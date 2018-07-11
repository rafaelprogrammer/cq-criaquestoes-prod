package br.com.cq.dominio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoQuestao {

	MULTIPLA_ESCOLHA, CERTO_ERRADO, SUBJETIVA;
	
	@JsonCreator
    public static TipoQuestao fromValue(String value) {
        if (MULTIPLA_ESCOLHA.name().equalsIgnoreCase(value)) {
        	return TipoQuestao.MULTIPLA_ESCOLHA;
        }
        if (CERTO_ERRADO.name().equalsIgnoreCase(value)) {
        	return TipoQuestao.CERTO_ERRADO;
        }
        if (SUBJETIVA.name().equalsIgnoreCase(value)) {
        	return TipoQuestao.SUBJETIVA;
        }
        return null;
    }

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }
    
}
