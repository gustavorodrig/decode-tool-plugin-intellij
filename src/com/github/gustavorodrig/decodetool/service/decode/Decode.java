package com.github.gustavorodrig.decodetool.service.decode;

import java.io.IOException;
import java.net.URISyntaxException;

public interface Decode {

    String decode(String text) throws IOException, URISyntaxException;

}

