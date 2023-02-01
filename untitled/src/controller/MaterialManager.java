package controller;

import model.CrispyFlour;
import model.Material;
import model.Meat;
import java.util.ArrayList;
import java.util.List;

public class MaterialManager {
    //Data saving-------------------------------------------------------------
    public List<Material> materials;
    public MaterialManager() {
        materials = new ArrayList<>();
    }

    public MaterialManager(List<Material> materials) {
        this.materials = materials;
    }

    //CRUD Material----------------------------------------------------------
    public void addNewMaterial(Material material) {
       materials.add(material);
    }

    public void displayMaterials() {
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    public void editMaterial(String id, Material material) {
        for (Material o : materials) {
            if (o.getId().equals(id)) {
                if (o instanceof Meat){
                    o.setId(material.getId());
                    o.setName(material.getName());
                    o.setManufacturingDate(material.getManufacturingDate());
                    o.setCost(material.getCost());
                } else {
                    System.out.println("Vui lòng nhâp lại!!!");
                }
            }

        }
    }

    public void deleteMaterial() {
        materials.remove(materials.size()-1);
    }

    public double meatArbitrage() {
        double costMeat = 0;
        double saleMeat = 0;
        for (Material material : materials) {
            if (material instanceof Meat) {
                costMeat += material.getAmount();
                saleMeat += material.getRealMoney();
            }
        }
        return  costMeat - saleMeat;
    }

    public double powderArbitrage() {
        double costCrispyFlour = 0;
        double saleCrispyFlour = 0;
        for (Material material : materials) {
            if (material instanceof CrispyFlour) {
                costCrispyFlour += material.getAmount();
                saleCrispyFlour += material.getRealMoney();
            }
        }
         return costCrispyFlour - saleCrispyFlour;
    }
}
