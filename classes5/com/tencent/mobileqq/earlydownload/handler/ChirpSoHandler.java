package com.tencent.mobileqq.earlydownload.handler;

import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.xmldata.ChirpSoData;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import mqq.os.MqqHandler;
import rgp;
import rgq;

public class ChirpSoHandler
  extends EarlyHandler
{
  public static final String a = "qq.android.system.chirp";
  private static final String jdField_b_of_type_JavaLangString = "ChirpSoHandler";
  private LinkedList jdField_a_of_type_JavaUtilLinkedList;
  private boolean jdField_a_of_type_Boolean;
  private QQAppInterface jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public ChirpSoHandler(QQAppInterface paramQQAppInterface)
  {
    super("qq.android.system.chirp", paramQQAppInterface);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.b = paramQQAppInterface;
  }
  
  public Class a()
  {
    return ChirpSoData.class;
  }
  
  public String a()
  {
    return "actEarlyChirpSo";
  }
  
  public void a(ChirpSoHandler.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramCallback)) {
        this.jdField_a_of_type_JavaUtilLinkedList.add(paramCallback);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "onDownload success " + paramString);
    }
    paramString = new rgp(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ThreadManager.b().post(paramString);
    }
    for (;;)
    {
      BaseApplicationImpl.a.post(new rgq(this));
      return;
      paramString.run();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "restartDownload " + paramBoolean);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
      return;
    }
    super.a(paramBoolean);
  }
  
  public void b(ChirpSoHandler.Callback paramCallback)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.remove(paramCallback);
      return;
    }
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.b.E();
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "isNetValid2Download by user " + AppSetting.j);
      }
      return AppSetting.j;
    }
    this.b.E();
    if (QLog.isColorLevel()) {
      QLog.d("ChirpSoHandler", 2, "isNetValid2Download by startup " + AppSetting.j);
    }
    return (AppSetting.j) && (super.c());
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\earlydownload\handler\ChirpSoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */