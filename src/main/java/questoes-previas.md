### 1) Como sabemos, testar uma aplicação requer conhecimentos de técnicas que possibilitem validar e cobrir todos os requisitos de uma funcionalidade. Considerando isso, cite as técnicas de testes de software que você conhece comentando também sobre as suas diferenças e aplicabilidade.

- Pode-se citar o teste de caixa branca que consiste em utilizar o código-fonte do sistema testado, com o objetivo de analisar as diversas partes do sistema, o fluxo de dados, a qualidade e segurança do código.
- Existe também o teste de caixa preta, em contraste com a técnica anterior, não se tem conhecimento do código, apenas se analisa a entrada e a saída dos dados, focando no aspecto funcional do sistema, por isso esse tipo também é chamado de teste funcional.
- Tem-se também o teste unitário que é a técnica mais básica de teste, pois a sua finalidade consiste em testar de forma isolada cada componente menor do sistema.
- Em contra ponto a esta última técnica, existe o teste de integração que seria realizar testes com vários componentes e módulos integrados para descobrir se as funcionalidades funcionam juntas sem falhas.
- Existe também o teste de regressão, considerado nas situações de implantações de novas versões do sistema, ou seja, testes de retrocompatibilidade com versões anteriores do sistema procurando por possíveis falhas
- Pode-se mencionar também testes mais específicos não voltados para funcionalidade como teste de carga que verifica se o sistema suporta o processamento esperado para ele. Também o teste de estresse que busca verificar até que ponto o sistema suporta um processamento muito alto. Além do teste de usabilidade com a finalidade de verificar a aceitação para possíveis usuários do sistema.


### 2) Comente sobre os tipos de testes de software existentes e suas finalidades.

- Os testes de software podem ser divididos praticamente em dois tipos: testes funcionais e testes não funcionais.
- Como o próprio nome diz os testes funcionais tem como finalidade verificar as funcionalidades e a lógica de negócios planejada para o sistema, como por exemplo, testes unitários, de integração, caixa-preta e de regressão, mencionados na questão anterior.
- Já os testes não funcionais são voltados para aspectos do sistema que não dependem das funções do sistema, como por exemplo, teste de usabilidade, desempenho, velocidade, carga, estresse, escalabilidade e segurança, também mencionados na questão anterior.
- Pode-se mencionar também os testes manuais, cuja execução é feita de forma presencial por alguém a interagir no sistema, e os testes automatizados cuja execução é feito por uma máquina/computador. Existem os testes de api cujos passos dos testes usam apenas chamadas internas sem precisar de interface e pode-se falar também dos testes dirigidos a dados, cuja função é realizar o mesmo teste várias vezes, porém cada vez com um dado diferente.


### 3) Uma das principais características de um engenheiro de qualidade é a técnica de entender os comportamentos existentes dentro de fluxos de negócio e/ou histórias de usuários e transcrevê-las, juntamente com a área de negócio, de uma forma simples e fácil de ser compreendida. Essa técnica permite que uma documentação seja criada logo na fase de planejamento e, dessa forma, servirá como guia para desenvolvedores e documentação das funcionalidades, eliminando a barreira entre pessoas técnicas e não técnicas da equipe. Considerando isso, cite a prática a qual estamos nos referindo acima.

- BDD (Behavior Driven Development) ou desenvolvimento orientado a comportamento
