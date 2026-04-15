/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.btech.gerenciamento.repository;

import com.btech.gerenciamento.model.FuncionarioBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDAO {
    
    public List<FuncionarioBean> lerTodos(){
        List<FuncionarioBean> dados = new ArrayList();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                FuncionarioBean funcionario = new FuncionarioBean();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                
                dados.add(funcionario);
                
            }
            
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return dados;
    }
    
    public FuncionarioBean lerPorId (int id){
         FuncionarioBean funcionario = new FuncionarioBean();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            
            stmt = conn.prepareStatement("SELECT * FROM funcionario WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setDepartamento(rs.getString("departamento"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataContratacao(rs.getDate("data_contratacao"));
                
            }
                  
    } catch (SQLException e){
            e.printStackTrace();
    }
        return funcionario;
}
}
