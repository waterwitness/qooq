package com.tencent.video.decode;

public class AVDecodeOption
{
  public static final int DISABLE_DROP_VIDEO_FPS = -1;
  public static final int ENCODING_PCM_16BIT = 65281;
  public static final int ENCODING_PCM_8BIT = 65280;
  public static final int ENCODING_PCM_FLOAT = 65282;
  public int audioFormat = 65281;
  public boolean cycle;
  public String filename;
  public boolean fixDuration = true;
  public boolean ignore_audio;
  public String mAfPath;
  public int mDecodeType = 0;
  public int mTotalTime;
  public String mVfPath;
  public int mVideoFrames;
  public boolean only_keyframe;
  public float wantedFps = 0.0F;
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\video\decode\AVDecodeOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */