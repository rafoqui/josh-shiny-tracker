package model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="counter")
public class Counter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long encCount;
	private LocalDate startDate;
	private String target;
	private int gen;
	private String method;
	private String odds;
	private boolean shinyCharm;
	private String sprite;
	private boolean completed;
	private LocalDate endDate;
	
	public Counter(long id, long encCount, LocalDate startDate, String target, int gen, String method, String odds,
			boolean shinyCharm, String sprite, boolean completed, LocalDate endDate) {
		super();
		this.id = id;
		this.encCount = encCount;
		this.startDate = startDate;
		this.target = target;
		this.gen = gen;
		this.method = method;
		this.odds = odds;
		this.shinyCharm = shinyCharm;
		this.sprite = sprite;
		this.completed = completed;
		this.endDate = endDate;
	}
	
	public Counter() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getEncCount() {
		return encCount;
	}

	public void setEncCount(long encCount) {
		this.encCount = encCount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getGen() {
		return gen;
	}

	public void setGen(int gen) {
		this.gen = gen;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOdds() {
		return odds;
	}

	public void setOdds(String odds) {
		this.odds = odds;
	}

	public boolean isShinyCharm() {
		return shinyCharm;
	}

	public void setShinyCharm(boolean shinyCharm) {
		this.shinyCharm = shinyCharm;
	}

	public String getSprite() {
		return sprite;
	}

	public void setSprite(String sprite) {
		this.sprite = sprite;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	
}
