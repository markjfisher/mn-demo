package mn.demo.gateway

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import io.reactivex.Flowable
import io.reactivex.Single
import mn.demo.api.v1.Product
import mn.demo.api.v1.ProductDataClass
import mn.demo.api.v1.ProductOpen
import mn.demo.api.v1.ProductWithDesc
import mn.demo.gateway.client.v1.ProductClient

@Validated
@Controller("/")
class GatewayController(private val productClient: ProductClient) {

    @Get("/flowableListOfTypeProductInterface")
    fun flowableListOfTypeProductInterface() : Flowable<List<Product>> = productClient.flowableListOfTypeProductInterface()

    @Get("/singleOfTypeProductInterface/{id}")
    fun singleOfTypeProductInterface(id: String) : Single<Product> = productClient.singleOfTypeProductInterface(id)

    @Get("/singleOfProductDataClass/{id}")
    fun singleOfProductDataClass(id: String) : Single<ProductDataClass> = productClient.singleOfProductDataClass(id)

    @Get("/singleOfProductOpen/{id}")
    fun singleOfProductOpen(id: String): Single<ProductOpen> = productClient.singleOfProductOpen(id)

    @Get("/singleOfProductWithDesc/{id}")
    fun singleOfProductWithDesc(id: String): Single<ProductWithDesc> = productClient.singleOfProductWithDesc(id)

    @Get("/singleListOfProductThatWillBeSubtype")
    fun singleListOfProductThatWillBeSubtype() : Single<List<ProductOpen>> = productClient.singleListOfProductThatWillBeSubtype()

}
