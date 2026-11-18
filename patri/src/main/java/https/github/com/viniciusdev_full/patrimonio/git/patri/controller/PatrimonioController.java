
package https.github.com.viniciusdev_full.patrimonio.git.patri.controller;

import https.github.com.viniciusdev_full.patrimonio.git.patri.Service.PatrimonioService;
import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patrimonios")
public class PatrimonioController {

    @Autowired
    private PatrimonioService service;

    // Listar todos os patrimônios
    @GetMapping
    public String lista(Model model) {
        model.addAttribute("listarPatrimonios",
                service.listarTodos());

        return "lista";
    }

    // Formulário para novo patrimônio
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("patrimonio", new Patrimonio());

        return "formulario";
    }

    // Formulário para editar patrimônio
    @GetMapping("/editar/{id}")
    public String editarFormulario(
            @PathVariable("id") Long id,
            Model model) {

        return service.buscarPorId(id)
                .map(patrimonio -> {
                    model.addAttribute("patrimonio", patrimonio);
                    return "formulario";
                })
                .orElse("redirect:/patrimonios");
    }

    // Salvar ou atualizar patrimônio
    @PostMapping("/salvar")
    public String salvar(
            @ModelAttribute("patrimonio") Patrimonio patrimonio) {

        service.Salvar(patrimonio);

        return "redirect:/patrimonios";
    }

    // Excluir patrimônio
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id) {

        service.Deletar(id);

        return "redirect:/patrimonios";
    }
}
