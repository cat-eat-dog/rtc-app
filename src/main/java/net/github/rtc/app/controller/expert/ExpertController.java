package net.github.rtc.app.controller.expert;

import net.github.rtc.app.service.CourseService;
import net.github.rtc.app.utils.datatable.CourseSearchResult;
import net.github.rtc.app.utils.datatable.SearchFilter;
import net.github.rtc.app.model.user.Request;
import net.github.rtc.app.model.user.UserCourseOrder;
import net.github.rtc.app.model.user.UserRequestStatus;
import net.github.rtc.app.service.UserCourseOrderService;
import net.github.rtc.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller("expertController")
@RequestMapping("/expert")
public class ExpertController {

    private static final String ROOT = "expert";

    @Autowired
    private CourseService courseService;
    @Autowired
    private UserCourseOrderService userCourseOrderService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public ModelAndView expertCourses() {
        ModelAndView mav = new ModelAndView("expert" + "/page/Coursesexpert");
        List<UserCourseOrder> orderList = userCourseOrderService.getOrderByStatus(UserRequestStatus.PENDING);
        List<Request> requestsList = new ArrayList<Request>();
        if(!orderList.isEmpty()){
            for(UserCourseOrder order : orderList){
                try{
                    Request request = new Request((int)order.getId(),
                    userService.findByCode(order.getUserCode()).getName(),
                    order.getReason(),
                    courseService.findByCode(order.getCourseCode()).getName(),
                    order.getPosition().toString());
                    requestsList.add(request);
                }catch (Throwable t){System.out.print("error");}
            }
        }
        mav.addObject("requests", requestsList);
        return mav;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView userCourses() {
        ModelAndView mav = new ModelAndView(ROOT + "/page/expertAllcourse");
        CourseSearchResult result = courseService.findByFilter(getFilter());
        mav.addObject("courses", result.getCourses());
        return mav;
    }

    @RequestMapping(value = "/accept/{orderId}", method = RequestMethod.GET)
    public String acceptRequest(@PathVariable Integer orderId){
       changeOrderStatus(UserRequestStatus.ACCEPTED, orderId);
       return "redirect:/expert/requests";
    }

    @RequestMapping(value = "/decline/{orderId}", method = RequestMethod.GET)
    public String declineRequest(@PathVariable Integer orderId){
        changeOrderStatus(UserRequestStatus.REJECTED, orderId);
        return "redirect:/expert/requests";
    }

    private void changeOrderStatus(UserRequestStatus userRequestStatus, Integer orderId){
        UserCourseOrder order = userCourseOrderService.getUserOrder(orderId.longValue());
        order.setResponseDate(new Date());
        order.setStatus(userRequestStatus);
        userCourseOrderService.update(order);
    }

    @ModelAttribute("searchFilter")
    public SearchFilter getFilter() {
        return new SearchFilter();
    }

}
