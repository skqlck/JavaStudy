import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class PlayGame {
    /* 종족 번호 {0:Terran, 1:Zerg, 2:Protoss}
    random int 뽑아서 컴퓨터 만들고
    사용자 입력 받아서 사용자 종족 만들고
    ArrayList<입력 받은 종족 클래스> player = new ArrayList<>();
    for 문 돌면서 player에 종족 유닛 하나씩 추가
    게임 실행
  */
	public static HashMap<Integer, Unit> getUnit(int n) {
		Random generator = new Random();
		HashMap<Integer, Unit> map = new HashMap<>();
		if (n == 0) {
			for (int i = 0; i < 5; i++) {
				int UnitNumber = generator.nextInt(5);
				switch (UnitNumber) {
				case 0: map.put(i,new Marine()); break;
				case 1: map.put(i,new Tank()); break;
				case 2: map.put(i,new Goliath()); break;
				case 3: map.put(i,new Wraith()); break;
				case 4: map.put(i,new Valkyrie()); break;
				}
			}
		}
		else if (n == 1) {
			for (int i = 0; i < 8; i++) {
				int UnitNumber = generator.nextInt(4);
				switch (UnitNumber) {
				case 0: map.put(i,new Zergling()); break;
				case 1: map.put(i,new Hydralisk()); break;
				case 2: map.put(i,new Ultralisk()); break;
				case 3: map.put(i,new Mutalisk()); break;
				}
			}
		}
		else if (n == 2) {
			for (int i = 0; i < 4; i++) {
				int UnitNumber = generator.nextInt(5);
				switch (UnitNumber) {
				case 0: map.put(i,new Zealot()); break;
				case 1: map.put(i,new Dragoon()); break;
				case 2: map.put(i,new HighTempler()); break;
				case 3: map.put(i,new Scout()); break;
				case 4: map.put(i,new Corsair()); break;
				}
			}
		}
		return map;
	}
	public static void showStatus(HashMap<Integer, Unit> map) {
		List<Integer> keys = new ArrayList<Integer>(map.keySet());
        for (int i = 0; i < map.size(); i++) {
        	int key = keys.get(i);
        	System.out.printf("%d. %s (현재 방어력: %d)\n",key,map.get(key).getClass().getName(), map.get(key).getDefense());
        }
	}
	public static void AttackDefense(HashMap<Integer, Unit> map1, int num1, HashMap<Integer, Unit> map2, int num2) {
		map1.get(num1).AttackEnemy(map2.get(num2));
		if (map2.get(num2).getDefense() <= 0) {
			map2.remove(num2);
		}
	}
    public static void main(String args[]){
    	String[] species = {"Terran","Zerg","Protoss"};
        Random generator = new Random();
        Scanner scanner = new Scanner(System.in);
        int playerSpecies = scanner.nextInt();
        HashMap<Integer, Unit> Player = getUnit(playerSpecies);
        int computerSpecies = generator.nextInt(3);
        HashMap<Integer, Unit> Computer = getUnit(computerSpecies);
        int cnt = 0;
        while (Player.size() != 0 && Computer.size() != 0) {
            System.out.println("적군: "+species[computerSpecies]);
            showStatus(Computer);
            System.out.println("아군: "+species[playerSpecies]);
            showStatus(Player);
            System.out.println("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요:");
            if (cnt % 2 == 0) {
            	int Attacker = scanner.nextInt();
                int Defenser = scanner.nextInt();
	            AttackDefense(Player,Attacker,Computer,Defenser);
            }
            else {
            	List<Integer> keys = new ArrayList<Integer>(Computer.keySet());
            	int Attacker = keys.get(generator.nextInt(keys.size()));
            	keys = new ArrayList<Integer>(Player.keySet());
                int Defenser = keys.get(generator.nextInt(keys.size()));
            	AttackDefense(Computer,Attacker,Player,Defenser);
            }
            cnt += 1;
        }
        scanner.close();
        if (Player.size() == 0) {
        	System.out.println("패배했습니다!!");
            System.out.println("적군: "+species[computerSpecies]);
            showStatus(Computer);
        }
        else if (Computer.size() == 0) {
            System.out.println("아군: "+species[playerSpecies]);
            showStatus(Player);
        	System.out.println("승리했습니다!!");
        }
    }
}
