package service;

import org.springframework.stereotype.Service;

import model.Counter;

@Service
public class CharmVerificationImpl implements CharmVerification {

	/**
	 * It verifies if the counter's shinyCharm attribute is set to true
	 * and if it's generation passes the verification.
	 */
	@Override
	public boolean verShinyCharm(Counter counter) {
		return counter.isShinyCharm() && verDispShinyCharm(counter);
	}

	/**
	 * It verifies the counter's generation. 
	 */
	@Override
	public boolean verDispShinyCharm(Counter counter) {
		return counter.getGen()>=5 && counter.getGen()<=8; 
	}
}
