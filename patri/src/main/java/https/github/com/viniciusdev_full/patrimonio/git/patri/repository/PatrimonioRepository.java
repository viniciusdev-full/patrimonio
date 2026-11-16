package https.github.com.viniciusdev_full.patrimonio.git.patri.repository;


import https.github.com.viniciusdev_full.patrimonio.git.patri.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatrimonioRepository extends JpaRepository<Patrimonio,Long>{



}
