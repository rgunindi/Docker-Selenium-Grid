n11 TalentHub 2022 Case Test 

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
  Test adımlamızın docker selenium grid ortamında çalıştırılması mümkündür. Bunun için gerekli adımlar aşağıda açıklanmakdtır:
  
  Öncelikle varsayılan olarak testlerimiz selenium ortamında çalıştırılmayacak şekilde parametre almaktadır. Bu parametrenin değiştirilerek testlerimiz docker selenim grid ortamında çalıştırılmaya hazır hale gelmektedir.
  Parametrenin belirtildiği kısım: 
