package com.example.lab1.controller;

import com.example.lab1.model.Configuracion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class AhorcadoController {
    @GetMapping("/conf")
    public String configuracion(Model model){
        Configuracion config = new Configuracion();
        model.addAttribute("config", config);
        return "ahorcado";
    }
    @PostMapping("/conf/start")
    public String empezarJuego(Configuracion configur, Model model){
        int intentos = configur.getIntentos();
        int longitud = configur.getLongitud();
        String tema = configur.getTema();
        String[] palabras;

        switch (tema.toLowerCase()) {
            case "animales":
                palabras = new String[]{"leon", "elefante", "tigre", "cebra", "jirafa", "delfin", "ballena", "gorila", "panda", "aguila", "hipopotamo", "koala", "lobo", "oso", "canguro"};
                break;
            case "frutas":
                palabras = new String[]{"manzana", "platano", "kiwi", "mango", "pera", "uva", "fresa", "naranja", "pina", "sandia", "cereza", "melon", "papaya", "limon", "higo"};
                break;
            case "países":
                palabras = new String[]{"Mexico", "Canada", "Brasil", "España", "Francia", "Italia", "Alemania", "Japon", "Australia", "Argentina", "Chile", "Peru", "Estados Unidos", "China", "India"};
                break;
            default:
                model.addAttribute("error", "Tema no válido.");
                return "ahorcado";
        }

        ArrayList<String> palabrasFiltradas = new ArrayList<>();
        for (String palabra : palabras) {
            if (palabra.length() == longitud) {
                palabrasFiltradas.add(palabra);
            }
        }

        if (palabrasFiltradas.isEmpty()) {
            model.addAttribute("error", "No hay palabras disponibles para esa longitud.");
            return "ahorcado";
        }

        // Selecciona una palabra aleatoriamente entre las posibles
        Random random = new Random();
        String palabraSeleccionada = palabrasFiltradas.get(random.nextInt(palabrasFiltradas.size()));

        model.addAttribute("palabra", palabraSeleccionada);
        model.addAttribute("intentos", intentos);

        model.addAttribute("mensaje", "Juego iniciado con la palabra: " + palabraSeleccionada + ". Tienes " + intentos + " intentos.");
        return "game";
    }
}
