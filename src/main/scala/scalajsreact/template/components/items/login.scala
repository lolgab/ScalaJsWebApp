package scalajsreact.template.components.items

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
import dom.MouseEvent
import japgolly.scalajs.react.extra.{EventListener, OnUnmount}
import org.scalajs.dom.html.Div

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, ScalaJSDefined}
import js.DynamicImplicits._
import scala.scalajs.js.Dynamic


@js.native
@JSGlobal("firebase")
object firebase extends js.Object{


  def initializeApp(config: js.Object): Unit = js.native

  def database():  js.Any = js.native
}



sealed trait credentials
case class firebaseApiCredentials(typeCredits:String , project_id :String, private_key_id:String ,private_key:String,client_email:String,client_id:String,auth_uri:String,token_uri:String,auth_provider_x509_cert_url:String,client_x509_cert_url:String) extends credentials


class firebaseAppConfig(apiKey:String,authDomain:String, databaseURL:String) extends  js.Object


case class State( loggedIn: Boolean,
                  currentState: String,
                  someInitialValue: String)

object Login  {


  def initializeApp={
    /*

  var config = {
  apiKey: "apiKey",
  authDomain: "projectId.firebaseapp.com",
  databaseURL: "https://databaseName.firebaseio.com"
  };

  firebase.initializeApp(config);

  var rootRef = firebase.database().ref();
  */


    val apiKey= "AIzaSyCT7g1W-EmqDTv2N-s-em1QTWvpfZH0seI"
    val authDomain=  "api-project-1021787054473.firebaseapp.com"
    val databaseURL ="https://api-project-1021787054473.firebaseio.com"


    var config = new firebaseAppConfig(apiKey,authDomain,databaseURL)
    firebase.initializeApp(config)
    println(firebase)
    println(firebase.database())
  }




  val component = {
    ScalaComponent
      .builder[Unit]("Login/SignUp")
      .initialState(State(false, "not logged in", "firebase not initialized"))
      .renderBackend[Backend]
      .build
  }



  class Backend($: BackendScope[Unit, State]) {

    def logEvent(desc: String)       = {
      println(desc)
      $.modState(state => State(false, "not logged in", "firebase intializing trying"))
    }
    def logMouseEnter(e: ReactMouseEventFromTextArea) = {
      initializeApp
      logEvent(s"Mouse enter @ ${e.pageX},${e.pageY}")
    }
    val logWindowClick               = logEvent("Window clicked.")
    val logLocalClick                = logEvent("Component clicked.")


    def render(state: State) = {

       <.div(
         ^.border  := "solid 1px black",
         ^.width   := "90ex",
         ^.height  := "20em",
         ^.padding := "2px 6px",
         <.textarea (
           ^.onClick  ==> logMouseEnter
         )

       )
    }

  }



  def apply() = component().vdomElement



}