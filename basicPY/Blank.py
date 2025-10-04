daftar_data = [
    {"nama": "Andi", "id": "S01", "tugas": 80, "kuis": 75, "ujian": 90},
    {"nama": "Budi", "id": "S02", "tugas": 70, "kuis": 85, "ujian": 78},
    {"nama": "Citra", "id": "S03", "tugas": 95, "kuis": 88, "ujian": 92},
    {"nama": "Andi", "id": "S04", "tugas": 60, "kuis": 70, "ujian": 65},  # Nama duplikat
]

daftar_nama = set()
data_siswa = []

def hitung_rata(tugas, kuis, ujian):
    return round((tugas * 0.3 + kuis * 0.3 + ujian * 0.4), 2)

def tentukan_predikat(nilai):
    if nilai >= 85:
        return "A"
    elif nilai >= 70:
        return "B"
    elif nilai >= 60:
        return "C"
    elif nilai >= 50:
        return "D"
    else:
        return "E"

class Siswa:
    def __init__(self, nama, id, tugas, kuis, ujian):
        self.nama = nama
        self.id_siswa = id
        self.tugas = tugas
        self.kuis = kuis
        self.ujian = ujian
        self.nilai_akhir = hitung_rata(tugas, kuis, ujian)
        self.predikat = tentukan_predikat(self.nilai_akhir)

    def tampilkan(self):
        print(f"[{self.id_siswa}] {self.nama}")
        print(f"  Tugas: {self.tugas}, Kuis: {self.kuis}, Ujian: {self.ujian}")
        print(f"  Nilai Akhir: {self.nilai_akhir} | Predikat: {self.predikat}")

# Proses data
for data in daftar_data:
    try:
        if data["nama"] in daftar_nama:
            print(f"\nlewati {data['nama']} sudah ada, melewati...")
            continue

        siswa = Siswa(data["nama"], data["id"], data["tugas"], data["kuis"], data["ujian"])
        data_siswa.append(siswa)
        daftar_nama.add(data["nama"])
    except KeyError:
        print("Data siswa tidak lengkap!")
    except Exception as e:
        print(f"Terjadi error: {e}")
        
print("\n=== Rekap Nilai ===")
for siswa in data_siswa:
    siswa.tampilkan()

if data_siswa:
    total = sum([siswa.nilai_akhir for siswa in data_siswa])
    rata_kelas = total / len(data_siswa)
    print(f"\n>> Rata-rata kelas: {round(rata_kelas, 2)}")
else:
    print("Tidak ada data siswa valid.")
    print ("Tidak ada data siswa valid.")



            
            
                
    

       
        
   




  