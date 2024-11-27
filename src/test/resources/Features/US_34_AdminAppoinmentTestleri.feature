

  Feature: Bir yönetici (admin) olarak randevulari yönetmek icin dashboard sidebar'da bir sayfanin olmasini istiyorum.
    Background:
      Given Kullanici Heal Life "HLadminUrl"  girer
      When Admin mail "AdminMailKubra"  ve password "Passwords" ile sign in olur
      Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar


    Scenario: TC01 Appointment ogesinin gorunurluğunu ve islevselligini  test etme
      Given Sidbarda "Appoinment" a tiklar
      When Appoinment sayfasina yonlendirildigini dogrular
      Then Sayfayi Kapatir
    @kubra
      Scenario: TC02 Appoinment sayfasi Patient Name, Appointment No, Appointment Date, Phone, Gender, Doctor, Source, Priorty, Fees, Status basliklari gorunurluk testi
        Given Sidbarda "Appoinment" a tiklar
        When  Tablo baslıklarının oldugunu dogrular
          | Patient Name       |
          | Appointment No     |
          | Appointment Date   |
          | Phone              |
          | Gender             |
          | Doctor             |
          | Source             |
          | Priority           |
          |Live Consultant     |
          | Fees               |
          | Status             |
        And Sayfayi Kapatir