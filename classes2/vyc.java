import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.FaceDrawableImpl;
import com.tencent.mobileqq.util.FaceDrawableImpl.DisFaceObserver;
import com.tencent.qphone.base.util.QLog;

public class vyc
  implements FaceDrawableImpl.DisFaceObserver
{
  private vyc(FaceDrawableImpl paramFaceDrawableImpl)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    int i;
    if (DiscussionIconHelper.a(paramString)) {
      i = 1001;
    }
    for (String str = DiscussionIconHelper.b(paramString);; str = paramString)
    {
      if (paramBoolean2) {
        this.a.a(paramBoolean1, i, str, this.a.a);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.FaceDrawableImpl", 2, "====faceDrawableImpl onUpdateDiscussionFaceIcon === isSuccess: " + paramBoolean1 + ", isComplete: " + paramBoolean2 + ",disUin: " + paramString + ",type: " + i);
        }
        return;
        this.a.a(paramBoolean1, i, str, null);
      }
      i = 101;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\vyc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */