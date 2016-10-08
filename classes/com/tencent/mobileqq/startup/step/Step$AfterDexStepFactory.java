package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AfterDexStepFactory
  implements Step.IStepFactory
{
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    paramStartupDirector = null;
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 19: 
    default: 
      paramStartupDirector = new Step();
    case 28: 
      return paramStartupDirector;
    case 5: 
    case 17: 
      return new LoadData();
    case 4: 
      return new NewRuntime();
    case 9: 
      return new InitSkin();
    case 10: 
      return new InitUrlDrawable();
    case 12: 
      return new Rdm();
    case 13: 
      return new ManageThread();
    case 15: 
      return new LoadUi();
    case 16: 
      return new LoadOtherStuff();
    case 18: 
      return new InitQzoneTracer();
    case 20: 
      return new StartServiceLiteCmp();
    case 21: 
      return new UpdateBubbleZip();
    case 22: 
      return new UpdateAvSo();
    case 23: 
      return new UpdateArkSo();
    case 24: 
      return new SetPlugin();
    case 25: 
      return new UpdatePluginVersion();
    case 26: 
      return new WebP();
    case 29: 
      return new PreInitValues();
    case 14: 
      return new InitMagnifierSDK();
    case 27: 
      return new InitHook();
    case 30: 
      return new LoadAIOBg();
    case 31: 
      return new InjectBitmap();
    case 32: 
      return new MigrateSubscribeDB();
    }
    return new UpdatePatchConfig();
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\startup\step\Step$AfterDexStepFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */