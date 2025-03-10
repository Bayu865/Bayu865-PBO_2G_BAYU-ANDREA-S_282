import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Meminta input dari pengguna
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Jenis Kelamin (P/L): ");
        char jenisKelamin = scanner.next().charAt(0);

        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = scanner.nextInt();

        // Menghitung umur berdasarkan tahun lahir
        int umur = LocalDate.now().getYear() - tahunLahir;

        // Menutup scanner
        scanner.close();

        // Menentukan jenis kelamin dan menampilkan hasil
        String jenisKelaminString = (jenisKelamin == 'L' || jenisKelamin == 'l') ? "Laki-laki" :
                (jenisKelamin == 'P' || jenisKelamin == 'p') ? "Perempuan" :
                        "Tidak diketahui";

        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminString);
        System.out.println("Umur: " + umur + " tahun");
    }
}