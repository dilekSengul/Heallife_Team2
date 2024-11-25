Feature: Bir yönetici (admin) olarak Admin panelinde menulerin yer aldigi bir dashboard sidebar olmasini istiyorum.

  @us_29
  Scenario: TC01 Dashboard'ın görünürlük ve işlevsellik testi
  Given Kullanici Heal Life "HLadminUrl"  girer
  When Admin mail "kubranur.admin@heallifehospital.com"  ve password "o6*d@fko3PXL1" ile sign in olur
  Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar
  Then Sidbarda "Dasboard" yazisini gorunurlugunu dogrular
  Then Dashboard yazisina tiklar
  And Sayfanin yenilendigini dogrular
  And Sayfayi kapatir
