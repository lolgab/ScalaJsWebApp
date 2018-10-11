package scalajsreact.template

import org.scalajs.dom
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter

object ReactApp {
  val CssSettings = scalacss.devOrProdDefaults

  def main(args: Array[String]): Unit = {
    AppCSS.load
    dom.console.info("Router logging is enabled. Enjoy!")
    AppRouter.router().renderIntoDOM(dom.document.body)
  }
}
