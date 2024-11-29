Feature:Kullanici Contact Us sayfasini ziyaret ettiginde gerekli elementlerin goruntulendigini dogrulamalidir.

  @levent4
  Scenario:TC_001 Kullanici Contact Us sayfasini basariyla ziyaret eder

    Given Kullanici anasayfaya gider
    When Kullanici contact_us linkine tiklar
    Then Kullanici contact_us sayfasina acildigini dogrular
    And  Kullanici sayfayi kapatir
