package toy.thelife.domain

import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class MutationFactory {

    /**
     * 변이 여부
     * * 1%의 확률로 변이할 수 있습니다.
     */
    fun canItMutate(): Boolean {
        val random = Random.nextInt(100) // TODO 확률 조절 가능하게

        return random == 0
    }

    /**
     * 진화 or 퇴화 여부
     * * 50 프로의 확률로 진화하거나 퇴화합니다.
     */
    fun evolveOrDevolve(): Boolean {
        val random = Random.nextInt(2)

        return random == 0
    }
}