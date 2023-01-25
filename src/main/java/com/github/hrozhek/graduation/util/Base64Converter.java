package com.github.hrozhek.graduation.util;

import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Base64Converter {

    @SneakyThrows
    public static BufferedImage convertImage(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        return ImageIO.read(new ByteArrayInputStream(decodedBytes));
    }

    private Base64Converter() {
    }

}
