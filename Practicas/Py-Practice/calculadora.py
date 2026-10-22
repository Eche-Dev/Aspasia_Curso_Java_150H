nombre_del_producto = str(input("Ingrese el nombre del producto: "))
precio_del_producto = float(input("Ingrese el precio del producto: "))      

cantidad_del_producto = float(input("Ingrese la cantidad del producto: "))

costo_total = precio_del_producto * cantidad_del_producto
print(f"El costo total del producto {nombre_del_producto} es: {costo_total:.2f}")

if costo_total >= 100:
    descuento10 = costo_total * 0.10
    print(f"Se aplicará un descuento del 10% ya que el costo total es mayor a 100.")
else:
    descuento10 = 0
    print(f"Descuento aplicado: no cumple el minimo de 100 euros")

print(f"El descuento del 10% es: {descuento10:.2f}")

precio_final = costo_total - descuento10
print(f"El precio final del producto {nombre_del_producto} es: {precio_final:.2f}")