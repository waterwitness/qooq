package com.facebook.stetho.common.android;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.facebook.stetho.common.LogUtil;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ResourcesUtil
{
  private static String getFallbackIdString(int paramInt)
  {
    return "#" + Integer.toHexString(paramInt);
  }
  
  public static String getIdString(@Nullable Resources paramResources, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramResources == null) {
      return getFallbackIdString(paramInt);
    }
    String str1;
    switch (getResourcePackageId(paramInt))
    {
    default: 
      str1 = paramResources.getResourcePackageName(paramInt);
    }
    for (String str2 = ":";; str2 = "")
    {
      String str3 = paramResources.getResourceTypeName(paramInt);
      paramResources = paramResources.getResourceEntryName(paramInt);
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 1 + str2.length() + str3.length() + 1 + paramResources.length());
      localStringBuilder.append("@");
      localStringBuilder.append(str1);
      localStringBuilder.append(str2);
      localStringBuilder.append(str3);
      localStringBuilder.append("/");
      localStringBuilder.append(paramResources);
      return localStringBuilder.toString();
      str1 = "";
    }
  }
  
  @Nonnull
  public static String getIdStringQuietly(Object paramObject, @Nullable Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = getIdString(paramResources, paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources)
    {
      paramResources = getFallbackIdString(paramInt);
      LogUtil.w("Unknown identifier encountered on " + paramObject + ": " + paramResources);
    }
    return paramResources;
  }
  
  private static int getResourcePackageId(int paramInt)
  {
    return paramInt >>> 24 & 0xFF;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\common\android\ResourcesUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */