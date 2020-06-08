package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * Classe base de servidor.
 */

@Entity
@Table(name="Servidor")
public class Servidor {
	
	@Id
	@NotNull
	@Column(name="MATRICULA")
	private int matricula;
	
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SETOR")
	private String setor;
	
	@Column(name="SALARIO")
	private double salario;
	
	@Column(name="CLASSE")
	private int classe;

	public Servidor() {
		this(0, "", "", 0.0, 0);
	}

	public Servidor(int matricula, String nome, String setor, double salario, int classe) {
		setMatricula(matricula);
		setNome(nome);
		setSetor(setor);
		setSalario(salario);
		setClasse(classe);
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public void setClasse(int classe) {
		this.classe = classe;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getSetor() {
		return setor;
	}

	public double getSalario() {
		return salario;
	}

	public int getClasse() {
		return classe;
	}

	@Override
	public String toString() {
		return ("Matrícula: " + getMatricula() + "\nNome: " + getNome() + "\nSetor: " + getSetor() + "\nSalário: "
				+ getSalario() + "\nClasse : " + getClasse());
	}
	
	public String[] toStringTable() {
		return new String[] {Integer.toString(getMatricula()), getNome(), getSetor(), Double.toString(getSalario()), Integer.toString(getClasse())};
	}
}
