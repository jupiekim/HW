//Julie Kim
//Period 8
//HW 27
//Due November 19

public class Rational {

    //============================PHASE 1============================

    //INSTANACE VARIABALES
    private int _num;
    private int _denom;

    //CONSTRUCTORS
    public Rational () { _num = 0; _denom = 1; }
    
    public Rational (int n, int d) {
	if (d == 0) { _num = 0; _denom = 1; System.out.println("Come on, a rational number can't be undefined, you know that! In other terms, the denominator can't be equal to 0. For now, I'll set your values for you."); }
	else { _num = n; _denom = d; }
    }

    //ACCESSORS
    public int getNum () { return _num; }
    public int getDenom () { return _denom; }

    //toString 
    public String toString () {
	String rn; String n = Integer.toString(_num); String d = Integer.toString(_denom);
	if (_denom == 1) { rn = n; }
	else { rn = n + "/" + d; }
	return rn;
    }
 
    public double floatValue () { 
	return (double) _num / (double) _denom; 
    }

    public void multiply (Rational n) {
	_num *= n.getNum();
	_denom *= n.getDenom();
    }

    public void divide (Rational n) {
	_num *= n.getDenom();
	_denom *= n.getNum();
    }

    //============================PHASE 2============================

    //for use in addition and subtraction of rational objects
    public static int lcd (int a, int b) {
	int min = Math.min(a, b);
	int max = Math.max(a, b);
	int p = min * max;
	int lcd = 1;
	while (min <= p) {
	    if (max % min == 0) { lcd = max; break; }
	    else { max += Math.max(a,b); }
	} 
	return lcd;
    }

    public void add (Rational n) {
	int lcd = lcd(_denom, n.getDenom());
	int f1 = lcd / _denom;
	int f2 = lcd / n.getDenom();
	if (_denom == n.getDenom()) { _num += n.getNum(); }
	else { _denom = lcd; _num = f1 * _num + f2 * n.getNum(); }
    }

    public void subtract (Rational n) {
	int lcd = lcd(_denom, n.getDenom());
	int f1 = lcd / _denom;
	int f2 = lcd / n.getDenom();
	if (_denom == n.getDenom()) { _num -= n.getNum(); }
	else { _denom = lcd; _num = f1 * _num - f2 * n.getNum(); }
    }

    public int gcf () {
	int min = Math.min(_num, _denom);
	int max = Math.max(_num, _denom);
	int gcf = 1;
	while (min >= 1) {
	    if (max % min == 0) { gcf = min; break; }
	    else { min = max % min; }
	}
	return gcf;
    }

    public void reduce () {
	int gcf = this.gcf();
	if (gcf == 1) { }
	else { _num /= gcf; _denom /= gcf; }
    }

    //============================PHASE 3============================

    public static int gcf (int num, int denom) {
	int min = Math.min(num, denom);
	int max = Math.max(num, denom);
	int gcf = 1;
	while (min >= 1) {
	    if (max % min == 0) { gcf = min; break; }
	    else { min = max % min; }
	}
	return gcf;
    }

    public int compareTo (Rational n) {
	int c;
	if (this.floatValue() == n.floatValue()) { c = 0; }
	else if (this.floatValue() > n.floatValue()) { c = 1; }
	else { c = -1; }
	return c;
    }


    //MAIN METHOD FOR TESTING
    public static void main (String[] args) {

	Rational r = new Rational(2,3); 
	Rational s = new Rational(1,2); 
	Rational t = new Rational(4,6);
	Rational u = new Rational(3,2);

	System.out.println("Num = 2, Denom = 3: " + r);
	System.out.println("Num = 1, Denom = 2: " + s);

	System.out.println("2/3 ~ " + r.floatValue());
	System.out.println("1/2 ~ " + s.floatValue());

	r.multiply(s);
	System.out.println("Multiplying 2/3 by 1/2: " + r);

	r.divide(s);
	System.out.println("Dividing 2/6 by 1/2: " + r);

	System.out.println(lcd(5, 10));
	System.out.println(lcd(12, 5));

	r.add(s);
	System.out.println("Adding 4/6 to 1/2: " + r);

	r.subtract(s);
	System.out.println("Subtracting 7/6 from 1/2: " + r);
	
	System.out.println(r.gcf());
	System.out.println(s.gcf());
	System.out.println(t.gcf());
	System.out.println(u.gcf());

	t.reduce();
	r.reduce();
	System.out.println(r);
	System.out.println(t);

	System.out.println(r.compareTo(t));
	System.out.println(r.compareTo(s));
	System.out.println(r.compareTo(u));

	//EVERYTHING WORKS IN MY FAVOR WOOHOO THANKS MAIN METHOD
    }

}