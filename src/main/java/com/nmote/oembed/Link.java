/*
 * Copyright (c) Nmote Ltd. 2015. All rights reserved.
 * See LICENSE doc in a root of project folder for additional information.
 */

package com.nmote.oembed;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * RFC-5988 compliant Link parser.
 *
 * http://tools.ietf.org/html/rfc5988
 *
 * @author vnesek@nmote.com
 */

/**
 * @author vnesek
 *
 */
/**
 * @author vnesek
 *
 */
public class Link {

	public static class Parameter {

		public Parameter(String name, String value) {
			assert name != null;
			assert value != null;

			this.name = name.intern();
			this.value = value;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}

		@Override
		public String toString() {
			return name + "=\"" + value + '"';
		}

		private String name;
		private String value;
	}

	private static class LinkTokenizer {

		public LinkTokenizer(String in) {
			this.in = in;
			this.pos = 0;
			this.buffer = new StringBuilder(32);
		}

		public String readName() {
			if (pos >= in.length())
				return null;

			int end = pos + 1;
			do {
				char c = in.charAt(end);
				if (c == ';' || c == '=')
					break;
				++end;
			} while (end < in.length());

			String result = in.substring(pos, end).trim();
			pos = end;
			return result;
		}

		public String readURI() {
			int idx1 = in.indexOf('<', pos);
			if (idx1 == -1) {
				throw new IllegalStateException("expected '<': " + in.substring(pos));
			}
			int idx2 = in.indexOf('>', idx1 + 1);
			if (idx2 == -1) {
				throw new IllegalStateException("expected '>': " + in.substring(pos));
			}

			String result = in.substring(idx1 + 1, idx2);
			pos = idx2 + 1;
			skipToName();
			return result;
		}

		public String readValue() {
			if (pos >= in.length())
				return null;

			String result;

			char c = in.charAt(pos);
			if (c == ';') {
				++pos;
				result = null;
			} else if (c == '=') {
				++pos;
				c = in.charAt(pos);
				if (c == '"') {
					result = readQuoted();
				} else {
					result = readToken();
				}
			} else {
				throw new RuntimeException();
			}

			skipLWS();
			return result;
		}

		private String readQuoted() {
			buffer.setLength(0);
			++pos;
			while (pos < in.length()) {
				char c = in.charAt(pos++);
				if (c == '\\' && in.charAt(pos) == '"') {
					buffer.append('"');
					++pos;
				} else if (c == '"') {
					skipToName();
					break;
				} else {
					buffer.append(c);
				}
			}
			return buffer.toString();
		}

		private String readToken() {
			buffer.setLength(0);
			while (pos < in.length()) {
				char c = in.charAt(pos++);
				if (c == ';' || Character.isSpaceChar(c)) {
					skipLWS();
					break;
				} else {
					buffer.append(c);
				}
			}

			return buffer.toString();
		}

		private void skipLWS() {
			while (pos < in.length() && Character.isSpaceChar(in.charAt(pos))) {
				++pos;
			}
		}

		private void skipToName() {
			skipLWS();
			if (pos < in.length() && in.charAt(pos) == ';') {
				++pos;
				skipLWS();
			}
		}

		private StringBuilder buffer;
		private String in;
		private int pos;
	}

	public static void main(String[] args) {
		String[] links = { " <http://example.com/TheBook/chapter2>; rel=\"previous\"; title=\"previous chapter\"",
				"</>; rel=\"http://example.net/foo\"",
				"</TheBook/chapter2>;\n       rel=\"previous\"; title*=UTF-8'de'letztes%20Kapitel",
				"<http://example.org/>;\n             rel=\"start http://example.net/relation/other\"" };
		for (String a : links) {
			System.out.println(Link.parse(a));
		}
	}

	/**
	 * Parse HTTP Link header
	 *
	 * @param header
	 *            header data
	 * @return parsed Link instance
	 */
	public static Link parse(String header) {
		Link link = new Link(header);
		LinkTokenizer tok = new LinkTokenizer(header);
		link.uri = tok.readURI();
		link.params = new ArrayList<>();
		for (;;) {
			String name = tok.readName();
			if (name == null) {
				break;
			}
			String value = tok.readValue();
			link.params.add(new Parameter(name, value));
		}
		return link;
	}

	/**
	 * HTTP Link representation.
	 */
	public Link() {
	}

	/**
	 * Constructs Link instance from uri.
	 *
	 * @param uri
	 *            HTTP uri
	 */
	public Link(String uri) {
		Objects.requireNonNull(uri);

		this.uri = uri;
		this.params = new ArrayList<>();
	}

	/**
	 * Get first link parameter by name.
	 *
	 * @param name
	 *            parameter name
	 * @return parameter value or null if there is no such parameter
	 */
	public String get(String name) {
		for (Parameter p : params) {
			if (name.equals(p.getName())) {
				return p.getValue();
			}
		}
		return null;
	}

	/**
	 * Get's a list of all link parameters.
	 *
	 * @return all link parameters.
	 */
	public List<Parameter> getParameters() {
		return params;
	}

	/**
	 * Get 'rel' parameter.
	 *
	 * @return parameter value or null if there is no 'rel' parameter
	 */
	public String getRel() {
		return get("title");
	}

	/**
	 * Get 'title' parameter.
	 *
	 * @return parameter value or null if there is no 'title' parameter
	 */
	public String getTitle() {
		return get("title");
	}

	/**
	 * Get link's URI.
	 *
	 * @return link's URI
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Checks if there is specifi 'rel' type parameter.
	 *
	 * @param rel
	 *            'rel' type
	 * @return there if there is a 'rel' of given type
	 */
	public boolean hasRel(String rel) {
		String r = getRel();
		if (r == null) {
			return false;
		}
		StringTokenizer tok = new StringTokenizer(r);
		while (tok.hasMoreElements()) {
			if (tok.nextElement().equals(rel)) {
				return true;
			}
		}
		return false;
	}

	public Link rel(String rel) {
		remove("rel");
		params.add(0, new Parameter("rel", rel));
		return this;
	}

	public Link remove(String name) {
		Iterator<Parameter> i = params.iterator();
		while (i.hasNext()) {
			if (name.equals(i.next().getName())) {
				i.remove();
			}
		}
		return this;
	}

	public Link title(String title) {
		remove("rel");
		params.add(new Parameter("title", title));
		return this;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append('<').append(uri).append('>');
		Pattern needQuote = Pattern.compile("[\n\t:/ \"]");
		for (Parameter p : params) {
			b.append("; ").append(p.getName()).append('=');
			String v = p.getValue();
			if (needQuote.matcher(v).find()) {
				b.append('"');
				b.append(v.replace("\"", "\\\""));
				b.append('"');
			} else {
				b.append(v);
			}
		}
		return b.toString();
	}

	public Link uri(String uri) {
		this.uri = uri;
		return this;
	}

	private List<Parameter> params;

	private String uri;
}
