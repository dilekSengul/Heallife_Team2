Feature: Doktor dashboard sidebar messaging bölümüü testi
  Background: Doktor sisteme giriş yapar
    Given Doktor geçerli url ile giriş yapar
    And Gecerli User Name girer
    When Gecerli password girer
    When Sign In butonuna tıklar
    Then heal life logosu görüntülenir

    Scenario: TC01 Messaging linkine tiklanarak ilgili sayfaya yönlendirmesi testi
      Given dashboard sidebarda bulunan Messaging e tiklanir
      And messaging sayfasina gidildigi dogrulanir
      Then notice board goruntulenir
  @test
  Scenario: TC02 Post New Messaging linkine tıklanabilmesi ve gerekli alanların doldurulabilmesi testi
    Given dashboard sidebarda bulunan Messaging e tiklanir
    And post new message linkine tiklanir
    When title, message, notice date, publish on, message to doldurulur
    Then send tiklanir
    And mesajin geldigi dogrulanir
