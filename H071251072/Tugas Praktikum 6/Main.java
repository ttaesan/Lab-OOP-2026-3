import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class Main {
 
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library(
        new ArrayList<>(),
        new ArrayList<>(),
        new LibraryLogger()
    );

 
    static void printHeader() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    Sistem Manajemen Perpustakaan     ║");
        System.out.println("╚══════════════════════════════════════╝");
    }
 
    static void printSeparator() {
        System.out.println("──────────────────────────────────────");
    }
 
    static void printMenu() {
        printHeader();
        System.out.println();
        System.out.println("  1. Tambah Item");
        System.out.println("  2. Tambah Anggota");
        System.out.println("  3. Pinjam Item");
        System.out.println("  4. Kembalikan Item");
        System.out.println("  5. Lihat Status Perpustakaan");
        System.out.println("  6. Lihat Log Aktivitas");
        System.out.println("  7. Lihat Item yang Dipinjam Anggota");
        System.out.println("  8. Keluar");
        System.out.println();
        System.out.print("Pilih menu [1-8]: ");
    }
 
    static void success(String msg) {
        System.out.println(msg);
    }
 
    static void error(String msg) {
        System.out.println(msg);
    }
 
    static void info(String msg) {
        System.out.println(msg);
    }
 
    static String prompt(String label) {
        System.out.print(label);
        return scanner.nextLine().trim();
    }
 
    static int promptInt(String label) {
        while (true) {
            try {
                return Integer.parseInt(prompt(label));
            } catch (NumberFormatException e) {
                error("Input harus berupa angka. Coba lagi.");
            }
        }
    }

 
    static void menuTambahItem() {
        printHeader();
        printSeparator();
        System.out.println("Tambah Item Baru");
        printSeparator();
        System.out.println("  1. Buku");
        System.out.println("  2. DVD");
        System.out.println();
        int tipe = promptInt("Pilih tipe item [1-2]: ");
        if (tipe != 1 && tipe != 2) {
            error("Pilihan tidak valid.");
            return;
        }
 
        System.out.println();
        String judul = prompt("Judul          : ");
        int id = promptInt("ID Item        : ");
 
        if (tipe == 1) {
            String penulis = prompt("Penulis        : ");
            Book book = new Book(judul, id, false, penulis);
            System.out.println();
            String hasil = library.addItem(book);
            if (hasil.startsWith("Gagal")) error(hasil); else success(hasil);
        } else {
            int durasi = promptInt("Durasi (menit) : ");
            DVD dvd = new DVD(judul, id, false, durasi);
            System.out.println();
            String hasil = library.addItem(dvd);
            if (hasil.startsWith("Gagal")) error(hasil); else success(hasil);
        }
    }
 
    static void menuTambahAnggota() {
        printHeader();
        printSeparator();
        System.out.println("Tambah Anggota Baru");
        printSeparator();
        System.out.println();
 
        String nama = prompt("Nama Anggota   : ");
        int id = promptInt("ID Anggota     : ");
        Member member = new Member(nama, id, new ArrayList<>());
        System.out.println();
        String hasil = library.addMember(member);
        if (hasil.startsWith("Gagal")) error(hasil); else success(hasil);
 
    }
 
    static void menuPinjamItem() {
        printHeader();
        printSeparator();
        System.out.println("Pinjam Item");
        printSeparator();
 
        if (library.items.isEmpty()) {
            error("Belum ada item di perpustakaan.");
            return;
        }
        if (library.members.isEmpty()) {
            error("Belum ada anggota terdaftar.");
            return;
        }
 
        System.out.println();
        info("Daftar Anggota:");
        System.out.print(library.getMembersStatus());
        int idAnggota = promptInt("ID Anggota        : ");
 
        System.out.println();
        info("Daftar Item:");
        System.out.print(library.getLibraryStatus());
        int idItem = promptInt("ID Item           : ");
        int hari   = promptInt("Lama Pinjam (hari): ");
 
        System.out.println();
        try {
            Member member   = library.findMemberById(idAnggota);
            LibraryItem item = library.findItemById(idItem);
 
            if (item.isBorrowed) {
                error("Gagal meminjam: Item sedang dipinjam.");
            } else {
                member.borrow(item, hari);
                library.logger.logActivity(
                    member.name + " meminjam: " + item.getDescription() + " (" + hari + " hari)"
                );
            }
        } catch (NoSuchElementException e) {
            error(e.getMessage());
        }
    }
 
    static void menuKembalikanItem() {
        printHeader();
        printSeparator();
        System.out.println("Kembalikan Item");
        printSeparator();
 
        if (library.members.isEmpty()) {
            error("Belum ada anggota terdaftar.");
            return;
        }
 
        System.out.println();
        info("Daftar Anggota:");
        System.out.print(library.getMembersStatus());
        int idAnggota = promptInt("ID Anggota                : ");
 
        try {
            Member member = library.findMemberById(idAnggota);
 
            if (member.borrowedItems.isEmpty()) {
                System.out.println();
                error(member.name + " tidak memiliki item yang dipinjam.");
                return;
            }
 
            System.out.println();
            member.getBorrowedItems();
 
            int idItem    = promptInt("ID Item yang dikembalikan : ");
            int hariTelat = promptInt("Hari keterlambatan        : ");
 
            System.out.println();
            try {
                LibraryItem item = library.findItemById(idItem);
                member.returnItem(item, hariTelat);
                library.logger.logActivity(
                    member.name + " mengembalikan: " + item.title +
                    (hariTelat > 0 ? " (terlambat " + hariTelat + " hari)" : "")
                );
            } catch (NoSuchElementException e) {
                error(e.getMessage());
            }
 
        } catch (NoSuchElementException e) {
            error(e.getMessage());
        }
    }
 
    static void menuStatusPerpustakaan() {
        printHeader();
        printSeparator();
        System.out.println("Status Perpustakaan");
        printSeparator();
        System.out.println();
        System.out.print(library.getLibraryStatus());
 
        long tersedia = library.items.stream().filter(i -> !i.isBorrowed).count();
        long dipinjam = library.items.stream().filter(i ->  i.isBorrowed).count();
        System.out.println();
        info("Total Item    : " + library.items.size());
        info("Tersedia      : " + tersedia);
        info("Dipinjam      : " + dipinjam);
        info("Total Anggota : " + library.members.size());
 
    }
 
    static void menuLogAktivitas() {
        printHeader();
        printSeparator();
        System.out.println("Log Aktivitas");
        printSeparator();
        System.out.println();
        System.out.println(library.getAllLogs());
    }
 
    static void menuItemDipinjamAnggota() {
        printHeader();
        printSeparator();
        System.out.println("Item yang Dipinjam Anggota");
        printSeparator();
 
        if (library.members.isEmpty()) {
            System.out.println();
            error("Belum ada anggota terdaftar.");
            return;
        }
 
        System.out.println();
        info("Daftar Anggota:");
        System.out.print(library.getMembersStatus());
        int idAnggota = promptInt("ID Anggota: ");
 
        System.out.println();
        try {
            Member member = library.findMemberById(idAnggota);
            member.getBorrowedItems();
        } catch (NoSuchElementException e) {
            error(e.getMessage());
        }

    }
 
    public static void main(String[] args) {
        while (true) {
            printMenu();
 
            String input = scanner.nextLine().trim();
 
            switch (input) {
                case "1" : 
                    menuTambahItem();
                    continue;
                case "2" : 
                    menuTambahAnggota();
                    continue;
                case "3" : 
                    menuPinjamItem();
                    continue;
                case "4" : 
                    menuKembalikanItem();
                    continue;
                case "5" : 
                    menuStatusPerpustakaan();
                    continue;
                case "6" : 
                    menuLogAktivitas();
                    continue;
                case "7" : 
                    menuItemDipinjamAnggota();
                    continue;
                case "8" : {
                    System.out.println(" Terima kasih! Sampai jumpa.");
                    System.out.println();
                    return;
                }
                default : {
                    error("Pilihan tidak valid. Masukkan angka 1-8.");
                    try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                    System.out.println();
                }
            }
        }
    }
}