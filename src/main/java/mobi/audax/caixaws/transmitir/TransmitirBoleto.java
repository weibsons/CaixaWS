/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.transmitir;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import mobi.audax.caixaws.enumm.AceiteEnum;
import mobi.audax.caixaws.enumm.OperacaoEnum;
import mobi.audax.caixaws.enumm.SistemaEnum;
import mobi.audax.caixaws.restful.model.Boleto;
import mobi.audax.caixaws.restful.model.BoletoResponse;
import mobi.audax.caixaws.restful.model.Mensagem;
import mobi.audax.caixaws.util.Util;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author links
 */
public class TransmitirBoleto {

    private Boleto boleto;
    private OperacaoEnum operacaoEnum;

    public BoletoResponse enviar(Boleto boleto, OperacaoEnum operacaoEnum) throws Exception {
        this.boleto = boleto;
        this.operacaoEnum = operacaoEnum;

        String soapEndpointUrl = "https://barramento.caixa.gov.br/sibar/ManutencaoCobrancaBancaria/Boleto/Externo";
        String soapAction = operacaoEnum.getOperacao();

        return callSoapWebService(soapEndpointUrl, soapAction);
    }

    private void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

//        String soapenv = "soapenv";
//        String soapenvURI = "http://schemas.xmlsoap.org/soap/envelope/";
        String ext = "ext";
        String extURI = "http://caixa.gov.br/sibar/manutencao_cobranca_bancaria/boleto/externo";

        String sib = "sib";
        String sibURI = "http://caixa.gov.br/sibar";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(ext, extURI);
        envelope.addNamespaceDeclaration(sib, sibURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();

        SOAPElement servicoEntrada = soapBody.addChildElement("SERVICO_ENTRADA", ext);
        SOAPElement header = servicoEntrada.addChildElement("HEADER", sib);
        this.headerBuild(header);
        SOAPElement dados = servicoEntrada.addChildElement("DADOS");
        SOAPElement incluiBoleto = dados.addChildElement(this.operacaoEnum.name());
        this.incluiBoletoBuild(incluiBoleto);
    }

    private void headerBuild(SOAPElement header) throws SOAPException {
        header.addChildElement("VERSAO").addTextNode("1.0");
        //<editor-fold defaultstate="collapsed" desc="Autenticação">
        StringBuilder auth = new StringBuilder();
        auth.append(StringUtils.leftPad(boleto.getCodigoBeneficiario(), 7, "0"));
        auth.append(StringUtils.leftPad(boleto.getNossoNumero(), 17, "0"));
        auth.append(new SimpleDateFormat("ddMMyyyy").format(boleto.getVencimento()));
        auth.append(StringUtils.leftPad(String.valueOf(boleto.getValor()).replace(".", ""), 15, "0"));
        auth.append(StringUtils.leftPad(boleto.getCpfCnpjBeneficiario(), 14, "0"));
        System.out.println("AUTH -> " + auth.toString());
        header.addChildElement("AUTENTICACAO").addTextNode(Util.sha256Base64(auth.toString()));
        //</editor-fold>
        header.addChildElement("USUARIO_SERVICO").addTextNode("SGCBS02P");
        header.addChildElement("OPERACAO").addTextNode(this.operacaoEnum.name());
        header.addChildElement("SISTEMA_ORIGEM").addTextNode(SistemaEnum.SIGCB.name());
        header.addChildElement("UNIDADE").addTextNode(this.boleto.getAgencia());
        header.addChildElement("DATA_HORA").addTextNode(new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime()));
    }

    private void incluiBoletoBuild(SOAPElement incluiBoleto) throws SOAPException {
        SimpleDateFormat isoDATE = new SimpleDateFormat("yyyy-MM-dd");

        incluiBoleto.addChildElement("CODIGO_BENEFICIARIO").addTextNode(this.boleto.getCodigoBeneficiario());

        SOAPElement titulo = incluiBoleto.addChildElement("TITULO");
        titulo.addChildElement("NOSSO_NUMERO").addTextNode(this.boleto.getNossoNumero());
        titulo.addChildElement("NUMERO_DOCUMENTO").addTextNode(this.boleto.getNumeroDocumento());
        titulo.addChildElement("DATA_VENCIMENTO").addTextNode(isoDATE.format(this.boleto.getVencimento()));
        titulo.addChildElement("VALOR").addTextNode(String.valueOf(this.boleto.getValor()));
        titulo.addChildElement("TIPO_ESPECIE").addTextNode("02");
        titulo.addChildElement("FLAG_ACEITE").addTextNode(this.boleto.isAceite() ? AceiteEnum.S.name() : AceiteEnum.N.name());
        if (this.operacaoEnum == OperacaoEnum.INCLUI_BOLETO) {
            titulo.addChildElement("DATA_EMISSAO").addTextNode(isoDATE.format(Calendar.getInstance().getTime()));
        }

        SOAPElement jurosMora = titulo.addChildElement("JUROS_MORA");
        jurosMora.addChildElement("TIPO").addTextNode(this.boleto.getJuros().getTipo().name());
        jurosMora.addChildElement("VALOR").addTextNode(this.boleto.getJuros().getValor());

        titulo.addChildElement("VALOR_ABATIMENTO").addTextNode("0.00");

        SOAPElement posVencimento = titulo.addChildElement("POS_VENCIMENTO");
        posVencimento.addChildElement("ACAO").addTextNode(this.boleto.getPosVencimento().getAcaoPosVencimento().name());
        posVencimento.addChildElement("NUMERO_DIAS").addTextNode(String.valueOf(this.boleto.getPosVencimento().getDias()));

        if (this.operacaoEnum == OperacaoEnum.INCLUI_BOLETO) {
            titulo.addChildElement("CODIGO_MOEDA").addTextNode("9");
        }

        SOAPElement pagador = titulo.addChildElement("PAGADOR");
        if (this.operacaoEnum == OperacaoEnum.INCLUI_BOLETO) {
            pagador.addChildElement("CPF").addTextNode(this.boleto.getCpfPagador());
        }
        pagador.addChildElement("NOME").addTextNode(this.boleto.getNomePagador());

        SOAPElement endereco = pagador.addChildElement("ENDERECO");
        endereco.addChildElement("LOGRADOURO").addTextNode(this.boleto.getEndereco());
        endereco.addChildElement("BAIRRO").addTextNode(this.boleto.getBairro());
        endereco.addChildElement("CIDADE").addTextNode(this.boleto.getCidade());
        endereco.addChildElement("UF").addTextNode(this.boleto.getUf());
        endereco.addChildElement("CEP").addTextNode(this.boleto.getCep());

        SOAPElement fichaCompensacao = titulo.addChildElement("FICHA_COMPENSACAO");
        SOAPElement mensagens = fichaCompensacao.addChildElement("MENSAGENS");
        for (Mensagem mensagem : this.boleto.getFichaCompensacao()) {
            mensagens.addChildElement("MENSAGEM").addTextNode(mensagem.getMensagem());
        }

        SOAPElement reciboPagador = titulo.addChildElement("RECIBO_PAGADOR");
        SOAPElement mensagensRecibo = reciboPagador.addChildElement("MENSAGENS");
        for (Mensagem mensagem : this.boleto.getReciboPagador()) {
            mensagensRecibo.addChildElement("MENSAGEM").addTextNode(mensagem.getMensagem());
        }

        SOAPElement pagamento = titulo.addChildElement("PAGAMENTO");
        pagamento.addChildElement("QUANTIDADE_PERMITIDA").addTextNode(String.valueOf(this.boleto.getQuantidade()));
        pagamento.addChildElement("TIPO").addTextNode(this.boleto.getTipoPagamento().name());
        pagamento.addChildElement("VALOR_MINIMO").addTextNode("0.00");
        pagamento.addChildElement("VALOR_MAXIMO").addTextNode("0.00");
    }

    private BoletoResponse callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            SOAPBody soapBody = soapResponse.getSOAPBody();
            Map<String, String> map = new HashMap<>();

            NodeList nodes = soapBody.getElementsByTagName(this.operacaoEnum.name());
            BoletoResponse br = new BoletoResponse();
            for (int i = 0; i < nodes.getLength(); i++) {
                NodeList node = nodes.item(i).getChildNodes();

                br.setCodigoBarras(node.item(0).getTextContent());
                br.setLinhaDigitavel(node.item(1).getTextContent());
                br.setUrl(node.item(2).getTextContent());
            }
            soapConnection.close();

            return br;
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
            return null;
        }
    }

    private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);
        soapMessage.saveChanges();

        System.out.println("Request SOAP Message:");

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        soapMessage.writeTo(bos);
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        FileUtils.writeByteArrayToFile(new File("c:\\temp\\boleto.xml"), bos.toByteArray());

        return soapMessage;
    }
}
