package com.caleb.sdk.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// Bitmap Utils
public class BitmapUtils {

    public BitmapUtils(){

    }

    // Bitmap to Byte array
    public static byte[] BitmapToByteArray(Bitmap bitmap, Bitmap.CompressFormat format) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    // Byte array to Bitmap
    public static Bitmap ByteArrayToBitmap(byte[] byteArray) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return bitmap;
    }

    // Bitmap to String
    public static String BitmapToString(Bitmap bitmap, Bitmap.CompressFormat format) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String string = new String(byteArray);
        return string;
    }

    // String to Bitmap
    public static Bitmap StringToBitmap(String string) {
        byte[] byteArray = string.getBytes();
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        return bitmap;
    }

    // Bitmap to Drawable
    public static Drawable BitmapToDrawable(Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    // Drawable to Bitmap
    public static Bitmap DrawableToBitmap(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        return bitmap;
    }

    // Bitmap to Canvas
    public static Canvas BitmapToCanvas(Bitmap bitmap) {
        Canvas canvas = new Canvas(bitmap);
        return canvas;
    }

    // Canvas to Bitmap
    public static Bitmap CanvasToBitmap(Canvas canvas) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        return bitmap;
    }

    // Drawable to Canvas
    public static Canvas DrawableToCanvas(Drawable drawable) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Canvas canvas = new Canvas(bitmap);
        return canvas;
    }

    // Canvas to Drawable
    public static Drawable CanvasToDrawable(Canvas canvas) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    // String to Canvas
    public static Canvas StringToCanvas(String string) {
        byte[] byteArray = string.getBytes();
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Canvas canvas = new Canvas(bitmap);
        return canvas;
    }

    // Canvas to String
    public static String CanvasToString(Canvas canvas, Bitmap.CompressFormat format) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String newString = new String(byteArray);
        return newString;
    }

    // String to Drawable
    public static Drawable StringToDrawable(String string) {
        byte[] byteArray = string.getBytes();
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    // Drawable to String
    public static String DrawableToString(Drawable drawable, Bitmap.CompressFormat format) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        String string = new String(byteArray);
        return string;
    }

    // Byte array to Canvas
    public static Canvas ByteArrayToCanvas(byte[] byteArray) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Canvas canvas = new Canvas(bitmap);
        return canvas;
    }

    // Canvas to Byte array
    public static byte[] CanvasToByteArray(Canvas canvas, Bitmap.CompressFormat format) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    // Byte array to Drawable
    public static Drawable ByteArrayToDrawable(byte[] byteArray) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }

    // Drawable to Byte array
    public static byte[] DrawableToByteArray(Drawable drawable, Bitmap.CompressFormat format) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(format, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    // String to Byte array
    public static byte[] StringToByteArray(String string) {
        byte[] byteArray = string.getBytes();
        return byteArray;
    }

    // Byte array to String
    public static String ByteArrayToString(byte[] byteArray) {
        String string = new String(byteArray);
        return string;
    }

    // pixel to gray scale
    private static int PixelToGrayScale(int pixel) {
        int red = Color.red(pixel);
        int green = Color.green(pixel);
        int blue = Color.blue(pixel);
        int gray = (int) (0.299 * red + 0.587 * green + 0.114 * blue);
        return gray;
    }

    // Bitmap to gray scale
    public static Bitmap BitmapToGrayScale(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap grayScaleBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);
                int gray = PixelToGrayScale(pixel);
                grayScaleBitmap.setPixel(i, j, Color.argb(255, gray, gray, gray));
            }
        }
        return grayScaleBitmap;
    }

    // 水平投影
    public static int[] HorizontalProjection(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] projection = new int[height];
        for (int i = 0; i < height; i++) {
            int count = 0;
            for (int j = 0; j < width; j++) {
                int pixel = bitmap.getPixel(j, i);
                int gray = PixelToGrayScale(pixel);
                if (gray < 128) {
                    count++;
                }
            }
            projection[i] = count;
        }
        return projection;
    }

    // 垂直投影
    public static int[] VerticalProjection(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] projection = new int[width];
        for (int i = 0; i < width; i++) {
            int count = 0;
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);
                int gray = PixelToGrayScale(pixel);
                if (gray < 128) {
                    count++;
                }
            }
            projection[i] = count;
        }
        return projection;
    }

    // Otsu Threshold
    public static Bitmap OtsuThreshold(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] histogram = new int[256];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);
                int gray = PixelToGrayScale(pixel);
                histogram[gray]++;
            }
        }
        int total = width * height;
        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }
        float sumB = 0;
        int wB = 0;
        int wF = 0;
        float varMax = 0;
        int threshold = 0;
        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }
            wF = total - wB;
            if (wF == 0) {
                break;
            }
            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;
            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);
            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }
        Bitmap otsuBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);
                int gray = PixelToGrayScale(pixel);
                if (gray < threshold) {
                    otsuBitmap.setPixel(i, j, Color.argb(255, 0, 0, 0));
                } else {
                    otsuBitmap.setPixel(i, j, Color.argb(255, 255, 255, 255));
                }
            }
        }
        return otsuBitmap;
    }

    // Adaptive Threshold
    public static Bitmap AdaptiveThreshold(Bitmap bitmap, int blockSize, int c) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap adaptiveThresholdBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);
                int gray = PixelToGrayScale(pixel);
                int left = i - blockSize / 2;
                int right = i + blockSize / 2;
                int top = j - blockSize / 2;
                int bottom = j + blockSize / 2;
                if (left < 0) {
                    left = 0;
                }
                if (right >= width) {
                    right = width - 1;
                }
                if (top < 0) {
                    top = 0;
                }
                if (bottom >= height) {
                    bottom = height - 1;
                }
                int count = 0;
                int sum = 0;
                for (int k = left; k <= right; k++) {
                    for (int l = top; l <= bottom; l++) {
                        int pixel1 = bitmap.getPixel(k, l);
                        int gray1 = PixelToGrayScale(pixel1);
                        sum += gray1;
                        count++;
                    }
                }
                int mean = sum / count;
                if (gray < mean - c) {
                    adaptiveThresholdBitmap.setPixel(i, j, Color.argb(255, 0, 0, 0));
                } else {
                    adaptiveThresholdBitmap.setPixel(i, j, Color.argb(255, 255, 255, 255));
                }
            }
        }
        return adaptiveThresholdBitmap;
    }

    // Sobel Edge Detection
    public static Bitmap SobelEdgeDetection(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap sobelEdgeDetectionBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[][] Gx = new int[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        int[][] Gy = new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                int sumX = 0;
                int sumY = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        int pixel = bitmap.getPixel(i + k, j + l);
                        int gray = PixelToGrayScale(pixel);
                        sumX += gray * Gx[k + 1][l + 1];
                        sumY += gray * Gy[k + 1][l + 1];
                    }
                }
                int sum = (int) Math.sqrt(sumX * sumX + sumY * sumY);
                if (sum > 255) {
                    sum = 255;
                }
                if (sum < 0) {
                    sum = 0;
                }
                sobelEdgeDetectionBitmap.setPixel(i, j, Color.argb(255, sum, sum, sum));
            }
        }
        return sobelEdgeDetectionBitmap;
    }

    // Bitmap save to .png file
    public static void BitmapSaveToPngFile(Bitmap bitmap, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Canvas save to .jpg file
    public static void CanvasSaveToJpgFile(Canvas canvas, String path) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Canvas save to .png file
    public static void CanvasSaveToPngFile(Canvas canvas, String path) {
        Bitmap bitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas newCanvas = new Canvas(bitmap);
        newCanvas.drawBitmap(bitmap, 0, 0, null);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Drawable save to .jpg file
    public static void DrawableSaveToJpgFile(Drawable drawable, String path) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Drawable save to .png file
    public static void DrawableSaveToPngFile(Drawable drawable, String path) {
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Bitmap save to .bmp file. format is ARGB_8888
    private boolean BitmapSaveToBmpFile(Bitmap bitmap, String path) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pixels = new int[(w * h)];
        bitmap.getPixels(pixels, 0, w, 0, 0, w, h);
        byte[] rgb = addBMP_RGB_888(pixels, w, h);
        byte[] header = addBMPImageHeader(rgb.length);
        byte[] infos = addBMPImageInfosHeader(w, h);
        byte[] buffer = new byte[(rgb.length + 54)];
        System.arraycopy(header, 0, buffer, 0, header.length);
        System.arraycopy(infos, 0, buffer, 14, infos.length);
        System.arraycopy(rgb, 0, buffer, 54, rgb.length);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            fileOutputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private byte[] addBMPImageHeader(int size) {
        return new byte[]{66, 77, (byte) (size >> 0), (byte) (size >> 8), (byte) (size >> 16), (byte) (size >> 24), 0, 0, 0, 0, 54, 0, 0, 0};
    }

    private byte[] addBMPImageInfosHeader(int w, int h) {
        return new byte[]{40, 0, 0, 0, (byte) (w >> 0), (byte) (w >> 8), (byte) (w >> 16), (byte) (w >> 24), (byte) (h >> 0), (byte) (h >> 8), (byte) (h >> 16), (byte) (h >> 24), 1, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, -32, 1, 0, 0, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private byte[] addBMP_RGB_888(int[] b, int w, int h) {
        int len = b.length;
        System.out.println(b.length);
        byte[] buffer = new byte[(w * h * 3)];
        int offset = 0;
        int i = len - 1;
        while (i >= w) {
            int end = i;
            int offset2 = offset;
            for (int j = (i - w) + 1; j <= end; j++) {
                buffer[offset2] = (byte) (b[j] >> 0);
                buffer[offset2 + 1] = (byte) (b[j] >> 8);
                buffer[offset2 + 2] = (byte) (b[j] >> 16);
                offset2 += 3;
            }
            i -= w;
            offset = offset2;
        }
        return buffer;
    }

    // Bitmap clip to circle
    public static Bitmap BitmapClipToCircle(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int radius = Math.min(width, height) / 2;
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

}
