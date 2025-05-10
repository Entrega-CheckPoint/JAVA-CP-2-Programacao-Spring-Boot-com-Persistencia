package fiap.com.br.checkpoint.Dto;

import fiap.com.br.checkpoint.Model.Brinquedo;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BrinquedoDaoImpl extends GenericDaoImpl<Brinquedo, Integer> implements BrinquedoDto {

    public BrinquedoDaoImpl(EntityManager em) {
        super(em);
    }

    @Override
    @Transactional
    public Brinquedo cadastrar(Brinquedo entidade) {
        return super.cadastrar(entidade);
    }

}
