package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.ttpic.filter.CustomVertexFilter;
import com.tencent.ttpic.filter.CustomVideoFilter;
import com.tencent.ttpic.filter.FaceMoveFilter;
import com.tencent.ttpic.filter.FaceOffByImageFilter;
import com.tencent.ttpic.filter.FaceOffFilter;
import com.tencent.ttpic.filter.NormalVideoFilter;
import com.tencent.ttpic.filter.SnakeFaceFilter;
import com.tencent.ttpic.filter.TransformFilter;
import com.tencent.ttpic.filter.VideoFilterBase;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.filter.VideoFlipFilter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class VideoFilterUtil
{
  public static final float[] EMPTY_POSITIONS = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static final String FRAGMENT_SHADER_COMMON;
  public static final int IMAGE_HEIGHT = 960;
  public static final int IMAGE_WIDTH = 720;
  public static final float[] ORIGIN_TEX_COORDS = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  public static final double SCREEN_RATIO = 0.75D;
  public static final int SHOW_ONCE_TEX_COUNT = 2;
  public static final String SIMPLE_VERTEX_SHADER;
  public static final String VERTEX_SHADER_COMMON = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonVertexShader.dat");
  
  static
  {
    FRAGMENT_SHADER_COMMON = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/MCCommonFragmentShader.dat");
    SIMPLE_VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/SimpleVertexShader.dat");
  }
  
  @Nullable
  private static CustomVertexFilter createCustomVertexFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject4 = null;
    Object localObject3 = localObject4;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
    {
      Object localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      localObject3 = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = SIMPLE_VERTEX_SHADER;
      }
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = SnakeFaceFilter.FRAGMENT_SHADER;
      }
      localObject3 = localObject4;
      if (!VideoUtil.isEmpty(paramVideoMaterial.getItemList())) {
        localObject3 = new CustomVertexFilter((String)localObject1, (String)localObject2, null);
      }
    }
    return (CustomVertexFilter)localObject3;
  }
  
  @Nullable
  private static CustomVideoFilter createCustomVideoFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject1 = null;
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value))
    {
      Object localObject2 = VideoMaterialUtil.loadVertexShader(paramVideoMaterial.getDataPath());
      String str = VideoMaterialUtil.loadFragmentShader(paramVideoMaterial.getDataPath());
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = VERTEX_SHADER_COMMON;
      }
      localObject2 = str;
      if (TextUtils.isEmpty(str)) {
        localObject2 = FRAGMENT_SHADER_COMMON;
      }
      localObject1 = new CustomVideoFilter((String)localObject1, (String)localObject2, paramVideoMaterial.getResourceList(), getCustomFilterTriggerType(paramVideoMaterial.getItemList()), paramVideoMaterial.getDataPath());
    }
    return (CustomVideoFilter)localObject1;
  }
  
  @Nullable
  private static VideoFilterBase createFaceOffFilter(VideoMaterial paramVideoMaterial)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
    {
      localObject1 = localObject2;
      if (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) {}
    }
    else
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramVideoMaterial.getFaceExchangeImage()))
      {
        localObject1 = new FaceItem(paramVideoMaterial.getFaceExchangeImage(), (float)paramVideoMaterial.getBlendAlpha(), paramVideoMaterial.getGrayScale(), paramVideoMaterial.getFeatureType(), paramVideoMaterial.getFacePoints());
        if (paramVideoMaterial.getFaceoffType() != VideoMaterialUtil.FACE_OFF_TYPE.BY_IMAGE.value) {
          break label95;
        }
        localObject1 = new FaceOffByImageFilter((FaceItem)localObject1);
      }
    }
    return (VideoFilterBase)localObject1;
    label95:
    return new FaceOffFilter((FaceItem)localObject1, paramVideoMaterial.getDataPath());
  }
  
  public static VideoFilterList createFilters(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {
      return null;
    }
    Object localObject2 = createCustomVideoFilter(paramVideoMaterial);
    CustomVertexFilter localCustomVertexFilter = createCustomVertexFilter(paramVideoMaterial);
    SnakeFaceFilter localSnakeFaceFilter = createSnakeFaceFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase2 = createFaceOffFilter(paramVideoMaterial);
    VideoFilterBase localVideoFilterBase1 = createTransformFilter(paramVideoMaterial);
    Object localObject1 = createNormalVideoFilterList(paramVideoMaterial);
    if (localObject2 != null) {
      ((CustomVideoFilter)localObject2).setNormalFilters((List)localObject1);
    }
    VideoFilterList localVideoFilterList = new VideoFilterList();
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.NORMAL.value) {
      localArrayList.addAll((Collection)localObject1);
    }
    for (;;)
    {
      setLoadImageFromCache(localArrayList, paramVideoMaterial.isLoadImageFromCache());
      localVideoFilterList.setFilters(localArrayList);
      localVideoFilterList.setMaterial(paramVideoMaterial);
      return localVideoFilterList;
      if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.COMMON_BEFORE_CUSTOM.value)
      {
        localArrayList.addAll((Collection)localObject1);
        localArrayList.add(localObject2);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value)
      {
        localArrayList.add(localObject2);
        localArrayList.addAll((Collection)localObject1);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value)
      {
        localArrayList.add(localSnakeFaceFilter);
        localArrayList.addAll((Collection)localObject1);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_VERTEX_SHADER.value)
      {
        localArrayList.add(localCustomVertexFilter);
        localArrayList.addAll((Collection)localObject1);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value)
      {
        if (localVideoFilterBase2 != null) {
          localArrayList.add(localVideoFilterBase2);
        }
        localArrayList.addAll((Collection)localObject1);
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value)
      {
        if (localVideoFilterBase1 != null)
        {
          localObject2 = VideoFlipFilter.createVideoFlipFilter();
          localArrayList.add(localObject2);
          localArrayList.add(localVideoFilterBase1);
          localArrayList.add(localObject2);
          localArrayList.addAll((Collection)localObject1);
        }
      }
      else if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value)
      {
        if (paramVideoMaterial.getOrderMode() <= 1)
        {
          if (localVideoFilterBase2 != null) {
            localArrayList.add(localVideoFilterBase2);
          }
          if (localVideoFilterBase1 != null)
          {
            localObject2 = VideoFlipFilter.createVideoFlipFilter();
            localArrayList.add(localObject2);
            localArrayList.add(localVideoFilterBase1);
            localArrayList.add(localObject2);
          }
          localArrayList.addAll((Collection)localObject1);
        }
        else if (paramVideoMaterial.getOrderMode() == 2)
        {
          localArrayList.addAll((Collection)localObject1);
          if (localVideoFilterBase2 != null) {
            localArrayList.add(localVideoFilterBase2);
          }
          if (localVideoFilterBase1 != null)
          {
            localObject1 = VideoFlipFilter.createVideoFlipFilter();
            localArrayList.add(localObject1);
            localArrayList.add(localVideoFilterBase1);
            localArrayList.add(localObject1);
          }
        }
      }
    }
  }
  
  @Nullable
  private static List<NormalVideoFilter> createNormalVideoFilterList(VideoMaterial paramVideoMaterial)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        NormalVideoFilter localNormalVideoFilter = VideoFilterFactory.createFilter((StickerItem)localIterator.next(), paramVideoMaterial.getDataPath());
        if (localNormalVideoFilter != null) {
          localArrayList.add(localNormalVideoFilter);
        }
      }
    }
    return localArrayList;
  }
  
  @Nullable
  private static SnakeFaceFilter createSnakeFaceFilter(VideoMaterial paramVideoMaterial)
  {
    SnakeFaceFilter localSnakeFaceFilter = null;
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) {
      localSnakeFaceFilter = new SnakeFaceFilter();
    }
    return localSnakeFaceFilter;
  }
  
  private static VideoFilterBase createTransformFilter(VideoMaterial paramVideoMaterial)
  {
    TransformFilter localTransformFilter = null;
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value))
    {
      if (!VideoUtil.isEmpty(paramVideoMaterial.getDistortionItemList())) {
        localTransformFilter = new TransformFilter(paramVideoMaterial.getDistortionItemList());
      }
    }
    else {
      return localTransformFilter;
    }
    return new FaceMoveFilter(paramVideoMaterial.getFaceMoveItemList(), paramVideoMaterial.getFaceMoveTriangles());
  }
  
  private static List<NormalVideoFilter> filtersToList(NormalVideoFilter paramNormalVideoFilter)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramNormalVideoFilter == null) {}
    for (;;)
    {
      return localArrayList;
      while (paramNormalVideoFilter != null)
      {
        localArrayList.add(paramNormalVideoFilter);
        paramNormalVideoFilter = (NormalVideoFilter)paramNormalVideoFilter.getmNextFilter();
      }
    }
  }
  
  public static double get4DirectionAngle(double paramDouble)
  {
    if ((paramDouble >= -0.7853981633974483D) && (paramDouble <= 0.7853981633974483D)) {
      return 0.0D;
    }
    if ((paramDouble >= 0.7853981633974483D) && (paramDouble <= 2.356194490192345D)) {
      return 1.5707963267948966D;
    }
    if ((paramDouble >= -2.356194490192345D) && (paramDouble <= -0.7853981633974483D)) {
      return -1.5707963267948966D;
    }
    return -3.141592653589793D;
  }
  
  public static double get8DirectionAngle(double paramDouble)
  {
    if ((paramDouble >= -0.39269908169872414D) && (paramDouble <= 0.39269908169872414D)) {
      return 0.0D;
    }
    if ((paramDouble >= 0.39269908169872414D) && (paramDouble <= 1.1780972450961724D)) {
      return 0.7853981633974483D;
    }
    if ((paramDouble >= 1.1780972450961724D) && (paramDouble <= 1.9634954084936207D)) {
      return 1.5707963267948966D;
    }
    if ((paramDouble >= 1.9634954084936207D) && (paramDouble <= 2.748893571891069D)) {
      return 2.356194490192345D;
    }
    if ((paramDouble >= -1.1780972450961724D) && (paramDouble <= -0.39269908169872414D)) {
      return -0.7853981633974483D;
    }
    if ((paramDouble >= -1.9634954084936207D) && (paramDouble <= -1.1780972450961724D)) {
      return -1.5707963267948966D;
    }
    if ((paramDouble >= -2.748893571891069D) && (paramDouble <= -1.9634954084936207D)) {
      return -2.356194490192345D;
    }
    return -3.141592653589793D;
  }
  
  private static VideoMaterialUtil.TRIGGER_TYPE getCustomFilterTriggerType(List<StickerItem> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return VideoMaterialUtil.TRIGGER_TYPE.UNKNOW;
    }
    int i = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW.value;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramList.next();
      if (localStickerItem.triggerType > i) {
        i = localStickerItem.triggerType;
      }
    }
    return VideoMaterialUtil.getTriggerType(i);
  }
  
  public static Frame getSecondLastFrame(Frame paramFrame)
  {
    Frame localFrame;
    if ((!FrameUtil.isValid(paramFrame)) || (!FrameUtil.isValid(paramFrame.nextFrame)))
    {
      localFrame = null;
      return localFrame;
    }
    for (;;)
    {
      localFrame = paramFrame;
      if (!FrameUtil.isValid(paramFrame.nextFrame)) {
        break;
      }
      localFrame = paramFrame;
      if (!FrameUtil.isValid(paramFrame.nextFrame.nextFrame)) {
        break;
      }
      paramFrame = paramFrame.nextFrame;
    }
  }
  
  public static boolean isValid(VideoFilterList paramVideoFilterList)
  {
    return (paramVideoFilterList != null) && (paramVideoFilterList.isValid());
  }
  
  public static boolean needBlendMode(List<VideoFilterBase> paramList)
  {
    if (paramList == null) {}
    do
    {
      while (!paramList.hasNext())
      {
        return false;
        paramList = paramList.iterator();
      }
    } while (!((VideoFilterBase)paramList.next() instanceof NormalVideoFilter));
    return true;
  }
  
  public static void setBlendMode(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      GLES20.glEnable(3042);
      GLES20.glBlendFunc(1, 771);
      return;
    }
    GLES20.glDisable(3042);
  }
  
  private static void setLoadImageFromCache(List<VideoFilterBase> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoFilterBase)paramList.next()).setLoadImageFromCache(paramBoolean);
      }
    }
  }
  
  public static void setRenderMode(BaseFilter paramBaseFilter, int paramInt)
  {
    while (paramBaseFilter != null)
    {
      paramBaseFilter.setRenderMode(paramInt);
      paramBaseFilter = paramBaseFilter.getmNextFilter();
    }
  }
  
  public static void setRenderMode(List<VideoFilterBase> paramList, int paramInt)
  {
    if (VideoUtil.isEmpty(paramList)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((VideoFilterBase)paramList.next()).setRenderMode(paramInt);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoFilterUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */