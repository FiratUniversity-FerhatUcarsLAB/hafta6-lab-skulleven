/**
 * Ad Soyad: Melik Buğra Kara
 * Öğrenci No: 250541110
 * Proje: Restoran Sipariş Sistemi
 * Tarih: 27/11/2025
 */

import java.util.Scanner;

class Proje3_RestoranSiparis{
    static Boolean isWeekend(int gun)
    {
        switch (gun){
            case 6:
                return true;
            case 7:
                return true;
            default:
                return false;
        }
    }

    static Boolean isHappyHour(int saat){
        if(saat >= 14 && 17 >= saat){
            return true;
        }
        else{
            return false;
        }
    }

    static Boolean isComboOrder(int anaYemekSecim, int tatliSecim, int icecekSecim){
        return (anaYemekSecim > 0 && tatliSecim > 0 && icecekSecim > 0);
    }

    static int getDessertPrice(int secim){
        switch(secim){
            case 1: // Künefe
                return 65;
            case 2: // Baklava
                return 55;
            case 3: // Sütlaş
                return 35;
            default: // Yanlış değer
                throw new AssertionError();
        }
    }

    static int getDrinkPrice(int secim){
        switch(secim){
            case 1: // Kola
                return 15;
            case 2: // Ayran
                return 12;
            case 3: // Meyve Suyu
                return 35;
            case 4: // Limonata
                return 25;
            default: // Yanlış değer
                throw new AssertionError();
        }
    }

    static int getAppetizerPrice(int secim){
        switch (secim) {
            case 1: // Çorba
                return 25;
            case 2: // Humus
                return 45;
            case 3: // Sigara Böreği
                return 55;
            default: // Yanlış değer
                throw new AssertionError();
        }
    }

    static int getMainDishPrice(int secim){
        switch(secim){
            case 1: // Izgara Tavuk
                return 85;
            case 2: // Adana Kebap
                return 120;
            case 3: // Levrek
                return 110;
            case 4: // Mantı
                return 65;
            default: // Yanlış Sayı
                throw new AssertionError();
        }
    }

    static double calculateDiscount(double tutar, double icecekTutar, Boolean combo, int meslek, int saat, int gun){
        if(combo){
            tutar = tutar - (tutar * 0.15);
            System.out.println("kombo : " + tutar);
        }
        if(isHappyHour(saat)){
            tutar = tutar - (icecekTutar * 0.2);
            System.out.println("happy : " + tutar);
        }
        if(meslek == 1 && isWeekend(gun) == false){
            tutar = tutar - (tutar * 0.1);
            System.out.println("ogrenci : " + tutar);
        }
        return tutar;
    }

    static double calculateServiceTip(double tutar){
        return tutar * 0.1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ana Yemek (1-4)       : ");
        int anaYemekSecim = input.nextInt();
        System.out.print("Baslangic (0-3)       : ");
        int baslangicYemekSecim = input.nextInt();
        System.out.print("Icecek    (0-4)       : ");
        int icecekSecim = input.nextInt();
        System.out.print("Tatli     (0-3)       : ");
        int tatliSecim = input.nextInt();
        System.out.print("Saat      (8-23)      : ");
        int saat = input.nextInt();
        System.out.print("Ogrencimisiniz? (0-1) : ");
        int Ogrenci = input.nextInt();
        System.out.print("Hangi gun?(1-7)       : ");
        int gun = input.nextInt();

        double anaYemekTutar = getMainDishPrice(anaYemekSecim);
        double baslangicYemekTutar = getAppetizerPrice(baslangicYemekSecim);
        double icecekTutar = getDrinkPrice(icecekSecim);
        double tatliTutar = getDessertPrice(tatliSecim);

        double indirimsizTutar = anaYemekTutar + baslangicYemekTutar + icecekTutar + tatliTutar;

        Boolean kombo = isComboOrder(anaYemekSecim, tatliSecim, icecekSecim);

        double indirimliTutar = calculateDiscount(indirimsizTutar, icecekTutar, kombo, Ogrenci, saat, gun);

        double bahsisOnerisi = calculateServiceTip(indirimliTutar);

        System.out.println("===============");
        System.out.println("Ana Yemek Tutari       :          " + anaYemekTutar + " TL");
        System.out.println("Baslangic Yemek Tutari :          " + baslangicYemekTutar + " TL");
        System.out.println("Icecek Tutari          :          " + icecekTutar + " TL");
        System.out.println("Tatli Tutari           :          " + tatliTutar + " TL");
        System.out.println("Indirimsiz Tutar       :          " + indirimsizTutar + " TL");
        System.out.printf("Indirimli Tutar        :          %.2f TL \n", indirimliTutar);
        System.out.printf("Bahsis onerisi         :          %.2f TL\n", bahsisOnerisi);
    }
}