package com.github.gustavorodrig.decodetool.util;

import java.util.Base64;

public class DecodeUtil {

    public static String decodeBase64(String text){
        return new String(Base64.getDecoder().decode(text));
    }
}
