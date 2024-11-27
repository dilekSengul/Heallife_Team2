Feature: Doktor dashboard sidebar messaging bölümüü testi
  Background: Doktor sisteme giriş yapar
    Given Doktor geçerli url ile giriş yapar
    And Gecerli User Name girer
    When Gecerli password girer
    When Sign In butonuna tıklar
    Then heal life logosu görüntülenir

  Scenario: OPD linkine tıklanması ve list başlıklarının görüntülenmesi testi
    Given doktor sidebar da OPD linkine tiklanir
    When OPD Patient list başlıklari goruntulenmelidir
      | Name            |
      | Patient ID      |
      | Guardian Name   |
      | Gender          |
      | Phone           |
      | Consultant      |
      | Last Visit      |
      | Total Recheckup |