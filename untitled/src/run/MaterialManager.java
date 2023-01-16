package run;

import material.CrispyFlour;
import material.Material;
import material.Meat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    public ArrayList<Material> materials;
    Scanner input = new Scanner(System.in);
    int index;

    public MaterialManager() {
        materials = new ArrayList<>();
        materials.add(new Meat("1", "Thịt lợn 1", LocalDate.now().plusDays(1), 100, 1));
        materials.add(new Meat("2", "Thịt lợn 2", LocalDate.now().plusDays(2), 100, 1));
        materials.add(new Meat("3", "Thịt lợn 3", LocalDate.now().plusDays(3), 100, 1));
        materials.add(new Meat("4", "Thịt lợn 4", LocalDate.now().plusDays(4), 100, 1));
        materials.add(new Meat("5", "Thịt lợn 5", LocalDate.now().plusDays(5), 100, 1));
        materials.add(new CrispyFlour("6", "Bột 1", LocalDate.now().plusDays(1), 100, 1));
        materials.add(new CrispyFlour("7", "Bột 2", LocalDate.now().plusDays(2), 100, 1));
        materials.add(new CrispyFlour("8", "Bột 3", LocalDate.now().plusDays(3), 100, 1));
        materials.add(new CrispyFlour("9", "Bột 4", LocalDate.now().plusDays(4), 100, 1));
        materials.add(new CrispyFlour("10", "Bột 5", LocalDate.now().plusDays(5), 100, 1));
    }

    public void print() {
        for (Material material : materials) {
            System.out.println(material);
            System.out.println("Hạn SD: " + material.getExpiryDate());
        }
        System.out.println("------------------------------------------------");
    }

    public void differenceMeat() {
        double costMeat = 0;
        double saleMeat = 0;
        double differenceMeat;
        for (Material material : materials
        ) {
            if (material instanceof Meat) {
                costMeat += material.getAmount();
                saleMeat += material.getRealMoney();
            }
        }
        differenceMeat = costMeat - saleMeat;
        System.out.println("Giá gốc thịt: " + costMeat);
        System.out.println("Giá sale thịt: " + saleMeat);
        System.out.println("Giá chênh lệch thịt: " + differenceMeat);
        System.out.println(" ");
    }

    public void differenceCrispyFlour() {
        double costCrispyFlour = 0;
        double saleCrispyFlour = 0;
        double differenceCrispyFlour;
        for (Material material : materials
        ) {
            if (material instanceof CrispyFlour) {
                costCrispyFlour += material.getAmount();
                saleCrispyFlour += material.getRealMoney();
            }
        }
        differenceCrispyFlour = costCrispyFlour - saleCrispyFlour;
        System.out.println("Giá gốc bột: " + costCrispyFlour);
        System.out.println("Giá sale bột: " + saleCrispyFlour);
        System.out.println("Giá chênh lệch bột: " + differenceCrispyFlour);
        System.out.println("---------------------------------------------------");
    }

    public void inputAdd() {
        System.out.print("Nhập đối tượng muốn thêm thứ index: ");
        index = input.nextInt();
    }

    public void inputDel() {
        System.out.print("Nhập đối tượng muốn xóa thứ index: ");
        index = input.nextInt();
    }

    //xóa đối tượng
    public void deleteElement() {
        inputDel();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.remove(i);
            }
        }
        print();
        differenceMeat();
        differenceCrispyFlour();
    }

    //thêm đối tượng
    public void addElement(Material material) {
        inputAdd();
        for (int i = 0; i < materials.size(); i++) {
            if (i == index) {
                materials.add(i, material);
                print();
            } else if (index >= materials.size()) {
                materials.add(material);
                print();
                break;
            }
        }
        differenceMeat();
        differenceCrispyFlour();
    }
}
