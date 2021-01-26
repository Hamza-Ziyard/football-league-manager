// @GENERATOR:play-routes-compiler
// @SOURCE:D:/IIT/Level 5/OOP/Coursework/Final Submission/w1761340/w1761340/PlayFinal/playfinal/conf/routes
// @DATE:Tue Jan 05 19:58:19 IST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FrontendController_1: controllers.FrontendController,
  // @LINE:9
  HomeController_0: controllers.HomeController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FrontendController_1: controllers.FrontendController,
    // @LINE:9
    HomeController_0: controllers.HomeController
  ) = this(errorHandler, FrontendController_1, HomeController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FrontendController_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FrontendController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/footballClubs""", """controllers.HomeController.getClubsF"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/matchesPlayed""", """controllers.HomeController.getPlayedMatchesF"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/randomMatches""", """controllers.HomeController.getRandomMatchesF"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """file<.+>""", """controllers.FrontendController.assetOrDefault(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FrontendController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FrontendController_index0_invoker = createInvoker(
    FrontendController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Serve index page from public directory""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_getClubsF1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/footballClubs")))
  )
  private[this] lazy val controllers_HomeController_getClubsF1_invoker = createInvoker(
    HomeController_0.getClubsF,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getClubsF",
      Nil,
      "GET",
      this.prefix + """api/footballClubs""",
      """ An example route (Prefix all API routes with apiPrefix defined in application.conf)""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_getPlayedMatchesF2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/matchesPlayed")))
  )
  private[this] lazy val controllers_HomeController_getPlayedMatchesF2_invoker = createInvoker(
    HomeController_0.getPlayedMatchesF,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getPlayedMatchesF",
      Nil,
      "GET",
      this.prefix + """api/matchesPlayed""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_getRandomMatchesF3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/randomMatches")))
  )
  private[this] lazy val controllers_HomeController_getRandomMatchesF3_invoker = createInvoker(
    HomeController_0.getRandomMatchesF,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getRandomMatchesF",
      Nil,
      "GET",
      this.prefix + """api/randomMatches""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_FrontendController_assetOrDefault4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_FrontendController_assetOrDefault4_invoker = createInvoker(
    FrontendController_1.assetOrDefault(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "assetOrDefault",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """file<.+>""",
      """ Serve static assets under public directory""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FrontendController_index0_route(params@_) =>
      call { 
        controllers_FrontendController_index0_invoker.call(FrontendController_1.index())
      }
  
    // @LINE:9
    case controllers_HomeController_getClubsF1_route(params@_) =>
      call { 
        controllers_HomeController_getClubsF1_invoker.call(HomeController_0.getClubsF)
      }
  
    // @LINE:10
    case controllers_HomeController_getPlayedMatchesF2_route(params@_) =>
      call { 
        controllers_HomeController_getPlayedMatchesF2_invoker.call(HomeController_0.getPlayedMatchesF)
      }
  
    // @LINE:11
    case controllers_HomeController_getRandomMatchesF3_route(params@_) =>
      call { 
        controllers_HomeController_getRandomMatchesF3_invoker.call(HomeController_0.getRandomMatchesF)
      }
  
    // @LINE:14
    case controllers_FrontendController_assetOrDefault4_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_FrontendController_assetOrDefault4_invoker.call(FrontendController_1.assetOrDefault(file))
      }
  }
}
