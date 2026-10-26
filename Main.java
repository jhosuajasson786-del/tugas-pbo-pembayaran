import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("==================================================");
        System.out.println("   SELAMAT DATANG DI SISTEM PEMBAYARAN DIGITAL    ");
        System.out.println("==================================================");
        
        System.out.print("Masukkan Nama Anda: ");
        String nama = scanner.nextLine();
        
        // Pilihan Metode Pembayaran
        System.out.println("\nPilih Metode Pembayaran:");
        System.out.println("1. Kartu Kredit (Diskon 10%)");
        System.out.println("2. E-Wallet     (Diskon 15%)");
        System.out.print("Pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        // Variabel deklarasi menggunakan tipe Abstract Class (Polymorphism)
        MetodePembayaran metodePembayaran = null;
        
        if (pilihan == 1) {
            System.out.print("Masukkan Nomor Kartu Kredit: ");
            String nomorKartu = scanner.nextLine();
            System.out.print("Masukkan Limit Kartu Kredit (Rp): ");
            double limit = scanner.nextDouble();
            
            // Instansiasi subclass KartuKredit
            metodePembayaran = new KartuKredit(nama, limit, nomorKartu);
            
        } else if (pilihan == 2) {
            System.out.print("Masukkan Nomor HP E-Wallet: ");
            String noHP = scanner.nextLine();
            System.out.print("Masukkan Saldo E-Wallet (Rp): ");
            double saldo = scanner.nextDouble();
            
            // Instansiasi subclass EWallet
            metodePembayaran = new EWallet(nama, saldo, noHP);
            
        } else {
            System.out.println("Pilihan tidak valid. Program berhenti.");
            scanner.close();
            return;
        }

        // Tampilan Menu Utama / Home Sederhana
        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n==================================================");
            System.out.println("                  MENU UTAMA                      ");
            System.out.println("==================================================");
            System.out.println("1. Lihat Informasi Akun Pembayaran");
            System.out.println("2. Lakukan Transaksi Pembayaran");
            System.out.println("3. Keluar / Exit");
            System.out.print("Pilih Menu (1-3): ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("\n--- INFORMASI AKUN ---");
                    metodePembayaran.tampilkanInfo();
                    break;

                case 2:
                    System.out.println("\n--- TRANSAKSI PEMBAYARAN ---");
                    System.out.print("Masukkan Total Belanja (Rp): ");
                    double totalBelanja = scanner.nextDouble();
                    
                    if (totalBelanja <= 0) {
                        System.out.println("Total belanja harus lebih besar dari 0.");
                    } else {
                        // Memanggil proses pembayaran (Dynamic Polymorphism)
                        metodePembayaran.prosesPembayaran(totalBelanja);
                    }
                    break;

                case 3:
                    System.out.println("\nTerima kasih telah menggunakan Sistem Pembayaran Digital!");
                    berjalan = false;
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid. Silakan coba lagi.");
            }
        }
        
        scanner.close();
    }
}
