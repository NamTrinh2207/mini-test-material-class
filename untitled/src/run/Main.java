package run;

import material.CrispyFlour;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager materialManager = new MaterialManager();
        materialManager.print();
        materialManager.differenceMeat();
        materialManager.differenceCrispyFlour();
        materialManager.deleteElement();
        materialManager.addElement(new CrispyFlour("10", "Bột 5", LocalDate.now().plusDays(5), 100, 1));
    }
}
