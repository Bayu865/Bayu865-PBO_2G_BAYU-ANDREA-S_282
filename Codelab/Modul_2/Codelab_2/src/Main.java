// Kelas RekeningBank
class RekeningBank {
    String nomorRekening; // Atribut nomor rekening
    String namaPemilik; // Atribut nama pemilik
    double saldoRekening; // Atribut saldo

    // Constructor untuk inisialisasi atribut
    RekeningBank(String nomorRekening, String namaPemilik, double saldoRekening) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldoRekening = saldoRekening;
    }

    // Metode untuk menampilkan informasi rekening
    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo Rekening: Rp" + saldoRekening);
        System.out.println(); // Baris kosong sebagai pemisah
    }

    // Metode untuk setor uang
    void setorUang(double jumlah) {
        saldoRekening += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldoRekening);
    }

    // Metode untuk tarik uang
    void tarikUang(double jumlah) {
        if (saldoRekening >= jumlah) {
            saldoRekening -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". Saldo sekarang: Rp" + saldoRekening);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldoRekening);
        }
    }
}

// Kelas Main
public class Main {
    public static void main(String[] args) {
        // Membuat objek RekeningBank pertama
        RekeningBank rekening1 = new RekeningBank("202410370110282", "Bayu", 400000.0);

        // Membuat objek RekeningBank kedua
        RekeningBank rekening2 = new RekeningBank("202410370110278", "Dafi", 500000.0);

        // Menampilkan informasi awal kedua rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan transaksi pada rekening1 dan rekening2
        rekening1.setorUang(100000.0);
        rekening2.setorUang(500000.0);

        rekening1.tarikUang(900000.0); // Saldo tidak mencukupi
        rekening2.tarikUang(400000.0); // Saldo mencukupi
        System.out.println(); // Baris kosong sebagai pemisah

        // Menampilkan informasi akhir kedua rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
