package api.ibmec.Ecommerce.repository;

import api.ibmec.Ecommerce.entity.Extrato;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface ExtratoRepository extends CosmosRepository<Extrato, String> {
    List<Extrato> findById(int id);
}