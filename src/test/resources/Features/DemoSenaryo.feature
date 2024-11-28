Feature: Hasta John ve Heallife Sitesi Yardımı

  Scenario: Sol elindeki uyuşma için randevu talebi

    Given John "HLurl" sitesine gider
    When John "Appointment" sayfasına gider
    Then John Specialist olarak "Cardiologists" girer
    And Doctor olarak "Sonia Bush (9002)" girer
    And Shift "Evening" girer
    And Date olarak "29.12.2024" girer
    And Message olarak'ta "El uyuşma sebebiyle randevu talebi" girer
    And Slot seçimi için Slot butonuna basar
    And Slot olarak'ta 05:12 PM girer
    And Patient Name olarak "John Doe" girer
    And Email olarak "nepariy365@luxyss.com" girer
    And Phone olarak "982456222" girer
    And John randevu talebi için Submit butonuna basar
    And John Randevu ödemesi için Pay butonuna basar
    And John ödeme için Pay with card butonuna basar
    And John Email olarak "niko@hotmail.com" girer
    And Card Number olarak "4242424242424242" girer
    And MM_YY olarak "0227" girer
    And CVC olarak'ta "332" girer
    And Zip Code olarak'ta "010110" girer
    And John ödemeyi tamamlamak için Pay butonuna basar
    And John işlemin doğru olduğundan emin olmak için Success mesajını doğrular
    And John Go To Home butonuna basarak anasayfaya yönlendirilir
    And John Approved yazısını görüp randevunun onaylandığını teyit eder
    And John kendi profil fotoğrafına basar
    And John ardından Logout butonuna basarak randevu alma işlemini tamamlar
    And John Browseri kapatır ve randevu tarihini bekler...
