/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import BancoDeDados.Conexao;

public class Conectar {

  public BancoDeDados.Conexao bd = new Conexao();
  
  public Conectar() {
    try {
      bd.conectar("localhost:3306", "root", "", "chat");
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("ERRO NA CONEXAO");
    }
  }
}  