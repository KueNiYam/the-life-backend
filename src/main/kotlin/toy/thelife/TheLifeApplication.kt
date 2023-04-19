package toy.thelife

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TheLifeApplication

fun main(args: Array<String>) {
    runApplication<TheLifeApplication>(*args)
}
