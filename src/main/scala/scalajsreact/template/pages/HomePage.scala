package scalajsreact.template.pages

import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import scalajsreact.template.components.Firebase.{FirebaseComponent, StyledFirebaseAuth}

// TODO page background to have image
// and boots trapo css wirth Material UI design for both browser and
// mobile
object HomePage {
  // This will choose between dev/prod depending on your scalac `-Xelide-below` setting
  val CssSettings = scalacss.devOrProdDefaults
  import CssSettings._

  object Style extends StyleSheet.Inline {
    import dsl._
    val content = style(textAlign.center, fontSize(30.px), minHeight(450.px), paddingTop(40.px))
  }

  val component =
    ScalaComponent.builder
      .static("HomePage")(
        <.div(Style.content,
              "React based app store ",
              <.p("convert this page to listing"),
              <.p("using Material UI and with bootstrap css"),
        FirebaseComponent.firebaseComponent
        ))
      .build

  def apply() = component()
}
