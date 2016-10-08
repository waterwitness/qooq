package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class IndividualRedPacketManager$PrecreateRunnable
  implements Handler.Callback
{
  int jdField_a_of_type_Int;
  IndividualRedPacketResDownloader.Char300Info jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info;
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference b;
  
  public IndividualRedPacketManager$PrecreateRunnable(IndividualRedPacketManager paramIndividualRedPacketManager, QQAppInterface paramQQAppInterface, IndividualRedPacketResDownloader.Char300Info paramChar300Info)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramIndividualRedPacketManager);
    this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info = paramChar300Info;
  }
  
  public void a()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)this.b.get();
    if ((localObject == null) || (localIndividualRedPacketManager == null)) {}
    while ((localIndividualRedPacketManager.a().getBoolean(IndividualRedPacketManager.m, false)) && (!this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_Boolean)) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_Boolean)
    {
      localIndividualRedPacketManager.a().edit().putInt(IndividualRedPacketManager.n, 0).commit();
      localIndividualRedPacketManager.a().edit().putBoolean(IndividualRedPacketManager.m, false).commit();
      ((QQAppInterface)localObject).getPreferences().edit().putInt(IndividualRedPacketManager.l, 0).commit();
    }
    QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg start!");
    int i = localIndividualRedPacketManager.a().getInt(IndividualRedPacketManager.l, 0);
    localObject = localIndividualRedPacketManager.a.obtainMessage();
    ((Message)localObject).what = i;
    localIndividualRedPacketManager.a.sendMessage((Message)localObject);
  }
  
  void a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    IndividualRedPacketManager localIndividualRedPacketManager = (IndividualRedPacketManager)this.b.get();
    if ((localQQAppInterface == null) || (localIndividualRedPacketManager == null)) {}
    Object localObject;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.jdField_a_of_type_JavaLangString;
      if (paramInt >= str.length())
      {
        localObject = new File(IndividualRedPacketManager.g).listFiles();
        if ((localObject != null) && (localObject.length >= str.length())) {
          localIndividualRedPacketManager.a().edit().putBoolean(IndividualRedPacketManager.m, true).commit();
        }
        for (;;)
        {
          paramInt = localIndividualRedPacketManager.a().getInt(IndividualRedPacketManager.n, 0);
          localIndividualRedPacketManager.a().edit().putInt(IndividualRedPacketManager.n, paramInt + 1).commit();
          QLog.d(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg create count = " + paramInt);
          return;
          localIndividualRedPacketManager.a().edit().putInt(IndividualRedPacketManager.l, 0).commit();
        }
      }
      localObject = "0";
      if (localIndividualRedPacketManager.a()) {
        localObject = "1";
      }
    } while ((localIndividualRedPacketManager.d.get()) || (Thread.currentThread().isInterrupted()));
    String str = str.substring(paramInt, paramInt + 1);
    if (new File(IndividualRedPacketManager.a("", str, 4, 0, 0)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e(IndividualRedPacketManager.b(), 2, "preCreatePersonalFontImg exists : " + str + " address = " + IndividualRedPacketManager.a("", str, 4, 0, 0));
      }
      localIndividualRedPacketManager.a().edit().putInt(IndividualRedPacketManager.l, paramInt + 1).commit();
      localObject = localIndividualRedPacketManager.a.obtainMessage();
      ((Message)localObject).what = (paramInt + 1);
      localIndividualRedPacketManager.a.sendMessageDelayed((Message)localObject, 500L);
      return;
    }
    long l1 = System.currentTimeMillis();
    Bitmap localBitmap = localIndividualRedPacketManager.a(str, true);
    long l2;
    if (localBitmap != null)
    {
      this.jdField_a_of_type_Int = 0;
      l2 = System.currentTimeMillis();
      localIndividualRedPacketManager.a().edit().putInt(IndividualRedPacketManager.l, paramInt + 1).commit();
      if (paramInt % 100 == 0) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject, "1", String.valueOf(l2 - l1), str);
      }
      if (!localBitmap.isRecycled()) {
        localBitmap.recycle();
      }
    }
    do
    {
      localObject = localIndividualRedPacketManager.a.obtainMessage();
      ((Message)localObject).what = (paramInt + 1);
      localIndividualRedPacketManager.a.sendMessageDelayed((Message)localObject, 5000L);
      return;
      l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(IndividualRedPacketManager.b(), 2, "preCreatePersonalFontImg " + str + "fail");
      }
      if (paramInt % 100 == 0) {
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8006132", "0X8006132", 0, 0, (String)localObject, "0", String.valueOf(l2 - l1), str);
      }
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b);
    QLog.e(IndividualRedPacketManager.b(), 1, "preCreatePersonalFontImg fail count = " + this.jdField_a_of_type_Int + " max failcount = " + this.jdField_a_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.b);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    a(paramMessage.what);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\app\IndividualRedPacketManager$PrecreateRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */