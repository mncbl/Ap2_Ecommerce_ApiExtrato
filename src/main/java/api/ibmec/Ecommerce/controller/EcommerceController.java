package api.ibmec.Ecommerce.controller;


import api.ibmec.Ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import api.ibmec.Ecommerce.entity.Extrato;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/ecommerce/extrato")
public class EcommerceController {

    @Autowired
    private ProductService productService;

    // Get de Teste e introdução da API
    @GetMapping()
    public String introducao() {
        return "Olá, esta é a API do nosso e-commerce!";
    }

    // Método GET para buscar extratos pelo CPF
    @GetMapping("/buscar-por-cpf/{cpf}")
    public ResponseEntity<List<Extrato>> getExtratosByCpf(@PathVariable String cpf) {
        List<Extrato> extratos = productService.findCpf(cpf);
        if (extratos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(extratos);
    }

    // Método GET para buscar um extrato pelo ID do pedido
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<Extrato> getExtratoById(@PathVariable String id) {
        Optional<Extrato> extrato = productService.findById(id); // Buscar pelo ID
        return extrato.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Método POST para criar um novo extrato
    @PostMapping
    public ResponseEntity<Extrato> criarExtrato(@Valid @RequestBody Extrato extrato) {
        Extrato novoExtrato = productService.salvarExtrato(extrato);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoExtrato);
    }
}
