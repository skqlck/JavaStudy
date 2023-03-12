public class Tank extends Terran {

    public Tank(){
        this.setAttack(7);
        this.setDefense(15);
        this.setFlyable(false);
        this.setAttackable(false);
    }
    public void AttackEnemy(Unit unit){
        if (unit.getFlyable()){
            System.out.println("Cannot Attack!!!");
        }
        else {
            unit.setDefense(unit.getDefense()-this.getAttack());
        }
    }
}
