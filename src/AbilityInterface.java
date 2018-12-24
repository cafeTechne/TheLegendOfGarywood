import java.io.Serializable;

public interface AbilityInterface{

	public void applyAbility(Entity target);
	
	public String getAbilityName();
}

class AnalysisBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Analysis Damage";
	String damageType = "Analysis Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}


class FireBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Fire Damage";
	String damageType = "Fire Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
}

class WindBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Wind Damage";
	String damageType = "Wind Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class WaterBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Water Damage";
	String damageType = "Water Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class SmokeBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Smoke Damage";
	String damageType = "Smoke Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class ElectricityBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Electricity Damage";
	String damageType = "Electricity Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class IceBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Ice Damage";
	String damageType = "Ice Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class HolyBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Holy Damage";
	String damageType = "Holy Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class ExplosionBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Explosion Damage";
	String damageType = "Explosion Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class EarthBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Earth Damage";
	String damageType = "Earth Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}


class UnholyBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Unholy Damage";
	String damageType = "Unholy Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
}

class NatureBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Nature Damage";
	String damageType = "Nature Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
}

class TimeBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Time Damage";
	String damageType = "Time Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}

class PhysicalBasedSkill implements AbilityInterface, Serializable{
	
	String abilityName = "Physical Damage";
	String damageType = "Physical Damage";
	
	public void applyAbility(Entity target) {
	
	};
	
	public String getAbilityName() {
		return abilityName;
	};
	
	public String getDamageType() {
		return damageType;
	};
	
}


class Calculate extends AnalysisBasedSkill implements AbilityInterface, Serializable{

	String abilityName = "Calculate";
	
	public void applyAbility(Entity target) {
		
		//apply ability towards the target
		System.out.println("You size up the entity before you. Taking everything you can perceive into account.");
		System.out.println("Target's hit points: " + target.hp);
		System.out.println("Target's magic points: " + target.mp);
		//System.out.println("Target's abilities: " + target.mp);
	};
	
	public String getAbilityName() {
		return this.abilityName;
	}
	
	public String toString() {
		return this.abilityName;
	}
}
