package com.github.gustavorodrig.decodetool.service.decode;

import java.util.Base64;

public class DecodeBase64 implements Decode {

    @Override
    public String decode(String text) {
        return new String(Base64.getDecoder().decode(text));
    }

}
