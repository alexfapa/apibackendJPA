package dominio;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne //notação para referenciar a tabela pessoa
	private Pessoa pessoa;
	
	@ManyToOne //notação para referenciar a tabela produto
	private Produto produto;
	private BigDecimal valorPago;
	private BigDecimal troco;
	
	public Compra() {
		
	}

	public Compra(Integer id, Pessoa pessoa, Produto produto, BigDecimal valorPago, BigDecimal troco) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.produto = produto;
		this.valorPago = valorPago;
		this.troco = troco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", pessoa=" + pessoa + ", produto=" + produto + ", valorPago=" + valorPago
				+ ", troco=" + troco + "]";
	}

}
