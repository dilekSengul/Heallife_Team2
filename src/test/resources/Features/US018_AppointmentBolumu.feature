Feature:
US018 Bir kullanici(hasta) olarak randevularimi kontrol edebilmem icin bir randevularimla ilgili islemleri yapabilecegim bir randevu sayfasinin olmasini istiyorum

Scenario: TC001 Randevu sayfasında randevu bilgilerini kontrol etme, işlemleri gerçekleştirme ve randevu arama
Given Kullanici Anasayfa adresine gider
When Hasta giriş düğmesine tıklar
And Hasta, hasta paneline giriş yapar
Then Hasta, "Appointment" sekmesine tıklar
Then Hasta bilgilerini kontrol eder
| Patient Id      |
| Gender          |
| Marital Status  |
| Phone           |
| Email           |
| Address         |
| Age             |
| Guardian Name   |
| Username        |
| Password        |

Then Yeni bir Appointment oluşturur
Then Show, pay butonuna tıklar
Then Appointment arasında arama yapar