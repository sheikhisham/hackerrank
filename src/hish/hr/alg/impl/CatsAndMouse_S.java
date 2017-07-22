package hish.hr.alg.impl;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 * Created by shisham on 22-Jul-17.
 */
public class CatsAndMouse_S {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        String[] r = new String[q];
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            int xT = Math.abs(z-x);
            int yT = Math.abs(z-y);
            if(xT < yT) {
                r[a0] = "Cat A";
            } else if(xT > yT) {
                r[a0] = "Cat B";
            } else {
                r[a0] = "Mouse C";
            }
        }

        for(String s : r) {
            System.out.println(s);
        }
    }
}
