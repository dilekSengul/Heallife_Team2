Feature: Radiology Test Reports Page

  Background: Kullanici sisteme giris yapar.
  Given kullanici URL'i acar
  And kullanıcı "{string}" ve "{string}" ile giriş yapar
  When Sign In butonuna tıklanır
  Then dashboard duzgun bir şekilde goruntuler


Scenario: Radyoloji menusunun Radiology Test Reports List sayfasina yonlendirdigi doğrulanmalidir.
  When kullanici sol menuden Radiology secenegine tiklar
  Then "Radiolagy Test Reports List" sayfasinin goruntulendigini dogrular

  Scenario: Radyology Test Reports List ,sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given kullanici sol menuden Radiology secenegine tiklar
    When hasta Radyology Test Reports List sayfasına gider
    Then asagidaki baslıklarin gorunur oldugunu dogrular
      | Bill No          |
      | Case ID          |
      | Reporting Date   |
      | Reference Doctor |
      | Note             |
      | Amount ($)       |
      | Paid Amount ($)  |
      | Balance Amount ($) |
      | Action           |

  Scenario: Radyology Test Reports Listesinde arama kutusunun duzgun calistigi dogrulanmalidir
    When kullanici sol menuden Radiology secenegine tiklar
    Then hasta bir arama terimi girer
    And sonuclarin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular

  Scenario: Radyology Test Reports sayfasında siralama fonksiyonelligi dogrulanmalidir
    Given kullanici sol menuden Radiology secenegine tiklar
    Then hasta Radyology Test Reports sayfasina gider
    When hasta bir baslık uzerine tiklar
    Then liste artan sirada siralanmalidir
    When hasta aynı başlık uzerine tekrar tiklar
    Then listenin azalan sirada siralandigini dogrular

  Scenario: Islem sutunundaki islemlerin mevcut oldugunun dogrulanmasi testi
    When kullanici sol menuden Radiology secenegine tiklar
    Then hasta "View Payments" baglantısına tıklar
    When bir modal pencere ödeme detaylarıyla acilir
    And modal penceresinin "Pay" butonunu icerdigini dogrular
    When hasta "Pay" butonuna tiklar
    Then sistem ödeme islemini yapmali ve rapor durumu guncellenmeli veya onay mesaji göstermelidir
    Then "View Reports" baglantisi her rapor için mevcut olmalidir
    When hasta "View Reports" bağlantısına tiklar
    Then bir modal pencere rapor detaylarıyla açılmalidir
    And  modal pencere "Print" butonunu icermelidir

    When hasta "Print" butonuna tiklar
    Then yazdırma penceresinin acıldigi dogrulanir

    Then "Pay" baglantısı her rapor için mevcut olmalidir
    When hasta "Pay" baglantısına tiklar
    Then bir modal pencere acilir
    And  modal pencerenin "Add" butonunu icerdigi dogrulanir

    When hasta modal pencereyi kapatmak için "X" butonuna tiklar
    Then modal pencere kapanir ve kullanici Radiology Test List sayfasina geri dondugu dogrulanir.