Feature: Doktor HealLife sitesine ilaç yazımı

  Scenario: Hasta John ve ilaç süreci

    Given Doktor "HLadminUrl" sitesine gider
    When Doktor email olarak "DoctorMailIsmaill" ve password olarakda "Passwords" ile giriş yapar
    Then Doktor sitenin SideBar'ında bulunan "Pharmacy" sayfasına tıklar
    And Doktor Generate Bill Butonuna basar
    And Hasta id'si "59" olarak seçer
    And Medicine Category olarak "Capsule" seçer
    And Medicine Name olarak "WORMSTOP" seçer
    And Batch No olarak 1520 seçer
    And Quantity olarak "3" yazar
    And Hospital Doctor olarak ismail kaya seçer
    And Save butonuna basarak ilacı kaydeder
    And Success mesajını doğrular
    And Listede hasta isminin göründüğünü doğrular
    And Doktor browser kapatır
