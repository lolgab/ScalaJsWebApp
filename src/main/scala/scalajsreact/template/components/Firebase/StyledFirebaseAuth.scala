package scalajsreact.template.components.Firebase

import japgolly.scalajs.react._
import scalajsreact.template.facades.firebase.firebaseui.auth.AuthUI
import scalajsreact.template.facades.firebase.{FirebaseAuth, FirebaseUIConfig}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

object StyledFirebaseAuth {
  @JSImport("react-firebaseui/StyledFirebaseAuth", JSImport.Default)
  @js.native
  private object RawStyledFirebaseAuth extends js.Object

  type UICallback = js.Function1[AuthUI, Unit]

  @js.native
  trait Props extends js.Object {
    var uiConfig: FirebaseUIConfig = js.native
    var firebaseAuth: FirebaseAuth = js.native
    var uiCallback: UICallback     = js.native
  }

  def props(uiConfig: FirebaseUIConfig,
            firebaseAuth: CallbackTo[FirebaseAuth],
            uiCallback: AuthUI => Callback = _ => Callback.empty): Props = {
    val p = (new js.Object).asInstanceOf[Props]
    p.uiConfig = uiConfig
    p.firebaseAuth = firebaseAuth.runNow()
    p.uiCallback = (ui: AuthUI) => uiCallback(ui).runNow()
    p
  }

  val component = JsComponent[Props, Children.None, Null](RawStyledFirebaseAuth)

  def apply(uiConfig: FirebaseUIConfig,
            auth: CallbackTo[FirebaseAuth],
            uiCallback: AuthUI => Callback = _ => Callback.empty) =
    component(props(uiConfig, auth, uiCallback))
}
