package com.github.hrozhek.signistmlverificatorservice.storage;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileSystemModelStorageImpl implements ModelStorage {

    @Value("${user.path}")
    private String rootPath;

    @Override
    @SneakyThrows
    public String save(BufferedImage image) {
        String pathToSave = UUID.randomUUID() + ".png";
        String fullPath = rootPath + pathToSave;
        Path file = Paths.get(fullPath);
        if (Files.isRegularFile(file)) {
            throw new RuntimeException(String.format("file %s already exists", pathToSave));//todo 500
        }
        Files.createFile(file);
        ImageIO.write(image, "png", file.toFile());
        return pathToSave;
    }

    @Override
    @SneakyThrows
    public BufferedImage load(String path) {
        String fullPath = rootPath + path;
        Path file = Paths.get(fullPath);
        if (!Files.isRegularFile(file)) {
            throw new RuntimeException(String.format("file %s not found", path));//todo 500
        }
        return ImageIO.read(file.toFile());
    }
}
