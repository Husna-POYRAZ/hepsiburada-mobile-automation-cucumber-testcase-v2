package FavoriteProduct.tests;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;

public class FavoriteProduct {
    private AndroidDriver driver;
    public WebDriverWait wait;

    String folderName;
    DateFormat df;

    private final By closedAdvert = By.id("com.pozitron.hepsiburada:id/com_braze_inappmessage_modal_close_button");
    private final By superPrice = By.id("com.pozitron.hepsiburada:id/all");
    private final By productImage = By.xpath("(//android.widget.ImageView[@content-desc=\"ürün fotoğrafı\"])[1]");

    private final By product = By.id("com.pozitron.hepsiburada:id/productImage");

    private final By closedBtn = By.id("com.pozitron.hepsiburada:id/leftIcon");

    private final By addFavourites = By.id("com.pozitron.hepsiburada:id/product_detail_favourites");

    private final By emailArea = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    //By.id("txtUserName");

    private final By loginBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button");
    private final By passwordArea = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText");
    private final By passwordLoginBtn = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    //By.id("btnEmailSelect");

    private final By saveNoPassword = By.id("android:id/autofill_save_no");
    private final By message = By.id("android:id/button1");

    public String email = "hbtesting1@mailinator.com";
    public String password = "Hbtesting123.";

    private final By backButton = By.xpath("//android.widget.ImageView[@content-desc='Geri']");
    private final By userMenuButton = By.id("com.pozitron.hepsiburada:id/iv_toolbar_user_account_menu");
    private final By favouritesTab = By.xpath("//android.view.ViewGroup[@content-desc=\"account_menu_5\"]/android.widget.TextView");

    public void captureScreenshots() throws IOException {
        folderName = "screenshot";
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        df = new SimpleDateFormat("dd-MM-yyyy__hh_mm_ssaa");
        new File(folderName).mkdir();
        String fileName = df.format(new Date())+ ".png";
        FileUtils.copyFile(f,new File(folderName+ "/" + fileName));
    }

    public void scroll(int fromX, int fromY, int toX, int toY){
        TouchAction swipe = new TouchAction(driver)
                .press(PointOption.point(fromX,fromY))
                .waitAction(waitOptions(ofMillis(800)))
                .moveTo(PointOption.point(toX,toY))
                .release()
                .perform();
    }



    public void swipeUp(){
        TouchAction action =new TouchAction(driver);
        Dimension size	=driver.manage().window().getSize();
        int width=size.width;
        int height=size.height;
        int middleOfX=width * 1/2;
        int startYCoordinate= (int)(height*2/3); //ortalaam 1890
        int endYCoordinate= (int)(height*1/4); //ortalama 600
        System.out.println("Width:" + width);
        System.out.println("Height:" + height);
        System.out.println("MiddleOfX:" + middleOfX);
        System.out.println("Start Y Coordinate:" + startYCoordinate);
        System.out.println("End Y Coordinate:" + endYCoordinate);
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }

    @Given("Uygulama acilir")
    public void uygulamaAcilir() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:platformVersion", "11 RP1A.200720.011");
        desiredCapabilities.setCapability("appium:deviceName", "Redmi Note 8 Pro");
        desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appium:udid", "wos4w4rojfbugqs4");
        desiredCapabilities.setCapability("appium:app", "C:\\Users\\Dell\\Documents\\MOBVEN\\apk\\Hepsiburada_ Online Alışveriş_5.4.0_apkcombo.com.apk");
        desiredCapabilities.setCapability("appium:noReset", false);
        desiredCapabilities.setCapability("appium:fullReset", true);
        desiredCapabilities.setCapability("appium:autoGrantPermissions", true);


        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        wait = new WebDriverWait(driver,60);
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.SECONDS);
    }

    @When("Popup ekranindaki Devam Tamamla ve Reklam kapatma butonlarina sira sira tiklanir")
    public void popupEkranindakiDevamTamamlaVeReklamKapatmaButonlarinaSiraSiraTiklanir() throws InterruptedException {
        Thread.sleep(25000);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(547,93)).perform();
        swipeUp();
        //scroll(923, 1455,942, 1451);
        //scroll(930, 665, 884, 669);
        //Thread.sleep(15000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(closedAdvert)).click();
    }

    @And("Super Fiyat Super Teklif tiklanir")
    public void superFiyatSuperTeklifTiklanir(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(superPrice)).click();
    }

    @And("Super Fiyat Super Teklif sayfasindan bir urune gidilir")
    public void superFiyatSuperTeklifSayfasindanBirUruneGidilir(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productImage)).click();
    }

    @And("Urun detayda urunun gorseline tiklanir ve yana dogru scroll edilir")
    public void UrunDetaydaUrununGorselineTiklanirVeYanaDogruScrollEdilir(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(product)).click();
        scroll(814, 1143,231, 1139);
    }

    @And("Gorsel ekrani kapatilir")
    public void gorselEkraniKapatilir(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(closedBtn)).click();
    }

    @And("Urun detaydan favori butonuna basilir")
    public void urunDetaydanFavoriButonunaBasilir(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addFavourites)).click();
    }

    @And("Acilan login sayfasindan login olunur")
    public void acilanLoginSayfasindanLoginOlunur(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(emailArea)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailArea)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(passwordArea)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordArea)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLoginBtn)).click();
    }

    @And("Login olundugu kontrol edilir")
    public void loginOlunduguKontrolEdilir(){
        /*
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(saveNoPassword)).click();
        }catch (Exception e){}
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(message)).click();

    }
    @Then("Begendiklerim sayfasina gidilip urunun begendiklerime eklendigi gorulur")
    public void begendiklerimSayfasinaGidilipUrununBegendiklerimeEklendigiGorulur() throws InterruptedException, IOException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(userMenuButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(favouritesTab)).click();
        captureScreenshots();
        Thread.sleep(5000);
    }
}
