# RPCG
O RPCG (Role-Playing Card Game) é um sistema de RPG (Role-Playing Game) criado por Pedro Henrique Mendes Siqueira Silva cujo troca todo sistema de dados de um RPG convencional por cartas e busca objetivamente um sistema mais modular e menos rígido de Gameplay.<br />
Este projeto no Github nasce primeiramente comigo, Felipe Pinheiro Rocha, querendo fazer um projeto de back-end em Java-Spring para o meu portfólio e decidindo fazer um criador de ficha personalizável no sistema RPCG.

<img src="https://user-images.githubusercontent.com/127625793/232535394-de807a1c-bd2f-4ff8-b0b5-72f3b118231b.jpg" width="600" title="Ficha de Exemplo">

## Momento atual do projeto
- [x] Criação e organização do banco de dados do sistema do jogo 
- [x] Fazer requisições que armazena atributos e talentos das fichas
- [ ] Criar um sistema de login
- [ ] Deixar o usuário criar itens e atribuir eles a ficha

## Organização do banco de dados do sistema do jogo
O banco de dados não devem só armazenar os dados da Ficha, como também mostrar todos talentos, atributos e afins que a pessoa teria que ler para poder montar a sua ficha.<br />
Há também um detalhe que modifica extremamente a organização das tabelas, o sistema do jogo é constantemente mudado e adaptado por que ele ainda se encontra em periodo de teste, então nomes e descrições de habilidade são mudados em algumas seções. Além disso, está sendo adaptado o sistema base do jogo que se passa no universo do Jogo de Zelda, mas as tabelas tem que ser adaptável para a criação de sistemas que se passem em outros universos.<br />
Indo para a parte técnica, o banco de dados é utilizando as *migrations* o *flyway* em um banco de dados em PostgreSQL. As tabelas base do sistema do jogo foram criadas e preenchidas, quando necessário, com o sistema base.

## Requisições que armazena atributos e talentos das fichas
Salvar todos os valores na ficha que o jogador pode decidir e calcular todos os restantes automaticamente. Provavelmente a parte mais fundamental na criação de ficha já que Talentos geram decisões opcionais e alteram valores de atributos.<br />
Basicamente a maneira que está sendo aplicado é a *entidade* JPA que está relacionado com a *tabela* tem as váriaveis e calculos básicos, mas um *serviço* chamado **ConstrutorDeFicha** é o que aplica as *regras de negócio*.

## Problemas conhecidos
- Esse projeto é feito como um portfólio primeiramente, então quando se tem alguma decisão que não precisaria de uma aplicação tão robusta ela muitas vezes é escolhida já que o intuito primevo do projeto é mostrar habilidades do criador.
