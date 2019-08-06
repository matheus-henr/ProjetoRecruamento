package br.com.recrutamento.brasilia.model.enums;

public enum Role {
	ADMIN(1, "ROLE_ADMIN"),
	PUBLIC(2, "ROLE_PUBLIC");

	private int cod;
	private String descrption;

	private Role(int cod, String descrption) {
		this.cod = cod;
		this.descrption = descrption;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrption () {
		return descrption;
	}

	public static Role toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (Role x : Role.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
