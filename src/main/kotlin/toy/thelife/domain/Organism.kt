package toy.thelife.domain

data class Organism(
    val red: Int = 128,
    val green: Int = 128,
    val blue: Int = 128,
) {
    init {
        if (red < 0 || red > 255) {
            throw IllegalArgumentException()
        }

        if (green < 0 || green > 255) {
            throw IllegalArgumentException()
        }

        if (blue < 0 || blue > 255) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        fun computeMutationResult(value: Int, mutationDegree: Int = 1, isEvolve: Boolean): Int {
            val sum = if (isEvolve) value + mutationDegree else value - mutationDegree

            return when {
                sum < 0 -> 0
                sum > 255 -> 255
                else -> sum
            }
        }
    }
}
