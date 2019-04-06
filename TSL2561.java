import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TSL2561
{
	public static void main(String args[]) throws Exception
	{
		
		I2CBus Bus = I2CFactory.getInstance(I2CBus.BUS_1);
		I2CDevice device = Bus.getDevice(0x39);

		device.write(0x00 | 0x80, (byte)0x03);
		device.write(0x01 | 0x80, (byte)0x02);
		
		Thread.sleep(500);

		byte[] data=new byte[4];
		device.read(0x0C | 0x80, data, 0, 4);

		double ch0 = ((data[1] & 0xFF)* 256 + (data[0] & 0xFF));
		double ch1 = ((data[3] & 0xFF)* 256 + (data[2] & 0xFF));

		System.out.printf("Full Spectrum(IR + Visible) : %.2f lux %n", ch0);
		System.out.printf("Infrared Value : %.2f lux %n", ch1);
		System.out.printf("Visible Value : %.2f lux %n", (ch0 - ch1));
	}
}