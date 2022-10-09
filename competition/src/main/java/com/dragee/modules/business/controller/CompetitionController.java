package com.dragee.modules.business.controller;

import com.dragee.common.PageUtils;
import com.dragee.common.R;
import com.dragee.config.exception.BusinessException;
import com.dragee.config.resolver.User;
import com.dragee.modules.business.dto.CompetitionDetailDTO;
import com.dragee.modules.business.entity.CompetitionEntity;
import com.dragee.modules.business.service.CompetitionService;
import com.dragee.modules.sys.entity.LoginUser;
import com.dragee.modules.vo.MakeScoreVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 用户表
 *
 * @author tys
 * @email tys@mail.com
 * @date 2020-11-11 17:46:45
 */
@RestController
@RequestMapping("competition")
@Api(tags = "用户管理")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 列表
     */
    @GetMapping("xsList")
    @ApiOperation("列表")
    public R xsList(@User LoginUser user,  @RequestParam Map<String, Object> params){
        PageUtils page = competitionService.queryPageXS(params, user);
        /*主办方', '观众', '选手', '评委', '系统管理员'*/
        if (user.getRoleName().equals("观众") || user.getRoleName().equals("选手")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_xs(user.getUserId(), l.getId()));
            });
        }
        if (user.getRoleName().equals("评委")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_pw(user.getUserId(), l.getId()));
            });
        }
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @GetMapping("pwList")
    @ApiOperation("列表")
    public R pwList(@User LoginUser user,  @RequestParam Map<String, Object> params){
        PageUtils page = competitionService.queryPagePW(params, user);
        /*主办方', '观众', '选手', '评委', '系统管理员'*/
        if (user.getRoleName().equals("观众") || user.getRoleName().equals("选手")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_xs(user.getUserId(), l.getId()));
            });
        }
        if (user.getRoleName().equals("评委")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_pw(user.getUserId(), l.getId()));
            });
        }
        return R.ok().put("data", page);
    }


    /**
     * 列表
     */
    @GetMapping("list")
    @ApiOperation("列表")
    public R list(@User LoginUser user,  @RequestParam Map<String, Object> params){
        PageUtils page = competitionService.queryPage(params);
        /*主办方', '观众', '选手', '评委', '系统管理员'*/
        if (user.getRoleName().equals("观众") || user.getRoleName().equals("选手")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_xs(user.getUserId(), l.getId()));
            });
        }
        if (user.getRoleName().equals("评委")) {
            List<CompetitionEntity> ls = (List<CompetitionEntity>) page.getList();
            ls.forEach(l -> {
                l.setIsJoin(isJoin_pw(user.getUserId(), l.getId()));
            });
        }
        return R.ok().put("data", page);
    }

    @GetMapping("detail")
    public R detail (String competitionId) {
        CompetitionEntity competition = competitionService.getById(Long.parseLong(competitionId));
        String sqlXS = "select userId, userName, score from t_user_join where competitionId = " + Long.parseLong(competitionId);
        List<Map<String, Object>> lsXS = jdbcTemplate.queryForList(sqlXS);
        String sqlPW = "select userId, userName from t_judge_join where competitionId = " + Long.parseLong(competitionId);
        List<Map<String, Object>> lsPW = jdbcTemplate.queryForList(sqlPW);
        CompetitionDetailDTO dto = new CompetitionDetailDTO(competition, lsXS, lsPW);
        return R.ok().put("data", dto);
    }

    @GetMapping("join")
    public R join (@User LoginUser user, String competitionId) {
        checkStatus(competitionService.getById(Long.parseLong(competitionId)));
        if (user.getRoleName().equals("评委")) {
            join_pw(user, Long.parseLong(competitionId));
        } else {
            join_xs(user, Long.parseLong(competitionId));
        }
        return R.ok();
    }
    @GetMapping("noJoin")
    public R noJoin (@User LoginUser user, String competitionId) {
        checkStatus(competitionService.getById(Long.parseLong(competitionId)));
        if (user.getRoleName().equals("评委")) {
            noJoin_pw(user, Long.parseLong(competitionId));
        } else {
            noJoin_xs(user, Long.parseLong(competitionId));
        }
        return R.ok();
    }

    private void noJoin_pw (LoginUser user, Long competitionId) {
        String sql = "delete from t_judge_join where competitionId = "+competitionId+" and userId = "+user.getUserId();
        this.jdbcTemplate.execute(sql);
    }

    private void noJoin_xs (LoginUser user, Long competitionId) {
        String sql = "delete from t_user_join where competitionId = "+competitionId+" and userId = "+user.getUserId();
        this.jdbcTemplate.execute(sql);
    }



    private void join_pw (LoginUser user, Long competitionId) {
        String sql = "insert into t_judge_join (competitionId, userId, userName) values ("+competitionId+", "+user.getUserId()+", '"+user.getName()+"')";
        this.jdbcTemplate.execute(sql);
    }

    private void join_xs (LoginUser user, Long competitionId) {
        String sql = "insert into t_user_join (competitionId, userId, userName) values ("+competitionId+", "+user.getUserId()+", '"+user.getName()+"')";
        this.jdbcTemplate.execute(sql);
    }

    private String isJoin_pw (Long userId, Long competitionId) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_judge_join where competitionId = " + competitionId + " and userId = " + userId);
        return list.size() == 0 ? "未报名" : "已报名";
    }

    private String isJoin_xs (Long userId, Long competitionId) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from t_user_join where competitionId = " + competitionId + " and userId = " + userId);
        return list.size() == 0 ? "未报名" : "已报名";
    }

    /**
     * 保存
     */
    @PostMapping("makeScore")
    @ApiOperation("保存或修改比赛")
    public R makeScore(@RequestBody MakeScoreVO vo, @User LoginUser user){
        CompetitionEntity competition = competitionService.getById(Long.parseLong(vo.getCompetitionId()));
        List<Map<String, Object>> xs = vo.getXs();
        for (Map<String, Object> x : xs) {
            int score = x.get("score") == null ? 0 :  Integer.parseInt(x.get("score").toString());
            String sql = "update t_user_join set score = "+score+" where userId = "+Long.parseLong(x.get("userId").toString())+" and competitionId = " + competition.getId();
            jdbcTemplate.execute(sql);
        }
        competition.setScoreStandard(vo.getScoreStandard());
        competition.setStatus(3);
        competition.setStatusMean("完成");
            competition.setJudgePerson(user.getName());
        competitionService.saveOrUpdate(competition);
        return R.ok();
    }

    /**
     * 保存
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation("保存或修改比赛")
    public R saveOrUpdate(@RequestBody CompetitionEntity competition){
        if (competition.getId() == null) {
            competition.setStatus(1);
            competition.setStatusMean("未开始");
            competitionService.saveOrUpdate(competition);
        } else {
            CompetitionEntity competitionOld = competitionService.getById(competition.getId());
            checkStatus(competitionOld);
            competitionOld.setTitle(competition.getTitle());
            competitionOld.setStartTime(competition.getStartTime());
            competitionService.saveOrUpdate(competitionOld);
        }

        return R.ok();
    }



    @GetMapping("delete-by-id")
    @ApiOperation("删除")
    public R deleteById(String id){
        CompetitionEntity competition = competitionService.getById(id);
        checkStatus(competition);
        competitionService.removeById(Long.parseLong(id));
        jdbcTemplate.execute("delete from t_judge_join where competitionId = " + competition.getId());
        jdbcTemplate.execute("delete from t_user_join where competitionId = " + competition.getId());
        return R.ok();
    }


    private void checkStatus (CompetitionEntity competition) {
        if (competition.getStatus() != 1) {
            throw new BusinessException(501, "只可以操作未开始的比赛");
        }
    }

    @GetMapping("sort")
    public R sort(){
        String sql = "select userName, score from (\n" +
                "   select userId, userName, sum(score) as score from t_user_join group by userId, userName\n" +
                ") t order by score desc";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return R.ok().put("data", maps);
    }


}
