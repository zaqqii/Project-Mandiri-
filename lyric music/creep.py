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
        ("But I'm a creep\nI'm a weirdo", 0.06),
        ("What the hell am I doin' here?\nI don't belong here", 0.06),
        ("I don't care if it hurts\nI want to have control", 0.06),
        ("I want a perfect body\nI want a perfect soul", 0.06),
        ("I want you to notice\nWhen I'm not around", 0.06),
        ("You're so fuckin' special\nI wish I was special", 0.06),
        ("But I'm a creep\nI'm a weirdo", 0.06),
        ("What the hell am I doin' here?\nI don't belong here", 0.06),
    ]
    
    # Adjusted delays to match the timing of the chorus
    delays = [0.0, 4.0, 8.0, 12.0, 16.0, 20.0, 24.0, 28.0]
    
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
