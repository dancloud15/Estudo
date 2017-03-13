package br.com.dnasystem.BEAN;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.dnasystem.DAO.FornecedorDAO;
import br.com.dnasystem.VO.Fornecedor;

@ManagedBean(name = "forBean")
@SessionScoped
public class FornecedorBean {

	private Fornecedor fornecedor = new Fornecedor();
	private DataModel<Fornecedor> fornecedores;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public void novoFornecedor() {
		fornecedor = new Fornecedor();
	}
	
	public void selecionarFornecedor(){
		this.fornecedor= fornecedores.getRowData();
		
	}

	public DataModel<Fornecedor> getFornecedores() {
		FornecedorDAO dao = new FornecedorDAO();
		try {
			List<Fornecedor> lista = dao.GetAll();
			fornecedores = new ListDataModel<Fornecedor>(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return fornecedores;

	}

	public void setFornecedores(DataModel<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String addFornecedor() {

		String retorno = "erro";

		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.Salvar(fornecedor);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	public String deleteFornecedor() {
		this.fornecedor =fornecedores.getRowData();
		String retorno = "erro";

		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.Delete(fornecedor);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	public String updateFornecedor() {

		String retorno = "erro";

		try {
			FornecedorDAO dao = new FornecedorDAO();
			dao.Update(fornecedor);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

}
