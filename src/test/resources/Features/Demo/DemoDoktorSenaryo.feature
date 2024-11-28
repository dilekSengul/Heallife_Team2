Feature: Bir doktorun, randevulu hastasına ilaç yazma süreci

  Scenario: Doktor, randevulu hastaasına sistem üzerinden ilaç yazar ve fatura oluşturur.

    * Doktor "HLadminUrl" sitesine gider
    * Doktor email olarak "DoctorMailIsmaill" ve password olarakda "Passwords" ile giriş yapar
    * Doktor sitenin SideBar'ında bulunan "Pharmacy" sayfasına tıklar
    * Doktor Generate Bill Butonuna basar
    * Hasta id'si "259" olarak seçer
    * Medicine Category olarak "Capsule" seçer
    * Medicine Name olarak "WORMSTOP" seçer
    * Batch No olarak 1520 seçer
    * Quantity olarak "3" yazar
    * Hospital Doctor olarak ismail kaya seçer
    * Save butonuna basarak ilacı kaydeder
    * Success mesajını doğrular
    * Listede hasta isminin göründüğünü doğrular
    * Doktor browser kapatır
