package cooperation.qqhotspot;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.Base64Util;

public class QQHotSpotHelper
{
  public QQHotSpotHelper()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    if (paramString.contains("?")) {
      return paramString + "&_wv=1024";
    }
    return paramString + "?_wv=1024";
  }
  
  private static String b(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() == 0)) {
      return null;
    }
    try
    {
      paramString = new String(Base64Util.decode(paramString, 0), "UTF-16LE");
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qqhotspot\QQHotSpotHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */