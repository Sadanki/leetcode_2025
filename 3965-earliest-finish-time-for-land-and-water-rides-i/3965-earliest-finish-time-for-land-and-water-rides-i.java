class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {
        int earliest = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                // Case A: Land first, then Water
                int finishLand = landStartTime[i] + landDuration[i];
                int startWater = Math.max(finishLand, waterStartTime[j]);
                int finishWater = startWater + waterDuration[j];
                earliest = Math.min(earliest, finishWater);

                // Case B: Water first, then Land
                int finishWaterFirst = waterStartTime[j] + waterDuration[j];
                int startLand = Math.max(finishWaterFirst, landStartTime[i]);
                int finishLandSecond = startLand + landDuration[i];
                earliest = Math.min(earliest, finishLandSecond);
            }
        }

        return earliest;
    }
}