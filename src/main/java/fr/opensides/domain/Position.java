package fr.opensides.domain;

import fr.opensides.domain.repository.EOrientation;

/**
 * Position bean used for mover
 * 
 * @author opensides
 *
 */
public class Position {

	private int x;
	private int y;
	private EOrientation orientation;

	public Position() {
	}

	public Position(int x, int y, EOrientation orientation) {
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public EOrientation getOrientation() {
		return orientation;
	}

	public void setOrientation(EOrientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		Position other = (Position) obj;
		if (orientation != other.orientation)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{ \n\"x\" : " + x + ", \n\"y\" : " + y + ", \n\"orientation\" : " + orientation + "\"\n}";
	}

}
