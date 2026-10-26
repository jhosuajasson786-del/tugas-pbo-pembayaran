# Sistem Pembayaran Digital (Java OOP)

Proyek ini adalah implementasi tugas Pemrograman Berorientasi Objek (PBO) dalam bahasa Java yang menerapkan konsep:
- **Abstract Class & Abstract Method**
- **Interface**
- **Inheritance (Pewarisan)**
- **Polymorphism**
- **Input Interaktif Konsol (Interactive Menu / Home)**

## Struktur File
1. `BisaDiskon.java` -> Interface untuk kalkulasi diskon.
2. `MetodePembayaran.java` -> Abstract Class induk untuk seluruh metode pembayaran.
3. `KartuKredit.java` -> Subclass dari `MetodePembayaran` dan mengimplementasikan `BisaDiskon`.
4. `EWallet.java` -> Subclass dari `MetodePembayaran` dan mengimplementasikan `BisaDiskon`.
5. `Main.java` -> Kelas utama berisikan menu interaktif (*Home*) dan scanner input user.

## Cara Mengkompilasi & Menjalankan
1. Buka Terminal / Command Prompt di folder proyek.
2. Kompilasi seluruh file Java:
   ```bash
   javac *.java
   ```
3. Jalankan program utama:
   ```bash
   java Main
   ```
