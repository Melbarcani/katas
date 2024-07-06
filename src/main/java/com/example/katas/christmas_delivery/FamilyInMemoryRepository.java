package com.example.katas.christmas_delivery;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FamilyInMemoryRepository {

    private final String resourcePath;
    public FamilyInMemoryRepository(String resourcePath){
        this.resourcePath = resourcePath;
    }

    private String line;

    public List<FamilyDelivery> getNonDeliveredFamilies() {
        var url = getFileUrl();
        List<FamilyDelivery> familyDeliveries = new ArrayList<>();
        try (var linesStream = Files.lines(Path.of(Objects.requireNonNull(url.toURI(), "Uri cannot be null")))) {
            var lines = linesStream.toList();
            lines.forEach(line -> {
                var splitLine = line.split(",".trim());
                familyDeliveries.add(retrieveFamily(splitLine));
            });
            return familyDeliveries.stream().filter(f -> f.isDelivered()).toList();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("cannot read families delivery file : %s".formatted(url));
        }
    }

    public URL getFileUrl() {
        ClassLoader loader = FamilyInMemoryRepository.class.getClassLoader();
        return loader.getResource(resourcePath);
    }

    private static FamilyDelivery retrieveFamily(String[] splitLine) {
        return new FamilyDelivery(
                splitLine[0],
                Arrays.stream(splitLine)
                        .toList()
                        .subList(1, splitLine.length - 1)
                        .stream().toList(),
                Boolean.parseBoolean(splitLine[splitLine.length - 1].trim())
        );
    }

    public void familyDelivered(FamilyDelivery family) {
        var url = getFileUrl();
        try {
            var path = Paths.get(Objects.requireNonNull(url).toURI());
            var lines = Files.readAllLines(path);
            for (int i = 0; i < lines.size(); i++) {
                line = lines.get(i);
                if (line.contains(family.familyName())) {
                    var splitLine = line.split(",");
                    if (splitLine[splitLine.length - 1].trim().equals("false")) {
                        splitLine[splitLine.length - 1] = " true";
                        lines.set(i, Arrays.stream(splitLine).collect(Collectors.joining(",")));
                    }
                }
            }
            Files.write(path, lines);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException("Error while writing in file");
        }
    }
}
