package material;

import java.time.LocalDate;

public class CrispyFlour extends Material {
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getRealMoney() {
        return 0;
    }

    @Override
    public double getAmount() {
        return this.quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return manufacturingDate.plusYears(1);
    }

    @Override
    public String toString() {
        return "Bột mỳ : " +
                "số lượng=" + quantity +
                ",mã='" + id + '\'' +
                ", tên='" + name + '\'' +
                ", ngày sản xuất=" + manufacturingDate +
                ", số lượng=" + cost;
    }
}
