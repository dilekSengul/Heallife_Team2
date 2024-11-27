@fus02 @fus
Feature: Admin kullanici olarak admin panelinde sisteme kayitli tum calisanlarin bilgilerine erisebilmek istiyorum

  Background:
    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider

  Scenario: [TC_01 > FUS_02] Kullanici Kayitli Personelleri Card ve List View formatinda goruntuleyebilmesi
    When Kullanici List View butonuna tiklar
    Then Kullanici Staff ID, Name, Role, Department, Designation, Mobile Number ve Action basliklarini goruntuler
    And Kullanici Personelleri Liste halinde goruntuler
    When Kullanici Card View butonuna tiklar
    Then Kullanici Personelleri Card View halinde goruntuler


  Scenario: [TC_02 > FUS_02] List View'de Action basligi altinda personel bilgilerinin show ve edit yapilabilmesi
    When Kullanici List View butonuna tiklar
    When Kullanici "Action" altinda "Show" butonuna tiklar
    Then Ilgili personelin bilgilerinin yer aldigi sayfaya yonlendirilir
    And Staff Directory Sayfasina gider
      And Kullanici List View butonuna tiklar
    When Kullanici Action altinda Edit butonuna tiklar
    Then Ilgili personel bilgilerinin editlendigi sayfaya yonlendirilir

  Scenario: [TC_03 > FUS_02] Staff Directory Sayfasindan "Disabled Staff" sayfalara gecisin yapilabilmesi
    When Kullanici "Add Staff" butonuna ardindan da "Disabled Staff" butonuna tiklar
    Then Kullanici Disabled Staff ekranina erisir
    When Staff Directory Sayfasina gider
    And Kullanici "Staff Attendance" butonuna tiklar
    Then Kullanici Staff Attendance sayfasina erisir
    When Staff Directory Sayfasina gider
    And Kullanici "Payroll" linkine tiklar
    Then Kullanici "Payroll" Sayfasina goruntuler
