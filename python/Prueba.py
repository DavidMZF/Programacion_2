numeroPrueba = [2,46,23,9,13,55,4,10,3] #Valores de prueba en el arreglo
tamano = len(numeroPrueba) #Longitud del valor
valor = int(input('Ingresea el valor a encontrar: ')) #Lectura del valor a buscar
indice = -1
for i in range(tamano): #Inicio del bucle for
    if valor == numeroPrueba[i]:
        indice = i+1
        break #Salir del bucle
print('El elemento se encuentra en la posición: ')
print(indice) #Impresion del resultado