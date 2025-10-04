import java.util.Scanner;

public class KafePilihan {
    public static void main(String[] args) {
        
        String[] menu = {"Tidak Pesan Makanan", "Nasi Goreng", "Kentang Goreng", "Roti Bakar", "Tidak Pesan Minuman", "Kopi", "Teh", "Cappuccino"};
        double[] harga = {0, 20000, 15000, 18000, 0, 12000, 7000, 15000};

        // Pesanan disimpan dalam array satu dimensi
        int[] jumlahPesanan = new int[menu.length];

        Scanner sc = new Scanner(System.in);
        boolean transaksiBerjalan = true;
        boolean keanggotaan = false;

        
        System.out.print("Apakah Anda anggota? (true/false): ");
        keanggotaan = sc.nextBoolean();
        sc.nextLine();

        while (transaksiBerjalan) {

            System.out.println("\n--- Menu Utama ---");
            System.out.println("1. Cari Menu");
            System.out.println("2. Pesan Menu");
            System.out.println("3. Tampilkan Pesanan");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1: 
                    System.out.print("Masukkan nama makanan atau minuman: ");
                    String cari = sc.nextLine();
                    boolean ditemukan = false;

                    for (String m : menu) {
                        if (m.equalsIgnoreCase(cari)) {
                            ditemukan = true;
                            System.out.println("Menu " + cari + " tersedia.");
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Menu tidak ditemukan.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Menu ---");
                    for (int i = 0; i < menu.length; i++) {
                        System.out.println(i + ". " + menu[i] + " - Rp" + harga[i]);
                    }
                    System.out.print("Masukkan angka menu yang ingin dipesan (jika lebih dari 1, gunakan spasi untuk memisahkan): ");
                    String input = sc.nextLine();
                    String[] pilihanMenu = input.split(" ");

                    for (String m : pilihanMenu) {
                        int idx = Integer.parseInt(m);
                        if (idx >= 0 && idx < menu.length) {
                            jumlahPesanan[idx]++;
                        } else {
                            System.out.println("Pilihan menu tidak valid: " + idx);
                        }
                    }

                    System.out.println("Pesanan Anda telah ditambahkan.");
                    break;

                case 3: 
                    System.out.println("\n--- Rincian Pesanan Anda ---");
                    double totalHarga = 0;

                    for (int i = 0; i < menu.length; i++) {
                        if (jumlahPesanan[i] > 0) {
                            double subtotal = jumlahPesanan[i] * harga[i];
                            System.out.println(menu[i] + " x " + jumlahPesanan[i] + " - Rp" + subtotal);
                            totalHarga += subtotal;
                        }
                    }

                    if (keanggotaan) {
                        totalHarga *= 0.9;
                    }

                    System.out.println("\nTotal harga: Rp" + totalHarga);
                    break;

                case 4: 
                    System.out.println("Terima kasih telah berkunjung!");
                    transaksiBerjalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        sc.close();
    }
}