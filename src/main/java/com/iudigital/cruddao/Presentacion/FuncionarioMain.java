
package com.iudigital.cruddao.Presentacion;

import com.iudigital.cruddao.Controller.FuncionarioController;
import com.iudigital.cruddao.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;


public class FuncionarioMain {
  public static void obtenerFuncionarios(FuncionarioController funcionarioController) {
        
        try {
            List<Funcionario>  funcionarios= funcionarioController.obtenerFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay funcionarios ");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("Id: " + funcionario.getFuncionario_id());
                    System.out.println("documento: " + funcionario.getNumero_identificacion());
                    System.out.println("nombre: " + funcionario.getNombres());
                    System.out.println("Apellido: " + funcionario.getApellidos());
                    System.out.println("sexo: " + funcionario.getSexo());
                    System.out.println("Direcccion: " + funcionario.getDireccion());
                    System.out.println("Telefono: " + funcionario.getTelefono());
                    System.out.println("Fecha nacimiento: " + funcionario.getFecha_nacimiento());
                    System.out.println("Estado Civil: " + funcionario.getEstado_civil());
                    System.out.println("-------------------------------------------");
                });
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        
        FuncionarioController funcionarioController = new FuncionarioController();
        obtenerFuncionarios(funcionarioController);
    }
}
