import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class igz
  implements INetEventHandler
{
  private igz(VideoServerInfoManager paramVideoServerInfoManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    Bosses.get().postLightWeightJob(new iha(this), 1000);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\igz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */