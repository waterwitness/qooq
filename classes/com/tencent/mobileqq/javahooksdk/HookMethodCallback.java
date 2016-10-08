package com.tencent.mobileqq.javahooksdk;

public abstract interface HookMethodCallback
{
  public abstract void afterHookedMethod(MethodHookParam paramMethodHookParam);
  
  public abstract void beforeHookedMethod(MethodHookParam paramMethodHookParam);
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\javahooksdk\HookMethodCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */