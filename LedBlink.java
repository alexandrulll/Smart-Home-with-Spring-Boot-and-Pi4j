class LedBlink {
    public static void main(String args[]) {
        System.out.println("Press CTRL-C to exit");	    	
        try {			
            Runtime runTime = Runtime.getRuntime();
            runTime.exec("gpio mode 4 out");
            while(true) {
                runTime.exec("gpio write 4 1");
                Thread.sleep(500);
                runTime.exec("gpio write 4 0");
                Thread.sleep(500);
            }		
        } catch (Exception e) {
            System.out.println("Exception occured: " + e.getMessage());
        }
    }
}