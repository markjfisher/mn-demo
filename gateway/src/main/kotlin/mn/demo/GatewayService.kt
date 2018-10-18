package mn.demo

import io.micronaut.runtime.Micronaut
import io.micronaut.runtime.event.annotation.EventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import mu.KLogging

class GatewayService {

    companion object : KLogging() {
        @JvmStatic
        fun main(args: Array<String>) {
            Micronaut.build()
                .packages("mn/demo")
                .mainClass(GatewayService::class.java)
                .start()
        }
    }

    @EventListener
    fun onStartup(e: ServerStartupEvent) {
        logger.info { "starting gateway service: $e" }
    }

}
