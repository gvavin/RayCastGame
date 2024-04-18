package org.resources;

import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import org.graphics.RayCastGameEngine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageResource {

    //OpenGL texture object
    private Texture texture = null;

    private BufferedImage image = null;

    public ImageResource(String path){
        URL url =ImageResource.class.getResource(path);

        try{
           if(url != null){
               image = ImageIO.read(url);
           }
           else{
               System.err.println("failed to load image ");

           }
        } catch(IOException e){
            e.printStackTrace();
        }
        if(image != null){
            image.flush();
        }



    }
    public Texture getTexture (){
        if(image == null){
            // texture is empty?
            System.out.println("getTexture's image is empty/null");
            return null;
        } if(texture == null){
            texture = AWTTextureIO.newTexture(RayCastGameEngine.getProfile(),image,true);
        }
        return texture;
    }
}
