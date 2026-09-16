class Nomina:
    def __init__(self, horas_trabajadas, valor_hora, porcentaje_retencion):
        self.horas_trabajadas = horas_trabajadas
        self.valor_hora = valor_hora
        self.porcentaje_retencion = porcentaje_retencion
        self.salario_bruto = self.horas_trabajadas * self.valor_hora
        self.retefuente = self.salario_bruto * (self.porcentaje_retencion / 100)
        self.salario_neto = self.salario_bruto - self.retefuente

    def mostrar_nomina(self):
        print(f"Salario Bruto: {self.salario_bruto}")
        print(f"Retención en la fuente: {self.retefuente}")
        print(f"Salario Neto: {self.salario_neto}")


# Programa principal
empleado = Nomina(horas_trabajadas=48, valor_hora=5000, porcentaje_retencion=12.5)
empleado.mostrar_nomina()