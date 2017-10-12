package server.domain.entity;

public enum TaskPriority {
    LOW, MEDIUM, HIGH;

    public String getAssociatedColor(){
        switch (this) {
            case LOW:
                return "#8370D8";
            case MEDIUM:
                return "#00A876";
            case HIGH:
                return "#E869AA";
        }
        return "";
    }
}
