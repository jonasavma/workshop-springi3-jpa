package br.com.educandoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.entities.Categoria;
import br.com.educandoweb.entities.Cliente;
import br.com.educandoweb.entities.Pagamento;
import br.com.educandoweb.entities.Pedido;
import br.com.educandoweb.entities.PedidoItem;
import br.com.educandoweb.entities.Produto;
import br.com.educandoweb.entities.enuns.PedidoStatus;
import br.com.educandoweb.repositories.CategoriaRepository;
import br.com.educandoweb.repositories.ClienteRepository;
import br.com.educandoweb.repositories.PedidoItemRepository;
import br.com.educandoweb.repositories.PedidoRepository;
import br.com.educandoweb.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoItemRepository pedidoItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Eletronico");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat3);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat1);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		// produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Cliente u1 = new Cliente(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Cliente u2 = new Cliente(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.WAITTING_PAYMENT, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.WAITTING_PAYMENT, u1);

		PedidoItem oi1 = new PedidoItem(o1, p1, 2, p1.getPreco());
		PedidoItem oi2 = new PedidoItem(o1, p3, 1, p3.getPreco());
		PedidoItem oi3 = new PedidoItem(o2, p3, 2, p3.getPreco());
		PedidoItem oi4 = new PedidoItem(o3, p5, 2, p5.getPreco());

		clienteRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		pedidoItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPagamento(pag1);
		
		pedidoRepository.save(o1);
		
	}

}
