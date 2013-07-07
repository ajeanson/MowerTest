package fr.opensides.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import fr.opensides.domain.Input;
import fr.opensides.domain.Position;
import fr.opensides.domain.repository.EControl;
import fr.opensides.domain.repository.EOrientation;
import fr.opensides.services.InputsDigester;

public class InputsDigesterImpl implements InputsDigester {
	private final static Logger log = Logger.getLogger(InputsDigesterImpl.class.getName());
	
	public List<Input> digestInputs(String filename){
		log.info("disgest file "+filename);
		int lawnUpperRightCornerX = 0;
		int lawnUpperRightCornerY = 0;
		
		File file = new File(filename);
        List<Input>inputs = new ArrayList<Input>();
        try {
            Scanner scanner = new Scanner(file);
            
            //load first line:
            String line = scanner.nextLine();
            lawnUpperRightCornerX = Integer.valueOf(line.substring(0,1));
            lawnUpperRightCornerY = Integer.valueOf(line.substring(1,2));
            log.debug("load first line ("+line+"): lawnUpperRightCornerX:"+lawnUpperRightCornerX+"/lawnUpperRightCornerY:"+lawnUpperRightCornerY);
            //load following lines:
            while (scanner.hasNextLine()) {
                String positionLine = scanner.nextLine();
                String controlsLine = scanner.nextLine();
                log.debug("load a mover  - positionLine:"+positionLine+"/controlsLine:"+controlsLine);
                inputs.add(new Input(lawnUpperRightCornerX, lawnUpperRightCornerY, getPositionFromLine(positionLine), getControlsFromLine(controlsLine)));
            }
        } catch (FileNotFoundException e) {
            log.error("Error while opening file "+filename);
            //throws exception for bad parsing
        }catch(Exception e){
        	 log.error("Error while parsing file "+filename);
        	//throws exception for bad parsing
        }
		return inputs;
	}
	
	
	private Position getPositionFromLine(String positionLine){
		int x = Integer.valueOf(positionLine.substring(0,1));
		int y = Integer.valueOf(positionLine.substring(1,2));
		EOrientation orientation = EOrientation.valueOf(positionLine.substring(2,3));
		return new Position(x,y,orientation);
	}
	
	private List<EControl>getControlsFromLine(String controlsLine){
		log.info("Load a control line: "+controlsLine);
		List<EControl>controls = new ArrayList<EControl>();
		for (int i = 0; i < controlsLine.length(); i++){
			
			EControl control = EControl.valueOf(controlsLine.substring(i,i+1));
			if (control == null){
				log.error("Error while parsing #"+i+" control in controls line: "+controlsLine);
				//TODO: throws exception
			}else{
				log.debug("OK add control :"+control);
				controls.add(control);
			}
		}
		return controls;
	}
	
}
