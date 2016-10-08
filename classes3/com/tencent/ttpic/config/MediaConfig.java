package com.tencent.ttpic.config;

public class MediaConfig
{
  public static int BPS_HIGH;
  public static int BPS_LOW = 1048576;
  public static int BPS_MEDIUM;
  public static int INTERMIDIATE_IMAGE_WIDTH_HIGH;
  public static int INTERMIDIATE_IMAGE_WIDTH_LOW;
  public static int INTERMIDIATE_IMAGE_WIDTH_MEDIUM;
  public static double INTERMIDIATE_SCALE_FACTOR_HIGH;
  public static double INTERMIDIATE_SCALE_FACTOR_LOW;
  public static double INTERMIDIATE_SCALE_FACTOR_MEDIUM;
  public static int MS_VIDEO_FRAME_RATE;
  public static int VIDEO_FRAME_RATE;
  public static int VIDEO_IMAGE_HEIGHT;
  public static int VIDEO_IMAGE_WIDTH;
  public static double VIDEO_OUTPUT_ASPECT_RATIO;
  public static int VIDEO_OUTPUT_HEIGHT;
  public static int VIDEO_OUTPUT_WATERMARK_HEIGHT;
  public static int VIDEO_OUTPUT_WATERMARK_WIDTH;
  public static int VIDEO_OUTPUT_WIDTH = 720;
  
  static
  {
    VIDEO_OUTPUT_HEIGHT = 960;
    VIDEO_OUTPUT_ASPECT_RATIO = 1.0D;
    VIDEO_FRAME_RATE = 25;
    MS_VIDEO_FRAME_RATE = 25;
    VIDEO_OUTPUT_WATERMARK_WIDTH = 118;
    VIDEO_OUTPUT_WATERMARK_HEIGHT = 34;
    VIDEO_IMAGE_WIDTH = 480;
    VIDEO_IMAGE_HEIGHT = 640;
    INTERMIDIATE_IMAGE_WIDTH_HIGH = 720;
    INTERMIDIATE_IMAGE_WIDTH_MEDIUM = 600;
    INTERMIDIATE_IMAGE_WIDTH_LOW = 480;
    INTERMIDIATE_SCALE_FACTOR_HIGH = 0.25D;
    INTERMIDIATE_SCALE_FACTOR_MEDIUM = 0.5D;
    INTERMIDIATE_SCALE_FACTOR_LOW = 0.5D;
    BPS_HIGH = 1048576;
    BPS_MEDIUM = 1048576;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\config\MediaConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */