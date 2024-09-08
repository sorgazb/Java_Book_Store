package sob.tienda_libros.vista;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sob.tienda_libros.modelo.Libro;
import sob.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField idTexto;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio=libroServicio;
        inicarForm();
        agregarButton.addActionListener(e -> agregarLibro());
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        modificarButton.addActionListener(e -> modificarLibro() );
        eliminarButton.addActionListener(e -> eliminarLibro());
    }

    private void eliminarLibro(){
        var renglon=tablaLibros.getSelectedRow();
        if(renglon!=-1){
            String idLibro = tablaLibros.getModel().getValueAt(renglon,0).toString();
            var libro = new  Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro "+idLibro+" eliminado.");
            limpiarForm();
            listarLibros();
        }else{
            mostrarMensaje("No se ha seleccionado ningun libro a eliminar.");
        }
    }

    private void modificarLibro(){
        if(this.idTexto.getText().equals("")){
            mostrarMensaje("ERROR. Debe seleccionar un registro.");
        }else{
            if(libroTexto.getText().equals("")){
                mostrarMensaje("Introduce el nombre del Libro.");
                libroTexto.requestFocusInWindow();
                return;
            }
            int idLibro = Integer.parseInt(idTexto.getText());
            var nombreLibro=libroTexto.getText();
            var autor=autorTexto.getText();
            var precio=Double.parseDouble(precioTexto.getText());
            var existencias=Integer.parseInt(existenciasTexto.getText());
            var libro=new Libro();
            libro.setIdLibro(idLibro);
            libro.setNombreLibro(nombreLibro);
            libro.setAutorLibro(autor);
            libro.setPrecioLibro(precio);
            libro.setExistenciasLibro(existencias);
            libroServicio.guardarLibro(libro);
            mostrarMensaje("Se modifico el Libro");
            limpiarForm();
            listarLibros();
        }
    }

    private void cargarLibroSeleccionado(){
        var renglon = tablaLibros.getSelectedRow();
        if(renglon != -1){
            String idLibro = tablaLibros.getModel().getValueAt(renglon, 0).toString();
            idTexto.setText(idLibro);
            String nombreLibro=tablaLibros.getModel().getValueAt(renglon,1).toString();
            libroTexto.setText(nombreLibro);
            String autor=tablaLibros.getModel().getValueAt(renglon,2).toString();
            autorTexto.setText(autor);
            String precio=tablaLibros.getModel().getValueAt(renglon,3).toString();
            precioTexto.setText(precio);
            String existencias=tablaLibros.getModel().getValueAt(renglon,4).toString();
            existenciasTexto.setText(existencias);
        }
    }

    private void agregarLibro(){
        if(libroTexto.getText().equals("")){
            mostrarMensaje("Introduce el Titulo del Libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        if(autorTexto.getText().equals("")){
            mostrarMensaje("Introduce el Autor del Libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        if(precioTexto.getText().equals("")){
            mostrarMensaje("Introduce el Precio del Libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        if(existenciasTexto.getText().equals("")){
            mostrarMensaje("Introduce las Existencias del Libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro=libroTexto.getText();
        var autor=autorTexto.getText();
        var precio=Double.parseDouble(precioTexto.getText());
        var existencias=Integer.parseInt(existenciasTexto.getText());

        var libro=new Libro();
        libro.setNombreLibro(nombreLibro);
        libro.setAutorLibro(autor);
        libro.setPrecioLibro(precio);
        libro.setExistenciasLibro(existencias);

        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se inserto el libro");
        limpiarForm();
        listarLibros();
    }

    private void limpiarForm(){
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this,mensaje);
    }

    private void inicarForm(){
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit= Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla= toolkit.getScreenSize();
        int x=(tamanioPantalla.width - getWidth()/2);
        int y= (tamanioPantalla.height - getHeight()/2);
        setLocation(x,y);
    }

    private void createUIComponents() {
        idTexto = new JTextField("");
        idTexto.setVisible(false);
        this.tablaModeloLibros= new DefaultTableModel(0,5);
        String[] cabecera={"ID","Libro","Autor","Precio","Existencias"};
       this.tablaModeloLibros.setColumnIdentifiers(cabecera);
       this.tablaLibros= new JTable(tablaModeloLibros);
       listarLibros();
    }

    private void listarLibros(){
        tablaModeloLibros.setRowCount(0);
        var libros= libroServicio.listarLibros();
        libros.forEach((libro)->{
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutorLibro(),
                    libro.getPrecioLibro(),
                    libro.getExistenciasLibro()
            };
            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
