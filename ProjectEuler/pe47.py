# https://www.ivl-projecteuler.com/overview-of-problems/5-difficulty/problem-47

# Function to find distinct prime factor
# of a number N 



def distinctPrimeFactors(N):
    C= N
    arr = []

    if (N < 2):
        print(-1)
        return []
    if N == 2:
      print(2)
      return []
    visited = {}
    
    i = 2
    while(i * i <= N):
        while(N % i == 0):
            if(i not in visited):
                # print(i , end = " ")
                arr.append(i)
                visited[i] = 1
                
            N //= i
        i+=1

    if(N > 2):
        arr.append(N)

    if len(arr) != 0:
        return arr
    
    return []

# code & stuff
# N = 645
# distinctPrimeFactors(N)

cnt = 0
arr = []

for x in range(10**6):
    if len(distinctPrimeFactors(x)) == 4:
        cnt = cnt+1
        arr.append(x)
    else:
        cnt = 0
        arr.clear()
    if len(arr) == 4:
        print(arr)
        exit()

