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

    public Vector multiply(int n) {
        return new Vector(this.x * n,
                this.y * n, this.z * n);
    }

    public int dotProduct(Vector vector1) {
        return vector1.x * this.x +
                vector1.y * this.y + vector1.z * this.z;
    }

    public Vector crossProduct(Vector vector1) {
        return new Vector(
                this.y * vector1.z - this.z * vector1.y,
                this.z * vector1.x - this.x * vector1.z,
                this.x * vector1.y - this.y * vector1.x);
    }

}
