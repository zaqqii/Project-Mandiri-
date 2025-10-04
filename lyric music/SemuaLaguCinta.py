import time
from threading import Thread, Lock
import sys

lock = Lock()

def animate_text(text, delay=0.1):
    with lock:
        for char in text:
            sys.stdout.write(char)
            sys.stdout.flush()
            time.sleep(delay)
    print()

def sing_lyric(lyric, delay, speed):
    time.sleep(delay)
    animate_text(lyric, speed)

def sing_song():
    lyrics = [
        ("Di seluruh tempat di seluruh dunia", 0.06),
        ("Di manapun lagu cinta ini terputar", 0.06),
        ("Ada film di kepalaku yang terputar", 0.06),
        ("Adegan romantis pemerannya kamu", 0.06),
        ("Semua membosankan semua menjemukan", 0.06),
        ("Tak ada yang bisa gambarkan parasmu", 0.06),
        ("Secara sempurna maka kan kucoba", 0.06),
        ("Karena semua yang lain terdengar sama", 0.06)
    ]
    delays = [0.4, 3.0, 6.3, 10.0, 13.0, 16.5, 19.9, 21.7]
    threads = []
    for i in range(len(lyrics)):
        lyric, speed = lyrics[i]
        t = Thread(target=sing_lyric, args=(lyric, delays[i], speed))
        threads.append(t)
        t.start()
    for t in threads:
        t.join()

if __name__ == "__main__":
    sing_song()
 