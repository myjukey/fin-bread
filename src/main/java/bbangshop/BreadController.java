package bbangshop;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BreadController {

    private final BreadService postsService;
    @GetMapping("/breads/check")
    public String breadCheck(@RequestParam String breadId){
        return postsService.checkQuantityByBreadId(breadId);
    }

}
