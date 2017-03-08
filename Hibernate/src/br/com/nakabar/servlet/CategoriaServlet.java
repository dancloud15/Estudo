package br.com.nakabar.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;

import br.com.nakabar.DB.Categoria;
import br.com.nakabar.DB.CategoriaDAO;
import br.com.nakabar.DB.Cliente;
import br.com.nakabar.DB.ClienteDAO;

@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5678177143535664960L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getParameter("update")!= null){
			int id = Integer.parseInt(request.getParameter("update"));
			String nome = request.getParameter("txtNome");
			
			Categoria cat = new Categoria();
			cat.setId(id);
			cat.setNome(nome);
			CategoriaDAO dao = new CategoriaDAO();
			dao.update(cat);
			response.sendRedirect("listar_cat.jsp");
		}else{
		
		String nome = request.getParameter("txtNome");
				
		Categoria cat = new Categoria();
		cat.setNome(nome);
		CategoriaDAO dao = new CategoriaDAO();
		dao.salvar(cat);
		response.sendRedirect("listar_cat.jsp");
		}
				
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getParameter("delete")!= null){
			
			Categoria cat = new Categoria();
			cat.setId(Integer.parseInt(request.getParameter("delete")));
			CategoriaDAO dao = new CategoriaDAO();
			dao.delete(cat);
			response.sendRedirect("listar_cat.jsp");
			
		}
		
	}

}
