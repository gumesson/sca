package br.edu.iffarroupilha.sca.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.edu.iffarroupilha.sca.modelo.Aluno;
import br.edu.iffarroupilha.sca.modelo.Turma;

/**
 * <p>
 * Classe utilit�ria para gerir objetos de conex�o com o banco de dados relacional.
 * Utiliza-se como base para a infraestrura o framework hibernate aplicando-se o padr�o singleton
 * </p>
 * 
 * @author Renato
 * @since 15/03/2016	21:32
 */

public class HibernateUtil {
	
	private static final SessionFactory fabrica = construirFabrica();

	/**
	 * <p>
	 * M�todo que cria uma f�brica a partir do arquivo de configura��o hibernate.properties
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
	 * Retorna a f�brica de sess�o, atrav�s desta � poss�vel criar e gerenciar
	 * sess�es de acesso ao banco de dados
	 * </p>
	 */
	public static SessionFactory getFabrica(){
		return fabrica;
	}
	

}
