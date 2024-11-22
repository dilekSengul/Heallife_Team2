@US02

Feature: Homepage Top Bar Functionality

  @TC01
  Scenario: Verify visibility of elements in the top bar
    Given kullanici ana sayfayi acar
    Then "Latest News" bilgisinin ust barda kayan bir yazi olarak gorunur oldugunu dogrular
    And sitenin logosunun ust barda gorundugunu dogrular
    And ust barda asagidaki menu ogelerinin gorundugunu dogrular:
      | Home        |
      | Appointment |
      | Events      |
      | About Us    |
      | Gallery     |
      | Contact Us  |

  Scenario: Verify site logo functionality
    Given kullanici ana sayfayi acar
    When kullanici site logosuna tiklar
    Then ana sayfanin yenilendigini ve URL’nin degismedigini dogrular

  Scenario: Verify menu navigation functionality
    Given kullanici ana sayfayi acar
    When kullanici ust bardaki menu ogelerine tek tek tiklar
    Then "Home" secenegine tikladiginda ana sayfaya yonlendigini dogrular
    And "Appointment" secenegine tikladiginda Appointment sayfasina yonlendigini dogrular
    And "Events" secenegine tikladiginda Events sayfasina yonlendigini dogrular
    And "About Us" secenegine tikladiginda About Us sayfasina yonlendigini dogrular
    And "Gallery" secenegine tikladiginda Gallery sayfasina yonlendigini dogrular
    And "Contact Us" secenegine tikladiginda Contact Us sayfasina yonlendigini dogrular
