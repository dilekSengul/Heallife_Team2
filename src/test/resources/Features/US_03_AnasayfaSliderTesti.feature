#Bu feature Ugur Yaman tarafindan 25.11.2024 tarihinde "Ana Sayfa Slider'inin Calismasini Test Etmek Icin" olusturulmustur.

  @us03
Feature: Ana sayfada slider'in dogru calistigini dogrulama
         Ana sayfada kullanicinin hastaneye ait gorselleri goruntuledigi ve bu gorsellerin periyodik olarak degistigini kontrol etmek

  Background:
    Given Kullanici websitesi URL'ini kullanarak ana sayfaya gider

  Scenario: [TC_001 > US_03] Ana sayfa kaydırıcısında görsellerin görüntülenmesi ve otomatik değişimi
    When Kullanıcı ana sayfadaki slider'i göruntuler
    And Kullanici ana sayfada slider'da otomatik olarak degisen resimleri goruntuler

  Scenario: [TC_002 > US_04] Ana sayfa slider'inde gecis ikonu kullanilarak gorseller arasinda gecis yapilmasi
    When Kullanici ana sayfada slider gecis ikonuna tiklar
    And Kullanici bu ikona tiklayarak tum gorselleri manuel olarak degistigini gozlemler


