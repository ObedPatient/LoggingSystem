package com.example.LoggingSystem.buildpattern;

public class Product {
    private final String id;
    private final String name;
    private final String category;
    private final double price;
    private final String brand;
    private final Integer horsepower;
    private final Double screensize;
    private final String size;

    private Product(ProductBuilder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.category = builder.category;
        this.price = builder.price;
        this.brand = builder.brand;
        this.horsepower = builder.horsepower;
        this.screensize = builder.screensize;
        this.size = builder.size;
    }

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Double getScreensize() {
        return screensize;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", horsepower=" + horsepower +
                ", screensize=" + screensize +
                ", size='" + size + '\'' +
                '}';
    }

    public static class ProductBuilder{
        private String id;
        private String name;
        private String category;
        private double price;
        private String brand;
        private Integer horsepower;
        private Double screensize;
        private String size;

        // required Fields
        public ProductBuilder(String id, String name, String category, double price){
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        // optional fields
        public ProductBuilder brand(String brand){
            this.brand = brand;
            return this;
        }

        public ProductBuilder horsepower(Integer horsepower){
            this.horsepower = horsepower;
            return this;
        }

        public ProductBuilder screensize(double screensize){
            this.screensize = screensize;
            return this;
        }

        public ProductBuilder size(String size){
            this.size = size;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }




}
