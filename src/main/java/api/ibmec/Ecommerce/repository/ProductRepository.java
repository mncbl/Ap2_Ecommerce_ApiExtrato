package api.ibmec.Ecommerce.repository;

import api.ibmec.Ecommerce.entity.Extrato;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends CosmosRepository<Extrato, String> {
    List<Extrato> findByCpf(String cpf);
}

