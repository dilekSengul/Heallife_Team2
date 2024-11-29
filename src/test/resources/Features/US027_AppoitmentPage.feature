Feature: Bir kullanici olarak kolayca randevu olusturabilmek icin ana sayfada appointment sayfasinin olmasini istiyorum

  @levent


  Scenario: TC_001 Kullanici randevu alma islemini basariyla gerceklestirir
    Given Kullanici anasayfaya gider
    When  Kullanici Appointment sekmesine tiklar
    Then  Kullanici Appointment sayfasinin acildigini dogrular
    And   Kullanici gerekli bilgileri (bolum, doktor, tarih, notlar) girer
    And   Kullanici zaman araligini ve saati secer
    And   Kullanici hasta bilgilerini (isim, email, cinsiyet, telefon) girer
    And  Kullanici Submit tusuna basar
    And  Kullanici Patient Portal yonlendirildigini dogrular
    And   Kullanici sayfayi kapatir

  @levent2
  Scenario: TC_002 Kullanici yanlis veya eksik bilgilerle randevu alamaz

    Given Kullanici anasayfaya gider
    Then  Kullanici Appointment sekmesine tiklar
    Then  Kullanici Appointment sayfasinin acildigini dogrular
    And   Kullanici gerekli bilgileri (bolum, doktor, tarih, notlar) girer
    And   Kullanici zaman araligini ve saati secer
    And   Kullanici hasta bilgilerini (isim, email, cinsiyet, gecersiztelefon) girer
    And   Kullanici Submit tusuna basar
    And   Kullaniciya eksik veya hatali bilgi icin Lutfen tum alanlari doldurun seklinde bir hata mesaji gosterilir.
    And   Kullanici sayfayi kapatir


  @levent3
  Scenario:TC_003 Daha onceden olusturulan randevu icin tekrar randevu olusturma

    Given Kullanici anasayfaya gider
    When  Kullanici Appointment sekmesine tiklar
    Then  Kullanici Appointment sayfasinin acildigini dogrular
    And   Kullanici gerekli bilgileri (bolum, doktor, tarih, notlar) girer
    And   Kullanici zaman araligini ve saati secer
    And   Kullanici hasta bilgilerini (isim, email, cinsiyet, telefon) girer
    And   Kullanici Submit tusuna basar
    And   Kullanici randevu olusturmadigini dogrular
    And   Kullanici sayfayi kapatir



