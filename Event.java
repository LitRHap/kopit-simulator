class Event {
  public String eve;
  public int vaccine;
  public int covidChange;
  public int healthChange;
  public int happyChange;
  public int moneyChange;
  public static Characters play;
  public Event(String ev, int co,int he,int ha,int mo, int vac){
    eve = ev;
    covidChange = co;
    healthChange = he;
    happyChange = ha;
    moneyChange = mo;
    vaccine = vac;
  }
  public void reset(){
    play.covid += covidChange;
    play.health += healthChange;
    play.happy += happyChange;
    play.money += moneyChange;
    if(vaccine > 0 && play.vaccine < 3){
      play.covid /= 2;
    }
    play.vaccine += vaccine;
  }
}
