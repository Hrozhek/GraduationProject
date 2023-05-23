package com.github.hrozhek.signistmlverificatorservice.storage;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class FileSystemModelStorageImpl implements ModelStorage {

    @Override
    public String save(BufferedImage image) {
        return null;
    }

    @Override
    public BufferedImage load(String path) {
        return null;
    }
}
