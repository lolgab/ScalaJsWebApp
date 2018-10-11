package scalajsreact.template.routes

import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.html_<^._
import scalajsreact.template.components.{Footer, TopNav}
import scalajsreact.template.models.Menu
import scalajsreact.template.pages.HomePage

object AppRouter {
  sealed trait AppPage

  case object Home extends AppPage
  case class Items(p: Item) extends AppPage

  val config: RouterConfig[AppPage] = RouterConfigDsl[AppPage].buildConfig { dsl =>
    import dsl._
    val itemRoutes: Rule =
      Item.routes.prefixPath_/("#items").pmap[AppPage](Items) {
        case Items(p) => p
      }
    (trimSlashes
      | staticRoute(root, Home) ~> render(HomePage())
      | itemRoutes)
      .notFound(redirectToPage(Home)(Redirect.Replace))
      .renderWith(layout)
  }

  val mainMenu = Vector(
    Menu("StockNap", Home),
    Menu("Login", Items(Item.Info))
  )

  def layout(c: RouterCtl[AppPage], r: Resolution[AppPage]) =
    <.div(
      TopNav(TopNav.Props(mainMenu, r.page, c)),
      r.render(),
      Footer()
    )

  val baseUrl: BaseUrl = BaseUrl.fromWindowOrigin / "stocknap/"

  val router = Router(baseUrl, config)
}
