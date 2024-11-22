
Feature: Verify footer and social media links functionality

  Scenario: TC_01 Kullanıcı qa.heallifehospital.com URL'ine ulaşabilmelidir.
    Given Kullanıcı HLurl adresini ziyaret eder
    And Kullanıcı siteye başarıyla erişebildiğini doğrular
    And Kullanıcı ana sayfanın footer bölümüne kaydırır
    And Kullanıcı sosyal medya ikonlarının görünür olduğunu doğrular
    Then sayfayı kapatır

  Scenario: TC_02 Sosyal medya ikonlarının ilgili hesaplara yönlendirdiğinin doğrulanması testi
    Given Kullanıcı projectUrl adresini ziyaret eder
    And Kullanıcı ana sayfanın footer bölümüne kaydırır
    And Facebook ikonuna tıklar
    Then Facebook ikonunun tıklandığını doğrular
    And Twitter ikonuna tıklar
    Then Açılan sayfa doğru Twitter hesabına yönlendirilmelidir
    And YouTube ikonuna tıklar
    Then Açılan sayfa doğru YouTube hesabına yönlendirilmelidir
    And Google ikonuna tıklar
    Then Açılan sayfa doğru Google hesabına yönlendirilmelidir
    And LinkedIn ikonuna tıklar
    Then Açılan sayfa doğru LinkedIn hesabına yönlendirilmelidir
    And Kullanıcı Instagram ikonuna tıklar
    Then Açılan sayfa doğru Instagram hesabına yönlendirilmelidir
    And Kullanıcı Pinterest ikonuna tıklar
    Then Açılan sayfa doğru Pinterest hesabına yönlendirilmelidir
    Then sayfayı kapatır