package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;
import java.time.LocalDate;

public class MaterialManager {
    public static void main(String[] args) {
        Material[] materials = new Material[10];
        materials[0] = new Meat("1", "Thịt lợn 1",LocalDate.of(2023,1,20), 100, 1);
        materials[1] = new Meat("2", "Thịt lợn 2", LocalDate.of(2023,1,20), 120, 2);
        materials[2] = new Meat("3", "Thịt lợn 3", LocalDate.of(2023,1,20), 140, 3);
        materials[3] = new Meat("4", "Thịt lợn 4", LocalDate.of(2023,1,10), 160, 4);
        materials[4] = new Meat("5", "Thịt lợn 5", LocalDate.of(2023,1,10), 180, 5);

        materials[5] = new CrispyFlour("6", "Bột 1", LocalDate.of(2022,1,11), 100, 1);
        materials[6] = new CrispyFlour("7", "Bột 2", LocalDate.of(2022,1,12), 120, 2);
        materials[7] = new CrispyFlour("8", "Bột 3", LocalDate.of(2022,1,13), 140, 3);
        materials[8] = new CrispyFlour("9", "Bột 4", LocalDate.of(2022,1,14), 160, 4);
        materials[9] = new CrispyFlour("10", "Bột 5", LocalDate.of(2022,1,15), 180, 5);

        for (Material material : materials) {
            System.out.println(material);
            System.out.println("Hạn SD: "+material.getExpiryDate());
        }

        double costMeat = 0;
        double saleMeat = 0;
        double costCrispyFlour = 0;
        double saleCrispyFlour = 0;
        double differenceMeat;
        double differenceCrispyFlour;
        for (Material i : materials
        ) {
            if (i instanceof Meat) {
                costMeat += i.getAmount();
                saleMeat += i.getRealMoney();
            }
            if (i instanceof CrispyFlour) {
                costCrispyFlour += i.getAmount();
                saleCrispyFlour += i.getRealMoney();
            }
        }
        differenceMeat = costMeat - saleMeat;
        differenceCrispyFlour = costCrispyFlour - saleCrispyFlour;

        System.out.println("giá gốc thịt: " + costMeat);
        System.out.println("giá sale thịt: " + saleMeat);
        System.out.println("Giá chênh lệch thịt: " + differenceMeat);

        System.out.println("------------------------------------------------");

        System.out.println("giá gốc bột: " + costCrispyFlour);
        System.out.println("giá sale bột: " + saleCrispyFlour);
        System.out.println("Giá chênh lệch bột: " + differenceCrispyFlour);
    }
}