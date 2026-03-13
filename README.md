# 🌙 Lunaris - Mail Service

Microserviço especializado para o envio e gerenciamento de comunicações por e-mail do ecossistema Lunaris.

## 📋 Sobre o Projeto

O **Lunaris Mail Service** é um componente desacoplado responsável por toda a comunicação transacional do sistema. Ele permite que a API principal dispare notificações sem ficar bloqueada aguardando o envio do e-mail, garantindo performance e confiabilidade.

* **📧 Templates Dinâmicos**: Envio de e-mails personalizados para alunos, professores e administradores.
* **⚡ Assincronismo**: Processamento de filas para garantir que nenhum e-mail seja perdido.
* **🛠️ Integração**: Conecta-se facilmente com provedores como SendGrid, Mailgun ou servidores SMTP tradicionais.

## 🚀 Tecnologias

* **Java 17** - Linguagem base
* **Spring Boot 3** - Framework principal
* **Spring Boot Starter Mail** - Abstração para serviços de e-mail
* **Thymeleaf** - Motor de templates para criar e-mails HTML dinâmicos
* **Spring Data JPA** - Registro de logs de envios (opcional)
* **Maven** - Gestão de build

## 📁 Estrutura do Projeto

```
lunaris-mail-service/
├── src/
│   ├── main/
│   │   ├── java/com/lunaris/mail/
│   │   │   ├── config/          # Configurações de SMTP e Beans
│   │   │   ├── controller/      # Endpoints para disparo manual/teste
│   │   │   ├── dto/             # Estrutura do payload de e-mail
│   │   │   ├── service/         # Lógica de montagem e envio de mensagens
│   │   │   └── consumer/        # Consumidor de filas (se usar RabbitMQ/Kafka)
│   │   └── resources/
│   │       ├── templates/       # Arquivos HTML dos e-mails (Thymeleaf)
│   │       ├── static/          # Logos e assets para os e-mails
│   │       └── application.yml  # Configurações de servidor de e-mail
├── pom.xml                      # Dependências do projeto
└── README.md

```

## 🛠️ Instalação

### Pré-requisitos

* Java JDK 17
* Maven 3.6+
* Um servidor SMTP para testes (Mailtrap é recomendado para desenvolvimento)

### Passo a passo

1. **Clone o repositório**

```bash
git clone https://github.com/Lunaris-School/lunaris-mail-service.git
cd lunaris-mail-service

```

2. **Configuração de Credenciais**
Edite o arquivo `src/main/resources/application.properties` com os dados do seu provedor de e-mail:

```properties
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=seu_usuario
spring.mail.password=sua_senha
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

```

3. **Build e Execução**

```bash
mvn clean install
mvn spring-boot:run

```

## 🎯 Funcionalidades Atuais

* ✅ **Boas-vindas**: E-mail automático para novos alunos e funcionários.
* ✅ **Recuperação de Senha**: Envio de tokens de segurança.
* ✅ **Notificações de Notas**: Alerta para alunos quando uma nova nota é lançada.
* ✅ **Comunicados Gerais**: Disparo de avisos da administração para toda a escola.

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para mais detalhes.

## 👥 Equipe

Desenvolvido com ❤️ pela equipe Lunaris

* Beatriz
* Breno
* Clara
* Giulia
* Isabela
* Maria Eduarda

## 📞 Contato

Para dúvidas ou sugestões, entre em contato:

* Email: lunaris.school@gmail.com

---

⭐ Se este projeto foi útil para você, considere dar uma estrela!
