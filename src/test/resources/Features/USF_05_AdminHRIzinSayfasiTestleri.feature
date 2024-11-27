@fus05 @fus
Feature: Admin kullanici olarak admin panelinde izin taleplerini yonetebilmek istiyorum.

  Background:
    Given Admin kullanici giris bilgileri ile sisteme login olur
    And Staff Directory Sayfasina gider

  Scenario: [TC_01 > FUS_05] My Leaves Sayfasindan Approve Leave Request'e Erisilebilmesi
    When Kullanici Leaves butonuna tiklar
    And Kullanici Approve Leave Request butonuna tiklar
    When Kullanici Action basligi altinda Viewe tiklar
    Then Kullanici Details ekraninin goruntulendigini dogrular

  Scenario: [TC_02 > FUS_05] Approve Leave Request List sayfasindan Add Leave Request penceresine erisilmesi
    When Kullanici Leaves butonuna tiklar
    And Kullanici Approve Leave Request butonuna tiklar
    And Kullanici Add Leave Request butonuna tiklar
    Then Kullanici Add Details ekranina erisir
    When Kullanici Add Details ekraninda formu doldurur
    Then Kullanici kaydedilen izni Approve Leave Request ekraninda goruntuleyebildigini dogrular