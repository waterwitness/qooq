package com.tencent.mobileqq.shortvideo.ptvfilter.material;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.VideoTemplateParser;
import usg;

public class TemplateParser
{
  private static final DecryptListener a = new usg();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static VideoMaterial a(String paramString1, String paramString2)
  {
    VideoMaterial localVideoMaterial2 = VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, false, a);
    VideoMaterial localVideoMaterial1 = localVideoMaterial2;
    if (localVideoMaterial2.getMinAppVersion() == 0) {
      localVideoMaterial1 = VideoTemplateParser.parseVideoMaterial(paramString1, paramString2, true, a);
    }
    return localVideoMaterial1;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\shortvideo\ptvfilter\material\TemplateParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */