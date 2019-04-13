package com.summary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @description:springmvc流程
 *
 * 总结发现：重定向过程中，想要将参数传递到下一个handler的model使用，使用addFlashAttribute方法实现
 *
 * addAttitude方法保存的参数会出现在URL中，不会被下一个handler的model获取到
 *
 *具体源码可以看RequestMappingHandlerAdapter.getModelAndView方法中
 * mavContainer.getModel();获取model的时候，如果是重定向，则获取redirectModel，redirectModel存储的是addAttribute方法的值
 * 如果不是重定向，则获取的是defaultModel，这个就是平时常用的model
 * 接着会判断redirectModel是不是重定向的model，当然是了，是则取出getFlashAttributes，存储于OutputFlashMap
 * RequestContextUtils.getOutputFlashMap(request).putAll(flashAttributes);
 *
 * @author:niepu
 * @version:1.0
 * @date:2019/4/13 14:48
 **/
@Controller
@SessionAttributes("articleId")
public class FollowMe {

    private final String[] sensitiveWords = {"k1", "s2"};

    @ModelAttribute("comment")
    public String replaceSensitiveWords(String comment) {
        if (comment != null) {
            System.out.println("原始comment：" + comment);
            for (String sw : sensitiveWords) {
                comment = comment.replaceAll(sw, "");
            }
        }
        return comment;
    }

    @RequestMapping(value = {"/articles/{articleId}/comment"})
    public String doComment(@PathVariable String articleId, RedirectAttributes attributes, Model model) {
        // addFlashAttribute传递的参数不会出现在跳转地址中
        // attributes.addFlashAttribute("comment", model.asMap().get("comment"));
        attributes.addFlashAttribute("articleId", articleId);
        // addAttribute传递的参数会出现在跳转地址中：http://localhost:8888/showArticle?test=hello%2Cwolrd
        attributes.addAttribute("addAttribute", "addAttribute");
        attributes.addFlashAttribute("addFlashAttribute", "addFlashAttribute");
        model.addAttribute("articleId", articleId);
        // 此处略去正常的入库操作
        return "redirect:/showArticle";
    }

    @RequestMapping(value = {"/showArticle"})
    public String showArticle(Model model, SessionStatus sessionStatus) {
        String articleId = (String) model.asMap().get("articleId");
        model.addAttribute("articleTitle", articleId + "号文章标题");
        model.addAttribute("article", articleId + "号文章内容");
        // 页面中获取不到addAttribute，这个值出现到了URL中
        model.addAttribute("addAttribute", model.asMap().get("addAttribute"));

        // 页面中可以获取到addFlashAttribute，这个值不会出现在URL中
        model.addAttribute("addFlashAttribute", model.asMap().get("addFlashAttribute"));
        sessionStatus.setComplete();
        return "article";
    }
}
