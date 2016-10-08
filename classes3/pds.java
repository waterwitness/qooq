import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pds
  implements Runnable
{
  pds(pdn parampdn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    RMVideoStateMgr.a().b(0, "麦克风参数初始化失败", false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pds.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */