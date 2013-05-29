import java.util.Date;

public class Pembelian {
    private String nota;
    private Date waktuTransaksi;
    
    private List<PembelianDetail> daftarPembelianDetail
        = new ArrayList<PembelianDetail>();
        
    private Customer customer;
    
    private Pembayaran pembayaran;
    
    private Pengiriman pengiriman;
    
    private List<Diskon> daftarDiskon
        = new ArrayList<Diskon>();
    
    private List<Pajak> daftarPajak
        = new ArrayList<Pajak>();
    
    public BigDecimal hitungTotalPembelian(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(PembelianDetail pd : daftarPembelianDetail){
            hasil = hasil.add(pd.hitungSubtotal());
        }
        return hasil;
    }
    
    public BigDecimal hitungTotalPajak(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(Pajak px : daftarPajak){
            hasil = hasil.add(px.hitungPajak(this));
        }
        return hasil;
    }
    
    public BigDecimal hitungTotalDiskon(){
        BigDecimal hasil = BigDecimal.ZERO;
        for(Diskon px : daftarDiskon){
            hasil = hasil.add(px.hitungDiskon(this));
        }
        return hasil;
    }
    
    public BigDecimal hitungTotalHarusDibayar(){
        return hitungTotalPembelian()
            .substract(hitungTotalDiskon())
            .add(hitungTotalPajak());
    }
    
    // generate getter dan setter
}
