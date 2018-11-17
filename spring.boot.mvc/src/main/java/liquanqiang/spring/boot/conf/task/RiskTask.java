package liquanqiang.spring.boot.conf.task;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import liquanqiang.spring.boot.conf.SpringContext;

@Component
@EnableScheduling
public class RiskTask {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 注入方式,把实现接口的类全部注入
	 */
	@Autowired
	private List<RiskCalc> riskCalcList;

	/**
	 * 工具类的方式,直接获取实现接口的类
	 */
	@Autowired
	private SpringContext springContext;

	@Scheduled(cron = "${RiskTask.cron}")
	public void run() {
		logger.info("风控计算定时任务开始...");
		Map<String, RiskCalc> beansOfType = springContext.getBeansOfType(RiskCalc.class);
		Set<Entry<String, RiskCalc>> entrySet = beansOfType.entrySet();
		Iterator<Entry<String, RiskCalc>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, RiskCalc> riskCalc = iterator.next();
			logger.info("风控计算信息{}-{}", riskCalc.getKey(), riskCalc.getValue());
			riskCalc.getValue().calc();
		}
		
		for (RiskCalc calc : riskCalcList) {
			logger.info("风控计算信息{}-{}", calc.getClass().getSimpleName(),calc);
			calc.calc();
		}
		logger.info("风控计算定时任务结束...");
	}
}
