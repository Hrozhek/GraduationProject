package com.github.hrozhek.signistmlverificatorservice.storage;

import java.awt.image.BufferedImage;

public interface ModelStorage {

    String save(BufferedImage image);

    BufferedImage load(String path);
}
