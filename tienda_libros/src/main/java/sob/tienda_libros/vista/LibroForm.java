package sob.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sob.tienda_libros.repositorio.LibroRepositorio;
import sob.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import java.awt.*;

@Component
public class LibroForm extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;

    @Autowired
    public LibroForm(LibroServicio libroServicio){
        this.libroServicio=libroServicio;
        inicarForm();
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
}