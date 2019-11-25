# CaixaWS
Webservice para incluir e alterar boletos da Caixa Econômica Federal.

Como usar o Micro Serviço

1. Hospede em um servidor ApacheTomcat 8+
2. Acesse o serviço através de WEBSERVICE REST
2.1 Utilize a função POST para INCLUIR_BOLETO
2.2 Utilize a função PUT para ALTERAR_BOLETO

Exemplo de requisição
´´´´´´´´´´´´

POST: http://localhost:8084/CaixaWS/rest/boleto
HEADER:
 Accept: application/json
 Content-type: application/json
BODY:
´´json
{
	"agencia" : 1294,
	"codigoBeneficiario" : "945414",
	"cpfCnpjBeneficiario" : "09.023.204/0001-12",
	"nossoNumero" : "14000000000000001",
	"numeroDocumento" : "1",
	"vencimento" : "2019-11-30",
	"valor" : 1.00,
	"aceite" : true,
	"juros" : {
		"tipo" : "ISENTO",
		"valor" : "0.00"
	},
	"posVencimento" : {
		"acaoPosVencimento" : "DEVOLVER",
		"dias" : 99
	},
	"cpfPagador" : "07375446431",
	"nomePagador" : "Weibson Santos",
	"endereco" : "Rua Anunciada da Rocha Melo, 116",
	"bairro" : "Madalena",
	"cidade" : "Recife",
	"uf" : "PE",
	"cep" : "50710-390",
	"fichaCompensacao" : [
		{ "mensagem" : "Mensagem ficha de compensação 01" },
		{ "mensagem" : "Mensagem ficha de compensação 02" }
	],
	"reciboPagador" : [
		{ "mensagem" : "Mensagem recibo 01" },
		{ "mensagem" : "Mensagem recibo 02" },
		{ "mensagem" : "Mensagem recibo 03" },
		{ "mensagem" : "Mensagem recibo 04" }
	],	
	"tipoPagamento" : "NAO_ACEITA_VALOR_DIVERGENTE",
	"quantidade" : 1
}
´´
