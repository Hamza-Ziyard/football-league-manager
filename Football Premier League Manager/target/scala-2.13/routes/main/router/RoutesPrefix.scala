// @GENERATOR:play-routes-compiler
// @SOURCE:D:/IIT/Level 5/OOP/Coursework/Final Submission/w1761340/w1761340/PlayFinal/playfinal/conf/routes
// @DATE:Tue Jan 05 19:58:19 IST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
