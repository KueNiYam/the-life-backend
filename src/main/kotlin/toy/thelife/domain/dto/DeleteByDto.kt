package toy.thelife.domain.dto

data class DeleteByDto (
    val redGte: Int,

    val redLte: Int,

    val greenGte: Int,

    val greenLte: Int,

    val blueGte: Int,

    val blueLte: Int
)

