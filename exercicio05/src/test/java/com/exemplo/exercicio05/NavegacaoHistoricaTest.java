package com.exemplo.exercicio05;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavegacaoHistoricaTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Se precisar, defina o caminho do chromedriver:
        // System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testNavegacaoHistorica() {
        // Passo 1: abrir Google
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle(), "Título deve ser 'Google'");

        // Passo 2: navegar para página 'Sobre o Google'
        driver.get("https://about.google/");
        assertEquals("Google – About Google, Our Culture & Company News", driver.getTitle(), "Título da página 'Sobre o Google' esperado");

        // Passo 3: voltar para Google
        driver.navigate().back();
        assertEquals("Google", driver.getTitle(), "Deve voltar para 'Google'");

        // Passo 4: avançar para 'Sobre o Google'
        driver.navigate().forward();
        assertEquals("Google – About Google, Our Culture & Company News", driver.getTitle(), "Deve avançar para 'Sobre o Google'");

        // Passo 5: atualizar a página
        driver.navigate().refresh();
        assertEquals("Google – About Google, Our Culture & Company News", driver.getTitle(), "Após refresh o título deve continuar o mesmo");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
