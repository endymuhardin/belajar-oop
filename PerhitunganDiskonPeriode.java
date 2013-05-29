public class PerhitunganDiskonPeriode implements DiskonBersyarat {
    private Pembelian pembelian;
    
    public BigDecimal hitungDiskon(Pembelian p){
        this.pembelian = p;
        if(berlaku()){
            return new BigDecimal(0.2)
            .multiply(p.hitungTotal());
        }
    }
    
    public Boolean berlaku(){
        return dekatTahunBaru(pembelian.getWaktu());
    }
    
    private Boolean dekatTahunBaru(Date waktu){
        // kalau bulan desember return true
    }
}
