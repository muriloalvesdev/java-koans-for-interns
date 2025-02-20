# Java Koans for Interns

Bem-vindo ao Java Koans for Interns!
Este projeto é um conjunto de pequenos testes (koans) feitos para ajudar estagiários e desenvolvedores iniciantes a aprender Java de forma prática e divertida. Cada koan é um teste que aborda um conceito específico da linguagem, desde operações básicas até tópicos mais avançados.

### Motivação
A ideia para criar este repositório surgiu de uma conversa com um amigo. Eu já possuía alguns koans em um repositório privado e decidi reestruturá-los completamente. Com o auxílio do GPT, explorei e refinei diversos cenários de teste, utilizando o padrão de koans que havia desenvolvido anteriormente.

### Sobre o Projeto
O projeto foi criado para ensinar os fundamentos de Java através de desafios práticos. Cada classe de koans contém métodos de teste (anotados com @Koan) que ilustram conceitos importantes como:

- **Operações Matemáticas**: adição, subtração, multiplicação, divisão, módulo, exponenciação, fatorial, Fibonacci, Bubble Sort, busca linear e binária, MDC.
- **Programação Orientada a Objetos**: criação de objetos, encapsulamento, herança, polimorfismo, classes abstratas, interfaces, inner classes, classes anônimas, clonagem, equals/hashCode e generics.
- **Padrões de Projeto Básicos**: Builder, Singleton, Observer.
- **Estruturas de Dados Personalizadas**: implementações simples de Stack e Queue.
- **Funcionalidades Modernas do Java**: Streams (filter, map, reduce, groupingBy, etc.), Optional, expressões lambda e referências de método.
- **Tratamento de Exceções**: blocos try-catch-finally, try-with-resources, exceções personalizadas.
- **Outros Conceitos**: Entrada/Saída de arquivos, serialização, reflexão, varargs, multithreading, concorrência, Timer/TimerTask, uso de expressões regulares, e muito mais!

### Como Usar
#### Pré-Requisitos
- Java 8 ou superior
- Maven instalado
- Git (para clonar o repositório)

### Compilando o Projeto
Navegue até o diretório raiz do projeto e execute:
```bash
mvn clean compile
```

### Executando os Koans
#### Executar Todos os Testes
Para executar os testes, utilize o runner customizado. Se você configurar o plugin exec-maven-plugin no pom.xml, poderá executar:
```bash
mvn exec:java -Dexec.mainClass="com.koans.framework.KoanRunner"
```

Ou, alternativamente, execute a classe KoanRunner diretamente pela sua IDE.

#### Executar um Teste Específico
Para executar apenas um teste específico, passe o nome do método ou uma parte de sua descrição como argumento. Por exemplo, para executar testes relacionados à "testExceptionHandling", utilize:
```bash
mvn exec:java -Dexec.mainClass="com.koans.framework.KoanRunner" -Dexec.args="testExceptionHandling"
```

Esse comando filtra e executa apenas os testes cujo nome do método de teste contenha a string informada (a busca é case-insensitive).

## Testando Seus Koans e Salvando sua solução!

##### 1. Crie sua Branch:
- Faça um fork ou clone desse repositório.
- Crie uma branch com exatamente o seu nome de usuário do GitHub (por exemplo, git checkout -b seu-usuario). Se o seu usuário no GitHub for joaodasilva, então a branch precisa se chamar joaodasilva.

##### 2. Resolva os Koans:
- Abra os arquivos de teste e resolva as falhas (você vai ver alguns testes falhando de propósito).
- Rode os testes localmente até ver tudo verdinho. Sem pressa!

##### 3. Faça o Commit e Suba a Branch:
- Quando achar que tudo está ok, `git add .` - `git commit -m "Finaliza koans"` (ou qualquer mensagem) e depois `git push origin sua-branch`

#### 4. Valide no CI
- Fique de olho no status do CI.
- Se passar nos testes, pronto! Você tem a sua versão deste repositório, com o seu nome, atestando que chegou no final sem tropeçar nos koans!

Por que fazer isso? Bom, além de ser uma forma de praticar Git, CI e expandir seu conhecimento em Java, você ainda sai com uma "prova" de que resolveu todas as missões. Pode até mandar o link pra galera no trabalho ou na faculdade! Ou só pra ver seu nome na lista de branches do repositório, rs. Enfim, a ideia é deixar tudo mais interativo e divertido. Boa sorte e divirta-se nos koans! Se aparecer qualquer dúvida, problemas esquisitos ou se você quebrar tudo sem querer, abre uma issue!

##### Bora evoluir nesses testes juntos!


### Importante: Por Que o CI Está Quebrado?
Você deve ter reparado que a branch `main` está com o **CI falhando**. Isso é de propósito. Os Koans têm testes que ainda não foram resolvidos, então o workflow no GitHub Actions vai continuar “vermelhinho” até que alguém os corrija.

A ideia é você forkar (ou clonar), criar a sua branch e ir passando nos Koans, até que o seu próprio CI fique verdinho. É quase como um mini-desafio: ao resolver todos os Koans, a sua branch provará que está tudo no lugar, e então o CI deve executar todos os testes e validar se você conseguiu!

Então não se assuste quando olhar o repositório e ver que os testes estão falhando na main: é uma forma de mostrar que esses exercícios estão aí pra serem resolvidos!

#### Contribuições são bem-vindas! Se você tiver ideias de novos koans ou melhorias, sinta-se à vontade para abrir um Pull Request.
