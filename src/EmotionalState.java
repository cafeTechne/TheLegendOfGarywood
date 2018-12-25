
public interface EmotionalState {
	
}

//TODO: bounds checking for the setIntensity() method? Perhaps we can do this externally, depending on context.

class EmotionalStateHappiness implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateHappiness() {
		currentEmotion = "Happy";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Happy";
	}
	
}


class EmotionalStateAnger implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateAnger() {
		currentEmotion = "Angry";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Angry";
	}
}


class EmotionalStateDisgusted implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateDisgusted() {
		currentEmotion = "Disgusted";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Disgusted";
	}
	
}


class EmotionalStateAfraid implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateAfraid() {
		currentEmotion = "Scared";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Scared";
	}
	
}


class EmotionalStateSadness implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateSadness() {
		currentEmotion = "Sad";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Sad";
	}
	
}


class EmotionalStateSurprise implements EmotionalState{

	String currentEmotion;
	double intensity;
	
	
	public double getIntensity() {
		return intensity;
	}

	public void setIntensity(double intensity) {
		this.intensity = intensity;
	}

	public EmotionalStateSurprise() {
		currentEmotion = "Surprised";
		this.intensity = 5;
	}
	
	public String toString() {
		return "Surprised";
	}
	
}
