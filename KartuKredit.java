// Subclass KartuKredit mewarisi MetodePembayaran dan mengimplementasikan BisaDiskon
public class KartuKredit extends MetodePembayaran implements BisaDiskon {
    private String nomorKartu;

    public KartuKredit(String namaPengguna, double saldoOrLimit, String nomorKartu) {
        super(namaPengguna, saldoOrLimit);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public boolean prosesPembayaran(double jumlah) {
        double totalBayar = hitungDiskon(jumlah);
        System.out.printf("Diskon Kartu Kredit (10%%): Rp %,.2f\n", (jumlah - totalBayar));
        System.out.printf("Total Tagihan Setelah Diskon: Rp %,.2f\n", totalBayar);
        
        if (saldoOrLimit >= totalBayar) {
            saldoOrLimit -= totalBayar;
            System.out.println("[STATUS] Pembayaran via Kartu Kredit BERHASIL!");
            System.out.printf("Sisa Limit Kartu: Rp %,.2f\n", saldoOrLimit);
            return true;
        } else {
            System.out.println("[STATUS] Pembayaran GAGAL! Limit kartu kredit tidak mencukupi.");
            return false;
        }
    }

    @Override
    public double hitungDiskon(double total) {
        // Kartu kredit diskon 10%
        return total * 0.90;
    }

    public String getNomorKartu() {
        return nomorKartu;
    }
}
