import processing.core.*;

public class CubeRenderer extends PApplet {

    final int INSIDE_CUBES_MAX = 300;

    // TODO: get rid of magic numbers
    public void draw() {
        background(0);
        translate(width / 2.0f, height / 2.0f, -INSIDE_CUBES_MAX);

        final float mainCubeAngle = frameCount * .01f;
        rotateX(mainCubeAngle);
        rotateY(mainCubeAngle);
        rotateZ(mainCubeAngle);

        for (int x = -INSIDE_CUBES_MAX; x < INSIDE_CUBES_MAX; x += 100) {
            for (int y = -INSIDE_CUBES_MAX; y < INSIDE_CUBES_MAX; y += 100) {
                for (int z = -INSIDE_CUBES_MAX; z < INSIDE_CUBES_MAX; z += 100) {
                    pushMatrix();
                    translate(x, y, z);

                    final float insideCubesAngle = frameCount * .02f;
                    rotateX(insideCubesAngle);
                    rotateY(insideCubesAngle);
                    rotateZ(insideCubesAngle);

                    fill(colorFromOffset(x), colorFromOffset(y), colorFromOffset(z));
                    final double insideCubesRotation = (Math.sin(frameCount / 20.0f)) * 15;
                    box((float) (20 + insideCubesRotation));
                    popMatrix();
                }
            }
        }
    }

    public int colorFromOffset(int offset) {
        return (int) ((offset + INSIDE_CUBES_MAX) / (2.8f * INSIDE_CUBES_MAX) * 255);
    }

    public void settings() {
        size(1060, 1040, P3D);
    }

    static public void main(String[] passedArgs) {
        final String[] appletArgs = new String[] {"CubeRenderer"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
