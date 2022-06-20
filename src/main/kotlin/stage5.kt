fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rowNumber = readln().toInt()
    println("Enter the number of seats in each row:")
    val rowSeatNumber = readln().toInt()

    val cinemaLayout = MutableList(rowNumber) { MutableList(rowSeatNumber) { 'S' } }
    val totalSeat = rowSeatNumber * rowNumber
    var currentIncome = 0
    var totalIncome = 0
    var purchasedTicket = 0

    fun showCinemaLayout() {
        println("\nCinema:")
        print("  ")
        for (l in 1..rowSeatNumber) {
            print("$l ")
        }
        print("\n")
        for (i in 0 until rowNumber) {
            print("${i + 1} ")
            for (k in 0 until rowSeatNumber) {
                print("${cinemaLayout[i][k]} ")
            }
            print("\n")
        }
    }
    fun buyTicket() {
        println("\nEnter a row number:")
        val bookRow = readln().toInt()
        println("Enter a seat number in that row:")
        val bookRowSeat = readln().toInt()

        if (cinemaLayout[bookRow - 1][bookRowSeat - 1] == 'B') {
            println("That ticket has already been purchased!")
            buyTicket()
        } else {
            cinemaLayout[bookRow - 1][bookRowSeat - 1] = 'B'
            ++purchasedTicket

            val ticketPrice: Int
            val frontRow: Int

            if (totalSeat < 60) {
                ticketPrice = 10
                currentIncome += ticketPrice

            } else {
                frontRow = rowNumber / 2
                if (bookRow <= frontRow) {
                    ticketPrice = 10
                    currentIncome += ticketPrice
                } else {
                    ticketPrice = 8
                    currentIncome += ticketPrice
                }
            }
            println("\nTicket price: $$ticketPrice \n")
        }
    }
    fun showStatistics() {
        if (totalSeat < 60) {
            totalIncome = 10 * totalSeat

        } else {
            totalIncome = ((rowNumber / 2) * rowSeatNumber * 10) + (totalSeat - ((rowNumber / 2) * rowSeatNumber)) * 8
        }

        val percentage = ((purchasedTicket.toDouble() / totalSeat.toDouble()) * 100)

        println("Number of purchased tickets: $purchasedTicket")
        println("Percentage: ${String.format("%.2f", percentage)}%")
        println("Current income: \$$currentIncome")
        println("Total income: \$$totalIncome")
    }
    fun menuText() {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")

    }

    while (true) {
        menuText()
        when (readln().toInt()) {
            0 -> break
            1 -> showCinemaLayout()
            2 -> {
                try {
                    buyTicket()
                } catch (e: IndexOutOfBoundsException) {
                    println("Wrong input!")
                }
            }
            3 -> showStatistics()
        }
    }
}