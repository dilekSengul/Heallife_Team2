Feature: About Us Dropdown Menü Testi

  Kullanıcı "About Us" dropdown menüsü ve "About Hospitals" sayfasını doğrular.

  @hurrem
  Scenario: About Us dropdown ve About Hospitals sayfa testi
    Given Kullanıcı projectUrl adresini ziyaret eder
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And sayfayı kapatır