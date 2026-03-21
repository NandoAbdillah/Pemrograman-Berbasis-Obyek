import pygame
import sys

pygame.init()

WIDTH , HEIGHT = 600, 400

screen = pygame.display.set_mode((WIDTH, HEIGHT))

pygame.display.set_caption("Praktikum PBO - Pygame")

# WHITE = (0, 255, 255)
RED = (255, 0, 0)
GREEN = (0, 255, 0)
BIRU = (0, 0, 255)


running = True

while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    screen.fill(RED)
    pygame.display.update()
    
pygame.quit()
sys.exit()