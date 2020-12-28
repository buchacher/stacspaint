# StacsPaint

StacsPaint is a vector drawing application comparable to a drastically simplified, bare-bones version of MS Paint.

### Features

  - Draw lines, rectangles, squares, ellipses, circles and stars
  - Select the colour you want to draw your shapes in
  - Undo actions
  - Redo actions

### Instructions

  - Select the shape you wish to draw by clicking on the corresponding button at the top of the canvas
  - Move your mouse over the canvas
  - Press and hold the left mouse button
  - Drag your mouse to another position on the canvas
  - Release the left mouse button, and your shape will be drawn
    - The size of the shape will be determined by how far you move your mouse before letting go of the left mouse button
  - Click the **Choose colour** button at the bottom of the canvas and select a colour if you wish to draw your shapes in another colour
    - Remember to click **OK** button at the bottom of the dialogue box when you have selected the colour
    - You can select another colour anytime and as often as you wish
  - If you wish to undo and redo the drawing of one or more shapes, press the **Undo** and **Redo** buttons respectively at the bottom of the canvas

  
### Compiling, Testing and Running StacsPaint **Locally**

Navigate to the root folder and compile all `.java` files:

```shell script
javac -cp .:./junit.jar:./hamcrest.jar **/*.java
```

The `junit.jar` and `hamcrest.jar` files must be in the same directory.

To run the tests, add the `src` and `tests` directory to the classpath:

```shell script
java -cp .:./junit.jar:./hamcrest.jar:./src:./tests org.junit.runner.JUnitCore vectordrawing.model.shapes.ShapeTest
```

The output should be:

```
JUnit version 4.11
...
Time: 0.042

OK (2 tests)
```

To run the application, pass:

```shell script
java -cp .:./src vectordrawing.VectorDrawingMain
```
