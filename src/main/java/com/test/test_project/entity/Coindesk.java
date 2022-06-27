package com.test.test_project.entity;

import java.util.Map;
import java.util.Objects;

public class Coindesk {
	private Map<String,String> time;
	private String disclaimer;
	private String chartName;
	private Map<String,Map<String,String>> bpi;
	
	public Map<String, String> getTime() {
		return time;
	}
	public void setTime(Map<String, String> time) {
		this.time = time;
	}
	public String getDisclaimer() {
		return disclaimer;
	}
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	public String getChartName() {
		return chartName;
	}
	public void setChartName(String chartName) {
		this.chartName = chartName;
	}
	public Map<String, Map<String, String>> getBpi() {
		return bpi;
	}
	public void setBpi(Map<String, Map<String, String>> bpi) {
		this.bpi = bpi;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bpi, chartName, disclaimer, time);
	}
	@Override
	public String toString() {
		return "Coindesk [time=" + time + ", disclaimer=" + disclaimer + ", chartName=" + chartName + ", bpi=" + bpi
				+ "]";
	}
	
	
}
