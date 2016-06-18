package br.com.pathfinder.api.entity;
import java.util.List;
import com.google.common.collect.Lists;


public class Usuario {
	public static final String TABLE = "PATHFINDER_USUARIO";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_LOGIN = "LOGIN";
	public static final String COL_SENHA = "SENHA";

	private Long id;
	private String nome;
	private String login;
	private String senha;
	
	public Long getId() {				return id;		}
	public void setId(Long id) {		this.id = id;		}
	
	public String getNome() {				return nome;	}
	public void setNome(String nome) {		this.nome = nome;	}
	
	public String getLogin() {				return login;		}
	public void setLogin(String login) {	this.login = login;	}
	
	public String getSenha() {				return senha;		}
	public void setSenha(String senha) {	this.senha = senha;	}
	
	public Usuario(){}
	
	public Usuario(Long id, String nome, String login, String senha){
		this.id = id;
		this.nome= nome;
		this.login = login;
		this.senha = senha;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_LOGIN, COL_SENHA);
	}
	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_LOGIN, COL_SENHA };
	}
	
	@Override
	public String toString() {
		return id +" ,"+ nome+" ,"+login+" ,"+ senha;
	}
}
