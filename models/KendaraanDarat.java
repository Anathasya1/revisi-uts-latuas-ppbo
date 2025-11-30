package models;

public class KendaraanDarat extends Kendaraan{
    private int jumlahRoda;

    public KendaraanDarat(BahanBakar bahanBakar, int kapasitasOrang, String nama, int jumlahRoda){
        super(bahanBakar, kapasitasOrang, nama);
        this.jumlahRoda = jumlahRoda;
    }

    public int getJumlahRoda(){
        return this.jumlahRoda;
    }

    @Override
    public String getDetails(){
        return super.getDetails() + ", Jumlah roda: " + this.jumlahRoda;
    }

}
