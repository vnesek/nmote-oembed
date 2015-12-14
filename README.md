nmote-oembed
=====================================

Java 1.7 client for oEmbed protocol.

oEmbed is a format for allowing an embedded representation of a URL on third party sites. The simple API allows a website to display embedded content (such as photos or videos) when a user posts a link to that resource, without having to parse the resource directly.

See http://oembed.com

Features
--------

* Autodiscovery for any website supporting oEmbed
* Out-of-box support for YouTube, Viddler, Flickr, IFTTT, ...
* Support for vendor extensions
* Support for embedly and noembed oEmbed proxy services
* Favicon, pingback and webmention extraction
* BSD style license

Usage
-----

Get oEmbed info from YouTube URL:

```java
		OEmbedProvider ep = new DefaultOEmbedProvider();
		OEmbed e = ep.resolve("https://www.youtube.com/watch?v=V_Qo4a_3IeQ");
		System.out.println(e);
```

produces:
```
BasicOEmbed(
	"height":344,
	"html":"<iframe width=\"459\" height=\"344\" src=\"https://www.youtube.com/embed/V_Qo4a_3IeQ?feature=oembed\" frameborder=\"0\" allowfullscreen></iframe>",
	"title":"LEGO train crash high speed Eurostar and ICE 3 on 9V double track",
	"type":"video",
	"version":"1.0",
	"width":459,
	"author_name":"LEGO9vtrainfan",
	"author_url":"https://www.youtube.com/user/LEGO9vtrainfan",
	"favicon_url":"https://s.ytimg.com/yts/img/favicon-vflz7uhzw.ico",
	"provider_name":"YouTube",
	"provider_url":"https://www.youtube.com/",
	"thumbnail_height":360,
	"thumbnail_url":"https://i.ytimg.com/vi/V_Qo4a_3IeQ/hqdefault.jpg",
	"thumbnail_width":480
)
```

Add to Your's Project
---------------------

If you use maven for dependency management, add following snippet to pom.xml:

```xml
	<dependencies>
		...

		<dependency>
			<groupId>com.nmote.oembed</groupId>
			<artifactId>nmote-oembed</artifactId>
			<version>0.7</version>
		</dependency>

	</dependencies>
```

Building
--------
To produce nmote-oembed.jar you will need apache maven installed. Run:

> mvn clean package



Author Contact and Support
--------------------------

For further information please contact
Vjekoslav Nesek (vnesek@nmote.com)
