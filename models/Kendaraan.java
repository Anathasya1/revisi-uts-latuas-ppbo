package models;

public abstract class Kendaraan {
    private BahanBakar bahanBakar;
    private int kapasitasOrang;
    private String nama;

    public Kendaraan(BahanBakar bahanBakar, int kapasitasOrang, String nama){
        this.bahanBakar = bahanBakar;
        this.kapasitasOrang = kapasitasOrang;
        this.nama = nama;
    }

    public BahanBakar getBahanBakar(){
        return this.bahanBakar;
    }

    public int getKapasitasOrang(){
        return this.kapasitasOrang;
    }

    public String getNama(){
        return this.nama;
    }
    

    public String getDetails(){
        return nama + ", kapasitas orang: " + this.kapasitasOrang;
    }
}
