# teste-porto-seguro

Arquivo com o teste completo: [gabriel costa do nascimento-capgemini.zip](https://github.com/Gabriel-cdn/teste-porto-seguro/blob/main/gabriel%20costa%20do%20nascimento-capgemini.zip)

## Questões prévias

- As questões prévias foram respondidas no arquvio [questoes-previas.md](src/main/java/questoes-previas.md).

## Teste práticos

- Os testes práticos sem encontram separado cada um em sua pasta respectiva no pacote [src/main/java](src/main/java).

### Teste 1

- Tanto o Teste 1 como o 2 usam as classes do pacote `base` que contém os métodos básicos e comuns para interação via Selenium.
- Os testes unitários relativos a cada campo estão na classe [Suite.java](src/main/java/teste1/Suite.java).
- Para consideração de praticidade decidi realizar para cada campo um teste positivo e dois negativos com o objetivo de contemplar outras mensagens de erro em alguns casos.
- Utilizei o padrão `Page Object` encapsulando todos os métodos relativos a mesma página (out tela) [DadosIniciaisTela.java](src/main/java/teste1/DadosIniciaisTela.java) e também criando um classe de funcionalidade para reutilizar o máximo de código nos passos semelhantes [DadosIniciaisFunc.java](src/main/java/teste1/DadosIniciaisFunc.java). Como os campos são parecidos consegui aproveitar bastante código.

### Teste 2

- Para esse teste realizei a criação da request e verificação da response via Postman exportando a Collection e o Enviroment criados.
- Fiquei um pouco na dúvida porque a request precisaria ter sido feito via Pre-request script, mas segui a orientação do desafio proposto.
- Poderia ter validade cada campo comparando com o valor esperado, mas para ser mais prático resolvi validar apenas se não eram vazios.

### Teste 3

- Para esse teste usei o código sql para criar o banco de dados desejado [create-database.sql](src/main/resources/create-database.sql)
- Realizei a transcrição dos cenários em Gherkin no arquivo [produto.feature](src/main/java/teste3/features/produto.feature).
- Segui então com a implementação de cada passo usando o mesmo padrão de separar métodos de interação para cada página que seria acessado pelos testes dentro da pasta [telas](src/main/java/teste3/telas).
- A classe [TestRunner.java](src/main/java/teste3/runner/TestRunner.java) executa os quatro cenário em série.
- As interações com o banco de dados é feita através da classe [MySQLConnection.java](src/main/java/teste3/database/MySQLConnection.java) (para funcionar precisa trocar colocar a senha do banco).
