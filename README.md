Repositório criado para realizar o seguinte desafio:

Funcionais:

O aplicativo deve ser capaz de buscar/cadastrar/atualizar/deletar um cliente;
O aplicaƟvo deve ser capaz de buscar clientes pela razão social, nome fantasia e CNPJ;
A listagem deve ter uma versão simples em Smartphone e uma versão com detalhes ao lado para Tablet;
Um cliente pode ser pessoa jurídica ou física. Se for pessoa Física, deve ter CPF, nome (utilizar campo Razão Social), e-mail principal, e-mail secundário, vários endereços (mínimo de 1). Se for pessoa Jurídica, deve trocar o CPF por CNPJ e adicionar o campo de nome fantasia.
O aplicaƟvo deve ser capaz de buscar todos os produtos separados pelo seu status:

 NORMAL
 P. ESTOQUE
 LANÇAMENTO
 PROMOÇÃO
 
O aplicativo deve exibir na listagem de produtos: descrição. código, estoque, preço máximo e preço mínimo).
Ao pressionar um produto, deve exibir um dialog com todos os preços dele em ordem crescente.

Não-funcionais:

O aplicativo deve uƟlizar o banco SQLite. O modelo será passado com as tabelas;
O aplicativo deve ter como target SDK o SDk mais recente;
O aplicativo deve fazer uso das boas práticas de programação android;

Atenção:
Utilize ViewPager e TabLayout
Utilize o Material Design
Utilize NavigaƟon Drawer
Utilize o Modelo MVP.

Alguns ajustes foram realizados, foi utilizado arquitetura MVVM + Clean Architecture para o projeto, visando uma arquitetura mais robusta e atual. O BD que foi disponibilizado, foram necessários alguns ajustes, como remoção de colunas não utilizadas para simplificar as consultas.
