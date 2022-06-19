fun main() {
    // write your code here
    println("Enter the number of rows:")
    val rowNumber = readln().toInt()
    println("Enter the number of seats in each row:")
    val rowSeatNumber = readln().toInt()

    val totalSeat = rowSeatNumber * rowNumber
    val totalIncome: Int
    var backRow: Int
    var frontRow: Int

    if (totalSeat < 60) {
        totalIncome = totalSeat * 10

        println("Total income:")
        println("$$totalIncome")
    } else {
        frontRow = rowNumber / 2
        backRow = rowNumber / 2 + rowNumber % 2
        frontRow *= rowSeatNumber
        backRow *= rowSeatNumber
        totalIncome = (frontRow * 10) + (backRow * 8)

        println("Total income:")
        println("$$totalIncome")
    }
}