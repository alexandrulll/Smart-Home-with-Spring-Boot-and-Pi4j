public class relay {
	
public static void main(String [] args) {
	
    final GpioController gpio = GpioFactory.getInstance();
    
    Pin pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_06);             
    GpioPinDigitalOutput output = gpio.provisionDigitalOutputPin(pin, "My Output", PinState.HIGH);
    
    int i = 0;
    
	while(i < 10) {
		
    	output.high();
    	output.blink(1000);
    	output.low();
    	i++;
    	
    	}
	}
}