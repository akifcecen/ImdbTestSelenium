package Pages;

import Base.BasePage;
import Base.BaseTest;
import Interfaces.Elements;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Page extends BasePage implements Elements {
    String aramaTxt = "The Jazz Singer";
    public Logger LOGGER = LogManager.getLogger(Page.class);
    protected WebDriver driver = BaseTest.driver;
    private WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
    private WebElement director;
    private WebElement writer;
    private WebElement stars;
    private String url="";
    HttpURLConnection huc = null;
    int respCode = 200;
    List<WebElement> cast;

    public void checkMovie(){

        waitForElementAndClick(menuButton);
        LOGGER.info("Arama çubuğunun sol tarafında bulunan Menü butonuna basılır");

        waitForElementAndClick(oscars);
        LOGGER.info("Gelen ekranda “Award & Events” başlığı altında bulunan “Oscars” butonuna tıklanır");


        waitClickableOfElementLocatedBy(By.xpath("//*[@id=\"right-5-react\"]/div/div[2]/div[16]/span[4]"));
        waitForElementAndClick(date);
        LOGGER.info("“Event History” başlığı altında “1929” değeri seçilir");

        driver.findElements(theJazzSinger.getBy());
        LOGGER.info("Sayfanın sonuna inildi");

        waitForElementAndClick(theJazzSinger);
        LOGGER.info("The Jazz Singer Seçilir");
        if (isElementExist(credit.getBy())){
        waitForElementAndClick(credit);}
        else {
            waitForElementAndClick(getTheJazzSingerAlternateResult);
        }

        LOGGER.info("Full credit sayfası açıldı");
        cast = driver.findElements(By.tagName("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div"));
        LOGGER.info("Director, Writer ve Stars değerleri kaydedildi.");

    }

    public void checkTheMovieFromSearch(){
        waitForElementAndClick(homeButton);
        LOGGER.info("Ekranın sol üstünde bulunan “IMDb” butonuna tıklanarak “Anasayfa’ya” dönülür.");
        waitForElementAndSendKeys(searchBox,aramaTxt);
        LOGGER.info("Arama çubuğuna"+aramaTxt+" yazılır");
        driver.findElement(By.xpath("//*[@id=\"suggestion-search\"]")).sendKeys(Keys.ENTER);
        LOGGER.info("Enter tuşuna basılı arama yapılır");


        waitForElementAndClick(resultsTheJSinger);
        LOGGER.info("Sonuçlar arasında gelen 'The Jazz Singer' tıklanır");
        if (isElementExist(creditSnd.getBy())){
            waitForElementAndClick(creditSnd);}
        else {
            waitForElementAndClick(getTheJazzSingerAlternateResult);
        }

        LOGGER.info("Full Credit sayfası açılır");
        List<WebElement> links = driver.findElements(By.tagName("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div"));
        Iterator<WebElement> it = links.iterator();
        Iterator<WebElement> itcast = cast.iterator();

        while (it.hasNext() && itcast.hasNext() ){

            if (it.next()==itcast.next())
            {
                continue;
            }
            else
            {
                LOGGER.info("Cast eşit değil");
                break;
            }

        }
        LOGGER.info("Director, Writer, Stars Bilgileri aynı.");

    }

    public void photoCheck() {

        driver.findElement(backToMovie.getBy()).click();
        LOGGER.info("Film bilgileri sayfasına geri dönüldü");

        if(isElementExist(seeAllPhoto.getBy()))
        waitForElementAndClick(seeAllPhoto);
        else waitForElementAndClick(seeAllPhotoSnd);
        LOGGER.info("See All photos linkine tıklandı.");
        int count=0;
        LOGGER.info("Fotoğraf linkleri kontrol ediliyor...");
        List<WebElement> links = driver.findElements(By.xpath("//*[@class='media_index_thumb_list']/a"));
        Iterator<WebElement> it = links.iterator();
        while (it.hasNext()) {

            url = it.next().getAttribute("href");
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    LOGGER.info(url + "  Linki çalışmıyor");
                    count++;

                } else {
                    //LOGGER.info(url + "  Linki çalışıyor");

                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        LOGGER.info(" Toplam Link sayısı : "+ links.size() + " Çalışmayan link sayısı :"+count);
        if(count>0)LOGGER.info("Çalışmayan link var..");
        else LOGGER.info("Fotoğraf linklerinde kırık yok..");

    }

}
