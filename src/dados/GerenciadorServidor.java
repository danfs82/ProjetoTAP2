package dados;

import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Table;

import entidades.Servidor;
import excecoes.ExcecaoEntrada;

public class GerenciadorServidor {
	private EntityManagerFactory entityManagerFactory;

	public GerenciadorServidor() {
		entityManagerFactory = Persistence.createEntityManagerFactory("GerenciadorServidor");
	}

	public void finalize() {
		entityManagerFactory.close();
	}

	private EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	/**
	 * Inclui um registro
	 *
	 * @param servidor Servidor a ser adicionado
	 * @return Retorna verdadeiro ou falso se conseguiu realizar a inclusão.
	 */
	public boolean inserir(Servidor servidor) {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(servidor);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}


	public String[][] listarTudo() {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
				
		String [][] resultado;
	
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("FROM Servidor");
			
			List<Servidor> lista = query.getResultList();

			resultado = new String[lista.size()][5];
			int n = 0;
			for (Servidor s : lista) {
				resultado[n] = s.toStringTable();
				n++;
			}

			return resultado;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			em.close();
		}
		
		
		
	}


	/**
	 * Retorna a quantidade de registros.
	 *
	 * @return Um número inteiro com a quantidade de registros.
	 */
	public int getQuantidadeRegistro() {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		int contador = 0;
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("FROM Servidor");
			
			List<Servidor> lista = query.getResultList();

			for (Servidor s : lista) {
				contador = contador + 1;
			}
			
			return contador;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		} finally {
			em.close();
		}
	}

	/**
	 * Atualiza um registro.
	 *
	 * @param servidor Um servidor com os novos dados.
	 * @return Retorna verdadeiro ou falso se conseguiu atualizar o registro.
	 */
	public boolean atualizar(Servidor servidor) {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Servidor servidoratualiza = em.find(Servidor.class, servidor.getMatricula());
			servidoratualiza.setNome(servidor.getNome());
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean excluirMatricula(int matricula){
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Servidor servidor = pesquisarMatricula(matricula);
			servidor = em.find(Servidor.class, servidor.getMatricula());
			em.remove(servidor);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	public boolean excluirNome(String nome) {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Servidor servidor = pesquisarNome(nome);
			servidor = em.find(Servidor.class, servidor.getMatricula());
			em.remove(servidor);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	/**
	 * Pesquisa uma chave no banco de dados retornando o registro.
	 *
	 * @param chave Valor chave a se pesquisado no arquivo.
	 * @return Retorna o registro encontrado no arquivo.
	 */
	public Servidor pesquisarMatricula(int chave) {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		EntityManager em = getEntityManager();
		try {
			Query query = em.createQuery("FROM Servidor WHERE MATRICULA = :id ");
			query.setParameter("id", chave);
			return (Servidor) query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

	public Servidor pesquisarNome(String nome) {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("from Servidor where NOME like :nome ");
			query.setParameter("nome", "%" + nome + "%");
			return (Servidor) query.getResultList().get(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			em.close();
		}
	}

	/**
	 * Apaga os registro da tabela.
	 *
	 * @return Se conseguiu esvaziar a tabela.
	 */
	public boolean zerar() {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela");
		}
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.createNativeQuery("DROP TABLE Servidor").executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean criar() {
		if(checar()==true) {
			throw new ExcecaoEntrada("Tabela já existe!");
		}
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();

			em.createNativeQuery("CREATE TABLE Servidor (\n" + 
					"	MATRICULA INT(6) NOT NULL,\n" + 
					"    NOME VARCHAR(255) NOT NULL,\n" + 
					"    SETOR VARCHAR(355),\n" + 
					"    SALARIO NUMERIC(7,2),\n" + 
					"    CLASSE INT(2),\n" + 
					"    CONSTRAINT PK_SERVIDOR PRIMARY KEY(MATRICULA)\r\n" + 
					")").executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}
	
	public boolean checar() {
		
		EntityManager em = getEntityManager();
		Class<?> c = Servidor.class;
		Table table = c.getAnnotation(Table.class);
		String tableName = table.name();
		Query query = em.createNativeQuery("SHOW TABLES LIKE '" + tableName + "'" );
		List lista = query.getResultList();
		if(lista.size()==0) {
			
			return false;
		} else {
			return true;
		}
		
	}
	
	public String informacoesQuantidade() {
		if(checar()!=true) {
			throw new ExcecaoEntrada("Tabela não existe! Crie a tabela.");
		}
		
		
		String informacoes = "";
		// Concatena as informações
		informacoes = Integer.toString(getQuantidadeRegistro());

		return informacoes;
	}
}
