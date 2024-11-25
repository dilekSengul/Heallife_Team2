@US21

Feature: Pharmacy Sayfasi Temel Ozellikleri ve Islevselligi


  Background: Kullanici sisteme giris yapar.
    Given kullanici "HLuserUrl" adresine gider
    And geçerli bir email adresi "onurPatName" ve sifre "onurPatPass" girer
    When Sign In butonuna tıklar
    Then dashboard duzgun bir şekilde goruntulenir

  @TC01
  Scenario: Pharmacy sayfasi dogrulanmasi
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then Pharmacy sayfasinin duzgun bir sekilde goruntulendigini dogrular

  Scenario: Pharmacy Bill listesi tablo basliklarinin dogrulanmasi
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then kullanici aşagidaki tablo basliklarinin goruntulendigini dogrular:
      | Bill No           |
      | Case ID           |
      | Date              |
      | Doctor Name       |
      | Note              |
      | Amount ($)        |
      | Paid Amount ($)   |
      | Balance Amount ($)|
      | Action            |

  Scenario: Pharmacy sayfasindaki arama islevinin dogrulanmasi
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then kullanici arama cubuguna bir ogenin iceriginin ilk 3 harfini yazar
    And arama sonuçlarinin dogru bir sekilde goruntulendigini dogrular

  Scenario: Actions butonlarının çalıştığını doğrulama
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then kullanici Actions sutunundaki View Payments butonuna tiklar
    And  View Payments butonunun duzgun calistigini dogrular
    Then kullanici Actions sutunundaki Show butonlarina butonuna tiklar
    And  Show butonunun duzgun calistigini dogrular


  @TC02
  Scenario: Odemede gecersiz girisimlerin reddedildiginin dogrulanmasi
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then kullanici bir ogenin Pay dugmesine tiklar
    Then odeme penceresine negatif bir miktar girer ve Add dugmesine tiklar
    And sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular

    Then odeme penceresine rakam olmayan bir karakter girer ve Add dugmesine tiklar
    And sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular

    Then odeme penceresine miktar olarak 0 girer ve Add dugmesine tiklar
    And sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular

    Then odeme penceresine bakiye miktarindan daha buyuk bir miktar olarak 500 girer ve Add dugmesine tiklar
    And sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular

    Then odeme penceresini bos birakir ve Add dugmesine tiklar
    And sayfanin bu girisimi reddettigini ve sag ust kosede error mesaji ciktigini dogrular

  Scenario: Odeme modulune gecilebildigini dogrulama
    When kullanici sol menuden Pharmacy secenegine tiklar
    Then kullanici bir ogenin Pay dugmesine tiklar
    And odeme penceresine miktar girer (full or partial amount) ve Add e tiklar
    Then odeme detaylari sayfasinin acildigini dogrular
