package fiap.com.br.checkpoint.Dao;

import fiap.com.br.checkpoint.Exception.IdNaoEncontradoException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional
public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

    @PersistenceContext
    protected EntityManager em;

    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public GenericDaoImpl(EntityManager em) {
        this.clazz = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T cadastrar(T entidade) {
        return em.merge(entidade); // ou persist se for novo
    }

    @Override
    public void remover(K id) {
        T entidade = buscar(id);
        em.remove(entidade);
    }

    @Override
    public T buscar(K id) {
        T entidade = em.find(clazz, id);
        if (entidade == null)
            throw new IdNaoEncontradoException("ID NÃO ENCONTRADO");
        return entidade;
    }

    @Override
    public List<T> listar() {
        return em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
    }

}
