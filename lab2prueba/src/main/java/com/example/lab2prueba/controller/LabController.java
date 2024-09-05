package com.example.lab2prueba.controller;

import com.example.lab2prueba.model.Auto;
import com.example.lab2prueba.model.Sede;
import com.example.lab2prueba.model.Seguro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LabController {

    ArrayList<Auto> listaAutos = new ArrayList<>();
    ArrayList<Sede> listaSedes = new ArrayList<>();
    ArrayList<Seguro> listaSeguros = new ArrayList<>();

    //Listas
    @GetMapping("/sedes")
    public String listarSedes(Model model){
        model.addAttribute("listaSedes",listaSedes);
        return "listaSedes";
    }
    @GetMapping("/autos")
    public String listarAutos(Model model){
        model.addAttribute("listaAutos",listaAutos);
        return "listaAutos";
    }
    @GetMapping("/seguros")
    public String listarSeguros(Model model){
        model.addAttribute("listaSeguros",listaSeguros);
        return "listaSeguros";
    }

    //Form de agregar elemento
    @GetMapping("/formSede")
    public String AddFormSede(Model model){
        Sede sede = new Sede();
        model.addAttribute("sede",sede);
        return "agregarSede";
    }
    @PostMapping("/formSede/registro")
    public String registrarSede(Sede sede){

        listaSedes.add(sede);
        return "redirect:/sedes";
    }

    @GetMapping("/formAuto")
    public String AddFormAuto(Model model){
        Auto auto = new Auto();
        model.addAttribute("auto",auto);
        return "agregarAuto";
    }
    @PostMapping("/formAuto/registro")
    public String registrarAuto(Auto auto){
        listaAutos.add(auto);
        return "listaAutos";
    }

    @GetMapping("/formSeguro")
    public String AddFormSeguro(Model model ){
        Seguro seguro = new Seguro();
        model.addAttribute("seguro",seguro);
        return "agregarSeguro";
    }
    @GetMapping("/editarSede/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        Sede sedeEdit = null;
        for (Sede s : listaSedes) {
            if (s.getIdSede() == id) {
                sedeEdit = s;
                break;  // Detenemos el bucle cuando encontramos la sede
            }
        }
        model.addAttribute("sede", sedeEdit);  // Agrega la sede encontrada al modelo
        return "editarSede";
    }
    @PostMapping("/editarSede/{id}")
    public String editarSede(@PathVariable("id") int id, Sede sedeAct){
        for (Sede sede : listaSedes) {
            if (sede.getIdSede() == id) {
                sede.setDistrito(sedeAct.getDistrito());
                sede.setDireccion(sedeAct.getDireccion());
                break;
            }
        }
        return "redirect:/sedes";
    }
    @PostMapping("/borrarSede/{id}")
    public String borrarSede(@PathVariable("id") int id) {
        listaSedes.removeIf(sede -> sede.getIdSede() == id);
        return "redirect:/sedes";
    }

}
