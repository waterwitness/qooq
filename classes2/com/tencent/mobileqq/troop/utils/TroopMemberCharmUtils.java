package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.Calendar;

public class TroopMemberCharmUtils
{
  public static final int a = 1;
  protected static LruCache a = new LruCache(4);
  public static final String a = "http://qun.qq.com/qunpay/gifts/charm.html?from=31&_wv=1031&_bid=2204&uin=";
  public static final int b = 2;
  protected static LruCache b = new LruCache(4);
  public static final String b = "http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_aio.png";
  public static final int c = 4;
  public static final String c = "http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_card.png";
  protected static final int d = 4;
  public static final String d = "glamour_has_update_today";
  public static final String e = "glamour_updated";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static Drawable a(int paramInt1, int paramInt2)
  {
    Object localObject = null;
    Drawable localDrawable;
    if (paramInt2 == 1)
    {
      localDrawable = (Drawable)a.get(Integer.valueOf(paramInt1));
      localObject = localDrawable;
      if (localDrawable == null)
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        localObject = URLDrawable.getDrawable(String.format("http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_aio.png", new Object[] { Integer.valueOf(paramInt1) }), (URLDrawable.URLDrawableOptions)localObject);
        a.put(Integer.valueOf(paramInt1), localObject);
      }
    }
    do
    {
      do
      {
        return (Drawable)localObject;
      } while (paramInt2 != 2);
      localDrawable = (Drawable)b.get(Integer.valueOf(paramInt1));
      localObject = localDrawable;
    } while (localDrawable != null);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    localObject = URLDrawable.getDrawable(String.format("http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_card.png", new Object[] { Integer.valueOf(paramInt1) }), (URLDrawable.URLDrawableOptions)localObject);
    b.put(Integer.valueOf(paramInt1), localObject);
    return (Drawable)localObject;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return "http://qun.qq.com/qunpay/gifts/charm.html?from=31&_wv=1031&_bid=2204&uin=" + paramString1 + "&gc=" + paramString2;
  }
  
  protected static void a()
  {
    int i = 0;
    while (i < 4)
    {
      a.remove(Integer.valueOf(i));
      URLDrawable.removeMemoryCacheByUrl(String.format("http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_aio.png", new Object[] { Integer.valueOf(i) }));
      b.remove(Integer.valueOf(i));
      URLDrawable.removeMemoryCacheByUrl(String.format("http://pub.idqqimg.com/pc/misc/groupgift/charminglevel_%1$s_card.png", new Object[] { Integer.valueOf(i) }));
      i += 1;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if ("glamour_updated".equals(SharePreferenceUtils.a(paramContext, "glamour_has_update_today"))) {
      return false;
    }
    long l = NetConnInfoCenter.getServerTime();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l * 1000L);
    if (localCalendar.get(11) >= 4)
    {
      a();
      SharePreferenceUtils.a(paramContext, "glamour_has_update_today", "glamour_updated");
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\utils\TroopMemberCharmUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */