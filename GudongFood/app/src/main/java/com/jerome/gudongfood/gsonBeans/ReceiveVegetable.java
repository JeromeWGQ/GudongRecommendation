package com.jerome.gudongfood.gsonBeans;

import java.util.List;

/**
 * Created by Jerome on 2017/5/2.
 */

public class ReceiveVegetable {
    public String error_code;
    public List<OneDish> result;
    public class OneDish{
        public String title;
        public String tags;
        public String intro;
        public String ingredients;
        public String burden;
        public String albums;
        public List<OneStep> steps;
        public class OneStep{
            public String img;
            public String step;
        }
    }
}
