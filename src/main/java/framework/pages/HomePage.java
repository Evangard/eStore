package framework.pages;

public class HomePage extends BasePage {

    @Override
    public void openPage() {
        driver.get(BASE_PAGE + "/");
        waitUntilLoaded();
    }
}
