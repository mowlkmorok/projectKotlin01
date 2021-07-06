package opt

import interfaces.OptionFun
import main
import util.Cooldown
import util.UtilEnum
import java.io.File
import java.io.FileWriter
import java.lang.Exception
import kotlin.system.exitProcess

class Options: OptionFun {

    private val loading = Cooldown()
    private val user1: String = ""
    private val pass1: String = ""
    private var fileName = "./src/main/kotlin/datatxt/hashes.txt"
    private var hashID: String = ""

    override fun chooseOptions() {
        println("""
                    1- Back
                    2- Exit
                """.trimIndent())
        print(">>")

        // When conditions
        when (readLine()!!) {
            "1" -> {
                Thread.sleep(1500)
                main()
            }           // Return for main function
            "2" -> {
                exitProcess(0)
            } // Program exit
            else -> {
                println("Invalid Option")

            }
        }
    }

    override fun loginOption() {

        println("""
         _____________________
        | 00000000000000000000|
        | 000---L.O.G.I.N- 000|
        | 00000000000000000000|
        |---------------------|
        ┈┈┈╲====╱
        ┈┈┈╱   ▔▔╲
        ┈┈┃┈▇┈┈▇┈┃
        ╭╮┣━━━━━━┫╭╮
        ┃┃┃┈┈┈┈┈┈┃┃┃
        ╰╯┃┈┈┈┈┈┈┃╰╯
        ┈┈╰┓┏━━┓┏╯
        ┈┈┈╰╯┈┈╰╯
        """.trimIndent())

        print("User: ")
        val username = readLine()!!                 //Variable user
        print("Pass: ")
        val password = readLine()!!                //Variable pass


        // To make a hashcode
        val doHASH = username + password
        val vHASH = doHASH.hashCode().toString()
        File(fileName).forEachLine() {
            loading.cooldown()
            if (it != vHASH) {
                println("""
                     _____________________
                    |LOGIN ERROR!.........|
                    |Credentials incorrect|
                    |...or not found......|
                    |...your credentials..|
                    |Sign-Up or try again!|
                    |---------------------|
                    ┈┈┈╲====╱
                    ┈┈┈╱╭  ▔▔╲
                    ┈┈┃┈▇┈┈▇┈┃
                    ╭╮┣━━︵━━━┫╭╮
                    ┃┃┃┈┈┈┈┈┈┃┃┃
                    ╰╯┃┈┈┈┈┈┈┃╰╯
                    ┈┈╰┓┏━━┓┏╯
                    ┈┈┈╰╯┈┈╰╯
                """.trimIndent())
                Thread.sleep(1500)

                chooseOptions()

                Thread.sleep(1500)

                main()
                return@forEachLine
            } else {
                println("""
         _____________________
        |    YEEEAHHH BRO!!!  |
        | S.U.C.C.E.S.S !     |
        |       L.O.G.I.N !   |
        |---------------------|
        ┈┈┈╲====╱
        ┈┈┈╱   ▔▔╲
        ┈┈┃┈▇┈┈▇┈┃
        ╭╮┣━━︶━━━┫╭╮
        ┃┃┃┈┈┈┈┈┈┃┃┃
        ╰╯┃┈┈┈┈┈┈┃╰╯
        ┈┈╰┓┏━━┓┏╯
        ┈┈┈╰╯┈┈╰╯
                """.trimIndent())
                chooseOptions()
            }
        }

    }



    override fun signUp(){

        val readLOGIN: (String) -> String = { readLine()!! }

        // Set up your user
        print(UtilEnum.USER.string)
        val user1: String = readLOGIN(user1)

        // Set up your pass
        print(UtilEnum.PASSWORD.string)
        val pass1: String = readLOGIN(pass1)

        // Making the hash
        val doHash = user1+pass1
        // Hash create
        hashID = doHash.hashCode().toString()
        println(doHash)

        print(UtilEnum.CREATE_LOGIN.string)

        val youSure = readLine()!!


        // Conditions for create hash
        when {
            youSure.lowercase(Locale.getDefault()) == "n" || youSure.lowercase(Locale.getDefault()) == "no" -> {
                println(UtilEnum.CANCELED_PROCESS.string)

                // Time sleep
                Thread.sleep(1500)

                // Calling the options
                chooseOptions()
            }
            youSure.lowercase(Locale.getDefault()) == "y" || youSure.lowercase(Locale.getDefault()) == "yes" -> {

                //Loading .....
                loading.cooldown()

                // Calling save login function
                saveLogin()

                // Calling the options
                chooseOptions()

            }
            youSure.lowercase(Locale.getDefault()) == "" -> {
                loading.cooldown()
                saveLogin()
                // Choose your options
                chooseOptions()}
            else -> {
                println(UtilEnum.INVALID_OPTION.string)
                Thread.sleep(1500)
                //Return from option
            }
        }



    }

    override fun saveLogin(){

        try{

            //Save HASH
            val x1 = FileWriter(fileName)
            File(fileName).writeText(hashID)

            //Close file
            x1.close()

        }catch (ex: Exception){
            // Error treatments
            ex.printStackTrace()

        }

    }

    override fun congratulations() {

        println("""
 ___________________
|===================|
|==CONGRATULATIONS==|
|==LOGIN=CREATED!===|
|-------------------|
┈┈┈╲====╱
┈┈┈╱   ▔▔╲
┈┈┃┈▇┈┈▇┈┃
╭╮┣━━━━━━┫╭╮
┃┃┃┈┈┈┈┈┈┃┃┃
╰╯┃┈┈┈┈┈┈┃╰╯
┈┈╰┓┏━━┓┏╯
┈┈┈╰╯┈┈╰╯
        """.trimIndent())
                Thread.sleep(1900)

        // Choose your Options
        chooseOptions()

    }



}
