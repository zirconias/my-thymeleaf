package com.zirconias.thyspring.config;

/**
 * Created by xirc on 09/07/2015.
 */
public class AjaxUtils {

    private AjaxUtils() {
    }

    public static boolean isAjaxRequest(String requestedWith) {
        return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
    }

}
