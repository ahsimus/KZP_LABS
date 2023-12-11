
from equations import Equations
from wfile import WFile
def main():
    file_name = input("Enter the name of the file to save the result: ")
    try:
        x = float(input("Enter X: "))
        equations=Equations()
        result =equations.calculate(x)
        wfile=WFile(file_name)
        wfile.writeResTxt(str(result))
        wfile.writeResBin(str(result))
        read_result = wfile.readResBin()
        read_result1 = wfile.readResTxt()
        print("Res from file:", read_result)
        print("Res from file:", read_result1)
    except ValueError:
        print("Error: The entered X must be a number")
    except IOError:
        print("Error: Unable to write/read from file")
if __name__ == "__main__":
    main()
