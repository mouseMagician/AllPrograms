import itertools


def main():
    english_words = get_cleaned_wordlist()
    menu(english_words)


def menu(word_list):
    repeating_letters = 1  # Characters are allowed to repeat
    all_letters = 1  # Not all the letters have the be used
    welcome_text()
    user_input = get_user_input()
    repeating_letters = input("By default, characters are allowed to repeat. To turn off this function, type \"0\": ")
    all_letters = input("By default, words don't have to contain every single letter. "
                        "To turn off this function, type \"0\": ")
    permutations = get_permutations(user_input)
    words = get_words(permutations, word_list)
    print(words)


def get_permutations(letter_string):
    word_list = []
    string_permutations = itertools.permutations(letter_string)
    string_permutations = list(string_permutations)
    string_permutations = [''.join(permutation) for permutation in string_permutations]
    return string_permutations


def get_words(permutations, word_list):
    return [word for word in permutations if word in word_list]


def welcome_text():
    print("Welcome,")
    print("This program allows you to input a string of letters from the english alphabet")
    print("The program will find all possible english letters that can be made up of these characters\n")


def get_user_input():
    raw_input = input("Please enter the string of letters to use: ")
    cleaned_input = raw_input.lower().strip()
    return cleaned_input


def get_cleaned_wordlist():
    file = open('words.txt', 'r')
    lines = file.readlines()
    file.close()
    cleaned_lines = [(i.lower()).rstrip('\n') for i in lines]
    return cleaned_lines


if __name__ == '__main__':
    main()
