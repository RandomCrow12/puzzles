run = True
while (run):
    firstline = input()
    if (firstline == "0 0"):
        run = False
        break
    line = firstline.split()
    H = int(line[0])
    T = int(line[1])
    
    c = 0
    
    possible = True
    
    while (H != 0 or T != 0):
        # 0 and 4 guarentees a win in two moves
        # get heads to an even number, cut to 0
        # get tails to a multiple of 4
        # cut tails
        # cut heads
        if (H%2 == 0 and H > 0): # 
            H-=2
            c += 1
        elif (H%2 == 1 and T > 1):
            T-=2
            H+=1
            c += 1
        elif (T%4 != 0 and T > 0):
            T+=1
            c += 1
        elif (T%4 == 0):
            while (T>0):
                T-=2
                H+=1
                c += 1
            while (H>0):
                H-=2
                c += 1
        else:
            possible = False # ???
            break
    
    if (possible):
        print(c)
    else:
        print(-1)
