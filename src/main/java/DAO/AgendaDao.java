package DAO;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	public static List<Agenda> listar() {
		  EntityManager em = JPAutil.criarEntityManager();
		  Query q = em.createQuery("select a from Agenda a");
		  List <Agenda> resultado = q.getResultList();
		  em.close();
		  return resultado;
	}
	public static void excluir(Agenda agenda) {
	    EntityManager em = JPAutil.criarEntityManager();
	    em.getTransaction().begin();
	    agenda = em.find(Agenda.class, agenda.getId());
	    if (agenda !=null){
	    	em.remove(agenda);
	    }
	    em.getTransaction().commit();
	    em.close();
	}
	
	public static void editar(Agenda agenda) {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(agenda);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	public static long contar() {
		EntityManager em = JPAutil.criarEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createQuery("SELECT COUNT(a) FROM Agenda a");
		 long resultado = (long) query.getSingleResult();
		
		 em.getTransaction().commit();
		 em.close();
		 
		 return resultado;
	}
	 public static List<Agenda> buscarPorDataHoraEMedico(Date date, String medico) {
	        EntityManager em = JPAutil.criarEntityManager();
	        try {
	            TypedQuery<Agenda> query = em.createQuery("SELECT a FROM Agenda a WHERE a.dataHoraConsulta = :dataHoraConsulta AND a.medico = :medico", Agenda.class);
	            query.setParameter("dataHoraConsulta", date);
	            query.setParameter("medico", medico);
	            return query.getResultList();
	        } finally {
	            em.close();
	        }
	    }
		
	}
	