class Persona:
    def __init__(self, nombre: str, apellidos: str, numero_documento_identidad: str,
                anio_nacimiento: int, pais_nacimiento: str, genero: str):
        if genero not in ("H", "M"):
            raise ValueError("El género debe ser 'H' o 'M'.")
        self.nombre = nombre
        self.apellidos = apellidos
        self.numero_documento_identidad = numero_documento_identidad
        self.anio_nacimiento = anio_nacimiento
        self.pais_nacimiento = pais_nacimiento
        self.genero = genero

    def imprimir(self) :
        print(f"Nombre = {self.nombre}")
        print(f"Apellidos = {self.apellidos}")
        print(f"Número de documento de identidad = {self.numero_documento_identidad}")
        print(f"Año de nacimiento = {self.anio_nacimiento}")
        print(f"País de nacimiento = {self.pais_nacimiento}")
        print(f"Género = {self.genero}")


def main() :
    p1 = Persona("Pedro", "Pérez", "1053121010", 1998, "Colombia", "H")
    p2 = Persona("Luis", "León", "1053223344", 2001, "Colombia", "H")
    p1.imprimir()
    print()
    p2.imprimir()


if __name__ == "__main__":
    main()
