@fus01 @fus
Feature: Admin kullanici olarak Insan Kaynaklari(HR) Sayfasindan Personel Bilgilerine Erismek Istiyorum

  Scenario: [TC_01 > FUS_01] Insan Kaynaklari Sayfasina Erisim
    Given Admin kullanici ana sayfaya gider
    And Gecerli giris bilgileriyle sisteme giris yapar
    When Admin kullanici "Human Resource" Linkine tiklar
    Then Admin Kullanici "Staff Directory" sayfasini goruntuler