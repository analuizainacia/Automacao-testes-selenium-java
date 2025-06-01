package com.exemplo.exercicio02;S


import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificarTituloTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configurar caminho do ChromeDriver se necessário:
        // System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void verificarTituloGoogle() {
        driver.get("https://www.google.com");

        String tituloEsperado = "Google";
        String tituloAtual = driver.getTitle();

        assertEquals(tituloEsperado, tituloAtual, "O título da página deve ser 'Google'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
