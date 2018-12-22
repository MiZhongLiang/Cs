package com.ysd.config;

import java.util.TimerTask;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.template.Engine;
import com.ysd.controller.StudentController;
import com.ysd.task.MyTask;

public class StartConfig extends JFinalConfig{

	/**
	 * 配置项目设置
	 */
	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);//会输出每次请求细节
		
	}

	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		me.add("/", StudentController.class);
		
	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configPlugin(Plugins me) {
		Cron4jPlugin cron4j = new Cron4jPlugin();
		cron4j.addTask("* * * * *", new MyTask());
		me.add(cron4j);
		
		
	}

	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		
	}

}
