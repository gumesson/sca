package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Classe utilitária para gerir objetos de conexão com o banco de dados relacional.
 * Utiliza-se como base para a infraestrura o framework hibernate aplicando-se o padrão singleton
 * </p>
 * 
 * @author Renato
 * @since 15/03/2016	21:32
 */

public class HibernateUtil {
	
	private static final SessionFactory fabrica = construirFabrica();

	/**
	 * <p>
	 * Método que cria uma fábrica a partir do arquivo de configuração hibernate.properties
	 * </p>
	 * @return
	 */
	private static SessionFactory construirFabrica() {
		Configuration cfg = new Configuration();
		//adiciona as classes (entidades) anotadas
		cfg.addAnnotatedClass(Aluno.class);
		cfg.addAnnotatedClass(Turma.class);
		cfg.configure();
		return cfg.buildSessionFactory();
	}
	
	/**
	 * <p>
	 * Retorna a fábrica de sessão, através desta é possível criar e gerenciar
	 * sessões de acesso ao banco de dados
	 * </p>
	 */
	public static SessionFactory getFabrica(){
		return fabrica;
	}
	

}
