package com.assp.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 
  * 类简述
  * <p>
  * 类说明、详细描述(optional)
  * </p>
  * @Company 动力威视
  * @Copyright
  * @author (panlinlin@sxw100.com)
  * @version 1.0
  * @CreateDate 2016年6月21日 下午2:40:58
 */
public class VerifyCodeUtil {
	public static String getMimeType() {
		return "image/jpeg";
	}

	public static String createVerifyCode(OutputStream output)
			throws IOException {
		int width = 60;
		int height = 21;
		BufferedImage image = new BufferedImage(width, height, 1);

		Graphics g = image.getGraphics();

		Random random = new Random();

		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		g.setFont(new Font("Times New Roman", 0, 18));

		g.setColor(new Color(204, 217, 232));
		g.drawRect(0, 0, width, height);

		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; ++i) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		String sRand = "";
		for (int i = 0; i < 4; ++i) {
			String rand = String.valueOf(random.nextInt(10));
			sRand = sRand + rand;

			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, 13 * i + 6, 16);
		}

		g.dispose();

		ImageIO.write(image, "JPEG", output);

		return sRand;
	}

	private static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
