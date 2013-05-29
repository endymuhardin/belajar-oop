public class PerhitunganDiskonPeriode implements Diskon {
    public BigDecimal hitungDiskon(Pembelian p){
        Date waktuTransaksi = p.getWaktu();
        if(dekatTahunBaru(waktuTransaksi)){
            return new BigDecimal(0.2)
            .multiply(p.hitungTotal());
        }
    }
    
    private Boolean dekatTahunBaru(Date waktu){
        // kalau bulan desember return true
    }
}
