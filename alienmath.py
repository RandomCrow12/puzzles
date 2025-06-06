base = int(input())
symbols = input().split()
num = input()
toBeMult = []

while (num != ""):
    for x in range (len(num)+1):
        splitNum = num [0:x]
        for y in range (base):
            if (splitNum == symbols[y]):
                num = num[x:]
                toBeMult.append(y)
                
actualNum = 0
for h in range (len(toBeMult)):
    actualNum = actualNum + (toBeMult[h] * pow(base, len(toBeMult)-(h+1)))

print(actualNum)