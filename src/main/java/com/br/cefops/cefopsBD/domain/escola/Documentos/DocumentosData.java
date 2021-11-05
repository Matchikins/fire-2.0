package com.br.cefops.cefopsBD.domain.escola.Documentos;

import com.br.cefops.cefopsBD.domain.escola.AlunosData;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Documentos")
public class DocumentosData  implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String cpf;
    private String rg;
    private Date dataemissao;
    private String orgaoemissor;
    private String estadoemissor;
    private String tituloeleitor;
    private String zona;
    private String secao;
    private Date dataemissaotitulo;
    private String estemissortitulo;
    private String reservista;
    private String categoriamilitar;
    private String circoinscricaomitlitar;
    private String regiaomilitar;
    private Date dataemissaoreservista;
    private String orgaoemissorreservista;
    private String situacaomilitar;
    private String nomedamae;
    private String nomedopai;

    @OneToOne()
    @Setter
    @Getter(value = AccessLevel.NONE)
    private AlunosData alunosId;

}
