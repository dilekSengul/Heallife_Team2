#Bu feature Ugur Yaman tarafindan 25.11.2024 tarihinde "Ana Sayfa Slider'inin Calismasini Test Etmek Icin" olusturulmustur.


Feature: Ana sayfada slider'in dogru calistigini dogrulama
         Ana sayfada kullanicinin hastaneye ait gorselleri goruntuledigi ve bu gorsellerin periyodik olarak degistigini kontrol etmek

  Background:
    Given Kullanici websitesi URL'ini kullanarak ana sayfaya gider

  Scenario: [TC_001 > US_03] Ana sayfa kaydırıcısında görsellerin görüntülenmesi ve otomatik değişimi
    Then Kullanici ana sayfada slider'da otomatik olarak degisen resimleri goruntuler
@us03
  Scenario: [TC_002 > US_04] Ana sayfa slider'inde gecis ikonu kullanilarak gorseller arasinda gecis yapilmasi
    Then Kullanici bu ikona tiklayarak tum gorselleri manuel olarak degistigini gozlemler


