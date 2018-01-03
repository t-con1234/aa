package com.sahabt.test;

import com.sahabt.base.BaseTest;
import com.sahabt.page.HomePage;
import org.junit.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchTest(){
        HomePage hPage = new HomePage(driver);
        hPage.search();
    }
}
