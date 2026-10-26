// Subclass EWallet mewarisi MetodePembayaran dan mengimplementasikan BisaDiskon
public class EWallet extends MetodePembayaran implements BisaDiskon {
    private String nomorTelepon;

    public EWallet(String namaPengguna, double saldoOrLimit, String nomorTelepon) {
        super(namaPengguna, saldoOrLimit);
        this.nomorTelepon = nomorTelepon;
    }

    @Override
    public boolean prosesPembayaran(double jumlah) {
        double totalBayar = hitungDiskon(jumlah);
        System.out.printf("Diskon E-Wallet (15%%): Rp %,.2f\n", (jumlah - totalBayar));
        System.out.printf("Total Tagihan Setelah Diskon: Rp %,.2f\n", totalBayar);
        
        if (saldoOrLimit >= totalBayar) {
            saldoOrLimit -= totalBayar;
            System.out.println("[STATUS] Pembayaran via E-Wallet BERHASIL!");
            System.out.printf("Sisa Saldo E-Wallet: Rp %,.2f\n", saldoOrLimit);
            return true;
        } else {
            System.out.println("[STATUS] Pembayaran GAGAL! Saldo e-wallet tidak mencukupi.");
            return false;
        }
    }

    @Override
    public double hitungDiskon(double total) {
        // E-Wallet diskon 15%
        return total * 0.85;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }
}
