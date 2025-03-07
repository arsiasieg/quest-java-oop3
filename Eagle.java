public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }
    
    @Override
    public String sing() {
        return "Cry!";
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }
    
    /**
     * take off, must be on ground
     */
    
    public void takeOff() {
    	if (!this.flying && this.altitude == 0) {
    		this.flying = true;
    		System.out.printf("%s take off in the sky.%n", this.getName());
    	}
    };
    
    /**
     * swin upward
     * @param meters depths decrease
     * @return depth
     */
    
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 100);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
    
    /**
     * flies downward
     * @param meters altitude increase
     * @return altitude
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }
    
    /**
     * get out of water, must be on surface
     */
    @Override
    public void land() {
        if (this.flying && this.altitude == 0) {
            System.out.printf("%s lands on the ground.%n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
        }
    }

	public void glide() {
		System.out.printf("%s glides into the air.%n", this.getName());
	}
}
