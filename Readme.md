# ** com.HealLifeHospital_Team1 **

## 📚 Proje Hakkında
Bu proje, **Selenium WebDriver**, **Cucumber**, ve **Java** kullanılarak UI test otomasyonu için tasarlanmış bir framework'tür. Framework, **Behavior-Driven Development (BDD)** yaklaşımını destekler ve yeniden kullanılabilir, modüler bir yapı sunar.

## 🎯 Projenin Amaçları
Bu proje aşağıdaki amaçlarla oluşturulmuştur:
1. UI test otomasyonunu kolaylaştırmak.
2. BDD yaklaşımını benimsemek ve senaryoların daha anlaşılır olmasını sağlamak.
3. CI/CD süreçleri ile uyumlu bir framework geliştirmek.

## 🚀 Gelecekteki Planlar
- Çoklu dil desteği eklemek.
- Daha fazla raporlama formatı desteği (ör. JSON, XML).
- Paralel test çalıştırma desteği sağlamak.


### **Özellikler**
- **Cucumber BDD:** İş mantığını İngilizce gibi doğal bir dilde tanımlama.
- **Selenium WebDriver:** UI otomasyonu için güçlü bir araç.
- **Page Object Model (POM):** Sayfa bazlı tasarım.
- **JUnit/TestNG:** Test çalıştırma ve raporlama.
- **WebDriver Manager:** WebDriver yönetimini kolaylaştırır.
- **Log4j:** Loglama.
- **Extent Reports:** Gelişmiş HTML raporlama.
- **Çoklu tarayıcı desteği:** Chrome, Firefox, Edge.
- **CI/CD için uygun yapı.**

---

## 🛠 Gereksinimler
Projeyi çalıştırmak için aşağıdaki araçlar gereklidir:
- **Java JDK 11 veya üzeri**
- **Maven 3.6.0 veya üzeri**
- **Git**
- Bir IDE (IntelliJ IDEA veya Eclipse önerilir)


## 📂 Proje Yapısı

```plaintext
draftCucumberProject
├── .idea                             # IntelliJ IDEA ayar dosyaları
├── Documents                         # Dokümanların olduğu klasör
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config
│   │   │   │   └── ConfigReader.java      # Config dosyasını okuyucu class
│   │   │   ├── drivers
│   │   │   │   ├── BrowserFactory.java    # Tarayıcı ayarları
│   │   │   │   └── DriverManager.java     # WebDriver yönetimi
│   │   │   ├── pages
│   │   │   ├── utils
│   │   │   │   ├── ExcelReader.java       # Excel işlemleri
│   │   │   │   ├── JSUtilities.java       # Javascript metotlar
│   │   │   │   ├── LoggerHelper.java      # Loglama işlemleri
│   │   │   │   ├── ReusableMethods.java   # Tekrar kullanılabilir metotlar
│   │   │   │   ├── TestUtils.java         # Genel test yardımcıları
│   │   │   │   └── WaitHelper.java        # Dinamik bekleme yönetimi
│   └── resources
│       └── config.properties              # Framework ayarları
├── test
│   ├── java
│   │   ├── features
│   │   │   └── login.feature              # Login senaryoları
│   │   ├── runners
│   │   │   └── TestRunner.java            # Test çalıştırıcı
│   │   ├── stepdefinitions
│   │   │   ├── Hooks.java                 # Before/After metodları
│   │   │   └── LoginSteps.java            # Login işlemleri adımları
│   └── resources
│       └── extent-config.xml              # Extent Report yapılandırma
├── target                                # Derleme sonrası oluşturulan dosyalar
├── .gitignore                            # Git tarafından göz ardı edilen dosyalar
├── pom.xml                               # Maven bağımlılıkları ve proje ayarları
└── README.md                             # Proje açıklama dosyası



``` 



### **1. `src/main/java`**
Framework’ün ana kodlarının bulunduğu yerdir.

#### **1.1. `config`**
- **Amacı:** Framework’ün yapılandırma ayarlarını yönetmek.
- **Dosyalar:**
  - **`ConfigReader.java`**: `config.properties` dosyasını okuyarak framework’ün yapılandırma ayarlarını yükler.

#### **1.2. `drivers`**
- **Amacı:** WebDriver yönetimi ve tarayıcı ayarlarını içerir.
- **Dosyalar:**
  - **`DriverManager.java`**: WebDriver nesnesini başlatır ve kapatır.
  - **`BrowserFactory.java`**: Farklı tarayıcılar için WebDriver nesnesi oluşturur (ör. Chrome, Firefox).

#### **1.3. `pages`**
- **Amacı:** Page Object Model (POM) yapısını kullanarak web sayfalarını temsil eder.
- **Dosyalar:**
  - **`BasePage.java`**: Tüm sayfalar için temel işlemleri içerir (örneğin, tıklama, yazma).
  - **`LoginPage.java`**: Login sayfasını temsil eder ve giriş işlemleriyle ilgili metodları barındırır.
  - **`HomePage.java`**: Ana sayfa işlemlerini temsil eder ve ana sayfa işlemleriyle ilgili metodları barındırır.

#### **1.4. `utils`**
- **Amacı:** Yardımcı metodları barındırır.
- **Dosyalar:**
  - **`ExcelReader.java`**: Excel dosyalarını okumak için metotlar içerir.
  - **`JSUtilities.java`**: JavaScript işlemleri (ör. scroll veya alert handling) için metotlar sağlar.
  - **`LoggerHelper.java`**: Framework genelinde loglama işlemleri için kullanılır.
  - **`ReusableMethods.java`**: Proje genelinde tekrar kullanılabilir genel metotları barındırır.
  - **`TestUtils.java`**: Genel test yardımcı metotlarını içerir.
  - **`WaitHelper.java`**: Dinamik beklemeler (explicit wait) için yardımcı metodlar sağlar.

---

### **2. `src/main/resources`**
Framework için gerekli olan kaynak dosyalarını içerir.

#### **Dosyalar:**
- **`config.properties`**: Framework’ün yapılandırma ayarlarını içerir.

---

### **3. `src/test/java`**
Cucumber senaryolarını çalıştırmak ve tanımlamak için test kodlarını içerir.

#### **3.1. `features`**
- **Amacı:** Cucumber senaryolarının tanımlandığı `.feature` dosyalarını içerir.
- **Dosyalar:**
  - **`login.feature`**: Login işlemleri için örnek bir senaryo içerir.

#### **3.2. `stepdefinitions`**
- **Amacı:** `.feature` dosyalarındaki adımları Java kodlarına bağlar.
- **Dosyalar:**
  - **`Hooks.java`**: Testlerden önce ve sonra çalışan yapılandırmaları tanımlar (ör. `Before` ve `After`).
  - **`LoginSteps.java`**: Login işlemleri için adımları içerir.

#### **3.3. `runners`**
- **Amacı:** Cucumber senaryolarını başlatır.
- **Dosyalar:**
  - **`TestRunner.java`**: Cucumber özelliklerini çalıştırmak için kullanılır.

---

### **4. `src/test/resources`**
Testlerle ilgili kaynak dosyalarını içerir.

#### **Dosyalar:**
- **`extent-config.xml`**: Extent Reports için yapılandırma ayarlarını barındırır.

---

### **5. Diğer Dosyalar**
- **`.gitignore`**: Git tarafından göz ardı edilecek dosyaların listesini içerir.
- **`pom.xml`**: Maven bağımlılıklarını ve proje yapılandırmalarını içerir.
- **`README.md`**: Projeye dair açıklamaları içeren dosya.

### **6. Projede Calisirken Dikkat Edilmesi Gerekenler**
Locate alinan element nerenin elementi oldugu aciklama satiri ile aciklanmali || orn: Homepage>> LoginLink>> Email Text Box ||

### Git
***
1. Herkes kendi adina birer branch olusturur.
  * `git branch <isim>`

Nerede oldugunuzu görmek icin `git branch` komutunu kullanin.
Branch degistirmek icin `git checkout <isim>` komutunut kullanin.

Kodunuzu güncellemek icin main branch e checkout ile gecin
Daha sonra `git pull` komutu ile kendinize cekin
Kendi branchinizi checkout ile gecin ve `git merge yapin`


2. sol üst ya da sag alt(mac için) panelde branch ismimizin yazili oldugu kisimdan
  * main'e tikliyoruz
  * update'e tikliyoruz
  * sonra merge 'main' into 'branch ismi' yazan kısma tikliyoruz
  * bu şekilde pull işlemini gerçekleştirmiş oluyoruz

3. Yaptigi degisiklikleri kucuk commitlerle kendi branchinda saklar. Burada tavsiye edilen sadece sizin yaptiginiz degisikliklerin eklenmesidir.
  * 'git add . kesinlikle kullanilMAMAli'
  * 'git add (degisiklik yapilan yerin dosya yolu yani "path from content root" u)
  * 'git commit -m "İsim/tarih/Yapilan Degisiklikler icin bir mesaj yazilir."'
    Örn >>> git commit -m "<Kendi isminiz>/02.07/loginClassEklendi"
4. git push

Eger push isleminden sonra Failed e-postasi alirsaniz bu demektir ki cakisma vardir.

- Push icin Jenkins ile baglanti kuruldugundan belli saatlerde push islemi yapilacaktir.



#### **Önemli Bağımlılıklar:**
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.14.0</version>
    </dependency>
    <dependency>
        <groupId>io.cucumber</groupId>
        <artifactId>cucumber-java</artifactId>
        <version>7.13.0</version>
    </dependency>
    <dependency>
        <groupId>com.aventstack</groupId>
        <artifactId>extentreports</artifactId>
        <version>5.0.9</version>
    </dependency>
</dependencies>

```

## 🛠️ Teknoloji Stack

Bu proje aşağıdaki teknolojileri kullanır:
- **Java 11:**
- **Maven:**
- **Selenium WebDriver:**
- **Cucumber:**
- **JUnit 5:**
- **Extent Reports:**
- **Log4j:**
- **WebDriver Manager:**

 

