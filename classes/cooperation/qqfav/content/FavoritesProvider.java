package cooperation.qqfav.content;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppContentProvider;

public class FavoritesProvider
  extends AppContentProvider
  implements Favorites
{
  private static final int jdField_a_of_type_Int = 100;
  private static final int b = 101;
  private static final String e = "qqfav|FavoritesProvider";
  private static final String f = "com.qqfav.data.BizRelatedData$Proxy";
  private static final String g = "com.qqfav.data.BizRelatedData$GlobalSearchProxy";
  private UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  private Map jdField_a_of_type_JavaUtilMap;
  private String h;
  
  public FavoritesProvider()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private Favorites.IProxy a(Uri paramUri)
  {
    int k = this.jdField_a_of_type_AndroidContentUriMatcher.match(paramUri);
    if (k == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav|FavoritesProvider", 2, "getProxy| mismatch! uri=" + paramUri.toString());
      }
      return null;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    int i;
    if (Thread.currentThread().getId() == 1L) {
      i = 1;
    }
    for (;;)
    {
      int j = 0;
      label72:
      if ((localBaseApplicationImpl == null) && (i == 0) && (j < 5)) {
        try
        {
          Thread.sleep(10L);
          localBaseApplicationImpl = BaseApplicationImpl.a();
          j += 1;
          break label72;
          i = 0;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    Favorites.IProxy localIProxy;
    if (localInterruptedException != null)
    {
      QfavHelper.a(false);
      paramUri = paramUri.getLastPathSegment();
      if (!this.h.equals(paramUri)) {
        break label294;
      }
      localIProxy = (Favorites.IProxy)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(k));
      if (localIProxy == null) {
        break label250;
      }
      switch (k)
      {
      }
    }
    for (;;)
    {
      switch (k)
      {
      default: 
        return null;
        return null;
        if (localIProxy.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$Proxy"))
        {
          return localIProxy;
          if (localIProxy.getClass().getSimpleName().equals("com.qqfav.data.BizRelatedData$GlobalSearchProxy"))
          {
            return localIProxy;
            label250:
            if (QLog.isColorLevel())
            {
              QLog.e("qqfav|FavoritesProvider", 2, "getProxy|match cacheuin but provider null, match=" + k + ",uin=" + paramUri);
              continue;
              label294:
              this.jdField_a_of_type_JavaUtilMap.clear();
              this.h = paramUri;
              if (QLog.isDevelopLevel()) {
                QLog.e("qqfav|FavoritesProvider", 4, "getProxy|cache uin unmatch, match=" + k + ",uin=" + paramUri);
              }
            }
          }
        }
        break;
      }
    }
    for (paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$Proxy", null, null); paramUri != null; paramUri = (Favorites.IProxy)QfavHelper.a("com.qqfav.data.BizRelatedData$GlobalSearchProxy", null, null))
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(k), paramUri);
      return paramUri;
    }
    if (QLog.isColorLevel()) {
      QLog.e("qqfav|FavoritesProvider", 2, "getProxy|never should goto here");
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramString, paramArrayOfString);
    }
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramContentValues);
    }
    return null;
  }
  
  public boolean onCreate()
  {
    this.jdField_a_of_type_AndroidContentUriMatcher = new UriMatcher(-1);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.favorites", "biz_related/#", 100);
    this.jdField_a_of_type_AndroidContentUriMatcher.addURI("qq.favorites", "global_search/#", 101);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.h = "";
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (QLog.isDevelopLevel()) {
      QLog.d("qqfav|FavoritesProvider", 4, "query|" + localIProxy + ",uri=" + paramUri + ",selection=" + paramString1);
    }
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
    }
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    Favorites.IProxy localIProxy = a(paramUri);
    if (localIProxy != null) {
      return localIProxy.a(paramUri, paramContentValues, paramString, paramArrayOfString);
    }
    return 0;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qqfav\content\FavoritesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */