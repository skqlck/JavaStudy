public class Unit {
    private int Attack;
    private int Defense;
    private boolean Flyable;
    private boolean Attackable;
    
    public void setAttack(int n){
        this.Attack = n;
    }
    public int getAttack(){
        return this.Attack;
    }
    public void setDefense(int n){
        this.Defense = n;
    }
    public int getDefense(){
        return this.Defense;
    }
    public void setFlyable(boolean b){
        this.Flyable = b;
    }
    public boolean getFlyable(){
        return this.Flyable;
    }
    public void setAttackable(boolean b) {
    	this.Attackable = b;
    }
    public boolean getAttackable() {
    	return this.Attackable;
    }
    public void AttackEnemy(Unit unit){
    	if (this.getFlyable() || this.getAttackable()) {
    		unit.setDefense(unit.getDefense()-this.getAttack());
    	}
    	else {
    		if (!unit.getFlyable()) {
    			unit.setDefense(unit.getDefense()-this.getAttack());
    		}
    		else {
    			System.out.println("Cannot Attack!!!");
    		}
    	}
    }
}
