package com.github.hrozhek.signistappsignaturist.util;

import com.google.protobuf.ByteString;

import java.util.Base64;

public class ByteUtils {

    public static ByteString convertImage(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return ByteString.copyFrom(decodedBytes);
    }

}
