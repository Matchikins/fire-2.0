package com.br.cefops.cefopsBD.domain.Financias;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EntidadesGrupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nomeCompleto;
		private String nomeAbreviadoString;
		private String cnpj;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNomeCompleto() {
			return nomeCompleto;
		}
		public void setNomeCompleto(String nomeCompleto) {
			this.nomeCompleto = nomeCompleto;
		}
		public String getNomeAbreviadoString() {
			return nomeAbreviadoString;
		}
		public void setNomeAbreviadoString(String nomeAbreviadoString) {
			this.nomeAbreviadoString = nomeAbreviadoString;
		}
		public String getCnpj() {
			return cnpj;
		}
		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}
		@Override
		public int hashCode() {
			return Objects.hash(cnpj, id, nomeAbreviadoString, nomeCompleto);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			EntidadesGrupo other = (EntidadesGrupo) obj;
			return Objects.equals(cnpj, other.cnpj) && Objects.equals(id, other.id)
					&& Objects.equals(nomeAbreviadoString, other.nomeAbreviadoString)
					&& Objects.equals(nomeCompleto, other.nomeCompleto);
		}
		
		
		
		
}
