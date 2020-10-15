import com.github.nkzawa.socketio.client.IO
import com.github.nkzawa.socketio.client.Socket

fun main() {
    val socket = IO.socket("https://markets.profitview.net?api_key=223834ffcc42d292c3a5fdc156c244ad2b020465")
    socket.connect().on(Socket.EVENT_CONNECT) { socket.emit("subscribe", arrayOf("trade:bitmex:XBTUSD", "trade:bitmex:ETHUSD"))}
    socket.on("trade") { parameters -> for(parameter in parameters) println(parameter)}
}