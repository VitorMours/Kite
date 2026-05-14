# Kite

<p  align="center">
  <a href="https://go-skill-icons.vercel.app/">
    <img
      src="https://go-skill-icons.vercel.app/api/icons?i=mysql,docker,githubactions,nginx,rabbitmq,celery,playwright,python,fastapi,java,spring,jwt,html,css,javascript,jquery&theme=dark"
    />
  </a>
</p>

O **Kite** surgiu de uma ideia, de criar uma ferramenta de processamento de contratos de troca 
dentro do csgo, como forma de achar as trocas mais eficientes, e mais lucrativas dentro de um sistema. Isso também 
permite determinar a forma como os usuários podem ter mais chances de lucrarem com seus atuais inventários. A ideia é 
que por meio de ferramentas como o **Auto-Gamble**, ele consiga ver todas as possibilidades de contratos de troca, de 
forma a ver quais possuem as maiores chances de serem produtivos, e quais possuem as menores chances de serem produtivos.

Temos que no quesito arquiteutural e estrutural, vamos ter o core da aplicação rodando dentro do ecossistema spring boot,
sendo desenvolvido usando conceitos de arquitetura limpa e TDD, de forma a criar uma api robusta e escalável. Também vai 
ser possível por meio de comunicação por meio de message brokers, como o rabbitmq, que ele se comunique com o scrapper, de 
forma a acionar ele e fazer com que o mesmo faça os processos de extração de dados de maneira muito mais eficiente e direta.
Todos esses dados devem ser servidos e apresentados. Com isso, temos ue o front-end vai ser desenvolvido com tecnologias 
que facilitam o uso reatividade, de forma a facilitar o nosso desenvolvimento, usando react, e outras ferramentas como o 
context api e o tailwindcss