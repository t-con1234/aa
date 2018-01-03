package com.sahabt.page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(){
        navigate("http://www.sahibinden.com");
        //sendKeys(By.xpath(".//*[@id='searchText']"),"Ford Mustang");
        //clickElement(By.cssSelector("button[value='Ara']"));
    }
}
