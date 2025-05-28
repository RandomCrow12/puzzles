tc = int(input())

for i in range(tc):
    stack = []
    innn = input()
    over = False
    for c in innn:
        if c == "$":
            stack.append("$")
        elif c == "|":
            stack.append("|")
        elif c == "*":
            stack.append("*")
        elif c == "t":
            if len(stack) == 0:
                over = True
            if (not over):
                thi = stack.pop()
                if thi != "|": 
                    over = True
        elif c == "j":
            if len(stack) == 0:
                over = True
            if (not over):
                thi = stack.pop()
                if thi != "*": 
                    over = True
        elif c == "b":
            if len(stack) == 0:
                over = True
            if (not over):
                thi = stack.pop()
                if thi != "$":
                    over = True
    if len(stack) != 0:
        print("NO")
    elif over == True:
        print("NO")
    else:
        print("YES")

