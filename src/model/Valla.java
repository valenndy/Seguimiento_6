package model;

public class Valla {
	private int altura;
	private int ancho;
	private boolean uso;
	private String Empresa;
	
	public Valla() {
	}

	public Valla(int altura, int ancho, boolean uso, String empresa) {
		this.altura = altura;
		this.ancho = ancho;
		this.uso = uso;
		Empresa = empresa;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public boolean isUso() {
		return uso;
	}

	public void setUso(boolean uso) {
		this.uso = uso;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
	
	
}
