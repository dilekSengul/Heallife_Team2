Feature: Radiology Test Reports Page

  Background: Kullanici sisteme giris yapar.
  Given kullanici URL'i acar
  And kullanıcı "{string}" ve "{string}" ile giriş yapar
  When Sign In butonuna tıklanır
  Then dashboard duzgun bir şekilde goruntuler


Scenario: Radyoloji menusunun Radiology Test Reports List sayfasina yonlendirdigi doğrulanmalidir.
  When kullanici sol menuden Radiology secenegine tiklar
  Then "Radyology Test Reports List" sayfasinin goruntulendigini dogrular

  Scenario: Radyology Test Reports List ,sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given kullanici sol menuden Radiology secenegine tiklar
    When hasta Radyology Test Reports List sayfasına gider
    Then asagidaki baslıklarin gorunur oldugunu dogrular
      | Bill No                   |
      | Case ID / Patient ID      |
      | Reporting Date            |
      | Reference Doctor          |
      | Note                      |
      | Amount ($)                |
      | Paid Amount ($)           |
      | Balance Amount ($)        |
      | Action                    |

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




  Scenario: Islem sutunundaki islemlerin mevcut oldugunun dogrulanmasi testi
    When kullanici sol menuden Radiology secenegine tiklar
    Then hasta View Payments bağlantısına tiklar
    And modal penceresinin Print butonunu içerdiği doğrulanır

    When kullanıcı modal pencereyi kapatmak için X butonuna tiklar
    And hasta view reports bağlantısına tiklar
    Then rapor detayları modal penceresi açılmalıdır

    When hasta modal pencereyi kapatmak için X butonuna tiklar
    And hasta pay bağlantısına tıklar