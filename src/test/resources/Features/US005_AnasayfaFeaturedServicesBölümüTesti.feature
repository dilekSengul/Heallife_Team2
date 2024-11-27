Feature: US005_Bir kullanıcı olarak sitenin ana sayfasinda hastaneye ait
         "Featured Services" bölümünün olmasini istiyorum.

  Scenario: TC01_Ana sayfada Featured Services yazısı ve altında
            Medical Treatment, Emergency Help, Qualified Doctors, Medical professionals
            başlıklarının görünür olduğunun doğrulanması testi

    Given Browser aç ve HLurl adersine git
    And Sayfayı kaydır
    Then Featured Services görünür olduğunu doğrula
    And Medical Treatment görünür olduğunu doğrula
    And Emergency Help görünür olduğunu doğrula
    Then Qualified Doctors görünür olduğunu doğrula
    And Medical professionals görünür olduğunu doğrula
    And Sayfayı kapat







