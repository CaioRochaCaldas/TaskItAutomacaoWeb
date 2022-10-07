package br.com.taskit;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {


    protected WebDriver navegador;

    public BasePage(WebDriver navegador){
        //O Page Factory
        PageFactory.initElements(navegador, this);
        this.navegador = navegador;
    }


}
