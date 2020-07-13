from mpl_toolkits.mplot3d import Axes3D
from multiprocessing import Process, Queue
import matplotlib.pyplot as plt
import matplotlib.animation as animation
import json, subprocess, time, os, sys,random
import pandas as pd


origin = [0,0,0]
fig = plt.gcf()
ax = fig.add_subplot(111, projection='3d')

def animate(i):
    data = pd.read_csv('data.csv')
    count = data['count']
    x = - int(data['z'].tail(1))
    y = - int(data['y'].tail(1))
    z =  int(data['x'].tail(1))
    
    print(x)
    ax.clear()
    p0 = [x/10000,y/10000,z/10000]
    p1 = [0, 0, 0]
    p2 = [0, 0, 0]
    X, Y, Z = zip(origin,origin,origin) 
    U, V, W = zip(p0,p1,p2)
    ax.quiver(X,Y,Z,U,V,W,arrow_length_ratio=0.1)

ani = animation.FuncAnimation(fig, animate, 1)
plt.tight_layout()
plt.show()    




