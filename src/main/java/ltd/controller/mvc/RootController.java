package ltd.controller.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ltd.model.dev.ComponentDevURLModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

//@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/")
public class RootController {


    @Autowired
    private Environment environment;

    @GetMapping("/")
    @SneakyThrows
    public String welcome(Model model) {
        String message = environment.getProperty("welcome_message");
        HashMap<String, Object> attributes = new HashMap<>();
        attributes.put("welcomeMessage", message);

        ObjectMapper mapper = new ObjectMapper();
        InputStream stream = RootController.class.getResourceAsStream("/../urls.json");
        try (InputStream is = new BufferedInputStream(stream)) {
            List<ComponentDevURLModel> value = mapper.readValue(is, List.class);
            attributes.put("urlModels", value);
        }
        model.addAllAttributes(attributes);
        return "welcome";
    }

}
