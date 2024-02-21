public class MyOwnAutoShop {
    public static void main(String[] args) {
        Sedan s = new Sedan(280,  14700.99, "rosu",14);
        Ford f1 = new Ford(260,24900.75,"gri",2020,700);
        Ford f2 = new Ford(300,31100.86,"negru",2022,450);
        Car c = new Car(270,18900.32,"albastru");

        System.out.println("sedan price: "+s.getSalePrice());
        System.out.println("ford 1 price: "+f1.getSalePrice());
        System.out.println("ford 2 price: "+f2.getSalePrice());
        System.out.println("car price: "+c.getSalePrice());
    }
}
