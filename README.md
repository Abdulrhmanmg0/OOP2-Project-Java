# ***OOP2-Project-Java***

<p>In this Project of <em>JAVA Object-oriented programming </em>as a Graphical User Interface I tried to implements as much as possible of what I learned in by this course or a personal diligence , I even draw my first pixel art to use it in my project. <br><strong> You are free to use the code or pictures.</strong></p>
<h1> The In-Game View</h1>
<img align="left" src="https://user-images.githubusercontent.com/93158698/200768476-952e497f-2d11-4c9d-98ce-2be93780bc77.png" width="300" height="300" /> 

## This is the interface of the game.
The special technique that I implemented here is making these buttons because the border and the color is from the background ImageIcon not the buttons.
```
	JButton.setContentAreaFilled(false);
	JButton.setFocusPainted(false);
	JButton.setBorderPainted(false);
```

<br><br><br><br><br>

<img align="left" src="https://user-images.githubusercontent.com/93158698/200768458-7c7ffcf9-3b41-4bdb-872a-4d90107384b6.png" width="300" height="300" /> 

## The champion board 
It only read the last player details, I was intended to make it a Leaderboard showing the top 5 player at least but, I tried to make it simpler so it can be delivered before the deadline, It was difficult it center the labels that show the champion stats after i tried to center a Panel then put the labels above it but the Panel, but the Panel overlapping with the background Image so I learned how to set it transparent using this line of code.
```
    JPanel.setOpaque(false);
``` 
<br><br>

<img align="left" src="https://user-images.githubusercontent.com/93158698/201102193-e67734ef-0be3-461d-912c-b988492ac6d9.png" width="300" height="300" /> 

## The game frame 
Here were the main efforts written, I implemented for the first time the ``` Runnable ``` class which allow me to use the multithreading so I can do many tasks at once, the main implemented method from runnable class is
 ``` run ``` which will be called within a while loop 

 ```
    @Override
	public void run() {
	
        while(gameThread != null){

          //here were the methods called

         }
    }
```
For the images I used ``` BufferedImage ``` so I can draw it using ``` Graphical2D ``` it was a great class to manipulate the images size and place 
```
imageBG = ImageIO.read(getClass().getResourceAsStream("/pic/grass.png"));

g2.drawImage(imageBG, X, Y, WIDTH, HEIGHT, null);

``` 
How I made cars move and change direction at the end of the road after some simple research I found that we can change the X-axis each time we call the ``` paintComponent ``` method so the car appears like a moving car 
```
        Velocity1 = 2;
        X1 = X1 + Velocity1;
    	if(X1 > 600) { Velocity1 *= -1; xDir1 *= -1; }
		if(X1 < -50) { Velocity1 *= -1; xDir1 *= -1; }
```
And for the direction it was experiment to negate the ``` WIDTH ``` which leads to change direction at the end
```
        g2.drawImage(imageCarY,X1,80,xDir1,50,null);
```
It the end i wanna post down here every image I draw (by inspiration) pixel art using Gimp

<img align="left" src="https://user-images.githubusercontent.com/93158698/201119169-c04099a8-8eeb-49d0-9833-ce28a4d3bc15.png" width="100" height="100" /> 
<img align="left" src="https://user-images.githubusercontent.com/93158698/201119210-5fdd7d7b-a272-4027-b32c-0e5aed7b4186.png" width="100" height="100" /> 
<img align="left" src="https://user-images.githubusercontent.com/93158698/201119219-6afc13a3-0afe-4dd5-ae3e-986b7a8cbd04.png" width="100" height="100" /> 
<img align="left" src="https://user-images.githubusercontent.com/93158698/201119249-79165267-863e-4ac0-89be-bf507a2eea95.png" width="100" height="100" /> 
<img align="left" src="https://user-images.githubusercontent.com/93158698/201119271-c646708f-33bd-442f-bc57-285c03b9b5ac.png" width="100" height="100" /> 
