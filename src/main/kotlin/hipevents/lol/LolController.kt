package hipevents.lol

import hipevents.common.Constants
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.API_ROOT)
class LolController {

    @GetMapping("/lol")
    fun getSomeLol(): Lol {
        return Lol("this is a message")
    }

}