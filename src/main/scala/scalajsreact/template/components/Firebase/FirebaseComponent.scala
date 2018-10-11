package scalajsreact.template.components.Firebase

import japgolly.scalajs.react.{Callback, CallbackTo}
import scalajsreact.template.facades.firebase.FirebaseUIConfig.SignInFlow
import scalajsreact.template.facades.firebase._

import scala.scalajs.js
import scala.scalajs.js.JSON

object FirebaseComponent {
  val firebaseConfig =
    new FirebaseConfig(
      apiKey = "AIzaSyB3n4J6Pw509z-5Frzv_tNaAx9awsILnxA",
      authDomain = "gestione-azienda-agricola.firebaseapp.com",
      databaseURL = "https://gestione-azienda-agricola.firebaseio.com",
      projectId = "gestione-azienda-agricola",
      storageBucket = "gestione-azienda-agricola.appspot.com",
      messagingSenderId = "711562531423"
//      apiKey = "AIzaSyCT7g1W-EmqDTv2N-s-em1QTWvpfZH0seI",
//      authDomain = "api-project-1021787054473.firebaseapp.com",
//      databaseURL = "https://api-project-1021787054473.firebaseio.com",
//      projectId = "api-project-1021787054473",
//      storageBucket = "api-project-1021787054473.appspot.com",
//      messagingSenderId = "1021787054473"
    )

  firebase.initializeApp(firebaseConfig)

  val uiConfig = new FirebaseUIConfig(
    signInSuccessUrl = "/signedIn", //TODO
    signInFlow = SignInFlow.popup,
    tosUrl = "",
    privacyPolicyUrl = "/privacyPolicy", //TODO
    signInOptions = js.Array(firebase.auth.GoogleAuthProvider.PROVIDER_ID,
                             firebase.auth.FacebookAuthProvider.PROVIDER_ID,
                             firebase.auth.EmailAuthProvider.PROVIDER_ID)
  )

  val firebaseComponent = StyledFirebaseAuth(uiConfig, CallbackTo(firebase.authenticate()))
}
