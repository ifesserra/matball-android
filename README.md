# matball-android
Jogo MatBall. Parte ANDROID do Trabalho das disciplinas Engenharia de Software e Projeto de Sistemas
<p>Minimundo: O projeto Matball tem como objetivo o desenvolvimento de um jogo onde o objetivo do jogo é o estouro do maior numero de balões possíveis.
A dinâmica do jogo funciona da seguinte forma, cada balão possui uma questão de matemática e uma resposta, para estourar os balões é necessário selecionar a questão e sua respectiva resposta, para cada reposta certa os balões são estourados e a pontuação do jogador é aumentada, com o tempo a dificuldade das questões vão aumentando bem como a velocidade de subida dos balões, o termino do jogo acontece quando a quantidade de vidas acaba, sendo o total de 5 vidas, cada dupla de balão(questão e respectiva resposta) que subir até não ser vista mais na tela contará como 1 unidade de vida a menos.
O jogo é capaz de criar grupos de usuários para competirem entre eles, ou seja, o grupo possui um ranking decrescente de pontuações, há três tipos de grupos, grupo oculto, esse grupo é oculto a todos os usuários, sendo permitida a entrada apenas para aqueles que foram convidados pelo administrador ou pelos moderadores, o outro tipo de grupo é o privado, ele permanece visível a todos os usuários porém a entrada é feita através de uma solicitação do próprio usuário, onde o administrador ou moderador decidirão se permitem a entrada do mesmo, outra forma de entrada é através do convite emitido pelos moderadores ou administrador do grupo, o terceiro tipo de grupo é o publico, esse é visível para todos os usuários e qualquer usuário pode ter acesso a ele, o jogo possui a opção de sair dos grupos ao qual você pertence.
Cada grupo possui um administrador e até 5 moderadores, o administrador é o criador do grupo, ele pode transformar um usuário em um moderador ou um moderador em usuário comum. O administrador e os moderadores podem inserir e excluir os usuários dos grupos.
Além dos rankings nos grupos existe o ranking geral, e tanto os grupos quanto o ranking geral possuem duas formas de serem vistos, pela ordem decrescente de pontuações de todos os usuários, onde a maior pontuação é a maior pontuação já feita, e a outra forma é pela ordem decrescente de pontuações diárias onde a maior pontuação é a maior pontuação feita naquele dia.
O sistema possuirá um feedback onde o administrador ou o próprio usuário poderá ver onde mais errou e onde mais acertou.
As questões são baseadas em operações aritméticas de soma, subtração, multiplicação e divisão, podendo até ser usada mais de uma operação em cada questão presente nos balões.
O sistema deve ser capaz de cadastrar usuários, e permitir a criação de grupos, bem como formar o relatório de erros e acertos.<p>
<p>Requisitos Funcionais<p>
<ul>
<li>O sistema deve contabilizar o numero de acertos e erros.</li>
<li>O sistema deve gerar as operações e suas respectivas respostas a serem colocadas nos baloes.</li>
<li>O sistema deve contabilizar o numero de vidas.</li>
<li>O sistema deve ter a opção de pausar o jogo.</li>
<li>O sistema deve poder dar continuidade de um jogo pausado.</li>
</ul>
<p>Requisitos não funcionais<p>
<ul>
<li>O sistema deve controlar o acesso de usuários através de login e senha.</li>
<li>O sistema de jogo deve ser desenvolvido para uma plataforma mobile.</li>
<li>A GUI do sistema deverá ser intuitiva.</li>
<li>O sistema deve ser desenvolvido utilizando a linguagem java (mobile).</li>
<li>O sistema deve armazenar a senha dos usuários de forma segura</li>
<li>O sistema deve possuir uma SGBD</li>
</ul>
<p>Regras de negócio<p>
<ul>
<li>O jogo termina quando a quantidade de vidas chegar a zero.</li>
<li>O nivel de dificuldade aumenta coforme o tempo jogado.</li>
<li>A velocidade aumenta conforme o tempo jogado.</li>
</ul>
