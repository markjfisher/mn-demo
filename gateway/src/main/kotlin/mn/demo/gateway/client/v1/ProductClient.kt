package mn.demo.gateway.client.v1

import io.micronaut.http.client.annotation.Client
import io.reactivex.Flowable
import io.reactivex.Single
import mn.demo.api.v1.*

@Client(id = "productcatalogue", path = "/pc")
interface ProductClient : ProductOperations<Product> {
    override fun flowableListOfTypeProductInterface(): Flowable<List<Product>>
    override fun singleOfTypeProductInterface(id: String): Single<Product>
    override fun singleOfProductDataClass(id: String): Single<ProductDataClass>
    override fun singleOfProductOpen(id: String): Single<ProductOpen>
    override fun singleOfProductWithDesc(id: String): Single<ProductWithDesc>
    override fun singleListOfProductThatWillBeSubtype() : Single<List<ProductOpen>>
}
