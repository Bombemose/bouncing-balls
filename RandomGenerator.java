
/**
 * Lav en beskrivelse af klassen RandomGenerator her.
 * 
 * @author (dit navn her)
 * @version (versions nummer eller dato her)
 */

import java.util.Random;
import java.util.HashMap;
import java.awt.Color;

public class RandomGenerator
{
    // instansvariabler - erstat eksemplet herunder med dine egne variabler
    private Random randomGenerator;
    private HashMap<Integer, Color> colorMap;

    /**
     * Konstruktør for objekter af klassen RandomGenerator
     */
    public RandomGenerator()
    {
        // initialiser instansvariable
        randomGenerator = new Random();
        colorMap = new HashMap<Integer, Color>();
        
        createColorMap();
    }

    /**
     * Et eksempel på en metode - erstat denne kommentar med din egen
     * 
     * @param  y  eksempel på en parameter til en metode
     * @return    summen af x og y 
     */
    public int getRandomNumber(int limit)
    {
        // indsæt din egen kode her
        return randomGenerator.nextInt(limit);
    }
    
    private void createColorMap() {
        colorMap.put(1,Color.BLUE);
        colorMap.put(2,Color.YELLOW);
        colorMap.put(3,Color.RED);
        colorMap.put(4,Color.GREEN);
        colorMap.put(5,Color.CYAN);
        colorMap.put(6,Color.ORANGE);
        colorMap.put(7,Color.PINK);
    }
    
    public Color getRandomColor() {
        int colorNumber = getRandomNumber(7)+1;
        
        Color color = colorMap.get(colorNumber);
        
        return color;
    }
}
