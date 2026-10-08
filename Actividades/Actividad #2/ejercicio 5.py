from enum import Enum


class TipoCuenta(Enum):
    AHORROS = "AHORROS"
    CORRIENTE = "CORRIENTE"


class CuentaBancaria:
    def __init__(self, nombres_titular: str, apellidos_titular: str,
                 numero_cuenta: int, tipo_cuenta: TipoCuenta,
                 interes_mensual: float = 0.0):
        self.nombres_titular = nombres_titular
        self.apellidos_titular = apellidos_titular
        self.numero_cuenta = numero_cuenta
        self.tipo_cuenta = tipo_cuenta
        self.saldo = 0.0
        self.interes_mensual = interes_mensual  # porcentaje, por ejemplo 1.5 = 1,5 %

    def imprimir(self) :
        print(f"Nombres del titular = {self.nombres_titular}")
        print(f"Apellidos del titular = {self.apellidos_titular}")
        print(f"Número de cuenta = {self.numero_cuenta}")
        print(f"Tipo de cuenta = {self.tipo_cuenta.name}")
        print(f"Saldo = {self.saldo}")
        print(f"Interés mensual = {self.interes_mensual} %")

    def consultar_saldo(self) :
        print(f"El saldo actual de la cuenta {self.numero_cuenta} es ${self.saldo}")

    def consignar(self, valor: int) :
        if valor <= 0:
            print("El valor a consignar debe ser mayor que cero.")
            return False
        self.saldo += valor
        print(f"Se ha consignado ${valor} en la cuenta. El nuevo saldo es ${self.saldo}")
        return True

    def retirar(self, valor: int) :
        if valor <= 0:
            print("El valor a retirar debe ser mayor que cero.")
            return False
        if valor > self.saldo:
            print("Saldo insuficiente para realizar el retiro.")
            return False
        self.saldo -= valor
        print(f"Se ha retirado ${valor} en la cuenta. El nuevo saldo es ${self.saldo}")
        return True

    def comparar_cuentas(self, cuenta: "CuentaBancaria") :
      
        if self.saldo > cuenta.saldo:
            print(f"La cuenta {self.numero_cuenta} tiene mayor saldo que la cuenta {cuenta.numero_cuenta}.")
        elif self.saldo < cuenta.saldo:
            print(f"La cuenta {cuenta.numero_cuenta} tiene mayor saldo que la cuenta {self.numero_cuenta}.")
        else:
            print("Ambas cuentas tienen el mismo saldo.")

    def transferencia(self, cuenta: "CuentaBancaria", valor: int) :

        if valor <= 0 or valor > self.saldo:
            print("No se pudo realizar la transferencia.")
            return False
        self.saldo -= valor
        cuenta.saldo += valor
        print(f"Se han transferido ${valor} de la cuenta {self.numero_cuenta} "
              f"a la cuenta {cuenta.numero_cuenta}.")
        return True

    def calcular_nuevo_saldo(self) :

        self.saldo += self.saldo * self.interes_mensual / 100
        print(f"Se aplicó un interés del {self.interes_mensual} %. El nuevo saldo es ${self.saldo}")
        return self.saldo


def main() :
    cuenta = CuentaBancaria("Pedro", "Pérez", 123456789, TipoCuenta.AHORROS, 1.5)
    cuenta.imprimir()
    cuenta.consignar(200000)
    cuenta.consignar(300000)
    cuenta.retirar(400000)
    cuenta.calcular_nuevo_saldo()

    print()
    otra = CuentaBancaria("Luis", "León", 987654321, TipoCuenta.CORRIENTE)
    otra.consignar(50000)
    cuenta.comparar_cuentas(otra)
    cuenta.transferencia(otra, 60000)
    cuenta.consultar_saldo()
    otra.consultar_saldo()


if __name__ == "__main__":
    main()
