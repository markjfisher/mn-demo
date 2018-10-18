package mn.demo

import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.event.annotation.EventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import mu.KLogging

class ProductCatalogueService {

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            Micronaut.build()
                .packages("mn/demo")
                .mainClass(ProductCatalogueService::class.java)
                .start()
        }
    }

    @EventListener
    fun onStartup(e: ServerStartupEvent) {
        logger.info { "starting product catalogue service: $e" }
    }
}