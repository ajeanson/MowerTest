package fr.opensides.domain;


/**
 * Lawn bean
 * 
 * @author ajeanson
 */
public class Lawn {

	private int xMax;
	private int yMax;
	
	
	public Lawn(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
	}
	
	public int getxMax() {
		return xMax;
	}
	public void setxMax(int xMax) {
		this.xMax = xMax;
	}
	public int getyMax() {
		return yMax;
	}
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xMax;
		result = prime * result + yMax;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lawn other = (Lawn) obj;
		if (xMax != other.xMax)
			return false;
		if (yMax != other.yMax)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{ \n\"xMax\" : " + xMax + ", \n\"yMax\" : " + yMax + "\"\n}";
	}
	
	
}