package com.perocho.assignment3.model;

import java.util.ArrayList;

/*data persistence between views*/
public class PyramidData {
    private static PyramidForm form = new PyramidForm();

    public static PyramidForm getRecentPyramid() {
        return form;
    }

    public static void setRecentPyramid(PyramidForm _form) {
        form = _form;
    }

    public static ArrayList<String> validate(PyramidForm _form) {
        ArrayList<String> errors = new ArrayList<>();
        if (_form.getBaseN() <= 2) {
            errors.add("Cannot Have less than 2 sides");
        }
        if (_form.getBaseSide() <= 0) {
            errors.add("Side length must be greater than 0");
        }
        if (_form.getHeight() <= 0) {
            errors.add("Height must be greater than 0");
        }
        return errors;
    }
}
