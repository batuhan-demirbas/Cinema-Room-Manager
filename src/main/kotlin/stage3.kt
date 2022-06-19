fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rowNumber = readln().toInt()
    println("Enter the number of seats in each row:")
    val rowSeatNumber = readln().toInt()

    val cinemaLayout = MutableList(rowNumber) { MutableList(rowSeatNumber) { 'S' } }
    println("\nCinema:")
    print("  ")
    for (l in 1..rowSeatNumber) {
        print("$l ")
    }
    print("\n")
    for (i in 0..rowNumber - 1) {
        print("${i + 1} ")
        for (k in 0..rowSeatNumber - 1){
            print("${cinemaLayout[i][k]} ")
        }
        print("\n")
    }

    println("\nEnter a row number:")
    val bookRow = readln().toInt()
    println("Enter a seat number in that row:")
    val bookRowSeat = readln().toInt()

    cinemaLayout[bookRow - 1][bookRowSeat - 1] = 'B'

    val totalSeat = rowSeatNumber * rowNumber
    val ticketPrice: Int
    var backRow: Int
    var frontRow: Int

    if (totalSeat < 60) {
        ticketPrice = 10

    } else {
        frontRow = rowNumber / 2
        backRow = rowNumber - frontRow
        if (bookRow <= frontRow) {
            ticketPrice = 10
        } else {
            ticketPrice = 8
        }
    }
    println("\nTicket price: $$ticketPrice \n")
    println("Cinema:")
    print("  ")
    for (l in 1..rowSeatNumber) {
        print("$l ")
    }
    print("\n")
    for (i in 0..rowNumber - 1) {
        print("${i + 1} ")
        for (k in 0..rowSeatNumber - 1){
            print("${cinemaLayout[i][k]} ")
        }
        print("\n")
    }
}