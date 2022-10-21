
# Funcionamento do Sistema

[Link protocolo](https://docs.google.com/spreadsheets/d/1Gjys73_gtiCY9MKNksQyY0NIzIDkiwHdtqvJzyfLHfs/edit#gid=0)

## Requisitos Não Funcionais

### Estado do usuário são:

0: off-line
1: disponível
2: indisponível


### Mensagens

- Será usado JSON para a troca de dados;

- No protocolo só será especificado os campos obrigatórios, mas cada equipe pode colocar adicionais.


### Identificação da operação no envio do cliente:
Será utilizado o nome da operação no campo “operacao” do JSON da mensagem enviada pelo cliente.
Operações:
-login;
-cadastrar;
-logout;


### Identificação da operação no envio do servidor:
Proposta 1: Será utilizado códigos únicos para as respostas de sucesso do servidor para o cliente, sendo possível individualizar cada operação pelo código. O código será enviado pelo campo “status” da mensagem enviada pelo servidor.
Status sucesso: 201 (Cadastro), 200 (Login), 600 (Logout)


Proposta 2: Nas mensagens do servidor também conterá o campo “operacao”. 
Operações:
-login;
-cadastrar;
-logout;

## Requisitos Funcionais

### Cliente

[Cadastro] (nome, descrição do usuário, senha, username, categoria do usuário)
[Login] (username, senha)
	O username usado no software será o R.A. (sem o "a")

[Home]
Pedirá a lista de categorias para o servidor
Selecionar categoria (de serviço)

→ Busca Usuário
Envia um pedido de listagem dos usuários para o servidor (com filtro de categoria selecionada)
Mostra o resultado recebido do servidor

[Chat]
Selecionar um usuário para o chat
Enviar um pedido de chat para o servidor
Se o usuário estiver online e disponível o servidor iniciará o chat (servidor marcará os dois usuários como indisponíveis)
Acontecerá o chat na janela do chat
Qualquer um dos dois usuários do chat pode encerrar o chat


### Servidor

[Cadastro] Checar se o username já existe. Se não, armazenar os dados de cadastro enviado pelo cliente
	O servidor vai checar se o r.a. já existe no BD ou não
O servidor retorna sucesso ou mensagem de erro

[Login] Buscar o username no BD. Se existir verifica se os dados estão corretos.
	O servidor checa se os dados estão corretos (e o r.a. existe)
O servidor retorna uma mensagem informando o sucesso ou não do pedido de login

[Home] 
→ Busca Usuário
O servidor enviará a lista de categorias à pedido do cliente
O servidor recebe um pedido de listagem dos usuários por categoria
O servidor envia a lista de usuários para o cliente
O Servidor irá enviar uma atualização da lista a cada mudança de estado da lista de clientes

[Chat]
O servidor vai receber um pedido de chat do usuário
O servidor vai verificar se os usuários estão disponíveis (estado '1')
Se os usuários estiverem disponíveis, o servidor estabelecerá uma conexão com cada usuário
O servidor mudará o estado dos usuários como indisponíveis (status '2')
O servidor vai mandar as mensagens para cada usuário
O servidor recebe um pedido de fechamento do chat e o encerra
