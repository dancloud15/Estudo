package br.com.dnasystem.BEAN;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.dnasystem.DAO.ContasPagarDAO;
import br.com.dnasystem.DAO.FornecedorDAO;
import br.com.dnasystem.VO.ContasPagar;
import br.com.dnasystem.VO.Fornecedor;

@ManagedBean(name = "cpBean")
@SessionScoped
public class ContasPagarBEAN {

	private ContasPagar contas_pagar = new ContasPagar();
	private DataModel<ContasPagar> ContasPagars;
	private int fornecedor_id;

	public DataModel<ContasPagar> getContasPagars() {
		return ContasPagars;
	}

	public void setContasPagars(DataModel<ContasPagar> contasPagars) {
		ContasPagars = contasPagars;
	}

	public int getFornecedor_id() {
		return fornecedor_id;
	}

	public void setFornecedor_id(int fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}

	public ContasPagar getContas_pagar() {
		return contas_pagar;
	}

	public void setContas_pagar(ContasPagar contas_pagar) {
		this.contas_pagar = contas_pagar;
	}

	public void novoContas_pagar() {
		contas_pagar = new ContasPagar();
	}
	public void novoContasPagar(){
		contas_pagar = new ContasPagar();
	}
	
	public void selecionarContas_pagar(){
		this.contas_pagar= ContasPagars.getRowData();
		
	}

	public DataModel<ContasPagar> getcontas_pagars() {
		ContasPagarDAO dao = new ContasPagarDAO();
		try {
			List<ContasPagar> lista = dao.GetAll();
			ContasPagars = new ListDataModel<ContasPagar>(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return ContasPagars;

	}

	public void setcontas_pagars(DataModel<ContasPagar> ContasPagars) {
		this.ContasPagars = ContasPagars;
	}

	public String addContasPagar() {

		String retorno = "erro";

		try {
			ContasPagarDAO dao = new ContasPagarDAO();
			FornecedorDAO fornecedorDao= new FornecedorDAO();
			contas_pagar.setFornecedor(fornecedorDao.Get(fornecedor_id));
			dao.Salvar(contas_pagar);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	public String deleteContasPagar() {
		this.contas_pagar =ContasPagars.getRowData();
		String retorno = "erro";

		try {
			ContasPagarDAO dao = new ContasPagarDAO();
			dao.Delete(contas_pagar);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}

	public String updateContasPagar() {

		String retorno = "erro";

		try {
			ContasPagarDAO dao = new ContasPagarDAO();
			FornecedorDAO fornecedorDao= new FornecedorDAO();
			contas_pagar.setFornecedor(fornecedorDao.Get(fornecedor_id));
			dao.Update(contas_pagar);
			retorno = "listar";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return retorno;
	}
	
	
	
	public Collection<SelectItem>getCarregarFornecedores(){
		FornecedorDAO dao = new FornecedorDAO();
		Collection<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("-- SELECIONE --"));
		List<Fornecedor> listaFornecedor = dao.GetAll();
		
		for (int i = 0; i < listaFornecedor.size(); i++) {
			lista.add(new SelectItem(listaFornecedor.get(i).getId(), listaFornecedor.get(i).getNome()));
		}
		
		return lista;
	}
	
	

}
