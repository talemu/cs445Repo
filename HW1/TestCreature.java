
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestCreature{
	public static final int THING_COUNT = 8;
	public static final int CREATURE_COUNT = 5;
	
	public TestCreature() { 
		
	}
	@Test
	public void test_Thing_toString() {
		Thing test = new Thing("Eman");
		assertEquals("Eman", test.toString());
	}
	
	@Test
	public void test_Thing_constructor_built_with_name() {
		Thing test = new Thing("Eman");
		assertEquals("Eman", test.returnThingName());
	}
	
	@Test 
	public void test_Ant_toString() {
		Ant a = new Ant("anty");
		assertEquals("anty Ant", a.toString());
	}
	
	@Test
	public void test_Ant_movement() {
		Ant a = new Ant("anty");
		assertEquals("anty Ant is crawling around.", a.return_move_instruction());
	}
	
	@Test
	public void test_Ant_eating_nothing() {
		Ant a = new Ant ("anty");
		assertEquals("anty Ant has had nothing to eat!", a.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Ant_stomach_content() {
		Ant a = new Ant ("anty");
		a.eat(a);
		assertEquals("anty Ant has eaten a Ant", a.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Fly_toString() {
		Fly f = new Fly("buzz");
		assertEquals("buzz Fly", f.toString());
	}
	
	@Test
	public void test_Fly_eating_Thing() {
		Fly f = new Fly("buzz");
		Thing t = new Thing("Tabor");
		assertEquals("buzz Fly has just eaten a Tabor", f.return_eat_instruction(t));
	}
	
	@Test
	public void test_Fly_eating_Creature() {
		Fly f = new Fly("buzz");
		Ant t = new Ant("anty");
		assertEquals("buzz Fly won't eat a anty Ant", f.return_eat_instruction(t));
	}
	
	@Test
	public void test_Fly_stomach_content() {
		Fly f = new Fly("buzz");
		Ant t = new Ant("anty");
		f.eat(t);
		assertEquals("buzz Fly has had nothing to eat!", f.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Fly_stomach_content_after_eating_a_thing() {
		Fly f = new Fly("buzz");
		Thing t = new Thing("Tabor");
		f.eat(t);
		System.out.println(f.return_whatDidYouEat_instruction());
		assertEquals("buzz Fly has eaten a Thing", f.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Fly_flying() {
		Fly f = new Fly("buzz");
		assertEquals("buzz Fly is buzzing around in flight.", f.return_fly_instruction());
	}
	
	@Test
	public void test_Fly_moving() {
		Fly f = new Fly("buzz");
		assertEquals("buzz Fly is buzzing around in flight.", f.return_move_instruction());
	}
	
	@Test
	public void test_Fly_eating_nothing() {
		Fly f = new Fly("buzz");
		assertEquals("buzz Fly has had nothing to eat!", f.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Tiger_toString() {
		Tiger t = new Tiger("roar");
		assertEquals("roar Tiger", t.toString());
	}
	
	@Test
	public void test_Tiger_movement() {
		Tiger t = new Tiger("roar");
		assertEquals("roar Tiger has just pounced.", t.return_move_instruction());
	}
	
	@Test
	public void test_Tiger_eating() {
		Tiger t = new Tiger("roar");
		assertEquals("roar Tiger has just eaten a roar Tiger", t.return_eat_instruction(t));
	}
	
	@Test
	public void test_Tiger_eating_nothing() {
		Tiger t = new Tiger("tigga");
		assertEquals("tigga Tiger has had nothing to eat!", t.return_whatDidYouEat_instruction());
	}
	
	@Test
	public void test_Bat_toString() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat", b.toString());
	}
	
	@Test
	public void test_Bat_eating() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat has just eaten a dracula Bat", b.return_eat_instruction(b));
	}
	
	@Test
	public void test_Bat_eating_thing() {
		Bat b = new Bat("dracula");
		Thing t = new Thing("Tabor");
		assertEquals("dracula Bat won't eat Tabor", b.return_eat_instruction(t));
	}
	
	@Test
	public void test_Bat_flying() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat is swooping through the dark.", b.return_fly_instruction());
	}
	
	@Test
	public void test_Bat_moving() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat is swooping through the dark.", b.return_move_instruction());
	}
	
	@Test
	public void test_Bat_eating_nothing() {
		Bat b = new Bat("dracula");
		assertEquals("dracula Bat has had nothing to eat!", b.return_whatDidYouEat_instruction());
	}
	
	
	
	public static void main(java.lang.String[] args) {
		/* Creating Creature Array of size CREATURE_COUNT
		 */
		Creature[] creatureArray = new Creature[CREATURE_COUNT];
		
		/* Adding items to creatureArray*/
		creatureArray[0] = new Tiger("tigga");
		creatureArray[1] = new Bat ("Vamp");
		creatureArray[2] = new Fly ("bugg");
		creatureArray[3] = new Ant ("ant");
		creatureArray[4] = new Tiger("tiger king");
		
		/* Creating Thing Array of size THING_COUNT
		 */
		Thing[] thingArray = new Thing [THING_COUNT];
		
		/* Adding items to thingArray*/
		thingArray[0] = new Thing ("Tabor");
		thingArray[1] = new Thing ("Monti");
		thingArray[2] = new Thing ("Adi");
		
		System.out.println(thingArray[0]);
		
		/*For loop to add creatures to thingArray, ensuring polymorphism*/
		for (int i = 0; i < creatureArray.length; i++) {
			thingArray [3+i] = creatureArray[i];
		}
		
		System.out.println("Things:");
		
		/* Printing thingArray elements*/
		for (int i = 0; i < thingArray.length; i++) {
			System.out.println(thingArray[i]);	
		}
		System.out.println("\n");
		
		/* Printing thingArray elements that are not Things*/
		for (int i = 0; i < thingArray.length; i++) {
			if (thingArray[i].getClass().getName() == "Thing") {
		}
			else {
				System.out.println(thingArray[i]);
			}
		}
}
}