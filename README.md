# clean-architecture-java

Essa arquitetura fornece uma maneira melhor de criar aplicativos para melhor testabilidade, capacidade de manutenção e confiabilidade nas infraestruturas, como bancos de dados e serviços. O principal objetivo dessa arquitetura é abordar os desafios enfrentados pela arquitetura de três camadas ou pela arquitetura de n camadas e fornecer uma solução para problemas comuns, como acoplamento e separação de interesses. Existem dois tipos de acoplamento - acoplamento apertado e acoplamento frouxo.

Acoplamento forte

Quando uma classe depende de uma dependência concreta, diz-se que ela está fortemente acoplada a essa classe. Um objeto fortemente acoplado é dependente de outro objeto; isso significa alterar um objeto em um aplicativo fortemente acoplado, geralmente requer alterações em vários outros objetos. Não é difícil quando um aplicativo é pequeno, mas em um aplicativo de nível corporativo, é muito difícil fazer as alterações.

Acoplamento fraco

Isso significa que dois objetos são independentes e um objeto pode usar outro objeto sem depender dele. É uma meta de design que busca reduzir as interdependências entre os componentes de um sistema com o objetivo de reduzir of risco de que alterações em um componente exijam alterações em qualquer outro componente.
