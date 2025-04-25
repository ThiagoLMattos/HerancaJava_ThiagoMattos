# Gerenciador de Funcionários 👥

Um sistema simples em Java para cadastro, listagem e execução de ações de funcionários, com base em herança e polimorfismo.  
Feito para fins de aprendizado e prática com POO.

## Funcionalidades ✨

- Cadastro de Funcionários:
  - Gerente
  - Desenvolvedor
  - Estagiário

- Listagem de todos os funcionários cadastrados
- Execução de ações específicas:
  - Gerente: `realizarReuniao()`
  - Desenvolvedor: `programar()`
  - Estagiário: `fazerTarefa()`
- Ação comum para todos os funcionários: `baterPonto()`

## Como usar 🛠️

1. Compile todos os arquivos `.java`:

```bash
javac -source 8 -target 8 *.java
java Main

