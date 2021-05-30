package model;

public class Menu {
	
	private String kode, nama;
	private int harga, stok;

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public Menu(String kode, String nama, int harga, int stok) {
		super();
		this.kode = kode;
		this.nama = nama;
		this.harga = harga;
		this.stok = stok;
	}

	public Menu() {
		// TODO Auto-generated constructor stub
	}

}
