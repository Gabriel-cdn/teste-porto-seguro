Feature: Realizar testes com o produto do banco de automacao

Background:
  Given acessa ao site principal

@cenario1
Scenario: Validar especificacoes do produto
  And clica no menu "SPECIAL OFFER"
  When clica no botao "SEE OFFER"
  Then as especificacoes do produto devem estar de acordo com as informacoes retornadas do banco de automacao

@cenario2
Scenario: Validar alteracao de cor do produto no carrinho
  And clica no menu "SPECIAL OFFER"
  And clica no botao "SEE OFFER"
  And altera a cor do produto de acordo com a cor informada no banco de automacao
  When clica no botao "ADD TO CART"
  Then o produto deve ser adicionado ao carrinho com a cor selecionada

@cenario3
Scenario: Validar pagina de checkout
  And pesquisa o nome do produto do banco de automacao clicando no icone de lupa
  And selecionar produto pesquisado
  And altera a cor do produto para uma diferente da existente no banco de automacao
  And altera a quantidade de produtos que deseja comprar
  And clica no botao "ADD TO CART"
  When acessa a pagina de checkout
  Then a soma dos precos deve corresponder ao total apresentado na pagina de checkout
  And realiza um update no banco de automacao alterando a cor existente no banco para a cor selecionada no teste

@cenario4
Scenario: Remover produto do carrinho de compras
  And clica no menu "SPECIAL OFFER"
  And clica no botao "SEE OFFER"
  And clica no botao "ADD TO CART"
  And clica no carrinho de compras
  When remove produto do carrinho de compras
  Then o carrinho de compras deve estar vazio