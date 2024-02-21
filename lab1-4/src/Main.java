public class Main {
    public static void main(String[] args) {
        Persoana p1= new Persoana();

        p1.setNume("Popescu");
        p1.setPrenume("Ion");
        p1.setVarsta(30);

        System.out.println(p1.getNume()+" "+p1.getPrenume()+", "+p1.getVarsta());
    }
}