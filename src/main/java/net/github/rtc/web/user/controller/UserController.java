package net.github.rtc.web.user.controller;


import net.github.rtc.web.user.model.User;
import net.github.rtc.web.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author  Lapshin Ugene
 */


@Controller ("adminNavigationController")
@RequestMapping ("admin/user")
public class UserController {

    private static final String ROOT = "admin/user";
    private UserService userService;


    @RequestMapping (value = "/qwe", method = RequestMethod.GET)
    public ModelAndView single(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView(ROOT + "/layout");
        User user = userService.findById(id);
        //mav.addObject("user", user);
        mav.addObject("content", "ViewAll");
        return mav;
       // return "ViewAll";
    }

    @RequestMapping(value = "/ViewAll", method = RequestMethod.GET)
    public ModelAndView View() {
        ModelAndView mav = new ModelAndView(ROOT + "/layout");
        mav.addObject("content", "ViewAll");
        return mav;
    }

}
