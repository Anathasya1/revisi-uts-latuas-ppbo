package controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Exceptions.InvalidInputException;
import models.BahanBakar;
import models.Helikopter;
import models.Kendaraan;
import models.Mobil;
import models.Pesawat;
import models.Truk;

public class KendaraanController {
    private List<Kendaraan> listKendaraan;

    public KendaraanController(){
        this.listKendaraan = new ArrayList<>();
    }

    public void sortByKapasitas(){
        this.listKendaraan.sort(new Comparator<Kendaraan>() {
            @Override
            public int compare(Kendaraan o1, Kendaraan o2){
                return o1.getKapasitasOrang() - o2.getKapasitasOrang();
            }
        });
    }

    public List<Kendaraan> getAllKendaraan(){
        return this.listKendaraan;
    }

    public void validateInput(String nama) throws InvalidInputException{
        if (nama.isEmpty()) {
            throw new InvalidInputException("input bahan bakar tidak boleh null");
        }
    }

    public void add(BahanBakar bahanBakar, int kapasitasOrang, String nama) throws InvalidInputException{
        validateInput(nama);
        if (bahanBakar == null) {
            throw new InvalidInputException("input bahan bakar tidak boleh kosong");
        }
        if (kapasitasOrang < 0) {
            throw new InvalidInputException("Input jumlah orang tidka boleh negatif");
        }
        this.listKendaraan.add(new Mobil(bahanBakar, kapasitasOrang, nama));
    }

    public void add(String nama, int jumlahRoda) throws InvalidInputException{
        validateInput(nama);
        if (jumlahRoda < 0) {
            throw new InvalidInputException("Jumalah roda tidak boleh negatif");
        }
        this.listKendaraan.add(new Truk(nama, jumlahRoda));
    }

    public void add(int kapasitasOrang, String nama, int jumlahRoda, boolean pesawatTempur) throws InvalidInputException{
        validateInput(nama);
        if (kapasitasOrang < 0) {
            throw new InvalidInputException("Input jumlah orang tidka boleh negatif");
        }
        if (jumlahRoda < 0) {
            throw new InvalidInputException("Jumalah roda tidak boleh negatif");
        }
        this.listKendaraan.add(new Pesawat(kapasitasOrang, nama, jumlahRoda, pesawatTempur));
    }

    public void add(int kapasitasOrang, String nama, int jumlahBalingBaling) throws InvalidInputException{
        validateInput(nama);
        if (kapasitasOrang < 0) {
            throw new InvalidInputException("Input jumlah orang tidka boleh negatif");
        }
        if (jumlahBalingBaling < 0) {
            throw new InvalidInputException("Jumalah roda tidak boleh negatif");
        }
        this.listKendaraan.add(new Helikopter(kapasitasOrang, nama, jumlahBalingBaling));
    }
}
