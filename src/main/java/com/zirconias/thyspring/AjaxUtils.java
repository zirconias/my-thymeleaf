package com.zirconias.thyspring;

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
