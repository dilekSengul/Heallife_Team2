@US22


  Feature: Pathology Sayfasi Temel Ozellikleri ve Islevselligi

    Background: Kullanici sisteme giris yapar.
      Given kullanici "https://qa.heallifehospital.com/site/login" adresine gider
      And geçerli bir e-posta adresi ve sifre girer
      When giris butonuna tıklar
      Then ana sayfa duzgun bir şekilde goruntulenir

    @TC01
    Scenario: Pathology sayfasi dogrulanmasi
      When kullanici sol menuden "Pathology" secenegine tiklar
      Then Pathology sayfasinin duzgun bir sekilde goruntulendigini dogrular

    Scenario: Pathology Bill listesi tablo basliklarinin dogrulanmasi
      When kullanici sol menuden "Pathology" secenegine tiklar
      Then kullanici aşagidaki tablo basliklarinin goruntulendigini dogrular:

        | Bill No           |
        | Case ID           |
        | Reporting Date    |
        | Reference Doctor  |
        | Note              |
        | Amount ($)        |
        | Paid Amount ($)   |
        | Balance Amount ($)|
        | Action            |

    Scenario: Pathology sayfasindaki arama islevinin dogrulanmasi
      When kullanici arama cubuguna bir ögenin ilk 3 harfini yazar
      Then arama sonuçlarinin dogru bir sekilde goruntulendigini dogrular

    Scenario: Verify actions buttons work correctly
      When kullanici "Actions" sutunundaki "View Payments" ve "Show" butonlarina tiklar
      Then bu dugmelerin duzgun calistigini dogrular


    @TC02
    Scenario: Odemede gecersiz girisimlerin reddedildiginin dogrulanmasi
      When kullanici bir ogenin "Pay" dugmesine tiklar
      And odeme penceresine negatif bir miktar girer ve "Add" dugmesine tiklar
      Then sayfanin bu girisimi reddettigini ve sag ust kosede "error" mesaji ciktigini dogrular

      When odeme penceresine rakam olmayan bir karakter girer ve "Add" dugmesine tiklar
      Then sayfanin bu girisimi reddettigini ve sag ust kosede "error" mesaji ciktigini dogrular

      When odeme penceresine sifir (0) miktar girer ve "Add" dugmesine tiklar
      Then sayfanin bu girisimi reddettigini ve sag ust kosede "error" mesaji ciktigini dogrular

      When odeme penceresine bakiye miktarindan daha buyuk bir miktar girer ve "Add" dugmesine tiklar
      Then sayfanin bu girisimi reddettigini ve sag ust kosede "error" mesaji ciktigini dogrular

      When odeme penceresini bos birakir ve "Add" dugmesine tiklar
      Then sayfanin bu girisimi reddettigini ve sag ust kosede "error" mesaji ciktigini dogrular

    Scenario: Odeme modulune gecilebildigini dogrulama
      When kullanici bir ogenin "Pay" dugmesine tiklar
      And odeme penceresine miktar girer (full or partial amount) ve "Add" e tiklar
      Then odeme detaylari sayfasinin ve odeme miktarinin olması gerektigi gibi goruntulendigini dogrular
