<h1 align="center">
	  <img src="https://qa.heallifehospital.com/./uploads/hospital_content/logo/front_logo-617a7008a31f58.32204916.png"  alt="Logo"  width="150000"><br><br>
    HealLife Projesi - Test ve Tanıtım
</h1>

## 📚 Proje Hakkında
Bu proje, modern kullanıcı arayüzü (UI) test otomasyonu süreçlerine yönelik bir çözüm geliştirmek için tasarlanmıştır. **Selenium WebDriver**, **Cucumber** ve **Java** gibi güçlü araçların entegrasyonu sayesinde, hem kullanıcı dostu hem de kolayca genişletilebilir bir framework sunar. Framework, yazılım projelerinde otomasyon testlerini daha verimli bir şekilde gerçekleştirmek ve manuel test süreçlerini en aza indirerek zamandan tasarruf sağlamak amacıyla oluşturulmuştur.

Proje, yalnızca testlerin otomatikleştirilmesiyle sınırlı kalmayıp, aynı zamanda yazılım geliştirme süreçlerini hızlandırmayı ve hata oranlarını azaltmayı hedefler. Yeniden kullanılabilir modüller ve **Behavior-Driven Development (BDD)** yaklaşımı sayesinde, ekiplerin iş birliğini kolaylaştırırken, test süreçlerinde daha tutarlı ve güvenilir sonuçlar elde edilmesini sağlar. Bu sayede yazılımın kalitesini artırarak, kullanıcı deneyimini iyileştirmek için etkili bir çözüm sunar.

## 🎯 Projenin Amaçları
Bu proje aşağıdaki amaçlarla oluşturulmuştur:
1. UI test otomasyonunu kolaylaştırmak.
2. BDD yaklaşımını benimsemek ve senaryoların daha anlaşılır olmasını sağlamak.
3. CI/CD süreçleri ile uyumlu bir framework geliştirmek.

## 🚀 Gelecekteki Planlar
- Çoklu dil desteği eklemek.
- Daha fazla raporlama formatı desteği (ör. JSON, XML).
- Paralel test çalıştırma desteği sağlamak.

## 🛠 Technologies & Tools

<div>
  <a href="#">
		<img  src="https://img.shields.io/static/v1?label=Language&message=Java&color=red&style=for-the-badge&logo=Java"  alt="Language: Java">
	</a>

  <a href="#">
		<img  src="https://img.shields.io/static/v1?label=Language&message=Cucumber&color=green&style=for-the-badge&logo=Cucumber"  alt="Freamework: Cucumber">
	</a>

  <a href="#">
        <img src="https://img.shields.io/static/v1?label=Tests&message=JUnit&color=yellow&style=for-the-badge&logo=JUnit" alt="Tests: JUnit">
  </a>

  <a href="#">
        <img src="https://img.shields.io/static/v1?label=Compilation&message=Maven&color=blue&style=for-the-badge&logo=Maven" alt="Compilation: Maven">
  </a>

  <a href="#">
        <img src="https://img.shields.io/static/v1?label=Atumation&message=Selenium&color=pink&style=for-the-badge&logo=SeleniumWebdriver" alt="Atumation: Selenium">
  </a>
</div>

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