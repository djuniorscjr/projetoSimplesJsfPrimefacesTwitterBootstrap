package br.com.projeto.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.projeto.bo.PerfilBo;
import br.com.projeto.model.Perfil;
import br.com.projeto.model.Usuario;
import br.com.projeto.utils.Acesso;
import br.com.projeto.utils.GenerateValidation;
import br.com.projeto.utils.ManipulateDate;
import br.com.projeto.utils.security.GenerateMD5;



@RequestScoped
@ManagedBean
public class IndexBean {
	
	private PerfilBo perfilBO;
	
	private Perfil perfil;
	private Usuario usuario;
	
	private List<Perfil> listaOfPerfil = new LinkedList<>();
	
	public IndexBean() throws Exception{
		perfilBO = new PerfilBo();
		perfil = new Perfil();
		/**
		 * 	 Testando BasicDaoIml
		 * 	 Cadastrando um Usuario
		 */
		 Long idOfPerfilCadastro = this.cadastrandoUsuario();
		 
		 /***
		  *  Obtendo Perfil cadastrado
		  */
		 perfil = perfilBO.retornaPorId(idOfPerfilCadastro);
		 System.out.println("");
		 System.out.println("Nome do Usuario Cadastrado " + perfil.getNome());
		 System.out.println("");
		 /**
		  *  Mudando nome do perfil cadastrado
		  * 
		  */
		 
		 perfil.setNome("Nome Alterado " + new Random().nextInt());
		 perfil = perfilBO.mudarNome(perfil);
		 System.out.println("");
		 System.out.println("Novo nome do Usuario Cadastrado " + perfil.getNome());
		 
		 /**
		  *  Mostrar todos os usuarios cadastrados
		  */
		 listaOfPerfil = perfilBO.getPerfis();
		 System.out.println("");
		 System.out.println("Lista de usuario cadastrados");
		 for (Perfil perfil : listaOfPerfil) {
			
			System.out.println(perfil.getNome());
		}
		/**
		 *  Removendo Usuario cadastado
		 */
		perfilBO.remover(perfil);
		
		 /**
		  *  Mostrar todos os usuarios cadastrados
		  */
		 listaOfPerfil = perfilBO.getPerfis();
		 System.out.println(" ");
		 System.out.println("Lista de usuario cadastrados");
		 for (Perfil perfil : listaOfPerfil) {
			System.out.println(perfil.getNome());
		}
		
		
	}
	
	
	@PostConstruct
	public void init() {
		
		System.out.println("Bean Encontrado!");
	}

	private Long cadastrandoUsuario() throws Exception{
		
		try {
			usuario = new Usuario();
			usuario.setSenha(GenerateMD5.generate("123456" + new Random().nextInt()));
			usuario.setValidacao(GenerateValidation.keyValidation());
			usuario.getPermissoes().add(Acesso.ACESSO_COMUM.getValue());
			usuario.setAtivado(false);

			perfil.setUsuario(usuario);
			perfil.setDataDeNascimento(ManipulateDate.getDate(1996, 3, 10));
			perfil.setEmail("Email" + new Random().nextInt());
			perfil.setNome("Nome " + new Random().nextInt());
			perfil.setSexo("M");
			perfil.setSobreNome("Sobrenome" + new Random().nextInt());
			
			perfil = perfilBO.salvar(perfil);
			return perfil.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public String getMessage() {
		return "Hello World JSF!";
	}

	public String register() {
		return "/public/cadastro.xhtml";
	}
}
