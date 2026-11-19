
package https.github.com.viniciusdev_full.patrimonio.git.patri.Service;

import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;
import https.github.com.viniciusdev_full.patrimonio.git.patri.repository.PatrimonioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrimonioService {

    private final PatrimonioRepository repository;

    public PatrimonioService(PatrimonioRepository repository) {
        this.repository = repository;
    }

    // Listar todos os patrimônios
    public List<Patrimonio> listarTodos() {
        return repository.findAll();
    }

    // Buscar patrimônio pelo ID
    public Optional<Patrimonio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Salvar ou atualizar patrimônio
    public Patrimonio salvar(Patrimonio patrimonio) {
        return repository.save(patrimonio);
    }

    // Excluir patrimônio
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
