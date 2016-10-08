package com.tencent.mobileqq.richmedia;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import java.util.concurrent.ConcurrentHashMap;

public class VideoCompoundController
{
  static final String a = "VideoCompoundController";
  public ConcurrentHashMap a;
  
  public VideoCompoundController()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.a = new ConcurrentHashMap(10);
  }
  
  public CompoundProcessor a(SVHwEncoder paramSVHwEncoder, SessionInfo paramSessionInfo, int paramInt)
  {
    paramSVHwEncoder = new CompoundProcessor(paramSVHwEncoder, paramSessionInfo, paramInt);
    this.a.put(paramSVHwEncoder.b, paramSVHwEncoder);
    LOG.a("VideoCompoundController", "newProcessor, key = " + paramSVHwEncoder.b);
    return paramSVHwEncoder;
  }
  
  public CompoundProcessor a(String paramString)
  {
    LOG.a("VideoCompoundController", "findProcessor, key = " + paramString);
    if ((!this.a.isEmpty()) && (paramString != null) && (this.a.containsKey(paramString))) {
      return (CompoundProcessor)this.a.get(paramString);
    }
    return null;
  }
  
  public void a(String paramString, CompoundProcessor paramCompoundProcessor)
  {
    LOG.a("VideoCompoundController", "addProcessor, key = " + paramString);
    this.a.put(paramString, paramCompoundProcessor);
  }
  
  public boolean a(String paramString)
  {
    LOG.a("VideoCompoundController", "removeProcessor, key = " + paramString);
    if (paramString == null) {}
    while (this.a.remove(paramString) == null) {
      return false;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richmedia\VideoCompoundController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */