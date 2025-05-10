package fiap.com.br.checkpoint.Dao;

import fiap.com.br.checkpoint.Model.Brinquedo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BrinquedoDaoImpl extends GenericDaoImpl<Brinquedo, Integer> implements BrinquedoDao {

    public BrinquedoDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    @Transactional
    public Brinquedo cadastrar(Brinquedo entidade) {
        return super.cadastrar(entidade);
    }

}
