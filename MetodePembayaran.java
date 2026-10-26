// Abstract class sebagai basis metode pembayaran (Inheritance)
public abstract class MetodePembayaran {
    protected String namaPengguna;
    protected double saldoOrLimit;

    // Constructor
    public MetodePembayaran(String namaPengguna, double saldoOrLimit) {
        this.namaPengguna = namaPengguna;
        this.saldoOrLimit = saldoOrLimit;
    }

    // Abstract Method: Wajib di-override oleh subclass (Polymorphism)
    public abstract boolean prosesPembayaran(double jumlah);

    // Concrete Method
    public void tampilkanInfo() {
        System.out.println("Nama Pengguna       : " + namaPengguna);
        System.out.printf("Saldo/Limit Tersedia: Rp %,.2f\n", saldoOrLimit);
    }

    // Getter untuk saldo
    public double getSaldoOrLimit() {
        return saldoOrLimit;
    }
}
