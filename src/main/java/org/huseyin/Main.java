package org.huseyin;

import org.huseyin.services.ViewService;

public class Main {

    public static void main(String[] args) {
        System.out.println(new ViewService().getViewByRewardId(5));
    }

}
