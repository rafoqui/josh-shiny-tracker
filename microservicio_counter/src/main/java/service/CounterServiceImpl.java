package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.CounterDao;
import model.Counter;

@Service
public class CounterServiceImpl implements CounterService {
	
	@Autowired
	CounterDao dao;
	@Autowired
	OddsCalcs odds;
	@Autowired
	CharmVerification sc;
	
	@Override
	public boolean agregarCounter(Counter counter) {
		if(dao.recuperarCounter(counter.getId())==null) {
			oddsCalculator(counter);
			modificarSprites(counter);
			dao.crearCounter(counter);
			return true;
		}
		return false;
	}

	@Override
	public List<Counter> recuperarCounters() {
		return dao.devolverCounters();
	}

	@Override
	public void actualizarCounter(Counter counter) {
		if(dao.recuperarCounter(counter.getId())!=null) {
			oddsCalculator(counter);
			dao.actualizarCounter(counter);
		}
	}

	@Override
	public boolean eliminarCounter(long idCounter) {
		if(dao.recuperarCounter(idCounter)!=null) {
			dao.eliminarCounter(idCounter);
			return true;
		}
		return false;
	}

	@Override
	public Counter buscarCounter(long idCounter) {
		return dao.recuperarCounter(idCounter);
	}

	@Override
	public void oddsCalculator(Counter counter) {
		String rE = "Random encounters/Soft resets";
		String sB = "Shiny breeding";
		String m = "Masuda";
		String rC = "Radar chain";
		String fS = "Friend Safari";
		String cF = "Chain fishing";
		String h = "Hordes";
		String dN = "DexNav";
		String soB = "S.O.S. battles";
		String kos = "KOs Bonus";
		String dA = "Dynamax adventures";
		String method = counter.getMethod();
		if(method!=null) {
		switch (counter.getGen()) {
		case 2:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 8192, counter));
			} else if(method.equals(sB)) {
				counter.setOdds(odds.baseRates(1, 64, counter));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 3:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 8192, counter));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 4:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 8192, counter));
			} else if(method.equals(m)) {
				counter.setOdds(odds.altRates(5, 8192, counter));
			} else if(method.equals(rC)) {
				counter.setOdds(odds.radarChainRates(65536, counter));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 5:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 8192, counter));
			} else if(method.equals(m)) {
				counter.setOdds(odds.altRates(6, 8192, counter));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 6:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 4096, counter));
			} else if(method.equals(m)) {
				counter.setOdds(odds.altRates(6, 4096, counter));
			} else if(method.equals(rC)) {
				counter.setOdds(odds.radarChainRates(32768, counter));
			} else if(method.equals(fS)) {
				counter.setOdds(odds.altRates(5, 4096, counter));
			} else if(method.equals(cF)) {
				counter.setOdds(odds.chainFishingRates(counter));
			} else if(method.equals(h)) {
				counter.setOdds(odds.altRates(5, 4096, counter));
			} else if(method.equals(dN)) {
				counter.setOdds(odds.baseRates(1, 4096, counter));;
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 7:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 4096, counter));
			} else if(method.equals(m)) {
				counter.setOdds(odds.altRates(6, 4096, counter));
			} else if(method.equals(soB)) {
				counter.setOdds(odds.sosBattlesRates(counter));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		case 8:
			if(method.equals(rE)) {
				counter.setOdds(odds.baseRates(1, 4096, counter));
			} else if(method.equals(m)) {
				counter.setOdds(odds.altRates(6, 4096, counter));
			} else if(method.equals(kos)) {
				counter.setOdds(odds.swshKosBonusRates(counter));
			} else if(method.equals(dA)) {
				counter.setOdds(odds.baseRates(1, 300, counter));
			} else if(method.equals(rC)) {
				counter.setOdds(odds.bdspRadarChainRates(counter.getEncCount()));
			} else {
				counter.setOdds("Wrong generation!");
			}
			break;
		default:
			counter.setOdds("No method");
		}
		} else {
			counter.setOdds("No method");
		}
	}

	@Override
	public void modificarShinyCharm(Counter counter, boolean charm) {
		if(sc.verDispShinyCharm(counter)) {
			counter.setShinyCharm(charm);
		}
	}
	
	public void modificarSprites(Counter counter) {
		String baseUrlforSprites = "https://img.pokemondb.net/sprites";
	    String baseUrlforModels = "https://projectpokemon.org/images/shiny-sprite";
	    String baseUrlforSwsh = "https://projectpokemon.org/images/sprites-models/swsh-shiny-sprites";
	    String sprite = nameOddities(counter.getTarget(),counter.getGen()).toLowerCase().concat(".png");
	    String spriteAni = nameOddities(counter.getTarget(),counter.getGen()).toLowerCase().concat(".gif");
	    switch(counter.getGen()) {
	    case 2:
	    	counter.setSprite(baseUrlforSprites.concat("/crystal/shiny/".concat(sprite)));
	    	break;
	    case 3:
	    	counter.setSprite(baseUrlforSprites.concat("/emerald/shiny/".concat(sprite)));
	    	break;
	    case 4:
	    	counter.setSprite(baseUrlforSprites.concat("/heartgold-soulsilver/shiny/".concat(sprite)));
	    	break;
	    case 5:
	    	counter.setSprite(baseUrlforSprites.concat("/black-white/anim/shiny/".concat(spriteAni)));
	    	break;
	    case 6:
	    	counter.setSprite(baseUrlforModels.concat("/".concat(spriteAni)));
	    	break;
	    case 7:
	    	counter.setSprite(baseUrlforModels.concat("/".concat(spriteAni)));
	    	break;
	    case 8:
	    	counter.setSprite(baseUrlforSwsh.concat("/".concat(spriteAni)));
	    	break;
	    default:
	    	counter.setSprite(null);
	    }
	}
	
	public String nameOddities(String name, int gen) {
	    StringBuilder sb = new StringBuilder(name);
	    String modifiedName = name;

	    if (gen >= 6) {
	        if (name.equals("Nidoran-M") || name.equals("Nidoran-F")) {
	            sb.setCharAt(7, '_');
	            modifiedName = sb.toString();
	        } else if (name.equals("Mr Mime")) {
	            modifiedName = "Mr._Mime";
	        } else if (name.equals("Mime Jr")) {
	            modifiedName = "Mime_Jr";
	        } else if (name.equals("Basculin-Red-Striped")) {
	            modifiedName = sb.delete(8, sb.length()).toString();
	        } else if (name.equals("Basculin-Blue-Striped")) {
	            modifiedName = sb.delete(13, sb.length()).toString();
	        } else if (name.equals("Minior")) {
	            modifiedName = name.concat("-Red");
	        } else if (name.equals("Type: Null")) {
	            modifiedName = "TypeNull";
	        } else if (name.equals("Tapu Koko") || name.equals("Tapu Lele") || name.equals("Tapu Bulu") || name.equals("Tapu Fini")) {
	            modifiedName = sb.deleteCharAt(4).toString();
	        } else if (name.equals("Mr Rime")) {
	            modifiedName = "Mr.Rime";
	        }else if (name.equals("Mr Mime-Galar")) {
	            modifiedName = "Mr.-Mime-Galar";
	        }
	    } else if (gen <= 5) {
	        if (name.equals("Giratina")) {
	            modifiedName = name.concat("-Altered");
	        } else if (name.equals("Shaymin")) {
	            modifiedName = name.concat("-Land");
	        } else if (name.equals("Arceus")) {
	            modifiedName = name.concat("-Normal");
	        } else if (name.equals("Tornadus") || name.equals("Thundurus") || name.equals("Landorus")) {
	            modifiedName = name.concat("-Incarnate");
	        } else if (name.equals("Keldeo")) {
	            modifiedName = name.concat("-Ordinary");
	        } else if (name.equals("Meloetta")) {
	            modifiedName = name.concat("-Aria");
	        } else if (name.equals("Deerling") || name.equals("Sawsbuck")) {
	            modifiedName = name.concat("-Summer");
	        } else if (name.equals("Darmanitan")) {
	            modifiedName = name.concat("-Standard-Mode");
	        } else if (name.equals("Mr Mime")) {
	            modifiedName = "Mr-Mime";
	        } else if (name.equals("Mime Jr")) {
	            modifiedName = "Mime-Jr";
	        }
	    }

	    return modifiedName;
	}

}
