package fast4s.backend

import io.fast4s.backend.beast.{HttpServerAsync, HttpServerSync}
import io.fast4s.core.{HttpServerConfigs, HttpServerCreatorR}

package object beast:
  given sync: HttpServerCreatorR =
    (cfg: HttpServerConfigs) => HttpServerSync(cfg)

  given async: HttpServerCreatorR =
    (cfg: HttpServerConfigs) => HttpServerAsync(cfg)
