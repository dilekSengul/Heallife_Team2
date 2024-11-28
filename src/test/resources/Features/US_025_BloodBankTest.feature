Feature: Blood Bank Test Reports Page

  Background: Kullanici sisteme giris yapar.
    Given kullanici URL'i acar
    And kullanıcı "{string}" ve "{string}" ile giriş yapar
    When Sign In butonuna tıklanır
    Then dashboard duzgun bir şekilde goruntuler


  Scenario: Blood Bank menusunun Blood Bank sayfasina yonlendirdigi doğrulanmalidir.
    When kullanici sol menuden Blood Bank secenegine tiklar
    Then "Blood Bank" sayfasinin goruntulendigini dogrular


 Scenario: Blood Bank sayfasında hasta profil bilgilerini doğrulanır
  Given kullanici sol menuden Blood Bank secenegine tiklar
   When hasta Blood Bank sayfasına gider
   Then asagidaki list baslıklarin gorunur oldugunu dogrular
     | Patient Id           |
     | Gender               |
     | Marital Status       |
     | Phone                |
     | Email                |
     | Address              |
     | Age                  |
     | Guardian Name        |




  Scenario: Blood Issue sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given kullanici sol menuden Blood Bank secenegine tiklar
    When hasta Blood Bank sayfasına gider
    Then asagidaki baslıklarin gorunur oldugunu dogrular
      | Bill No              |
      | Issue Date           |
      | Received To          |
      | Blood Group          |
      | Gender               |
      | Donor Name           |
      | Bags                 |
      | Amount ($)           |
      | Paid Amount ($)      |
      | Balance Amount ($)   |
      | Action               |


  Scenario:Blood Issue Listesinde arama kutusunun duzgun calistigi dogrulanmalidir
    When kullanici sol menuden Blood Bank secenegine tiklar
    Then hasta, Blood Issue icin bir arama terimi girer
    And Blood Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular


  Scenario: Blood Issue sayfasında siralama fonksiyonelligi dogrulanmalidir
    Given kullanici sol menuden Blood Bank secenegine tiklar
    Then hasta Blood Issue sayfasına gider
    When Blood Issue listesinde hasta bir baslık uzerine tiklar
    Then blood liste artan sirada siralanmalidir
    When hasta blood Id uzerine tekrar tiklar



  Scenario: Blood Bank menusunun Component Issue sayfasina yonlendirdigi doğrulanmalidir.
    When kullanici sol menuden Blood Bank secenegine tiklar
    And hasta Component Issue butonuna tıklar
    Then Component Issue sayfasinin goruntulendigini dogrular


  Scenario: Component Issue sayfasinda gerekli baslıkların goruntulendigi dogrulanmalidir
    Given kullanici sol menuden Blood Bank secenegine tiklar
    And hasta Component Issue butonuna tıklar
    Then asagidaki baslıklarin gorunur oldugunu dogrular
      | Bill No              |
      | Issue Date           |
      | Received To          |
      | Blood Group          |
      | Component            |
      | Gender               |
      | Donor Name           |
      | Bags                 |
      | Amount ($)           |
      | Paid Amount ($)      |
      | Balance Amount ($)   |
      | Action               |


  Scenario:Component Issue Listesinde arama kutusunun duzgun calistigi dogrulanmalidir
    When kullanici sol menuden Blood Bank secenegine tiklar
    And hasta Component Issue butonuna tıklar
    Then hasta, Compenent Issue icin bir arama terimi girer
    And  Component Issue elementinin girilen arama terimiyle eslesen sekilde goruntulendigini dogrular

  Scenario: Component Issue sayfasında siralama fonksiyonelligi dogrulanmalidir
    Given kullanici sol menuden Blood Bank secenegine tiklar
    And hasta Component Issue butonuna tıklar
    When Compenent Issue listesinde hasta bir baslık uzerine tiklar
    Then component liste artan sirada siralanmalidir
    When component listede hasta aynı başlık uzerine tekrar tiklar


