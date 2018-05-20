package com.github.gustavorodrig.decodetool.service.decode;

import com.github.gustavorodrig.decodetool.persistence.DecodeToolPersistance;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class DecodeUrl implements Decode {

    @Override
    public String decode(String text) throws IOException, URISyntaxException {

        CloseableHttpClient client = HttpClients.createDefault();

        String url = DecodeToolPersistance.getInstance().getUrl();

        HttpGet getRequest = new HttpGet(new URIBuilder(url).build().toString() + (url.endsWith("/") ? "" : "/") + text);
        CloseableHttpResponse response = client.execute(getRequest);
        String decodedText = EntityUtils.toString(response.getEntity());
        return decodedText;

    }
}
