import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GradeAnalyser {
    public static void main(String[] args) {
        String fileName = "scores.txt";

        List<Integer> scoresList = readScores(fileName);
        if(scoresList != null ){
            System.out.println("Total Scores:"+scoresList.size());
            Iterator<Integer> scoresIterator = scoresList.iterator();
            while(scoresIterator.hasNext()){
                System.out.println(scoresIterator.next());
            }
        }
        
        List<Integer> testList = new ArrayList<>();
        testList.add(100);
        testList.add(140);
        testList.add(60);

        System.out.println("Testing Average:"+ calculateAverage( testList ));
        System.out.println("Score Average:"+ calculateAverage( scoresList ));

        Integer highest = Integer.MIN_VALUE;
        Integer lowest = Integer.MAX_VALUE;
        for(int i=0;i<scoresList.size();i++) {
            Integer score = scoresList.get(i);
            if( score > highest){
                highest = score;
            }
            if( score < lowest){
                lowest = score;
            }
        }
        
        writeReport(scoresList, calculateAverage( scoresList ), highest, lowest, "report.txt");

    }

    private static List<Integer> readScores(String fileName) {
        List<Integer> scores = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String scoreLine = reader.readLine();
            while(scoreLine != null){
                
                if(!scoreLine.trim().isEmpty()){
                    try{
                        scores.add(Integer.parseInt(scoreLine)); 
                    }catch(NumberFormatException numberFomratException){
                        System.out.println("Error parsing number:"+numberFomratException.getMessage());
                    }
                }
                scoreLine = reader.readLine();

            }
        }catch (IOException ioException) {
            System.out.println("Error reading File:"+ioException.getMessage());
            return null;
        }
        return scores;
    }
    
    public static double calculateAverage(List<Integer> numberList){
        double average = 0.0D;
        if(numberList != null && numberList.size() > 0) {
            double total =0.0D;
            Iterator<Integer> numberIterator = numberList.iterator();
            while(numberIterator.hasNext()){
                total += numberIterator.next();
            }
            average=total/numberList.size();
        }
        return average;
    }

    public static void writeReport(List<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        int gradeACount = 0, gradeBCount = 0,  gradeCCount = 0, gradeDCount = 0, gradeFCount = 0;

        for(int i=0;i<scores.size();i++) {
            Integer score = scores.get(i);
            if( score >= 90){
                gradeACount++;
            } else if (score<=89 && score>=80) {
                gradeBCount++;
            } else if (score<=79 && score>=70) {
                gradeCCount++;
            }else if (score<=69 && score>=60) {
                gradeDCount++;
            } else {
                gradeFCount++;
            }
            
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writeStringToWriterAndPrintOnConsole(writer, "=== Grade Analysis Report ===\n");
            writeStringToWriterAndPrintOnConsole(writer, "\n");

            
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("Total scores processed: %d%n", scores.size()) );
            
            writeStringToWriterAndPrintOnConsole(writer, "\n");
            
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("Average score: %.2f%n", avg) );     
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("Highest score: %d%n", high) );
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("Lowest score: %d%n", low) );
            writeStringToWriterAndPrintOnConsole(writer, "\n");
            writeStringToWriterAndPrintOnConsole(writer, "Grade distribution:\n");
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("A (90-100): %d%n", gradeACount) );
            writeStringToWriterAndPrintOnConsole(writer, 
                String.format("B (80-89): %d%n", gradeBCount) );
             writeStringToWriterAndPrintOnConsole(writer, 
                String.format("C (70-79): %d%n", gradeCCount) );
             writeStringToWriterAndPrintOnConsole(writer, 
                String.format("D (60-69): %d%n", gradeDCount) );
             writeStringToWriterAndPrintOnConsole(writer, 
                String.format("F (below 60): %d%n", gradeFCount) );
        } catch (IOException ioException) {
            System.out.println("Error reading File:"+ioException.getMessage());
        }
    }

    private static void writeStringToWriterAndPrintOnConsole(BufferedWriter writer, String strOutput) throws IOException {
        writer.write(strOutput);
        System.out.print(strOutput);
    }
}