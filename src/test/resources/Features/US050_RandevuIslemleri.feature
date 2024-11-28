Feature: Doktor olarak Dashboard SideBar'indaki Appointment sayfasindan hastalarin aldiklari randevulari görüntüleyebilmek istiyorum.

  Background:
    Given Doktor "HLadminUrl" sitesine gider
    When Doktor email olarak "DoctorMailIsmaill" ve password olarakda "Passwords" ile giriş yapar
    Then Doktor sitenin SideBar'ında bulunan "Appointment" sayfasına tıklar

  Scenario: TC09 Doktor olarak Appointment sayfasindan hastalarin aldiklari randevularin goruntulenmesini istiyorum
    And Doktor sitenin Appointment sayfasında randevuları goruntuler
    And Doktor browser kapatır

  Scenario: TC10 Appointment sayfasında bulunan Search Box'i kullanarak randevularin aranmasini istiyorum
    And Doktor sitenin Appointment sayfasında Search Box'i kullanarak randevuları arar
    Then Doktor SearchBox'taki arnan kelime listelenenle aynı olmalı
    And Doktor browser kapatır


  Scenario: TC11 Doctor Wise Appointment sayfasında Doctor ve Date filtreleme seçeneklerini kullanarak arama yapabilmek istiyorum
    And Doktor sitenin Appointment sayfasındaki "Doctor Wise" butonuna tıklar
    And Doktor, Doktor olarak "i̇smail kaya (1011)" Date olarak'ta "29.11.2024" seçer
    And Doktor Search butonuna basarak arama yapar
    Then Doktor Doctor Wise Appointment arnan kelime listelenenle aynı olmalı
    And Doktor browser kapatır


  Scenario: TC12 Appointment sayfasından Queue filtreleme seçeneklerini kullanarak arama yapabilmek istiyorum
    And Doktor sitenin Appointment sayfasındaki "Queue" butonuna tıklar
    And Doktor, Doktor olarak "i̇smail kaya (1011)" Shift olarak "Morning" Date olarak "29.11.2024" ve Slot olarak'ta "06:00 AM - 09:30 AM" seçer
    And Doktor Search butonuna basarak arama yapar
    Then Doktor Patient Queue arnan kelime listelenenle aynı olmalı
    And Doktor browser kapatır



  Scenario: TC13 Appointment sayfasinda Appointment Details Listeleme seçeneklerinin görüntülenmesini istiyorum.
    And Doktor sitenin Appointment sayfasında Appointment Details Listeleme seçeneklerini goruntuler
    And Doktor browser kapatır

