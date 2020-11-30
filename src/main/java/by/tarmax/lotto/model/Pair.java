package by.tarmax.lotto.model;

public class Pair implements Comparable<Pair>{
    private Combination combination;
    private int one;
    private int two;
    private int three;
    private int four;
    private int five;
    private int six;
    private int sum;
    private double constancy;

    public Pair() {
    }

    public Pair(Combination combination, Integer one, Integer two, Integer three,
                Integer four, Integer five, Integer six) {
        this.combination = combination;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;

        this.sum = one + two + three + four + five + six;

        double avr = sum / 6;
        this.constancy = (Math.abs(one - avr) + Math.abs(two - avr) + Math.abs(three - avr)
                + Math.abs(four - avr) + Math.abs(five - avr) + Math.abs(six - avr))/6;
    }

    public Combination getCombination() {
        return combination;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTwo() {
        return two;
    }

    public void setTwo(Integer two) {
        this.two = two;
    }

    public Integer getThree() {
        return three;
    }

    public void setThree(Integer three) {
        this.three = three;
    }

    public Integer getSum() {
            return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public double getConstancy() {
        return constancy;
    }

    @Override
    public String toString() {
        return
                "combination=" + combination +
                ", " + one +
                ", " + two +
                ", " + three +
                ", " + four +
                ", " + five +
                ", " + six +
                ", sum=" + sum +
                ", " + combination.getLastDate() +
                ", " + constancy +
                '}';
    }

    @Override
    public int compareTo(Pair o) {
//        return this.one - o.getOne();
        int i = 0;
        if (this.constancy > o.getConstancy()) {
            i = 1;
        } else if(this.constancy < o.getConstancy()) {
            i = -1;
        }
        return i;
    }
}
