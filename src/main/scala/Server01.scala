
import java.io._
import java.net._

import ControlUtil._

object Server01 {

  def main(args: Array[String]) {

    using(new ServerSocket(8001)) { server =>
      println("クライアントからの接続を待ちます。")
      val socket = server.accept
      println("クライアント接続。")

      var ch: Int = 0
      val input = socket.getInputStream

      while (Option(input.read).map { in =>
        ch = in
        ch
      }.getOrElse(0) != -1) {
        val c: Char = ch.toChar
        println(c)
      }

      socket.close
      server.close
    }
  }
}
