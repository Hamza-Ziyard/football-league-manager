// @GENERATOR:play-routes-compiler
// @SOURCE:D:/IIT/Level 5/OOP/Coursework/Final Submission/w1761340/w1761340/PlayFinal/playfinal/conf/routes
// @DATE:Tue Jan 05 19:58:19 IST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:9
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getRandomMatchesF(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/randomMatches")
    }
  
    // @LINE:10
    def getPlayedMatchesF(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/matchesPlayed")
    }
  
    // @LINE:9
    def getClubsF(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/footballClubs")
    }
  
  }

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def assetOrDefault(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }


}
