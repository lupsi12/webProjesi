# BLOG WEBSITE

Bu proje, Spring Boot framework kullanılarak geliştirilmiş bir web uygulamasıdır. Kullanıcı yönetimi, rol tabanlı erişim kontrolü (RBAC) ve çerez yönetimi gibi işlevleri içermekte olup, kullanıcıları etkin bir şekilde yönetmek ve güçlü güvenlik mekanizmaları sağlamak amacıyla tasarlanmıştır. Modern UI framework'ler kullanarak responsive bir kullanıcı arayüzü sunar ve Spring Security ile güçlendirilmiş yetkilendirme sağlar.

## Kullanılan Teknolojiler ve Araçlar
Proje, çeşitli modern teknolojiler ve araçlar kullanılarak geliştirilmiştir:
- **Spring Boot**
- **Spring Security**
- **Spring Framework**
- **React**
- **MongoDB**
- **Lombok**
- **Docker**
- **Postman**
- **Maven**
- **JWT**

  
## Özellikler
1. **Presentation Layer**: React kullanılarak geliştirilmiş kullanıcı arayüzü. Kullanıcılar bu arayüz üzerinden giriş yapabilir, kayıt olabilir ve yetkilerine bağlı olarak çeşitli sayfalara erişebilir.
2. **Business Layer**: OOP prensiplerini kullanarak tasarlanmış servisler, managerlar, entityler, controllerlar, configler ve repositoryler.
3. **Data Layer**: Entity framework kullanılarak oluşturulan veritabanı tasarımı ve etkileşimi.
4. **Web Service Implementation**: RESTful API'ler kullanılarak gerçekleştirilen CRUD işlemleri.
5. **RBAC Implementation**: Kullanıcılara atanmış roller üzerinden erişim kontrolü sağlanması.
6. **Authorization Implementation**: Spring Security ile gerçekleştirilen yetkilendirme, belirli uç noktalara sadece yetkilendirilmiş kullanıcıların erişimine izin verir.
7. **Session / Cookie Management**: Kullanıcı oturumlarını yönetmek ve kullanıcıya özgü verileri saklamak için kullanılan çerez yönetimi.
8. **Extension / Third Party Library Using**: Kod tekrarını azaltmak ve daha temiz bir kod yapısı sağlamak için Lombok kütüphanesi kullanılmıştır.
9. **Web Security Implementation**: CORS yapılandırması, parola şifreleme ve güvenli kimlik doğrulama protokollerini içerir.


## Projeyi Çalıştırmak İçin

Projeyi yerel geliştirme ortamınızda başlatmak ve çalıştırmak için aşağıdaki adımları izleyin:

1. **Docker Desktop'ı Açın:**
   - Bilgisayarınızda Docker Desktop uygulamasını açarak Docker'ın çalışır durumda olduğundan emin olun. Docker Desktop, projenin konteynerlerini çalıştırmak için gereklidir.

2. **Projeyi GitHub'dan Çekin:**
   - Terminal veya komut istemcisini açın ve projeyi GitHub reposundan yerel makinenize klonlamak için aşağıdaki komutu girin:
     ```bash
     git clone https://github.com/lupsi12/webProjesi.git
     ```
3. **Docker Compose ile Projeyi Başlatın:**
   - İndirilen proje dizinine gidin ve projeyi Docker kullanarak başlatmak için aşağıdaki Docker Compose komutunu terminalde çalıştırın:
     ```bash
     docker-compose up --build
     ```
   - Bu komut, gerekli Docker imajlarını inşa eder ve projenin bağımlılıklarını otomatik olarak kurarak servisleri başlatır.

4. **Uygulamaya Tarayıcı Üzerinden Erişin:**
   - Projeye ait frontend uygulamasına erişmek için web tarayıcınızı açın ve `http://localhost:3000/` adresine gidin.

5. **Backend API'ye Erişin:**
   - Backend servislerine erişmek için, tarayıcınızda `http://localhost:8080/user` adresini ziyaret edin. Bu adres, backend API'lerinin çalıştığı endpoint'tir.

## EKRAN GÖRÜNTÜLERİ
### Kayıt Olma Ekranı
Kullanıcılar bu ekrandan sisteme kayıt olabilirler. Kullanıcı adı, e-posta, şifre ve rol bilgileri girilerek yeni bir kullanıcı hesabı oluşturulabilir.

<img src="https://github.com/Merveziya/webfrontend/assets/108355676/2be382c4-0a24-4431-8f93-29f12748211d" width="600">

### Giriş Ekranı
Kullanıcılar, sistemde kayıtlı bilgileri ile bu ekrandan giriş yapabilirler.

<img src="https://github.com/Merveziya/webfrontend/assets/108355676/760e761a-192a-4607-8a00-d789710e1d3b" width="600">

### Admin Ekranı
Sistem yöneticilerinin kayıtlı tüm kullanıcıların bilgilerini görüntülemesine ve yönetmesine olanak tanır.

<img src="https://github.com/Merveziya/webfrontend/assets/108355676/b58462ed-6803-40d5-80c2-48bec6daa39c" width="600">

### Çerezlerin Yönetimi
Çerezler, kullanıcı tercihlerini kaydetmek ve oturum bilgilerini güvenli bir şekilde yönetmek için kullanılmıştır.

<img src="https://github.com/Merveziya/webfrontend/assets/108355676/a1f0f43f-3afc-4e3d-b460-f6024eff1c53" width="600">

### Postman Kullanıcı Sorgulama (E-posta ile)
 Kullanıcı, e-posta adresi kullanılarak sorgulanır ve kullanıcı bilgileri başarılı bir şekilde döndürülür.

 <img src="https://github.com/Merveziya/webfrontend/assets/108355676/2a74853c-c520-4190-a999-1150df654516" width="600">

### Postman Kullanıcı Sorgulama (ID ile)
Kullanıcı ID'si kullanılarak yapılan sorgu sonucu, belirtilen kullanıcının detayları başarıyla getirilir.

 <img src="https://github.com/Merveziya/webfrontend/assets/108355676/cb41889b-c1db-4ecf-883e-4fd7963c0651" width="600">

### Postman Kullanıcı Bilgi Güncelleme
Belirli bir kullanıcının yorum bilgileri güncellenir ve işlem başarılı bir şekilde tamamlanır.

 <img src="https://github.com/Merveziya/webfrontend/assets/108355676/0276bd67-1d30-43e3-9837-75ab3200ef2f" width="600">

