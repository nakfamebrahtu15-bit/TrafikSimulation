package view;



import javax.swing.JPanel;

import model.SimulationState;

import java.awt.Graphics;
import java.util.List;

public class SimulationDisplay extends JPanel{

    SimulationState state;


public SimulationDisplay(SimulationState state ){
    this.state = state;
}

// Planen ritas av den här 
//@Override
protected void paintComponent(Graphics g){
    super.paintComponent(g);// anpropas via Basklassen

    int roadLength = state.getRoadLength(); // tar reda på väg längd med hjälp av objekten "state"
    List<Integer> cars = state.getCarPositions(); // Hämtar bilarnas positioner från SimulationSatte


    int cellSize = 20; // en ruta med 20 pixlar
    int y = 50; // höjd på vägen

    // rita väggen 
    for (int i = 0; i < roadLength; i++){
        int x = i * cellSize; // räknar ut var cellen ska ritas  
        g.drawRect(x, y, cellSize, cellSize); // rita en tom cell
    }

    //ritar bilar
    for(int i = 0; i < cars.size(); i ++){
        int position = cars.get(i); //Hämta positionen för varje bil från listan
        
        // räknar var bilen ska ritas på skärmen 
        int x = position * cellSize;

        // rita bilen som en fylld ruta på skärmen 
        g.fillRect(x, y, cellSize, cellSize);

    }

}
    
}
