package com.nmote.oembed;

import java.io.IOException;

public interface OEmbedProvider {

	OEmbed resolve(String url, Integer... maxSize) throws IOException;
}
