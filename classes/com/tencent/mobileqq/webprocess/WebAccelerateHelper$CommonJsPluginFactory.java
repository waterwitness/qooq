package com.tencent.mobileqq.webprocess;

import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.biz.webviewplugin.OpenCenterPlugin;
import com.tencent.biz.webviewplugin.PtloginPlugin;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.biz.webviewplugin.ReportPlugin;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.antiphing.AntiphingHandler;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import java.util.ArrayList;
import java.util.List;

public class WebAccelerateHelper$CommonJsPluginFactory
{
  public WebAccelerateHelper$CommonJsPluginFactory()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new AntiphingHandler());
    localArrayList.add(new OfflinePlugin());
    localArrayList.add(new SosoPlugin());
    localArrayList.add(new VasWebReport());
    localArrayList.add(new WebSoPlugin());
    localArrayList.add(new ReportPlugin());
    localArrayList.add(new PtloginPlugin());
    localArrayList.add(new WebViewJumpPlugin());
    localArrayList.add(new EventApiPlugin());
    localArrayList.add(new UiApiPlugin());
    localArrayList.add(new OpenCenterPlugin());
    localArrayList.add(new QzoneWebViewOfflinePlugin());
    return localArrayList;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\webprocess\WebAccelerateHelper$CommonJsPluginFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */