package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Counter;

@Service
public class OddsCalcsImpl implements OddsCalcs {
	
	@Autowired
	CharmVerification charm;

	@Override
	public String baseRates(int rolls, int odds, Counter counter) {
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (odds/newRolls);
		} else {
			return rolls + "/" + odds;
		}
	}

	@Override
	public String altRates(int rolls, int odds, Counter counter) {
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (odds/newRolls);
		} else {
			return 1 + "/" + (odds/rolls);
		}
	}

	@Override
	public String radarChainRates(int odds, Counter counter) {
		int[] array = {8, 9, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 
                14, 14, 15, 15, 16, 17, 18, 19, 20, 21, 22, 24, 26, 28, 
                30, 33, 37, 41, 47, 55, 66, 82, 110, 164, 328};
		int relOdds = 8;
		int rolls = 1;
		for(int i=0;i<array.length;i++) {
			if (counter.getEncCount() == i) {
				relOdds=array[i];
				break;
			} else {
				relOdds=328;
			}
		}
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (odds/relOdds)/newRolls;
		} else {
			return 1 + "/" + (odds/relOdds);
		}
	}

	@Override
	public String chainFishingRates(Counter counter) {
		int relOdds = 1;
		int rolls = 1;
		if(counter.getEncCount()<=20) {
			relOdds=1+(2*(int)counter.getEncCount());
		} else {
			relOdds=41;
		}
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (4096/relOdds)/newRolls;
		} else {
			return 1 + "/" + (4096/relOdds);
		}
	}

	@Override
	public String sosBattlesRates(Counter counter) {
		int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 
                5, 5, 5, 5, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 
                13};
		int rolls = 1;
		for(int i=0;i<array.length;i++) {
			if(counter.getEncCount()==i) {
				rolls=array[i];
				break;
			} else {
				rolls=13;
			}
		}
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (4096/newRolls);
		} else {
			return 1 + "/" + (4096/rolls);
		}
	}

	@Override
	public String swshKosBonusRates(Counter counter) {
		int rolls = 1;
		long chain = counter.getEncCount();
		if(chain<1) {
			rolls = 1;
		} else if(chain<100 && 49<chain) {
			rolls = 2;
		} else if(chain<200 && 99<chain) {
			rolls = 3;
		} else if(chain<300 && 199<chain) {
			rolls = 4;
		} else if(chain<500 && 299<chain) {
			rolls = 5;
		} else if(499<chain) {
			rolls = 6;
		}
		if(charm.verShinyCharm(counter)) {
			int newRolls = aplicarShinyCharm(rolls);
			return 1 + "/" + (4096/newRolls);
		} else {
			return 1 + "/" + (4096/rolls);
		}
	}

	@Override
	public String bdspRadarChainRates(long chain) {
		int[] array = {4096, 3855, 3640, 3449 ,3277, 3121, 2979, 2849, 2731, 2621, 2521, 2427, 2341, 2259, 2185,
		2114, 2048, 1986, 1927, 1872, 1820, 1771, 1724, 1680, 1638, 1598, 1560, 1524,
		1489, 1456, 1310, 1285, 1260, 1236, 1213, 1192, 993, 799, 400, 200, 99};
		int odds = 4096;
		for(int i=0;i<chain;i++) {
			if(chain==i) {
				odds=array[i];
				break;
			} else {
				odds=99;
			}
		}
		return 1 + "/" + odds;
	}
	
	public int aplicarShinyCharm(int rolls) {
		return rolls + 2;
	}
	
	
	
}
