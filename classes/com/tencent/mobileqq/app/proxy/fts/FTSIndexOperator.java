package com.tencent.mobileqq.app.proxy.fts;

import android.os.Message;
import com.tencent.mobileqq.app.FTSConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.fts.FTSDatabase;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.persistence.fts.FTSEntity;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public abstract class FTSIndexOperator
  extends Observable
  implements FTSConstants
{
  protected int a;
  public QQAppInterface a;
  public FTSSyncHandler a;
  protected FTSUpgrader a;
  public FTSDatabase a;
  protected FTSDatatbase a;
  protected volatile boolean a;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  private boolean e;
  
  public FTSIndexOperator(QQAppInterface paramQQAppInterface, FTSSyncHandler paramFTSSyncHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler = paramFTSSyncHandler;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean)
  {
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2)
  {
    return null;
  }
  
  public ArrayList a(String paramString, Class paramClass, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.d = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.a();
    }
  }
  
  public void a(FTSEntity paramFTSEntity) {}
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  public boolean a()
  {
    if (SQLiteFTSUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 1) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.a();
  }
  
  public boolean a(FTSDatatbase paramFTSDatatbase, FTSDatabase paramFTSDatabase)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = paramFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsFTSDatabase = paramFTSDatabase;
    return true;
  }
  
  public boolean a(FTSEntity paramFTSEntity)
  {
    return false;
  }
  
  public void b()
  {
    if (a()) {
      b();
    }
  }
  
  public void b(FTSEntity paramFTSEntity) {}
  
  public void b(Observer paramObserver)
  {
    if (paramObserver != null) {
      deleteObserver(paramObserver);
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSUpgrader.b();
    }
    return true;
  }
  
  public void c()
  {
    setChanged();
    notifyObservers();
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppProxyFtsFTSSyncHandler.obtainMessage(2, this).sendToTarget();
  }
  
  protected boolean d()
  {
    boolean bool3 = false;
    int i;
    boolean bool1;
    if (!this.e) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a.a();
        if (i == 0)
        {
          this.e = true;
          bool1 = false;
          label39:
          bool2 = bool1;
          if (i == 1) {
            this.e = true;
          }
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = true)
    {
      if ((bool2) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
      for (bool1 = bool3;; bool1 = bool2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.sync_worker", 2, "isSaveDBAtOnce unActionLoginB atOnce:" + bool1);
        }
        return bool1;
      }
      bool1 = true;
      break label39;
      i = 0;
      break;
    }
  }
  
  public abstract void e();
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\app\proxy\fts\FTSIndexOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */