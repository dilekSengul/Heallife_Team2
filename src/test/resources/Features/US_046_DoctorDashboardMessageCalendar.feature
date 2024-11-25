Feature: Doktor paneli Ana sayfası özellikleri

  Scenario: TC01 Login sayfasina dogru datalar ile sisteme girilmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    And Sign In butonuna tıklar

  Scenario: TC02 Doktorlara gonderilen post mesajlarinin goruntulenmesi testi
    Given Doktor geçerli url ile giriş yapar
    Then Gecerli User Name girer
    Then Gecerli password girer
    Then Sign In butonuna tıklar
    Then heal life logosu görüntülenir
    And navbar altinda post mesajlari bölümü oldugu dogrulanir
  @test
   Scenario: TC03 Doktora ait takvimin görüntülenmesi ve işlemler yapılabilmesi testi
     Given Doktor geçerli url ile giriş yapar
     Then Gecerli User Name girer
     Then Gecerli password girer
     Then Sign In butonuna tıklar
     And takvim bolumune gelinir
     Then Month tiklanir ve gun secilir
     Then Event title, event date, event color ve event type bolumleri doldurulur
     And save butonuna tiklanir






