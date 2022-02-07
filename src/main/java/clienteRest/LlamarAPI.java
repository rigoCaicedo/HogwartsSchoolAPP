package clienteRest;

import com.hogwarts.domain.Estudiante;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rigot
 */
@Component
public class LlamarAPI{
 
    public Estudiante buscarAlumno(int id){
        RestTemplate restTemplate= new RestTemplate();
        Estudiante estudiante = restTemplate.getForObject("https://hogwartsschoolapi.azurewebsites.net/api/Estudiantes/"+id ,Estudiante.class);
        return estudiante;
    }
    
    public static Estudiante[] listarAlumnos(){
        RestTemplate restTemplate= new RestTemplate();
        var estudiantes = restTemplate.getForObject("https://hogwartsschoolapi.azurewebsites.net/api/Estudiantes/" ,Estudiante[].class);
        
        return estudiantes;
    }

}
