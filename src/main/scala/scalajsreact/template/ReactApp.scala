package scalajsreact.template

import org.scalajs.dom
import scalajsreact.template.css.AppCSS
import scalajsreact.template.routes.AppRouter

object ReactApp {
  def main(args: Array[String]): Unit = {
    AppCSS.load
    AppRouter.router().renderIntoDOM(dom.document.body)
  }
}
