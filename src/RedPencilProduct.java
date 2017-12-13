

import java.time.LocalDateTime;

//im not sure how to program an object that is continuously in existence as a means of checking the 30 day rules
//but here goes nothing, maybe I can approach is as just statically/manually checking dates
public class RedPencilProduct {

    private boolean redPencil;
    private LocalDateTime creationDate;
    private double originalPrice;
    private double currentPrice;
    private int sale;

    //In a real implementation it would likely be better to use actual dates and arithmetic,
    //but since I just need 30 day triggers, this simplistic approach should be fine. Hopefully
    private int redPencilDays;
    private int daysPastRedPencil;

    public void RedPencilProduct(double p){
        this.redPencil = false;
        this.creationDate = LocalDateTime.now();
        this.originalPrice = p;
        this.currentPrice = p;
        this.sale = 0;
        this.redPencilDays = 0;
        this.daysPastRedPencil = 30;
    }

    protected void changeSale(int s) {
        this.sale += s;

        if(s < 0){
            redPencil = false;
            daysPastRedPencil = 0;
            redPencilDays = 0;
        }
        else if(sale > 5 && sale < 30 && daysPastRedPencil >= 30){
            redPencil = true;
            redPencilDays = 0;
            daysPastRedPencil = 0;
        }
        else{
            redPencil = false;
            daysPastRedPencil = 0;
            redPencilDays = 0;
        }

        this.currentPrice = this.originalPrice*sale;

    }

    //under the assumption that some external framework calls this method every 24 hours
    protected void checkRedPencil(){
        if(redPencilDays+1 >= 30){
            this.currentPrice = this.originalPrice;
            this.redPencil = false;
            this.sale = 0; //sort of conflicts with my changeSale. Poor design?
            redPencilDays = 0;
            daysPastRedPencil = 0;
        }
        else if(!redPencil){
            daysPastRedPencil++;
        }

    }

    //getters
    private double getPrice(){return this.currentPrice;}
    private int getSale(){return this.sale;}
    private LocalDateTime getCreationDate(){return this.creationDate;}


}
