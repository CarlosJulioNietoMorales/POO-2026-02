#1)ejercicio 4
class edades:
 @staticmethod
 def calcular_edad_alber(juan):
  return (2 * juan) / 3

 @staticmethod 
 def calcular_edad_ana(juan):
  return (4 * juan) / 3

 @staticmethod
 def calcular_edad_mama(juan, alber, ana):
  return juan + alber + ana

#programa principal
juan = float(input("Ingrese la edad de Juan: "))
alber = edades.calcular_edad_alber(juan)
ana = edades.calcular_edad_ana(juan)
mama = edades.calcular_edad_mama(juan, alber, ana)

print(f"La edad de Alber es: {alber}")
print(f"La edad de Ana es: {ana}")
print(f"La edad de la mamá es: {mama}") 

