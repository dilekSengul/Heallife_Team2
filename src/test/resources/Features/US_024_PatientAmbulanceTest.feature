Feature: Ambulance Test Reports Page

  Background: Kullanici sisteme giris yapar.
    Given kullanici URL'i acar
    And kullanıcı "{string}" ve "{string}" ile giriş yapar
    When Sign In butonuna tıklanır
    Then dashboard duzgun bir şekilde goruntuler


  Scenario: Ambulance menusunun Ambulance Bill sayfasina yonlendirdigi doğrulanmalidir.
    When kullanici sol menuden Ambulance secenegine tiklar
    Then "Ambulance Bill" sayfasinin goruntulendigini dogrular

  Scenario: Ambulance Bill sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given kullanici sol menuden Ambulance secenegine tiklar
    When hasta Ambulance Bill sayfasına gider
    Then asagidaki baslıklarin gorunur oldugunu dogrular
      | Bill No              |
      | Vehicle Number       |
      | Vehicle Model        |
      | Driver Name          |
      | Driver Contact       |
      | Amount ($)           |
      | Tax (%)              |
      | Net Amount ($)       |
      | Paid Amount ($)      |
      | Balance Amount ($)   |
      | Action               |

  Scenario:Ambulance Bill Listesinde arama kutusunun duzgun calistigi dogrulanmalidir
    When kullanici sol menuden Ambulance secenegine tiklar
    Then hasta, ambulans icin bir arama terimi girer
    And ambulans elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular

  Scenario: Ambulance Bill sayfasında siralama fonksiyonelligi dogrulanmalidir
    Given kullanici sol menuden Ambulance secenegine tiklar
    Then hasta Ambulance Bill sayfasına gider
    When ambulans listesinde hasta bir baslık uzerine tiklar
    Then liste artan sirada siralanmalidir
    When hasta aynı başlık uzerine tekrar tiklar




  Scenario: Islem sutunundaki islemlerin mevcut oldugunun dogrulanmasi testi
    When kullanici sol menuden Ambulance secenegine tiklar
    Then hasta View Payments bağlantısına tiklar
    And modal penceresinin Print butonunu içerdiği doğrulanır

    When kullanıcı modal pencereyi kapatmak için X butonuna tiklar
    And hasta show baglantısına tıklar
    Then rapor detayları modal penceresi açılmalıdır

    When hasta modal pencereyi kapatmak için X butonuna tiklar
    And hasta pay bağlantısına tıklar

