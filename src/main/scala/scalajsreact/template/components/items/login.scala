package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

import scala.scalajs.js
import scala.scalajs.js.annotation._

/*
@js.native
@JSGlobal("firebase")
object firebase extends js.Object{
  def initializeApp(config: js.Object): Unit = js.native
  def database():  js.Any = js.native
}

sealed trait credentials
case class firebaseApiCredentials(typeCredits:String , project_id :String, private_key_id:String ,private_key:String,client_email:String,client_id:String,auth_uri:String,token_uri:String,auth_provider_x509_cert_url:String,client_x509_cert_url:String) extends credentials

@js.native
class firebaseAppConfig(apiKey:String,authDomain:String, databaseURL:String) extends  js.Object

 */

case class State(loggedIn: Boolean, currentState: String, someInitialValue: String)

@js.native
@JSGlobalScope
object Globals extends js.Object {
  var fbjsApp: js.Any = js.native
}

object Login {

  def initializeApp(): Unit = {}

  val component = {
    ScalaComponent
      .builder[Unit]("Login/SignUp")
      .initialState(State(false, "not logged in", "firebase not initialized"))
      .renderBackend[Backend]
      .build
  }

  class Backend($ : BackendScope[Unit, State]) {

    def logEvent(desc: String) = {
      println(desc)
      $.modState(state => State(false, "not logged in", "firebase intializing trying"))
    }
    def logMouseEnter(e: ReactMouseEventFromTextArea) = {
      // initializeApp()

      val apiKey            = "AIzaSyCT7g1W-EmqDTv2N-s-em1QTWvpfZH0seI"
      val authDomain        = "api-project-1021787054473.firebaseapp.com"
      val databaseURL       = "https://api-project-1021787054473.firebaseio.com"
      val projectId         = "api-project-1021787054473"
      val storageBucket     = "api-project-1021787054473.appspot.com"
      val messagingSenderId = "1021787054473"
      var config =
        new FirebaseConfig(apiKey, authDomain, databaseURL, storageBucket, messagingSenderId)
      var fjs = FirebaseFacade.firebase.Firebase
      if (js.isUndefined(js.Dynamic.global.fbjsApp)) {
        js.Dynamic.global.fbjsApp = fjs.initializeApp(config)
        println(fjs.SDK_VERSION)
        println("reading firebase data")
      } else {
        println("no need to again intialize firebase app")
      }

      var db          = fjs.database()
      var datSnapshot = db.ref("user")
      def successCallback(datSnapshot: DataSnapshot, b: js.|[String, Null]): js.Any = {

        println(datSnapshot.`val`())
        def printData(ds: DataSnapshot) = {
          println(ds.child("comments").`val`())
          true
        }
        val jsPrintData: js.Function1[DataSnapshot, Boolean] = printData
        datSnapshot.forEach(jsPrintData)
        println("success callback")
        println(b)
      }
      val jsSuccessFun: js.Function2[DataSnapshot, js.|[String, Null], Any] = successCallback
      val p                                                                 = db.ref("user").once("value", jsSuccessFun, null, null)

      println(fjs.database().refFromURL(databaseURL))

      logEvent(s"Mouse enter @ ${e.pageX},${e.pageY}")
    }
    val logWindowClick = logEvent("Window clicked.")
    val logLocalClick  = logEvent("Component clicked.")

    def render(state: State) = {

      <.div(
        ^.border := "solid 1px black",
        ^.width := "90ex",
        ^.height := "20em",
        ^.padding := "2px 6px",
        <.textarea(
          ^.onClick ==> logMouseEnter
        )
      )

    }

  }

  def apply() = component().vdomElement

}
