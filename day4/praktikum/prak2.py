import pygame 
import sys

pygame.init()

WIDTH, HEIGHT = 800, 600

screen = pygame.display.set_mode((WIDTH, HEIGHT))
pygame.display.set_caption("GAME PBO")

WHITE = (255, 255, 255)
BLUE = (0 ,0, 255)
RED = (255, 0, 0)
colors = [BLUE, RED]

class Player :
    def __init__ (self, x,y) :
        self.x = x
        self.y = y
        
        self.speed = 2
        
        self.width = 50
        self.height = 50
        
        self.max_size = 200
        self.min_size = 10
        
        self.scale = 1.5
        
        self.color_state = 0
        self.color = colors[self.color_state]
        
    def move(self, keys) :
        if keys[pygame.K_LEFT] :
            self.x -= self.speed
            
        if keys[pygame.K_RIGHT] :
            self.x += self.speed
            
        if keys[pygame.K_UP] :
            self.y -= self.speed
            
        if keys[pygame.K_DOWN] :
            self.y += self.speed
        
        self.check_boundaries()
    
    def check_boundaries(self) :
        if(self.x < 0) :
            self.x = 0
        if(self.x + self.width > WIDTH) :
            self.x = WIDTH - self.width
            
        if(self.y < 0) :
            self.y = 0
            
        if(self.y + self.height > HEIGHT) :
            self.y = HEIGHT - self.height

    def resize_increase(self, key) :
        if self.width < self.max_size and self.height < self.max_size :
            if key == pygame.K_p :
                self.width = self.width * self.scale
                self.height = self.height * self.scale
               
                self.x = self.x - (self.width - self.width / self.scale) / 2
                self.y = self.y - (self.height - self.height / self.scale) / 2
                
    def resize_decrease(self, key) :
        if self.width > self.min_size and self.height > self.min_size :
            if key == pygame.K_o :
                self.width = self.width / self.scale
                self.height = self.height / self.scale
                
                self.x = self.x - (self.width - self.width * self.scale) / 2
                self.y = self.y - (self.height - self.height * self.scale) / 2
                        
        
    def change_color(self, key) :
        if key == pygame.K_1 :
            self.color = colors[self.color_state]
            self.color_state = (self.color_state + 1) % len(colors)
            
    def draw(self, surface) :
        pygame.draw.rect(surface, self.color, (self.x, self.y, self.width, self.height))
        
player = Player(375, 275)

running = True

while running :
    
    for event in pygame.event.get() :
        if event.type == pygame.QUIT :
            running = False
            
        if event.type == pygame.KEYDOWN :
            player.resize_decrease(event.key)
            player.resize_increase(event.key)
            player.change_color(event.key)
            
    keys = pygame.key.get_pressed()
    
    player.move(keys)
    
    screen.fill(WHITE)
    player.draw(screen)
    pygame.display.flip()
    
pygame.quit()
sys.exit()