class Operaciones:
    @staticmethod
    def operacion1(suma, x):
        return suma + x
    @staticmethod
    def operacion2(x, y):
        return x + (y**2)

    @staticmethod
    def operacion3(suma, x, y):
        return suma + (x/y)
#programa principal
x = float(input("Ingresa el valor de x: "))
suma = float(input("Ingresa el valor inicial de suma: "))
suma = Operaciones.operacion1(suma, x)

y = float(input("Ingresa el valor de y: "))
x = Operaciones.operacion2(x, y)
suma = Operaciones.operacion3(suma, x, y)

print("El valor de la suma es:", suma)

