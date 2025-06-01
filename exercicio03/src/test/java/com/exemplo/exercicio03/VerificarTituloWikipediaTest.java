package com.exemplo.exercicio03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerificarTituloWikipediaTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Se necessário, defina o caminho do ChromeDriver aqui:
        // System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void verificarTituloWikipedia() {
        driver.get("https://www.wikipedia.org");

        String tituloEsperado = "Wikipedia";
        String tituloAtual = driver.getTitle();

        assertEquals(tituloEsperado, tituloAtual, "O título da página deve ser 'Wikipedia'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
