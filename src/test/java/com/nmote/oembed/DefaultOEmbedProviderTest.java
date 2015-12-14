package com.nmote.oembed;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DefaultOEmbedProviderTest {

	@Test
	public void youTube() throws IOException{
		String url = "https://www.youtube.com/watch?v=V_Qo4a_3IeQ";
		// "https://www.youtube.com/watch?v=iqne45DkvPw&list=PLXzGdGVvDa-IOYQLPITomGSCEaXSl4-tQ";
		// "http://stackoverflow.com/questions/5119041/how-can-i-get-a-web-sites-favicon?foo=bar";
		// "http://arstechnica.com/gadgets/2014/11/thanksgiving-dealmaster-save-100-an-ipad-air-2-while-supplies-last/?comments=1";
		OEmbedProvider ep = new DefaultOEmbedProvider();
		BasicOEmbed e = (BasicOEmbed) ep.resolve(url);
		assertEquals("LEGO train crash high speed Eurostar and ICE 3 on 9V double track", e.getTitle());
		assertEquals("video", e.getType());
		assertEquals("https://s.ytimg.com/yts/img/favicon-vflz7uhzw.ico", e.getFaviconUrl());
	}

}
