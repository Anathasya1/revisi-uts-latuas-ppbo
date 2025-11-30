package models;

public class Mobil extends KendaraanDarat{
    public Mobil(BahanBakar bahanBakar, int kapasitasOrang, String nama){
        super(bahanBakar, kapasitasOrang, nama, 4);
    }

    @Override
    public String getDetails(){
        return "Mobil " + super.getDetails();
    }
}
