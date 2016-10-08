import com.tencent.biz.qqstory.base.preload.storylist.DelayUpdateDownloadQueueJob;
import com.tencent.biz.qqstory.base.preload.storylist.PreloadVideoSource;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;

public class ihz
  implements INetEventHandler
{
  private ihz(PreloadVideoSource paramPreloadVideoSource)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    this.a.a.a(4000);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ihz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */