# 5) ejercicio 17
#Dado el radio de un círculo. Haga un algoritmo que obtenga el área del círculo y la longitud de la circunferencia.

import math


class Circulo:
    
    def __init__(self, radio):
        self.radio = radio
        self.area = math.pi * (radio ** 2)
        self.longitud = 2 * math.pi * radio

    def mostrar_resultados(self):
        print(f"El radio ingresado es: {self.radio}")
        print(f"El área del círculo es: {self.area}")
        print(f"La longitud de la circunferencia es: {self.longitud}")


# Programa principal

radio = float(input("Ingrese el radio del círculo: "))
c = Circulo(radio)
c.mostrar_resultados()