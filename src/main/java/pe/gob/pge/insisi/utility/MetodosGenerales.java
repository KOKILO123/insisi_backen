package pe.gob.pge.insisi.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import pe.gob.pge.insisi.entity.Usuario;
import pe.gob.pge.insisi.repository.UsuarioSesionRepositorio;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class MetodosGenerales {

	public static final Date capturarFechaActual(){
        // Obtener la fecha y hora actual
        LocalDateTime now = LocalDateTime.now();

        // Definir el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Formatear la fecha y hora actual
        String formattedNow = now.format(formatter);

        // Imprimir la fecha formateada (opcional)
        System.out.println("Formatted Date: " + formattedNow);

        // Convertir LocalDateTime a Date
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        // Devolver el objeto Date
        return date;
    }

    public static final Long captutarUsuarioID(UsuarioSesionRepositorio usuarioSesionRepositorio){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name =auth.getName();
        Usuario usuario = usuarioSesionRepositorio.BuscarUsuario(name)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese username o email : " + name));
        Long usuariol= (long) usuario.getUsuarioId();
        return  usuariol;
    }
    

}
