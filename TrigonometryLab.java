
import java.util.Scanner;

public class TrigonometryLab {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Problem 1
        // Ask for angle in degrees
        System.out.println("Problem 1");
        System.out.print("Enter angle in degrees: ");
        double degrees = input.nextDouble();

        // Ask for function choice;
        System.out.println("Choose a function:");
        System.out.println("1: Sine");
        System.out.println("2: Cosine");
        System.out.println("3: Tangent");
        System.out.println("4: All three");
        int choice = input.nextInt();

        // Convert to radians
        double radians = Math.toRadians(degrees);

        if (choice == 1) {
            double sine = Math.sin(radians);
            System.out.println("Sine(" + degrees + "°) = " + sine);
        } else if (choice == 2) {
            double cosine = Math.cos(radians);
            System.out.println("Cosine(" + degrees + "°) = " + cosine);
        } else if (choice == 3) {
            if (Math.abs(degrees % 180 - 90) <= 1) {
                System.out.println("Warning: Tangent is undefined near " + degrees + "°");
            } else {
                double tangent = Math.tan(radians);
                System.out.println("Tangent(" + degrees + "°) = " + tangent);
            }
        } else if (choice == 4) {
            double sine = Math.sin(radians);
            double cosine = Math.cos(radians);
            if (Math.abs(degrees % 180 - 90) <= 1) {
                System.out.println("Warning: Tangent is undefined near " + degrees + "°");
                System.out.println("Sine(" + degrees + "°) = " + sine);
                System.out.println("Cosine(" + degrees + "°) = " + cosine);
            } else {
                double tangent = Math.tan(radians);
                System.out.println("Sine(" + degrees + "°) = " + sine);
                System.out.println("Cosine(" + degrees + "°) = " + cosine);
                System.out.println("Tangent(" + degrees + "°) = " + tangent);
            }
        } else {
            System.out.println("Invalid choice. Please select 1 to 4.");
        }

        //======================================================================
        System.out.println();
        System.out.println("Problem 2");
        //Problem 2
        // Ask the user to input an angle
        System.out.print("Enter an angle in degrees: ");
        double angle = input.nextDouble();

        // Normalize the angle to [0°, 360°)
        angle = angle % 360;
        if (angle < 0) {
            angle += 360;
        }

        // Determine quadrant and signs using if-else
        if (angle == 0 || angle == 180 || angle == 360) {
            System.out.println("Angle lies on the X-axis.");
            System.out.println("Sine: 0");
            System.out.println("Cosine: " + (angle == 180 ? "-1" : "1"));
            System.out.println("Tangent: 0");
        } else if (angle == 90 || angle == 270) {
            System.out.println("Angle lies on the Y-axis.");
            System.out.println("Sine: " + (angle == 90 ? "1" : "-1"));
            System.out.println("Cosine: 0");
            System.out.println("Tangent: Undefined");
        } else if (angle > 0 && angle < 90) {
            System.out.println("Quadrant I");
            System.out.println("Sine: Positive");
            System.out.println("Cosine: Positive");
            System.out.println("Tangent: Positive");
        } else if (angle > 90 && angle < 180) {
            System.out.println("Quadrant II");
            System.out.println("Sine: Positive");
            System.out.println("Cosine: Negative");
            System.out.println("Tangent: Negative");
        } else if (angle > 180 && angle < 270) {
            System.out.println("Quadrant III");
            System.out.println("Sine: Negative");
            System.out.println("Cosine: Negative");
            System.out.println("Tangent: Positive");
        } else if (angle > 270 && angle < 360) {
            System.out.println("Quadrant IV");
            System.out.println("Sine: Negative");
            System.out.println("Cosine: Positive");
            System.out.println("Tangent: Negative");
        } else {
            System.out.println("Unexpected angle value.");
        }

        //======================================================================
        System.out.println();
        System.out.println();
        System.out.println("Problem 3");
        System.out.println("What do you know?");
        System.out.println("1: Two sides");
        System.out.println("2: One side and one angle (not the right angle)");
        int desisyon = input.nextInt();

        double a = 0, b = 0, c = 0;
        double A = 0, B = 0, C = 90;
        double area = 0;

        if (desisyon == 1) {
            System.out.println("Enter side a:");
            a = input.nextDouble();
            System.out.println("Enter side b:");
            b = input.nextDouble();

            c = Math.sqrt(a * a + b * b);
            A = Math.toDegrees(Math.atan(a / b));
            B = 90 - A;
            area = 0.5 * a * b;

            System.out.println("Sides: a = " + a + ", b = " + b + ", c = " + c);
            System.out.println("Angles: A = " + A + "°, B = " + B + "°, C = 90°");
            System.out.println("Area = " + area);
        } else if (desisyon == 2) {
            System.out.println("Enter known side:");
            double side = input.nextDouble();
            System.out.println("Enter known angle (less than 90):");
            double angle2 = input.nextDouble();

            A = angle;
            B = 90 - A;

            System.out.println("Is the known side opposite (1) or adjacent (2) to the angle?");
            int type = input.nextInt();

            if (type == 1) {
                a = side;
                b = a / Math.tan(Math.toRadians(A));
            } else {
                b = side;
                a = b * Math.tan(Math.toRadians(A));
            }

            c = Math.sqrt(a * a + b * b);
            area = 0.5 * a * b;

            System.out.println("Sides: a = " + a + ", b = " + b + ", c = " + c);
            System.out.println("Angles: A = " + A + "°, B = " + B + "°, C = 90°");
            System.out.println("Area = " + area);
        } else {
            System.out.println("Invalid choice.");
        }

        //========================================================================
        System.out.println();
        System.out.println();
        System.out.println("Problem 4");

        // A small value for tolerance to account for floating-point inaccuracies.
        final double epsilon = 1e-9;

        // Ask the user to input an angle in degrees.
        System.out.print("Enter an angle in degrees: ");
        double angleDegrees = input.nextDouble();

        // Convert the angle from degrees to radians, as Java's Math functions use radians.
        double angleRadians = Math.toRadians(angleDegrees);

        // Calculate sine, cosine, and tangent of the angle.
        double sinVal = Math.sin(angleRadians);
        double cosVal = Math.cos(angleRadians);
        double tanVal = Math.tan(angleRadians);

        System.out.println("\nVerifying identities for an angle of " + angleDegrees + " degrees...");

        // Verify the identities by calculating both sides.
        // Identity 1: sin^2(theta) + cos^2(theta) = 1
        System.out.println("\nChecking sin^2(theta) + cos^2(theta) = 1");
        double leftSide1 = Math.pow(sinVal, 2) + Math.pow(cosVal, 2);
        double rightSide1 = 1.0;

        // Use an if-else statement to check if the identity holds true within the tolerance.
        if (Math.abs(leftSide1 - rightSide1) < epsilon) {
            System.out.println("   The identity holds true.");
        } else {
            double difference1 = Math.abs(leftSide1 - rightSide1);
            System.out.printf("   The identity does not hold true.%n");
            System.out.printf("     Difference: %.10f%n", difference1);
        }

        // Identity 2: 1 + tan^2(theta) = sec^2(theta)
        System.out.println("\nChecking 1 + tan^2(theta) = sec^2(theta)");
        // Handle cases where tan(theta) or sec(theta) are undefined.
        if (Math.abs(cosVal) < epsilon) {
            System.out.println("   Skipped: The identity is undefined for this angle.");
        } else {
            double leftSide2 = 1 + Math.pow(tanVal, 2);
            double rightSide2 = 1 / Math.pow(cosVal, 2); // sec(theta) is 1/cos(theta)

            if (Math.abs(leftSide2 - rightSide2) < epsilon) {
                System.out.println("   The identity holds true.");
            } else {
                double difference2 = Math.abs(leftSide2 - rightSide2);
                System.out.printf("   The identity does not hold true.%n");
                System.out.printf("     Difference: %.10f%n", difference2);
            }
        }

        // Identity 3: sin(2*theta) = 2*sin(theta)*cos(theta)
        System.out.println("\nChecking sin(2theta) = 2sin(theta)cos(theta)");
        double leftSide3 = Math.sin(2 * angleRadians);
        double rightSide3 = 2 * sinVal * cosVal;

        if (Math.abs(leftSide3 - rightSide3) < epsilon) {
            System.out.println("   The identity holds true.");
        } else {
            double difference3 = Math.abs(leftSide3 - rightSide3);
            System.out.printf("   The identity does not hold true.%n");
            System.out.printf("     Difference: %.10f%n", difference3);
        }

        //======================================================================
        System.out.println();
        System.out.println();
        System.out.println("Problem 5");

        final double epsilon1 = 1e-9; // Tolerance for floating-point comparisons

        // 1. Ask the user for wave properties
        System.out.println("Enter the wave properties:");
        System.out.print("Amplitude (A): ");
        double amplitude = input.nextDouble();
        System.out.print("Frequency (f) in Hz: ");
        double frequency = input.nextDouble();
        System.out.print("Phase shift (phi) in radians: ");
        double phaseShift = input.nextDouble();

        // 2. Ask for a specific time value
        System.out.print("\nEnter a time value (t) in seconds: ");
        double time = input.nextDouble();

        // Calculate angular frequency (omega)
        double omega = 2 * Math.PI * frequency;

        // Calculate the instantaneous value of the wave at the given time
        double instantaneousValue = amplitude * Math.sin(omega * time + phaseShift);

        // Display the instantaneous value
        System.out.printf("\nInstantaneous value of the wave at t=%.2f s is: %.4f%n", time, instantaneousValue);

        // 3. Implement appropriate checks for wave properties
        // Check if the wave is at a peak, trough, or zero-crossing using if-else statements
        if (Math.abs(instantaneousValue - amplitude) < epsilon) {
            System.out.println("The wave is currently at a PEAK.");
        } else if (Math.abs(instantaneousValue - (-amplitude)) < epsilon) {
            System.out.println("The wave is currently at a TROUGH.");
        } else if (Math.abs(instantaneousValue) < epsilon) {
            System.out.println("The wave is currently at a ZERO-CROSSING.");
        } else {
            System.out.println("The wave is not at a peak, trough, or zero-crossing at this time.");
        }

        // Calculate the time to the next peak
        // The time of a peak is when the sine function equals 1, i.e., omega*t + phi = pi/2 + 2*k*pi
        // Solving for t: t = (pi/2 - phi + 2*k*pi) / omega
        // We need the next peak, so we find the smallest non-negative k that gives a future time.
        double nextPeakTime;
        double ab = (Math.PI / 2) - phaseShift;

        // Find the smallest non-negative k
        double k = Math.ceil((omega * time - a) / (2 * Math.PI));

        nextPeakTime = (a + 2 * k * Math.PI) / omega;

        System.out.printf("\nThe next time the wave will reach a peak is: %.4f seconds%n", nextPeakTime);

        input.close();
        //======================================================================

        //Critical Thinking Questions
        /*
        Problem 1:
        a. We convert angles from degrees to radians because java particularly
        use radians for their trigonometric functions.
        
        b. The tangent becomes undefined when the denominator, cos(θ), is zero.
        This occurs at angles like 90 and 270 as well as every 180 after that.
        
        c. You would need to add a new option to your user selection menu like 
        (5: Cosecant, 6: Secant, 7: Cotangent, 8: All) and add corresponding 
        if-else or switch statements to handle the new calculations.
        
        
        Problem 2: 
        a. Normalizing an angle is crucial because the trigonometric functions 
        are periodic. This means they repeat their values every 360.
        
        b. The signs of sine, cosine, and tangent are determined by the quadrant 
        where the angle's terminal side lies. It depends whether they are within
        those angles. 
        
        c. If they land on angles that lie on the axis, then it would 
        print the name of the axis that the input is on. The angles 0,90,270, 
        and 360, act as boundaries for determining the correct quadrant.
        
        
        Problem 3:
        a. We must validate that angles are less than 90 because a right 
        triangle, by definition, has one angle that is exactly 90. The sum of
        the interior angles of any triangle must be 180 
        
        b. The program would handle different cases using a series of if-else 
        statements or a switch statement. The first step is to ask the user to 
        select which elements they know. Next, depending on which case, the 
        program would prompt the user for the lengths of the two sides or prompt
        for the known side and angle.
        
        c. If a user enters invalid values, the program would produce incorrect
        results. The program would likely fail to calculate other values correctly.
        
        
        Problem 4:
        a. We need a tolerance when comparing floating-point values because they're 
        stored in a computer's memory using a binary format that can lead to tiny, 
        unavoidable rounding errors.

        b. The identity 1+tan^2θ=sec^2θ is the most susceptible to floating-
        point precision issues. This is because it involves division. Both tanθ= 
        cosθ/sinθ and secθ= 1/cosθ involve division, which can compound small 
        rounding errors already present in sin and cos values.
        
        c. You could extend the program to verify more complex identities by
        creating a function for each new identity, using a switch statement, and
        Adding advanced mathematical evaluation. This would allow the program to
        dynamically verify a wide range of identities without requiring you to 
        hard-code each one.
        
        
        Problem 5:
        a. I determined if the wave is at a peak or trough by comparing its 
        instantaneous value to its amplitude. If the instantaneous value is 
        equal to the amplitude, the wave is at a peak.
        
        b. I used the mathematical formula for a sinusoidal wave's peak. A peak 
        occurs when the argument of the sine function is equal to pi/2 plus a 
        multiple of 2 pi.By setting the expression ωt+ϕ equal to pi/2 + 2k 
        multiplied by pi, and solving for time (t), I get a general formula 
        for all peak times.
        
        c. To handle non-sinusoidal waves, the program would need to be 
        fundamentally changed. The current program relies on the sine function 
        to calculate wave properties. For a non-sinusoidal wave, you would need 
        to replace the sine function with a different mathematical model that 
        describes the new wave shape.
         */
    }
}
