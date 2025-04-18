// Program simulasi pertarungan antara karakter pahlawan dan penjahat

public class Main {
    public static void main(String[] args) {
        // Membuat objek KarakterGame "Karakter Umum" dengan kesehatan 100
        KarakterGame karakterUmum = new KarakterGame("Karakter Umum", 100);

        // Membuat objek Pahlawan dengan nama "Hulk" dan kesehatan 150
        Pahlawan hulk = new Pahlawan("Hulk", 150);

        // Membuat objek Musuh dengan nama "Thanos" dan kesehatan 200
        Musuh thanos = new Musuh("Thanos", 200);

        // Menampilkan status awal Pahlawan dan Musuh
        System.out.println("=== Status Awal Pertarungan ===");
        System.out.println(hulk.getNama() + " memiliki kesehatan: " + hulk.getKesehatan());
        System.out.println(thanos.getNama() + " memiliki kesehatan: " + thanos.getKesehatan());
        System.out.println("--------------------------------");

        // Simulasi serangan: Hulk menyerang Thanos
        hulk.serang(thanos);
        System.out.println();

        // Simulasi serangan balasan: Thanos menyerang Hulk
        thanos.serang(hulk);
    }
}

class KarakterGame {
    private String nama;      // Nama karakter
    private int kesehatan;    // Nilai kesehatan karakter

    // Konstruktor untuk menginisialisasi nama dan kesehatan
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Getter untuk kesehatan
    public int getKesehatan() {
        return kesehatan;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Setter untuk kesehatan
    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    // Method untuk mengurangi kesehatan karakter.
    // Menggunakan Math.max untuk mencegah kesehatan menjadi negatif.
    public void kurangiKesehatan(int damage) {
        this.kesehatan = Math.max(this.kesehatan - damage, 0);
    }

    // Method serang dasar yang nantinya akan di-override oleh subclass
    public void serang(KarakterGame target) {
        System.out.println(nama + " melakukan serangan dasar.");
    }
}

//Implementasi serangan untuk pahlawan.
class Pahlawan extends KarakterGame {
    // Konstanta untuk nilai damage serangan pahlawan
    private static final int DAMAGE = 20;

    // Konstruktor yang memanggil konstruktor superclass
    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang untuk menampilkan pesan serangan dan mengurangi kesehatan target
    @Override
    public void serang(KarakterGame target) {
        // Menampilkan pesan serangan khas untuk Hulk
        System.out.println(getNama() + " menghantam " + target.getNama() +
                " dengan pukulan dahsyat penuh kekuatan!");

        // Mengurangi kesehatan target menggunakan method 'kurangiKesehatan'
        target.kurangiKesehatan(DAMAGE);

        // Menampilkan kesehatan target setelah serangan
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}

//Implementasi serangan untuk penjahat.
class Musuh extends KarakterGame {
    // Konstanta untuk nilai damage serangan musuh
    private static final int DAMAGE = 15;

    // Konstruktor yang memanggil konstruktor superclass
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    // Override method serang untuk menampilkan pesan serangan dan mengurangi kesehatan target
    @Override
    public void serang(KarakterGame target) {
        // Menampilkan pesan serangan khas untuk Thanos
        System.out.println(getNama() + " melancarkan tendangan mematikan yang mengguncang " +
                target.getNama() + "!");

        // Mengurangi kesehatan target menggunakan method 'kurangiKesehatan'
        target.kurangiKesehatan(DAMAGE);

        // Menampilkan kesehatan target setelah diserang
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan());
    }
}