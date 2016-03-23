package br.edu.iffarroupilha.sca.controle;

import java.util.List;

import org.hibernate.Session;

import br.edu.iffarroupilha.sca.hibernate.HibernateUtil;

/**
 * <p>
 * Classe abstrata que concentra as op��es padr�es de opera��o para entidades.
 * <p>
 * @author Renato
 * @since 16/03/2016 21:56
 */


public abstract class AControle {
	/**
	 * <p>
	 * Gravar ou atualizar uma informa��o no banco de dados, o que
	 * define em qual tabela os dados ser�o persistidos � o tipo
	 * da entidade, que por sua vez � passada como parametro nesta a��o
	 * </p>
	 * 
	 * @param entidade
	 */
	
	public void gravar(Object entidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		//abre a transa��o
		sessao.beginTransaction();
		//salva ou atualiza a entidade
		sessao.saveOrUpdate(entidade);
		//comita a transa��o
		sessao.getTransaction().commit();
		sessao.close();
	}
	
	
	/**
	 * Retorna uma lista com todos os registros de uma determinada tabela, o que
	 * define a tabela de origem dos dados � a classe que � informada como par�metro
	 * para esta a��o. Este m�todo equivale a: SELECT * FROM tabela
	 * @return
	 */
	
	public List listar(Class classeEntidade){
		Session sessao = HibernateUtil.getFabrica().openSession();
		List dados = sessao.createCriteria(classeEntidade).list();
		sessao.close();
		return null;
	}
	

}
