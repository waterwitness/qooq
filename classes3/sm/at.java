package sm;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.securemodule.service.ProductInfo;

public class at
{
  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    return paramContext.getSharedPreferences("secure_config", 0).getInt(a(paramInt1), paramInt2);
  }
  
  private static String a(int paramInt)
  {
    return String.format("%5d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String a(Context paramContext, int paramInt, String paramString)
  {
    return paramContext.getSharedPreferences("secure_config", 0).getString(a(paramInt), paramString);
  }
  
  public static void a(Context paramContext, ProductInfo paramProductInfo)
  {
    paramContext = paramContext.getSharedPreferences("secure_config", 0).edit();
    paramContext.putInt(a(30003), paramProductInfo.getProductId());
    paramContext.putString(a(30001), paramProductInfo.getVersion());
    paramContext.putInt(a(30004), paramProductInfo.getBuildNo());
    paramContext.putInt(a(30005), paramProductInfo.getSubPlatformId());
    paramContext.putString(a(30002), paramProductInfo.getChannelId());
    paramContext.putString(a(30006), paramProductInfo.getQq());
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    return paramContext.getSharedPreferences("secure_config", 0).getBoolean(a(paramInt), paramBoolean);
  }
  
  public static void b(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = paramContext.getSharedPreferences("secure_config", 0).edit();
    paramContext.putInt(a(paramInt1), paramInt2);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("secure_config", 0).edit();
    paramContext.putString(a(paramInt), paramString);
    paramContext.commit();
  }
  
  public static void b(Context paramContext, int paramInt, boolean paramBoolean)
  {
    paramContext = paramContext.getSharedPreferences("secure_config", 0).edit();
    paramContext.putBoolean(a(paramInt), paramBoolean);
    paramContext.commit();
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\sm\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */