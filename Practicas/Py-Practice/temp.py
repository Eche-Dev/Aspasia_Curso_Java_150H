# TEMPERATURA DE LA SEMANA  

Lunes = float(input("Ingrese la temperatura del lunes: "))
Martes = float(input("Ingrese la temperatura del martes: "))
miercoles = float(input("Ingrese la temperatura del miércoles: "))
Jueves = float(input("Ingrese la temperatura del jueves: "))
Viernes = float(input("Ingrese la temperatura del viernes: "))
sabado = float(input("Ingrese la temperatura del sábado: "))
domingo = float(input("Ingrese la temperatura del domingo: "))

tempAlt = max(Lunes, Martes, miercoles, Jueves, Viernes, sabado, domingo)
tempBaj = min(Lunes, Martes, miercoles, Jueves, Viernes, sabado, domingo)
tempProm = (Lunes + Martes + miercoles + Jueves + Viernes + sabado + domingo) / 7


print("La temperatura del lunes es:", Lunes)
print("La temperatura del martes es:", Martes)
print("La temperatura del miércoles es:", miercoles)
print("La temperatura del jueves es:", Jueves)
print("La temperatura del viernes es:", Viernes)
print("La temperatura del sábado es:", sabado)
print("La temperatura del domingo es:", domingo)

print("La temperatura más alta de la semana es:", tempAlt)
print("La temperatura más baja de la semana es:", tempBaj)
tempProm = round(tempProm, 2)
print("La temperatura promedio de la semana es:", tempProm) 