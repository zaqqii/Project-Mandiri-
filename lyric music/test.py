pesos = int(input("What do you have left in pesos?"))
soles = int(input("What do you have left in soles?"))
reais = int(input("What do you have left in reais?"))

dolar_a_pesos = pesos * 3857.46
dolar_a_soles = soles * 3.75
dolar_a_reais = reais * 5.20

total = dolar_a_pesos + dolar_a_soles + dolar_a_reais
print(total)