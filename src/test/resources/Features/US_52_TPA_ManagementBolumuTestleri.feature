@US52

Feature: TPA Management Sayfası Temel Özellikleri ve İşlevselliği

  Background: Kullanici sisteme giris yapar.
    Given kullanici "HLadminUrl" adresine gider
    And geçerli bir email adresi "DoctorMailOnur" ve sifre "Passwords" girer
    When Sign In butonuna tıklar
    Then dashboard duzgun bir şekilde goruntulenir
    When kullanici sol menuden "TPA Management" butonuna tiklar
    Then kullanici TPA Management sayfasina yonlendirildigini dogrular

  @TC01
  Scenario: TPA Management sayfasındaki kolonların doğrulanması
    Then kullanici aşağıdaki kolonların görüntülendiğini doğrular:
      | Name                 |
      | Code                 |
      | Phone                |
      | Address              |
      | Contact Person Name  |
      | Contact Person Phone |

  @TC02
  Scenario: Tablo öğelerinin kolonlara göre listelenebildiğinin doğrulanması
    Then kullanici tablo öğelerinin kolonlara göre listelenebildiğini doğrular

  @TC03
  Scenario: Sayfada bir arama çubuğu olduğunun doğrulanması
    Then sayfada bir arama çubuğu olduğunu doğrular

  @TC04
  Scenario: İçeriğin sayfa başına gösterilecek miktarının seçilebilmesi
    Then kullanici sayfadaki içeriğin görüntüleneceği sayfa sayısını 100 ya da "All" olarak seçebileceğini doğrular

  @TC05
  Scenario: Organization butonunun yönlendirme yapıp yapmadığının doğrulanması
    When kullanici "Contact Person Phone" altındaki "Organization" butonuna tıklar
    Then kullanici Details sayfasina yonlendirildigini dogrular
