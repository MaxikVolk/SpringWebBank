package com.fivesysdev.vovchuk.maxim.bankSecurity.models;

import com.fivesysdev.vovchuk.maxim.bankSecurity.security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Entering {
    static Scanner sc = new Scanner(System.in);

    public static User getUserFromContext() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ((MyUserDetails) authentication.getPrincipal()).getUser();
    }

    public static String enterString(String name) {
        System.out.print(name + ": ");
        String str = sc.next();
        System.out.println();
        return str;
    }

    public static String enterString(String name, int minLength) {
        while (true) {
            String str = enterString(name);
            if (str.length() >= minLength) {
                return str;
            }
            System.out.println("String must be at least "
                    + minLength + " characters");
        }
    }

    public static String enterString(
            String name, int minLength, int maxLength) {
        while (true) {
            String str = enterString(name, minLength);
            if (str.length() <= maxLength) {
                return str;
            }
            System.out.println("String must be less than " +
                    (maxLength + 1) + " characters");
        }
    }

    public static int enterInt(String name) {
        int i = Integer.MIN_VALUE;
        while (i == Integer.MIN_VALUE) {
            System.out.print(name + ": ");
            try {
                sc = new Scanner(System.in);
                i = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("number must be int");
            }
        }
        return i;
    }

    public static int enterInt(String name, int min) {
        while (true) {
            int i = enterInt(name);
            if (i >= min) {
                return i;
            }
            System.out.println("number must be at least " + min);
        }
    }

    public static int enterInt(String name, int min, int max) {
        while (true) {
            int i = enterInt(name, min);
            if (i <= max) {
                return i;
            }
            System.out.println("number must be less than " + (max + 1));
        }
    }

    public static double enterDouble(String name) {
        double i = Integer.MIN_VALUE;
        while (i == Integer.MIN_VALUE) {
            System.out.print(name + ": ");
            try {
                sc = new Scanner(System.in);
                i = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("number must be double");
            }
        }
        return i;
    }

    public static double enterDouble(String name, double min) {
        while (true) {
            double i = enterDouble(name);
            if (i >= min) {
                return i;
            }
            System.out.println("number must be at least " + min);
        }
    }

    public static double enterDouble(String name, double min, double max) {
        while (true) {
            double i = enterDouble(name, min);
            if (i <= max) {
                return i;
            }
            System.out.println("number must be less than " + (max + 1));
        }
    }

    public static long enterLong(String name) {
        long i = Long.MAX_VALUE;
        while (i == Long.MAX_VALUE) {
            System.out.print(name + ": ");
            try {
                sc = new Scanner(System.in);
                i = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("number must be long");
            }
        }
        return i;
    }

    public static long enterLong(String name, int min) {
        while (true) {
            long i = enterLong(name);
            long minAm = 1;
            for (int j = 1; j < min; j++) {
                minAm *= 10;
            }
            if (i >= minAm) {
                return i;
            }
            System.out.println(
                    "number must be at least " + min + " characters");
        }
    }

    public static long enterLong(String name, int min, int max) {
        while (true) {
            long i = enterLong(name, min);
            long maxAm = 10;
            for (int j = 1; j < max; j++) {
                maxAm *= 10;
            }
            maxAm--;
            if (i <= maxAm) {
                return i;
            }
            System.out.println("number must be less than " + (max + 1));
        }
    }

    public static short enterShort(String name) {
        short i = Short.MIN_VALUE;
        while (i == Short.MIN_VALUE) {
            System.out.print(name + ": ");
            try {
                sc = new Scanner(System.in);
                i = sc.nextShort();
            } catch (InputMismatchException e) {
                System.out.println("number must be short");
            }
        }
        return i;
    }

    public static short enterShort(String name, int min) {
        while (true) {
            short i = enterShort(name);
            if (i >= min) {
                return i;
            }
            System.out.println("number must be at least " + min);
        }
    }

    public static short enterShort(String name, int min, int max) {
        while (true) {
            short i = enterShort(name, min);
            if (i <= max) {
                return i;
            }
            System.out.println("number must be less than " + (max + 1));
        }
    }
}
