package juanarboleda.springthymeleafclase.controladores;
import juanarboleda.springthymeleafclase.modelo.dao.IDepartamentosDAO;
import juanarboleda.springthymeleafclase.modelo.dao.IEmpleadosDAO;
import juanarboleda.springthymeleafclase.modelo.entidades.EntidadDepartamentos;
import juanarboleda.springthymeleafclase.modelo.entidades.EntidadEmpleados;
import juanarboleda.springthymeleafclase.servicio.ServicioDepartamentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class ViewController {

    @Autowired
    ServicioDepartamentos servicioDepartamentos;

    @Autowired
    IEmpleadosDAO empleadosDAO;

    @Autowired
    IDepartamentosDAO departamentosDAO;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/verdepartamentos")
    public String mostrarDepartamentos(Model model) {

        List<EntidadDepartamentos> departamentos = servicioDepartamentos.mostrarDepartamentos();
        model.addAttribute("departamentos", departamentos);
        return "verdepartamentos";
    }

    @GetMapping("/altadepartamento")
    public String altadepartamento(Model model){

        model.addAttribute("departamento",new EntidadDepartamentos());
        return "altadepartamento";
    }

    @PostMapping("/altadepartamento")
    public String creartDepartamento(@ModelAttribute EntidadDepartamentos departamento, Model model){

        if(servicioDepartamentos.guardarDepartamento(departamento)){

            model.addAttribute("tipo_operacion", "ok");
            model.addAttribute("mensaje", "Departamento creado correctamente");

        }else{

            model.addAttribute("tipo_operacion", "error");
            model.addAttribute("mensaje", "Error al crear el departamento: clave duplicada");

        }
        return "altadepartamento";
    }

    @GetMapping("/verempleado")
    public String mostrarEmpleado(Model model, @RequestParam(name = "id", required = true) int id) {
        Optional<EntidadEmpleados> empleado = empleadosDAO.findById(id);
        if (!empleado.isPresent()) {
            model.addAttribute("titulo", "Error");
            model.addAttribute("mensaje", "No se encontro el empleado con el id " + id);
            return "error";
        }
        model.addAttribute("empleado", empleado.get());
        return "verempleado";
    }

    @GetMapping("/verempleados")
    public String mostrarEmpleados(Model model, @RequestParam(name = "depno", required = false) Integer depno) {
        List<EntidadDepartamentos> departamentos = (List<EntidadDepartamentos>) departamentosDAO.findAll();
        model.addAttribute("departamentos", departamentos);
        List<EntidadEmpleados> empleados;

        if (depno == null)
            empleados = (List<EntidadEmpleados>) empleadosDAO.findAll();
        else
            empleados = (List<EntidadEmpleados>) empleadosDAO.findAllByDepno(departamentosDAO.findById(depno));

        model.addAttribute("empleados", empleados);
        return "verempleados";
    }

}
