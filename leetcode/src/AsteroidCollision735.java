public class AsteroidCollision735 {
    public int[] asteroidCollision(int[] asteroids) {
        int slow = 1;
        int fast = 1;
        while (fast < asteroids.length) {
            if (slow != 0 && ((asteroids[fast] < 0 && asteroids[slow - 1] < 0) || (asteroids[fast] > 0 && asteroids[slow - 1] > 0))) {
                swap(asteroids, fast, slow);
                fast++;
                slow++;
            }
            else if (slow != 0 && (asteroids[fast] < 0 && asteroids[slow - 1] > 0)){
                if (Math.abs(asteroids[fast]) > Math.abs(asteroids[slow - 1])) {
                    slow--;
                }
                else if (Math.abs(asteroids[fast]) < Math.abs(asteroids[slow - 1])){
                    fast++;
                }
                else {
                    fast++;
                    slow--;
                }
            }
            else {
                asteroids[slow] = asteroids[fast];
                fast++;
                slow++;
            }
        }
        return Arrays.copyOf(asteroids, slow);
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
