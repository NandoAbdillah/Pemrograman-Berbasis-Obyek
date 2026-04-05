import pygame 
import sys

pygame.init()

WIDTH, HEIGHT = 600, 400
screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("GAME KEJAR MALING")

WHITE = (255, 255, 255)
BLUE = (0 ,0, 255)
RED = (255, 0, 0)


class Character :
    def __init__ (self, x, y, color) :
        self.x = x
        self.y = y
        self.color = color
        self.speed = 1
        self.width = 50
        self.height = 50

    def check_boundaries(self) :
        if self.x < 0:
            self.x = 0
        if self.x + self.width > WIDTH:
            self.x = WIDTH - self.width
        if self.y < 0:
            self.y = 0
        if self.y + self.height > HEIGHT:
            self.y = HEIGHT - self.height

    def draw(self, surface) :
        pygame.draw.rect(surface, self.color, (self.x, self.y, self.width, self.height))

    def get_rect(self) :
        return pygame.Rect(self.x, self.y, self.width, self.height)

class Polisi(Character) :
    def move(self, keys):
        if keys[pygame.K_LEFT]:
            self.x -= self.speed
        if keys[pygame.K_RIGHT]:
            self.x += self.speed
        if keys[pygame.K_UP]:
            self.y -= self.speed
        if keys[pygame.K_DOWN]:
            self.y += self.speed
        self.check_boundaries()

class Maling(Character) :
    def move(self, keys):
        if keys[pygame.K_a]:
            self.x -= self.speed
        if keys[pygame.K_d]:
            self.x += self.speed
        if keys[pygame.K_w]:
            self.y -= self.speed
        if keys[pygame.K_s]:
            self.y += self.speed
        self.check_boundaries()

polisi = Polisi(375, 275, BLUE)
maling = Maling(100, 100, RED)

running = True
game_over = False
game_over_time = 0

while running :
    
    for event in pygame.event.get() :
        if event.type == pygame.QUIT :
            running = False
            
    keys = pygame.key.get_pressed()
    
   
    if not game_over:
        polisi.move(keys)
        maling.move(keys)


    screen.fill(WHITE)

    if polisi.get_rect().colliderect(maling.get_rect()) and not game_over:
        print("Maling Tertangkap!")
        game_over = True
        
    polisi.draw(screen)
    maling.draw(screen)

    if game_over:
        font = pygame.font.SysFont(None, 48)
        text = font.render("Polisi Menang !", True, (0, 0, 0))
        screen.blit(text, (WIDTH // 2 - text.get_width() // 2, HEIGHT // 2 - text.get_height() // 2))
        running = False
        pygame.display.update()
        pygame.time.delay(2000)

    pygame.display.update()


pygame.quit()
sys.exit()