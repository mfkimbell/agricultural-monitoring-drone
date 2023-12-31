package tello;

import tellolib.communication.TelloConnection;
import tellolib.control.TelloControl;
import tellolib.drone.TelloDrone;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScanFarm
{
    private final Logger logger = Logger.getGlobal();

    public void execute()
    {
        logger.info("start");

        TelloControl telloControl = TelloControl.getInstance();

        TelloDrone drone = TelloDrone.getInstance();

        telloControl.setLogLevel(Level.FINE);

        try {
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

            for (int i = 0; i < 5; i++) {

                telloControl.rotateRight(90);

                telloControl.forward(120);

                telloControl.rotateLeft(90);

                telloControl.forward(20);

                telloControl.rotateLeft(90);

                telloControl.forward(120);

                telloControl.rotateRight(90);

                telloControl.forward(20);

                String s = String.valueOf(i);

                logger.info("i:" + s);

            }

            //return to base

            telloControl.rotateRight(180);
            telloControl.forward(200);
            telloControl.rotateRight(180);



            // fly a curve to a point 3.25 feet in front of the drone and
            // 1.5 feet higher.


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
