public class Rectangle {

        // Fields
        private double width;
        private double height;
        private int id;
        private static int idGen;

        // Constructuri
        public Rectangle() {
            this.width = 1.0;
            this.height = 1.0;
            this.id = idGen++;
        }

        public Rectangle(double width, double height) {
            this(); // вызов конструктора по умолчанию
            setWidth(width);
            setHeight(height);
        }

        // Getteri
        public double getWidth() {
            return width;
        }

        public double getHeight() {
            return height;
        }

        public int getId() {
            return id;
        }

        // Setteri
        public void setWidth(double width) {
            if (width <= 0) {
                throw new IllegalArgumentException("Width must be greater than 0");
            }
            this.width = width;
        }

        public void setHeight(double height) {
            if (height <= 0) {
                throw new IllegalArgumentException("Height must be greater than 0");
            }
            this.height = height;
        }

        // Metodi
        public double area() {
            return width * height;
        }

        public double perimeter() {
            return 2 * (width + height);
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "id=" + id +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }




}
