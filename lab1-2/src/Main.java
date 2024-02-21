public class Main {
    public static void main(String[] args) {
        int[] arr={15,99,75,77,6,40,85,15,52,62};
        int s=0;
        for (int j : arr) {
            s += j;
        }
        System.out.println("media="+(s/ arr.length));
    }
}