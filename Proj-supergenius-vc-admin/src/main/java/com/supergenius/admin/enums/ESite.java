package com.supergenius.admin.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 项目枚举类
 * @author YuYingJie
 */
@Getter
public enum ESite {

	supergenius(0),//超天才
	tpi(1),//并购平台
	finance(2),//天财评论
	moral(3),//职业道德培训
	user(4),//会员中心
	manager(5),//职业经理人培训
	sns(6),//人间仙境
	enterpriser(7),//企业家培训
	startup(8),//创业平台
	ai(9),//天才AI
	solr(10),//搜索
	career(11),//职场
	gupage(12),//顾雏军专栏
	gupagearticle(13),//顾雏军专栏文章
	life(14),//天才人生
	managernews(15),//职业经理人文章
	entrepreneur(16),//企业家培训
	moralnews(17),//职业道德培训文章
	venturecapital(18),//天才创投项目
	sudoku(100),//数独游戏
	sudokuRMB(101),//数独游戏
	demopay(99);//内部测试
	@EnumValue
	private final int value;

	private ESite(int value) {
		this.value = value;
	}

	public static ESite get(int v) {
		String str = String.valueOf(v);
		return get(str);
	}

	public static ESite get(String name) {
		for (ESite e : values()) {
			if (e.name().equals(name)) {
				return e;
			}
		}
		return null;
	}

}
