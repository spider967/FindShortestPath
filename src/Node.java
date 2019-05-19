public class Node {

    private int posX, posY, distance;

    public Node(int posX, int posY, int distance) {
        this.posX = posX;
        this.posY = posY;
        this.distance = distance;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getDistance() {
        return distance;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
