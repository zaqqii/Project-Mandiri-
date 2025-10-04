public class faktorial {
    public static void main(String[] args) {
        System.out.println(faktorialRekuatif(5));
    }
    static int faktorialRekursif(int n){
        if (n == 0) {
            return (1);
        } else {
            return (n * faktorialRekursif(n - 1));
        
        }
    }
}