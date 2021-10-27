public class Rational
{
    // instance variables: every Rational object will have its own copy
    // of these variables
    public int numerator;
    public int denominator;
    
    /**
     * Constructor: the special method that will actually create a new Rational
     * object
     * Constructors are always public
     * Constructors have the same name as the class
     * Constructors have no return type
     */
    public Rational(int a, int b) {
        numerator = a;
        denominator = b;
    }

    // *****
    // You should go ahead and copy and paste the methods
    // from last class into here:
    public static Rational add(Rational r, Rational s) {
        int num1 = r.numerator * s.denominator;
        int num2 = s.numerator * r.denominator;
        int den1 = r.denominator * s.denominator;
        Rational new_rational = new Rational(num1 + num2, den1);
        return new_rational;
    }

    // This method takes two Rationals, subtracts thems up,
    // and returns a Rational equal to the difference
    public static Rational subtract(Rational r, Rational s) {
        int num1 = r.numerator * s.denominator;
        int num2 = s.numerator * r.denominator;
        int den1 = r.denominator * s.denominator;
        Rational new_rational = new Rational(num1 - num2, den1);
        return new_rational;
    }

    public static Rational multiply(Rational r, Rational s) {
        int num1 = r.numerator * s.numerator;
        int den1 = r.denominator * s.denominator;
        Rational new_rational = new Rational(num1, den1);
        return new_rational;
    }

    public static Rational divide(Rational r, Rational s) {
        int num1 = s.numerator * r.denominator;
        int den1 = s.denominator * r.numerator;
        Rational new_rational = new Rational(num1, den1);
        return new_rational;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor, find the largest number x
    // such that a and b are both multiples of x
    public static int greatestCommonFactor(int a, int b){
        int min = Math.min(a,b);
        int x = 0;
        for (int i = min; i >= 0; i--){
            if (a % i == 0 && b % i == 0){
                x = i;
                break;
            }
        }
        return x;
    }

    // This method is given a rational, and returns a simplified version
    // of the input rational
    // Use the greatestCommonFactor method here
    // e.g. simplify(2/4) => 1/2
    //      simplify(1/2) => 1/2
    public static Rational simplify(Rational r) {
        int gcf = greatestCommonFactor(r.numerator, r.denominator);
        int new_biden = r.numerator/gcf;
        int new_donald = r.denominator/gcf;
        return new Rational(new_biden,new_donald);
    }


    // *****




    // *****
    // Here are all of our NON-STATIC methods:
    // *****

    // Returns whether or not the numerator is greater than or equal
    // to the denominator
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.isImproper()) // true
    public boolean isImproper() {
       return (this.numerator >= this.denominator);
    }

    // Returns whether or not the Rational is currently simplified
    // or not
    // Example:
    // Rational r = new Rational(6,12);
    // System.out.println(r.isSimplified()) // false
    public boolean isSimplified() {
        return (greatestCommonFactor(this.numerator,this.denominator) == 1);
    }

    // Calculates the double value of our Rational
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.calculateDecimalValue()) // 0.75
    public double calculateDecimalValue() {
        return ((double) this.numerator/ this.denominator);
    }

    // Returns the Rational we get from raising the rational number to an integer power
    // Example:
    // Rational r = new Rational(2,5);
    // System.out.println(r.pow(2)) // 4/25
    public Rational pow(int exponent) {
        int x = (int) Math.pow(this.numerator, exponent);
        int y = (int) Math.pow(this.denominator, exponent);
        Rational z = new Rational(x,y);
        return (z);
    }

    // Checks to see if either the numerator or denominator match a given number
    // Example:
    // Rational r = new Rational(3,4);
    // System.out.println(r.contains(3)) // true
    public boolean contains(int x) {
        return (this.numerator == x||this.denominator == x);
    }

    // This returns a string representation of a Rational (e.g. "1/2")
    // This method has already been written for you
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    // *********
    // Here are is an example of a void method that changes the original Rational:
    // *********

    // This is a non-static version of simplify that returns a Rational
    // Example usage:
    // Rational r = new Rational(2, 4);
    // Rational s = r.simplify2(); // s = 1/2
    public Rational simplify2() {
        int gcf = gcf(this.numerator, this.denominator);
        int nume = this.numerator/gcf;
        int denom = this.denominator/gcf;
        Rational x = new Rational(nume, denom);
        return x;
    }

    // This is a non-static version of simplify that **changes** the original Rational
    // Note that the method is **void** because it doesn't need to return anything
    // Example usage:
    // Rational r = new Rational(2, 4);
    // r.simplify3(); // r is now equal to 1/2
    public void simplify3() {
        int gcf = gcf(this.numerator, this.denominator);
        this.numerator = this.numerator/gcf;
        this.denominator = this.denominator/gcf;
    }

    // Finds the greatest common factor between a and b
    // To find the greatest common factor,
    public static int gcf(int a, int b){
        int maxNum = 1;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) {
                maxNum = i;
            }
        }
        return maxNum;
    }

    // *********
    // Here are some methods that you will write later in class:
    // *********
    // Increments the current value of our Rational (increases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(3, 5);
    // r.increment(); // r is now 8/5
    public void increment() {
        this.numerator = this.numerator + this.denominator;
    }

    // Decrements the current value of our Rational (decreases the value
    // of the current Rational by 1/1)
    // Example:
    // Rational r = new Rational(6, 5);
    // r.decrement(); // r is now 1/5
    public void decrement() {
        this.numerator = this.numerator - this.denominator;
    }

    // Given an int input representing the new denominator, changes the
    // current Rational to an equivalent fraction with that new denominator
    // You can assume that the numerator will always end up as a whole number
    // Rational r = new Rational(3, 8);
    // r.changeToEquivalentFraction(64); // r is now 24/64 (which is equivalent to 3/8)
    public void changeToEquivalentFraction(int newDenominator) {
        double x = (double) newDenominator/this.denominator;
        this.numerator = (int) (this.numerator * x);
        this.denominator = newDenominator;
    }

    // **********
    // Methods you'll write for homework:
    // **********
    // Returns whether or not the Rational is a negative number
    // Example:
    // Rational r = new Rational(-3,4);
    // System.out.println(r.isNegative()) // true
    public boolean isNegative() {
        if (this.numerator < 0 && this.denominator < 0){
            return false;
        }
        else if (this.numerator < 0 || this.denominator < 0){
            return true;
        }
        else{
            return false;
        }
    }

    // Calculates the reciprocal of a Rational number.
    // The reciprocal of 3/4 is 4/3, the reciprocal of 1/2 is 2/1
    // Example:
    // Rational r = new Rational(5,2);
    // System.out.println(r.reciprocal()) // 2/5
    public Rational reciprocal() {
        Rational r = new Rational(this.denominator, this.numerator);
        return r;
    }

    // Checks whether the current Rational is the exactly the same as other
    // Example:
    // Rational r = new Rational(2,5);
    // Rational s = new Rational(2,4);
    // System.out.println(r.equals(s)) // false
    public boolean equals(Rational other) {
        return (this.numerator == other.numerator && this.denominator == other.denominator);
    }

    // Rounds the current Rational to the nearest whole number value
    // Example:
    // Rational r = new Rational(3, 2);
    // r.round(); // r is now 2/1
    public void round() {
        double x = (double)this.numerator/this.denominator;
        int y = (int) x;
        double subtract = x - y;
        if (subtract >= 0.5){
            this.numerator = (int) ((1-subtract) + x);
            this.denominator = 1;
        }



    }
}













