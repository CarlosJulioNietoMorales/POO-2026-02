#1)ejercicio 4
#A la mamá de Juan le preguntan su edad, y contesta: tengo 3 hijos, pregúntele a Juan su edad. Alberto tiene 2/3 de la edad de Juan,
#Ana tiene 4/3 de la edad de Juan y mi edad es la suma de las tres. Hacer un algoritmo que muestre la edad de los cuatro.
class edades:
    def __init__(self, edad_juan):
        self.juan = edad_juan
        self.alberto = (2*self.juan)/3
        self.ana = (4*self.juan)/3
        self.mama = self.juan + self.alberto + self.ana

    def mostrar_edades(self):
        print(f"La edad de Juan es: {self.juan}")
        print(f"La edad de Alberto es: {self.alberto}")
        print(f"La edad de Ana es: {self.ana}")
        print(f"La edad de la mamá es: {self.mama}")

#programa principal
edad_juan = int(input("Ingrese la edad de Juan: "))

familia = edades(edad_juan)
familia.mostrar_edades()  