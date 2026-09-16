class Potencias:

    def __init__(self, numero):
        self.numero = numero
        self.cuadrado = numero ** 2
        self.cubo = numero ** 3

    def mostrar_resultados(self):
        print(f"El número ingresado es: {self.numero}")
        print(f"Su cuadrado es: {self.cuadrado}")
        print(f"Su cubo es: {self.cubo}")


# Programa principal

numero = float(input("Ingrese un número: "))
p = Potencias(numero)
p.mostrar_resultados()