package pp.linguisticCategories;

import pp.grammaticalCategories.Gender;
import pp.grammaticalCategories.PerfectOrImperfect;
import pp.grammaticalCategories.Pronoun;
import pp.grammaticalCategories.Time;

import java.util.Scanner;

/**
 * Created by Admin on 30.11.2016.
 */
public  class LCDefineDimension {
    public static Gender defineGender() {
        return Gender.MALE;
    }

    public static boolean defineIsPlural() {
        return false;
    }

    public static PerfectOrImperfect definePerfectImperfect(){
        System.out.println("доконаний\\недоконаний вид");
        System.out.println("1. доконаний вид");
        System.out.println("2. недоконаний вид");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("введіть номер форми дієслова:");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    return PerfectOrImperfect.PERFECT;
                case 2:
                    return PerfectOrImperfect.IMPERFECT;
                default:
                    System.out.println("невірно введено. введіть номер позиції 1 чи 2");
                    continue;
            }
        }
    }

    public static Time defineTime() {
        System.out.println("часи дієслова");
        System.out.println("1. минулий");
        System.out.println("2. теперішній");
        System.out.println("3. майбутній");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("введіть номер часу дієслова:");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    return Time.PAST;
                case 2:
                    return Time.PRESENT;
                case 3:
                    return Time.FUTURE;
                default:
                    System.out.println("невірно введено. введіть номер позиції 1, 2 чи 3");
                    continue;
            }
        }
    }


    public static Pronoun definePerson() {
        System.out.println("особи");
        System.out.println("1. я");
        System.out.println("2. ти");
        System.out.println("3. він");
        System.out.println("4. вона");
        System.out.println("5. воно");
        System.out.println("6. ми");
        System.out.println("7. ви");
        System.out.println("8. вони");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("введіть номер часу дієслова:");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    return Pronoun.I;
                case 2:
                    return Pronoun.THOU;
                case 3:
                    return Pronoun.HE;
                case 4:
                    return Pronoun.SHE;
                case 5:
                    return Pronoun.IT;
                case 6:
                    return Pronoun.WE;
                case 7:
                    return Pronoun.YOU;
                case 8:
                    return Pronoun.THEY;
                default:
                    System.out.println("невірно введено позицію. спробуйте ще раз");
                    continue;
            }
        }
    }
}