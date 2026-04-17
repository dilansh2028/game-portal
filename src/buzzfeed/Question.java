package buzzfeed;

import java.util.Scanner;

public class Question {
    // Fields
    String label;
    Answer[] possibleAnswers = new Answer[4];

    Question(String label) {
        this.label = label;
    }

    
    Category ask(Scanner sc) {
        System.out.println(this.label);
        
        for (int i = 0; i < this.possibleAnswers.length; i++) {
            String choice = Integer.toString(i + 1);
            System.out.println("[" + choice + "]:" +
                    this.possibleAnswers[i].label);
        }

        //ishaan wrote this
        if(sc.hasNextInt() == false){
            sc.next();
            return ask(sc);
        }
        int ans = sc.nextInt();

        //dilan wrote this
        if(ans != 1 && ans != 2 && ans != 3 && ans != 4 ){
            return ask(sc);
        }
        return possibleAnswers[ans-1].cat;
    }
}
