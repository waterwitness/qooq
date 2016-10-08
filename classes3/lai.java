import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

public class lai
  implements URLDrawable.URLDrawableListener
{
  public lai(ChatSettingForTroop paramChatSettingForTroop)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    try
    {
      paramURLDrawable = ImageUtil.a(paramURLDrawable);
      ChatSettingForTroop.b(this.a, this.a.c, paramURLDrawable);
      return;
    }
    catch (NullPointerException paramURLDrawable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.chatopttroop", 2, QLog.getStackTraceString(paramURLDrawable));
      return;
    }
    catch (OutOfMemoryError paramURLDrawable) {}
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */