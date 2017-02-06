/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rpncalculator;


import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Joakim
 */
public class RPNMain {

    static Scanner scan = new Scanner(System.in);
    static Stack<Integer> stack = new Stack();

    public static void main(String[] args) {
        try {
            calc();
        } catch(Exception e){
            System.out.println("FAILURE! SYSTEM OVERLOAD!");
        }
    }

    public static void calc() {
        String input = "";
        while (!input.equals("close")) {
            System.out.println("Enter your input: ");
            input = scan.next();
            try {
                int number = Integer.valueOf(input);
                stack.push(number);
            } catch (Exception e) {
                if (input.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                    System.out.println("Result: "+stack.peek());
                } else if (input.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                    System.out.println("Result: "+stack.peek());
                } else if (input.equals("-")) {
                    stack.push(stack.pop() - stack.pop());
                    System.out.println("Result: "+stack.peek());
                } else if (input.equals("/")) {
                    stack.push(stack.pop() / stack.pop());
                    System.out.println("Result: "+stack.peek());
                } else if (input.equals("see")){
                    for (int i = 0; i < stack.size(); i++) {
                        System.out.println(stack.get(i));
                    }
                }
            }
        }
    }
}