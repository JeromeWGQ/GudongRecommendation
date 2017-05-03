package com.jerome.gudongfood.dao;

import com.jerome.gudongfood.gsonBeans.ReceiveVegetable;
import com.jerome.gudongfood.model.StepItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerome on 2017/5/3.
 */

public class StepsUtil {
    public static ReceiveVegetable currentRV;

    public static List<StepItem> getSteps() {
        List<StepItem> stepList = new ArrayList<>();
        for (ReceiveVegetable.OneDish.OneStep s : currentRV.result.get(0).steps) {
            stepList.add(new StepItem(s.img, s.step));
        }
        return stepList;
    }
}
