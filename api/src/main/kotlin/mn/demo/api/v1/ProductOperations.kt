package mn.demo.api.v1

import io.micronaut.http.annotation.Get
import io.reactivex.Flowable
import io.reactivex.Single

interface ProductOperations<T: Product> {
    @Get("/flowableListOfTypeProductInterface")
    fun flowableListOfTypeProductInterface(): Flowable<List<T>>

    @Get("/singleOfTypeProductInterface/{id}")
    fun singleOfTypeProductInterface(id: String): Single<T>

    @Get("/singleOfProductDataClass/{id}")
    fun singleOfProductDataClass(id: String): Single<ProductDataClass>

    @Get("/singleOfProductOpen/{id}")
    fun singleOfProductOpen(id: String): Single<ProductOpen>

    @Get("/singleOfProductWithDesc/{id}")
    fun singleOfProductWithDesc(id: String): Single<ProductWithDesc>

    @Get("/singleListOfProductThatWillBeSubtype")
    fun singleListOfProductThatWillBeSubtype() : Single<List<ProductOpen>>
}
