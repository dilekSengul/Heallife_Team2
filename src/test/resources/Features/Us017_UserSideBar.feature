Feature: sidebar ulaşım

  Scenario: TC01Sidebara katılıp menulerın gorundugunu test etmek
    Given kullanici URL'i acar
    And Kullanıcı email adresini girer
    And Gecerli password girer
    And Appointment secenegine tikladiginda Appointment sayfasina yonlendigini dogrular
    And Pharmacy sayfasinin duzgun bir sekilde goruntulendigini dogrular
    And kullanici sol menuden Radiology secenegine tiklar
    And kullanici sol menuden Pathology secenegine tiklar
    When kullanici sol menuden Ambulance secenegine tiklar

