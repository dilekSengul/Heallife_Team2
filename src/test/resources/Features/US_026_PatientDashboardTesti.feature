Feature: Dashboard Sayfasındaki Özet Bilgi Panellerini Doğrulama

  Scenario: Özet bilgi panellerinin görünürlüğünü ve işlevselliğini doğrulama
    Given Kullanıcı "HLurl" sitesine gider
    And   loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    Then  Kullanıcı aşağıdaki özet bilgi panellerinin hasta dashboard'da mevcut olduğunu doğrular ve her birine tıklayıp ilgili sayfaya gider
      | OPD               |
      | IPD               |
      | Pharmacy          |
      | Pathology         |
      | Radiology         |
      | Ambulance         |
      | Blood Bank        |
      | Live Consultation |
    When Kullanıcı browser kapatır

  Scenario: Medical History grafiğinin görünürlüğünü ve değerlerini doğrula
    Given Kullanıcı "HLurl" sitesine gider
    And   loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    Then Dashboard sayfasının gövdesinde "Medical History" başlıklı bir grafik bulunduğunu doğrular
    When Kullanıcı browser kapatır

  Scenario: Kullanıcı belirtiler ve semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular
    Given Kullanıcı "HLurl" sitesine gider
    And loginButton'una tıklayarak kullanıcı adı ve şifresi ile hasta olarak giriş yapar
    When Belirtiler  için özet grafiklerin sayfada mevcut olduğunu doğrular
    Then Semptomlar için özet grafiklerin sayfada mevcut olduğunu doğrular
    When Kullanıcı browser kapatır
