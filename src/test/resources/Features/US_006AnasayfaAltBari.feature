Feature: US006 Kullanici ana sayfa doktorlar seçeneğini görür bilgilerini gorur

    @testanlik @1
    Scenario: TC01 "Our Doctors" başlığı altındaki doktorlar doğru şekilde listeleniyor
      Given Url "HLurl" girer
    And Kullanıcı ana sayfaya yönlendirilir
    When Kullanıcı sayfada "Our Doctors" başlığını görür
    And Doktor isimlerini kontrol eder
      And Kullanıcı ünvalnarı kontrol eder
      And Sayfayi Kapatir
