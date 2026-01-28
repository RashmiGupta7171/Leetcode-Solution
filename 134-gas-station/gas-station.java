
// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int totalGas = 0;
//         int totalCost = 0;
//         int tank = 0;
//         int start = 0;

//         for (int i = 0; i < gas.length; i++) {
//             totalGas += gas[i];
//             totalCost += cost[i];
//             tank += gas[i] - cost[i];

//             // If tank becomes negative, reset start position
//             if (tank < 0) {
//                 start = i + 1;
//                 tank = 0;
//             }
//         }

       
//         return totalGas >= totalCost ? start : -1;
//     }
// }


class Solution{
    public int canCompleteCircuit(int[] gas , int[] cost){
        int position = 0 , sum = 0 , total = 0 ;

        for(int index = 0 ; index < gas.length ; index++){
            sum += gas[index] - cost[index];

            if(sum < 0){
                total += sum;
                sum = 0;
                position = index + 1;
            }
        }
        total += sum;
        return total >= 0 ? position : -1;
    }
}