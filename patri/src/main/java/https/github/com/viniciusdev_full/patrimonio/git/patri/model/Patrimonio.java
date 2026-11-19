
package https.github.com.viniciusdev_full.patrimonio.git.patri.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_patrimonio")
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_patrimonio", nullable = false, length = 50)
    private String nrPatrimonio;

    @Column(name = "local", nullable = false, length = 255)
    private String local;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    // Construtor vazio
    public Patrimonio() {
    }

    // Construtor completo
    public Patrimonio(Long id, String nrPatrimonio,
                      String local, String descricao) {
        this.id = id;
        this.nrPatrimonio = nrPatrimonio;
        this.local = local;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNrPatrimonio() {
        return nrPatrimonio;
    }

    public void setNrPatrimonio(String nrPatrimonio) {
        this.nrPatrimonio = nrPatrimonio;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
