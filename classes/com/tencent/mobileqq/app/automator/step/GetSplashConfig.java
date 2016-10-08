package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.StructMsgObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.olympic.OlympicManager;
import com.tencent.mobileqq.olympic.OlympicServlet;

public class GetSplashConfig
  extends AsyncStep
{
  public GetSplashConfig()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected int a()
  {
    this.a.b.b(this.a.b.a());
    ConfigServlet.b(this.a.b, this.a.b.a());
    ConfigServlet.h(this.a.b, this.a.b.a());
    ConfigServlet.i(this.a.b, this.a.b.a());
    OlympicManager localOlympicManager = (OlympicManager)this.a.b.getManager(166);
    OlympicServlet.b(this.a.b, localOlympicManager.b());
    this.a.b.a().addObserver(new StructMsgObserver());
    return 7;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\automator\step\GetSplashConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */