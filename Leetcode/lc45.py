import typing # didn't do this right

# greedy algo: https://www.youtube.com/watch?v=dJ7sWiOoK7g

# int arr, start @ pos 0, need to reach end in as few jumps as possible, each index is our current max jump

# choices @ each step: range from 1-jump max
# prob stays ahead? -> always choose the best solution??? can do this with DP too

# ok so Jump I works with greedy AND Jump II has a greedy solution :)

# from a whole portion of the arr, what is the entire portion we can reach?
    # redundant to jump to something we could have reached from the previous
# levels that we can reach from previous levels, tell us min steps required

# basically BFS in an array, when we have dest, done :3

class Solution: # self, list[int] nums
    def jump(self, nums) -> int:
        jumps = 0
        l, r = 0, 0
        # window from an index

        while r < len(nums) - 1: # end
            farthest = 0
            for i in range (l, r+1): # check our whole window
                jump_value = i + nums[i]
                farthest = max(farthest, i + jump_value) # max between existing farthest or testing farthest from current i + JUMP VALUE
            l = r+1 # can obr reach +1 from this window into the next
            r = farthest# place we can jump the furthest too from everything in our current window

        return jumps
