package beans.controllers;

import beans.models.User;
import beans.services.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UserService userServiceImpl;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseStatus(value = HttpStatus.OK)
    public void uploadUsers(@RequestParam("jsonFile") MultipartFile jsonFile) throws IOException {
        List<User> users = objectMapper.readValue(jsonFile.getBytes(), new TypeReference<List<User>>(){});

        users.forEach(u -> userServiceImpl.register(u));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getUsers(@RequestParam String name, @ModelAttribute("model") ModelMap model) {
        List<User> users = userServiceImpl.getUsersByName(name);

        if(CollectionUtils.isEmpty(users)) {
            users = Collections.emptyList();
        }
        model.addAttribute("users", users);
        return "list-users";
    }

    @RequestMapping(value = "/getByEmail", method = RequestMethod.GET)
    public String showUsersPage(@RequestParam String email, @ModelAttribute("model") ModelMap model) {
        User user = userServiceImpl.getUserByEmail(email);
        model.addAttribute("user", user);
        return "user";
    }
}
