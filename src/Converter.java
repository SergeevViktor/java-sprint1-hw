public class Converter {
        public double calculationDistance(int month, StepTracker stepTracker) {
            return (stepTracker.amountStepsPerMonth(month) * 0.75) / 1000.0;
        }
        public double calculationKilocalories(int month, StepTracker stepTracker) {
            return (stepTracker.amountStepsPerMonth(month) * 50) / 1000.0;
        }
}