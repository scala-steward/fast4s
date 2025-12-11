package io.fast4s.example

import fast4s.*
import io.fast4s.core.HttpServerCreator
import via.*

object AppServer:

  type RouteEnter = Enter[Request, Response]
  type Route = RouteEntry[Request, Response]

  def serve(using HttpServerCreator): Int =

    val logger: RouteEnter = enter(GET):
      req =>
        println(s"enter in ${req.target}")
        req

    val home: Route = route(GET, root):
      req => Response.ok("alive!")

    val ping: Route = route(GET, root / "ping"):
      case _ => Response.ok("pong")

    HttpServerBuilder()
      .withRoutes(
        logger ++ home,
        logger ++ ping
      )
      .build
      .serve


