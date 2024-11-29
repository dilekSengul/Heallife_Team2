Feature: Bir kullanici olarak hastane hakkinda daha cok bilgiye sahip olmak icin ana sayfada About Us menusunun olmasini istiyorum.


  @levent5
  Scenario: TC_001 AAbout Us dropdown seceneklerinin dogru sekilde goruntulenmesi dogrulanmalidir.

    Given Kullanici anasayfaya gider
    When Kullanici header bolumunde yer alan AboutUs tiklar
    Then Kullanici asagidaki seceklerin alt About menusunde oldugunu dogrular
      | About Hospitals   |
      | Meet Our Doctors  |
      | FAQ’s             |
      | Departments       |
      | Testimonials      |
    And Kullanici sayfayi kapatir


