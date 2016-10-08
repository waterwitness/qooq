package com.tencent.mobileqq.apollo;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.task.OnDressDoneListener;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ApolloRenderInterfaceImpl
  implements IRenderCommInterface
{
  public static String a;
  private ApolloRender jdField_a_of_type_ComTencentMobileqqApolloApolloRender;
  private ApolloRenderDriver jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = "ApolloRenderInterfaceImpl";
  }
  
  public ApolloRenderInterfaceImpl(ApolloRenderDriver paramApolloRenderDriver, ApolloRender paramApolloRender)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver = paramApolloRenderDriver;
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender = paramApolloRender;
  }
  
  public int a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onLoadRole], roleType:" + paramInt1 + ",roleId:" + paramInt2 + ",roleScale:" + paramFloat1 + ",xPos:" + paramFloat2 + ",yPos:" + paramFloat3);
    }
    int i = 0;
    if (!ApolloUtil.c(paramInt2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->role rsc NOT exist.");
      }
      i = 2;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null) {
      return i;
    }
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt1, paramInt2, paramFloat1, paramFloat2, paramFloat3);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    return paramInt1;
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onExecAction], roleType:" + paramInt1 + ",actionId:" + paramInt2 + ",taskId:" + paramInt3 + ",actionRscName:" + paramString1 + ",animName:" + paramString2);
    }
    int i = 0;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->null param.");
      }
      i = 1;
    }
    do
    {
      do
      {
        return i;
        File localFile = new File(ApolloRender.getRscPath(paramString1, "json"));
        if (!localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->rsc NOT exist. rscFile:" + localFile);
          }
          return 2;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null);
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
      paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
      i = paramInt1;
    } while (paramInt1 != 0);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a.set(8);
    return paramInt1;
  }
  
  public int a(int paramInt, int[] paramArrayOfInt, OnDressDoneListener paramOnDressDoneListener)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onChangeDress], roleType:" + paramInt + ",dressId:" + paramArrayOfInt + ",callback:" + paramOnDressDoneListener);
    }
    int i;
    if (paramArrayOfInt == null) {
      i = 1;
    }
    do
    {
      return i;
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        if (!ApolloUtil.b(paramArrayOfInt[i]))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "errInfo->dress rsc NOT exist, id:" + paramArrayOfInt[i]);
          }
          return 2;
        }
        i += 1;
      }
      i = j;
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver == null);
    paramInt = this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt, paramArrayOfInt, paramOnDressDoneListener);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    return paramInt;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramInt, paramString);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.a(paramLong);
    }
  }
  
  public int b(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.b(paramInt1, paramInt2, paramInt3, paramString1, paramString2);
    }
    return 1;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onUpdateRenderObj]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender.a().b(this.jdField_a_of_type_ComTencentMobileqqApolloApolloRender);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.b(paramInt);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[onDestroy]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null)
    {
      if (ApolloActionManager.a().a != null) {
        ApolloActionManager.a().a.a(ChatActivity.class).obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F / 2.84D) + 40, 0).sendToTarget();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.d();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null)
    {
      QQAppInterface localQQAppInterface = ApolloActionManager.a().a;
      if (localQQAppInterface != null) {
        localQQAppInterface.a(ChatActivity.class).obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F) + 40, 0).sendToTarget();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.e();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null)
    {
      if (ApolloActionManager.a().a != null) {
        ApolloActionManager.a().a.a(ChatActivity.class).obtainMessage(47, (int)((float)DeviceInfoUtil.i() / 7.0F / 2.84D) + 40, 0).sendToTarget();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.g();
    }
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloRenderDriver.h();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\ApolloRenderInterfaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */