package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.tencent.filter.Param.Float1sParam;
import com.tencent.filter.Param.Float2fParam;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.Param.TextureBitmapParam;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.List;

public class CustomVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = CustomVideoFilter.class.getSimpleName();
  private float frameStartTime;
  private List<NormalVideoFilter> normalFilters;
  private VideoMaterialUtil.TRIGGER_TYPE triggerType;
  
  public CustomVideoFilter(String paramString1, String paramString2, List<String> paramList, VideoMaterialUtil.TRIGGER_TYPE paramTRIGGER_TYPE, String paramString3)
  {
    super(paramString1, paramString2, null);
    this.dataPath = paramString3;
    this.triggerType = paramTRIGGER_TYPE;
    if (this.triggerType == null) {
      this.triggerType = VideoMaterialUtil.TRIGGER_TYPE.UNKNOW;
    }
    initParams();
    initTextureParams(paramList);
  }
  
  private void initTextureParams(List<String> paramList)
  {
    if (VideoUtil.isEmpty(paramList)) {
      return;
    }
    int i = 0;
    label10:
    Object localObject;
    if (i < paramList.size())
    {
      localObject = (String)paramList.get(i);
      localObject = this.dataPath + File.separator + (String)localObject;
      if (!((String)localObject).startsWith("assets://")) {
        break label99;
      }
      localObject = VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath((String)localObject), MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      label85:
      if (VideoBitmapUtil.isLegal((Bitmap)localObject)) {
        break label113;
      }
    }
    for (;;)
    {
      i += 1;
      break label10;
      break;
      label99:
      localObject = VideoBitmapUtil.decodeSampledBitmapFromFile((String)localObject, MediaConfig.VIDEO_IMAGE_WIDTH, MediaConfig.VIDEO_IMAGE_HEIGHT);
      break label85;
      label113:
      addParam(new Param.TextureBitmapParam("inputImageTexture" + (i + 1), (Bitmap)localObject, 33985 + i, true));
    }
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setTexCords(VideoFilterUtil.ORIGIN_TEX_COORDS);
    this.frameStartTime = ((float)System.currentTimeMillis());
  }
  
  public float[] getElementDurations(long paramLong)
  {
    Object localObject;
    if (VideoUtil.isEmpty(this.normalFilters))
    {
      localObject = new float[0];
      return (float[])localObject;
    }
    float[] arrayOfFloat = new float[this.normalFilters.size()];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfFloat;
      if (i >= this.normalFilters.size()) {
        break;
      }
      arrayOfFloat[i] = ((NormalVideoFilter)this.normalFilters.get(i)).getFrameDuration(paramLong);
      i += 1;
    }
  }
  
  public void initParams()
  {
    addParam(new Param.Float2fParam(VideoFilterBase.SHADER_FIELD.CANVAS_SIZE.name, 0.0F, 0.0F));
    addParam(new Param.Float2fParam(VideoFilterBase.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, 0.0F, 0.0F));
    addParam(new Param.Float1sParam(VideoFilterBase.SHADER_FIELD.FACE_POINT.name, new float[0]));
    addParam(new Param.IntParam(VideoFilterBase.SHADER_FIELD.FACE_ACTION_TYPE.name, 0));
    addParam(new Param.FloatParam(VideoFilterBase.SHADER_FIELD.FRAME_DURATION.name, 0.0F));
    addParam(new Param.Float1sParam(VideoFilterBase.SHADER_FIELD.ELEMENT_DURATIONS.name, new float[0]));
  }
  
  public void setNormalFilters(List<NormalVideoFilter> paramList)
  {
    this.normalFilters = paramList;
  }
  
  public void updatePreview(List<PointF> paramList, float paramFloat1, float paramFloat2, long paramLong)
  {
    int i = 0;
    if (VideoPreviewFaceOutlineDetector.getInstance().detectExpression(this.triggerType.value)) {
      i = this.triggerType.value;
    }
    for (;;)
    {
      addParam(new Param.IntParam(VideoFilterBase.SHADER_FIELD.FACE_ACTION_TYPE.name, i));
      addParam(new Param.FloatParam(VideoFilterBase.SHADER_FIELD.FRAME_DURATION.name, ((float)System.currentTimeMillis() - this.frameStartTime) / 1000.0F));
      paramList = VideoMaterialUtil.toFlatArray(paramList);
      if (paramList != null) {
        addParam(new Param.Float1sParam(VideoFilterBase.SHADER_FIELD.FACE_POINT.name, VideoMaterialUtil.flipYPoints(paramList, (int)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT))));
      }
      addParam(new Param.Float1sParam(VideoFilterBase.SHADER_FIELD.ELEMENT_DURATIONS.name, getElementDurations(paramLong)));
      return;
      if (VideoPreviewFaceOutlineDetector.getInstance().detectExpression(VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value)) {
        i = VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value;
      }
    }
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new Param.Float2fParam(VideoFilterBase.SHADER_FIELD.CANVAS_SIZE.name, paramInt1, paramInt2));
    addParam(new Param.Float2fParam(VideoFilterBase.SHADER_FIELD.FACE_DETECT_IMAGE_SIZE.name, (float)(this.width * VideoMaterialUtil.SCALE_FACE_DETECT), (float)(this.height * VideoMaterialUtil.SCALE_FACE_DETECT)));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\filter\CustomVideoFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */