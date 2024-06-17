package service;

import model.Counter;

public interface OddsCalcs {
	String baseRates(int rolls, int odds, Counter counter);
	String altRates(int rolls, int odds, Counter counter);
	String radarChainRates(int odds, Counter counter);
	String chainFishingRates(Counter counter);
	String sosBattlesRates(Counter counter);
	String swshKosBonusRates(Counter counter);
	String bdspRadarChainRates(long chain);
}
