package liquanqiang.spring.boot.conf.task.impl;

import org.springframework.stereotype.Component;

import liquanqiang.spring.boot.conf.task.RiskCalc;

/**
 * 暗保理类型产品
 * @author liqq
 *
 */
@Component("ablRisk")
public class RiskCalcABL implements RiskCalc{

	@Override
	public void calc() {
		System.out.println("暗保理风控审核...");
		
	}

}
