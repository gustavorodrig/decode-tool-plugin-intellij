package com.github.gustavorodrig.decodetool;

public enum DecodeType {

    BASE64("Base64"), GZIP("GZip"), URL("URL");

    private String value;

    DecodeType(String value) {
        this.value = value;
    }

    public static DecodeType getByValue(String value){
        for (DecodeType decodeType : DecodeType.values()) {
            if(decodeType.value.equals(value)){
                return decodeType;
            }
        }
        return null;
    }
}
