import sys, os, string
from spellchecker import SpellChecker

spell = SpellChecker(distance=2)

spell.word_frequency.load_text_file(sys.argv[1])

#open file that will be spell checked
with open(sys.argv[2],'r') as f:
    #read in line by line
    for line in f:
        #read in word by word
        for word in line.split():
            #remove any punctuation from word
            word = word.translate(None, string.punctuation)
            #check if word is in dictionary we provided
            if word in spell:
                #if spelled correctly, state so
                print("'{}' is spelled correctly!".format(word))
            else:
                #if spelled incorrectly, state so and suggest best guess to correct word
                cor = spell.correction(word)
                print("The best spelling for '{}' is '{}'".format(word, cor))

