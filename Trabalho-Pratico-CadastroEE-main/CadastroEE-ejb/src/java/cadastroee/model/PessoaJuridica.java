package cadastroee.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "cadastroee.model.PessoaJuridica[ idPessoa=" + getIdPessoa() + " ]";
    }
}