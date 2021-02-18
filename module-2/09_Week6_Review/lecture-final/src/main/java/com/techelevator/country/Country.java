package com.techelevator.country;

public class Country {
	
	private String code;
	private String name;
	private String continent;
	private String region;
	private Double surfacearea;
	private Integer indepyear;
	private Long    population;
	private Double lifeexpectancy;
	private Double gnp;
	private Double gnpold;
	private String localname;
	private String governmentform;
	private String headofstate;
	private Integer capital;
	private String code2;
	
	public Country() {}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurfacearea() {
		return surfacearea;
	}
	public void setSurfacearea(Double surfacearea) {
		this.surfacearea = surfacearea;
	}
	public Integer getIndepyear() {
		return indepyear;
	}
	public void setIndepyear(Integer indepyear) {
		this.indepyear = indepyear;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public Double getLifeexpectancy() {
		return lifeexpectancy;
	}
	public void setLifeexpectancy(Double lifeexpectancy) {
		this.lifeexpectancy = lifeexpectancy;
	}
	public Double getGnp() {
		return gnp;
	}
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	public Double getGnpold() {
		return gnpold;
	}
	public void setGnpold(Double gnpold) {
		this.gnpold = gnpold;
	}
	public String getLocalname() {
		return localname;
	}
	public void setLocalname(String localname) {
		this.localname = localname;
	}
	public String getGovernmentform() {
		return governmentform;
	}
	public void setGovernmentform(String governmentform) {
		this.governmentform = governmentform;
	}
	public String getHeadofstate() {
		return headofstate;
	}
	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}
	public Integer getCapital() {
		return capital;
	}
	public void setCapital(Integer capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
				+ ", surfacearea=" + surfacearea + ", indepyear=" + indepyear + ", population=" + population
				+ ", lifeexpectancy=" + lifeexpectancy + ", gnp=" + gnp + ", gnpold=" + gnpold + ", localname="
				+ localname + ", governmentform=" + governmentform + ", headofstate=" + headofstate + ", capital="
				+ capital + ", code2=" + code2 + "]";
	}
}
