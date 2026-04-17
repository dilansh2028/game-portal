package buzzfeed;

import java.util.HashMap;
import java.util.Scanner;
import Game.GameGeneric;
import Game.GameWriteable;;

public class Quiz extends GameGeneric implements GameWriteable {
        static Scanner sc = new Scanner(System.in);
        static String username = new String();
        static FileSave fs;
        HashMap<String, Integer> cats = new HashMap<>();

        @Override
        public String getScore() {
                int maxCount = 0;
                String maxCat = "";
                for (String cat : cats.keySet()){
                        if(cats.get(cat) > maxCount){
                                maxCount = cats.get(cat);
                                maxCat = cat;
                        }
                }
                return maxCat;
        }

        @Override
        public void play() {
                try {
                        fs = new FileSave("QuizResults.csv");
                        HashMap<String, String> results = fs.getResults();
                        // dilan created categories
                        Category nike = new Category("Nike", "You are athletic and love to play many sports.");
                        Category polo = new Category("Ralph Lauren",
                                        "You are classy and elegant in everything you do.");
                        Category uniqlo = new Category("Uniqlo", "You are a very relaxed and simple person.");
                        Category balenciaga = new Category("Balenciaga", "You are very wealthy and like to show off.");

                        // dilan did question 1-5, ishaan did questions 6-9
                        sc.nextLine();
                        System.out.println("What is your username: ");
                        username = sc.nextLine();

                        Question q1 = new Question("What is your favorite activity to do in your free time?");
                        q1.possibleAnswers[0] = new Answer("Play sports with your friends", nike);
                        q1.possibleAnswers[1] = new Answer("Read a book at the park", polo);
                        q1.possibleAnswers[2] = new Answer("Watch a television show", uniqlo);
                        q1.possibleAnswers[3] = new Answer("Go shopping at the mall", balenciaga);

                        Question q2 = new Question("What is your dream sports car?");
                        q2.possibleAnswers[0] = new Answer("I would want an Aston Martin", balenciaga);
                        q2.possibleAnswers[1] = new Answer("I would want a Porsche", polo);
                        q2.possibleAnswers[2] = new Answer("I would want a Ferrari", nike);
                        q2.possibleAnswers[3] = new Answer("I would want a Mercedes", uniqlo);

                        Question q3 = new Question("What is your favorite drink");
                        q3.possibleAnswers[0] = new Answer("I drink Coffee", uniqlo);
                        q3.possibleAnswers[1] = new Answer("I drink Matcha", polo);
                        q3.possibleAnswers[2] = new Answer("I drink Tea", balenciaga);
                        q3.possibleAnswers[3] = new Answer("I drink Gatorade", nike);

                        Question q4 = new Question("What is your favorite food?");
                        q4.possibleAnswers[0] = new Answer("My favorite food is Grilled Chicken", nike);
                        q4.possibleAnswers[1] = new Answer("My favorite food is Steak", balenciaga);
                        q4.possibleAnswers[2] = new Answer("My favorite food is Salad", polo);
                        q4.possibleAnswers[3] = new Answer("My favorite food is any type of Sandwich", uniqlo);

                        Question q5 = new Question("Which social media platform do you use the most?");
                        q5.possibleAnswers[0] = new Answer("I use Twitch", nike);
                        q5.possibleAnswers[1] = new Answer("I use Youtube", uniqlo);
                        q5.possibleAnswers[2] = new Answer("I use Instagram", polo);
                        q5.possibleAnswers[3] = new Answer("I use X (Twitter)", balenciaga);

                        Question q6 = new Question("What Sport do you watch the most?");
                        q6.possibleAnswers[0] = new Answer("I watch Basketball", nike);
                        q6.possibleAnswers[1] = new Answer("I watch Golf", polo);
                        q6.possibleAnswers[2] = new Answer("I watch Soccer", uniqlo);
                        q6.possibleAnswers[3] = new Answer("I watch Formula 1", balenciaga);

                        Question q7 = new Question("Which personality trait resonates with you most?");
                        q7.possibleAnswers[0] = new Answer("I am Quiet", uniqlo);
                        q7.possibleAnswers[1] = new Answer("I am Composed", polo);
                        q7.possibleAnswers[2] = new Answer("I am Hardworking", nike);
                        q7.possibleAnswers[3] = new Answer("I am confident", balenciaga);

                        Question q8 = new Question("What's your ideal job?");
                        q8.possibleAnswers[0] = new Answer("My ideal job is a Lawyer", polo);
                        q8.possibleAnswers[1] = new Answer("My ideal job is an Athlete", nike);
                        q8.possibleAnswers[2] = new Answer("My ideal job is a Musician", uniqlo);
                        q8.possibleAnswers[3] = new Answer("My ideal job is a CEO", balenciaga);

                        Question q9 = new Question("What is your favorite television show? ");
                        q9.possibleAnswers[0] = new Answer("My favorite show is Breaking Bad", balenciaga);
                        q9.possibleAnswers[1] = new Answer("My favorite show is Outer Banks", uniqlo);
                        q9.possibleAnswers[2] = new Answer("My favorite show is Suits", polo);
                        q9.possibleAnswers[3] = new Answer("My favorite show is Stranger Things", nike);

                        // ishaan edited this
                        gameIntro();
                        Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8, q9 };
                        for (Question q : qList) {
                                Category c = q.ask(sc);
                                c.points++;
                        }
                        Category[] cList = { nike, polo, uniqlo, balenciaga };
                        int index = getMostPopularCatIndex(cList);
                        System.out.println("If you were a clothing brand, you would be " + cList[index].label + ". ");
                        System.out.println(cList[index].description);
                        fs.updateResult(username, cList[index].label);

                        System.out.println("Total number of people in each category: ");
                        for (String cat : results.values()) {
                                if (cats.containsKey(cat)) {
                                        cats.put(cat, cats.get(cat) + 1);
                                } else {
                                        cats.put(cat, 1);
                                }

                        }

                        for (String cat : cats.keySet()) {
                                System.out.println(cat + ", " + cats.get(cat));
                        }

                } catch (Exception e) {
                        e.printStackTrace();
                }

        }

        public void gameIntro() {
                // dilan edited this
                System.out.println("Which Clothing Brand Are You? Play to Find Out!");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to begin!");

                if (sc.hasNextInt() == false) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        sc.next();
                        gameIntro();
                        return;
                }
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        sc.next();
                        gameIntro();
                        return;
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/
        public int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }

        @Override
        public boolean isHighScore(String score, String currentHighScore) {
                return true;
        }
}
