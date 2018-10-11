package scalajsreact.template.facades.firebase

import scalajsreact.template.facades.firebase.firebase.auth.UserCredential

import scala.scalajs.js
import scala.scalajs.js.annotation._
import scala.scalajs.js.|

@js.native
@JSImport("firebase", JSImport.Default)
object firebase extends js.Object {
  @js.native
  trait App extends js.Object {}

  def initializeApp(options: js.UndefOr[FirebaseConfig],
                    name: js.UndefOr[String] = js.undefined): App =
    js.native

  @JSName("auth")
  def authenticate(): FirebaseAuth = js.native

  @js.native
  trait User extends firebase.UserInfo {
    def delete(): js.Promise[Unit] = js.native

    def emailVerified: Boolean = js.native

    def getIdToken(forceRefresh: js.UndefOr[Boolean] = js.undefined): js.Promise[String] = js.native

    def getIdTokenResult(
        forceRefresh: js.UndefOr[Boolean] = js.undefined): js.Promise[auth.IdTokenResult] =
      js.native

    def isAnonymous: Boolean = js.native

    def linkAndRetrieveDataWithCredential(
        credential: auth.AuthCredential): js.Promise[UserCredential] = js.native

    def linkWithPopup(provider: auth.AuthProvider): js.Promise[UserCredential] = js.native

    def linkWithRedirect(provider: auth.AuthProvider): js.Promise[Unit] = js.native

    val providerData: js.Array[firebase.UserInfo] = js.native

    def refreshToken: String = js.native

    def reload(): js.Promise[Unit] = js.native

    def sendEmailVerification(
        actionCodeSettings: js.UndefOr[auth.ActionCodeSettings]): js.Promise[Unit] = js.native

    def unlink(providerId: String): js.Promise[js.Any] = js.native

    def updateEmail(newEmail: String): js.Promise[js.Any] = js.native

    def updatePassword(newPassword: String): js.Promise[js.Any] = js.native

    def updateProfile(profile: js.Any): js.Promise[js.Any] = js.native
  }

  @js.native
  trait UserInfo extends js.Object {
    var displayName: String | Null = js.native
    var email: String | Null       = js.native
    var photoURL: String | Null    = js.native
    var providerId: String         = js.native
    var uid: String                = js.native
  }

  @js.native
  object auth extends js.Object {
    @js.native
    trait AdditionalUserInfo extends js.Object

    @js.native
    trait ActionCodeSettings extends js.Object {
      val url: String                                         = js.native
      val iOS: js.UndefOr[js.Object { val bundleId: String }] = js.native
      val android: js.UndefOr[js.Object {
        val packageName: String
        val installApp: js.UndefOr[String]
        val minimumVersion: js.UndefOr[String]
      }]
      val handleCodeInApp: js.UndefOr[Boolean] = js.native
    }

    @js.native
    trait IdTokenResult extends js.Object {
      val authTime: String              = js.native
      val claims: js.Object             = js.native
      def expirationTime: String        = js.native
      val issuedAtTime: String          = js.native
      val signInProvider: String | Null = js.native
      val token: String                 = js.native
    }

    @js.native
    trait UserCredential extends js.Object {
      val user: User | Null                                         = js.native
      val credential: AuthCredential | Null                         = js.native
      val operationType: js.UndefOr[String | Null]                  = js.native
      val additionalUserInfo: js.UndefOr[AdditionalUserInfo | Null] = js.native
    }

    @js.native
    trait AuthCredential extends js.Object {
      var provider: String = js.native
    }

    @js.native
    trait AuthProvider extends js.Object {
      var providerId: String = js.native
    }

    @js.native
    object EmailAuthProvider extends js.Object {
      var PROVIDER_ID: String = js.native

      def credential(email: String, password: String): AuthCredential = js.native
    }

    @js.native
    trait Error extends js.Object {
      var code: String    = js.native
      var message: String = js.native
    }

    @js.native
    object FacebookAuthProvider extends js.Object {
      var PROVIDER_ID: String = js.native

      def credential(token: String): AuthCredential = js.native
    }

    @js.native
    object GithubAuthProvider extends js.Object {
      var PROVIDER_ID: String = js.native

      def credential(token: String): AuthCredential = js.native
    }

    @js.native
    object GoogleAuthProvider extends js.Object {
      var PROVIDER_ID: String = js.native

      def credential(idToken: String | Null = ???,
                     accessToken: String | Null = ???): AuthCredential =
        js.native
    }

    @js.native
    object TwitterAuthProvider extends js.Object {
      var PROVIDER_ID: String = js.native

      def credential(token: String, secret: String): AuthCredential = js.native
    }

  }
}

class FirebaseConfig(val apiKey: String,
                     val authDomain: String,
                     val databaseURL: String,
                     val projectId: String,
                     val storageBucket: String,
                     val messagingSenderId: String)
    extends js.Object

//@JSImport("firebase.auth.Auth", JSImport.Namespace)
//@js.native
trait FirebaseAuth extends js.Object
