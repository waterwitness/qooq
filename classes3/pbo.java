import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class pbo
  implements Runnable
{
  pbo(pbn parampbn)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (this.a.a.j)
    {
      NewFlowCameraActivity.b(this.a.a, false);
      return;
    }
    NewFlowCameraActivity.c(this.a.a, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */