package com.tencent.bitapp.pre;

import android.content.Context;
import java.io.File;
import java.lang.ref.WeakReference;

public enum ContextUtils
{
  INSTANCE;
  
  private WeakReference<Context> mContext = null;
  
  private ContextUtils() {}
  
  public Context getApplicationContext()
  {
    if (this.mContext != null) {
      return (Context)this.mContext.get();
    }
    return null;
  }
  
  public void setApplicationContext(Context paramContext)
  {
    setApplicationContext(paramContext, paramContext.getFilesDir());
  }
  
  public void setApplicationContext(Context paramContext, File paramFile)
  {
    this.mContext = new WeakReference(paramContext);
    PreConst.DEFAULT_NODE_MODULES_SAVE_FOLDER = new File(paramFile, "/react/modules").getAbsolutePath();
    PreConst.DEFAULT_OUT_MODULES_SAVE_FOLDER = new File(paramFile, "/react/out_modules").getAbsolutePath();
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\bitapp\pre\ContextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */