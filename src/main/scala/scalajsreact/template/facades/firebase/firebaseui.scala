package scalajsreact.template.facades.firebase

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("firebaseui", JSImport.Namespace)
object firebaseui extends js.Object {
  @js.native
  object auth extends js.Object {
    @js.native
    trait AuthUI extends js.Object {}

    @js.native
    trait AuthUIError extends js.Object {
      val code: String = js.native
      val credential: js.UndefOr[firebase.auth.AuthCredential] = js.native
    }

  }
}

trait Callbacks extends js.Object {
  val signInSuccessWithAuthResult: js.UndefOr[js.Function2[firebase.auth.UserCredential, js.UndefOr[String], Boolean]]
  val signInSuccess: js.UndefOr[js.Function3[firebase.User, js.UndefOr[firebase.auth.UserCredential], js.UndefOr[String], Boolean]]
  val signInFailure: js.UndefOr[js.Function1[firebaseui.auth.AuthUIError, js.Promise[Unit]]]
  val uiShown: js.UndefOr[js.Function0[Unit]]
}


class FirebaseUIConfig(
    val signInOptions: js.Array[String],
    val tosUrl: String,
    val privacyPolicyUrl: js.Function0[Unit] | String,
    val signInSuccessUrl: js.UndefOr[String] = js.undefined,
    val signInFlow: js.UndefOr[String] = js.undefined,
    val callbacks: js.UndefOr[Callbacks] = js.undefined
) extends js.Object

object FirebaseUIConfig {
  object SignInFlow {
    val redirect = "redirect"
    val popup    = "popup"
  }
}
