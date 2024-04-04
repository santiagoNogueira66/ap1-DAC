package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidades.Agenda;
import util.JPAutil;

public class AgendaDao {
	
	public static void salvar(Agenda agenda){
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
		em.close();
	}
	public void editar(Agenda agenda) {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
		em.close();
	}
	public void excluir(Agenda agenda) {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(agenda);
		em.getTransaction().commit();
		em.close();
	}
	public static List<Agenda> listar() {
		  EntityManager em = JPAutil.criarEntityManager();
		  Query q = em.createQuery("select a from Garrafa a");
		  List <Agenda> resultado = q.getResultList();
		  em.close();
		  return resultado;
	}
	

	public long contar() {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		
		Query query = (Query) em.createQuery("SELECT COUNT(a) FROM Agenda a");
		return (long)((javax.persistence.Query) query).getSingleResult();
		
		
	}

}
	