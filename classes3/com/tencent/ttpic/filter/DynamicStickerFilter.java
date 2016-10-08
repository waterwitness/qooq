package com.tencent.ttpic.filter;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;

public class DynamicStickerFilter
  extends NormalVideoFilter
{
  private static final int LENTH_POINTS_ANGLE = 4;
  private Point canvasCenter;
  
  public DynamicStickerFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private boolean isValidPoint(Point paramPoint)
  {
    if (paramPoint == null) {}
    while ((paramPoint.x < 0) || (paramPoint.x > this.width) || (paramPoint.y < 0) || (paramPoint.y > this.height)) {
      return false;
    }
    return true;
  }
  
  public void initParams()
  {
    addParam(new Param.IntParam("texNeedTransform", 1));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.Float2fParam("texAnchor", 0.0F, 0.0F));
    addParam(new Param.FloatParam("texScale", 0.0F));
    addParam(new Param.FloatParam("texRotate", 1.0F));
    addParam(new Param.FloatParam("positionRotate", 0.0F));
    addParam(new Param.IntParam("blendMode", this.item.blendMode));
  }
  
  protected void updatePositions(List<PointF> paramList, float paramFloat1, float paramFloat2)
  {
    if (VideoUtil.isEmpty(paramList))
    {
      clearTextureParam();
      return;
    }
    PointF localPointF1 = (PointF)paramList.get(this.item.alignFacePoints[0]);
    if (this.item.alignFacePoints.length == 1) {}
    for (int i = this.item.alignFacePoints[0];; i = this.item.alignFacePoints[1])
    {
      PointF localPointF2 = (PointF)paramList.get(i);
      localPointF1 = new PointF((localPointF1.x + localPointF2.x) / 2.0F, (localPointF2.y + localPointF2.y) / 2.0F);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      float f1 = localPointF1.x - this.item.anchorPoint[0];
      float f2 = this.height - localPointF1.y + this.item.anchorPoint[1];
      setPositions(AlgoUtils.calPositions(f1, f2, f1 + this.item.width, f2 - this.item.height, this.width, this.height));
      addParam(new Param.Float2fParam("texAnchor", localPointF1.x - this.canvasCenter.x, this.canvasCenter.y - localPointF1.y));
      localPointF1 = new PointF(((PointF)paramList.get(this.item.scalePivots[0])).x, ((PointF)paramList.get(this.item.scalePivots[0])).y);
      localPointF1.x = ((float)(localPointF1.x * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      localPointF1.y = ((float)(localPointF1.y * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      paramList = new PointF(((PointF)paramList.get(this.item.scalePivots[1])).x, ((PointF)paramList.get(this.item.scalePivots[1])).y);
      paramList.x = ((float)(paramList.x * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      paramList.y = ((float)(paramList.y * (1.0D / VideoMaterialUtil.SCALE_FACE_DETECT)));
      addParam(new Param.FloatParam("texScale", (float)(Math.sqrt(Math.pow(localPointF1.x - paramList.x, 2.0D) + Math.pow(localPointF1.y - paramList.y, 2.0D)) / this.item.scaleFactor)));
      addParam(new Param.FloatParam("texRotate", paramFloat1));
      addParam(new Param.FloatParam("positionRotate", -paramFloat2));
      return;
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\DynamicStickerFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */