package toy.thelife.domain

import org.springframework.stereotype.Service
import toy.thelife.domain.dto.DeleteByDto

@Service
class OrganismService(
    val organismRepository: OrganismRepository,
    val mutationFactory: MutationFactory
) {
    fun list(): List<Organism> {
        return organismRepository.list()
    }

    // TODO limit 추가해야 함
    fun next(): List<Organism> {
        // 번식
        val reproduced = organismRepository.list()
            .map {
                if (mutationFactory.canItMutate()) Organism(
                    Organism.computeMutationResult(it.red, isEvolve = mutationFactory.evolveOrDevolve()),
                    Organism.computeMutationResult(it.green, isEvolve = mutationFactory.evolveOrDevolve()),
                    Organism.computeMutationResult(it.blue, isEvolve = mutationFactory.evolveOrDevolve()),
                ) else it
            }

        organismRepository.addAll(reproduced)

        return organismRepository.list()
    }

    fun deleteBy(deleteByDto: DeleteByDto): List<Organism> {
        val deleted = organismRepository.list()
            .asSequence()
            .filter { it.red <= deleteByDto.redLte }
            .filter { it.red >= deleteByDto.redGte }
            .filter { it.red <= deleteByDto.greenLte }
            .filter { it.red >= deleteByDto.greenGte }
            .filter { it.red <= deleteByDto.blueLte }
            .filter { it.red >= deleteByDto.blueGte }
            .toList()

        organismRepository.removeAll(deleted)

        return organismRepository.list()
    }
}