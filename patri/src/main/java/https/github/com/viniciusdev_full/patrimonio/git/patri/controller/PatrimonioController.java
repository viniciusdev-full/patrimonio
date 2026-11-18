package https.github.com.viniciusdev_full.patrimonio.git.patri.controller;


import https.github.com.viniciusdev_full.patrimonio.git.patri.Service.PatrimonioService;
import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@Controller
@RequestMapping("/patrimonios")

public class PatrimonioController {
    @Autowired
    private PatrimonioService service;

    //listar todos os patrimonios

    @GetMapping
    public String listar(Model model){
        model.addAttribute("listarPatrimonios",service.listarTodos());
        return "Listar";
    }

    //formulario para novo patrimonio

    @GetMapping("/novo")
    public String novoformulario(Model model){
        model.addAttribute("patrimonio",new Patrimonio());
        return "formulario";
    }

    //formulario para editar patrimonio existente

    @GetMapping("/editar/{Id}")
    public String editarformulario(@PathVariable("Id")Long Id,Model model){
        Optional<Patrimonio>patrimonio = service.buscarPorId(Id);
        if(patrimonio.isPresent() ){
            model.addAttribute("patrimonio",patrimonio.get());

            return "formulario";

        }
        return "redirect:/patrimonios";

    }

    //salvar/ataulizar patrimonio

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("patrimonio")Patrimonio patrimonio){
        service.Salvar(patrimonio);
        return "redirect:/patrimonios";
    }

    //excluir patrimonio

    @GetMapping("/excluir/{Id}")
    public String excluir(@PathVariable("Id")Long Id){
        service.Deletar(Id);
        return "redirect:/patrimonios";
    }




}
