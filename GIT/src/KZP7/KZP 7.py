import sys

nRows = int(input("Enter matrix value. Value should be even: "))
filler1 = input("Enter the first filler symbol: ")
filler2 = input("Enter the second filler symbol: ")

if nRows % 2 == 1:
    print("Odd matrix value!")
    sys.exit()

arr = [[' ' for _ in range(nRows)] for _ in range(nRows)]

if len(filler1) != 1 or len(filler2) != 1:
    print("Each filler symbol should be a single character!")
    sys.exit()

with open("MyFile.txt", "w") as fout:
    for i in range(nRows):
        for j in range(nRows):
            if i % 2 == 0:
                arr[i][j] = filler1
                print(filler1, end='')
                fout.write(filler1)
            else:
                arr[i][j] = filler2
                print(filler2, end='')
                fout.write(filler2)
        print()
        fout.write('\n')
