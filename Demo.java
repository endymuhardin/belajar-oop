public class Demo {
    public static void main(String[] xxx){
        // data produk
        // nantinya diambil dari database
        Produk p1 = new Produk();
        p1.setKode("P-001");
        p1.setNama("Produk 001");
        p1.setHarga(new BigDecimal("110000"));
        
        
        Produk p2 = new Produk();
        p2.setKode("P-002");
        p2.setNama("Produk 002");
        p2.setHarga(new BigDecimal("120000"));
        
        
        Produk p3 = new Produk();
        p3.setKode("P-003");
        p3.setNama("Produk 003");
        p3.setHarga(new BigDecimal("130000"));
        
        // registrasi customer
        // mengisi form di aplikasi
        Customer c1 = new Customer();
        c1.setNama("Endy Muhardin");
        c1.setEmail("endy.muhardin@gmail.com");
        
        // pilih produk pertama
        PembelianDetail pd1 = new PembelianDetail();
        pd1.setProduk(p1);
        pd1.setJumlah(2);
        
        // pilih produk kedua
        PembelianDetail pd2 = new PembelianDetail();
        pd2.setProduk(p2);
        pd2.setJumlah(4);
        
        // tekan tombol pesan/order/confirm
        Pembelian pb = new Pembelian();
        pb.setWaktuTransaksi(new Date());
        pb.setNota("Pembelian 001");
        pb.setCustomer(c1);
        pb.getDaftarPembelianDetail().add(pd1);
        pd1.setPembelian(pb);
        pb.getDaftarPembelianDetail().add(pd2);
        pd2.setPembelian(pb);
        System.out.println("Total belanja : "
            +pb.hitungTotalPembelian());
        // simpan pb ke database
        
        // lihat konfigurasi diskon di database
        PerhitunganDiskonTotalPajakPpn discTax 
            = new PerhitunganDiskonTotalPajakPpn();
        // parameter diskon dan pajak harusnya diset di db
        
        // transaksi > 1 jt disc 15%
        discTax.setMinimalDiskon(1000000); // > 1 jt baru diskon
        discTax.setPersentaseDiskon(new BigDecimal(0.15));
        
        // semua transaksi kena PPn 10%
        discTax.setPersentasePajak(new BigDecimal(0.10));
        
        // mana yang di-enable, pasang di pembelian
        pb.getDaftarDiskon().add(discTax);
        pb.getDaftarPajak().add(discTax);
        
        System.out.println("Total harus dibayar : "
            +pb.hitungTotalHarusDibayar());
        
        // customer bayar pakai kartu
        KartuKredit py = new KartuKredit();
        py.setNomorKartu("123456");
        py.setNamaKartu("Kartunya Istri Saya");
        py.setKodeOtorisasi("ABCD-4321");
        pb.setPembayaran(py);
        
        // customer bayar pakai kartu
        Tunai px = new Tunai();
        px.setDibayar(new BigDecimal(500000));
        System.out.println("Kembalian : "+px.hitungKembalian());
        pb.setPembayaran(px);
        
        
        // sudah dibayar, lakukan pengiriman
        Pengiriman pm = new Pengiriman();
        pm.setWaktuPengiriman(new Date());
        pm.setStatus(StatusPengiriman.TERKIRIM);
        pb.setPengiriman(pm);
    }
}







