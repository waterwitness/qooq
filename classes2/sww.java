import android.net.Uri;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;

public final class sww
  implements HookMethodCallback
{
  public sww()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    paramMethodHookParam = ((Uri)paramMethodHookParam.args[0]).toString();
    if ((paramMethodHookParam.contains(ContactsContract.RawContacts.CONTENT_URI.toString())) || (paramMethodHookParam.contains(ContactsContract.Data.CONTENT_URI.toString())))
    {
      paramMethodHookParam = new StringBuilder(1000);
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      int i = 0;
      while (i < arrayOfStackTraceElement.length)
      {
        paramMethodHookParam.append(arrayOfStackTraceElement[i] + "-");
        i += 1;
      }
      QLog.d("ContactDelete", 1, paramMethodHookParam.toString());
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\sww.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */