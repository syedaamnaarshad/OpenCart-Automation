package org.store.pageObject;

import org.openqa.selenium.WebDriver;
import org.store.base.BaseClass;


public class BasePage {
        protected WebDriver driver;

        //Constructor
        public BasePage() {
            this.driver = BaseClass.getDriver();
        }
}
