enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

name := "scalajs-react-template"
version := "1.0"
scalaVersion := "2.12.6"

val scalaJSReactVersion = "1.3.1"
val scalaCssVersion     = "0.5.5"
val reactJSVersion      = "16.5.1"

lazy val semanticUIVersion = "0.68.5"
lazy val elementalVersion  = "0.6.1"
lazy val materialUIVersion = "0.18.1"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

scalacOptions += "-P:scalajs:sjsDefinedByDefault"

libraryDependencies ++= Seq(
  "com.olvind"                        %%% "scalajs-react-components" % "1.0.0-M2",
  "io.surfkit"                        %%% "scalajs-google-maps"      % "0.0.3-SNAPSHOT",
  "com.github.japgolly.scalajs-react" %%% "core"                     % scalaJSReactVersion,
  "com.github.japgolly.scalajs-react" %%% "extra"                    % scalaJSReactVersion,
  "com.github.japgolly.scalacss"      %%% "core"                     % scalaCssVersion,
  "com.github.japgolly.scalacss"      %%% "ext-react"                % scalaCssVersion,
//  "org.webjars.npm"                   % "loose-envify"               % "1.4.0",
//  "org.webjars.npm"                   % "js-tokens"                  % "4.0.0"
)

version in webpack := "4.20.2"
version in startWebpackDevServer := "3.1.9"
scalaJSUseMainModuleInitializer := true

npmDependencies in Compile ++= Seq(
  //      "elemental"                         -> elementalVersion,
  //      "highlight.js"                      -> "9.9.0",
  //"material-ui" -> materialUIVersion,
  "react"     -> reactJSVersion,
  "react-dom" -> reactJSVersion,
  //      "react-addons-create-fragment"      -> reactJSVersion,
  //      "react-addons-css-transition-group" -> "15.6.2",
  //      "react-addons-pure-render-mixin"    -> "15.5.2",
  //      "react-addons-transition-group"     -> "15.0.0",
  //      "react-addons-update"               -> "15.5.2",
  //      "react-geomicons"                   -> "2.1.0",
  //      "react-infinite"                    -> "0.11.0",
  //      "react-select"                      -> "1.0.0-rc.5",
  //      "react-slick"                       -> "0.14.11",
  //      "react-spinner"                     -> "0.2.7",
  //      "react-tagsinput"                   -> "3.16.1",
  //      "react-tap-event-plugin"            -> "2.0.1",
  //      "semantic-ui-react"                 -> semanticUIVersion,
  //      "svg-loader"                        -> "0.0.2",
  //      "snabbdom"                          -> "0.5.3",
  //      "font-awesome"                      -> "4.7.0",
  //      "url-loader"                        -> "0.5.9",
  "firebase"         -> "5.5.3",
  "react-firebaseui" -> "3.1.2"
  //"firebaseui"   -> "3.4.1"
//  "firebase-admin" -> "6.0.0",
  //      "webpack"                           -> "4.18.1",
  //      "webpack-merge"                     -> "4.1.0",
  //      "file-loader"                       -> "2.0.0",
  //      "jquery"                            -> "3.3.1"
)

// emitSourceMaps := false

// adds root to webpackDevServer resource path to see index.html
webpackDevServerExtraArgs in fastOptJS ++= Seq(
  "--content-base",
  baseDirectory.value.getAbsolutePath
)