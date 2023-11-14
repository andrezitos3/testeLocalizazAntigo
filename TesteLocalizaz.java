package com.mycompany.testelocalizaz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;

public class TesteLocalizaz {
    
    public static void timeout() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    public static void testeEstado(WebDriver driverParam) throws InterruptedException {
        // Encontrar o botão por ID < select > 
        WebElement botaoEstado = driverParam.findElement(By.id("estado_sb"));
        WebElement outputEstado = driverParam.findElement(By.id("ibge_estado_input"));
        // acho que não precisa desse .click, ele vai selecionando sozinho
        botaoEstado.click();
        // Criar um objeto Select passando o elemento <select> como parâmetro
        Select selectEstado = new Select(botaoEstado);
        // Ou selecionar uma opção pelo índice
         //selectEstado.selectByIndex(0);
         for (int i = 1; i < 28; i++){
             selectEstado.selectByIndex(i);
             // o comando outputEstado.getText() não ta pegando o texto do input codigo IBGE (ele ta imprimindo " ")
             String codigoIbgeEstado = outputEstado.getText();
             timeout();
         }
    }

            public static void testeMunicipio(WebDriver driverParam) throws InterruptedException {
            // Mapeando os botões de municipio e o espaço do código IBGE
            WebElement botaoMunicipio = driverParam.findElement(By.id("cidade_sb"));
            WebElement outputEstado = driverParam.findElement(By.id("ibge_cidade_input"));
            
            Select selectMunicipio = new Select(botaoMunicipio);
            
            int desconhecido = 0;
            for (int i = 1; i < desconhecido; i++){
                selectMunicipio.selectByIndex(i);
            }
        }
    
    public static void main(String[] args) throws InterruptedException {
        // Caminho para o ChromeDriver (coloque o caminho correto)
        String chromedriverpath = "C:\\Users\\andre\\AppData\\Local\\Programs\\ChromeDriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverpath );

        // Inicializa o WebDriver
        WebDriver driver = new ChromeDriver();

        // Abre o Google
        driver.get("https://artdsl.github.io/LocaliZAZ.js/");

        //WebDriverWait espera = new WebDriverWait(driver, tempoLimite);
        testeEstado(driver);
        timeout();
        
        // Encerra o navegador
        driver.quit();
    }
}
