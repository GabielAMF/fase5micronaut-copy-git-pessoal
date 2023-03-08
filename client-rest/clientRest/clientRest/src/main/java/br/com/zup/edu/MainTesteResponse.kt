package br.com.zup.edu

import br.com.zup.edu.frete.CalculaFreteRequest
import br.com.zup.edu.frete.FreteServiceGrpc
import jakarta.inject.Inject


@Inject
lateinit var gRpcClient : FreteServiceGrpc.FreteServiceBlockingStub

fun main(){
    val request = CalculaFreteRequest.newBuilder().setCep("1231").build()
    val response  = gRpcClient.calculaFrete(request)
    println(response)

}