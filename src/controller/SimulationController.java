 package controller;



import javax.swing.Timer;

import model.SimulationState;
import view.SimulationDisplay;


public class SimulationController {

    //Referens till datta(SimulationState)
    private SimulationState state;
    private SimulationDisplay display; // referens till SimulationDisplay
    private Timer timer; // timer som körs efter varje steg vid bilarnas förflyttning 

    // konstruktör - > kopplar ihop data + displayen + timer
public SimulationController(SimulationState state, SimulationDisplay display){

    //spara simulerings data
    this.state = state;

    // spara displayen så att den ska kunna uppdatera skärmen
    this.display = display;


    //skapar en time som kör var 200 millisekunder(5 gånger per sekund)
    this.timer = new Timer(200, e -> {

        //kontrollera om simulering är i gång
        if(state.isRunning()){

            //flytta bilarna ett steg framåt
            state.step();

        // rita om skrämen
        display.repaint();
    }
    });
}

// starta simulering
public void start(){

    // sätt igång simuleringen 
    state.start();

    //Timer tickar automatisk och bilarna för flyttar sig
    timer.start();
}
//stoppa simuleringen 
public void stop(){

    state.stop();
}
//starta om från början 
public void restart(){

    state.reset();

 //rita om skärmen 
 display.repaint();

}

}
