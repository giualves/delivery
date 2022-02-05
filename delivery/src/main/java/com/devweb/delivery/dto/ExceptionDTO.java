package com.devweb.delivery.dto;

import java.util.List;

import lombok.Data;

@Data
public class ExceptionDTO {

	private Integer status;
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<Validacao> getValidacoes() {
		return validacoes;
	}

	public void setValidacoes(List<Validacao> validacoes) {
		this.validacoes = validacoes;
	}

	private String mensagem;
	
	private List<Validacao> validacoes;
	
	@Data
	public static class Validacao {
		
		private String campo;
		
		private String erro;

		public String getCampo() {
			return campo;
		}

		public void setCampo(String campo) {
			this.campo = campo;
		}

		public String getErro() {
			return erro;
		}

		public void setErro(String erro) {
			this.erro = erro;
		}
		
	}
	
}
