"""
Steps:

Initialization:

Initialize total_tank to keep track of the total gas balance.
Initialize current_tank to keep track of the current gas balance.
Initialize starting_station to keep track of the potential starting station.

Iterate Over Stations:

For each station, update total_tank and current_tank.
If current_tank becomes negative, reset current_tank to 0 and update starting_station to the next station.

Check Total Gas:

After iterating through all stations, if total_tank is negative, return -1. Otherwise, return starting_station.
"""
class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        n = len(gas)
    
        total_tank = 0
        current_tank = 0
        starting_station = 0
        
        for i in range(n):
            total_tank += gas[i] - cost[i]
            current_tank += gas[i] - cost[i]
            
            # If current tank goes negative, reset starting station
            if current_tank < 0:
                starting_station = i + 1
                current_tank = 0
        
        return starting_station if total_tank >= 0 else -1