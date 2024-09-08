package sob.tienda_libros;

import org.hibernate.id.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import sob.tienda_libros.vista.LibroForm;

import java.awt.*;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contextoSpring =
				new SpringApplicationBuilder(TiendaLibrosApplication.class).headless(false).web(WebApplicationType.NONE).run(args);

		//Ejecucion Form
		EventQueue.invokeLater(()->{
			//Obtenemos Form desde Spring
			LibroForm libroForm= contextoSpring.getBean(LibroForm.class);
			libroForm.setVisible(true);
		});
	}

}
