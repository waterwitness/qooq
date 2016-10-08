package com.tencent.ttpic.filter;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.Param.Float1sParam;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;

public class FacePointsFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "DrawPoints.glsl");
  
  public FacePointsFilter(String paramString)
  {
    super(paramString);
  }
  
  public static FacePointsFilter createFaceFilter()
  {
    return new FacePointsFilter(FRAGMENT_SHADER);
  }
  
  public void ApplyGLSLFilter()
  {
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.Float2fParam("faceDetectImageSize", 0.0F, 0.0F));
    addParam(new Param.Float1sParam("facePoints", new float[0]));
    super.ApplyGLSLFilter();
  }
  
  public void updatePoints(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat != null) {
      addParam(new Param.Float1sParam("facePoints", paramArrayOfFloat));
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2)
  {
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
    addParam(new Param.Float2fParam("faceDetectImageSize", paramInt1 / 4, paramInt2 / 4));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\FacePointsFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */