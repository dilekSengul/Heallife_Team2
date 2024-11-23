Feature: About Us Dropdown Menu Testi
  Kullanıcı "About Us" dropdown menusunu doğrular.

  Scenario: About Us dropdown ve About Hospitals sayfa testi
    Given Kullanıcı projectUrl adresini ziyaret eder
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And sayfayı kapatır

  Scenario: Kullanıcı "About Us" menüsünden "About Hospitals" başlığına gider ve ilgili başlıkları doğrular
    Given Kullanıcı projectUrl adresini ziyaret eder
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    Then Some Words About Us başlığının sayfada göründüğünü doğrulayın
    And Our Mission başlığının sayfada göründüğünü doğrulayın
    And Opening Hours bilgisinin sayfada göründüğünü doğrulayın
    And Our Specialist başlığının sayfada göründüğünü doğrulayın
    And Heidi Prather'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın
    And Alexander M. Simotas'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın
    And Jesse N. Charnoff'ın resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın
    And George Cyril'in resmi, İsim ve Unvan'ının Our Specialist başlığı altında olduğunu doğrulayın
    And sayfayı kapatır

  Scenario: Kullanıcı Meet Our Doctors sayfasını doğrular
    Given Kullanıcı projectUrl adresini ziyaret eder
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı doktorların uzmanlık alanlarına göre gruplandığı menüyü görür
    And Menüde aşağıdaki uzmanlık alanları olmalıdır:
      | General Practitioner |
      | Ophthalmologist      |
      | Paediatrician        |
      | Cardiologist         |
      | Gynaecologist        |
      | Neurologist          |
    And Kullanıcı General Practitioner uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür
    And Kullanıcı Ophthalmologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür
    And Kullanıcı Paediatrician uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür
    And Kullanıcı Cardiologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür
    And Kullanıcı Gynaecologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür
    And Kullanıcı Neurologist uzmanlık alanına tıkladığında doktor isimlerini, unvanlarını ve resimlerini görür    And sayfayı kapatır
    And sayfayı kapatır

  @hurrem



