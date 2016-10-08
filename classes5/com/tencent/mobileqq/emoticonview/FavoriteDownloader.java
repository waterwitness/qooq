package com.tencent.mobileqq.emoticonview;

import android.app.Application;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import java.net.MalformedURLException;
import java.net.URL;

public class FavoriteDownloader
  extends AlbumThumbDownloader
{
  public static final String a = "favorite";
  public static final String b = "FavoriteDownloader";
  
  public FavoriteDownloader(Application paramApplication)
  {
    super(paramApplication);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static URL a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("favorite");
    localStringBuilder.append("://");
    localStringBuilder.append(paramString1);
    if (paramString2 != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString2);
    }
    try
    {
      paramString1 = new URL(localStringBuilder.toString());
      return paramString1;
    }
    catch (MalformedURLException paramString1) {}
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\FavoriteDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */