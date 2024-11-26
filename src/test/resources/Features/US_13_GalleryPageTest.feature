
Feature: Gallery Page Navigation

  Scenario: Verify gallery sections and their images
    Given Kullanıcı "HLurl" sitesine gider
    When Ana sayfada Gallery menüsüne tıklayın
    Then Kullanıcının Gallery sayfasına yönlendirildiğini doğrulayın
    When "Health & Wellness" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When "Hospitals and Directions" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When "Specialities" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When "Recreation Centre" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When "Your Health" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When "Surgery" bölümüne tıklayın ve ilgili resimlerin sayfada bulunduğunu doğrulayın
    When Kullanıcı browser kapatır
