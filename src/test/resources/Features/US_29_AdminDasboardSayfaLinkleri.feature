

Feature: Bir yönetici (admin) olarak Admin panelinde menulerin yer aldigi bir dashboard sidebar olmasini istiyorum.


  Scenario: TC01 Dashboard'ın görünürlük ve işlevsellik testi

  Given Kullanici Heal Life "HLadminUrl"  girer
  When Admin mail "AdminMailKubra"  ve password "Passwords" ile sign in olur
  Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar
  Then Sidbarda "Dasboard" yazisini gorunurlugunu dogrular
  Then Dashboard yazisina tiklar
  And Sayfanin yenilendigini dogrular
  And Sayfayi Kapatir
  @kubra
  Scenario: TC02 Dashboard yan menüsündeki sayfa bağlantıları için görünürlük ve işlevsellik testi

    Given Kullanici Heal Life "HLadminUrl"  girer
    When Admin mail "AdminMailKubra"  ve password "Passwords" ile sign in olur
    Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar
    Then Yan menude asagidaki basliklarin mevcut oldugunu dogrular:
      | Dashboard      |
      | Billing        |
      | OPD            |
      | IPD            |
      | Pharmacy       |
      | Pathology      |
      | Radiology      |
      | Blood Bank     |
      | Ambulance      |
      | Front Office   |
      |  Birth & Death Record|
      | Human Resource |

    And Her linkin tiklanabilir oldugunu ve dogru sayfaya yönlendirildigini dogrular

