## n11 TalentHub 2022 Case Test 
### The project directory structure

![dizinYapisi](https://user-images.githubusercontent.com/76232388/150692400-2bf5e4f0-2e5d-4e54-918a-f8975026da8d.png)

n11 Test adımlarını anlayabilmek için öncelikle senaryo bilgilerini belirtelim:
  > 3 ayrı senaryo test edilmektedir. Senaryolarımız şunlardır:
   - Feature1: In the first one, the number of comments made about the selected store is checked.
   - Feature2: In the second time, the products added to the cart are tried to be purchased with the wrong credit card.
   - Feature3: In the third one, the ones with free shipping are listed according to the comment order of the searched product.
Belirttiğimiz senaryoların testleri yazılırken bazı kurallar temel alınarak hazırlanmıştır. Kısaca bu kurallardan bahsedelim:
  - Bir test case senaryosu için hazırlanan testlerin sahip olması gereken bazı prensiplerden şunlar kullanılmıştır:
    >- Her bir case bir senaryoyu test etmiştir.
    >- Kullanılan adımlar belirlenmiştir.
    >- Test method isimleri test edilen senaryonun birer yansıması olarak adlandırılmışlardır.
    >- Test edilen kısımların bır kısmı integratin test kapsamında bir kısmı ise diğer kısımlardan bağımsız olarak test edilmiştir.
    >- Testler otomatize edilerek çalıştırılmıştır.
    >- Testler anlaşılır, okunaklı, tekrar edilebilir olarak yazılmıştır.
    >- Testler başarısız olduğunda test koşumu durdurularak, ilgili hata ayrıntılı olarak belirtilmiştir.
# Test Case' imizin aldığı parametler şunlardır:
  - Browser: Hangi tarayıcının çalıştırılmak istendiğinin belirtildiği parametre( [Chrome-Firefox-Edge-Opera] )
  - Environment: Hangi ortamda çalıştırılmak istendiğine dair parametre[(test-qa-staging-prod)]
  - SeleniumGrid Ortamında Çalıştırılmasının istenip istenmediğine dair parametre( [true/false] )
  
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
   desiredBrowser
   -------------
   <img src="https://icons.iconarchive.com/icons/dtafalonso/android-lollipop/256/Chrome-icon.png" alt="Girl in a jacket" width="30" height="30">
   <img src="https://icons.iconarchive.com/icons/carlosjj/mozilla/256/Firefox-icon.png" alt="Girl in a jacket" width="30" height="30">
   vb..
    
  2.Adım-Selenium Grid Ortamının Ayağa Kaldırılması:
  Bu adımı 2(iki) ayrı yol kullanarak yapabiliriz.
  -Birinci Adım: Proje Dosya Ortamında bulunan dockerGridUp.sh adlı shell dosyasının çalıştırılmasıdır. 
    Komut satırı : (windows)    : ./dockerGridUp.sh
                   (MacOs/Linux): ./dockerGridUp.sh #Dosyaya calisma izni verilmesi için chmod +x dockerGridUp.sh
   -İkinci Adım: Projenin Dosya Ortamında bulunan seleniumGrid.yml dosyasını ayağa kaldırmaktır. Bunun için:
    Komut satırı : (windows)    : docker-compose -f .\seleniumGrid.yml up
                   (MacOs/Linux): docker-compose -f .\seleniumGrid.yml up
                   
  Selenium Docker ortam gereklilikleri ayağa kaldırıldıktan sonra (Docker_Selenium_Grid->true olduğundan emin olun!) testlerin çalıştırılması selenium grid üzerinden yapılacaktır. Testleri bir IDE üzerinden(IntellijIdea*Eclipse) veya komut satırından mvn verify test ile yürütebilirsiniz.
  http://localhost:4444/ui/index.html üzerinden browserların durumu takip edilebilir.
  
  Ramazan G.
    
    
