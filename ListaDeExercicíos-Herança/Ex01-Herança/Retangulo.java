public class Retangulo extends Forma {
    private double base;
    private double altura;
    
    public Retangulo(double base, double altura) {
        base = base;
        altura = altura;
    }
    
    public double getBase() {
        return base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public double getArea() {
        return base * altura;
    }
    
    public double getPerimetro() {
        return 2 * (base + altura);
    }
    
    public double getDiagoal() {
        return Math.sqrt(Math.pow(base,2) * Math.pow(altura,2));
    }
}