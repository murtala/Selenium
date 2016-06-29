package utilities.flashVideos;

import static org.junit.Assert.*;

import org.junit.Test;

public class YoutubeTest {

	@Test
	public void testOpenPage() {
		Youtube y = new Youtube();
		y.OpenPage();
		y.play();
		y.seekTo();
		
		//y.play();
		//
	//	y.getCurrentTime();
		y.pause();
		//y.play();
		y.stopVideo();
	}

}
