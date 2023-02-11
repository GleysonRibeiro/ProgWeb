package br.iff.apontamentos;

public class veiculo {
	
	private int prefixo;
	private String placa;
	private String modelo;
	private int odometro;
	
	public veiculo (int prefixo) {
		this.prefixo = prefixo;
	}
	
	
	public int getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(int prefixo) {
		this.prefixo = prefixo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getOdometro() {
		return odometro;
	}
	public void setOdometro(int odometro) {
		this.odometro = odometro;
	}
	
	

}
