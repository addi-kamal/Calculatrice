package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import traitement.ICalcule;
import traitement.Somme;
import web.SumModel;
@WebServlet(name = "cs", urlPatterns = {"/controleur", "*.do"})
public class C_Servlet extends HttpServlet {
	private ICalcule traitement;
	public void init() throws ServletException {
		traitement = new Somme();	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("sumModel", new SumModel());
		request.getRequestDispatcher("Vue.jsp").forward(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// lire les donnees de la requete
		double nombre1 = Double.parseDouble(request.getParameter("nombre 1"));
		double nombre2 = Double.parseDouble(request.getParameter("nombre 2"));
		// valider les donnees
		// stocker les donnees dans le modele
		SumModel model=new SumModel();
		model.setNombre1(nombre1);
		model.setNombre2(nombre2);
		// traitements 
		double res=traitement.calculer(nombre1, nombre2);
		//stocker le resultat dans le modele
		model.setSomme(res);
		// stocker le model dans l'objet request
		request.setAttribute("sumModel", model);
		// request vers la vue jsp
		request.getRequestDispatcher("Vue.jsp").forward(request, response); 
	}

}
