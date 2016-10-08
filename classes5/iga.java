import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class iga
  implements Runnable
{
  public iga(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    try
    {
      Object localObject = new Bundle();
      String str = String.format("http://c.mp.qq.com/post/pageview/report?ftype=5&ctype=1&aid=%s&vid=%s&rtype=%d", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int) });
      ((Bundle)localObject).putString("Cookie", "uin=" + this.c + "; skey=" + this.d);
      HashMap localHashMap = new HashMap();
      localHashMap.put("BUNDLE", localObject);
      localHashMap.put("CONTEXT", BaseApplicationImpl.a());
      igb localigb = new igb(this);
      localObject = str;
      if (this.jdField_a_of_type_Int == 1) {
        localObject = str + "&rcode=" + Integer.toString(this.jdField_b_of_type_Int);
      }
      if (QLog.isColorLevel()) {
        QLog.i("PublicAccountUtil", 2, "doVideoPlayRealtimeReport cgiUrl=" + (String)localObject);
      }
      new HttpWebCgiAsyncTask2((String)localObject, "GET", localigb, 0, null).execute(new HashMap[] { localHashMap });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:request err " + localException);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\iga.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */