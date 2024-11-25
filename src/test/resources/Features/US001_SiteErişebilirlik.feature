Feature: Bir kullanıcı olarak siteyi kullanabilmek icin web sitesine erisebilmeliyim
  @test
  Scenario: TC01 Belirlenmiş URL ile siteye erişebilmeliyim

    Given Kullanıcı "HLurl" sitesine gider
    When Kullanıcı bulunduğu URL ile belirlenmiş URL'yi doğrular
    Then Kullanıcı site başlığının "Heal Life Hospital & Research Center" olduğunu doğrular
    And Kullanıcı Heal Life sitesinin logosunu görebilmelidir
    When Kullanıcı browser kapatır