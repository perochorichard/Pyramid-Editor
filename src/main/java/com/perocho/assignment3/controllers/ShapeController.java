package com.perocho.assignment3.controllers;

import com.perocho.assignment3.model.PyramidData;
import com.perocho.assignment3.model.PyramidForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class ShapeController {

    /*for the sake of error testing, I have allowed the range to be 0 - 100 for the number of sides.
     * typically, however, the range should logically start at 3, to minimize errors on the user end.*/
    private static final int[] bases = java.util.stream.IntStream.rangeClosed(0, 100).toArray();

    @RequestMapping({"/", "/main"})
    public ModelAndView enterParameters() {
        ModelAndView modelAndView = new ModelAndView("Main", "pyramid", PyramidData.getRecentPyramid());
        modelAndView.addObject("bases", bases);
        return modelAndView;
    }

    @RequestMapping("/validate")
    public String validateData(@Valid @ModelAttribute("pyramid") PyramidForm pyramidForm, BindingResult bindingResult, Model model) {
        // non-numerical errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", "Non-numerical value entered. Try again.");
            return "Error";
        }

        PyramidData.setRecentPyramid(pyramidForm);
        ArrayList<String> errors = PyramidData.validate(pyramidForm);
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "Error"; // html template
        }
        model.addAttribute(pyramidForm);
        return "Result"; // html template
    }

    @RequestMapping("/calculate")
    public String calculatePyramid(@Valid @ModelAttribute("pyramid") PyramidForm pyramidForm, Model model) {
        model.addAttribute(pyramidForm);
        return "Result";
    }
}
