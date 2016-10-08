package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.List;

public class FaceOffFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String TAG = FaceOffFilter.class.getSimpleName();
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float['ф'];
  private int grayImageHeight;
  private int grayImageWidth;
  private FaceItem item;
  private float[] texVertices = new float['ф'];
  
  public FaceOffFilter(FaceItem paramFaceItem, String paramString)
  {
    this(VERTEX_SHADER, FRAGMENT_SHADER, null);
    this.item = paramFaceItem;
    this.dataPath = paramString;
    initParams();
    setDrawPartial(true);
  }
  
  public FaceOffFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    List localList2 = FaceOffUtil.genPoints(this.item.facePoints);
    List localList1 = FaceOffUtil.getGrayCoords(this.item.featureType);
    localList2 = FaceOffUtil.getFullCoords(localList2);
    localList1 = FaceOffUtil.getFullCoords(localList1);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(localList2, this.faceImageWidth, this.faceImageHeight, this.texVertices));
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(localList1, this.grayImageWidth, this.grayImageHeight, this.texVertices));
    setFaceOff(true);
    setCoordNum(546);
  }
  
  public void initParams()
  {
    Bitmap localBitmap1 = FaceOffUtil.getFaceBitmap(this.dataPath, this.item);
    Bitmap localBitmap2 = FaceOffUtil.getGrayBitmap(this.item.featureType);
    if ((!VideoBitmapUtil.isLegal(localBitmap1)) || (!VideoBitmapUtil.isLegal(localBitmap2))) {
      return;
    }
    this.faceImageWidth = localBitmap1.getWidth();
    this.faceImageHeight = localBitmap1.getHeight();
    this.grayImageWidth = localBitmap2.getWidth();
    this.grayImageHeight = localBitmap2.getHeight();
    addParam(new Param.TextureBitmapParam("inputImageTexture2", localBitmap1, 33986, true));
    addParam(new Param.TextureBitmapParam("inputImageTexture3", localBitmap2, 33987, true));
    addParam(new Param.IntParam("enableFaceOff", 1));
    addParam(new Param.FloatParam("alpha", this.item.blendAlpha));
    addParam(new Param.Float2fParam("canvasSize", 0.0F, 0.0F));
    addParam(new Param.FloatParam("positionRotate", 0.0F));
    addParam(new Param.IntParam("enableAlphaFromGray", this.item.grayScale));
  }
  
  public void updatePreview(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    if (!VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value))
    {
      setPositions(VideoFilterUtil.EMPTY_POSITIONS);
      setCoordNum(4);
      return;
    }
    paramList = FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList));
    VideoMaterialUtil.flipYPoints(paramList, (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT));
    setPositions(FaceOffUtil.initFacePositions(paramList, (int)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT), (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT), this.faceVertices));
    setCoordNum(546);
    addParam(new Param.FloatParam("positionRotate", -paramFloat2));
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\FaceOffFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */