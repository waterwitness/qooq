package com.tencent.ttpic.recorder;

import android.annotation.TargetApi;
import android.hardware.Camera.Parameters;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class VideoParam
{
  private static final int BPS = 4194304;
  private static final int FPS = 25;
  private static final int IFI = 5;
  private static final String MIME = "video/avc";
  private static final String SDCARD = Environment.getExternalStorageDirectory().getPath();
  private static final String TAG = "VideoParam";
  private static final int VIDEO_H = 480;
  private static final int VIDEO_W = 640;
  public int mBps = 4194304;
  public int[] mFpsRange;
  public int mIfi = 5;
  public String mMime;
  
  public int getMaxFps()
  {
    if ((this.mFpsRange == null) || (this.mFpsRange.length <= 1)) {
      return 25;
    }
    return this.mFpsRange[1] / 1000;
  }
  
  @TargetApi(18)
  public void init(Camera.Parameters paramParameters)
  {
    Iterator localIterator = null;
    Object localObject2 = null;
    Object localObject1 = localIterator;
    if (paramParameters != null)
    {
      localObject1 = localIterator;
      if (paramParameters.getSupportedPreviewFpsRange() != null)
      {
        localIterator = paramParameters.getSupportedPreviewFpsRange().iterator();
        paramParameters = (Camera.Parameters)localObject2;
        for (;;)
        {
          localObject1 = paramParameters;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (int[])localIterator.next();
          if (localObject1[1] >= 25000) {
            paramParameters = (Camera.Parameters)localObject1;
          }
        }
      }
    }
    if (localObject1 == null) {
      Log.e("VideoParam", String.format("Not support fps: %d", new Object[] { Integer.valueOf(25) }));
    }
    this.mFpsRange = ((int[])localObject1);
    paramParameters = null;
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      localObject2 = MediaCodecList.getCodecInfoAt(i);
      localObject1 = paramParameters;
      if (((MediaCodecInfo)localObject2).isEncoder())
      {
        localObject2 = ((MediaCodecInfo)localObject2).getSupportedTypes();
        int m = localObject2.length;
        int j = 0;
        for (;;)
        {
          localObject1 = paramParameters;
          if (j >= m) {
            break;
          }
          localObject1 = localObject2[j];
          if ("video/avc".equals(localObject1)) {
            paramParameters = (Camera.Parameters)localObject1;
          }
          j += 1;
        }
      }
      i += 1;
      paramParameters = (Camera.Parameters)localObject1;
    }
    if (paramParameters == null) {
      Log.e("VideoParam", String.format("Not support MIME: %s", new Object[] { "video/avc" }));
    }
    this.mMime = paramParameters;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\recorder\VideoParam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */