Feature: US006 Kullanici ana sayfa doktorlar seçeneğini görür bilgilerini gorur

    Scenario: TC01 "Our Doctors" başlığı altındaki doktorlar doğru şekilde listeleniyor
      Given Url "HLurl" girer
    And Kullanıcı ana sayfaya yönlendirilir
    When Kullanıcı sayfada "Our Doctors" başlığını görür
    And Her bir doktor için aşağıdaki bilgiler görünür olmalı:
      | İsim Soyisim                   | Unvan                 |
      | Heidi Prather                  | MD, Specialist        |
      | Alexander C. Simotas           | MD, Neurologist       |
      | Kristina Marie Quirolgico      | DO, Pediatrician      |
      | Christopher Lutz               | MD, Cardiologist      |
      | Joel M. Press                  | MD, Orthopedist       |
      | Dena Barsoum                   | MD, Anesthesiologist  |
      #And Her bir doktorun bir fotoğrafı görünür olmalı
      And Sayfayi Kapatir
