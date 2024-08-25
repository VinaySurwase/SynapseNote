package com.example.projectcanyouhackit

interface Destination {
    val route:String
}
object Home:Destination{
    override val route = "Home"
}
object Login:Destination{
    override val route= "Login"
}
object Register:Destination{
    override val route= "Register"

}
object Grides:Destination{
    override val route="Grides"
}
object Voice:Destination{
    override val route="Voice"
}
