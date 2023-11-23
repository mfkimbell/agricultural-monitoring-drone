package tello;

import farm.Drone;
import tellolib.communication.TelloConnection;
import tellolib.control.TelloControl;
import tellolib.drone.TelloDrone;

import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Math.abs;

public class GoHome
{

    private final Logger logger = Logger.getGlobal();

    public void execute(Drone droneInfo)
    {
        logger.info("start");
        double locationX = -1*(droneInfo.getX())/5;
        double locationY = -1*(droneInfo.getY())/5;
        logger.info("X distance" + String.valueOf(locationX));
        logger.info("Y distance" + String.valueOf(locationY));


        TelloControl telloControl = TelloControl.getInstance();

        TelloDrone drone = TelloDrone.getInstance();

        telloControl.setLogLevel(Level.FINE);

        try
        {
            telloControl.connect();

            telloControl.enterCommandMode();

            // Now we will fly. This command will cause the drone to take
            // off to its default initial altitude. Note that taking off
            // can take some time and we wait in this method until the
            // signals completion of take off.

            telloControl.takeOff();

            telloControl.startStatusMonitor();

            // Now we will execute a series of movement commands.
            // Distances in centimeters.

            if (locationY < 0) {
                telloControl.rotateRight(180);

            }

            telloControl.forward(abs(Integer.valueOf((int) locationY)));



            if (locationX < 0) {
                telloControl.rotateLeft(90);
                telloControl.forward(abs(Integer.valueOf((int) locationY)));
                telloControl.rotateRight(90);
            } else {
                telloControl.rotateRight(90);
                telloControl.forward(abs(Integer.valueOf((int) locationY)));
                telloControl.rotateLeft(90);

            }



            //telloControl.doFlip(TelloFlip.backward);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally
        {
            if (telloControl.getConnection() == TelloConnection.CONNECTED && drone.isFlying())
            {
                try
                {telloControl.land();}
                catch(Exception e) { e.printStackTrace();}
            }
        }

        telloControl.disconnect();

        logger.info("end");
    }
}
