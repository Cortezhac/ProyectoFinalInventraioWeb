/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Controladores.Usuario;
import DAO.CategoriaDAO;
import DAO.ProductoDAO;
import DAO.usuarioDAO;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PDF {
    private static final Font FuenteTitulos = FontFactory.getFont(FontFactory.TIMES_ROMAN, 26 , Font.BOLDITALIC);
    private static final Font FuenteParrafos = FontFactory.getFont(FontFactory.TIMES, 12, Font.NORMAL);
    private static final Font FuenteCabecera = FontFactory.getFont(FontFactory.TIMES, 12, Font.BOLD,BaseColor.WHITE);
    private static final Font FuenteParrafosHormiga = FontFactory.getFont(FontFactory.TIMES, 9, Font.NORMAL);
    private static final Font FuenteCabeceraHormiga = FontFactory.getFont(FontFactory.TIMES, 9, Font.BOLD,BaseColor.WHITE);
    private static final String Imagenutilizada = "";
    private static final Chunk saltoLinea = new Chunk(Chunk.NEWLINE);
    
    public static void GenerarPDF(OutputStream Nombredelarchivo, String nombreTabla) throws IOException{
        try {
            Document documento = new Document();
            try {
                PdfWriter writer = PdfWriter.getInstance(documento, Nombredelarchivo);
//                Rotate rotar = new Rotate();
//                rotar.setRotation(PdfPage.LANDSCAPE);
//                writer.setPageEvent(rotar);
            } catch (DocumentException e) {
                System.out.println("No se encontro el fichero para generar el PDF " + e);
            }
            
            documento.open();
            // Meta data
            documento.addTitle("Registro de " + nombreTabla);
            documento.addSubject("Registro de " + nombreTabla);
            documento.addKeywords("Java, PDF, Itext");
            documento.addAuthor("Irvin Cortez");
            documento.addCreator("Irvin Cortez");
            
            // Primera Pagina
            Chunk chunk = new Chunk("Registro de " + nombreTabla, FuenteTitulos);
            
            // Creamos el primer capitulo
            Chapter capitulo = new Chapter(new Paragraph(chunk), 1);
            capitulo.setNumberDepth(0);
            capitulo.add(new Paragraph("Registros disponibles de la tabla " + nombreTabla, FuenteParrafos));
            
            // Agregar una imagen
            Image image = null;
            try{
                image = Image.getInstance(Imagenutilizada);
                image.setAbsolutePosition(2, 150);
                capitulo.add(image);
            }catch(BadElementException e){
                System.out.println("Imagen elemento dañado " + e);
            }catch(IOException ex){
                System.out.println("Imagen excepcion ES " + ex);
            }
            documento.add(capitulo);
            documento.add(saltoLinea);
            // Elegir la tabla
            if(nombreTabla.equalsIgnoreCase("Categorias")){
                CategoriaDAO utilCategoriaDAO = new CategoriaDAO("tb_categoria");
                // Cabecera de datos
                int totalRegistros = utilCategoriaDAO.listarRegistros().size();
                documento.add(PDF.CabeceraInfo(totalRegistros, nombreTabla));
                documento.add(saltoLinea);
                ArrayList<Categoria> Categorias = utilCategoriaDAO.listarRegistros();
                documento.add(PDF.CategoriasPdfTable(Categorias));
            }else if(nombreTabla.equalsIgnoreCase("Productos")){
                ProductoDAO utilDAO = new ProductoDAO("tb_producto");
                //Cabecera de datos
                int totalRegistros = utilDAO.listarRegistros().size();
                documento.add(PDF.CabeceraInfo(totalRegistros, nombreTabla));
                documento.add(saltoLinea);
                ArrayList<Producto> Productos = utilDAO.listarRegistros();
                documento.add(PDF.ProductoPdfTable(Productos));
            }else if(nombreTabla.equalsIgnoreCase("Usuario")){
                usuarioDAO utilidadesUsuario = new usuarioDAO("tb_usuario");
                // Canecera datos
                int totalRegistros = utilidadesUsuario.listarRegistros().size();
                documento.add(PDF.CabeceraInfo(totalRegistros, nombreTabla));
                documento.add(saltoLinea);
                ArrayList<usuario> Usuario = utilidadesUsuario.listarRegistros();
                documento.add(PDF.usuriosPdfPTable(Usuario));
            }
            documento.close();
            System.out.println("Se ha genrado tuu PDF");
        } catch (DocumentException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static PdfPTable CategoriasPdfTable(ArrayList<Categoria> registroCategorias){
        PdfPTable tablaRegistro = new PdfPTable(2);
        // Definir cabecera
        PdfPCell Cabecera = new PdfPCell();
        Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
        Cabecera.setBackgroundColor(BaseColor.DARK_GRAY);
        Cabecera.setPhrase(new Paragraph("Nombre categoria", FuenteCabecera));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Estado categoria", FuenteCabecera));
        tablaRegistro.addCell(Cabecera);
        // Asignar cabecera
        tablaRegistro.setHeaderRows(1);
        // Rellenar
        for(int i = 0; i < registroCategorias.size(); i++){
            Categoria categotia = registroCategorias.get(i);
            PdfPCell Cuerpo = new PdfPCell();
            Cuerpo.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cuerpo.setPhrase(new Paragraph(categotia.getNom_categoria(),FuenteParrafos));
            tablaRegistro.addCell(Cuerpo);
            if(categotia.getEstado_categoria() == 1){
                Cuerpo.setPhrase(new Paragraph("Activo",FuenteParrafos));
            }else if(categotia.getEstado_categoria() == 0){
                Cuerpo.setPhrase(new Paragraph("Inactivo",FuenteParrafos));
            }
            tablaRegistro.addCell(Cuerpo);
        }
        return tablaRegistro;
    }
    
    protected static PdfPTable ProductoPdfTable(ArrayList<Producto> registroProducto){
        PdfPTable tablaRegistro = new PdfPTable(8);
        // Definir cabecera
        PdfPCell Cabecera = new PdfPCell();
        Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
        Cabecera.setBackgroundColor(BaseColor.DARK_GRAY);
        Cabecera.setPhrase(new Paragraph("Nombre", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Descripcion", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Stock", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Precio", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("U. Medidad", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Estado", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Categoria", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Fecha Ingreso", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        
        // Asignar cabecera
        tablaRegistro.setHeaderRows(1);
        // Rellenar
        for(int i = 0; i < registroProducto.size(); i++){
            Producto producto = registroProducto.get(i);
            PdfPCell Cuerpo = new PdfPCell();
            Cuerpo.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cuerpo.setPhrase(new Paragraph(producto.getNom_producto(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(producto.getDes_producto(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getStock()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getPrecio()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(producto.getUnidad_de_medida(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            String salida = (producto.getEstado_producto() == 1)? "Disponible" : "No disponible";
            Cuerpo.setPhrase(new Paragraph(salida,FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            CategoriaDAO util = new CategoriaDAO("tb_categoria");
            String condicion = " id_categoria = " + producto.getCategoria() + " ";
            Categoria cate = (Categoria) util.listarRegistros(condicion).get(0);
            Cuerpo.setPhrase(new Paragraph(cate.getNom_categoria(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(producto.getFecha_entrada()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
        }
        tablaRegistro.setWidthPercentage(100); // ancho tabla completa
        return tablaRegistro;
    }
    
    protected static PdfPTable usuriosPdfPTable(ArrayList<usuario> registroUsuarios){
        PdfPTable tablaRegistro = new PdfPTable(10);
        // Definir cabecera
        PdfPCell Cabecera = new PdfPCell();
        Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
        Cabecera.setBackgroundColor(BaseColor.DARK_GRAY);
        Cabecera.setPhrase(new Paragraph("Nombre", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Apellido", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Correo", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Usuario", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Clave", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Tipo", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Estado", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Pregunta", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Respuesta", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        Cabecera.setPhrase(new Paragraph("Fecha Registro", FuenteCabeceraHormiga));
        tablaRegistro.addCell(Cabecera);
        
        // Asignar cabecera
        tablaRegistro.setHeaderRows(1);
        // Rellenar
        for(int i = 0; i < registroUsuarios.size(); i++){
            usuario Usuario = registroUsuarios.get(i);
            PdfPCell Cuerpo = new PdfPCell();
            Cuerpo.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cuerpo.setPhrase(new Paragraph(Usuario.getNombre(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(Usuario.getApellido(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(Usuario.getCorreo()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(Usuario.getUsuario(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(Usuario.getClave().hashCode()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            String tipo = (Usuario.getTipo() == 1 )? "Administrador" : "Cliente";
            Cuerpo.setPhrase(new Paragraph(tipo,FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            String estado =(String.valueOf(Usuario.getEstado()).equalsIgnoreCase("1"))? "Activo" : "Inactivo";
            Cuerpo.setPhrase(new Paragraph(estado,FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(Usuario.getPregunta()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(String.valueOf(Usuario.getRespuesta().hashCode()),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
            Cuerpo.setPhrase(new Paragraph(Usuario.getFechaRegistro(),FuenteParrafosHormiga));
            tablaRegistro.addCell(Cuerpo);
        }
        tablaRegistro.setWidthPercentage(100); // ancho tabla completa
        return tablaRegistro;
    }
    
    protected static PdfPTable CabeceraInfo(int registros, String nombreTabla) throws DocumentException{
        PdfPTable data  = new PdfPTable(4);
        // Cabecera
        PdfPCell Cabecera = new PdfPCell();
        Cabecera.setColspan(4);
        Cabecera.setBackgroundColor(BaseColor.DARK_GRAY);
        Cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
        Cabecera.setPhrase(new Paragraph(nombreTabla, FuenteCabecera));
        data.addCell(Cabecera);
        // Cuerpo
        PdfPCell celdas = new PdfPCell();
        celdas.setPaddingLeft(10);
        float[] ancho = new float[]{30f,40f,25f,10f};// tamaño
        data.setWidths(ancho);
        Date fecha = new Date();// Definir fecha
        celdas.setPhrase(new Paragraph("Reporte Fechado: ",FuenteParrafos));
        data.addCell(celdas);//insertar
        celdas.setPhrase(new Paragraph(fecha.toString(), FuenteParrafos));
        data.addCell(celdas);
        celdas.setPhrase(new Paragraph("Total Registros: ",FuenteParrafos));
        data.addCell(celdas);
        celdas.setPhrase(new Paragraph(String.valueOf(registros),FuenteParrafos));
        data.addCell(celdas);
        return data;
    }
}
