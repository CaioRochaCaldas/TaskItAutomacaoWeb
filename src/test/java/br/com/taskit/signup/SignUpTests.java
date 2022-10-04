package br.com.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade de login")
public class SignUpTests {

    @Test
    @DisplayName("Resgistrar um novo usuario com dados invalidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        navegador.manage().window().maximize();
        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.findElement(By.id("signup")).click();
        navegador.findElement(By.id("name-sign-up")).sendKeys("Adriana");
        navegador.findElement(By.id("login-sign-up")).sendKeys("adriana0000000001");
        navegador.findElement(By.id("password-sign-up")).sendKeys("123456");
        navegador.findElement(By.id("btn-submit-sign-up")).click();

        //verifica se o valor da saldação é igual ao do usuario ao registrar
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Adriana", saudacaoAtual);
    }
    @Test
    @DisplayName("Fazer login na aplicação com um dado valor")
    public void testLogarComUmUsuarioregistrado(){
        WebDriverManager.chromedriver().setup();
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.juliodelima.com.br/taskit");
        navegador.findElement(By.linkText("Sign in")).click();
        navegador.findElement(By.id("login-sign-in")).sendKeys("adriana0000000001");
        navegador.findElement(By.id("password-sign-in")).sendKeys("123456");
        navegador.findElement(By.id("btn-submit-sign-in")).click();

        navegador.quit();

        
    }
}
