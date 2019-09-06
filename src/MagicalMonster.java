import java.io.Serializable;

public class MagicalMonster extends Monster implements MonsterInterface, AttackInterface, Serializable {

	//magical monsters have defenses against certain kinds of magic, like PC's
	
	private int fireDefense; 
	private int windDefense;
	private int waterDefense;
	private int smokeDefense; 
	private int electricityDefense;
	private int iceDefense;
	private int holyDefense;
	private int explosionDefense;
	private int earthDefense; 
	private int unholyDefense;
	private int natureDefense;
	private int timeDefense;
	private int physicalDefense;
	
	public MagicalMonster(int hp, int magicPoints, double movementSpeed, double attackSpeed, double attackRange,
			int sizeCategory, int level, int slashDefense, int pierceDefense, int bashDefense, 
			int fireDefense, int windDefense, int waterDefense, int smokeDefense, 
			int electricityDefense, int iceDefense, int holyDefense, int explosionDefense,
			int earthDefense, int unholyDefense, int natureDefense, int timeDefense,
			int physicalDefense, String region, String name, String description) {
		super(hp, magicPoints, movementSpeed, attackSpeed, attackRange, sizeCategory, level, slashDefense, pierceDefense,
				bashDefense, region, name, description);
		
		this.fireDefense = fireDefense;
		this.windDefense = windDefense;
		this.waterDefense = waterDefense; 
		this.smokeDefense = smokeDefense; 
		this.electricityDefense = electricityDefense;
		this.iceDefense = iceDefense;
		this.holyDefense = holyDefense;
		this.explosionDefense = explosionDefense; 
		this.earthDefense = earthDefense; 
		this.unholyDefense = unholyDefense; 
		this.natureDefense = natureDefense; 
		this.timeDefense = timeDefense; 
		this.physicalDefense = physicalDefense;
		super.setDescription(description);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void findTarget() {
		// TODO Auto-generated method stub

	}

	@Override
	public void engageTarget() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rangeChecker() {
		// TODO Auto-generated method stub

	}

	@Override
	public void attackTarget() {
		// TODO Auto-generated method stub

	}

	@Override
	public void useSpecialAbility() {
		// TODO Auto-generated method stub

	}

	@Override
	public void retreat() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAttack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMonsterDeath() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onActionTrigger() {
		// TODO Auto-generated method stub

	}

	public int getFireDefense() {
		return fireDefense;
	}

	public void setFireDefense(int fireDefense) {
		this.fireDefense = fireDefense;
	}

	public int getWindDefense() {
		return windDefense;
	}

	public void setWindDefense(int windDefense) {
		this.windDefense = windDefense;
	}

	public int getWaterDefense() {
		return waterDefense;
	}

	public void setWaterDefense(int waterDefense) {
		this.waterDefense = waterDefense;
	}

	public int getSmokeDefense() {
		return smokeDefense;
	}

	public void setSmokeDefense(int smokeDefense) {
		this.smokeDefense = smokeDefense;
	}

	public int getElectricityDefense() {
		return electricityDefense;
	}

	public void setElectricityDefense(int electricityDefense) {
		this.electricityDefense = electricityDefense;
	}

	public int getIceDefense() {
		return iceDefense;
	}

	public void setIceDefense(int iceDefense) {
		this.iceDefense = iceDefense;
	}

	public int getHolyDefense() {
		return holyDefense;
	}

	public void setHolyDefense(int holyDefense) {
		this.holyDefense = holyDefense;
	}

	public int getExplosionDefense() {
		return explosionDefense;
	}

	public void setExplosionDefense(int explosionDefense) {
		this.explosionDefense = explosionDefense;
	}

	public int getEarthDefense() {
		return earthDefense;
	}

	public void setEarthDefense(int earthDefense) {
		this.earthDefense = earthDefense;
	}

	public int getUnholyDefense() {
		return unholyDefense;
	}

	public void setUnholyDefense(int unholyDefense) {
		this.unholyDefense = unholyDefense;
	}

	public int getNatureDefense() {
		return natureDefense;
	}

	public void setNatureDefense(int natureDefense) {
		this.natureDefense = natureDefense;
	}

	public int getTimeDefense() {
		return timeDefense;
	}

	public void setTimeDefense(int timeDefense) {
		this.timeDefense = timeDefense;
	}

	public int getPhysicalDefense() {
		return physicalDefense;
	}

	public void setPhysicalDefense(int physicalDefense) {
		this.physicalDefense = physicalDefense;
	}

}
