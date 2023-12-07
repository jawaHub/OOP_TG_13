package c2KNN;

public class DataObjects {
    private double x;
    private double y;
    private double klasse;

    public DataObjects(double x, double y, double klasse){
        this.x = x;
        this.y = y;
        this.klasse = klasse;
    }

        public DataObjects(double x, double y){
        this(x, y, -1);
    }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getKlasse() {
            return klasse;
        }

        public void setX(double x) {
            this.x = x;
        }

        public void setY(double y) {
            this.y = y;
        }

        public void setKlasse(double klasse) {
            this.klasse = klasse;
        }

    
}
