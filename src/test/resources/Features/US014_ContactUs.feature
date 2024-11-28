Feature: Contact Us sayfasına erişim

  Scenario: Contact us sayfasına erişim

    Given Kullanici anasayfaya gider
    When Kullanici contact_us linkine tiklar
    Then Kullanici contact_us sayfasina acildigini dogrular
    And  Kullanici sayfayi kapatir


    Scenario: TC02 kuallanıcı contact as sayfasında box doldurur.
      Given Kullanici anasayfaya gider
      When Kullanici contact_us linkine tiklar
      And Kullanıcı ismini girer
      And Kullanıcı email adresini girer
      And Kullanıcı subject alanını doldurur
      And Kullanıcı description alanına mesaj yazar
      Then Kullanıcı formu gönderir
      Then Kulanici dogrulama mesajını görür

      Scenario: TC03Map görünümü test et
        Given Kullanici anasayfaya gider
        When Kullanici contact_us linkine tiklar
        When drop down sayfa asagı iner
        And haritanin görundugununu onaylar

