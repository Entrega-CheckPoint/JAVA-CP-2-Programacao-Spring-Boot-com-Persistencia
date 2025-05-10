package fiap.com.br.checkpoint.Dto;

import java.util.List;

public interface GenericDao<T,K> {
    T cadastrar (T entidade);

    void remover(K id);

    T buscar(K id);

    List<T> listar();

}
