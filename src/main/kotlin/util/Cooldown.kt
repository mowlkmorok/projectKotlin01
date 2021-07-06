package util

class Cooldown {
    fun cooldown(){
            Thread.sleep(400)
            print("Loading .")
            Thread.sleep(400)
            print(".")
            Thread.sleep(400)
            print(".")
            Thread.sleep(400)
            print(".")
            Thread.sleep(400)
            print("...")
            Thread.sleep(1900)
            print("...... 100%\n------------\n\n")
            Thread.sleep(1500)
    }
}