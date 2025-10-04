import java.util.Scanner;

public class KafeKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Data Menu
        String[] menu = {"Kopi", "Teh", "Roti"};
        double[] harga = {12000, 7000, 20000};
        
        while (true) {
            // Menu Utama
            System.out.println("\n--- KASIR KAFE ---");
            System.out.println("1. Buat Pesanan");
            System.out.println("2. Lihat Menu");
            System.out.println("3. Keluar");
            System.out.print("Pilih: ");
            
            int pilihan = scanner.nextInt();
            
            if (pilihan == 1) {
                // Proses Pesanan
                System.out.print("Nama Pelanggan: ");
                String nama = scanner.next();
                
                // Tampilkan Menu
                System.out.println("\nMenu:");
                for (int i = 0; i < menu.length; i++) {
                    System.out.printf("%d. %s (Rp %.0f)%n", 
                        i+1, menu[i], harga[i]);
                }
                
                // Hitung Total
                double total = 0;
                System.out.println("\nMasukkan Pesanan:");
                for (int i = 0; i < menu.length; i++) {
                    System.out.print(menu[i] + " (jumlah): ");
                    int jumlah = scanner.nextInt();
                    total += jumlah * harga[i];
                }
                
                // Cetak Struk
                System.out.println("\n--- STRUK ---");
                System.out.println("Nama: " + nama);
                System.out.printf("Total Bayar: Rp %.0f%n", total);
                System.out.println("Terima Kasih!");
                
            } else if (pilihan == 2) {
                // Tampilkan Daftar Menu
                System.out.println("\n--- DAFTAR MENU ---");
                for (int i = 0; i < menu.length; i++) {
                    System.out.printf("%s: Rp %.0f%n", menu[i], harga[i]);
                }
                
            } else if (pilihan == 3) {
                // Keluar
                System.out.println("Sampai Jumpa!");
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }
    
}

 