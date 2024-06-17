package service;

import org.springframework.stereotype.Service;

import model.Counter;

@Service
public class CharmVerificationImpl implements CharmVerification {

	@Override
	public boolean verShinyCharm(Counter counter) {
		return counter.isShinyCharm() && verDispShinyCharm(counter);
	}

	@Override
	public boolean verDispShinyCharm(Counter counter) {
		return counter.getGen()>=5 && counter.getGen()<=8; 
	}
}
