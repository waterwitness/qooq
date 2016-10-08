package com.tencent.bitapp.preDownload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import hea;
import java.util.ArrayList;
import java.util.Iterator;

public class RNPreDownloadHandler
  extends EarlyHandler
{
  public static final int a = 0;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static final String a = "actReactNativeSystemResource";
  public static final int b = -100;
  public static final String b = "qq.android.reactnative.system.resource";
  public static final int c = -101;
  public static final int d = -102;
  public static final int e = -103;
  private static final String f = "RNPreDownloadHandler";
  private RNEarlyDOwnloadListener jdField_a_of_type_ComTencentBitappPreDownloadRNEarlyDOwnloadListener = new hea(this);
  public boolean a;
  private ArrayList b = new ArrayList();
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public RNPreDownloadHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.reactnative.system.resource", paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    super.a(this.jdField_a_of_type_ComTencentBitappPreDownloadRNEarlyDOwnloadListener);
  }
  
  public Class a()
  {
    return RNPreDownloadData.class;
  }
  
  public String a()
  {
    return "actReactNativeSystemResource";
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.b != null) && (this.b.size() > 0))
      {
        Iterator localIterator = this.b.iterator();
        if (localIterator.hasNext())
        {
          IRNPreDownloadListener localIRNPreDownloadListener = (IRNPreDownloadListener)localIterator.next();
          if (QLog.isColorLevel()) {
            QLog.d("RNPreDownloadHandler", 4, "RNPreDownloadHandler notifyListener onProgress: " + this.jdField_a_of_type_ComTencentBitappPreDownloadRNEarlyDOwnloadListener + " | curOffset: " + paramLong1 + " | totalLen: " + paramLong2);
          }
          localIRNPreDownloadListener.a(paramLong1, paramLong2);
        }
      }
    }
  }
  
  public void a(IRNPreDownloadListener paramIRNPreDownloadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadHandler", 4, "RNPreDownloadHandler addListener: " + paramIRNPreDownloadListener);
    }
    Object localObject = jdField_a_of_type_JavaLangObject;
    if (paramIRNPreDownloadListener != null) {}
    try
    {
      if (this.b != null) {
        this.b.add(paramIRNPreDownloadListener);
      }
      return;
    }
    finally {}
  }
  
  public void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RNPreDownloadHandler", 2, "goDownloadFail");
    }
    a(false, -103);
  }
  
  public void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("RNPreDownloadHandler", 2, "onDownload success: " + paramString);
      }
      RNPreLoader.a(paramString);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RNPreDownloadHandler", 2, localException.getMessage());
        }
      }
    }
    super.a(paramString);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    IRNPreDownloadListener localIRNPreDownloadListener;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if ((this.b == null) || (this.b.size() <= 0)) {
        break label192;
      }
      if (paramBoolean)
      {
        Iterator localIterator1 = this.b.iterator();
        if (!localIterator1.hasNext()) {
          break label185;
        }
        localIRNPreDownloadListener = (IRNPreDownloadListener)localIterator1.next();
        if (QLog.isColorLevel()) {
          QLog.d("RNPreDownloadHandler", 4, "RNPreDownloadHandler notifyListener success: " + this.jdField_a_of_type_ComTencentBitappPreDownloadRNEarlyDOwnloadListener);
        }
        localIRNPreDownloadListener.a();
      }
    }
    Iterator localIterator2 = this.b.iterator();
    while (localIterator2.hasNext())
    {
      localIRNPreDownloadListener = (IRNPreDownloadListener)localIterator2.next();
      if (QLog.isColorLevel()) {
        QLog.d("RNPreDownloadHandler", 4, "RNPreDownloadHandler notifyListener fail: " + this.jdField_a_of_type_ComTencentBitappPreDownloadRNEarlyDOwnloadListener);
      }
      localIRNPreDownloadListener.a(paramInt);
    }
    label185:
    this.b.clear();
    label192:
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(XmlData paramXmlData)
  {
    super.b(paramXmlData);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    Object localObject = a();
    if ((localObject instanceof RNPreDownloadData))
    {
      localObject = (RNPreDownloadData)localObject;
      if (((RNPreDownloadData)localObject).isIngoreNet)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RNPreDownloadHandler", 2, "User set isIngoreNet true");
        }
        ((RNPreDownloadData)localObject).isIngoreNet = false;
      }
    }
    for (;;)
    {
      return super.c();
      boolean bool = NetworkUtil.i(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.d("RNPreDownloadHandler", 2, "isNetValid2Download isWifi: " + bool);
      }
      if (!bool)
      {
        return false;
        if (QLog.isColorLevel()) {
          QLog.d("RNPreDownloadHandler", 2, "Not RNPreDownloadData");
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\preDownload\RNPreDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */