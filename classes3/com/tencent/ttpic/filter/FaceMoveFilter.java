package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;

public class FaceMoveFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SnakeFaceFragmentShader.dat").replace("\n", "");
  private static final String TAG = FaceMoveFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat").replace("\n", "");
  private PointF[] dstPoints = new PointF[107];
  private int[] faceMoveTriangles;
  private List<FaceMoveItem> items;
  private float[] posVertices = new float['ф'];
  private PointF[] srcPoints = new PointF[107];
  private float[] texVertices = new float['ф'];
  
  public FaceMoveFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
  }
  
  public FaceMoveFilter(List<FaceMoveItem> paramList, int[] paramArrayOfInt)
  {
    this(VERTEX_SHADER, FRAGMENT_SHADER, null);
    this.items = paramList;
    this.faceMoveTriangles = paramArrayOfInt;
    int i = 0;
    while (i < this.srcPoints.length)
    {
      this.srcPoints[i] = new PointF();
      this.dstPoints[i] = new PointF();
      i += 1;
    }
    initParams();
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setFaceOff(true);
  }
  
  public void initParams() {}
  
  public void updatePreview(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    VideoMaterialUtil.copyListToArray(paramList, this.srcPoints);
    FaceMoveUtil.genFullCoords(this.srcPoints);
    FaceMoveUtil.adjustCoords(this.srcPoints, this.dstPoints, this.items);
    setPositions(FaceMoveUtil.initFacePositions(this.dstPoints, (int)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT), (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT), this.posVertices, this.faceMoveTriangles));
    setTexCords(FaceMoveUtil.initMaterialFaceTexCoords(this.srcPoints, (int)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT), (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT), this.texVertices, this.faceMoveTriangles));
    if (this.faceMoveTriangles == null) {}
    for (int i = 546;; i = this.faceMoveTriangles.length)
    {
      setCoordNum(i);
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\FaceMoveFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */