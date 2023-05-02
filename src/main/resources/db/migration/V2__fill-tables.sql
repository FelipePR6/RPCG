INSERT INTO atributos(nome, cor) VALUES
('Força', 'VERMELHO'),
('Destreza', 'VERMELHO'),
('Inteligência', 'AZUL'),
('Percepção', 'AZUL'),
('Força de Vontade', 'VERDE'),
('Magia', 'VERDE');

---------------------Talentos
---- Força
INSERT INTO talentos(nome, atributo_id) VALUES ('Atletismo',1);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Força.<br>• Proficiência em testes de Arremesso.', 1), (
	2, '• Você não sofre penalidade de movimentação quando carregar algo do seu tamanho/peso ou menor.<br>• Você ataca com VANTAGEM o alvo que você está agarrando.', 1), (
	3, '• VANTAGEM em testes de Força.<br>• Não sofre desvantagem quando atacar segurando uma arma de duas mãos com apenas uma mão.', 1);

INSERT INTO talentos(nome, atributo_id) VALUES ('Mobilidade',1);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• +1 de movimentação.<br>• Você não precisa queimar carta para usar Disparada.', 2), (
	2, '• +1 de movimentação.<br>• Quando utilizar Disparada você ignora terreno difícil.', 2), (
	3, '• +1 de movimentação.<br>• Escalar e nadar não custam nenhum movimento extra.<br>• Encontrão: Você soma como bônus ao seu ataque, cada passo que der em linha reta antes de realizar um ataque.', 2);

INSERT INTO talentos(nome, atributo_id) VALUES ('Super Força',1);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Eleva em +1 o seu dano base corpo a corpo.', 3), (
	2, '• Potência: Você queima uma ação antes de realizar UM ataque corpo a corpo ou UMA ação Física.<br>• Você soma como bônus o seu atributo Força.', 3), (
	3, '• Potência Aprimorada: Se estiver utilizando Potência com as duas mãos, você dobra o valor bônus.', 3);

INSERT INTO talentos(nome, atributo_id) VALUES ('Robustez',1);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando receber algum dano de Concussão, Corte ou Perfuração você pode usar 2HP para receber metade do dano.', 4), (
	2, '• Agora o efeito se aplica a qualquer tipo de dano.', 4), (
	3, '• A primeira vez que você utiliza esse talento durante o turno, ele não tem custo de HP e mitiga 4 de dano.', 4);

INSERT INTO talentos(nome, atributo_id) VALUES ('Vigor',1);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• +1 de HP.<br>• Ganha +1 de HP para cada talento de Nível 1 nos Atributos Físicos. (incluindo esse Talento)', 5), (
	2, '• +1 de HP.<br>• Ganha +1 de HP para cada talento de Nível 2 e 3 nos Atributos Físicos. (incluindo esse Talento)', 5), (
	3, '• +10 de HP<br>• Imune a alguns venenos e doenças.', 5);

---- Destreza
INSERT INTO talentos(nome, atributo_id) VALUES ('Proficiência em Combate',2);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, 'Sempre que você comprar esse talento, adquire um dos 3 efeitos:<br>• Combate Desarmado: Proficiência em combate desarmado. Aprende todas as manobras de combate desarmado.<br>• Armas Brancas: Proficiência em armas brancas e escudo. Aprende todas as manobras de armas brancas e escudo<br>• Atirador: Proficiência em armas de longo alcance. Aprende todas as manobras de armas de longo alcance.', 6), (
	2, 'Sempre que você comprar esse talento, adquire um dos 3 efeitos:<br>• Combate Desarmado: Proficiência em combate desarmado. Aprende todas as manobras de combate desarmado.<br>• Armas Brancas: Proficiência em armas brancas e escudo. Aprende todas as manobras de armas brancas e escudo<br>• Atirador: Proficiência em armas de longo alcance. Aprende todas as manobras de armas de longo alcance.', 6), (
	3, 'Sempre que você comprar esse talento, adquire um dos 3 efeitos:<br>• Combate Desarmado: Proficiência em combate desarmado. Aprende todas as manobras de Combate Desarmado.<br>• Armas Brancas: Proficiência em armas brancas e escudo. Aprende todas as manobras de Armas Brancas e Escudo.<br>• Atirador: Proficiência em armas de longo alcance. Aprende todas as manobras de Atirador.', 6);

INSERT INTO talentos(nome, atributo_id) VALUES ('Reflexos em Combate',2);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando acontecer uma iniciativa, cartas Vermelhas também somam seu valor integral, ao invés de apenas 1.<br>• Pode entrar em Posição Defensiva usando uma reação.', 7), (
	2, '• Ataque Duplo: Com UMA ação, você faz uma jogada de ataque e queima uma carta. (Lutador pode ser aplicado para não queimar carta)<br>• Você realiza 2 ataques, os ataques precisam ser diferentes e em sequência direta, você não pode se mover entre esses dois ataques.<br>(Exemplos: um ataque com cada mão, ou, uma arma de duas mãos e um chute.)', 7), (
	3, 'Ataque Duplo Aprimorado: a carta queimada para o Ataque Duplo, pode ser adicionada à jogada de ataque.', 7);

INSERT INTO talentos(nome, atributo_id) VALUES ('Acrobacia',2);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando acontecer uma iniciativa, cartas Vermelhas também somam seu valor integral, ao invés de apenas 1.<br>• Pode entrar em Posição Defensiva usando uma reação.', 8), (
	2, '• Ataque Duplo: Com UMA ação, você faz uma jogada de ataque e queima uma carta. (Lutador pode ser aplicado para não queimar carta)<br>• Você realiza 2 ataques, os ataques precisam ser diferentes e em sequência direta, você não pode se mover entre esses dois ataques.<br>(Exemplos: um ataque com cada mão, ou, uma arma de duas mãos e um chute.)', 8), (
	3, 'Ataque Duplo Aprimorado: a carta queimada para o Ataque Duplo, pode ser adicionada à jogada de ataque.', 8);

INSERT INTO talentos(nome, atributo_id) VALUES ('Defesa sem Armadura',2);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Destreza.<br>• Quando você está caído, você pode se levantar gastando apenas 1 de movimento extra, ao invés da metade do seu deslocamento.', 9),(
	2, '• Dança Marcial: quando realizar uma ação de dança, para cada 10 pontos na ação, você se garante um bônus de +1 no IP e no seu Ataque.<br>O bônus dura o turno que você fez a dança e o próximo. Requer concentração para ser mantido.', 9),(
	3, '• VANTAGEM em testes de Destreza.', 9);

INSERT INTO talentos(nome, atributo_id) VALUES ('Furtividade',2);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Furtividade: abrir fechaduras, esconder-se de inimigos, escapar sem ser notado, ou aproximar-se de alguém sem ser visto ou ouvido.', 10), (
	2, '• Ataque Furtivo: para cada 10 pontos realizado na ação de furtividade, soma +1 no ataque contra criaturas que não estão te percebendo.<br>• Ataque Letal: quando realizar um ataque com VANTAGEM em um alvo que não esteja te percebendo, o ataque causa +1 de dano base e +1 por sucesso.', 10), (
	3, '• VANTAGEM em testes de Furtividade.<br>• Ataque Letal Aprimorado: mesmo se o alvo estiver te percebendo, você sempre aplica o dano bônus quando atacar com VANTAGEM.', 10);

---- Inteligencia
INSERT INTO talentos(nome, atributo_id) VALUES ('Arcano',3);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Pode utilizar o atributo Inteligência para fazer testes que utilizam o atributo Magia. ', 11), (
	2, '• Ganha 1MP máximo para cada 1 PONTO no atributo Inteligência.', 11), (
	3, '• Quanto utilizar o atributo Magia ou o Talento Arcanismo, você pode usar 1MP para que as cartas de cor azul e verde tenham seu valor contabilizado.', 11);

INSERT INTO talentos(nome, atributo_id) VALUES ('Perícia',3);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Adquire de todas as perícias de um desses caminhos:<br>• Artista - Médico - Ladino - Arcano - Caçador - Habilidoso - Naturalista - Inventor - Devoto - Guerreiro<br>• O bônus de perícia é igual ao nível do personagem, limitado em +4.', 12), (
	2, '• Adquire mais um caminho.<br>• O bônus de perícia é igual ao nível do personagem, limitado em +8.', 12), (
	3, '• Adquire mais um caminho.<br>• O bônus de perícia é igual ao nível do personagem, limitado ao valor do seu atributo Inteligência.', 12);

INSERT INTO talentos(nome, atributo_id) VALUES ('Sagacidade',3);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Inteligência, que NÃO envolvam Carisma ou Sobrevivência.', 13), (
	2, '• Uma vez por turno, quando utilizar uma Ação Simples, Ação de ajuda, Disparada ou Posição Defensiva, você ganha uma ação extra.', 13), (
	3, '• VANTAGEM em testes de Inteligência, que NÃO envolvam Carisma ou Sobrevivência.', 13);

INSERT INTO talentos(nome, atributo_id) VALUES ('Carisma',3);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes sociais.', 14), (
	2, '• Você pode Provocar ou Intimidar um alvo.', 14), (
	3, '• VANTAGEM em testes sociais.<br>• O valor do efeito de Provocar ou Intimidar é dobrado.', 14);

INSERT INTO talentos(nome, atributo_id) VALUES ('Sobrevivência',3);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Sobrevivência.<br>• Resiliência: ganha +1 de HP para cada 4 PONTOS na soma dos Atributos Mentais.', 15), (
	2, '• Durante um descanso curto, você recupera HP equivalente a sua Resiliência.<br>• Resiliência: ganha +1 de HP para cada 3 PONTOS na soma dos Atributos Mentais.', 15), (
	3, '• VANTAGEM em testes de Sobrevivência.<br>• Resiliência: ganha +1 de HP para cada 2 PONTOS na soma dos Atributos Mentais. ', 15);

---- Percepção
INSERT INTO talentos(nome, atributo_id) VALUES ('Percepção',4);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando realizar uma ação Física ou reação de Ataque/Esquiva/Escudo, cartas Azuis somam um bônus de +1.', 16), (
	2, '• Quando realizar uma ação Física ou reação de Ataque/Esquiva/Escudo, cartas Azuis somam um bônus de +2.', 16), (
	3, '• Quando realizar uma ação Física ou reação de Ataque/Esquiva/Escudo, cartas Azuis somam um bônus de +3.', 16);

INSERT INTO talentos(nome, atributo_id) VALUES ('Sentidos Aguçados',4);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Ganha +1 de Iniciativa para cada talento de Nível 1 nos Atributos Mentais. (incluindo esse Talento)', 17), (
	2, '• Ganha +1 de Iniciativa para cada talento de Nível 2 e 3 nos Atributos Mentais. (incluindo esse Talento)', 17), (
	3, '• Ganha +4 de Iniciativa.', 17);

INSERT INTO talentos(nome, atributo_id) VALUES ('Prontidão',4);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Percepção.', 18), (
	2, '• Não pode ser surpreendido enquanto estiver consciente.<br>• Sentido Cego: Se você é capaz de ouvir, sabe a localização de qualquer criatura escondida ou invisível ao seu redor (1,5 metros). Você não sofre as desvantagens de lutar no escuro.', 18), (
	3, '• VANTAGEM em testes de Percepção.<br>• Você aumenta o alcance do Sentido Cego para 15 metros ao seu redor. (10 quadrados)', 18);

INSERT INTO talentos(nome, atributo_id) VALUES ('Oportunista',4);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Seu ataque de oportunidade não pode ser evitado por Posição Defensiva.<br>• Você ganha um ataque de oportunidade contra qualquer um que realizar um ataque com desvantagem CONTRA você.', 19), (
	2, '• Se sua iniciativa for maior do que a do alvo, seu ataque de oportunidade é feito com VANTAGEM.<br>• Você ganha um ataque de oportunidade contra qualquer um que realizar um ataque com desvantagem ao seu redor.', 19), (
	3, '• Criaturas provocam seu ataque de oportunidade quando entram em seu alcance.', 19);

INSERT INTO talentos(nome, atributo_id) VALUES ('Sentinela',4);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Sua primeira Ação Simples durante o seu turno não tem nenhum custo de carta.<br>• Você compra uma carta se não utilizar nenhuma carta durante o seu turno.', 20), (
	2, '• Você não precisa queimar uma carta para usar Ação de Ajuda.', 20), (
	3, '• Sua Ação de Ajuda é aplicada nos próximos 2 ataques ao invés de em apenas 1.<br>• Se você estiver próximo de uma criatura que realiza um ataque onde você não é o alvo, você pode queimar uma carta para aplicar desvantagem ao ataque.', 20);


---- Força de Vontade
INSERT INTO talentos(nome, atributo_id) VALUES ('Coragem',5);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Força de Vontade.', 21), (
	2, '• Você pode usar 2HP para aprimorar em 10 o seu teste de Força de Vontade.', 21), (
	3, '• VANTAGEM em testes de Força de Vontade.', 21);

INSERT INTO talentos(nome, atributo_id) VALUES ('Bravura',5);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Você nunca sofre penalidade de cartas.', 22), (
	2, '• No começo do seu turno, pode gastar 2HP para começar o turno com 4 cartas na mão.', 22), (
	3, '• Não precisa gastar HP para fazer o efeito do nível 2.', 22);

INSERT INTO talentos(nome, atributo_id) VALUES ('Fúria',5);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando realizar um ataque corpo a corpo, você pode gastar 2HP para: adicionar uma carta da sua mão ao ataque OU queimar uma carta e adicionar uma carta bônus aleatória ao ataque.<br>• O ataque com Fúria causa um dano bônus de +1 por sucesso.', 23), (
	2, '• Se o ataque com Fúria atingir 2 sucessos, você pode comprar uma carta.', 23), (
	3, '• Se o ataque com Fúria atingir 3 sucessos, você pode adicionar mais uma carta, fazendo isso, o dano bônus passa a ser +2 por sucesso.', 23);

INSERT INTO talentos(nome, atributo_id) VALUES ('Inspirar',5);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, 'Você pode inspirar os outros sobrenaturalmente por meio de um instrumento musical mágico, enquanto estiver tocando ele.<br>• No seu turno, você pode usar uma ação e queimar uma carta para fazer com que um alvo compre uma carta extra de inspiração.<br>Um alvo não pode possuir mais do que UMA carta extra de inspiração.', 24), (
	2, '• Você pode usar Inspirar como REAÇÃO, aprimorando a ação de um alvo com uma carta da sua mão.', 24), (
	3, '• Quando você ou alguém utilizar uma carta com efeito especial, você pode queimar uma carta para dobrar ou anular o efeito especial dessa carta.<br>• Sempre que usar Inspirar, pelo custo de 2HP você recuperar 2HP do alvo inspirado.', 24);

INSERT INTO talentos(nome, atributo_id) VALUES ('Ímpeto',5);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Quando realizar qualquer ação Fisica ou Mental, pelo custo de 2HP por carta, você pode escolher até duas cartas de cor Verde para ter seu valor contabilizado.', 25), (
	2, '• Custa 2HP para DUAS CARTAS Verdes.', 25), (
	3, '• Custa 2HP para TRÊS CARTAS Verdes.<br>• Você pode comprar para a sua mão, uma das cartas verdes contabilizadas.', 25);

---- Magia
INSERT INTO talentos(nome, atributo_id) VALUES ('Aptidão Mágica',6);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Aprende todas as magias de nível 1.<br>Sempre que usar alguma magia, você pode escolher entre virar uma carta de Proficiência, ou reduzir o custo de Mana em 1 ponto.', 26), (
	2, '• Aprende todas as magias de nível 2.', 26), (
	3, '• Aprende todas as magias de nível 3.', 26);

INSERT INTO talentos(nome, atributo_id) VALUES ('Afinidade Elemental',6);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, 'Você adquire afinidade elemental com um desses elementos: Fogo, Gelo ou Tempestade.<br>• A Afinidade Elemental te dá 8 de resistência extra contra o Efeito Elemental.<br>• Pelo custo de 1MP por ataque, você pode aplicar dano elemental com armas/escudos/flechas/desarmado.', 27), (
	2, 'Você adquire afinidade elemental com um desses elementos: Fogo, Gelo ou Tempestade.<br>• A Afinidade Elemental te dá 8 de resistência extra contra o Efeito Elemental.<br>• Pelo custo de 1MP por ataque, você pode aplicar dano elemental com armas/escudos/flechas/desarmado.', 27), (
	3, 'Você adquire afinidade elemental com um desses elementos: Fogo, Gelo ou Tempestade.<br>• A Afinidade Elemental te dá 8 de resistência extra contra o Efeito Elemental.<br>• Pelo custo de 1MP por ataque, você pode aplicar dano elemental com armas/escudos/flechas/desarmado.<br><br>• Se possuir no mínimo 10 no atributo Magia, voce adquire afinidade elemental com um desses elementos: Luz ou Sombra.', 27);

INSERT INTO talentos(nome, atributo_id) VALUES ('Sentir Magia',6);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Proficiência em testes de Sentir Magia.<br>• Meditação: Pelo custo de 1MP, você pode terminar o seu turno meditando, essa ação não custa carta. Você começa com 1 carta extra no próximo turno.<br>VOCÊ NÃO PODE REAGIR. O efeito final da Meditação só acontece no começo do seu próximo turno. (teste de resistência de concentração)', 28), (
	2, '• Quando utilizar Meditação, você pode utilizar até 2MP para começar com 1 carta extra e ter três ações durante o seu turno.<br>• Você pode fazer reações sem quebrar a Meditação.', 28), (
	3, '• VANTAGEM em testes de Sentir Magia.<br>• Pode utilizar Projeção Astral utilizando 3MP.', 28);

INSERT INTO talentos(nome, atributo_id) VALUES ('Fluxo de Mana',6);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• +1 de MP.<br>• Ganha +1 de MP para cada talento de Nível 1 nos Atributos Espirituais. (incluindo esse)<br>• Quando algum efeito tem custo de HP, você pode substituir 1 de HP do custo por 1 de MP.', 29), (
	2, '• +1 de MP.<br>• Ganha +1 de MP para cada talento de Nível 2 e 3 nos Atributos Espirituais. (incluindo esse)<br>• Quando algum efeito tem custo de HP, você pode substituir 2 de HP do custo por 1 de MP.', 29), (
	3, '• Quando utilizar uma magia, você não precisa escolher entre reduzir o custo de mana ou aplicar Proficiência, voce agora faz os dois efeitos ao mesmo tempo.', 29);

INSERT INTO talentos(nome, atributo_id) VALUES ('Imbuir com Mana',6);
INSERT INTO nivel_talento(nivel, descricao, talento_id) VALUES (
	1, '• Pode usar magia mesmo com as mãos ocupadas e pode fazer com que suas armas, escudos, instrumentos musicais e golpes desarmados sejam considerados mágicos.<br>• Aprender uma dessas 3 habilidades mágicas: Vinculo de Mana, Aura ou Golpe Aprimorado.<br><br>Golpe Aprimorado<br>• Pelo custo de 1MP por ataque, você pode causar +1 de dano base e +1 de dano por sucesso. Esse ataque ganha um alcance mágico equivalente a 1,5 metros para cada ponto no atributo Magia.', 30), (
	2, 'Vínculo de Mana<br>• Aprenda um ritual que cria um vínculo mágico entre você e um item. Você realiza o ritual ao longo de 1 hora, o que pode ser feito durante um descanso.<br>O item deve estar ao seu alcance durante todo o ritual, na conclusão em que você toca no item e forja o vínculo.<br>Depois de ligar um item a si mesmo, você não pode ser separado desse item, a menos que esteja incapacitado. Você pode convocar esse item com uma ação que não gasta carta durante seu turno, fazendo com que ele se teletransporte instantaneamente para a sua mão/corpo.<br>• Cada item diminui no mínimo em 2 a Mana máxima enquanto durar o vínculo. (Dependendo do tamanho do item/arma/armadura, o custo aumenta.)<br>• Pode aplicar Furor com uma arma que tenha vínculo. (Furor é uma manobra de Combate Desarmado)', 30), (
	3, 'Aura<br>• Pelo custo de 1MP, pode fazer UMA ação OU UMA reação para emanar UM talento. Você compartilha esse talento com criaturas que estejam na sua Aura.<br>O efeito dura até o começo do seu próximo turno.<br>O alcance da sua Aura é equivalente a 1,5 metros para cada ponto no atributo Magia.', 30);

