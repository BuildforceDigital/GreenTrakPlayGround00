package nl.greentrak.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nl.buildforce.olingo.commons.api.ex.ODataException;
import nl.buildforce.sequoia.processor.core.api.JPAODataCRUDContextAccess;
import nl.buildforce.sequoia.processor.core.api.JPAODataHandler;
import nl.buildforce.sequoia.processor.core.processor.JPAODataRequestContextImpl;
import nl.greentrak.persistence.ExampleCUDRequestHandler;

@WebServlet(urlPatterns="/ServletPath.svc/*")
public class OdataServlet extends HttpServlet {
	public static final String PUNIT_NAME = "GreenTrak00";

	@Override
	protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException {
		final JPAODataCRUDContextAccess serviceContext =
				(JPAODataCRUDContextAccess) getServletContext().getAttribute("ServiceContext");
		final JPAODataHandler handler = new JPAODataHandler(serviceContext); // JPAODataCRUDHandler(serviceContext);


		((JPAODataRequestContextImpl) handler.getJPAODataRequestContext()).setCUDRequestHandler(new ExampleCUDRequestHandler());
		try { handler.process(req, resp); }
		catch ( ODataException e) { throw new ServletException(e); }
	}

}