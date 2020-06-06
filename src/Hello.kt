import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
fun main() {
    println("Enter name")
    val stuname = readLine()
    println("Enter date in DD format")
    val birda = readLine()
    val birdate= birda?.toInt()
    when(birdate){
        !in 1..31 -> println("Enter valid date")
    }
    println("Enter month in MM format")
    val birmo = readLine()
    val birmon= birmo?.toInt()
    when(birmon){
        !in 1..12-> println("Enter valid month")
    }
    println("Enter year in YYYY format")
    val birye = readLine()
    val biryear= birye?.toInt()
    when(biryear){
        !in 0..2020 -> println("Enter valid year")
    }
    println("The birth date of $stuname is $birye-$birmo-$birda")
    val current1 = LocalDateTime.now()
    val formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formatted1 = current1.format(formatter1)
    println("Current Date is: $formatted1")
    val year = formatted1.toString()
    val finalyear=year.take(4)
    val finalyear1=finalyear.toInt()
    val current2 = LocalDateTime.now()
    val formatter2 = DateTimeFormatter.ofPattern("MM-yyyy-dd")
    val formatted2 = current2.format(formatter2)
    val month = formatted2.toString()
    val finalmonth=month.take(2)
    val finalmonth1=finalmonth.toInt()
    val current3 = LocalDateTime.now()
    val formatter3 = DateTimeFormatter.ofPattern("dd-yyyy-MM")
    val formatted3 = current3.format(formatter3)
    val day = formatted3.toString()
    val finalday=day.take(2)
    val finalday1=finalday.toInt()
    var ageday=0
    var agemon=0
    var ageyear=0
    if (birdate != null) {
        if (birdate>finalday1){
            ageday= 31- birdate.minus(finalday1)
        } else{
            ageday= finalday1.minus(birdate)
        }
    }
    if (birdate != null) {
        if (birmon != null) {
            if(biryear==finalyear1 && birmon>finalmonth1){
                println("Invalid Input")
            }
            else if(birdate==finalday1 && finalmonth1==birmon)
            {
                agemon=finalmonth1.minus(birmon)
            }
            else if(biryear==finalyear1 && birmon<=finalmonth1){
                agemon= finalmonth1-birmon
            }
            else if (birmon>finalmonth1 && birdate>finalday1){
                agemon= birmon.minus(finalmonth1)-1
            }
            else if(finalmonth1>birmon){
                agemon=finalmonth1.minus(birmon)
            }
            else if(finalmonth1==birmon){
                agemon=birmon+finalmonth1-1
            }
            else{
                agemon=birmon.minus(finalmonth1)
            }
        }
    }
    if (birmon != null) {
        if (biryear != null) {
            if (birdate != null) {
                if (birmon == finalmonth1 && biryear == finalyear1 && birdate > finalday1) {
                    println("Date of Birth needs to be earlier than the age at date")
                } else if (biryear == finalyear1) {
                    ageyear = finalyear1.minus(biryear)
                }
                else if(birmon==finalmonth1 && biryear<finalyear1){
                    ageyear=finalyear1.minus(biryear)
                }
                else if (birmon > finalmonth1 || birmon == finalmonth1) {
                    ageyear = finalyear1.minus(biryear) - 1
                } else {
                    ageyear = finalyear1.minus(biryear)
                }
            }
        }
    }
    println("Age is $ageyear years $agemon months $ageday days")
}







