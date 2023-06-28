package models;

import java.util.Objects;

public class Costs {
    private String date;
    private String name;
    private int price;

    public Costs(String date, String name, int price) {
        this.date = date;
        this.name = name;
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Costs costs = (Costs) o;
        return price == costs.price && Objects.equals(date, costs.date) && Objects.equals(name, costs.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, price);
    }

    @Override
    public String toString() {
        return "| " + this.date + " | " +
                "| " + this.name + " |" +
                "| " + this.price + " грн |";
    }
}
