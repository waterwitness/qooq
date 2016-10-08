package cooperation.qqfav.content;

import android.net.Uri;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public abstract interface Favorites
{
  public static final Uri a = Uri.parse("content://qq.favorites/biz_related");
  public static final String a = "qq.favorites";
  public static final Uri b = Uri.parse("content://qq.favorites/global_search");
  public static final String b = "content://qq.favorites/";
  public static final String c = "biz_related";
  public static final String d = "global_search";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\cooperation\qqfav\content\Favorites.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */