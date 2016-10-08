package com.tencent.mobileqq.earlydownload.handler;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.EarlyDataFactory;
import com.tencent.mobileqq.earlydownload.xmldata.SharpPData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class SharpPHandler
  extends EarlyHandler
{
  public static final String a = "qq.android.native.sharpP";
  private static final String b = "SharpPHandler";
  
  public SharpPHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.native.sharpP", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public Class a()
  {
    return SharpPData.class;
  }
  
  public String a()
  {
    return "actEarlyNativeSharpP";
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject = WebpSoLoader.a(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.d("SharpPHandler", 2, "so dir path: " + (String)localObject);
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        FileUtils.a(paramString, (String)localObject, false);
      }
      localObject = new SharpPData();
      ((SharpPData)localObject).sharpP_so_avaliable = true;
      EarlyDataFactory.a((XmlData)localObject, new String[] { "sharpP_so_avaliable" });
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    super.a(paramString);
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\SharpPHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */