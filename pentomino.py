# move this to puzzles eventually

from math import lcm

'''
for a in range(1, 10):
    for b in range(1, 10):
        print (a, b)
        for x in range (10):
            print(f"{a}  {b}+{a}*{x}  =  {a} {b+a*x}  ... {lcm(a,b+a*x)}")
'''

print("    ".join(map(str, range(20))))
print("-"*47*2)  # LINE!!!!!!

for a in range(1, 20):
    print(a, end = "|")
    for b in range(1, 20):
            print (f"{lcm(a,b+a) - lcm(a,b):>4}", end = " ") # :>2  pads 2
            if b == 19:
                  print()


# code Selene was writing
# return   (list(set   (i for i in l if not any(i%j==0 for j in l if i!=j))    ))
# (everything) in L that doesn't cause (condition)
# everything = i for i
# condition = ... l
# casted to set to remove duplicates & back to list to return


# from typing import list, tuple
# use force typing in functions with List[int] or Tuple[int, str] or Tuple[int, ...] (tuple of ints of unknown length) 