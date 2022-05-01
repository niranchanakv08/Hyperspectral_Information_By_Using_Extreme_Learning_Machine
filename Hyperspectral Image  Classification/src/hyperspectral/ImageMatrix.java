/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hyperspectral;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
/**
 *
 * @author admin
 */
public class ImageMatrix 
{
    int[][] pixels;
    int width;
    int height;

    public ImageMatrix(int width, int height) 
    {
	this.width = width;
	this.height = height;
	this.pixels = new int[height][width];
    }
	
    public ImageMatrix(Image image) throws Exception 
    {
	
        this(image.getWidth(null), image.getHeight(null));
	this.pixels = new int[height][width];
	
	int[] pixelsTemp = new int[this.width * this.height];
		
	PixelGrabber grabber = new PixelGrabber(image, 0, 0, this.width, this.height, pixelsTemp, 0, this.width);
	try 
        {
            grabber.grabPixels();
	} 
        catch (InterruptedException e) 
        {
            throw new Exception("Error");
	}
		
	for (int i=0; i<this.height; i++) 
        {
            for (int j=0; j<this.width; j++) 
            {
		this.pixels[i][j] = pixelsTemp[i*this.width + j];
            }
	}
    }

    public ImageProducer getImage() 
    {
	int[] pixelsTemp = new int[this.width * this.height];
	
	for (int i=0; i<this.height; i++) 
        {
            for (int j=0; j<this.width; j++) 
            {
		pixelsTemp[i * this.width + j] = this.pixels[i][j];
            }
	}
		
	return new MemoryImageSource(this.width, this.height, pixelsTemp, 0, this.width);
    }
	
    public BufferedImage getBufferedImage() 
    {
	BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
	for (int i=0; i<this.height; i++) 
        {
            for (int j=0; j<this.width; j++) 
            {
		bi.setRGB(j, i, this.pixels[i][j]);
            }
	}
		
	return bi;
    }
	
    public int getHeight() 
    {
	return height;
    }
	
    public int getWidth() 
    {
	return width;
    }
	
    public int[][] getPixels() 
    {
	return pixels;
    }
}
