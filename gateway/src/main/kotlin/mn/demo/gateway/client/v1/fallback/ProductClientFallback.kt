package mn.demo.gateway.client.v1.fallback

import io.micronaut.http.annotation.Get
import io.micronaut.retry.annotation.Fallback
import io.reactivex.Flowable
import io.reactivex.Single
import mn.demo.api.v1.*

@Fallback
class ProductClientFallback : ProductOperations<Product> {
    @Get("/flowableListOfTypeProductInterface")
    override fun flowableListOfTypeProductInterface(): Flowable<List<Product>> = Flowable.just(listOf(ProductFromInterface("pflfi-1-FB", "pflfi-1-FB name")))

    @Get("/singleOfTypeProductInterface/{id}")
    override fun singleOfTypeProductInterface(id: String): Single<Product> = Single.just(ProductFromInterface("sfpi-p1-FB", "sfpi-p1-FB name"))

    @Get("/singleOfProductDataClass/{id}")
    override fun singleOfProductDataClass(id: String): Single<ProductDataClass> = Single.just(ProductDataClass("sfpdc-p1-FB", "sfpdc-p1-FB name"))

    @Get("/singleOfProductOpen/{id}")
    override fun singleOfProductOpen(id: String): Single<ProductOpen> = Single.just(ProductOpen("sfpo-p1-FB", "sfpo-p1-FB name"))

    @Get("/singleOfProductWithDesc/{id}")
    override fun singleOfProductWithDesc(id: String): Single<ProductWithDesc> = Single.just(ProductWithDesc("sfpwd-p1-FB", "sfpwd-p1-FB name", "sfpwd-p1-FB desc"))

    @Get("/singleListOfProductThatWillBeSubtype")
    override fun singleListOfProductThatWillBeSubtype() : Single<List<ProductOpen>> = Single.just(listOf(ProductWithDesc("sfpwd-p1-FB", "sfpwd-p1-FB name", "sfpwd-p1-FB desc")))

}
