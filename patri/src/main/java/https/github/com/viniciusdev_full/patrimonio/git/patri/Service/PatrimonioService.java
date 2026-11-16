package https.github.com.viniciusdev_full.patrimonio.git.patri.Service;

import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;
import https.github.com.viniciusdev_full.patrimonio.git.patri.repository.PatrimonioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class PatrimonioService {

    @Autowired

    private PatrimonioRepository repository;


    public List<Patrimonio>listarTodos(){
    return repository.findAll();

    }

    public Optional<Patrimonio>buscarPorId(Long Id){
        return repository.findById(Id);

    }

    public Patrimonio Salvar(Patrimonio patrimonio){
        return repository.save(patrimonio);

    }

    public void Deletar(Long Id){
        repository.deleteById(Id);

    }


















}
