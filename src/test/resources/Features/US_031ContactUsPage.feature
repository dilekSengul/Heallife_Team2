Feature:Kullanici Contact Us sayfasini ziyaret ettiginde gerekli elementlerin goruntulendigini dogrulamalidir.

  @levent4
  Scenario:TC_001 Kullanici Contact Us sayfasini basariyla ziyaret eder

    Given Kullanici anasayfaya gider
    When Kullanici contact_us linkine tiklar
    Then Kullanici contact_us sayfasina yonlendirilir
    And Kullanici Ad-Soyad textBox goruntelendigini dogrular
    And Kullanici E-posta textBox goruntelendigini dogrular
    And Kullanici Konu textBox goruntelendigini dogrular
    And Kullanici Mesaj textBox goruntelendigini dogrular
    And Kullanici Gonder butonu goruntelendigini dogrular
    And Kullanici Contact Us sayfasinin alt kisminda hastanenin lokasyonunu gosteren bir haritayi goruntuler
    And Kullanici sayfayi kapatir