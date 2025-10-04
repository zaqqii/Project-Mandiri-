import turtle
import random

# Setup awal turtle screen
turtle.fd(0)
turtle.speed(0)
turtle.bgcolor("black")
turtle.ht()
turtle.setundobuffer(1)
turtle.tracer(1)

# Sprite class
class Sprite(turtle.Turtle):
    def __init__(self, spriteshape, color, stratx, straty):
        super().__init__(shape=spriteshape)
        self.speed(0)
        self.penup()
        self.color(color)
        self.goto(stratx, straty)
        self.showturtle()
        self.speed_value = 1

    def move(self):
        self.forward(self.speed_value)
        msg="Score"
        if self.xcor() > 290:
            self.setx(290)
            self.lt(60)
        if self.xcor() < -290:
            self.setx(-290)
            self.lt(60)
        if self.ycor() > 290:
            self.sety(290)
            self.lt(60)
        if self.ycor() < -290:
            self.sety(-290)
            self.lt(60)

    def is_collision(self, other):
        if (self.xcor() >= (other.xcor() - 20)) and\
           (self.xcor() <= (other.xcor() + 20)) and\
           (self.ycor() >= (other.ycor() - 20)) and\
           (self.ycor() <= (other.ycor() + 20)):
            return True
        else:
            return False

# Enemy class
class Enemy(Sprite):
    def __init__(self, spriteshape, color, stratx, straty):
        super().__init__(spriteshape, color, stratx, straty)
        self.speed_value = 8
        self.setheading(random.randint(0, 360))

class Missile(Sprite):
    def __init__(self, spriteshape, color, stratx, straty):
        super().__init__(spriteshape, color, stratx, straty)
        self.shapesize(stretch_wid=0.3, stretch_len=0.4, outline=None)
        self.speed = 20
        self.status = "ready"
        self.goto(-1000, 1000)  
    
    def fire(self):
        if self.status == "ready":
            self.goto(player .xcor(), player.ycor(), )
            self.setheading(player.heading())
            self.status = "firing"

    def move(self):

        if self.status == "ready":
            self.goto(-1000, 1000)  

        if self.status == "firing":
            self.fd(self.speed)

        if self.xcor() > 290 or self.xcor() < -290 or self.xcor() > 290 or \
            self.ycor() < -290 or self.ycor() > 290:
            self.goto(-1000, 1000)
            self.status = "ready"


# Player class
class Player(Sprite):
    def __init__(self, spriteshape, color, stratx, straty):
        super().__init__(spriteshape, color, stratx, straty)
        self.speed_value = 4
        self.lives = 3

    def turn_left(self):
        self.left(45)

    def turn_right(self):
        self.right(45)

    def accelerate(self):
        self.speed_value += 1

    def decelerate(self):
        self.speed_value = max(0, self.speed_value - 1)

# Game class
class Game():
    def __init__(self):
        self.level = 1
        self.score = 0
        
        self.state = "playing"
        self.pen = turtle.Turtle()
        self.lives = 3

    def draw_score(self):
        self.pen.speed(0)
        self.pen.color("white")
        self.pen.pensize(3)
        self.pen.penup()
        self.pen.goto(-300, 300)
        self.pen.pendown()
        for _ in range(4):
            self.pen.forward(600)
            self.pen.right(90)
        self.pen.penup()
        self.pen.hideturtle()

    def show_status(self): 
        msg = "Score: %s" % (self.score)
        self.pen.penup()
        self.pen.goto(-300, 310)
        self.pen.write(msg, font=("Arial", 16, "normal"))

    

# Inisialisasi game dan objek
game = Game()

game.draw_score()

game.show_status()

# Ally class
class Ally(Sprite):
    def __init__(self, spriteshape, color, stratx, straty):
        super().__init__(spriteshape, color, stratx, straty)
        self.speed_value = 6
        self.setheading(random.randint(0, 360))

#Create my sprites
player = Player("triangle", "white", 0, 0)
enemy = Enemy("circle", "red", -100, 0)
missile = Missile("triangle", "yellow", 0, 0)
ally = Ally("square", "green", 0, 0)

# Kontrol
turtle.onkey(player.turn_left, "Left")
turtle.onkey(player.turn_right, "Right")
turtle.onkey(player.accelerate, "Up")
turtle.onkey(player.decelerate, "Down")
turtle.onkey(missile.fire, "space")
turtle.listen()

# Loop game dengan ontimer (bukan while True agar tidak freeze)
def game_loop():
    player.move()
    enemy.move()
    missile.move()
    ally.move()
    turtle.ontimer(game_loop, 30)


    if player.is_collision(enemy):
        x = random.randint(-250, 250)
        y = random.randint(-250, 250)
        enemy.goto(x, y )
        #Increment score
        game.score += 100

    if player.is_collision(ally):
        x = random.randint(-250, 250)
        y = random.randint(-250, 250)
        ally.goto(x, y )
        missile.status = "ready"
        game.score -= 50
        game.show_status()

    if missile.is_collision(enemy):
        x = random.randint(-250, 250)
        y = random.randint(-250, 250)
        enemy.goto(x, y)
        missile.status = "ready"

game_loop()
turtle.done()
