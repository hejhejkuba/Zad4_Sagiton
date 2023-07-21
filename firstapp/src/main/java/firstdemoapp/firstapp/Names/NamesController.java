package firstdemoapp.firstapp.Names;

import firstdemoapp.firstapp.Names.Names;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Parameter;

@Controller
public class NamesController {
    private Names names;
    private NamesService namesService;

    @Autowired
    public NamesController(NamesService namesService) {
        this.namesService = new NamesService();
        this.names = new Names();
    }


    @GetMapping(value = "/")
    public String main(Model model) {
        return "welcome"; //view
    }

    @PostMapping(value = "/postaction")
    public String submit_handle(@RequestParam String fname, Model model) {
        return namesService.dispatcherMethod(fname, model);
    }


}