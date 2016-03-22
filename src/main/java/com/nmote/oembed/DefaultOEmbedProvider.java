/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Standar oEmbed provider. Uses autodiscovery and providers.json as found on
 * http://oembed.com
 *
 * @author vnesek
 */
public class DefaultOEmbedProvider extends AbstractOEmbedProvider {

    /**
     * Sample main program. Resolve URLs passed on command line.
     *
     * @param args
     *            oEmbed URLs to test
     * @throws IOException
     *             if
     */
    public static void main(String[] args) throws IOException {
        // "https://www.youtube.com/watch?v=V_Qo4a_3IeQ"
        OEmbedProvider ep = new DefaultOEmbedProvider();
        for (String arg : args) {
            System.out.println("Fetching " + arg);
            OEmbed e = ep.resolve(arg);
            System.out.println(e);
            System.out.println();
        }
    }

    private static boolean matchGlob(String text, String glob) {
        String rest = null;
        int pos = glob.indexOf('*');
        if (pos != -1) {
            rest = glob.substring(pos + 1);
            glob = glob.substring(0, pos);
        }

        if (glob.length() > text.length()) {
            return false;
        }

        // Handle the part up to the first *
        for (int i = 0; i < glob.length(); i++) {
            char a = glob.charAt(i);
            char b = text.charAt(i);
            if (a != b && a != '?') {
                return false;
            }
        }

        // Recurse for the part after the first *, if any
        if (rest == null) {
            return glob.length() == text.length();
        } else {
            for (int i = glob.length(); i <= text.length(); i++) {
                if (matchGlob(text.substring(i), rest)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Makes an instance using default HTTP client and Jackson ObjectMapper.
     *
     * @throws IOException
     *             if providers.json can't be loaded
     */
    public DefaultOEmbedProvider() throws IOException {
        super();
        loadProviders();
    }

    /**
     * Makes an instance using supplied httpClient and mapper
     *
     * @param httpClient
     *            OkHTTP client
     * @param mapper
     *            Jackson ObjectMapper instance
     * @throws IOException
     *             if providers.json can't be loaded
     */
    public DefaultOEmbedProvider(OkHttpClient httpClient, ObjectMapper mapper) throws IOException {
        super(httpClient, mapper);
        loadProviders();
    }

    /**
     * @see com.nmote.oembed.AbstractOEmbedProvider#getProviderEndpointFor(java.lang.String)
     */
    @Override
    public ProviderEndpoint getProviderEndpointFor(String url) {
        for (ProviderInfo p : providers) {
            for (ProviderEndpoint e : p.getEndpoints()) {
                if (endpointSupports(e, url)) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * List all predefined providers (providers.json) metadata.
     *
     * @return list of predefined providers
     */
    public List<ProviderInfo> getProviders() {
        return providers;
    }

    /**
     * Find a provider metadata by name.
     *
     * @param name
     *            provider name
     * @return provider info instance or null if not found
     */
    public ProviderInfo getProviderByName(String name) {
        for (ProviderInfo pi : providers) {
            if (pi.getProviderName().equals(name)) {
                return pi;
            }
        }
        return null;
    }

    /**
     * @see com.nmote.oembed.AbstractOEmbedProvider#resolve(java.lang.String,
     *      java.lang.Integer[])
     */
    @Override
    public OEmbed resolve(String url, Integer... maxSize) throws IOException {
        // Find a provider for a passed URL
        ProviderEndpoint p = getProviderEndpointFor(url);
        OEmbed result;
        if (p != null) {
            result = super.resolve(url, p, maxSize);
        } else {
            result = discover(url, maxSize);
        }

        // Check for a favicon in a root of domain
        if (result instanceof BasicOEmbed) {
            BasicOEmbed boe = (BasicOEmbed) result;
            if (boe.getFaviconUrl() == null) {
                String faviconUrl = new URL(new URL(url), "/favicon.ico").toExternalForm();
                if (checkFaviconUrl(faviconUrl)) {
                    boe.setFaviconUrl(faviconUrl);
                }
            }
            // String favSrc = "https://getfavicon.appspot.com/" +
            // pathSegmentEscaper.escape(href)
            // + "?defaulticon=bluepng";
        }

        return result;
    }

    protected boolean endpointSupports(ProviderEndpoint provider, String url) {
        if (provider.getSchemes() != null) {
            for (String scheme : provider.getSchemes()) {
                if (matchGlob(url, scheme)) {
                    return true;
                }
            }
        }
        return false;
    }

    private BasicOEmbed discover(final String url, final Integer... maxSize) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = httpClient.newCall(request).execute();
        if (response.isSuccessful()) {
            String finalUrl = url;
            BasicOEmbed result = new BasicOEmbed();
            result.setUrl(finalUrl);
            MediaType contentType = response.body().contentType();
            extractPingbackUrl(result, response);
            extractWebmentionUrl(result, response);

            if (contentType.subtype().equals("json")) {
                try (InputStream in = response.body().byteStream()) {
                    result = mapper.readValue(in, BasicOEmbed.class);
                }
            } else if (contentType.type().equals("image")) {
                result = photo(result, response, maxSize);
            } else if (contentType.subtype().equals("html")) {
                result = document(result, response, maxSize);
            } else {
                // Unknown mime type
                result.setType(OEmbed.Type.LINK);
            }

            return result;
        } else {
            throw new IOException(
                    String.format("HTTP %d/%s while getting %s", response.code(), response.message(), url));
        }
    }

    private boolean checkFaviconUrl(final String url) {
        Request request = new Request.Builder().url(url).head().build();
        boolean result = false;
        try {
            Response response = httpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                MediaType contentType = response.body().contentType();
                result = "image".equals(contentType.type());
            }
        } catch (IOException ioe) {
        }
        return result;
    }

    private BasicOEmbed document(BasicOEmbed result, Response response, Integer... maxSize) throws IOException {
        Charset charset = response.body().contentType().charset();
        Document doc;
        try (InputStream in = response.body().byteStream()) {
            doc = Jsoup.parse(in, charset != null ? charset.toString() : "UTF-8", result.getUrl());
        }

        result.setType(OEmbed.Type.LINK);
        result.setTitle(doc.title());

        // Process meta
        for (Element meta : doc.head().getElementsByTag("meta")) {
            String content = meta.attr("content");
            switch (meta.attr("name").toLowerCase()) {
            case "description":
            case "twitter:description":
            case "og:description":
                result.setDescription(content);
                break;
            case "author":
                result.setAuthorName(content);
                break;
            }
        }

        // Process links
        for (Element link : doc.head().getElementsByTag("link")) {
            String rel = link.attr("rel");
            if (rel == null) {
                continue;
            }
            String type = link.attr("type");
            String href = link.absUrl("href");

            if ((result.getFaviconUrl() == null && ("icon".equals(rel) || "shortcut icon".equals(rel))) //
                    || rel.startsWith("apple-touch-icon")) {
                // Found a favorite icon
                if (checkFaviconUrl(href)) {
                    result.setFaviconUrl(href);
                }
            } else if ("application/json+oembed".equals(type)) {
                // Found an oEmbed link

                // Apply maxSize
                if (maxSize != null) {
                    if (maxSize.length > 0 && maxSize[0] != null) {
                        href += "&maxwidth=" + maxSize[0];
                    }
                    if (maxSize.length > 1 && maxSize[1] != null) {
                        href += "&maxheight=" + maxSize[1];
                    }
                }

                BasicOEmbed result2 = super.get(href, BasicOEmbed.class);

                // Copy properties extracted from original result
                result2.setWebmentionUrl(result.getWebmentionUrl());
                result2.setPingbackUrl(result.getPingbackUrl());
                result2.setFaviconUrl(result.getFaviconUrl());

                result = result2;
            } else if ("canonical".equals(rel)) {
                result.setUrl(href);
            } else if (result.getPingbackUrl() == null && "pingback".equals(rel)) {
                // Found a pingback link
                result.setPingbackUrl(href);
            } else if (result.getWebmentionUrl() == null && "webmention".equals(rel)) {
                // Found webmention link
                result.setWebmentionUrl(href);
            }
        }

        if (result.getWebmentionUrl() == null) {
            // Find a webmention in anchors
            Element anchor = doc.body().select("a[rel=webmention][href]").first();
            if (anchor != null) {
                result.setWebmentionUrl(anchor.absUrl("href"));
            }
        }

        return result;
    }

    private void extractPingbackUrl(BasicOEmbed embed, Response response) {
        String h = response.header("X-Pingback");
        if (h != null) {
            embed.setPingbackUrl(h);
        }
    }

    private void extractWebmentionUrl(BasicOEmbed result, Response response) {
        for (String h : response.headers("Link")) {
            try {
                Link link = Link.parse(h);
                if (link.hasRel("webmention")) {
                    result.setWebmentionUrl(link.getUri());
                    break;
                }
            } catch (Exception ignored) {
                System.err.println("Failed to parse Link header: " + h);
            }
        }
    }

    private void loadProviders() throws IOException {
        // Load providers
        try (InputStream in = getClass().getResourceAsStream("providers.json")) {
            this.providers = mapper.readValue(in,
                    mapper.getTypeFactory().constructCollectionType(List.class, ProviderInfo.class));
        }

        // Map extensions
        try (InputStream in = getClass().getResourceAsStream("extensions.json")) {
            Map<String, String> exts = mapper.readValue(in,
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, String.class));
            for (Map.Entry<String, String> e : exts.entrySet()) {
                ProviderInfo pi = getProviderByName(e.getKey());
                if (pi != null) {
                    for (ProviderEndpoint pe : pi.getEndpoints()) {
                        try {
                            pe.setEmbedClass(e.getValue());
                        } catch (ClassNotFoundException cnfe) {
                            System.err.println("Missing extension class " + e.getValue() + ": " + cnfe);
                        }
                    }
                } else {
                    System.err.println("Missing provider '" + e.getKey() + "' for extension " + e.getValue());
                }
            }
        }
    }

    private BasicOEmbed photo(BasicOEmbed result, Response response, Integer... maxSize) throws IOException {
        result.setType(OEmbed.Type.PHOTO);
        SimpleImageInfo info = new SimpleImageInfo(response.peekBody(4096).bytes());
        result.setWidth(info.getWidth());
        result.setHeight(info.getHeight());
        return result;
    }

    private List<ProviderInfo> providers;
}
