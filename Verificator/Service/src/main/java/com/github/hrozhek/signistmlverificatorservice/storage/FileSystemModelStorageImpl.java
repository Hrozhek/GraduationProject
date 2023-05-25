package com.github.hrozhek.signistmlverificatorservice.storage;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
@Slf4j
public class FileSystemModelStorageImpl implements ModelStorage {

    @Value("${user.path}")
    private String rootPath;

    @Override
    @SneakyThrows
    public String save(BufferedImage image) {
        String pathToSave = UUID.randomUUID() + ".png";
        String fullPath = rootPath + File.separator + pathToSave;
        Path file = Paths.get(fullPath);
        if (Files.isRegularFile(file)) {
            String message = String.format("file %s already exists", pathToSave);
            log.error(message);
            throw new RuntimeException(message);//todo 500
        }
        Files.createFile(file);
        ImageIO.write(image, "png", file.toFile());
        return pathToSave;
    }

    @Override
    @SneakyThrows
    public BufferedImage load(String path) {
        String fullPath = rootPath + File.separator + path;
        Path file = Paths.get(fullPath);
        if (!Files.isRegularFile(file)) {
            String message = String.format("file %s not found", path);
            log.error(message);
            throw new RuntimeException(message);//todo 500
        }
        return ImageIO.read(file.toFile());
    }
}
