package main;



import javax.swing.JFrame;


import controller.SimulationController;
import model.SimulationState;
import view.SimulationDisplay;


class Main{
    
    public static void main(String[] args){

    //skapar data (bilar och deras positioner)
    SimulationState state = new SimulationState(20, 5); // 5 BILAR PÅ 20 "METER" LÅNG VÄG

    //skapar dipslay (ritar bilar) och skcikar state så att den vet var bilen ligger 
    SimulationDisplay display = new SimulationDisplay(state);

    //skapar controller objekt
    SimulationController controller = new SimulationController(state, display);



        //skapar fönstret(skärmen)
    JFrame frame = new JFrame("Traffic simulation");

    frame.add(display); // display läggs i fönstret(bilar och vägar blir synliga)

    frame.setSize(500, 200); // betsämemr storleken på fönstret 
    
    // programmet avslutas när fönstret stängs 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    frame.setVisible(true); // fönstret blir synligt för simularing 

    // Startar simuleringen
    controller.start();

}
}