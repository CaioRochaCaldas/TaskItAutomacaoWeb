package br.com.taskit.tests;

import br.com.taskit.pages.HomePage;
import br.com.taskit.pages.RegistroPage;
import br.com.taskit.pages.SecretaPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes automatizados da funcionalidade de login")
public class SignUpTests {

    private WebDriver navegador;
    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        navegador.manage().window().maximize();
    }

    @Test
    @DisplayName("Resgistrar um novo usuario com dados invalidos")
    public void testRegistrarUmNovoUsuarioComDadosValidos(){
        //Esse abaixo a gente usa que não tiver uma validação de uma string e tira esse também abaixo ( String saudacaoAtual = new HomePage(navegador))
        //new HomePage(navegador)

        String saudacaoAtual = new HomePage(navegador)
                .acessarPaginaHomedoTaskit()
                .abrirPaginadeRegistro()
                .registrarNovoUsuario("Caio","zwy@gmail.com","123456")
                        .pegarASaudacao();

        //OBS validações com o junity tal como abaixo devem ficar na classe de teste
        Assertions.assertEquals("Hi","Wilson Alves", saudacaoAtual);


    }

    @AfterEach
    public void tearDown(){
        navegador.quit();
    }

}
