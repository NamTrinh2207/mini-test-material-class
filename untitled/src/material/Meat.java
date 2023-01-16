package material;

import java.time.LocalDate;

public class Meat extends Material {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        return 0;
    }

    @Override
    public double getAmount() {
        return getCost() * getWeight();
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public String toString() {
        return "Thịt: " +
                "Nặng=" + weight +
                ", mã='" + id + '\'' +
                ", Tên='" + name + '\'' +
                ", Ngày sản xuất=" + manufacturingDate +
                ", giá=" + cost;
    }
}
