
import scala.util.control.Exception._

object ControlUtil {

  def using[A <% { def close(): Unit }, B](resource: A)(f: A => B): B = {
    try f(resource) finally {
      if (resource != null) {
        ignoring(classOf[Throwable]) {
          resource.close()
        }
      }
    }
  }

}
