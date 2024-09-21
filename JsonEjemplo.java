package com.Jsons;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonEjemplo {
	private static void sc(String cadena) {
        System.out.println(cadena);
    }
	public void lecturaJSON() {
        String archivoJSON = "src\\resources\\Usuarios.json";
        try {
           
            String contenido = new String(Files.readAllBytes(Paths.get(archivoJSON)));

            JSONObject objetoJSON = new JSONObject(contenido);

            JSONArray usuarios = objetoJSON.getJSONArray("Usuarios");

            for (int i = 0; i < usuarios.length(); i++) {
                JSONObject usuario = usuarios.getJSONObject(i);

                String nombre = usuario.getString("nombre");
                String telefono = usuario.getString("telefono");
                String direccion = usuario.getString("direccion");

                sc("Nombre: " + nombre);
                sc("Teléfono: " + telefono);
                sc("Dirección: " + direccion);
                sc("--------------------");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void escribirJSON(Scanner sc) {
        String archivoJSON = "src\\resources\\Usuarios.json";
        try {
        	
            String contenido = new String(Files.readAllBytes(Paths.get(archivoJSON)));

            JSONObject objetoJSON = new JSONObject(contenido);

            JSONArray usuarios = objetoJSON.getJSONArray("Usuarios");

            sc("Ingrese su nombre:");
            String nombre = sc.nextLine();

            sc("Ingrese su teléfono:");
            String telefono = sc.nextLine();

            sc("Ingrese su dirección:");
            String direccion = sc.nextLine();

            JSONObject nuevoUsuario = new JSONObject();
            nuevoUsuario.put("nombre", nombre);
            nuevoUsuario.put("telefono", telefono);
            nuevoUsuario.put("direccion", direccion);

            usuarios.put(nuevoUsuario);

            objetoJSON.put("Usuarios", usuarios);

            Files.write(Paths.get(archivoJSON), objetoJSON.toString(4).getBytes(), StandardOpenOption.TRUNCATE_EXISTING);

            sc("Nuevo usuario agregado correctamente.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
