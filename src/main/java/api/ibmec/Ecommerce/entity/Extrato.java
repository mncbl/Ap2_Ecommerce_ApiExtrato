package api.ibmec.Ecommerce.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import org.springframework.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Container(containerName = "pedidos")
public class Extrato {

    @Id
    private String id;

    @PartitionKey
    private String cpf;

    private String productName;

    private double price;

    private LocalDateTime dataCompra;

}
