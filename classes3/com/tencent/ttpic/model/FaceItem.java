package com.tencent.ttpic.model;

import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceItem
{
  public float blendAlpha;
  public List<Integer> facePoints;
  public FaceOffUtil.FEATURE_TYPE featureType;
  public int grayScale;
  public String imageFile;
  
  public FaceItem(String paramString, float paramFloat, int paramInt1, int paramInt2, List<Integer> paramList)
  {
    this.imageFile = paramString;
    this.blendAlpha = paramFloat;
    this.grayScale = paramInt1;
    this.featureType = FaceOffUtil.getFeatureType(paramInt2);
    this.facePoints = paramList;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\model\FaceItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */