
import util.Cooldown
import views.Login
import kotlin.system.exitProcess


fun main() {
    val loading = Cooldown()
    val x = Login()
    println("""
         ___________
        |...........|
        |..Hello!...|
        |I'm Android|
        |...........|
        |-----------|
        ┈┈┈╲====╱
        ┈┈┈╱   ▔▔╲
        ┈┈┃┈▇┈┈▇┈┃
        ╭╮┣━━━━━━┫╭╮
        ┃┃┃┈┈┈┈┈┈┃┃┃
        ╰╯┃┈┈┈┈┈┈┃╰╯
        ┈┈╰┓┏━━┓┏╯
        ┈┈┈╰╯┈┈╰╯
        1- Login
        2- Sign-Up
        3- Exit
    """.trimIndent())
    print(">> ")

    //Select Options
    when(readLine()!!){
        "1" -> {
            // Call the login
            x.doLogin()}

            // Call the Sign-up
        "2" -> {x.doSignUp() }

            // Exit the program
        "3" -> {exitProcess(0)}
        else -> main()
    }

}

