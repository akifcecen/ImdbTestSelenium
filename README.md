# ImdbTestSelenium 

Bu proje Maven, JUnit, Log4j, Selenium kullanılarak hazırlanmıştır. 

#IMDb Senaryoları

Senaryo Adı: Menüden Bulunan Filmle Arama Çubuğu Üzerinden Bulunan Film Özellikleri Aynı Olmalıdır.

Açıklama: Menü üzerinden gidilerek film bulunur ve bu film arama çubuğundan arattırılır. Director, Writer, Stars bilgilerinin aynı olduğu doğrulanır.

Test Adımları:

· https://www.imdb.com/ adresine gidilir

· Arama çubuğunun sol tarafında bulunan Menü butonuna basılır

· Gelen ekranda “Award & Events” başlığı altında bulunan “Oscars” butonuna tıklanır

· “Event History” başlığı altında “1929” değeri seçilir

· “Honorary Award” başlığı altında “The Jazz Singer (Charles Chaplin)” seçilir
· Gelen ekranda, The Jazz Singer’a ait;

a. Director: bilgisi kayıt edilir.

b. Writer: bilgisi kayıt edilir.

c. Stars: bilgisi kayıt edilir.

· Ekranın sol üstünde bulunan “IMDb” butonuna tıklanarak “Anasayfa’ya” dönülür.

· Arama çubuğuna “The Jazz Singer” yazılır.

· Sonuçlar arasında gelen “The Jazz Singer’a” tıklanır.

· Gelen ekranda;

a. Director: bilgisi kayıt edilen directorle aynı mı kontrol edilir.

b. Writer: bilgisi kayıt edilen Writer’la aynı mı kontrol edilir.

c. Stars: bilgisi kayıt edilen Starts’la aynı mı kontrol edilir.

· Kontroller yapıldıktan sonra “See all .. photos” linkine tıklanır

· Gelen ekranda:

a. Bütün fotoğrafların linklerinin kırık olmadığını kontrol edilir.


Beklenen Sonuç (Expected result):

· Director: bilgisi değişmemeli

· Writer: bilgisi değişmemeli

· Stars: bilgisi değişmemeli.

· Filmle alakalı fotoğrafların linkleri kırık olmamalı.
