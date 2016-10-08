package com.tencent.bitapp.bundle;

import android.text.TextUtils;
import com.facebook.react.devsupport.DevSupportManager;
import com.tencent.bitapp.module.Module;
import com.tencent.bitapp.module.ModuleDependency;
import com.tencent.bitapp.pre.PreConst;
import com.tencent.bitapp.utils.FileUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

public class Bundle
{
  public static final int base = 1;
  public static final String baseStr = String.valueOf(1);
  private final String[] mBundles;
  private String mFile = null;
  private String mFileMd5 = null;
  private boolean mIsForceUpdate = false;
  private String mKey = null;
  
  public Bundle(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, false);
  }
  
  public Bundle(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.mKey = paramString1;
    this.mFile = paramString2;
    this.mFileMd5 = paramString3;
    int i;
    if ((paramBoolean) || (DevSupportManager.isSupportDevMode()))
    {
      paramString1 = null;
      if (paramString1 != null)
      {
        this.mBundles = new String[paramString1.size() + 1];
        i = 0;
        paramString1 = paramString1.iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!paramString1.hasNext())
        {
          this.mBundles[i] = this.mFile;
          return;
          paramString1 = ModuleDependency.INSTANCE.getDependencies(paramString1);
          break;
        }
        paramString2 = (String)paramString1.next();
        this.mBundles[i] = getFile(paramString2);
        i += 1;
      }
    }
    this.mBundles = new String[1];
    this.mBundles[0] = this.mFile;
  }
  
  public static boolean combin(String paramString)
  {
    boolean bool = false;
    StringBuilder localStringBuilder = combineOnlyModule(paramString);
    if (!TextUtils.isEmpty(localStringBuilder))
    {
      if (!isBase(paramString)) {
        localStringBuilder.append(";require(\"").append(paramString).append("\");");
      }
      bool = FileUtils.writeFile(localStringBuilder.toString(), getFile(paramString));
    }
    return bool;
  }
  
  private static StringBuilder combineOnlyModule(String paramString)
  {
    return FileUtils.readFileByBytes(Module.getJsFile(paramString), "utf-8");
  }
  
  public static String getFile(String paramString)
  {
    return PreConst.DEFAULT_OUT_MODULES_SAVE_FOLDER + File.separator + paramString + ".bundle";
  }
  
  public static boolean isBase(String paramString)
  {
    return paramString.equals(baseStr);
  }
  
  public String[] getBundles()
  {
    return this.mBundles;
  }
  
  public String getFile()
  {
    return this.mFile;
  }
  
  public String getFileMd5()
  {
    return this.mFileMd5;
  }
  
  public String getKey()
  {
    return this.mKey;
  }
  
  public boolean isForceUpdate()
  {
    return this.mIsForceUpdate;
  }
  
  public void setForceUpdate(boolean paramBoolean)
  {
    this.mIsForceUpdate = paramBoolean;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\bundle\Bundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */