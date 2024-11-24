Feature: Dashboard Sayfasındaki Özet Bilgi Panellerini Doğrulama
  @hurrem

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
