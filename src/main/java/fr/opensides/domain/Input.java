package fr.opensides.domain;

import java.util.List;

import fr.opensides.domain.repository.EControl;

public class Input {
	int lawnUpperRightCornerX;
	int lawnUpperRightCornerY;
	Position initialPosition;
	List<EControl> controls;
	
	
	public Input(){
		super();
	}

	public Input(int lawnUpperRightCornerX, int lawnUpperRightCornerY, Position initialPosition, List<EControl> controls) {
		super();
		this.lawnUpperRightCornerX = lawnUpperRightCornerX;
		this.lawnUpperRightCornerY = lawnUpperRightCornerY;
		this.initialPosition = initialPosition;
		this.controls = controls;
	}


	public int getLawnUpperRightCornerX() {
		return lawnUpperRightCornerX;
	}


	public void setLawnUpperRightCornerX(int lawnUpperRightCornerX) {
		this.lawnUpperRightCornerX = lawnUpperRightCornerX;
	}


	public int getLawnUpperRightCornerY() {
		return lawnUpperRightCornerY;
	}


	public void setLawnUpperRightCornerY(int lawnUpperRightCornerY) {
		this.lawnUpperRightCornerY = lawnUpperRightCornerY;
	}


	public Position getInitialPosition() {
		return initialPosition;
	}


	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}


	public List<EControl> getControls() {
		return controls;
	}


	public void setControls(List<EControl> controls) {
		this.controls = controls;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((controls == null) ? 0 : controls.hashCode());
		result = prime * result + ((initialPosition == null) ? 0 : initialPosition.hashCode());
		result = prime * result + lawnUpperRightCornerX;
		result = prime * result + lawnUpperRightCornerY;
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
		Input other = (Input) obj;
		if (controls == null) {
			if (other.controls != null)
				return false;
		} else if (!controls.equals(other.controls))
			return false;
		if (initialPosition == null) {
			if (other.initialPosition != null)
				return false;
		} else if (!initialPosition.equals(other.initialPosition))
			return false;
		if (lawnUpperRightCornerX != other.lawnUpperRightCornerX)
			return false;
		if (lawnUpperRightCornerY != other.lawnUpperRightCornerY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "{ \n\"lawnUpperRightCornerX\" : " + lawnUpperRightCornerX + ", \n\"lawnUpperRightCornerY\" : " + lawnUpperRightCornerY + ", \n\"initialPosition\" : " + initialPosition + ", \n\"controls\" : " + controls + "\"\n}";
	}
	

}
