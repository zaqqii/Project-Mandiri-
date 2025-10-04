import java.util.Scanner;

public class cobaja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();

        String[] namaMahasiswa = new String[jumlahMahasiswa];
        String[] nimMahasiswa = new String[jumlahMahasiswa];
        char[] kelasMahasiswa = new char[jumlahMahasiswa];
        double[] rataRataMahasiswa = new double[jumlahMahasiswa];
        double[] nilaiIPKMahasiswa = new double[jumlahMahasiswa];

        sc.nextLine(); // Clear buffer

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nInput data untuk Mahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            namaMahasiswa[i] = sc.nextLine();
            System.out.print("NIM: ");
            nimMahasiswa[i] = sc.nextLine();
            System.out.print("Kelas: ");
            kelasMahasiswa[i] = sc.nextLine().charAt(0);

            // Input manual nilai UTS, UAS, Tugas
            double nilaiUTS, nilaiUAS, nilaiTugas;
            System.out.println("Masukkan nilai secara manual untuk mahasiswa ini:");
            System.out.print("Nilai UTS: ");
            nilaiUTS = sc.nextDouble();
            System.out.print("Nilai UAS: ");
            nilaiUAS = sc.nextDouble();
            System.out.print("Nilai Tugas: ");
            nilaiTugas = sc.nextDouble();

            // Hitung rata-rata nilai
            rataRataMahasiswa[i] = (nilaiUTS + nilaiUAS + nilaiTugas) / 3;

            // Hitung IPK dengan konversi nilai rata-rata ke IPK
            nilaiIPKMahasiswa[i] = getNilaiIPK(rataRataMahasiswa[i]);

            sc.nextLine(); // Clear buffer
        }

        System.out.println("\n============================ ");
        System.out.println("Data Mahasiswa dengan Nilai Akhir:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            String kualifikasi = getKualifikasi(rataRataMahasiswa[i]);
            System.out.println("Mahasiswa: " + namaMahasiswa[i] + " (NIM: " + nimMahasiswa[i] + ")");
            System.out.println("Kelas: " + kelasMahasiswa[i] + " | Rata-rata: " + rataRataMahasiswa[i] + " | Kualifikasi: " + kualifikasi + " | IPK: " + String.format("%.2f", nilaiIPKMahasiswa[i]));
        }

        System.out.println("\n============================ ");
        System.out.println("Rata-rata IPK Kelas:");
        double totalIPK = 0;
        for (double ipk : nilaiIPKMahasiswa) {
            totalIPK += ipk;
        }
        System.out.println("IPK Kumulatif Kelas: " + String.format("%.2f", (totalIPK / jumlahMahasiswa)));

        sc.close();
    }

    // Kualifikasi berdasarkan rata-rata nilai
    private static String getKualifikasi(double nilai) {
        if (nilai >= 81) return "Sangat Baik (A)";
        else if (nilai >= 74) return "Baik (B+)";
        else if (nilai >= 66) return "Cukup Baik (B)";
        else if (nilai >= 61) return "Cukup (C+)";
        else if (nilai >= 51) return "Kurang (C)";
        else if (nilai >= 40) return "Sangat Kurang (D)";
        else return "Gagal (E)";
    }

    // Konversi nilai rata-rata ke IPK
    private static double getNilaiIPK(double nilai) {
        if (nilai >= 81) return 4.0;
        else if (nilai >= 74) return 3.5;
        else if (nilai >= 66) return 3.0;
        else if (nilai >= 61) return 2.5;
        else if (nilai >= 51) return 2.0;
        else if (nilai >= 40) return 1.0;
        else return 0.0;
    }
}