package br.com.educandoweb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {
	

	private static final long serialVersionUID = -5674283448481956457L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String nome;
	private String descricao;
	private Double preco;
	private String imgUrl;
	
	@Transient
	private Set<Categoria> categorias= new HashSet<>();
	
	
	public Produto() {
	}


	public Produto(Long id, String nome, String descricao, Double preco, String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.imgUrl = imgUrl;
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Set<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categorias, descricao, id, imgUrl, nome, preco);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categorias, other.categorias) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(nome, other.nome) && Objects.equals(preco, other.preco);
	}


	@Override
	public String toString() {
		return "Produto [id=" + id + "]";
	}
	
	


	

	
	
}
