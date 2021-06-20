package Interfaces;

import Util.ElementInfo;
import org.openqa.selenium.By;

public interface Elements {

    public ElementInfo menuButton = new ElementInfo("Menü tuşuna tıklanılamadı", By.id("imdbHeader-navDrawerOpen--desktop"));
    public ElementInfo oscars = new ElementInfo("Oscars butonuna tıklanılamadı", By.xpath("//*[@id=\"imdbHeader\"]/div[2]/aside/div/div[2]/div/div[3]/span/div/div/ul/a[1]"));
    public ElementInfo date = new ElementInfo("Event Historyde tarih seçilemedi", By.xpath("//*[@id=\"right-5-react\"]/div/div[2]/div[16]/span[4]"));
    public ElementInfo theJazzSinger = new ElementInfo("The Jazz Singer Seçilemedi", By.xpath("//*[@id=\"center-3-react\"]/div/div/div[2]/h3/div/div/div/div[1]/div[2]/div[2]/div[1]"));
    public ElementInfo credit = new ElementInfo("Credit sayfası seçilemedi", By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[4]/a[4]"));
    public ElementInfo homeButton = new ElementInfo("Imdb anasayfasına gidilemedi", By.id("home_img_holder"));
    public ElementInfo searchBox = new ElementInfo("Arama yapılamadı", By.xpath("//*[@id=\"suggestion-search\"]"));
    public ElementInfo creditSnd = new ElementInfo("Credit sayfası seçilemedi", By.xpath("//*[@id=\"title-overview-widget\"]/div[2]/div[1]/div[4]/a[4]"));
    public ElementInfo resultsTheJSinger = new ElementInfo("Arama yapılamadı", By.xpath("//*[@id=\"main\"]/div/div[2]/table/tbody/tr[2]/td[2]/a"));
    public ElementInfo resultDirector = new ElementInfo("Sonuc kaydedilemedi", By.xpath("//*[@id=\"fullcredits_content\"]/table[1]"));
    public ElementInfo resultWriter = new ElementInfo("Sonuc kaydedilemedi", By.xpath("//*[@id=\"fullcredits_content\"]/table[2]"));
    public ElementInfo resultStars = new ElementInfo("Sonuc kaydedilemedi", By.xpath("//*[@id=\"fullcredits_content\"]/table[3]"));
    public ElementInfo seeAllPhoto =new ElementInfo("Fotoğraflar açılamadı",By.xpath("//*[@id=\"titleImageStrip\"]/div[2]/a[2]"));
    public ElementInfo backToMovie =new ElementInfo("Filme geri dönülemedi",By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div/div[1]/h3/a"));
    public ElementInfo getTheJazzSingerAlternateResult = new ElementInfo("Element tıklanmadı",By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[4]/ul/li[3]/a[2]"));
    public ElementInfo seeAllPhotoSnd = new ElementInfo("Element tıklanılamadı.",By.xpath("//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[3]/div[1]/a/h3/svg"));
}
