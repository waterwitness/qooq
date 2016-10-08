package com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.List;

public class DefaultDoodleStrategy
  implements DoodleStrategy
{
  public DefaultDoodleStrategy()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(List paramList, DoodleView paramDoodleView)
  {
    FaceLayer localFaceLayer = new FaceLayer(paramDoodleView);
    LineLayer localLineLayer = new LineLayer(paramDoodleView);
    paramDoodleView = new TextLayer(paramDoodleView);
    paramList.add(localFaceLayer);
    paramList.add(localLineLayer);
    paramList.add(paramDoodleView);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\doodle\layer\base\DefaultDoodleStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */