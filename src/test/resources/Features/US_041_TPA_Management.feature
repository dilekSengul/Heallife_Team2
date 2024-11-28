Feature: TPA Management Sayfasına Yönlendirme

  Scenario: TPA Yönetim Sayfasına Yönlendirme
    Given Kullanici Heal Life "HLadminUrl"  girer
    When Admin mail "AdminMailHurrem"  ve password "Passwords" ile sign in olur
    When Dashboard yan menüsünden "TPA Management" bağlantısını tıkla
    Then TPA Management sayfasına yönlendirildiğini doğrular
    When Kullanıcı browser kapatır

  Scenario: TPA Yönetim Listesi Görüntülenmesi ve İşlevsellik Kontrolü
    Given Kullanici Heal Life "HLadminUrl"  girer
    When Admin mail "AdminMailHurrem"  ve password "Passwords" ile sign in olur
    When Dashboard yan menüsünden "TPA Management" bağlantısını tıkla
    Then TPA Yönetim Listesinde "Name", "Code", "Phone", "Address", "Contact Person Name" ve "Contact Person Phone" sütunlarının görüntülendiğini doğrular
    Then Kayıtları filtrelemek için bir arama kutusunun bulunduğunu doğrular
    Then Görüntülenen kayıt sayısını değiştirmek için yuz ve all seçeneklerinin mevcut olduğunu doğrular
    Then Her bir sütun başlığına tıklayarak listenin sıralanabildiğini doğrular
    When Kullanıcı browser kapatır

  Scenario: Yeni TPA kaydı ekleme ve doğrulama
    When Admin mail "AdminMailHurrem"  ve password "Passwords" ile sign in olur
    When Dashboard yan menüsünden "TPA Management" bağlantısını tıkla
    Then TPA Add penceresinde Name,Code,Contact No,Address,Contact Person Name ve Contact Person Phone  giriş alanlarının mevcut olduğunu doğrular
    When TPA Ekleme penceresindeki tüm alanlara geçerli veriler girer ve Save düğmesine tıklar
    Then Yeni kaydın TPA Yönetim Listesinde görüntülendiğini doğrular
    When Kullanıcı browser kapatır

  Scenario: TPA Yönetim Listesinde bir kaydın düzenlenmesi, silinmesi ve sıralanması
    When Admin mail "AdminMailHurrem"  ve password "Passwords" ile sign in olur
    When Dashboard yan menüsünden "TPA Management" bağlantısını tıkla
    Given TPA Yönetim Listesinde "Contact Person Phone" sütununun altındaki bir ismin uzerine gelirim
    When Edit işlemiyle kaydın detaylarını güncellenir
    When Silme işlemi gerçekleştirilir
    When Organization butonu kontrol edilir
    When Kullanıcı browser kapatır

