public class Vector {

    private int x;
    private int y;
    private int z;

    public Vector(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector add(Vector vector) {
        return new Vector(this.x + vector.x,
                this.y + vector.y,
                this.z + vector.z);
    }

    public Vector substract(Vector vector) {
        return new Vector(this.x - vector.x,
                this.y - vector.y,
                this.z - vector.z);
    }
    

}
