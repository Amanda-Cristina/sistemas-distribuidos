/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author dinha
 */
public class Main {
  public Categoria categorias;

  public static void main(String[] args) throws JSONException {
      
    int teste = Categoria.valueOf("mecanico").ordinal();
    //System.out.println(teste);
    
    JSONObject reply = new JSONObject();
      //JSONObject parametro = new JSONObject();
    JSONObject dados = new JSONObject();
    
    reply.put("dados", dados);
    reply.put("mensagem", "Parâmetros enviados não correspondem à operação!");
    reply.put("status", 400);
    
    int categoria = reply.getInt("status");
    System.out.println(categoria);
    
     
}}
