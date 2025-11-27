/**
 * Ad Soyad: Melik Buğra Kara
 * Öğrenci No: 250541110
 * Proje: Sinema Bileti Hesaplama
 * Tarih: 27/11/2025
 */

import java.util.Scanner;

class Proje2_SinemaBileti{
    static String gunText = "";
    static String filmText = "";

    static boolean isWeekend(int gun){
        switch (gun) {
            case 1:
                gunText = "Pazartesi";
                return false;
            case 2:
                gunText = "Sali";
                return false;
            case 3:
                gunText = "Carsamba";
                return false;
            case 4:
                gunText = "Persembe";
                return false;
            case 5:
                gunText = "Cuma";
                return false;
            case 6:
                gunText = "Cumartesi";
                return true;
            case 7:
                gunText = "Pazar";
                return true;
            default:
                throw new AssertionError();
        }
    }
    
    static boolean isMatinee(int saat){
        return saat < 12;
    }

    static double calculateDiscount(double yas, String meslek, int gun){
        if(yas < 12){return 0.25;}
        if(yas > 65) {return 0.3;}
        if("Ogretmen".equals(meslek)) {return 0.35;}
        if("Ogrenci".equals(meslek)) {return  0.2;}
        else{return 0;}
    }
    
    static double calculateFinalPrice(double Discount, double BasePrice, double FormatExtra){
        return (BasePrice - (BasePrice * Discount)) + FormatExtra;
    }

    static void generateTicketInfo(int Gun, int saat, int yas, String meslek, int filmturu){
        System.out.println("Gun (1-7)        : " + Gun + " (" + gunText + ")");
        if(saat < 12) {System.out.println("Saat (8-23)      : " + saat + " (Matine)");} 
        else{System.out.println("Saat (8-23)      : " + saat + " (Normal)");}
        System.out.println("Yas              : " + yas);
        System.out.println("Meslek           : " + meslek);
        System.out.println("Film Turu (1-4)  : " + filmturu + " (" + filmText + ")");
        System.out.println("===============");
        System.out.println("Temel Fiyat     : " + calculateBasePrice(Gun, saat));
        System.out.println("Indirim         : " + "%" +(calculateDiscount(yas, meslek, Gun) * 100));
        System.out.println("Indirimli Fiyat : " + (calculateBasePrice(Gun, saat) - (calculateBasePrice(Gun, saat) * calculateDiscount(yas, meslek, Gun))));
        System.out.println("Film Ekstra     : " + getFormatExtra(filmturu));
        System.out.println("Toplam : " + calculateFinalPrice(calculateDiscount(yas, meslek, Gun), calculateBasePrice(Gun, saat), getFormatExtra(filmturu)));
    }

    static double getFormatExtra(int filmturu){
        switch (filmturu) {
            case 1: // 2D
                filmText = "2D";
                return 0;
            case 2: // 3D
                filmText = "3D";
                return 25;
            case 3: // IMAX
                filmText = "IMAX";
                return 35;
            case 4: // 4DX
                filmText = "4DX";
                return 50;
            default:
                throw new AssertionError();
        }
    }

    static double calculateBasePrice(int gun, int saat){
        if(isWeekend(gun) && isMatinee(saat)){return 55;}
        if(isWeekend(gun) && !isMatinee(saat)){return 85;}
        if(!isWeekend(gun) && isMatinee(saat)){return 45;}
        if(!isWeekend(gun) && !isMatinee(saat)){return 65;}
        else{return 9001;}
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Haftanin kacinci gunu olduğunu yazin (1-7) : ");
        int gun = input.nextInt();
        System.out.print("Saatin kac oldugunu yazın (8-23) : ");
        int saat= input.nextInt();
        System.out.print("Yasinizi yazin : ");
        int yas = input.nextInt();
        System.out.print("Izlemek istediginiz film turunu belirtin (1- 2D 2-3D 3-IMAX 4-4DX): ");
        int filmturu = input.nextInt();
        System.out.print("Mesleginizi belirtin : ");
        String meslek = input.next();

        generateTicketInfo(gun, saat, yas, meslek, filmturu);
    }
}