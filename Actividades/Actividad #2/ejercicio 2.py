from enum import Enum

class TipoPlaneta(Enum):
    GASEOSO = "GASEOSO"
    TERRESTRE = "TERRESTRE"
    ENANO = "ENANO"


class Planeta:
    # 1 UA = 149 597 870 km. Se considera exterior un planeta más allá de 3,4 UA.
    UNIDAD_ASTRONOMICA_KM = 149_597_870
    LIMITE_EXTERIOR_UA = 3.4

    def __init__(self, nombre: str, cantidad_satelites: int, masa: float,
                 volumen: float, diametro: int, distancia_sol: int,
                 tipo: TipoPlaneta, es_observable: bool,
                 periodo_orbital: float, periodo_rotacion: float):
        self.nombre = nombre
        self.cantidad_satelites = cantidad_satelites
        self.masa = masa                        # kg
        self.volumen = volumen                  # km^3
        self.diametro = diametro                # km
        self.distancia_sol = distancia_sol      # km
        self.tipo = tipo
        self.es_observable = es_observable
        self.periodo_orbital = periodo_orbital      # años
        self.periodo_rotacion = periodo_rotacion    # días

    def imprimir(self) :
        print(f"Nombre del planeta = {self.nombre}")
        print(f"Cantidad de satélites = {self.cantidad_satelites}")
        print(f"Masa del planeta = {self.masa}")
        print(f"Volumen del planeta = {self.volumen}")
        print(f"Diámetro del planeta = {self.diametro}")
        print(f"Distancia al sol = {self.distancia_sol}")
        print(f"Tipo de planeta = {self.tipo.name}")
        print(f"Es observable = {str(self.es_observable).lower()}")
        print(f"Periodo orbital (años) = {self.periodo_orbital}")
        print(f"Periodo de rotación (días) = {self.periodo_rotacion}")
        print(f"Densidad del planeta = {self.calcular_densidad()}")
        print(f"Es planeta exterior = {str(self.es_planeta_exterior()).lower()}")

    def calcular_densidad(self) :
        return self.masa / self.volumen

    def es_planeta_exterior(self) :
        limite = self.LIMITE_EXTERIOR_UA * self.UNIDAD_ASTRONOMICA_KM
        return self.distancia_sol > limite


def main() :
    tierra = Planeta("Tierra", 1, 5.9736e24, 1.08321e12, 12742, 150000000,
                     TipoPlaneta.TERRESTRE, True, 1.0, 1.0)
    jupiter = Planeta("Júpiter", 79, 1.899e27, 1.4313e15, 139820, 750000000,
                      TipoPlaneta.GASEOSO, True, 11.86, 0.41)
    tierra.imprimir()
    print()
    jupiter.imprimir()


if __name__ == "__main__":
    main()
