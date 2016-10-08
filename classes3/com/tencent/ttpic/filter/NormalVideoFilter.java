package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.cache.VideoImageCache2;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.List;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  private long frameStartTime;
  private int lastImageIndex = -1;
  private AudioUtils.Player mPlayer;
  protected Param.TextureBitmapParam mTextureParam;
  private final String materialId;
  protected int playCount = 0;
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(VideoFilterUtil.VERTEX_SHADER_COMMON, VideoFilterUtil.FRAGMENT_SHADER_COMMON, paramStickerItem);
    if (paramStickerItem.anchorPoint != null)
    {
      int i = 0;
      while (i < paramStickerItem.anchorPoint.length)
      {
        int[] arrayOfInt = paramStickerItem.anchorPoint;
        arrayOfInt[i] = ((int)(arrayOfInt[i] * 1.0D));
        i += 1;
      }
    }
    paramStickerItem.width = ((int)(paramStickerItem.width * 1.0D));
    paramStickerItem.height = ((int)(paramStickerItem.height * 1.0D));
    paramStickerItem.scaleFactor = ((int)(paramStickerItem.scaleFactor * 1.0D));
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    setStickerItem(paramStickerItem);
    setDrawPartial(true);
    initParams();
  }
  
  private Bitmap getNextFrame(int paramInt)
  {
    if (isLoadImageFromCache())
    {
      str = this.materialId + File.separator + this.item.id + "_" + paramInt + ".png";
      return VideoMemoryManager.getInstance().getVideoImageCache().loadImage(str);
    }
    String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.id + "_" + paramInt + ".png";
    if (this.dataPath.startsWith("assets://")) {
      return VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(str), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return VideoBitmapUtil.decodeSampledBitmapFromFile(str, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
  }
  
  private void updateTextureParam(long paramLong)
  {
    int i = (int)((paramLong - this.frameStartTime) / this.item.frameDuration);
    if (i >= this.item.frames * (this.playCount + 1))
    {
      this.playCount += 1;
      AudioUtils.startPlayer(this.mPlayer, true);
    }
    i %= this.item.frames;
    if ((i == this.lastImageIndex) && (this.mTextureParam != null)) {
      return;
    }
    Bitmap localBitmap = getNextFrame(i);
    if ((!VideoBitmapUtil.isLegal(localBitmap)) || (needClearTexture()))
    {
      clearTextureParam();
      return;
    }
    if (this.mTextureParam != null) {
      this.mTextureParam.swapTextureBitmap(localBitmap);
    }
    for (;;)
    {
      this.lastImageIndex = i;
      return;
      this.mTextureParam = new Param.TextureBitmapParam("inputImageTexture2", localBitmap, 33986, false);
      this.mTextureParam.initialParams(getmProgramIds());
      addParam(this.mTextureParam);
    }
  }
  
  public void clearTextureParam()
  {
    if (this.mTextureParam != null)
    {
      this.mTextureParam.clear();
      this.mTextureParam = null;
    }
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    AudioUtils.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    AudioUtils.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  protected boolean needClearTexture()
  {
    return (this.item.triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && ((!this.triggered) || ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)));
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(long paramLong)
  {
    if ((this.item != null) && (VideoPreviewFaceOutlineDetector.getInstance().detectExpression(this.item.triggerType)))
    {
      if (!this.triggered) {
        this.frameStartTime = paramLong;
      }
      this.triggered = true;
      if ((this.item != null) && (!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
      {
        if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
          if (!str.startsWith("assets://")) {
            break label184;
          }
          this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
        }
        AudioUtils.startPlayer(this.mPlayer, false);
      }
    }
    label184:
    while ((this.item == null) || (!this.item.alwaysTriggered)) {
      for (;;)
      {
        String str;
        return;
        this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
      }
    }
    this.triggered = false;
    AudioUtils.stopPlayer(this.mPlayer);
  }
  
  protected abstract void updatePositions(List<PointF> paramList, float paramFloat1, float paramFloat2);
  
  public void updatePreview(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    updateActionTriggered(paramLong);
    if (needClearTexture())
    {
      clearTextureParam();
      this.triggered = false;
      this.playCount = 0;
      this.lastImageIndex = -1;
      return;
    }
    updatePositions(paramList, paramFloat1, paramFloat2);
    updateTextureParam(paramLong);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\NormalVideoFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */