import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Mahasiswa {
    String nim;
    String nama;
    double nilaiTugas;
    double nilaiMatkul;
    double rataRata;
    String grade;

    public Mahasiswa(String nim, String nama, double nilaiUTS, double nilaiUAS) {
        this.nim = nim;
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiMatkul = nilaiMatkul;
        this.rataRata = (nilaiTugas + nilaiMatkul) / 2;
        this.grade = hitungGrade();
    }

    private String hitungGrade() {
        if (rataRata >= 95 && rataRata <= 100) {
            return "A";
        } else if (rataRata >= 80 && rataRata < 95) {
            return "B";
        } else if (rataRata >= 65 && rataRata < 80) {
            return "C";
        } else if (rataRata >= 40 && rataRata < 65) {
            return "D";
        } else {
            return "E"; // Nilai di bawah 40
        }
    }

    
    public String toString() {
        return "NIM: " + nim + ", Nama: " + nama + ", Nilai Tugas: " + nilaiTugas +
                ", Nilai Matkul: " + nilaiMatkul + ", Rata-rata: " + rataRata + ", Grade: " + grade;
    }
}

public class SIKAD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        List<Mahasiswa> dataMahasiswa = new ArrayList<>();
        double totalNilaiMatkul = 0;
        double nilaimatkul = 0;
        double nilaitugas = 0;
        double ratarataMatkul = 0;

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("NIM: ");
            String nim = scanner.nextLine();
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("Nilai Tugas: ");
            double nilaiUTS = scanner.nextDouble();
            System.out.print("Nilai Matkul: ");
            double nilaiUAS = scanner.nextDouble();
            scanner.nextLine(); // Membersihkan newline

            Mahasiswa mhs = new Mahasiswa(nim, nama,nilaitugas, nilaimatkul);
            dataMahasiswa.add(mhs);
            totalNilaiMatkul += nilaimatkul;
        }

        System.out.println("\nData Mahasiswa:");
        for (Mahasiswa mhs : dataMahasiswa) {
            System.out.println(mhs);
        }

        double rataRataMatkul = totalNilaiMatkul / jumlahMahasiswa;
        System.out.printf("\nRata-rata nilai Matkul: %.2f\n", ratarataMatkul);
        
        scanner.close();
    }
}
    
