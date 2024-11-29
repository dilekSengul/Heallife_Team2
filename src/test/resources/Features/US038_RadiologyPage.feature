Feature: Admin oloarak Radilogy servisine ait daitlati yonetilbilmek icin gerekli sayfalarin olmasini isityorum
@levent38
  Scenario: TC_001 Kullanici Radiology sayfasina erisebilirlik testi

    Given Kullanıcı Heal Life sitesine giris yapar
    Then Kulllanci Username bax icine admin adini giris yapar
    And  Kullanici password bolumune admin password girsi yapar
    And  Kullanici Signin Buttonu tiklar
    And  Kullanici admin sayfasinda oldugunu dogrular
    And  Kullanici side navigation yer alan Radiology tab'ine tiklar
    And  Kullanici Radiology sayfasinin acildigini dogrular
    And  Kullanici sayfayi kapatir

