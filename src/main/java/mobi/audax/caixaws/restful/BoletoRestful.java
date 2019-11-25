/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobi.audax.caixaws.restful;

import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import mobi.audax.caixaws.enumm.OperacaoEnum;
import mobi.audax.caixaws.restful.model.Boleto;
import mobi.audax.caixaws.restful.model.BoletoResponse;
import mobi.audax.caixaws.transmitir.TransmitirBoleto;

/**
 *
 * @author links
 */
@Path("/boleto")
public class BoletoRestful {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sample() {
        return Response.ok("{'retorno':true}", MediaType.MEDIA_TYPE_WILDCARD).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response gerar(Boleto boleto) {
        try {
            TransmitirBoleto tb = new TransmitirBoleto();
            BoletoResponse response = tb.enviar(boleto, OperacaoEnum.INCLUI_BOLETO);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(Boleto boleto) {
        try {
            TransmitirBoleto tb = new TransmitirBoleto();
            BoletoResponse response = tb.enviar(boleto, OperacaoEnum.ALTERA_BOLETO);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
