#language:pt
#encoding:UTF-8
@SuiteLojaAutomation
Funcionalidade: Validar dados de um produto

Contexto: 
		Dado que o site e-commerce esteja sendo exibido
        E que o cliente esteja logado

  @CompraTresProdutos
  Cenario: Compra de tres produtos
    Quando adicionar os produtos desejados
    E validar que os produtos foram para o carrinho
    Entao efetuo a compra dos itens
    E valido a compra efetuada com sucesso