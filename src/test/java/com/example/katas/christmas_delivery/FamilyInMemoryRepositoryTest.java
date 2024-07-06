package com.example.katas.christmas_delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

class FamilyInMemoryRepositoryTest {

    private FamilyInMemoryRepository familyRepository;
    private Path testFilePath;


    @BeforeEach
    void setup() {
        Properties properties = new Properties();
        try (var inputSystem = getClass().getClassLoader().getResourceAsStream("application-test.properties")) {
            properties.load(inputSystem);
            var resourcePath = properties.getProperty("resourcePath");
            familyRepository = new FamilyInMemoryRepository(resourcePath);
            URL url = familyRepository.getFileUrl();
            testFilePath = Paths.get(url.getPath());
            List<String> initialLines = List.of(
                    "Simpson, toy1, toy2, toy8, true",
                    "Jackson, toy7, toy3, false",
                    "Uchiwa, toy5, toy6, toy4, toy9, true"
            );
            Files.write(testFilePath, initialLines);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    @Test
    void shouldReturnFamilyList() {
        var deliveriesFamily = familyRepository.getNonDeliveredFamilies();
        assertThat(deliveriesFamily).hasSize(2);
        assertThat(deliveriesFamily.get(0).familyName()).isEqualTo("Simpson");
        assertThat(deliveriesFamily.get(1).familyName()).isEqualTo("Uchiwa");
    }

    @Test
    void shouldSetToTrue() {
        familyRepository.familyDelivered(
                new FamilyDelivery("Jackson", Collections.emptyList(), false));
        var deliveriesFamily = familyRepository.getNonDeliveredFamilies();
        try {
            List<String> lines = Files.readAllLines(testFilePath);
            assertThat(lines).containsExactly(
                    "Simpson, toy1, toy2, toy8, true",
                    "Jackson, toy7, toy3, true",
                    "Uchiwa, toy5, toy6, toy4, toy9, true"
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}