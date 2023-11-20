//1.Write a Kotlin program that takes takes an integer from the command line and  displays all the divisors of that integer

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Enter an integer")
        return
    }

    val number = args[0].toInt()

    println("Divisors of $number are:")
    for (i in 1..number) {
        if (number % i == 0) {
            println(i)
        }
    }
}

//2.A Perfect number is a number equal to the sum of its proper divisors (the number itself is excluded). Write a Kotlin program that displays all perfect numbers less than 1000000

fun main() {
    for (number in 2 until 1000000) {
        if (isPerfectNumber(number)) {
            println(number)
        }
    }
}

fun isPerfectNumber(number: Int): Boolean {
    var sum = 1
    for (i in 2..(number / 2)) {
        if (number % i == 0) {
            sum += i
        }
    }
    return sum == number
}

//3.Write a Kotlin program that takes an integer from the command line and displays all prime numbers less than or equal to that number

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Enter an integer")
        return
    }

    val limit = args[0].toInt()

    println("Prime numbers up to $limit are:")
    for (number in 2..limit) {
        if (isPrime(number)) {
            println(number)
        }
    }
}

fun isPrime(number: Int): Boolean {
    if (number < 2) {
        return false
    }
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

//4.Write a Kotlin Program that takes positive integers from the command line and displays the smallest and the biggest of the numbers entered

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("Enter an integer")
        return
    }

    val numbers = args.map { it.toInt() }
    val smallest = numbers.minOrNull()
    val biggest = numbers.maxOrNull()

    println("Smallest number: $smallest")
    println("Biggest number: $biggest")
}

//5.Write a Kotlin Program that takes an integer from the command line  and displays the number in words. For example, if the number is 123, the program should display: one hundred twenty three . Assume your program can handle six digit integers or less.

fun main(args: Array<String>) {
    if (args.size != 1) {
        println("Please provide exactly one integer as a command-line argument.")
        return
    }

    val number = args[0].toInt()

    println(numberToWords(number))
}

fun numberToWords(number: Int): String {
    val units = arrayOf("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val teens = arrayOf("", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen")
    val tens = arrayOf("", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety")

    return when {
        number < 10 -> units[number]
        number < 20 -> teens[number - 10]
        number < 100 -> "${tens[number / 10]} ${units[number % 10]}"
        number < 1000 -> "${units[number / 100]} hundred ${numberToWords(number % 100)}"
        else -> "Number out of range"
    }
}
