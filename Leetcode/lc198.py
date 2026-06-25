# lc198
# easy DP question (basically)
# maximize money but can't take from adjacent houses

# kinda like knapsack so very DP

# subproblem/ dichotomy:
    #  rob first, can't rob adjacent, NOW find the max from the rest of the input
    # vs skip this index and do max w/ rest of arr


# rob max(arr[0] + rob[2:len], 
#          rob[1:len])

# only need to store prev two results that are max


def rob(self, nums) -> int:
    rob1, rob2 = 0,0    # [r1, r2, a, b, ...]
    # if I'm going to rob a, I'm allowed to grab the max from r1
    # if I'm going to rob b, I'm allowed to grab the max from section r1:r2 
    
    # so we only rlly store these two maxes to use for decisions

    for val in nums: # val bc using the VALUE at index i, for each loop
        temp = max(val + rob1, rob2) # max of what we have found until now
        rob1 = rob2
        rob2 = temp
    return rob2 #reaches the final index, and when it does we have the max from the entire arr nums

# using [1,2,3,1], sol = 4

# max(1+0, 0), r2 = 1
# max(2+0, 2), r1 = 1, r2 = 2
# max(3+1, 2), r1 = 2, r2 = 4
# max(1+2, 4), r1 = 4, r2 = 4 SOLUTION = 4