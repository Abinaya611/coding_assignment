//package creational;

// Complex object
class Computer {
    private final String cpu;
    private final int ramGB;
    private final int storageGB;
    private final boolean hasGpu;

    private Computer(Builder b) {
        this.cpu = b.cpu; this.ramGB = b.ramGB; this.storageGB = b.storageGB; this.hasGpu = b.hasGpu;
    }
    @Override public String toString() {
        return "Computer[cpu=" + cpu + ", ram=" + ramGB + "GB, storage=" + storageGB + "GB, gpu=" + hasGpu + "]";
    }

    public static class Builder {
        private String cpu = "Intel i3";
        private int ramGB = 4;
        private int storageGB = 256;
        private boolean hasGpu = false;
        public Builder cpu(String cpu) { this.cpu = cpu; return this; }
        public Builder ramGB(int r) { this.ramGB = r; return this; }
        public Builder storageGB(int s) { this.storageGB = s; return this; }
        public Builder hasGpu(boolean g) { this.hasGpu = g; return this; }
        public Computer build() { return new Computer(this); }
    }
}

public class BuilderDemo {
    public static void main(String[] args) {
        Computer gaming = new Computer.Builder()
                .cpu("AMD Ryzen 7")
                .ramGB(16)
                .storageGB(1024)
                .hasGpu(true)
                .build();
        System.out.println(gaming);

        Computer office = new Computer.Builder().ramGB(8).build();
        System.out.println(office);
    }
}
