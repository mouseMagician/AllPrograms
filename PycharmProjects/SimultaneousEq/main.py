import numpy as np

def solveEq():
    # This function solves a system of linear equations, with the formatting being input as a matrix
    # Array format: [V, L, C]

    A = np.array([[1092.05, -47, -155], [0, 0.26, 0.485], [1, 1, 1]]) #
    B = np.array([56000, 560, 2000])
    c = np.linalg.solve(A, B)
    print(c) # Prints the solves variables, again in the format [V, L, C]
    print(sum(c)) # Check for the total flowrate


# 56000 = 1092.05V - 47L - 155C
# 560 = 0.485C + 0.26 L
# 2000 = V + L + C

if __name__ == '__main__':
    solveEq()




