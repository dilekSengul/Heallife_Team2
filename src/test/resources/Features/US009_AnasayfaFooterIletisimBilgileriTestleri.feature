Feature: US009 Kullanici ana sayfa alt barinda iletisim bilgilerini gorur

  Scenario:TC01 Ana sayfa alt barında telefon, e-posta ve adres bilgilerini gormeli

    Given Url "HLurl" girer
    Then Anasayfa alt barinda Contact, Email ve Adress gorunurlugunu dogrular.
    And Sayfayi Kapatir

  Scenario: TC02 Kullanici alt bar Contact'a tikladiginda Contact Us sayfasian yonlendirilir
    Given Url "HLurl" girer
    When Anasayfa alt Barinda Contact'a tiklar
    Then Contact Us sayfasina yonlendirildigini dogrular
    And Sayfayi Kapatir

    Scenario: TC03 Ana sayfa alt bar Mail'in görünürlüğü ve ilevselliği
      Given Url "HLurl" girer
      When Anasayfa alt Barinda Mail'e tiklar
      Then Mail'e tiklanabildigini dogrular
      Then Contact Us sayfasina yonlendirildigini dogrular
      And Sayfayi Kapatir
  @kubra
  Scenario: TC04 Ana sayfa alt bar Address'in görünürlüğü ve islevselliği
    Given Url "HLurl" girer
    When Anasayfa alt Barinda Adress'e tiklar
    Then Yonlendirilen sayfada hatitanın goruntulendigini dogrular
    And Sayfayi Kapatir
