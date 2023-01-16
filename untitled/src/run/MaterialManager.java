package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;

import java.time.LocalDate;

public class MaterialManager {
    public static void main(String[] args) {
        Material[] materials = new Material[10];
        materials[0] = new CrispyFlour("1", "Bột chiên giòn", LocalDate.now(), 100, 1);
        materials[1] = new CrispyFlour("2", "Bột chiên giòn", LocalDate.now(), 110, 2);
        materials[2] = new CrispyFlour("3", "Bột chiên giòn", LocalDate.now(), 120, 3);
        materials[3] = new CrispyFlour("4", "Bột chiên giòn", LocalDate.now(), 130, 4);
        materials[4] = new CrispyFlour("5", "Bột chiên giòn", LocalDate.now(), 140, 5);
        materials[5] = new Meat("1", "Thịt lợn", LocalDate.now(), 100, 1);
        materials[6] = new Meat("2", "Thịt lợn", LocalDate.now(), 110, 2);
        materials[7] = new Meat("3", "Thịt lợn", LocalDate.now(), 120, 3);
        materials[8] = new Meat("4", "Thịt lợn", LocalDate.now(), 130, 4);
        materials[9] = new Meat("5", "Thịt lợn", LocalDate.now(), 140, 5);
        double meatRoot = 0;
        double powderBase = 0;
        double saleMeat = 0;
        double saleCrispyFlour = 0;
        double chenhLech = 0;
        for (Material i : materials) {
            int day5 = 5;
            if (i instanceof Meat) {
                meatRoot += i.getAmount();
                if (i.manufacturingDate.compareTo(i.getExpiryDate()) <= day5) {
                    saleMeat = meatRoot - (meatRoot * 0.3);
                } else {
                    saleMeat = meatRoot - (meatRoot * 0.1);
                }

            }
            chenhLech = meatRoot - saleMeat;
        }
        System.out.println("giá gốc thịt : " + meatRoot);
        System.out.println("Giá thịt sau khi giảm : " + saleMeat);
        System.out.println("Chênh lệch: " + chenhLech);

        System.out.println("---------------------------------------------");

        for (Material i : materials) {
            int month2 = 2;
            int month4 = 4;
            if (i instanceof CrispyFlour) {
                powderBase += i.getAmount();
                if (i.manufacturingDate.compareTo(i.getExpiryDate()) <= month2) {
                    saleCrispyFlour = powderBase - (powderBase * 0.4);
                } else if (i.manufacturingDate.compareTo(i.getExpiryDate()) <= month4) {
                    saleCrispyFlour = powderBase - (powderBase * 0.2);
                } else {
                    saleCrispyFlour = powderBase - (powderBase * 0.05);
                }
            }
            chenhLech = powderBase - saleCrispyFlour;
        }
        System.out.println("giá gốc bột : " + powderBase);
        System.out.println("Giá bột sau khi giảm: " + saleCrispyFlour);
        System.out.println("Chênh lệch: " + chenhLech);
    }
}