package org.apache.jsp.Vistas;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class TablaBase_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Table</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body> \r\n");
      out.write("    <br>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h1>Categorias</h1>\r\n");
      out.write("        <div class=\"d-flex justify-content-end\">\r\n");
      out.write("            <button href=\"\" type=\"button\" class=\"btn btn-warning\"><svg class=\"bi bi-file-earmark\" width=\"1em\"\r\n");
      out.write("                    height=\"1em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n");
      out.write("                    <path\r\n");
      out.write("                        d=\"M4 1h5v1H4a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V6h1v7a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2z\" />\r\n");
      out.write("                    <path d=\"M9 4.5V1l5 5h-3.5A1.5 1.5 0 0 1 9 4.5z\" />\r\n");
      out.write("                </svg> IMPRIMIR</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("<br>\r\n");
      out.write("    <table class=\"responsive\">\r\n");
      out.write("        <table class=\"table table-striped table-bordered\">\r\n");
      out.write("            <thead class=\"thead-dark\">\r\n");
      out.write("                <tr align=\"center\">\r\n");
      out.write("\r\n");
      out.write("                    <th scope=\"col\">NOMBRE</th>\r\n");
      out.write("                    <th scope=\"col\">APELLIDO</th>\r\n");
      out.write("                    <th scope=\"col\">CORREO</th>\r\n");
      out.write("                    <th scope=\"col\">USUARIO</th>\r\n");
      out.write("                    <th scope=\"col\">TIPO</th>\r\n");
      out.write("                    <th scope=\"col\">ESTADO</th>\r\n");
      out.write("                    <th scope=\"col\">CORREO</th>\r\n");
      out.write("                    <th scope=\"col\">ACCIONES</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            <tbody align=\"center\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>ACA CODE</td>\r\n");
      out.write("                    <td>ACA CODE</td>\r\n");
      out.write("                    <td>ACA CODE</td>\r\n");
      out.write("                    <td>@ACA CODE</td>\r\n");
      out.write("                    <td>ACA CODE</td>\r\n");
      out.write("                    <td>ACA CODE</td>\r\n");
      out.write("                    <td>@ACA CODE</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <button href=\"view\" type=\"button\" class=\"btn btn-success\"><svg class=\"bi bi-pencil-square\"\r\n");
      out.write("                                width=\"1em\" height=\"1em\" viewBox=\"0 0 16 16\" fill=\"currentColor\"\r\n");
      out.write("                                xmlns=\"http://www.w3.org/2000/svg\">\r\n");
      out.write("                                <path\r\n");
      out.write("                                    d=\"M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z\" />\r\n");
      out.write("                                <path fill-rule=\"evenodd\"\r\n");
      out.write("                                    d=\"M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z\" />\r\n");
      out.write("                            </svg></button>\r\n");
      out.write("                        <button href=\"\" type=\"button\" class=\"btn btn-danger\"><svg class=\"bi bi-trash\" width=\"1em\"\r\n");
      out.write("                                height=\"1em\" viewBox=\"0 0 16 16\" fill=\"currentColor\" xmlns=\"http://www.w3.org/2000/svg\">\r\n");
      out.write("                                <path\r\n");
      out.write("                                    d=\"M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z\" />\r\n");
      out.write("                                <path fill-rule=\"evenodd\"\r\n");
      out.write("                                    d=\"M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z\" />\r\n");
      out.write("                            </svg></button>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("               \r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
      out.write("    </table>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
