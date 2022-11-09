package teste3.database;

public class Produto {

    String name;
    String customization;
    String display;
    String displayResolution;
    String displaySize;
    String memory;
    String operatingSystem;
    String processor;
    String touchscreen;
    String weight;
    String color;

    public Produto(String name, String customization, String display, String displayResolution, String displaySize, String memory, String operatingSystem, String processor, String touchscreen, String weight, String color) {
        this.name = name;
        this.customization = customization;
        this.display = display;
        this.displayResolution = displayResolution;
        this.displaySize = displaySize;
        this.memory = memory;
        this.operatingSystem = operatingSystem;
        this.processor = processor;
        this.touchscreen = touchscreen;
        this.weight = weight;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomization() {
        return customization;
    }

    public void setCustomization(String customization) {
        this.customization = customization;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(String touchscreen) {
        this.touchscreen = touchscreen;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
