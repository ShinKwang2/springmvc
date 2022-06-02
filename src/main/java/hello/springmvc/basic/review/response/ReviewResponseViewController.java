package hello.springmvc.basic.review.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/review")
public class ReviewResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    /**
     * Void를 반환하는 경우
     * - @Controller를 사용하고,
     * - HttpServletResponse, OutputStream(Writer) 같은 Http 메시지 바디를 처리하는 파라미터가 없으면,
     * - 요청 URL을 참고해서 논리 뷰 이름으로 사용
     * 요청 URL : /reponse/hello
     * 실행 : templates/response/hello.html
     *
     *  단점 : 명시성이 떨어지고 URL을 파일명에 종속시키는 결과(원하는 URL 사용 불가)
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!!");
    }
}
