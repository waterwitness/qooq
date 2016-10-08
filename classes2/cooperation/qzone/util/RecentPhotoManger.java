package cooperation.qzone.util;

import android.text.TextUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentPhotoManger
{
  public static final int a = 500;
  public static final long a = 86400000L;
  public static final String a = "key_shuoshuo_recent_photo_blacklist";
  public static final int b = 0;
  public static final String b = "key_personal_album_recent_photo_blacklist";
  public static final int c = 1;
  public static final String c = "key_banner_recent_photo_blacklist";
  public static final int d = 2;
  public static final String d = "key_bubble_recent_photo_blacklist";
  public static final int e = 3;
  
  public RecentPhotoManger()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private static String a(List paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(";");
    }
    return localStringBuilder.toString();
  }
  
  public static List a(String paramString)
  {
    return a(paramString, 500);
  }
  
  public static List a(String paramString, int paramInt)
  {
    int i = 0;
    paramString = LocalMultiProcConfig.a(paramString, "").split(";");
    LinkedList localLinkedList = new LinkedList();
    if ((paramString.length == 0) || (paramInt <= 0)) {
      return localLinkedList;
    }
    int k;
    for (int j = 0;; j = k)
    {
      if (i < paramString.length)
      {
        CharSequence localCharSequence = paramString[i];
        k = j;
        if (!TextUtils.isEmpty(localCharSequence))
        {
          localLinkedList.add(localCharSequence);
          k = j + 1;
        }
        if (k != paramInt) {}
      }
      else
      {
        return localLinkedList;
      }
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    List localList;
    do
    {
      return;
      localList = a(paramString1, 500);
    } while (localList.contains(paramString2));
    localList.add(0, paramString2);
    if (localList.size() > 500) {
      localList.remove(500);
    }
    LocalMultiProcConfig.a(paramString1, a(localList));
  }
  
  public static void a(String paramString, List paramList)
  {
    if (paramList == null) {
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    List localList = a(paramString, 500 - paramList.size());
    localLinkedList.addAll(paramList);
    localLinkedList.addAll(localList);
    LocalMultiProcConfig.a(paramString, a(localLinkedList));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qzone\util\RecentPhotoManger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */