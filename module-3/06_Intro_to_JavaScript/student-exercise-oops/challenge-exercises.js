/*
1. **iqTest** Bob is preparing to pass an IQ test. The most frequent task in this test 
    is to find out which one of the given numbers differs from the others. Bob observed
    that one number usually differs from the others in evenness. Help Bob — to check his 
    answers, he needs a program that among the given numbers finds one that is different in 
    evenness, and return the position of this number. _Keep in mind that your task is to help 
    Bob solve a real IQ test, which means indexes of the elements start from 1 (not 0)_

		iqTest("2 4 7 8 10") → 3 //third number is odd, while the rest are even
		iqTest("1 2 1 1") → 2 // second number is even, while the rest are odd
		iqTest("") → 0 // there are no numbers in the given set
        iqTest("2 2 4 6") → 0 // all numbers are even, therefore there is no position of an odd number
*/
    function iqTest(x) {
        if(x.length == 0) {
            return 0;
        }
        let string = x.split(" ");
        let evens = [];
        let odds = [];
        for(i = 0; i < string.length; i++) {
            if(string[i]%2 == 0) {
                evens.push(i+1);
            } else if(string[i]%2 == 1) {
                odds.push(i+1);
            }
        } 
        if(evens.length == 1) {
            return evens[0];
        } else if(odds.length == 1) {
            return odds[0];
        } else {
            return 0;
        }
    }

/*
2. **titleCase** Write a function that will convert a string into title case, given an optional 
    list of exceptions (minor words). The list of minor words will be given as a string with each 
    word separated by a space. Your function should ignore the case of the minor words string -- 
    it should behave in the same way even if the case of the minor word string is changed.


* First argument (required): the original string to be converted.
* Second argument (optional): space-delimited list of minor words that must always be lowercase
except for the first word in the string. The JavaScript tests will pass undefined when this 
argument is unused.

		titleCase('a clash of KINGS', 'a an the of') // should return: 'A Clash of Kings'
		titleCase('THE WIND IN THE WILLOWS', 'The In') // should return: 'The Wind in the Willows'
        titleCase('the quick brown fox') // should return: 'The Quick Brown Fox'
*/
        function titleCase(quote, minor) {
            let words = quote.toLowerCase().split(" ");
            if(minor == null) {
                minor = " ";
            }
            let minors = minor.toLowerCase().split(" ");
            
            let sentence = "";
            for(i = 0; i < words.length; i++) {
                let title = true;
                let word = words[i];
                for(j = 0; j < minors.length; j++) {
                    if(i > 0 && word == minors[j]) {
                        title = false;
                        break;
                    }    
                }
                if(title == true) {
                    let firstLetter = word.substring(0, 1).toUpperCase();
                    word = firstLetter + word.substring(1, word.length) + " ";
                    sentence += word;
                } else {
                    sentence += word + " ";
                }       
            }
            return sentence.trim();
        }    