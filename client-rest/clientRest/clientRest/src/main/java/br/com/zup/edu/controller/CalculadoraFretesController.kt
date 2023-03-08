package br.com.zup.edu.controller

import br.com.zup.edu.frete.CalculaFreteRequest
import br.com.zup.edu.frete.FreteResponse
import br.com.zup.edu.frete.FreteServiceGrpc
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import jakarta.inject.Inject
import org.slf4j.LoggerFactory



@Controller
class CalculadoraFretesController(@Inject val gRpcClient : FreteServiceGrpc.FreteServiceBlockingStub) {


    @Get("/api/fretes")
    fun calcula(@QueryValue cep : String) : FreteResponse {
        println("Entrou no get")
        val request = CalculaFreteRequest.newBuilder().setCep(cep).build()

        val response = gRpcClient.calculaFrete(request)
        return FreteResponse(cep = response.cep,valor = response.valor)
    }
    data class FreteResponse(val cep: String,val valor:Double){}

}