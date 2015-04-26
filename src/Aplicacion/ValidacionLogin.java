package Aplicacion;
import javax.swing.JOptionPane;
public class ValidacionLogin {
    boolean flag = false; 
    public boolean validarUsuario(String usuario, String contrasena){
        if(usuario.length()>7){
            JOptionPane.showMessageDialog(null,"Usuario no puede contener más de 7 caracteres.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }else if(usuario.equals("")){            
            JOptionPane.showMessageDialog(null,"Usuario no puede estar vacio.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }else if(usuario.length()<7){
            JOptionPane.showMessageDialog(null,"Usuario no puede contener menos de 7 caracteres.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }else if(contrasena.length()>20){
            JOptionPane.showMessageDialog(null,"Contraseña no puede ser mayor a 20 caracteres.", "Información", JOptionPane.INFORMATION_MESSAGE);
        
        }else if(contrasena.equals("")){
            JOptionPane.showMessageDialog(null,"Contraseña no puede estar vacio.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }else{
            flag = true; 
        }
        return flag;
    }
}
    
   
    
    

