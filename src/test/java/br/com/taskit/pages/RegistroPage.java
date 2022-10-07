package br.com.taskit.pages;

import br.com.taskit.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistroPage extends BasePage {


    @FindBy(id = "name-sign-up")
    private WebElement campoNome;
    @FindBy(id = "login-sign-up")
    private WebElement campoLogin;
    @FindBy(id = "password-sign-up")
    private WebElement campoSenha;
    @FindBy(id = "btn-submit-sign-up")
    private WebElement botaoSalvar;

    public RegistroPage(WebDriver navegador) {
        super(navegador);
    }

    //quando temos varias funcionalidades agregadas os colocamos em uma função ou funcionalidades que possuem dados variados no caso aqui é o proprio User
    //retorna ela mesma
    public SecretaPage registrarNovoUsuario(String nome,String login,String senha){

        campoNome.sendKeys(nome);
        campoLogin.sendKeys(login);
        campoSenha.sendKeys(senha);
        botaoSalvar.click();

        //retornou o navegador nessa pagina, pois vai fazer login e validar a secreta page
        return new SecretaPage(navegador);

    }

}
