package panzer.manager;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;
import panzer.models.vehicles.Revenger;
import panzer.models.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.*;

public class ProgramManager implements Manager {
     private HashMap<String,Vehicle> vehicles;
     private List<String> defeatedVehicles;
     private List<String> remainingVehicles;
     private HashMap<String,Part> parts;
     private BattleOperator battleOperator;

     public ProgramManager(){
         this.vehicles=new LinkedHashMap<>();
         this.battleOperator=new PanzerBattleOperator();
         this.parts=new LinkedHashMap<>();
         this.defeatedVehicles=new LinkedList<>();
         this.remainingVehicles=new LinkedList<>();
     }

    @Override
    public String addVehicle(List<String> arguments) {
        switch(arguments.get(1)){
            case "Revenger":
                Vehicle revenger=new Revenger(
                        arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        Integer.parseInt(arguments.get(7)));
                this.vehicles.put(arguments.get(2),revenger);
                this.remainingVehicles.add(arguments.get(2));
                break;
            case "Vanguard":
                Vehicle vanguard=new Vanguard(
                        arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        new BigDecimal(arguments.get(4)),
                        Integer.parseInt(arguments.get(5)),
                        Integer.parseInt(arguments.get(6)),
                        Integer.parseInt(arguments.get(7)));
                this.vehicles.put(arguments.get(2),vanguard);
                this.remainingVehicles.add(arguments.get(2));
                break;
        }
        return "Created "+arguments.get(1)+" Vehicle - "+arguments.get(2);
    }

    @Override
    public String addPart(List<String> arguments) {
         switch (arguments.get(2)){
             case "Arsenal":
                 Part arsenal=new ArsenalPart(arguments.get(3),
                         Double.parseDouble(arguments.get(4)),
                         new BigDecimal(arguments.get(5)),
                         Integer.parseInt(arguments.get(6)));
                 this.vehicles.get(arguments.get(1)).addArsenalPart(arsenal);
                 this.parts.put(arguments.get(3),arsenal);
                 break;
             case "Shell":
                 Part shell=new ShellPart(arguments.get(3),
                         Double.parseDouble(arguments.get(4)),
                         new BigDecimal(arguments.get(5)),
                         Integer.parseInt(arguments.get(6)));
                 this.vehicles.get(arguments.get(1)).addShellPart(shell);
                 this.parts.put(arguments.get(3),shell);
                 break;
             case "Endurance":
                 Part endurance=new EndurancePart(arguments.get(3),
                         Double.parseDouble(arguments.get(4)),
                         new BigDecimal(arguments.get(5)),
                         Integer.parseInt(arguments.get(6)));
                 this.vehicles.get(arguments.get(1)).addEndurancePart(endurance);
                 this.parts.put(arguments.get(3),endurance);
                 break;
         }
        return "Added "+arguments.get(2)+" - "+arguments.get(3)+" to Vehicle - "+arguments.get(1);
    }

    @Override
    public String inspect(List<String> arguments) {
        if(this.vehicles.containsKey(arguments.get(1))){
            return  this.vehicles.get(arguments.get(1)).toString();
        }else{
            return this.parts.get(arguments.get(1)).toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        String winner=this.battleOperator.battle(this.vehicles.get(arguments.get(1)),this.vehicles.get(arguments.get(2)));
        if(winner.equals(arguments.get(1))){
            this.vehicles.remove(this.vehicles.get(arguments.get(2)).getModel());
            defeatedVehicles.add(arguments.get(2));
            this.remainingVehicles.remove(arguments.get(2));
        }else{
            this.vehicles.remove(this.vehicles.get(arguments.get(1)).getModel());
            defeatedVehicles.add(arguments.get(1));
            this.remainingVehicles.remove(arguments.get(1));
        }
        return arguments.get(1)
                +" versus "+arguments.get(2)+
                " -> "+winner+" Wins! Flawless Victory!";
    }

    @Override
    public String terminate(List<String> arguments) {
         StringBuilder str=new StringBuilder();
         if(this.remainingVehicles.size()==0){
             str.append("Remaining Vehicles: None\n");
         }else{
             str.append("Remaining Vehicles: "+String.join(", ",this.remainingVehicles)+"\n");
         }
        if(this.defeatedVehicles.size()==0){
            str.append("Defeated Vehicles: None"+"\n");
        }else{
            str.append("Defeated Vehicles: "+String.join(", ",this.defeatedVehicles)+"\n");
        }
        final int[] currentlyUsedParts = {0};
         this.vehicles.entrySet().stream().
                 forEach(x->{
                     List<Part> toJoin=new ArrayList<Part>((Collection<? extends Part>) x.getValue().getParts());
                     currentlyUsedParts[0] +=toJoin.size();
                 });
         str.append("Currently Used Parts: "+currentlyUsedParts[0]);
        return str.toString();
    }
}
