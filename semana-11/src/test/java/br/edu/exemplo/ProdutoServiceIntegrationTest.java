package br.edu.exemplo;

import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProdutoServiceIntegrationTest {
    @Autowired
    ProdutoService service;

    @Autowired
    ProdutoRepository repository;

    @Test
    void deveCadastrarERecuperarProduto() {
        var cadastrado = service.cadastrar("Teclado", 150.0);

        assertNotNull(cadastrado.getId());

        var recuperado = repository.findById(cadastrado.getId()).orElseThrow();
        assertEquals("Teclado", recuperado.getNome());
        assertEquals(150.0, recuperado.getPreco());
    }

    @Test
    void naoDevePersistirProdutoComNomeEmBranco() {
        long quantidadeAntes = repository.count();

        assertThrows(IllegalArgumentException.class,
                () -> service.cadastrar("   ", 80.0));

        assertEquals(quantidadeAntes, repository.count());
    }

    @Test
    void deveAtualizarPrecoPersistido() {
        var cadastrado = service.cadastrar("Mouse", 80.0);

        service.atualizarPreco(cadastrado.getId(), 95.0);

        var recuperado = repository.findById(cadastrado.getId()).orElseThrow();
        assertEquals(95.0, recuperado.getPreco());
    }
}
