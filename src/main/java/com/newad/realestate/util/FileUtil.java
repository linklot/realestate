package com.newad.realestate.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtil {
    
    public static void createFile(String real_path, byte[] data) throws IOException {
        Path file = Paths.get(real_path);
        Files.write(file, data, StandardOpenOption.CREATE);
    }
    
    public static byte[] readFile(String real_path) throws IOException {
        Path file = Paths.get(real_path);
        return Files.readAllBytes(file);
    }

}
