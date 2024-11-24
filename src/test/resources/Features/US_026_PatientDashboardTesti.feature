Feature: Dashboard Sayfasındaki Özet Bilgi Panellerini Doğrulama

  Scenario: Özet bilgi panellerinin görünürlüğünü ve işlevselliğini doğrulama
    Given Kullanıcı projectUrl adresini ziyaret eder
    And   loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    Then  Kullanıcı aşağıdaki özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider
      |OPD        |
      |IPD        |
      |Pharmacy   |
      |Pathology  |
      |Radiology  |
      |Ambulance  |
      |Blood Bank |
      |Live Consultation|
    And sayfayı kapatır


  Scenario: Medical History grafiğinin görünürlüğünü ve değerlerini doğrula
    Given Kullanıcı projectUrl adresini ziyaret eder
    And   loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    Then Dashboard sayfasının gövdesinde "Medical History" başlıklı bir grafik bulunduğunu doğrular
    And Aşağıdaki değerlerin grafikte yer aldığını kontrol eder:
      | OPD        |
      | IPD        |
      | Pharmacy   |
      | Pathology  |
      | Radiology  |
      | Blood Bank |
      | Ambulance  |
    And sayfayı kapatır


  @hurrem

  Scenario: Kullanıcı belirtiler ve semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular
    Given Kullanıcı projectUrl adresini ziyaret eder
    And loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    When Belirtiler  için özet grafiklerin sayfada mevcut olduğunu doğrular
    Then Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular
    And sayfayı kapatır

