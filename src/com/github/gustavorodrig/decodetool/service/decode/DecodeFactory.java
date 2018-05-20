package com.github.gustavorodrig.decodetool.service.decode;

import com.github.gustavorodrig.decodetool.DecodeType;

import java.util.HashMap;
import java.util.Map;

public class DecodeFactory {

    private static Map<DecodeType, Decode> decodes = new HashMap<>();

    static {
        decodes.put(DecodeType.BASE64, new DecodeBase64());
        decodes.put(DecodeType.GZIP, new DecodeGzip());
        decodes.put(DecodeType.URL, new DecodeUrl());
    }

    public static Decode getDecode(DecodeType decodeType){
        return decodes.get(decodeType);
    }
}
