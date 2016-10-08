package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.smtt.export.external.DexLoader;
import dalvik.system.DexClassLoader;

class VideoWizard
{
  private static final String TBS_PLAYER_CLASS_NAME = "com.tencent.tbs.player.TbsPlayerProxy";
  protected DexLoader mDexLoader = null;
  
  public VideoWizard(DexLoader paramDexLoader)
  {
    this.mDexLoader = paramDexLoader;
  }
  
  public Object getTbsPlayer(Context paramContext)
  {
    DexLoader localDexLoader = this.mDexLoader;
    DexClassLoader localDexClassLoader = this.mDexLoader.getClassLoader();
    return localDexLoader.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[] { Context.class, DexClassLoader.class }, new Object[] { paramContext, localDexClassLoader });
  }
  
  public void onActivity(Object paramObject, Activity paramActivity, int paramInt)
  {
    this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[] { Activity.class, Integer.TYPE }, new Object[] { paramActivity, Integer.valueOf(paramInt) });
  }
  
  public void onUserStateChanged(Object paramObject)
  {
    this.mDexLoader.invokeMethod(paramObject, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
  }
  
  public boolean play(Object paramObject1, Bundle paramBundle, FrameLayout paramFrameLayout, Object paramObject2)
  {
    if (paramObject2 != null) {}
    for (paramObject1 = this.mDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class, Object.class }, new Object[] { paramBundle, paramFrameLayout, paramObject2 }); (paramObject1 instanceof Boolean); paramObject1 = this.mDexLoader.invokeMethod(paramObject1, "com.tencent.tbs.player.TbsPlayerProxy", "play", new Class[] { Bundle.class, FrameLayout.class }, new Object[] { paramBundle, paramFrameLayout })) {
      return ((Boolean)paramObject1).booleanValue();
    }
    return false;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\smtt\sdk\VideoWizard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */