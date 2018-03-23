# Project-1-Data-Structures
Kelvin Garcia Muñiz

802142644

CIIC4020 - 030

## To Run the Program:
Before executing any of these commands from the CMD or Terminal make sure you are in the correct directory path. If using Eclipse or a 
similar IDE, these procedures may not be required.
### To Run Part 1:
From terminal: java -classpath ./bin  p1MainClasses/Part1Main

From IDE: Run Part1Main.java from the p1MainClasses package
### To Run Part 2:
From terminal: java -classpath ./bin  p1MainClasses/Part2Main  n  m  isize  fsize  istep  rep

    Where:
    
       n = number of companies
       
       m = number of crimes
       
       isize = initial size for experimentations
       
       fsize = final size for experimentations
       
       isetp = incremental size step (how much the size increases by trial)
       
       rep = number of repetitions per size
       
     * For detailed information head to the in-code implementation *
From IDE: Run Part2Main.java, with the desired parameters, from the p1MainClasses package
## Part 1:
This part includes a working version of the four strategies to be implemented (P1, P2, P3, P4). 
Output produces the results for a particular input in which the intersection of all the sets is the set containing the corresponding
elements. (See results sample in "Part1 Sample Results Sheet.pdf")
## Part 2:
This part produces the empirical results for the execution times of each one of the four strategies in "part2Results/allResults.txt". (See running results sample graphs in "Part 2 Sample Results Sheets.pdf").
## Understanding the code:
In order tu understand the hierarchy of the classes, head to the "UML Kelvin Garcia CIIC4020-030.ucls" file or to the "README.pdf" file.
  ### Package dataGenerator
   #### Includes:
       DataGenerator.java (public): generates the data given parameter n, m, and totalSize
       DataReader.java (public): reads the data from the files generated
  ### Package interfaces
   #### Includes:
       IntersectionFinder.java (interface) - an objects of type finds the intersection of a family of sets.
       MySet.java (interface) - used by the intersectSets methods that the experiments will be implementing.
  ### Package mySetImplementations
   #### Includes: 
       AbstractMySet.java (public abstract)- an abstract class of MySet.
       Set1.java (public) - used by strategy P1 and implements ArrayLists
       Set2.java (public) - used by the remaining strategie and implements HashMaps
  ### Package p1MainClasses
   #### Includes: 
       FilesGeneratorMain.java - generates the files to be used in Part 1, with the given number of crimes and companies
       Part1Main.java - main class to run Part1 of the project. Outputs the intersections given by each of the strategies
       Part2Main.java - main class to run Part2 of the project. Outputs the execution times of the strategies given certain parameters. (See "To Run the program" or head to the in-code implementation of the class for more information)
