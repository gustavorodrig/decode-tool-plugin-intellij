package com.github.gustavorodrig.decodetool.service.decode;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class DecodeGzip implements Decode {

    @Override
    public String decode(String text) throws IOException {

            GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(text.getBytes()));
            BufferedReader bf = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
            String outStr = "";
            String line;
            while (( line  =bf.readLine())!=null) {
                outStr += line;
            }
            return outStr;
    }
}
