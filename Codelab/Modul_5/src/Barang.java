public class Barang {
    // Atribut private
    private String nama;
    private int stok;

    // Constructor
    public Barang(String nama, int stok) {
        this.nama = nama;
        this.stok = stok;
    }
    // Getter untuk mengambil nilai nama barang
    public String getNama() {
        return nama;
    }
    // Getter untuk mengambil nilai stok barang
    public int getStok() {
        return stok;
    }
    // Setter untuk mengubah nilai stok barang
    public void setStok(int stok) {
        this.stok = stok;
    }
    @Override
    public String toString(){
        String s = "Nama: " + nama + ", Stok: " + stok;
        return s;
    }
}