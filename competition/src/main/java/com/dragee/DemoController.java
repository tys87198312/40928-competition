package com.dragee;

import com.dragee.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tys on 2022/9/30
 */
@RequestMapping("demo")
@RestController
public class DemoController {
    @GetMapping("demo")
    public R demo () throws Exception {
        if (true) {
            throw new Exception("嘻嘻哈哈");
        }
        return R.ok().put("data", "哈哈哈");
    }
}
