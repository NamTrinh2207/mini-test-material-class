package run;

import material.CrispyFlour;
import material.Meat;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        materialManager.print();
        materialManager.differenceMeat();
        materialManager.differenceCrispyFlour();
        materialManager.deleteElement();
        materialManager.addElement(new CrispyFlour("10", "Bột 5", LocalDate.now().plusDays(1), 100, 1));
        materialManager.editElement(new Meat("10000", "Thịt 500", LocalDate.now().plusDays(5), 50, 1));
    }
}
