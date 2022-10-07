package br.com.taskit.pages;

import br.com.taskit.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    //identificador do html antigo é substituido pelo page factory
   // private By localizadorDoBotaoSignUp = By.id("tests");

    //Page Factory que subistitui a forma de cima
    @FindBy(id = "sigup")
    private WebElement botaoSignUp;




    //implementamos o construtor da super classe com os valores comuns de todas
    public HomePage(WebDriver navegador) {
        super(navegador);
    }


    //entra na home page e retorna ela como proximo passo pois é inicial
    public HomePage acessarPaginaHomedoTaskit(){

        navegador.get("http://www.juliodelima.com.br/taskit");

        return new HomePage(navegador);

        //depois de rodar o metodo eu fico na home
    }

    //clica no botão de criar conta
    public RegistroPage abrirPaginadeRegistro(){
    //quando clicar no botao vou para pagina de registro page

        //com page fatory
        botaoSignUp.click();
        //retornou o navegador nessa pagina, pois vai fazer login e validar a register page
        //Só retorna ela mesma se só ficar nela
        return new RegistroPage(navegador);

    }

}
