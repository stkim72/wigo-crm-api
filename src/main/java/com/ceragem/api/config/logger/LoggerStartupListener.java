package com.ceragem.api.config.logger;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;

public class LoggerStartupListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {

	@Override
	public void start() {
		String logFileId = System.getProperty("log.file.id");
		Context context = getContext();
		context.putProperty("log.file.id", logFileId);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStarted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResetResistant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onStart(LoggerContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onReset(LoggerContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStop(LoggerContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLevelChange(Logger logger, Level level) {
		// TODO Auto-generated method stub

	}

}
