package views;

import controller.MaterialManager;
import model.CrispyFlour;
import model.Material;
import model.Meat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static List<Material> materials = new ArrayList<>();
    public static MaterialManager materialManager = new MaterialManager(materials);
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int checkInput;
        do {
            System.out.println("Menu--------------------------------------");
            System.out.println(
                    """
                                    1. Thêm vật liệu
                                    2. hiển thị danh sách vật liệu
                                    3. Sửa vật liệu
                                    4. Xóa vật liệu
                                    5. chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay
                                    0. Thoát khỏi chương trình
                            """);
            System.out.print("Mời bạn chọn: ");

            checkInput = Integer.parseInt(input.nextLine());
            switch (checkInput) {
                case 1 -> materialManager.addNewMaterial(createNewMaterial());

                case 2 -> {
                    System.out.println("danh sách vật liệu: ");
                    materialManager.displayMaterials();
                }
//                case 3 -> materialManager.editMaterial();
                case 4 -> materialManager.deleteMaterial();
                case 5 -> {
                    System.out.println("chênh lệch giữa chiết khấu và không chiết khấu tại ngày hôm nay là: ");
                    System.out.println("Chênh lệch của thịt: "+ materialManager.meatArbitrage());
                    System.out.println("Chênh lệch của bột: "+ materialManager.powderArbitrage());
                }
                case 0 -> System.exit(checkInput);
                default -> System.out.println("Vui lòng nhập lại!!!");
            }
        } while (true);
    }

    public static Material createNewMaterial() {
        System.out.print("Bạn muốn thêm sp ?\n thịt hoặc bột: ");
        String check = input.nextLine();
        if (check.equalsIgnoreCase("thịt")) {
            System.out.print("Nhập id thịt: ");
            String idMeat = input.nextLine();
            System.out.print("Nhập tên : ");
            String nameMeat = input.nextLine();
            LocalDate dayMeat = LocalDate.now();
            System.out.print("Nhập giá : ");
            double priceMeat = Double.parseDouble(input.nextLine());
            System.out.print("Nhập cân nặng : ");
            double weightMeat = Double.parseDouble(input.nextLine());
            return new Meat(idMeat, nameMeat, dayMeat, (int) priceMeat, weightMeat);
        } else {
            System.out.print("Nhập id bột: ");
            String id = input.nextLine();
            System.out.print("Nhập tên : ");
            String name = input.nextLine();
            LocalDate day = LocalDate.now();
            System.out.print("Nhập giá : ");
            double price = Double.parseDouble(input.nextLine());
            System.out.print("Nhập số lượng : ");
            double quantity = Double.parseDouble(input.nextLine());
            return new CrispyFlour(id, name, day, (int) price, quantity);
        }
    }
}
