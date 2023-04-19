package toy.thelife.ui

import org.springframework.web.bind.annotation.*
import toy.thelife.domain.Organism
import toy.thelife.domain.OrganismService
import toy.thelife.domain.dto.DeleteByDto

@RestController
@RequestMapping("/api")
class OrganismController(
    val organismService: OrganismService
) {
    @GetMapping("/organisms")
    fun list(): List<Organism> {
        return organismService.list()
    }

    @PostMapping("/organisms/next")
    fun next(): List<Organism> {
        return organismService.next()
    }

    @DeleteMapping("/organisms")
    fun deleteBy(
        deleteByDto: DeleteByDto
    ): List<Organism> {
        return organismService.deleteBy(deleteByDto)
    }

    // TODO 초기화 API
}