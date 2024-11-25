Feature: Radiology Test Reports Page

Scenario: Kullanıcı(hasta) https://heallifehospital.com adresine username ve password ile giris yapabilmelidir.

  Given kullanici URL'i acar
  And kullanıcı "{string}" ve "{string}" ile giriş yapar


Scenario: Radyoloji menüusunun Radyology Test Reports List sayfasina yonlendirdigi doğrulanmalidir.
  When Kullanici (hasta) "Radyoloji" menu secenegine tiklar
  Then "Radiolagy Test Reports List" sayfasinşn goruntulendigini dogrular

  Scenario: Radyology Test Reports List sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given hasta Radyology Test Reports List sayfasına gider
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
    Given hasta Radyology Test Reports Listesi sayfasina gider
    When hasta bir arama terimi girer
    Then sonuclarin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular

  Scenario: Radyology Test Reports sayfasında siralama fonksiyonelligi dogrulanmalidir
    Given hasta Radyology Test Reports sayfasina gider
    When hasta bir baslık uzerine tiklar
    Then liste artan sirada siralanmalidir
    When hasta aynı başlık uzerine tekrar tiklar
    Then listenin azalan sirada siralandigini dogrular

  Scenario: Islem sutunundaki islemlerin mevcut oldugunun dogrulanmasi testi
    Given Radyology Test Reports sayfasına gider
    Then "View Payments" baglantisinin her rapor icin mevcut oldugunu dogrular
    When hasta "View Payments" baglantısına tıklar
    Then bir modal pencere ödeme detaylarıyla acilir
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