import java.util.*;
class Main {
  public static void main(String[] args) {
    int x = 0;
    Scanner s = new Scanner(System.in);
    String answer = "";
    Characters player = new Characters("Hollow", "Night", 0, 9, 1, 150, 0, false);
    System.out.print("Choose a character - Harry Potty(1), Homeowner Simpsons(2), Drem(3), Hollow Night(4), Costum(5): ");
    String player1 = s.nextLine();
    if (player1.equals("1")){
      player = new Characters("Harry", "Potty", 12, 8, 3, 150, 0, false);
    }
    else if (player1.equals("2")){
      player = new Characters("Homeowner", "Simpsons", 69, 4, 8, 100, 0, false);
    }
    else if (player1.equals("3")){
      player = new Characters("Drem", "WasTaken", 23, 6, 2, 200, 0, false);
    }
    else if (player1.equals("4")){
      player = new Characters("Hollow", "Night", 0, 9, 1, 150, 0, false);
    }
    else if (player1.equals("5")){
      System.out.print("Choose a First Name: ");
      String name1 = s.nextLine();
      System.out.print("Choose a Last Name: ");
      String name2 = s.nextLine();
      player = new Characters(name1, name2, random.randint(30,80), random.randint(3,10), random.randint(3,10), random.randint(5,300), 0, false);
    }
    Event.play = player;
    Event[] events = {new Event("You need to leave the house. Wear a mask for $5?", -5, 3, -2,-5, 0), new Event("Your friends are going out for lunch. Join them?", 5, -2, 3, 0, 0), new Event("Vaccines available at your local CVC!", 0, 3, -1, 0, 1),new Event("Jobs available at an indoor resturant for $100", 5, -3, 2, 100, 0), new Event("Zoom night with friends! Pay $50 to repair your computer?", 0, 0, 3, -50, 0), new Event("Oh no! Your best friend has Covid 19! Visit her in the hospital?", 5, -3, 3, 0, 0), new Event("Coronavirus cases reported in your family! Quarentine for 14 days?", -5, 3, -3, 0, 0), new Event("New movie just came out! Tickets available!", 5, -3, 3, -5, 0), new Event("You just got fired! Sell your house?", 0, 0, -3, 100, 0), new Event("Join the gym for $50", 5, 3, 3, -50, 0), new Event("Sleep all day", 0, -2, 3, 0, 0)};
    int r = random.randint(0, events.length-1);
    int r1 = random.randint(0, events.length-1);
    while(r1 == r){
      r1 = random.randint(0, events.length-1);
    }
    int r2 = random.randint(0, events.length-1);
    while(r2 == r || r2 == r1){
      r2 = random.randint(0, events.length-1);
    }
    System.out.println("");
    slowType.slow("** Covid 19 disease reported in the US! Stores all over the country are closeing down. To help slow the spread, everyone exept for front-line workers are being asked to quarentine. We know that self isolating can be very difficult mentally, so make sure to take part in as many physical and social activities as you can while staying safe. You'll know you need to be doing more of these events if your happyness meter starts going down. Similarly, if you do not follow health guidlines, your health bar might go down as well. Watch out not to spend too much money on items or you might go bankrupt. If any of these sections equals 0, it's game over! That's all for today. We hope you can stay safe and happy during this bizzare, worldwide pandamic.", 0);
    System.out.println("");
    slowType.slow("- The Buddy Bundle **",100);
    System.out.println("");
    player.turn+=1;
    while(player.alive == true){
      if(answer.length()>=1){
        player.varient = player.getCovid();
      }
      if(player.varient == true){
        if(player.age < 50){
          player.health -= 5;
        }
        else{
          player.health -= 6;
        }
      }
      player.homePage();
      if(player.varient == true){
        if(player.health<=0){
            slowType.slow("You died of Covid. Game Over!",50);
            System.out.println("");
            slowType.slow("You survived for " + player.turn + " turns.",50);
          System.out.println("");
            player.alive = false;
            break;
        }
      }
      if(player.money <= 0){
        slowType.slow("You lost all your money and went Bankrupt. Game Over!",50);
        System.out.println("");
        slowType.slow("You survived for " + player.turn + " turns.",50);
        System.out.println("");
        player.alive = false;
        break;
      }
      if(player.health <= 0){
        slowType.slow("You were too unhealthy and died. Game Over!",50);
        slowType.slow("You survived for " + player.turn + " turns.",50);
        player.alive = false;
        break;
      }
      if(player.happy <= 0){
        if(player.money>100){
          slowType.slow("You were too sad and need Therapy for $100!(y/n)",50);
          answer = s.nextLine();
        }
        else{
          slowType.slow("You were too sad and can't afford Therapy. Game Over!",50);
          slowType.slow("You survived for " + player.turn + " turns.",50);
          player.alive = false;
          break;
        }
      }
      if(answer.equals("y")){
        player.money-=100;
        player.happy=10;
        answer = "";
      }
      else if(answer.equals("n")){
        slowType.slow("You were too sad and didn't get Therapy. Game Over!",50);
        slowType.slow("You survived for " + player.turn + " turns.",50);
        player.alive = false;
        break;
      }
      else{
        answer = "";
        System.out.println(events[r].eve + "(1)");
        System.out.println(events[r1].eve + "(2)");
        System.out.println(events[r2].eve + "(3)");
        answer = s.nextLine();
        if(answer.equals("1")){
          player.turn+=1;
          events[r].reset();
          r = random.randint(0, events.length-1);
          while(r1 == r || r2 == r){
            r = random.randint(0, events.length-1);
          }
        }
        else if(answer.equals("2")){
          player.turn+=1;
          events[r1].reset();
          r1 = random.randint(0, events.length-1);
          while(r == r1 || r2 == r1){
            r1 = random.randint(0, events.length-1);
          }
        }
        else if(answer.equals("3")){
          player.turn+=1;
          events[r2].reset();
          r2 = random.randint(0, events.length-1);
          while(r == r2 || r1 == r2){
            r2 = random.randint(0, events.length-1);
          }
        }
      }
    }
  }
}
