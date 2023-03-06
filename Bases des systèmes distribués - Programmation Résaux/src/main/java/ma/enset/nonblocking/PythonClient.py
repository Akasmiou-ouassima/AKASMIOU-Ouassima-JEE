import socket

HOST = 'localhost'
PORT = 1234
REQUEST = b'Hello from Non-Blocking Python Client!'

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.connect((HOST, PORT))
    s.sendall(REQUEST)
    data = s.recv(1024)

print(repr(data.decode('utf-8')))
