## n11 TalentHub 2022 Case Test 
### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main
  + test
    + java                        Test runners and supporting code
    + resources
      + features                  Feature files
     + search                  Feature file subdirectories 
             n11FacebookLogin.feature
```

n11 Test adımlarını anlayabilmek için öncelikle senaryo bilgilerini belirtelim:
  - 3 ayrı senaryo test edilmektedir. Senaryolarımız şunlardır:
    *Feature1: In the first one, the number of comments made about the selected store is checked.
    *Feature2: In the second time, the products added to the cart are tried to be purchased with the wrong credit card.
    *Feature3: In the third one, the ones with free shipping are listed according to the comment order of the searched product.
Belirttiğimiz senaryoların testleri yazılırken bazı kurallar temel alınarak hazırlanmıştır. Kısaca bu kurallardan bahsedelim:
  - Bir test case senaryosu için hazırlanan testlerin sahip olması gereken bazı prensiplerden şunlar kullanılmıştır:
    *Her bir case bir senaryoyu test etmiştir.
    *Kullanılan adımlar belirlenmiştir.
    *Test method isimleri test edilen senaryonun birer yansıması olarak adlandırılmışlardır.
    *Test edilen kısımların bır kısmı integratin test kapsamında bir kısmı ise diğer kısımlardan bağımsız olarak test edilmiştir.
    *Testler otomatize edilerek çalıştırılmıştır.
    *Testler anlaşılır, okunaklı, tekrar edilebilir olarak yazılmıştır.
    *Testler başarısız olduğunda test koşumu durdurularak, ilgili hata ayrıntılı olarak belirtilmiştir.
Test Case' imizin aldığı parametler şunlardır:
  -Browser: Hangi tarayıcının çalıştırılmak istendiğinin belirtildiği parametre(Chrome-Firefox-Edge-Opera-Safari)
  -Environment: Hangi ortamda çalıştırılmak istendiğine dair parametre(test-qa-staging-prod)
  -SeleniumGrid Ortamında Çalıştırılmasının istenip istenmediğine dair parametre(true/false)
  
Testlerin tamamı paralel olarak çalıştırılabilmektedir. Paralel çalıştırıldığını anlayabilğimiz standart çıktı örneği:
  -[pool-2-thread-2]
  -[pool-2-thread-3]
  -[pool-2-thread-4]
  --Yukarı da belirtildiği gibi 'pool-2' iş parçacığı havuzunda 2-3-4 numaları farklı iş parçacıkları çalışmaktadır.
  
  Selenium Grid
  -------------
  Test adımlamızın docker selenium grid ortamında çalıştırılması mümkündür. Bunun için gerekli adımlar aşağıda açıklanmaktatır:
  1.Adım-Parametrenin Verilmesi:
  Öncelikle varsayılan olarak testlerimiz selenium ortamında çalıştırılmayacak şekilde parametre almaktadır. Bu parametrenin değiştirilerek testlerimiz docker selenim grid ortamında çalıştırılmaya hazır hale gelmektedir.
  Parametrenin belirtildiği kısım: 
  Img-1
  ![Proje1_Odev1.feature](https://user-images.githubusercontent.com/76232388/150688449-d1a8b403-b907-452a-bf45-afb0acb4cae1.png)
    Proje1_Odev1.feature Dosyasında paremetrenin belirtildiği kısım Img-1 de gösteriştir.
    false: Selenim Grid Off
    true:  Selenium Grid Onn
    
  2.Adım-Selenium Grid Ortamının Ayağa Kaldırılması:
  Bu adımı 2(iki) ayrı yol kullanarak yapabiliriz.
  -Birinci Adım: Proje Dosya Ortamında bulunan dockerGridUp.sh adlı shell dosyasının çalıştırılmasıdır. 
    Komut satırından : 
    
    
