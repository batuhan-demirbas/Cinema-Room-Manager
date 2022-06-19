fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rowNumber = readln().toInt()
    println("Enter the number of seats in each row:")
    val rowSeatNumber = readln().toInt()

    val cinemaLayout = MutableList(rowNumber) { MutableList(rowSeatNumber) { 'S' } }

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

        cinemaLayout[bookRow - 1][bookRowSeat - 1] = 'B'

        val totalSeat = rowSeatNumber * rowNumber
        val ticketPrice: Int

        val frontRow: Int

        if (totalSeat < 60) {
            ticketPrice = 10

        } else {
            frontRow = rowNumber / 2
            ticketPrice = if (bookRow <= frontRow) {
                10
            } else {
                8
            }
        }
        println("\nTicket price: $$ticketPrice \n")
    }

    var repeat = true
    fun menu() {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("0. Exit")
        when (readln().toInt()) {
            0 -> repeat = false
            1 -> showCinemaLayout()
            2 -> buyTicket()
        }
    }

    while (repeat) {
        menu()
    }
}