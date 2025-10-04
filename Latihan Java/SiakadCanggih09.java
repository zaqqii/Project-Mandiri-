import java.util.Scanner;

public class SiakadCanggih09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
        System.out.print("Masukkan jumlah mata kuliah: ");
        int jumlahMatkul = sc.nextInt();

        String[] namaMahasiswa = new String[jumlahMahasiswa];
        String[] nimMahasiswa = new String[jumlahMahasiswa];
        char[] kelasMahasiswa = new char[jumlahMahasiswa];
        int[][] nilaiMahasiswa = new int[jumlahMahasiswa][jumlahMatkul];
        double[] rataRataMahasiswa = new double[jumlahMahasiswa];

        sc.nextLine(); // Clear buffer

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nInput data untuk Mahasiswa ke-" + (i + 1));
            System.out.print("Nama: ");
            namaMahasiswa[i] = sc.nextLine();
            System.out.print("NIM: ");
            nimMahasiswa[i] = sc.nextLine();
            System.out.print("Kelas: ");
            kelasMahasiswa[i] = sc.nextLine().charAt(0);

            double totalNilai = 0;
            for (int j = 0; j < jumlahMatkul; j++) {
                System.out.print("Nilai Mata Kuliah " + (j + 1) + ": ");
                nilaiMahasiswa[i][j] = sc.nextInt();
                totalNilai += nilaiMahasiswa[i][j];
            }
            rataRataMahasiswa[i] = totalNilai / jumlahMatkul;
            sc.nextLine(); // Clear buffer
        }

        System.out.println("\n========================================================================================= ");
        System.out.println("Rata-rata dan Kualifikasi Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            String kualifikasi = getKualifikasi(rataRataMahasiswa[i]);
            System.out.println("Mahasiswa: " + namaMahasiswa[i] + " (NIM: " + nimMahasiswa[i] + ")");
            System.out.println("Kelas: " + kelasMahasiswa[i] + " | Rata-rata: " + rataRataMahasiswa[i] + " | Kualifikasi: " + kualifikasi);
        }

        System.out.println("\n========================================================================================= ");
        System.out.println("Rata-rata Nilai setiap Mata Kuliah:");
        for (int j = 0; j < jumlahMatkul; j++) {
            double totalPerMatkul = 0;
            for (int i = 0; i < jumlahMahasiswa; i++) {
                totalPerMatkul += nilaiMahasiswa[i][j];
            }
            System.out.println("Mata Kuliah " + (j + 1) + ": " + (totalPerMatkul / jumlahMahasiswa));
        }

        sc.close();
    }

    private static String getKualifikasi(double nilai) {
        if (nilai >= 81) return "Sangat Baik (A)";
        else if (nilai >= 74) return "Baik (B+)";
        else if (nilai >= 66) return "Cukup Baik (B)";
        else if (nilai >= 61) return "Cukup (C+)";
        else if (nilai >= 51) return "Kurang (C)";
        else if (nilai >= 40) return "Sangat Kurang (D)";
        else return "Gagal (E)";
    }
}
    

