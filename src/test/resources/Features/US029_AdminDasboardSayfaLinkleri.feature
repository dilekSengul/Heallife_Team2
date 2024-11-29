

Feature: Bir yönetici (admin) olarak Admin panelinde menulerin yer aldigi bir dashboard sidebar olmasini istiyorum.
 Background:
               Given Kullanici Heal Life "HLadminUrl"  girer
               When Admin mail "AdminMailKubra"  ve password "Passwords" ile sign in olur
               Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar

  Scenario: TC01 Dashboard'ın görünürlük ve işlevsellik testi

  Then Sidbarda "Dasboard" yazisini gorunurlugunu dogrular
  Then Dashboard yazisina tiklar
  And Sayfanin yenilendigini dogrular
  And Sayfayi Kapatir


  Scenario: TC02 Dashboard yan menüsündeki sayfa bağlantıları için görünürlük ve işlevsellik testi
    Then Yan menude asagidaki basliklarin mevcut oldugunu dogrular:
      | Dashboard      |
      | Billing        |
      |Appointment     |
      | OPD            |
      | IPD            |
      | Pharmacy       |
      | Pathology      |
      | Radiology      |
      | Blood Bank     |
      | Ambulance      |
      |  Birth & Death Record|
      | Human Resource |
      Then  sayfayi Setup a kadar kaydirir ve yan menude asagidaki basliklarin mevcut oldugunu dogrular:
      |TPA Management  |
      | Messaging     |
      |Live Consultation|
      |Setup            |

    Scenario Outline: TC03 Bir kullanıcı olarak, her bir yan menü öğesinin doğru sayfaya yönlendirdiğini doğrulamak istiyorum
    And "<MenuItem>" basligina tikladigimda
    Then  "<ExpectedPageUrl>" basligina yonlendirilmeliyim
    Examples:
      | MenuItem         | ExpectedPageUrl  |
      | Dashboard        | dashboard        |
      | Billing          | bill             |
      | Appointment      | appointment      |
      | OPD              | patient          |
      | IPD              | ipdsearch        |
      | Pharmacy         | pharmacy         |
      | Pathology        | pathology        |
      | Radiology        | radio            |
      | Blood Bank       | bloodbankstatus  |
      | Ambulance        | getcallambulance |
      | Human Resource   |staff             |
      | TPA Management   | tpamanagement    |
      | Messaging        | notification     |