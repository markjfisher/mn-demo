package mn.demo

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import io.reactivex.Flowable
import io.reactivex.Single
import mn.demo.api.v1.*

@Validated
@Controller("/pc")
class ProductController : ProductOperations<Product> {

    override fun flowableListOfTypeProductInterface(): Flowable<List<Product>> = Flowable.just(listOf(ProductFromInterface("pflfi-1", "pflfi-1 name")))

    override fun singleOfTypeProductInterface(id: String): Single<Product> = Single.just(ProductFromInterface("sfpi-p1", "sfpi-p1 name"))

    override fun singleOfProductDataClass(id: String): Single<ProductDataClass> = Single.just(ProductDataClass("sfpdc-p1", "sfpdc-p1 name"))

    override fun singleOfProductOpen(id: String): Single<ProductOpen> = Single.just(ProductOpen("sfpo-p1", "sfpo-p1 name"))

    override fun singleOfProductWithDesc(id: String): Single<ProductWithDesc> = Single.just(ProductWithDesc("sfpwd-p1", "sfpwd-p1 name", "sfpwd-p1 desc"))

    override fun singleListOfProductThatWillBeSubtype() : Single<List<ProductOpen>> = Single.just(listOf(ProductWithDesc("sflpo-p1", "sflpo-p1 name", "sflpo-p1 desc")))

}
