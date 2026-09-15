class Potencias:
    @staticmethod
    def calcular_cuadrado(numero):
        return numero ** 2  

    @staticmethod
    def calcular_cubo(numero):
        return numero ** 3  

#programa principal
numero = float(input("Ingrese un número: "))
cuadrado = Potencias.calcular_cuadrado(numero)
cubo = Potencias.calcular_cubo(numero)


print(f"El número ingresado es: {numero}")
print(f"El cuadrado de {numero} es: {cuadrado}")
print(f"El cubo de {numero} es: {cubo}")    