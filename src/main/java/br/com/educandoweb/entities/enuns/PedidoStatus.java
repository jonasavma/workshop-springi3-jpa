package br.com.educandoweb.entities.enuns;

public enum PedidoStatus {

	WAITTING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int codigo;

	private PedidoStatus(int codigo) {
		this.codigo = codigo;
	}

	// para esse metodo ficar visivel para fora
	public int getCodigo() {
		return codigo;
	}

	// metodo estaticos para converter o valor numerico para o tipo enumerado

	public static PedidoStatus valueOf(int codigo) {
		for (PedidoStatus value : PedidoStatus.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}

		}
		
		throw new IllegalArgumentException("Codigo invalido para PedidoStatus");
	}

}
