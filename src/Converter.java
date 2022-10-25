public class Converter {
        public double calculationDistance(int month, StepTracker stepTracker) {
            return (stepTracker.monthToData[month].amountStepsPerMonth() * 0.75) / 1000.0;
        }
        public double calculationKilocalories(int month, StepTracker stepTracker) {
            return (stepTracker.monthToData[month].amountStepsPerMonth() * 50) / 1000.0;
        }
}