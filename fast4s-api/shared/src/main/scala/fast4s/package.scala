import io.fast4s.core.Fast4sRequestBuilder
import io.fast4s.data.*
import via.*

package object fast4s:

  export io.fast4s.core.HttpServerBuilder
  export io.fast4s.data.{
    ContentType,
    HttpMethod,
    HttpStatus,
    MimeType,
    Request,
    Response
  }

  export Response.{
    Ok,
    NotFound,
    ServerError,
    BadRequest,
    Created,
    Unauthorized,
    Forbidden
  }

  export io.fast4s.data.HttpMethod.{
    Head,
    Options,
    Patch,
    Get,
    Post,
    Put,
    Delete,
    Trace,
    Connect,
  }
  
  export io.fast4s.api.Fast4s
  export io.fast4s.api.Fast4s.fast

  given requestBuilder: Fast4sRequestBuilder {
    def build(routeInfo: RouteInfo,
              extra: Option[RawRequest]): Request =

      val headers = extra.map(_.headers).getOrElse(Map())
      val contentType = headers
        .find(_._1.toLowerCase == "content-type")
        .map(_._2)
        .map(ContentType.make)
        .getOrElse(ContentType.Empty)

      Request(
        routeInfo.method.toHttpMethod,
        routeInfo.target,
        extra.map(_.body).getOrElse(""),
        contentType,
        extra.map(_.bodyRaw).getOrElse(Nil),
        headers,
        routeInfo.params,
        routeInfo.query,
        routeInfo.matcher
      )
  }

  // router
  //export io.micro.router.*
