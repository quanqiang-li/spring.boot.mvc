package liquanqiang.spring.boot.conf.task.impl;

import org.springframework.stereotype.Component;

import liquanqiang.spring.boot.conf.task.RiskCalc;

/**
 * 明保理类型产品
 * @author liqq
 *
 */
@Component("mblRisk")
public class RiskCalcMBL implements RiskCalc{

	@Override
	public void calc() {
		System.out.println("明保理风控审核...");
		
	}

}
