package toy.thelife.domain

import org.springframework.stereotype.Component

@Component
object OrganismRepository {
    private val organisms = mutableListOf(Organism()) // default 1

    fun addAll(list: List<Organism>) {
        organisms.addAll(list)
    }

    fun list(): List<Organism> {
        return organisms.toList()
    }

    fun removeAll(list: List<Organism>) {
        organisms.removeAll(list)
    }
}
