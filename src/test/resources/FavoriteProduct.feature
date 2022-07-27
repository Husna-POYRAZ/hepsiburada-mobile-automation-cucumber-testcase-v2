@search
Feature: Süper Fiyat Süper Teklif Ürün Favorilere Ekleme Senaryosu
  Misafir kullanıcısı olarak uygulamayı açıp
  Süper Fiyat, Süper Teklif'teki ürünleri inceleyip
  Seçtiğim ürünü favorilere eklemek istiyorum

  @quick-cases
  Scenario: 1- Secilen urunu favorilere ekle
    Given Uygulama acilir
    When Popup ekranindaki Devam Tamamla ve Reklam kapatma butonlarina sira sira tiklanir
    And Super Fiyat Super Teklif tiklanir
    And Super Fiyat Super Teklif sayfasindan bir urune gidilir
    And Urun detayda urunun gorseline tiklanir ve yana dogru scroll edilir
    And Gorsel ekrani kapatilir
    And Urun detaydan favori butonuna basilir
    And Acilan login sayfasindan login olunur
    And Login olundugu kontrol edilir
    Then Begendiklerim sayfasina gidilip urunun begendiklerime eklendigi gorulur