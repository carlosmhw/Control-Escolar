
package Aplicacion;
public class ValidarPantallaAdmin {
    boolean flag = false;
    public boolean validarLlenarTodo(String nombre,String apPaterno,
            String apMaterno,String calle,String colonia,
            String telCasa,String telMovil,String corrPers,String contrasena,
            String numero,String carrera){
        
        if(nombre.equals("") || apPaterno.equals("") || apMaterno.equals("") || calle.equals("") || colonia.equals("") 
                || telCasa.equals("")|| telMovil.equals("") || corrPers.equals("")|| contrasena.equals("") || numero.equals("")||
                        carrera.equals("")){
            flag = true;
            
        }
        return flag;
    }
    
}
