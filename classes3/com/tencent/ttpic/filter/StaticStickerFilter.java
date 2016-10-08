package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoFilterUtil;
import java.util.List;

public class StaticStickerFilter
  extends NormalVideoFilter
{
  private boolean initialized = false;
  
  public StaticStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  public void clearTextureParam()
  {
    super.clearTextureParam();
    this.initialized = false;
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", -1));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
  }
  
  public void initPositionAdjusted()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    if (this.width / this.height >= 0.75D)
    {
      d = this.width / 720.0D;
      j = (int)(this.width / 0.75D);
      int k = (int)(j * (1.0D - this.item.position[1]));
      i = (int)(this.width * this.item.position[0]);
      j = k - (j - this.height) / 2;
      setPositions(AlgoUtils.calPositions(i, j, (int)(this.item.width * d) + i, (int)(j - this.item.height * d), this.width, this.height));
      return;
    }
    double d = this.height / 960.0D;
    int j = (int)(this.height * 0.75D);
    int i = (int)(this.height * (1.0D - this.item.position[1]));
    j = (int)(j * this.item.position[0]) - (j - this.width) / 2;
    setPositions(AlgoUtils.calPositions(j, i, (int)(this.item.width * d) + j, (int)(i - this.item.height * d), this.width, this.height));
  }
  
  public void initPositions()
  {
    if ((this.item == null) || (this.item.position == null) || (this.item.position.length < 2))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      return;
    }
    double d = this.width / 720.0D;
    int i = (int)(this.height * (1.0D - this.item.position[1]));
    int j = (int)(this.width * this.item.position[0]);
    setPositions(AlgoUtils.calPositions(j, i, (int)(this.item.width * d) + j, (int)(i - this.item.height * d), this.width, this.height));
    this.initialized = true;
  }
  
  protected void updatePositions(List<PointF> paramList, float paramFloat1, float paramFloat2)
  {
    if ((this.initialized) || (this.mTextureParam == null)) {
      return;
    }
    initPositionAdjusted();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    initPositionAdjusted();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\StaticStickerFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */