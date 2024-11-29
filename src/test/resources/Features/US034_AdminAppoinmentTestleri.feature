

  Feature: Bir yönetici (admin) olarak randevulari yönetmek icin dashboard sidebar'da bir sayfanin olmasini istiyorum.
    Background:
      Given Kullanici Heal Life "HLadminUrl"  girer
      When Admin mail "AdminMailKubra"  ve password "Passwords" ile sign in olur
      Then Heal Life Hospital & Research yazisinin solundaki sidebar iconuna tiklar


    Scenario: TC01 Appointment ogesinin gorunurluğunu ve islevselligini  test etme
      Given Sidbarda "Appoinment" a tiklar
      When Appoinment sayfasina yonlendirildigini dogrular
      Then Sayfayi Kapatir

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

    Scenario: TC03 Patient Name liste basligi uzerinden siralama yapma testi
      Given Sidbarda "Appoinment" a tiklar
      When "Patient Name" sütun basligina tiklar
      And "Patient Name" sütunun alfebetik sirada oldugunu dogrular
      Then Sayfayi Kapatir

    Scenario: TC04 Search Box gorunurlugu ve islevselligi testi
      Given Sidbarda "Appoinment" a tiklar
      When Search Box oldugunu dogrular
      Then Search Box'a "Olivier Thomas" yazar
      And Hasta adı sütununda "Olivier Thomas" iceren sonucları gorundugunu dogrular
      Then Sayfayi Kapatir


    Scenario: TC05 Search Box gorunurlugu ve islevselligi testi
      Given Sidbarda "Appoinment" a tiklar
      When Status altinda "Action" basliginin gorundugunu dogrular
      Then Sayfayi Kapatir

    Scenario: TC06 Doktor wise butonu gorunurlugu ve aktifligi testi
      Given Sidbarda "Appoinment" a tiklar
      When Queue'nin solunda "Doctor Wise" gorunurlugunu dogrular
      Then "Doctor Wise" butonuna tiklar
      And Doctor Wise randevu sayfasina yonlendirildigini dogrular
      Then Sayfayi Kapatir

    Scenario: TC07  Doktor ve Date secilerek filtreleme testi
      Given Sidbarda "Appoinment" a tiklar
    Then "Doctor Wise" butonuna tiklar
    Then Doctor butonuna tiklar
    And Doktor olarak "Amit Singh (9009)" secer
    And Tarih butonuna tiklar
    And Tarih olarak"19.11.2024" secer
    And Search butonuna tiklar
    Then Asagidaki hasta bilgilerinin gorundugunu dogrular

      | Anna Broke (86)  | 1234671      | 07:00 am | klklpl@hotmail.com  | 19.11.2024 07:00 AM | Online |
      | Elizabeth (90)   | +99365646362 | 08:00 am | elizabeth@gmail.com | 19.11.2024 08:00 AM | Online |

      Then Sayfayi Kapatir

    Scenario: TC08 Queue butonu gorunurlugu ve aktifligi testi

      Given Sidbarda "Appoinment" a tiklar
      When Doctor Wise saginda "Queue" gorunurlugunu dogrular
      Then Queue butonuna tiklar
      And Queue randevu sayfasina yonlendirildigini dogrular
      Then Sayfayi Kapatir

    Scenario:
      Given Sidbarda "Appoinment" a tiklar
      Then Queue butonuna tiklar
      And Doktor olarak Amit Singh (9009) secer
      And Shift butonuna tiklar
      And Morning secer
      And Tarih olarak "19.11.2024" secer
      And Slot butonuna tiklar
      And Slot olarak "06:00 AM - 09:00 AM" secer
      And Search butonuna tiklar
      Then Asagidaki hasta bilgilerinin gorundugunu dogrular

       |1  | Anna Broke (86)  | 1234671      | 07:00 AM | klklpl@hotmail.com  | 19.11.2024  | Online |
       |2  | Elizabeth (90)   | +99365646362 | 08:00 AM | elizabeth@gmail.com | 19.11.2024  | Online |
      Then Sayfayi Kapatir
