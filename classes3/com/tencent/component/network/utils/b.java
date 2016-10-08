package com.tencent.component.network.utils;

import android.content.Context;
import java.io.File;

final class b
  implements FileUtils.AssetFileComparator
{
  public final boolean equals(Context paramContext, String paramString, File paramFile)
  {
    long l = FileUtils.getAssetLength(paramContext, paramString);
    return (l != -1L) && (l == paramFile.length());
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\component\network\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */