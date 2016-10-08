import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceManager;

public class vyf
  extends DiscussionObserver
{
  private vyf(FaceManager paramFaceManager)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    this.a.b(1007, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), paramString });
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */