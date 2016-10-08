import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class krt
  extends DiscussionObserver
{
  public krt(Call paramCall)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.i();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CallTab", 2, "call onUpdateDiscussionFaceIcon|[" + paramBoolean1 + ", " + paramBoolean2 + ", " + paramString + "]");
    }
    if (paramBoolean1) {
      this.a.i();
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    if ((paramBoolean) && (bool)) {
      this.a.i();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\krt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */