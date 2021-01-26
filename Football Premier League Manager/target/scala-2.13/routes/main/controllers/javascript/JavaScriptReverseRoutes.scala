// @GENERATOR:play-routes-compiler
// @SOURCE:D:/IIT/Level 5/OOP/Coursework/Final Submission/w1761340/w1761340/PlayFinal/playfinal/conf/routes
// @DATE:Tue Jan 05 19:58:19 IST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getRandomMatchesF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getRandomMatchesF",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/randomMatches"})
        }
      """
    )
  
    // @LINE:10
    def getPlayedMatchesF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getPlayedMatchesF",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/matchesPlayed"})
        }
      """
    )
  
    // @LINE:9
    def getClubsF: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getClubsF",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/footballClubs"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def assetOrDefault: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.assetOrDefault",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}
