@US02

Feature: Anasayfa Header Testleri

  @TC01
  Scenario: Header'daki elementlerin gorunurlugunu dogrulama
    Given Kullanıcı "HLurl" sitesine gider
    Then Latest News bilgisinin ust barda kayan bir yazi olarak gorunur oldugunu dogrular
    And sitenin logosunun ust barda gorundugunu dogrular
    And ust barda asagidaki menu ogelerinin gorundugunu dogrular:
      | Home        |
      | Appointment |
      | Events      |
      | About Us    |
      | Gallery     |
      | Contact Us  |

  Scenario: Website logosunun islev testi
    Given Kullanıcı "HLurl" sitesine gider
    When kullanici site logosuna tiklar
    Then ana sayfanin yenilendigini ve URL’nin degismedigini dogrular

  Scenario: Menu navigasyon islev testi
    Given Kullanıcı "HLurl" sitesine gider
    Then Home secenegine tikladiginda ana sayfaya yonlendigini dogrular
    And Appointment secenegine tikladiginda Appointment sayfasina yonlendigini dogrular
    And About Us secenegine tikladiginda About Us sayfasina yonlendigini dogrular
    And Gallery secenegine tikladiginda Gallery sayfasina yonlendigini dogrular
    And Contact Us secenegine tikladiginda Contact Us sayfasina yonlendigini dogrular
