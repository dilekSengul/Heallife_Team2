Feature: TPA Management Sayfasına Yönlendirme

  Scenario: TPA Yönetim Sayfasına Yönlendirme
    Given Kullanici Heal Life "HLadminUrl"  girer
    Given Admin kullanıcısı olarak giriş yapar
    When Dashboard yan menüsünden "TPA Management" bağlantısını tıkla
    Then TPA Management sayfasına yönlendirildiğini doğrular
    And sayfayı kapatır

