import math


class Circulo:
    def __init__(self, radio: int):
        self.radio = radio

    def calcular_area(self) :
        return math.pi * self.radio ** 2

    def calcular_perimetro(self) :
        return 2 * math.pi * self.radio


class Cuadrado:
    def __init__(self, lado: int):
        self.lado = lado

    def calcular_area(self) :
        return float(self.lado ** 2)

    def calcular_perimetro(self) :
        return float(4 * self.lado)


class Rectangulo:
    def __init__(self, base: int, altura: int):
        self.base = base
        self.altura = altura

    def calcular_area(self) :
        return float(self.base * self.altura)

    def calcular_perimetro(self) :
        return float(2 * (self.base + self.altura))


class TrianguloRectangulo:
    def __init__(self, base: int, altura: int):
        self.base = base
        self.altura = altura

    def calcular_area(self) :
        return self.base * self.altura / 2

    def calcular_hipotenusa(self) :
        return math.hypot(self.base, self.altura)

    def calcular_perimetro(self) :
        return self.base + self.altura + self.calcular_hipotenusa()

    def determinar_tipo_triangulo(self) :

        h = self.calcular_hipotenusa()
        lados = [self.base, self.altura, h]
        iguales = len({round(l, 9) for l in lados})
        if iguales == 1:
            print("Es un triángulo equilátero")
        elif iguales == 2:
            print("Es un triángulo isósceles")
        else:
            print("Es un triángulo escaleno")


class Rombo:
    def __init__(self, diagonal_mayor: int, diagonal_menor: int):
        self.diagonal_mayor = diagonal_mayor
        self.diagonal_menor = diagonal_menor

    def calcular_lado(self) :
        return math.hypot(self.diagonal_mayor / 2, self.diagonal_menor / 2)

    def calcular_area(self) :
        return self.diagonal_mayor * self.diagonal_menor / 2

    def calcular_perimetro(self) :
        return 4 * self.calcular_lado()


class Trapecio:
    def __init__(self, base_mayor: int, base_menor: int, altura: int,
                 lado_izquierdo: int, lado_derecho: int):
        self.base_mayor = base_mayor
        self.base_menor = base_menor
        self.altura = altura
        self.lado_izquierdo = lado_izquierdo
        self.lado_derecho = lado_derecho

    def calcular_area(self) :
        return (self.base_mayor + self.base_menor) * self.altura / 2

    def calcular_perimetro(self) :
        return float(self.base_mayor + self.base_menor
                     + self.lado_izquierdo + self.lado_derecho)


class PruebaFiguras:
    @staticmethod
    def main() :
        figura1 = Circulo(2)
        figura2 = Rectangulo(1, 2)
        figura3 = Cuadrado(3)
        figura4 = TrianguloRectangulo(3, 5)
        figura5 = Rombo(8, 6)
        figura6 = Trapecio(10, 6, 4, 5, 5)

        print(f"El área del círculo es = {figura1.calcular_area()}")
        print(f"El perímetro del círculo es = {figura1.calcular_perimetro()}")
        print()
        print(f"El área del rectángulo es = {figura2.calcular_area()}")
        print(f"El perímetro del rectángulo es = {figura2.calcular_perimetro()}")
        print()
        print(f"El área del cuadrado es = {figura3.calcular_area()}")
        print(f"El perímetro del cuadrado es = {figura3.calcular_perimetro()}")
        print()
        print(f"El área del triángulo es = {figura4.calcular_area()}")
        print(f"El perímetro del triángulo es = {figura4.calcular_perimetro()}")
        figura4.determinar_tipo_triangulo()
        print()
        print(f"El área del rombo es = {figura5.calcular_area()}")
        print(f"El perímetro del rombo es = {figura5.calcular_perimetro()}")
        print()
        print(f"El área del trapecio es = {figura6.calcular_area()}")
        print(f"El perímetro del trapecio es = {figura6.calcular_perimetro()}")


if __name__ == "__main__":
    PruebaFiguras.main()
