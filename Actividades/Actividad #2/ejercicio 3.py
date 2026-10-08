from enum import Enum


class TipoCombustible(Enum):
    GASOLINA = "GASOLINA"
    BIOETANOL = "BIOETANOL"
    DIESEL = "DIESEL"
    BIODIESEL = "BIODIESEL"
    GAS_NATURAL = "GAS_NATURAL"


class TipoAutomovil(Enum):
    CIUDAD = "CIUDAD"
    SUBCOMPACTO = "SUBCOMPACTO"
    COMPACTO = "COMPACTO"
    FAMILIAR = "FAMILIAR"
    EJECUTIVO = "EJECUTIVO"
    SUV = "SUV"


class TipoColor(Enum):
    BLANCO = "BLANCO"
    NEGRO = "NEGRO"
    ROJO = "ROJO"
    NARANJA = "NARANJA"
    AMARILLO = "AMARILLO"
    VERDE = "VERDE"
    AZUL = "AZUL"
    VIOLETA = "VIOLETA"


class Automovil:
    def __init__(self, marca: str, modelo: int, motor: int,
                 tipo_combustible: TipoCombustible, tipo_automovil: TipoAutomovil,
                 numero_puertas: int, cantidad_asientos: int,
                 velocidad_maxima: int, color: TipoColor):
        self._marca = marca
        self._modelo = modelo
        self._motor = motor
        self._tipo_combustible = tipo_combustible
        self._tipo_automovil = tipo_automovil
        self._numero_puertas = numero_puertas
        self._cantidad_asientos = cantidad_asientos
        self._velocidad_maxima = velocidad_maxima
        self._color = color
        self._velocidad_actual = 0

    @property
    def marca(self) :
        return self._marca

    @marca.setter
    def marca(self, marca: str) :
        self._marca = marca

    @property
    def modelo(self) :
        return self._modelo

    @modelo.setter
    def modelo(self, modelo: int) :
        self._modelo = modelo

    @property
    def motor(self) :
        return self._motor

    @motor.setter
    def motor(self, motor: int) :
        self._motor = motor

    @property
    def tipo_combustible(self):
        return self._tipo_combustible

    @tipo_combustible.setter
    def tipo_combustible(self, tipo_combustible: TipoCombustible) :
        self._tipo_combustible = tipo_combustible

    @property
    def tipo_automovil(self):
        return self._tipo_automovil

    @tipo_automovil.setter
    def tipo_automovil(self, tipo_automovil: TipoAutomovil) :
        self._tipo_automovil = tipo_automovil

    @property
    def numero_puertas(self) :
        return self._numero_puertas

    @numero_puertas.setter
    def numero_puertas(self, numero_puertas: int) :
        self._numero_puertas = numero_puertas

    @property
    def cantidad_asientos(self) :
        return self._cantidad_asientos

    @cantidad_asientos.setter
    def cantidad_asientos(self, cantidad_asientos: int) :
        self._cantidad_asientos = cantidad_asientos

    @property
    def velocidad_maxima(self) :
        return self._velocidad_maxima

    @velocidad_maxima.setter
    def velocidad_maxima(self, velocidad_maxima: int) :
        self._velocidad_maxima = velocidad_maxima

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, color: TipoColor) :
        self._color = color

    @property
    def velocidad_actual(self) :
        return self._velocidad_actual

    @velocidad_actual.setter
    def velocidad_actual(self, velocidad_actual: int) :
        self._velocidad_actual = velocidad_actual


    def acelerar(self, incremento_velocidad: int) :
        nueva = self._velocidad_actual + incremento_velocidad
        if nueva > self._velocidad_maxima:
            print("No se puede superar la velocidad máxima.")
            self._velocidad_actual = self._velocidad_maxima
        else:
            self._velocidad_actual = nueva

    def desacelerar(self, decremento_velocidad: int) :
        nueva = self._velocidad_actual - decremento_velocidad
        if nueva < 0:
            print("No se puede decrementar a una velocidad negativa.")
        else:
            self._velocidad_actual = nueva

    def frenar(self) :
        self._velocidad_actual = 0

    def calcular_tiempo_llegada(self, distancia: float) :
        """Tiempo en horas para recorrer 'distancia' (km) a la velocidad actual."""
        if self._velocidad_actual <= 0:
            raise ValueError("El automóvil está detenido; no se puede calcular el tiempo.")
        return distancia / self._velocidad_actual

    def imprimir(self) :
        print(f"Marca = {self._marca}")
        print(f"Modelo = {self._modelo}")
        print(f"Motor = {self._motor}")
        print(f"Tipo de combustible = {self._tipo_combustible.name}")
        print(f"Tipo de automóvil = {self._tipo_automovil.name}")
        print(f"Número de puertas = {self._numero_puertas}")
        print(f"Cantidad de asientos = {self._cantidad_asientos}")
        print(f"Velocidad máxima = {self._velocidad_maxima}")
        print(f"Color = {self._color.name}")
        print(f"Velocidad actual = {self._velocidad_actual}")


def main() :
    auto1 = Automovil("Ford", 2018, 3, TipoCombustible.DIESEL,
                      TipoAutomovil.EJECUTIVO, 5, 6, 250, TipoColor.NEGRO)
    auto1.imprimir()
    auto1.acelerar(100)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.acelerar(20)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.desacelerar(50)
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    print(f"Tiempo de llegada para 140 km = {auto1.calcular_tiempo_llegada(140)} horas")
    auto1.frenar()
    print(f"Velocidad actual = {auto1.velocidad_actual}")
    auto1.desacelerar(10)


if __name__ == "__main__":
    main()
