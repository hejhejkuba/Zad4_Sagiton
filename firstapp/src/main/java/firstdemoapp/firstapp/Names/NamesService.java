package firstdemoapp.firstapp.Names;


import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.lang.reflect.Field;

@Service
public class NamesService {
    private Names names = new Names();

    public String postName(String value) {
        Field name = null;
        try {
            name = Names.class.getDeclaredField(value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        MyTarget nameAnnotation = name.getAnnotation(MyTarget.class);
        String nameValue = nameAnnotation.value();
        return nameValue;
    }

    public String dispatcherMethod(String fname, Model model) {

        switch (fname) {
            case "Hal":
                model.addAttribute("message", names.getHal());
                return postName("hal");
            case "David":
                model.addAttribute("message", names.getDavid());
                return postName("david");
            case "Johny":
                throw new TeapotException("I'm a teapot");
            default:
                model.addAttribute("message", fname);
                return "Default";
        }

    }
}
