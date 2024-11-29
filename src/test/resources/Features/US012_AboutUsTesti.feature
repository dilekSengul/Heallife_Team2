Feature: About Us Dropdown Menu Testi
  Kullanıcı "About Us" dropdown menusunu doğrular.

  Scenario: About Us dropdown ve About Hospitals sayfa testi
    Given Kullanıcı "HLurl" sitesine gider
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı About Hospitals başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Meet Our Doctors başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    When Kullanıcı browser kapatır

  Scenario: Kullanıcı "About Us" menüsünden "About Hospitals" başlığına gider ve ilgili başlıkları doğrular
    Given Kullanıcı "HLurl" sitesine gider
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
    When Kullanıcı browser kapatır

  Scenario: Kullanıcı Meet Our Doctors sayfasını doğrular
    Given Kullanıcı "HLurl" sitesine gider
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
    When Kullanıcı browser kapatır

  Scenario: Kullanıcı FAQ's sayfasını doğrular
    Given Kullanıcı "HLurl" sitesine gider
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı FAQ's başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Sayfada What Our Clients Say başlığının göründüğünü doğrulayın
    And Sayfada What Our Doctor Say başlığının göründüğünü doğrulayın
    And FAQ's sayfasinda 9 tane soru olduğunu doğrulayın
    And Her bir soru üzerine tıklayın ve altlarında cevabın göründüğünü doğrulayın
    When Kullanıcı browser kapatır

  Scenario: Kullanıcı Departments sayfasındaki başlıkları ve açıklama metinlerini doğrular
    Given Kullanıcı "HLurl" sitesine gider
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı Departments başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    And Sayfada aşağıdaki departmanların başlık ve açıklama metinlerinin yer aldığını doğrulayın:
      | Accident and Emergency (A&E)               |
      | Admissions                                 |
      | Anesthetics                                |
      | Breast Screening                           |
      | Burn Center (Burn Unit or Burns Unit)      |
      | Cardiology                                 |
      | Central Sterile Services Department         |
      | Chaplaincy                                 |
      | Coronary Care Unit (CCU)                   |
      | Critical Care                              |
      | Diagnostic Imaging                         |
      | Discharge Lounge                           |
    When Kullanıcı browser kapatır

  Scenario: Testimonials sayfasındaki kişilerin yorumlarını ve resimlerini doğrulama
    Given Kullanıcı "HLurl" sitesine gider
    When Ana sayfanın üst kısmında "About Us" menüsünün üzerine gelir
    And Kullanıcı Testimonials başlığına tıkladığında ilgili sayfaya yönlendirildiğini doğrular
    Then Sayfada aşağıdaki kişilerin yorumlarının, resimleri ile birlikte yer aldığını doğrulayın:
      | Robert   |
      | Ganesh   |
      | James    |
      | Norman   |
      | Jessica  |
      | Nyisha   |
    When Kullanıcı browser kapatır
