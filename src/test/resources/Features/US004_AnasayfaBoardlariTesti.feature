Feature: US004_Bir kullanici olarak hastaneye ait bilgilere kolay erisim icin
         ana sayfada boardlarin olmasini istiyorum.

  Background:
    Given Browser aç ve HLurl adersine git
    When Sayfayı kaydır

  Scenario: TC01_Insurance Plans,Pediatric Services, Lab Testing board'larının görünür olması testi

  And Insurance Plans görünür olduğunu doğrula
  And Pediatric Services görünür olduğunu doğrula
  Then Lab Testing görünür olduğunu doğrula
  And Sayfayı kapat


  Scenario: TC02_Insurance Plans,Pediatric Services, Lab Testing board'ları altındaki read more butonunun
            ilgili sayfaya yönlendirmesi testi

    And Insurance Plans altında read more butonuna tıkla
    And Açılan sayfada Insurance Plans text'i görünür olduğunu doğrula
    Then Geri git
    And Pediatric Services altında read more butonuna tıkla
    Then Our Pediatric Services: text'i görünür olduğunu doğrula
    And Geri git
    Then Lab Texting altında read more butonuna tıkla
    And Lab Texting Services text'i görünür olduğunu doğrula
    And Sayfayı kapat









