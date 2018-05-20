package com.github.gustavorodrig.decodetool.service;

import com.github.gustavorodrig.decodetool.DecodeType;
import com.github.gustavorodrig.decodetool.service.decode.DecodeFactory;
import com.github.gustavorodrig.decodetool.service.decode.Decode;
import com.github.gustavorodrig.decodetool.util.SystemUtil;

public class DecodeService {

    public String decode(String text, DecodeType decodeType, Boolean copyToClipboard){

        try {

            Decode decode = DecodeFactory.getDecode(decodeType);
            String decodedText = new String(decode.decode(text).getBytes(), "UTF-8");

            if(copyToClipboard) {
                SystemUtil.copyToClipBoard(decodedText);
            }

            return decodedText;

        }catch (Exception e){
            return "DECODE ERROR: " + e.getMessage();
        }
    }
}
