#1)ejercicio 4
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