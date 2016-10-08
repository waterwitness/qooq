import android.text.TextUtils;
import com.tencent.mobileqq.app.DiscussionIconHelper;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.qcall.QCallDetailActivity;
import com.tencent.qphone.base.util.QLog;

public class tzp
  extends DiscussionObserver
{
  public tzp(QCallDetailActivity paramQCallDetailActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a).equals(paramString)) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramString);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QCallDetailActivity", 2, " === onUpdateDiscussionFaceIcon isSuccess | " + paramBoolean1 + ", disUin | " + paramString + ",isComplete | " + paramBoolean2);
    }
    if ((paramBoolean1) && (paramBoolean2) && (QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a) == 3000))
    {
      String str = paramString;
      if (DiscussionIconHelper.a(paramString)) {
        str = DiscussionIconHelper.b(paramString);
      }
      if (QCallDetailActivity.a(this.a).equals(str))
      {
        this.a.a(QCallDetailActivity.a(this.a));
        if (QLog.isColorLevel()) {
          QLog.i("QCallDetailActivity", 2, "==== onUpdateDiscussionFaceIcon updateUin ===");
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    paramArrayOfObject = (String)paramArrayOfObject[0];
    if ((QCallDetailActivity.a(this.a) != null) && (QCallDetailActivity.a(this.a).equals(paramArrayOfObject)) && (paramBoolean) && (QCallDetailActivity.a(this.a) == 3000)) {
      this.a.a(paramArrayOfObject);
    }
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(QCallDetailActivity.a(this.a))) && (QCallDetailActivity.a(this.a).equals(paramString)) && (!this.a.isFinishing())) {
      this.a.finish();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */