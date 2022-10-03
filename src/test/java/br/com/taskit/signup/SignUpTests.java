package br.com.taskit.signup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


@DisplayName("Testes automatizados da funcionalidade de login")
public class SignUpTests {
    private WebDriver navegador;
    //OBS: tudo que fica em roxo no codigo já referencia essa variavel navegador não precisa do this.navegado quanto estiver roxo,mas mesmo assim eu coloquei em todos
    @BeforeEach
    public void beforeEach(){
        WebDriverManager.chromedriver().setup();
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.get("http://www.juliodelima.com.br/taskit");
    }
    @Test
    @DisplayName("Resgistrar um novo usuario com dados invalidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(){

        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        this.navegador.findElement(By.id("signup")).click();
        this.navegador.findElement(By.id("name-sign-up")).sendKeys("Adriana");
        this.navegador.findElement(By.id("login-sign-up")).sendKeys("adriana0000000001");
        this.navegador.findElement(By.id("password-sign-up")).sendKeys("123456");
        this.navegador.findElement(By.id("btn-submit-sign-up")).click();

        //verifica se o valor da saldação é igual ao do usuario ao registrar
        String saudacaoAtual = navegador.findElement(By.className("me")).getText();
        Assertions.assertEquals("Hi, Adriana", saudacaoAtual);
    }
    @Test
    @DisplayName("Fazer login na aplicação com um dado valor")
    public void testLogarComUmUsuarioregistrado(){



        this.navegador.get("http://www.juliodelima.com.br/taskit");
        this.navegador.findElement(By.linkText("Sign in")).click();
        this.navegador.findElement(By.id("login-sign-in")).sendKeys("adriana0000000001");
        this.navegador.findElement(By.id("password-sign-in")).sendKeys("123456");
        this.navegador.findElement(By.id("btn-submit-sign-in")).click();

        this.navegador.quit();


    }
}
