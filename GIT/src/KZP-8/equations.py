import math

class Equations:
    def calculate(self,x):
        rad = x * math.pi / 180.0
        try:
        #.y=cos(x)/tg(2x)
            y = math.cos(x)/math.tan(2*x)
            if rad == math.pi or rad == (math.pi * 2):
                raise Exception
        except Exception as e:
            print("Exeption ",str(e))
            return 0
        return y

