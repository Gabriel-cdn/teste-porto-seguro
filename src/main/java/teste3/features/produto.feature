Feature: Realizar testes com o produto do banco de automacao

Background:
  Given inicio cenario
  And acessa ao site principal

@cenario1
Scenario: Validar especificacoes do produto
  And clica no menu "Special Offer"
  When clica no botao "See offer"
  Then as especificacoes do produto devem estar de acordo com as informacoes retornadas do banco de automacao
  And finaliza cenario

@cenario2
Scenario: Validar alteracao de cor do produto no carrinho
  And clica no menu "Special Offer"
  And clica no botao "See offer"
  And altera a cor do produto de acordo com a cor informada no banco de automacao
  When clica no botao "Add to cart"
  Then o produto deve ser adicionado ao carrinho com a cor selecionada
  And finaliza cenario

@cenario3
Scenario: Validar pagina de checkout
  And pesquisa o nome do produto do banco de automacao clicando no icone de lupa
  And selecionar produto pesquisado
  And altera a cor do produto para uma diferente da existente no banco de automacao
  And altera a quantidade de produtos que deseja comprar
  And clica no botao "Add to cart"
  When acessa a pagina de checkout
  Then a soma dos precos deve corresponder ao total apresentado na pagina de checkout
  And realiza um update no banco de automacao alterando a cor existente no banco para a cor selecionada no teste
  And finaliza cenario

@cenario4
Scenario: Remover produto do carrinho de compras
  And clica no menu "Special Offer"
  And clica no botao "See offer"
  And clica no botao "Add to cart"
  And clica no carrinho de compras
  When remove produto do carrinho de compras
  Then o carrinho de compras deve estar vazio
  And finaliza cenario