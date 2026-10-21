class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
           double[][] carDetails = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            int carPosition = position[i];
            int carSpeed = speed[i];
            double timeRequired = (double) (target - carPosition) / carSpeed;
            carDetails[i][0] = carPosition;
            carDetails[i][1] = timeRequired;
        }
        Arrays.sort(carDetails, (a, b) -> Double.compare(b[0], a[0]));
        int count = 0;
        double previousTime = 0;
        for (double[] ds : carDetails) {
            if (ds[1] > previousTime) {
                count++;
                previousTime = ds[1];
            }
        }

        return count;
    }
}
