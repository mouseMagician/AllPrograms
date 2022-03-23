# This is an idea I just thought of and was curious if I could solve it. It has no practical purpose to be atm.

# I am writing a program that will take in a decimal and check whether it can be turned into a fraction.

from decimal import Decimal

menu = {
    1: 'Non-repeating decimal',
    2: 'Repeating decimal',
    3: 'Quit'}


def simplify(numerator, denominator):
    """This finds all the factors of the denominator. It then checks if these factors also fit into the numerator. The
    function will return the numerator and denominator divided by the largest shared factor, indicated by the last
    value in numerator_factors[]. If no factor is found, it will return the original values.
    """

    factors = []
    for i in range(1, denominator + 1):
        if denominator % i == 0:
            factors.append(i)
    numerator_factor = [x for x in factors if numerator % x == 0]
    if numerator_factor:
        return int(numerator / numerator_factor[-1]), int(denominator / numerator_factor[-1])
    else:
        return numerator, denominator


def print_menu():
    for key in menu.keys():
        print(f'[{key}] - {menu[key]}')


def nonrepeating_decimal():
    num = float(input("\nEnter a non-repeating decimal you wish to turn into a fraction: "))
    print(num)


def repeating_decimal():
    # I noticed this wont work if you have, say, 12.12356565656. All the decimals have to be repeating
    num = Decimal(input("\nEnter a repeating decimal you wish to turn into a fraction: "))
    num_decimals = len(str(num % 1)[2:])
    numerator = int(num * 10 ** num_decimals - int(num))
    denominator = 10 ** num_decimals - 1
    simplified_fraction = simplify(numerator, denominator)
    print(f"The simplified fraction is: {simplified_fraction[0]}/{simplified_fraction[1]}\n")


if __name__ == '__main__':
    print("Welcome to the decimal to fraction simplificationator. This program can convert decimals to a simplified"
          "fraction. Note, this program can handle repeating decimals up to 5 decimal points.")
    while True:
        print_menu()
        try:
            option = int(input("Enter your choice: "))
        except ValueError:
            print("\nIncorrect input, please enter a valid number")
            continue
        if option == 1:
            nonrepeating_decimal()
        elif option == 2:
            repeating_decimal()
        elif option == 3:
            break
        else:
            print("\nWrong input, returning to the menu")
