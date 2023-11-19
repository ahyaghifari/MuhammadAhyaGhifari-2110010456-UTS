package model;
public class ResepMasakan {
    private String idResepMasakan;
    private String nama;
    private String lamaMemasak;
    private String bahanBahan;
    private String caraMemasak;
    
    public ResepMasakan(String id, String nama, String lamaMemasak, String bahanBahan, String caraMemasak){
        idResepMasakan = id;
        this.nama = nama;
        this.lamaMemasak = lamaMemasak;
        this.bahanBahan = bahanBahan;
        this.caraMemasak = caraMemasak;
    }
    
    public ResepMasakan(){}

    public String getIdResepMasakan() {
        return idResepMasakan;
    }

    public void setIdResepMasakan(String idResepMasakan) {
        this.idResepMasakan = idResepMasakan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLamaMemasak() {
        return lamaMemasak;
    }

    public void setLamaMemasak(String lamaMemasak) {
        this.lamaMemasak = lamaMemasak;
    }

    public String getBahanBahan() {
        return bahanBahan;
    }

    public void setBahanBahan(String bahanBahan) {
        this.bahanBahan = bahanBahan;
    }

    public String getCaraMemasak() {
        return caraMemasak;
    }

    public void setCaraMemasak(String caraMemasak) {
        this.caraMemasak = caraMemasak;
    }
    
    
    
}
