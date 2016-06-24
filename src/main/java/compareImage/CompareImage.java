package compareImage;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CompareImage {

	public static  boolean compare(File inputOriginal, File inputCopy) throws IOException {
		boolean match = true;
		//File inputOriginal = new File("F:\\Users\\Mobile\\White Box\\TesterProject\\src\\compareImages\\logo4w.png");
		//File inputCopy = new File("F:\\Users\\Mobile\\White Box\\TesterProject\\src\\compareImages\\logo4wInvert.png");
		
		BufferedImage original = ImageIO.read(inputOriginal);
		BufferedImage copy = ImageIO.read(inputCopy);

		original.getData();
		copy.getData();

		
		System.out.println("Original: NumBands= "+original.getData().getNumBands());
		System.out.println("Original: Width = "+original.getData().getWidth());
		System.out.println("Original: Height= "+ original.getData().getHeight());
		
		System.out.println("copy: NumBands= "+copy.getData().getNumBands());
		System.out.println("copy: Width= "+copy.getData().getWidth());
		System.out.println("copy: Height= "+copy.getData().getHeight());

		// compare number of bands,width and height

		if (original.getData().getNumBands() != copy.getData().getNumBands()
				|| original.getData().getWidth() != copy.getData().getWidth()
				|| original.getData().getHeight() != copy.getData().getHeight()) {

			match = false;
		} else {

			search: for (int i = 0; i < original.getData().getNumBands(); ++i) {
				for (int x = 0; x < original.getData().getWidth(); ++x) {
					for (int y = 0; y < original.getData().getHeight(); ++y) {
						if (copy.getData().getSample(x, y, i) != copy.getData().getSample(x, y, i)) {
							// If one of the result is false setting the result
							// as false and breaking the loop.
							match = false;
							break search;
						}
					}
				}
			}
		}
		return match;
	}
}
