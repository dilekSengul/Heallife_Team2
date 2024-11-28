Feature: Dashboard sayfasındakı navbar


  Scenario: Logoya tıklayıınca anasayfaya yonlendırme

    Given kullanici "HLuserUrl" adresine gider
    And geçerli bir email adresi "gulnarPatName" ve sifre "gulnarPatPass" girer
    And Sign In butonuna tıklar
    And kullanici dili degistırı
    And kullanici bildirme görür.
    And kullanıcı logout olur

