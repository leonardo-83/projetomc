package com.example.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Categoria;
import com.example.demo.domain.Cidade;
import com.example.demo.domain.Cliente;
import com.example.demo.domain.Endereco;
import com.example.demo.domain.Estado;
import com.example.demo.domain.ItemPedido;
import com.example.demo.domain.Pagamento;
import com.example.demo.domain.PagamentoComBoleto;
import com.example.demo.domain.PagamentoComCartao;
import com.example.demo.domain.Pedido;
import com.example.demo.domain.Produto;
import com.example.demo.domain.enums.EstadoPagamento;
import com.example.demo.domain.enums.TipoCliente;
import com.example.demo.repositories.CategoriaRepository;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.EstadoRepository;
import com.example.demo.repositories.ItemPedidoRepository;
import com.example.demo.repositories.PagamentoRepository;
import com.example.demo.repositories.PedidoRepository;
import com.example.demo.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepositry;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instatiateTestDatabase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronico");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");


		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		Produto p4 = new Produto(null, "Mesa de escritório", 300.00);
		Produto p5 = new Produto(null, "Toalha", 50.00);
		Produto p6 = new Produto(null, "colcha", 200.00);
		Produto p7 = new Produto(null, "Tv true collor", 1200.00);
		Produto p8 = new Produto(null, "Roçadeira", 800.00);
		Produto p9 = new Produto(null, "Abajur", 100.00);
		Produto p10 = new Produto(null, "Pendente", 180.00);
		Produto p11 = new Produto(null, "Shampoo", 90.00);


		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4)); 
		cat3.getProdutos().addAll(Arrays.asList(p5, p6)); 
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7)); 
		cat5.getProdutos().addAll(Arrays.asList(p8)); 
		cat6.getProdutos().addAll(Arrays.asList(p9, p10)); 
		cat7.getProdutos().addAll(Arrays.asList(p11)); 


		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().addAll(Arrays.asList(cat2));
		p5.getCategorias().addAll(Arrays.asList(cat3));
		p6.getCategorias().addAll(Arrays.asList(cat3));
		p7.getCategorias().addAll(Arrays.asList(cat4));
		p8.getCategorias().addAll(Arrays.asList(cat5));
		p9.getCategorias().addAll(Arrays.asList(cat6));
		p10.getCategorias().addAll(Arrays.asList(cat6));
		p11.getCategorias().addAll(Arrays.asList(cat7));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
				
		 estadoRepository.saveAll(Arrays.asList(est1, est2));
		 cidadeRepositry.saveAll(Arrays.asList(c1, c2, c3)); 
		 
		 Cliente cli1 =  new Cliente(null, "Rogeria da Mata", "rogeria@gmail.com", "25725725725", TipoCliente.PESSOAFISICA);
		 cli1.getTelefones().addAll(Arrays.asList("00000000", "00000000"));
		 
		 Endereco e1 = new Endereco(null, "Rua Rua", "200", "Apto 101", "Jardim", "32456987", cli1, c1);
		 Endereco e2 = new Endereco(null, "Avenida Avenida", "100", "Casa 1", "Gonzaga", "32569789", cli1, c2);
		 
		 cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		 
		 clienteRepository.saveAll(Arrays.asList(cli1));
		 enderecoRepository.saveAll(Arrays.asList(e1, e2));
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");
		 
		 Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		 Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:32"), cli1, e2);
		 
		 Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		 ped1.setPagamento(pagto1);
		 
		 Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2020 00:00"), null);
		 ped2.setPagamento(pagto2);
		 
		 cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		 
		 pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		 pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		 
		 ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		 ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		 ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		 ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		 ped2.getItens().addAll(Arrays.asList(ip3));
		 
		 p1.getItens().addAll(Arrays.asList(ip1));
		 p2.getItens().addAll(Arrays.asList(ip3));
		 p3.getItens().addAll(Arrays.asList(ip2));
		 
		 itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}
}