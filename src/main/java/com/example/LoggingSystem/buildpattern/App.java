package com.example.LoggingSystem.buildpattern;

public class App {
    public static void main(String args[]){
            //Post post = new Post.Builder()
                    //.text("Builder Pattern")
                    //.title("title ....")
                    //.category("java Programming")
                    //.build();
            //System.out.println(post);

            Product car = new Product.ProductBuilder("car_1","Mazda","Sedane", 28000.0)
                    .brand("Toyota")
                    .horsepower(400)
                    .build();
            System.out.println(car);

            Product tv = new Product.ProductBuilder("tv_1","Sumusung", "FlatScreen",3000.0)
                    .brand("Sumsung")
                    .screensize(70.0)
                    .build();
            System.out.println(tv);

            Product laptop = new Product.ProductBuilder("lpa_2", "Dell", "laptop", 7000.0)
                    .brand("Dell")
                    .screensize(4.5)
                    .build();
            System.out.println(laptop);
    }
}
