package com.br.cefops.cefopsBD.data.vo.v1;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.br.cefops.cefopsBD.domain.escola.Documentos.DocumentosData;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import com.br.cefops.cefopsBD.domain.escola.Documentos.Endereço;
import com.br.cefops.cefopsBD.domain.escola.Requerimentos.Requerimentos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonPropertyOrder({ "id", "name", "lastName","cpf","dataNanscimento","email","teleFone","teleFoneCelular" ,"photo","enabled","requerimentos","endereco","documentos"})
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AlunosVo extends RepresentationModel<AlunosVo> implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	
	
	@Mapping("Id")
	@JsonProperty("id")
	private String key;
	private String Name;
	private	Date dataNanscimento;
	private	String LastName;
	private	String Nacionalidade;
	private	String Email;
	private	String sexo;
	private	String estadoCivil;
	private	String TeleFoneCelular;
	private	String TeleFone;
	private	Boolean enabled;
	private	String photo;
	private List<Requerimentos>  requerimentos ;
	@JsonProperty("endereco")
	private Endereço endereço;
	private DocumentosData documentos;


}
