package com.tencent.mobileqq.magicface.magicfaceaction;

import android.os.Vibrator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.model.MagicfaceDecoder.MagicPlayListener;
import com.tencent.mobileqq.magicface.model.MagicfacePlayRes;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager.MagicfaceSensorOperation;
import com.tencent.mobileqq.magicface.service.MagicfacePlayManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import tas;
import tat;

public class Action
{
  public static final String a = "Action";
  public int a;
  private Vibrator jdField_a_of_type_AndroidOsVibrator;
  public ActionGlobalData a;
  public ActionProcess a;
  private MagicfaceDecoder.MagicPlayListener jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener;
  private MagicfacePlayRes jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes;
  public MagicfacePlayManager a;
  public List a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  public boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int c;
  public boolean c;
  private volatile boolean d;
  
  public Action()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener = new tas(this);
    this.jdField_a_of_type_JavaUtilTimerTask = new tat(this);
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i == 1) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = ((MagicfacePlayRes)this.jdField_a_of_type_JavaUtilList.get(0));
    }
    MagicfacePlayRes localMagicfacePlayRes;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((i <= 1) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int < 0)) {}
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      } while (!localIterator.hasNext());
      localMagicfacePlayRes = (MagicfacePlayRes)localIterator.next();
    } while ((localMagicfacePlayRes.jdField_a_of_type_Int > this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int) || (localMagicfacePlayRes.jdField_b_of_type_Int <= this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes = localMagicfacePlayRes;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int > 0) {
      ThreadManager.a().schedule(this.jdField_a_of_type_JavaUtilTimerTask, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((!"end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f)) || (paramInt != -1)) {
              break;
            }
          } while (paramMagicfaceSensorOperation == null);
          b();
          return;
          ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d)) || (paramInt < this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int)) {
            break;
          }
          b();
        } while (paramMagicfaceSensorOperation == null);
        paramMagicfaceSensorOperation.a();
        return;
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d));
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.m = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
  }
  
  public boolean a()
  {
    this.jdField_b_of_type_Boolean = false;
    c();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.g);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceDecoder$MagicPlayListener);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes);
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await();
      if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_c_of_type_JavaLangString);
      }
      if ((this.jdField_a_of_type_AndroidOsVibrator != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfacePlayRes.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidOsVibrator.cancel();
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Action", 2, "===Magicaction is stop====");
      }
      return true;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.b();
    this.jdField_a_of_type_JavaUtilTimerTask.cancel();
  }
  
  public void b(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            return;
            int j = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int;
            i = j;
            if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int > 0)
            {
              i = j;
              if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int < 40) {
                i = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_a_of_type_Int * 2;
              }
            }
            if (QLog.isColorLevel()) {
              QLog.i("Action", 2, "==stopValue=" + i);
            }
            if (!"end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f)) {
              break;
            }
          } while (paramInt < i);
          b();
          return;
          ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
          if ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d)) || (paramInt < i) || (!"mic".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.e))) {
            break;
          }
          b();
        } while (paramMagicfaceSensorOperation == null);
        paramMagicfaceSensorOperation.a();
        return;
        paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while (!"record".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d));
      paramMagicfaceSensorOperation = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData;
      paramMagicfaceSensorOperation.jdField_b_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.a(paramInt);
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.m = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float);
  }
  
  public void c(int paramInt, MagicfaceActionManager.MagicfaceSensorOperation paramMagicfaceSensorOperation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"end".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.f)) {
            break;
          }
        } while (paramMagicfaceSensorOperation == null);
        b();
        return;
        ActionProcess localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess;
      } while ((!"stop".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.d)) || (!"touch".equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.e)) || (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionProcess.jdField_b_of_type_Int != paramInt));
      b();
    } while (paramMagicfaceSensorOperation == null);
    paramMagicfaceSensorOperation.a();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\magicface\magicfaceaction\Action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */