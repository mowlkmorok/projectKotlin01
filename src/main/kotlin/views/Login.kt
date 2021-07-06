package views

import datatxt.DBClass
import interfaces.Auth
import opt.Options


class Login() : Auth {
    // Var token
    private var loginToken: String = "0"

    //Getters and Setters
    set(value){
        println(value)
        field = value

    }

    // Username variable
    private var username1: String = ""


    // Password variable
    private var password1: String = ""


    //Objects

 //   private val fileName = "../datatxt/test.txt"

    // Object create
    private val login1 = Options()
    private val signup1 = Options()



    override fun doLogin() {
        // Call Login function
        login1.loginOption()

        DBClass(user = username1, pass = password1, hash1 = loginToken)


    }

    override fun doSignUp() {

        println("""
         ___________
        |..=========|
         ==SIGN-UP==|
        |========   |
        |-----------|
        ┈┈┈╲====╱
        ┈┈┈╱   ▔▔╲
        ┈┈┃┈▇┈┈▇┈┃
        ╭╮┣━━━━━━┫╭╮
        ┃┃┃┈┈┈┈┈┈┃┃┃
        ╰╯┃┈┈┈┈┈┈┃╰╯
        ┈┈╰┓┏━━┓┏╯
        ┈┈┈╰╯┈┈╰╯
        """.trimIndent())

        //Call sign-up
        signup1.signUp()

    }


}
