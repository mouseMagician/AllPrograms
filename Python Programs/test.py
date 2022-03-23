def spin_words(sentence):
    for word in sentence.split():
        if len(word) >= 5:
            words = sentence.split('')
            word = ''.join(reversed(words))
    return sentence

str = "Hello World Welcome"
print(spin_words(str))