package com.tencent.ttpic.filter;

import android.graphics.PointF;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import java.util.List;

public class TransformFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformFragmentShader.dat").replace("\\s+", " ");
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformVertexShader.dat").replace("\\s+", " ");
  private static final String VERTEX_SHADER_SIMPLE = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformVertexShaderSimple.dat").replace("\\s+", " ");
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 88;
  private List<DistortionItem> items;
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  private MeshDistortionType[] meshs = new MeshDistortionType[30];
  
  public TransformFilter(String paramString1, String paramString2, StickerItem paramStickerItem)
  {
    super(paramString1, paramString2, paramStickerItem);
  }
  
  public TransformFilter(List<DistortionItem> paramList) {}
  
  private void initCoordinates()
  {
    this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(50, 88, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(50, 88, 0.0F, 1.0F, 0.0F, 1.0F);
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setSnakeFace(true);
    setCoordNum(8851);
  }
  
  public void initParams()
  {
    addParam(new Param.FloatParam("screenRatio", 0.0F));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), this.meshs[i].type));
      addParam(new Param.FloatParam(String.format("items[%d].strength", new Object[] { Integer.valueOf(i) }), this.meshs[i].strength));
      addParam(new Param.Float2fParam(String.format("items[%d].point", new Object[] { Integer.valueOf(i) }), this.meshs[i].point.x, this.meshs[i].point.y));
      addParam(new Param.FloatParam(String.format("items[%d].radius", new Object[] { Integer.valueOf(i) }), this.meshs[i].radius));
      addParam(new Param.IntParam(String.format("items[%d].direction", new Object[] { Integer.valueOf(i) }), this.meshs[i].direction));
      addParam(new Param.FloatParam(String.format("items[%d].faceDegree", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceDegree));
      addParam(new Param.FloatParam(String.format("items[%d].faceRatio", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceRatio));
      i += 1;
    }
  }
  
  public void updatePreview(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    paramList = VideoMaterialUtil.copyList(paramList);
    int i;
    if ((paramList == null) || (paramList.size() < 90) || (VideoUtil.isEmpty(this.items))) {
      i = 0;
    }
    while (i < 30)
    {
      addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), -1));
      i += 1;
      continue;
      paramList = TransformUtil.getFullPoints(paramList);
      paramFloat1 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
      paramFloat2 = (((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y) / paramFloat1;
      float f = (float)Math.atan((((PointF)paramList.get(9)).x - ((PointF)paramList.get(84)).x) / (-((PointF)paramList.get(9)).y + ((PointF)paramList.get(84)).y));
      i = 0;
      while (i < this.items.size())
      {
        DistortionItem localDistortionItem = (DistortionItem)this.items.get(i);
        this.meshs[i].type = localDistortionItem.distortion;
        this.meshs[i].strength = localDistortionItem.strength;
        this.meshs[i].point = ((PointF)paramList.get(localDistortionItem.position));
        this.meshs[i].radius = ((float)(localDistortionItem.radius * paramFloat1 / VideoMaterialUtil.SCALE_FACE_DETECT / this.width / 375.0D));
        this.meshs[i].direction = localDistortionItem.direction;
        this.meshs[i].faceDegree = f;
        this.meshs[i].faceRatio = paramFloat2;
        i += 1;
      }
      i = this.items.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      i = 0;
      while (i < 30)
      {
        addParam(new Param.IntParam(String.format("items[%d].type", new Object[] { Integer.valueOf(i) }), this.meshs[i].type));
        addParam(new Param.FloatParam(String.format("items[%d].strength", new Object[] { Integer.valueOf(i) }), this.meshs[i].strength));
        addParam(new Param.Float2fParam(String.format("items[%d].point", new Object[] { Integer.valueOf(i) }), (float)(2.0F * this.meshs[i].point.x / VideoMaterialUtil.SCALE_FACE_DETECT / this.width - 1.0D), (float)(2.0F * this.meshs[i].point.y / VideoMaterialUtil.SCALE_FACE_DETECT / this.height - 1.0D)));
        addParam(new Param.FloatParam(String.format("items[%d].radius", new Object[] { Integer.valueOf(i) }), this.meshs[i].radius));
        addParam(new Param.IntParam(String.format("items[%d].direction", new Object[] { Integer.valueOf(i) }), this.meshs[i].direction));
        addParam(new Param.FloatParam(String.format("items[%d].faceDegree", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceDegree));
        addParam(new Param.FloatParam(String.format("items[%d].faceRatio", new Object[] { Integer.valueOf(i) }), this.meshs[i].faceRatio));
        i += 1;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.FloatParam("screenRatio", this.height / this.width));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\TransformFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */