package views;

import Exceptions.InvalidInputException;
import controllers.KendaraanController;
import models.BahanBakar;
import models.Kendaraan;
import util.CLIUtil;

public class KendaraanView {
    private KendaraanController kendaraanController;

    public KendaraanView() {
        this.kendaraanController = new KendaraanController();
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah kendaraan");
        System.out.println("2. Tampilkan semua kendaraan");
        System.out.println("3. Urutkan kendaraan berdasarkan kapasitas");
        System.out.println("0. Keluar");
    }

    public void render() {
        this.printMenu();
        int menu = CLIUtil.getInt();
        while (menu != 0) {
            switch (menu) {
                case 1:
                    handleTambahKendaraan();
                    break;
                case 2:
                    handlePrintKendaraan();
                    break;
                case 3:
                    handleSortKendaraan();
                    break;

                default:
                    break;
            }
        }

    }

    private void handleTambahKendaraan() {
        System.out
                .print("Tipe kendaraan: 1 = Mobil, 2 = Truk, 3 = Helikopter, 4 = Pesawat \nMasukkan Tipe Kendaraan: ");
        int tipe = CLIUtil.getInt();
        if (tipe > 4 || tipe < 1) {
            System.out.println("tipe kendaraan tidak valid");
            return;
        }

        CLIUtil.getString();
        System.out.print("Masukkan nama kendaraan: ");
        String nama = CLIUtil.getString();

        try {
            switch (tipe) {
                case 1:
                    int bahanBakarIndex = CLIUtil.askForInt("Masukkan tipe bahan bakar mobil: 1 = bensin, 2 = diesel");
                    BahanBakar bahanBakar;
                    if (bahanBakarIndex == 1) {
                        bahanBakar = BahanBakar.BENSIN;
                    } else if (bahanBakarIndex == 2) {
                        bahanBakar = BahanBakar.DIESEL;
                    } else {
                        System.out.println("Tipe bahan bakar tidak valid");
                        return;
                    }
                    int kapasitas = CLIUtil.askForInt("Masukkan kapasitas mobil: ");
                    this.kendaraanController.add(bahanBakar, kapasitas, nama);
                    break;
                case 2:
                    int jumlahRoda = CLIUtil.askForInt("Masukkan jumlah roda truk: ");
                    this.kendaraanController.add(nama, jumlahRoda);
                    break;
                case 3:
                    int kapasitasHeli = CLIUtil.askForInt("Masukkan kapasitas heli: ");
                    int jumlahBalingBaling = CLIUtil.askForInt("Masukkan jumlah baling-baling heli: ");
                    this.kendaraanController.add(kapasitasHeli, nama, jumlahBalingBaling);
                    break;
                case 4:
                    int kapasitasPesawat = CLIUtil.askForInt("Masukkan kapasitas pesawat: ");
                    int jumlahRodaPesawat = CLIUtil.askForInt("Masukkan jumlah roda pesawat: ");
                    int indeksPesawatTempur = CLIUtil.askForInt("Apakah pesawat tempur? 0 = tidak, lainnya = ya");
                    boolean pesawatTempur = indeksPesawatTempur == 0 ? false : true;
                    this.kendaraanController.add(kapasitasPesawat, nama, jumlahRodaPesawat, pesawatTempur);
                    break;

                default:
                    break;
            }
        } catch (InvalidInputException e) {
            System.out.println("gagal " + e.getMessage());
        }

    }

    private void handlePrintKendaraan() {
        var objects = this.kendaraanController.getAllKendaraan();
        for (Kendaraan kendaraan : objects) {
            System.out.println(kendaraan.getDetails());
        }
    }

    private void handleSortKendaraan() {
        this.kendaraanController.sortByKapasitas();
        System.out.println("Kendaraan telah diurutkan");
    }
}
