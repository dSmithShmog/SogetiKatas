

import java.time.LocalDateTime;

//im not sure how to program an object that is continuously in existence as a means of checking the 30 day rules
//but here goes nothing, maybe I can approach is as just statically/manually checking dates
class RedPencilProduct {

    private boolean redPencil;
    private LocalDateTime creationDate;
    private double originalPrice;
    private double currentPrice;
    private int sale;

    //In a real implementation it would likely be better to use actual dates and arithmetic,
    //but since I just need 30 day triggers, this simplistic approach should be fine. Hopefully
    private int daysAsRedPencil;
    private int daysPastRedPencil;

    public RedPencilProduct(double price){
        this.redPencil = false;
        this.creationDate = LocalDateTime.now();
        this.originalPrice = price;
        this.currentPrice = price;
        this.sale = 0;
        this.daysAsRedPencil = 0;
        this.daysPastRedPencil = 30;
    }

    protected void changeSale(int change) {
        this.sale += change;

        if(change < 0){
            redPencil = false;
            daysPastRedPencil = 0;
            daysAsRedPencil = 0;
        }
        else if(sale > 5 && sale < 30 && daysPastRedPencil >= 30){
            redPencil = true;
            daysAsRedPencil = 0;
            daysPastRedPencil = 0;
        }
        else{
            redPencil = false;
            daysPastRedPencil = 0;
            daysAsRedPencil = 0;
        }

        currentPrice = originalPrice*sale;

    }

    //under the assumption that some external framework calls this method every 24 hours, seems clunky but it could work
    protected void checkIn(){
        if(daysAsRedPencil+1 >= 30){
            currentPrice = originalPrice;
            redPencil = false;
            changeSale(-sale); //reset sale to zero
            daysAsRedPencil = 0;
            daysPastRedPencil = 0;
        }
        else if(!redPencil){
            daysPastRedPencil++;
        }
        daysAsRedPencil++;

    }

    //getters
    protected double getCurrentPrice(){return this.currentPrice;}
    protected double getOriginalPrice(){ return this.originalPrice;}
    protected int getSale(){return this.sale;}
    protected LocalDateTime getCreationDate(){return this.creationDate;}
    protected boolean getRedPencil(){return this.redPencil;}

    //setters
    protected void setCurrentPrice(double x){this.currentPrice = x;}
    protected void setDaysAsRedPencil(int x){this.daysAsRedPencil = x;}
    protected void setDaysPastRedPencil(int x){this.daysPastRedPencil = x;}

}
