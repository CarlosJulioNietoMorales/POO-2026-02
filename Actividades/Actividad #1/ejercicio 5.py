class Operaciones:
    def __init__(self):
        self.suma = 0
        self.x = 20
        self.y = 0

    def operacion1(self):
        self.suma = self.x + self.suma

    def operacion2(self):
        self.y = 40
        self.x = self.x +(self.y**2)

    def operacion3(self):
        self.suma = self.suma + (self.x/self.y)

    def mostrar_resultados(self):
        print(f"El valor de la suma es: {self.suma}")

#programa principal
proceso = Operaciones()
proceso.operacion1()
proceso.operacion2()
proceso.operacion3()
proceso.mostrar_resultados()


