/**
 * Ad Soyad: Melik Buğra Kara
 * Öğrenci No: 250541110
 * Proje: Not Sistemi
 * Tarih: 24/11/2025
 */

import java.util.Scanner;

class Proje1_NotSistemi{
    static double calculateAverage(double Vize, double Final, double Odev){
        return (0.3 * Vize) + (0.4 * Final) + (0.3 * Odev);
    }

    static boolean hasRetakeRight(double ortalama){
        return 40 <= ortalama && ortalama <= 50;
    }

    static boolean isHonorList(double Ortalama, double Vize, double Final, double Odev){
        return Ortalama >= 85 && Vize >= 70 && Final >= 70 && Odev >= 70;
    }
    
    static String getLetterGrade(double Average){
        if (Average >= 90) {
            return "A";
        }
        else if (Average >= 80) {
            return "B";
        }
        else if (Average >= 70){
            return "C";
        }
        else if (Average >= 60){
            return "D";
        }
        else if(Average < 60){
            return "F";
        }
        return "not valid";
    }

    static boolean isPassingGrade(double ortalama){
        return ortalama >= 50;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Vize notunu giriniz : ");
        double vize = input.nextDouble();
        System.out.print("\nFinal notunu giriniz : ");
        double Final = input.nextDouble();
        System.out.print("\nOdev notunu giriniz : ");
        double Odev = input.nextDouble();

        double Ortalama = calculateAverage(vize, Final, Odev);
        boolean isPassingGrade = isPassingGrade(Ortalama);
        String letterGrade = getLetterGrade(Ortalama);
        boolean isHonorList = isHonorList(Ortalama, vize, Final, Odev);
        boolean hasRetakeRight = hasRetakeRight(Ortalama);

        System.out.println("==== OGRENCI NOT RAPORU ====");
        System.out.printf("Vize Notu    : %.2f\n", vize);
        System.out.printf("Final Notu   : %.2f\n", Final);
        System.out.printf("Odev Notu    : %.2f\n", Odev);
        System.out.println("----------------------------");
        System.out.printf("Ortalama     : %.2f\n", Ortalama);
        System.out.printf("Harf Notu    : %s\n", letterGrade);
        if(isPassingGrade) {System.out.println("Durum        : GECTI");}
        else {System.out.println("Durum        : KALDI");}
        if(isHonorList) {System.out.println("Onur Listesi : EVET");}
        else {System.out.println("Onur Listesi : HAYIR");}
        if(hasRetakeRight) {System.out.println("Butunleme    : EVET");}
        else {System.out.println("Butunleme    : HAYIR");}
        System.out.println("----------------------------");
    }
}