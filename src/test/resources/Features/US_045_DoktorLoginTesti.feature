Feature: Doktor olarak hastane sisteminde  hastalarima ait islemleri yurutebilecegim panele erisebilmek istiyorum.


  Scenario: TC01 İlgili Url tıklanınca login sayfasinin acilip test edilmesi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then Login sayfasinin sag tarafinda Admin Login penceresi görüntülenmeli
    Then Login sayfasinin sol tarafinda Latest New penceresi görüntülenmeli

  @test
  Scenario: TC02 Doğru bilgiler ile panele giriş testi
    Given Kullanıcı Heal Life sitesine giriş yapar
    Then username bolumune dogru email girilir
    Then password bolumune dogru password girilir
    Then sign in butonuna tiklanir
    And heal life logosu görüntülenir





