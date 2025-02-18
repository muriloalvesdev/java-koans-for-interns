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
Para executar os testes, utilize o runner customizado. Se você configurar o plugin exec-maven-plugin no pom.xml, poderá executar:
```bash
mvn exec:java -Dexec.mainClass="com.koans.framework.KoanRunner"
```

Ou, alternativamente, execute a classe KoanRunner diretamente pela sua IDE.

### Contribuindo
Contribuições são bem-vindas! Se você tiver ideias de novos koans ou melhorias, sinta-se à vontade para abrir um Pull Request.
