package br.com.educandoweb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.entities.Cliente;
import br.com.educandoweb.entities.Pedido;
import br.com.educandoweb.entities.enuns.PedidoStatus;
import br.com.educandoweb.repositories.ClienteRepository;
import br.com.educandoweb.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Cliente u1 = new Cliente(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Cliente u2 = new Cliente(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Pedido o1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAID, u1);
		Pedido o2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.WAITTING_PAYMENT, u2);
		Pedido o3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.WAITTING_PAYMENT, u1);

		clienteRepository.saveAll(Arrays.asList(u1, u2));
		pedidoRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
