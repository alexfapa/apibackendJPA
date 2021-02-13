package aplicacao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Compra;
import dominio.Pessoa;
import dominio.Produto;

public class Programa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager(); //neste ponto é criada uma conexção com o banco de dados e todo o contexto do arquivo de configuração persistence 
		
		/*
		 * Persistindo objetos no banco de dados
		 * Os objetos abaixo devem ser intanciados anteriormente
		 *  em.getTransaction().begin();
			em.persist(p1);
			em.persist(p2);
			em.persist(p3);
			em.getTransaction().commit();
		
			em.getTransaction().begin();
			em.persist(prd1);
			em.persist(prd2);
			em.persist(prd3);
		 	em.getTransaction().commit();
		
			em.getTransaction().begin();
			em.persist(c1);
			em.getTransaction().commit();
		 *
		 */
		//Buscando dados no banco
		Pessoa p = em.find(Pessoa.class, 2);
		Compra c = em.find(Compra.class, 1);
		Pessoa pc = em.find(Pessoa.class, c.getPessoa().getId());
		Produto prodC = em.find(Produto.class, c.getProduto().getId());
		
		System.out.println(p);
		System.out.println("Cliente: "+pc.getNome());
		System.out.println("Comprou: "+prodC.getName());
		
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
