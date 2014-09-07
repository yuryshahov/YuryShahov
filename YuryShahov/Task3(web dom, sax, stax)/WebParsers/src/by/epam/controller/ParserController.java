package by.epam.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.constant.ConstString;
import by.epam.exception.ErrorException;
import by.epam.exception.LogicException;
import by.epam.model.builder.CarBuilder;
import by.epam.model.entity.ICar;
import by.epam.model.factory.CarBuilderFactory;
import by.epam.model.factory.CarBuilderFactory.TypeParser;

@WebServlet(urlPatterns="/parser")
public class ParserController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2490064147684629473L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
										throws ServletException, IOException {
		ServletContext sc = null;
		CarBuilderFactory cbf = new CarBuilderFactory();
		String parsertype = req.getParameter("parsertype");
		try {
			sc = getServletContext();
			TypeParser type = CarBuilderFactory.TypeParser.valueOf(parsertype.toUpperCase());
			CarBuilder cb = cbf.createBuilder(type);
			String carPath = sc.getRealPath(ConstString.CAR_PATH);
			cb.buildListCars(carPath);
			List<ICar> cars = cb.getCars();
			req.setAttribute("cars", cars);
			req.setAttribute("parserName", parsertype);
			req.setAttribute("backurl", sc.getServerInfo());
			req.getRequestDispatcher("/jsp/parseResult.jsp").forward(req, resp);
		} catch (IllegalArgumentException e) {
			req.setAttribute("errorMessage", "Wrong value");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException e) {
			req.setAttribute("errorMessage", "Wrong value");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ErrorException e) {
			req.setAttribute("errorMessage", "Wrong value");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (LogicException e) {
			req.setAttribute("errorMessage", "Wrong value");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
}
