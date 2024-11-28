Feature: Hastanın randevu alma süreci

  Scenario: Hasta sisteme girer ve randevu oluşturmak için gerekli prosedürü takip eder.

    * John "HLurl" sitesine gider
    * John "Appointment" sayfasına gider
    * John Specialist olarak "Cardiologists" girer
    * Doctor olarak "i̇smail kaya (1011)" girer
    * Shift "Morning" girer
    * Date olarak "29.11.2024" girer
    * Message olarak'ta "El uyuşma sebebiyle randevu talebi" girer
    * Slot seçimi için Slot butonuna basar
    * Slot olarak'ta 05:12 PM girer
    * Patient Name olarak "John Doe" girer
    * Email olarak "11da1testestet@luxyss.com" girer
    * Phone olarak "9823114563222" girer
    * John randevu talebi için Submit butonuna basar
    * John Randevu ödemesi için Pay butonuna basar
    * John ödeme için Pay with card butonuna basar
    * John Email olarak "niko@hotmail.com" girer
    * Card Number olarak "4242424242424242" girer
    * MM_YY olarak "0227" girer
    * CVC olarak'ta "332" girer
    * Zip Code olarak'ta "010110" girer
    * John ödemeyi tamamlamak için Pay butonuna basar
    * John işlemin doğru olduğundan emin olmak için Success mesajını doğrular
    * John Go To Home butonuna basarak dashboard'a geri döner
    * John Approved yazısını görüp randevunun onaylandığını teyit eder
    * John kendi profil fotoğrafına basar
    * John ardından Logout butonuna basarak randevu alma işlemini tamamlar
    * John Browseri kapatır ve randevu tarihini bekler...

