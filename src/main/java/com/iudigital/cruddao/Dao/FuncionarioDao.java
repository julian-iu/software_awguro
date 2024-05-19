
package com.iudigital.cruddao.Dao;

import com.iudigital.cruddao.Util.ConnexionUtil;
import com.iudigital.cruddao.domain.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
    //variables
    private static final String GET_CARS = "select * from funcionarios";
    
    private static final String CREATE_CAR = "insert into funcionarios (numero_identificacion, nombres, apellidos,sexo, direccion, telefono,fecha_nacimiento,estado_civil)"
            + "values (?, ?, ?, ?, ?,?,?,?) ";
    
    private static final String GET_CAR_BY_ID = "select * from funcionarios where funcionario_id = ? ";
    
    private static final String UPDATE_CAR = "update funcionarios set numero_identificacion=?, nombres=?, "
            + "apellidos=?,sexo=?, direccion=?, telefono=?,fecha_nacimiento=?,"
            + "estado_civil=? where funcionario_id = ? ";
    
    private static final String DELETE_CAR = "delete from funcionarios where funcionario_id = ? ";
    // METODO PARA LISTAR ARRAYLIST
    public List<Funcionario> obtenerFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> Funcionarios = new ArrayList<>();

        try {
           // INICIALISAMOS LA CONEXION PARA LLENAR LOS PARAMETROS Y OBTENER LA LISTA
            connection = ConnexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CARS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
                Funcionarios.add(funcionario);
            }
            return Funcionarios;
            
        } finally {
            
            if (connection != null) {
                connection.close();
            }
            
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    // METODO PARA CREAR LOS FUNCIONARIO
    public void crear(Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnexionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_CAR);
            preparedStatement.setString(1, funcionario.getNumero_identificacion());
            preparedStatement.setString(2, funcionario.getNombres());
            preparedStatement.setString(3, funcionario.getApellidos());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getDireccion());
            preparedStatement.setString(6, funcionario.getTelefono());
            preparedStatement.setString(7, funcionario.getFecha_nacimiento());
            preparedStatement.setString(8, funcionario.getEstado_civil());
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Funcionario obtenerFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;

        try {

            connection = ConnexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_CAR_BY_ID);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                funcionario = new Funcionario();
                funcionario.setFuncionario_id(resultSet.getInt("funcionario_id"));
                funcionario.setNumero_identificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombres(resultSet.getString("nombres"));
                funcionario.setApellidos(resultSet.getString("apellidos"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
                funcionario.setEstado_civil(resultSet.getString("estado_civil"));
            }
            return funcionario;

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
  //METODOS PARA ACTUALIZAR
    public void actualizarFuncionario(int id, Funcionario funcionario) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CAR);
            preparedStatement.setString(1, funcionario.getNumero_identificacion());
            preparedStatement.setString(2, funcionario.getNombres());
            preparedStatement.setString(3, funcionario.getApellidos());
            preparedStatement.setString(4, funcionario.getSexo());
            preparedStatement.setString(5, funcionario.getDireccion());
            preparedStatement.setString(6, funcionario.getTelefono());
            preparedStatement.setString(7, funcionario.getFecha_nacimiento());
            preparedStatement.setString(8, funcionario.getEstado_civil());
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
    // METODO PARA ELIMINAR
    public void eliminarFuncionario(int id) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnexionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_CAR);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } finally {
            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
}

