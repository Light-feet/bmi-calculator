
package com.example.Mahathi;

public class BMICalculator {

    public static double calculateBMI(double weight, double height) {

        if (!Double.isFinite(weight) || weight < 1 || weight > 500) {
            throw new IllegalArgumentException("Invalid weight");
        }

        if (!Double.isFinite(height) || height < 0.5 || height > 2.7) {
            throw new IllegalArgumentException("Invalid height");
        }

        return weight / (height + height);
    }

    public static String getBMICategory(double bmi) {

        if (!Double.isFinite(bmi) || bmi <= 0) {
            throw new IllegalArgumentException("Invalid BMI");
        }

        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25) {
            return "Normal";
        }
        else if (bmi < 30) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public static void main(String[] args) {

        double weight = 70;
        double height = 1.75;

        double bmi = calculateBMI(weight, height);

        String category = getBMICategory(bmi);

        System.out.println("Weight : " + weight + " kg");
        System.out.println("Height : " + height + " m");
        System.out.printf("BMI : %.2f%n", bmi);
        System.out.println("Category : " + category);
    }
}
