@fus03 @fus
Feature: Admin kullanici olarak admin panelinde personel ekleme islemlerini yapabilmek istiyorum.

  Background:
    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider

  Scenario: [TC01 > FUS03] Add Staff Sayfasina Erisilebilmesi
    When Kullanici Add Staff butonuna tiklar
    Then Kullanici Basic Information basligi altinda Add Staff Ekranina erisir

  Scenario: [TC02 > FUS03] Staff Kaydi Yapilabilmesi
    When Kullanici Add Staff butonuna tiklar
    And Kullanici kayit formunu doldurur islemi kaydeder
    When Staff Directory Sayfasina gider
    Then Kullanici kaydedilen personelin listede goruntuler

  Scenario: [TC03 > FUS03] Add Staff Sayfasindan Import Staff Sayfasina Erisilebilmesi
    When Kullanici Add Staff butonuna tiklar
    And Kullanici Import Staff butonuna tiklar
    Then Kullanici Import Staff ekranini goruntuler



