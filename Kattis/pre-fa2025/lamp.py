innn = input().split()
h = int(innn[0])
P = int(innn[1])

Ipower = 60
Lpower = 11
Ilife = 1000
Llife = 8000
Iprice = 5
Lprice = 60

for hour in range (0, 8000, 24):
    KI = (Ipower * (hour*(h/24)) * P)/100000
    KL = (Lpower * (hour*(h/24)) * P)/100000

    numExtra = int((hour*(h/24)) / 1000) 

    print(numExtra)

    IP = (Iprice * numExtra) + Iprice + KI
    LP = Lprice + KL

    if IP > LP: 
        print(int(hour/24))
        break
