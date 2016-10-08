import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class pfa
  implements Runnable
{
  public pfa(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity, int paramInt)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    SosoInterface.a(new pfb(this, 0, false, true, 60000L, false, false, "CreateFaceToFaceDiscussionActivity"));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */