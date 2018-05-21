package com.github.gustavorodrig.decodetool.service.decode;

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;

public class DecodeGzip implements Decode {

    @Override
    public String decode(String text) throws IOException {
        byte[] decode = Base64.getUrlDecoder().decode(text);
        try (InputStream inStream = new GZIPInputStream(new ByteArrayInputStream(decode)); ByteArrayOutputStream outStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, len);
            }
            return outStream.toString("UTF-8");
        }
    }
}
