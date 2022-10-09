package com.dragee.modules.business;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dragee.common.P;
import com.dragee.modules.business.entity.CompetitionEntity;
import com.dragee.modules.business.service.CompetitionService;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author tys on 2022/10/9
 */
@Component
public class Task {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DefaultWebSecurityManager defaultWebSecurityManager;

    /**
     * 每天凌晨1点执行定时
     */
    @Scheduled(cron = "0/30 * * * * ?")
    public void task2() {
        ThreadContext.bind(defaultWebSecurityManager);
        System.out.println(1);
        List<CompetitionEntity> competitions = competitionService
                .list(new QueryWrapper<CompetitionEntity>()
                        .eq("status", 1));
        long nowTime = System.currentTimeMillis();
        for (CompetitionEntity competition : competitions) {
            if (competition.getStartTime().getTime() > nowTime) {
                continue;
            }
            P.green("【比赛开始】：" + competition.getTitle() + " -> " + competition.getId());
            String sql = "select userId from t_user_join where competitionId = " + competition.getId();
            List<Map<String, Object>> ls = jdbcTemplate.queryForList(sql);
            if (ls.size() == 0) {
                competition.setStatus(4);
                competition.setStatusMean("失效");
            } else {
                competition.setStatus(2);
                competition.setStatusMean("等待打分");
            }
            competitionService.saveOrUpdate(competition);
        }
    }
}
