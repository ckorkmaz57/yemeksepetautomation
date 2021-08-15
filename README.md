

## YemekSepeti Test Otomasyon Çalışması

Testler cucumber kullanılarak BDD yaklaşımı ile yazıldı. Test senaryoları ilgili feature dosyalarının altında bulunmaktadır. Sayfalar Page object model kullanılarak birbirinden ayrıldı. Ayrıca Page Factory ile nesnelerin tutulması sağlandı. Otomasyon projesi için Maven kullanıldı. Raporlama için extent reports kullanıldı. Çalışması için gerekli olan bağımlılıkları pom.xml dosyasında bulunmaktadır. Firefox ve Chrome webdriver'ları /webdriver klasörü altında bulunmakta.Son yapılan testin raporu /test-output altında bulunmaktadır.


Bulunan bug : 
- Kullanıcı adı/e-posta space(boşluk) karakteri girilip, giriş yapılmaya çalışıldığında verilen uyarı mesajı boş çıkmaktadır. Ekran görüntüsü rapor içersinde bulunmaktadır.
- Favorilerden çıkarma işlemi tutarlı davranmamaktadır. Silme işleminden sonra silinen restaurant sayfada görünmeye devam edebiliyor.

Kullanılan java versiyonu : 

* Java : JDK11

Projede kullanılan framework'ler : 

* Selenium : 3.141.59
* Cucumber : 6.11.0
* Extend Reports : 5.0.4
* maven : 3.8.2

# Testlerin Çalıştırılması

Testler paralel olarak feature dosyalarında bulunan senaryoları koşmaktadır. Paralel koşum için hangi browser'dan başlatılmak isteniyorsa commandline'da o parametrenin verilmesi gerekmektedir.

Testleri farklı tarayıcılar(crossbrowser) kullanarak başlatmak için : 

* Chrome (`mvn test "-Dbrowsername=Chrome"`)
* Firefox (`mvn test "-Dbrowsername=Firefox"`)

Not : Parametre verilmediği durumda testler chrome'dan koşulmaktadır.(`mvn test`)
