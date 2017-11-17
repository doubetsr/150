package Lab8;/*
 * Lab 8 Starting Code
 *
 * comments intentionally left out to shorten code for printout
 * 
 * written by C.Anderson,  CSIS150 fall 2013
 *  @author canderson
 *  modified by Sherri Harms, CSIT 150 Fall 2017
 *  edited by Sam Doubet, CSIT 150 Fall 2017
 */

public class TheaterRevenues {

    /**
     * create the variables for child and adult price, tickets and theatre cut.
     * create Final defaults for each variable.
     */
    private int adultTickets;
    private int childTickets;
    private double adultPrice;
    private double childPrice;
    private double theatercut;
    private final static double DEFAULTTHEATERCUT = 0.20;
    private final static double DEFUALTADULTPRICE = 75;
    private final static double DEFAULTCHILDPRICE = 30;
    private final static int DEFAULTADULTTICKETS = 0;
    private final static int DEFAULTCHILDTICKETS = 0;

    /**
     * set the default constructor.
     */
    public TheaterRevenues()
    {
        adultTickets=DEFAULTADULTTICKETS;
        childTickets=DEFAULTCHILDTICKETS;
        adultPrice=DEFUALTADULTPRICE;
        childPrice=DEFAULTCHILDPRICE;
        theatercut=DEFAULTTHEATERCUT;
    }

    /*Get Calculated values for sales, net and gross*/
    public double calcNetAdultSales()
    {
        return adultTickets*adultPrice*theatercut;
    }
    public double calcNetChildSales()
    {
        return childTickets*childPrice*theatercut;
    }
    public double calcGrossAdultSales()
    {
        return adultTickets*adultPrice;
    }
    public double calcGrossChildSales()
    {
        return childTickets*childPrice;
    }
    public double calcTotalGross()
    {
        return calcGrossAdultSales()+calcGrossChildSales();
    }
    public double calcTotalNet()
    {
        return calcNetAdultSales()+calcNetChildSales();
    }

    /* Get the default values */
     public double getDefaultAdultPrice() {
        return DEFUALTADULTPRICE;
    }
    public double getDefaultChildPrice() {
        return DEFAULTCHILDPRICE;
    }
    public int getDefaultAdultTickets() {
        return DEFAULTADULTTICKETS;
    }
    public int getDefaultChildTickets()
    {
        return DEFAULTCHILDTICKETS;
    }

    /*Getters and setters for the prices and number of tickets*/
    public void setChildTickets(int childTickets) {
        this.childTickets = childTickets;
    }
    public int getChildTickets() {
        return childTickets;
    }

    public void setAdultTickets(int adultTickets) {
        this.adultTickets = adultTickets;
    }
    public int getAdultTickets() {
        return adultTickets;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }
    public double getChildPrice() {
        return childPrice;
    }

    public void setAdultPrice(double adultPrice) {
        this.adultPrice = adultPrice;
    }
    public double getAdultPrice() {
        return adultPrice;
    }
   }
