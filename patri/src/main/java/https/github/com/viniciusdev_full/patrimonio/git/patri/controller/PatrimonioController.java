
package https.github.com.viniciusdev_full.patrimonio.git.patri.controller;

import https.github.com.viniciusdev_full.patrimonio.git.patri.Service.PatrimonioService;
import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patrimonios")
public class PatrimonioController {

    private final PatrimonioService service;

    public PatrimonioController(PatrimonioService service) {
        this.service = service;
    }

    // Listar patrimônios
    @GetMapping
    public String lista(Model model) {

        model.addAttribute("listarPatrimonios",
                service.listarTodos());

        return "lista";
    }

    // Novo patrimônio
    @GetMapping("/novo")
    public String novo(Model model) {

        model.addAttribute("patrimonio", new Patrimonio());

        return "formulario";
    }

    // Editar patrimônio
    @GetMapping("/editar/{id}")
    public String editarFormulario(
            @PathVariable Long id,
            Model model) {

        return service.buscarPorId(id)
                .map(patrimonio -> {
                    model.addAttribute("patrimonio", patrimonio);
                    return "formulario";
                })
                .orElse("redirect:/patrimonios");
    }

    // Salvar patrimônio
    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute("patrimonio") Patrimonio patrimonio) {

        service.salvar(patrimonio);

        return "redirect:/patrimonios";
    }

    // Excluir patrimônio
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {

        service.deletar(id);

        return "redirect:/patrimonios";
    }
}
