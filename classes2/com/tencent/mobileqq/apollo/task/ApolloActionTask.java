package com.tencent.mobileqq.apollo.task;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IRenderCommInterface;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import psk;
import psl;

public class ApolloActionTask
  implements Runnable
{
  public static final String a = "ApolloActionTask";
  public ApolloTaskParam a;
  public boolean a;
  
  public ApolloActionTask(ApolloTaskParam paramApolloTaskParam)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam = paramApolloTaskParam;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam = new ApolloTaskParam();
    }
  }
  
  private int a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[doActionForSingleMan], isActionMaker:" + paramBoolean + ",roleId:" + paramInt2 + ",nicknameText:" + paramString1 + ",roleType:" + paramInt1);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null) || (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null)) {
      return 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "actionId:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int + ",taskId:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f + ",msgText:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface == null) || ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface instanceof ApolloSurfaceView)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "revalue.");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface = ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "mCurTaskParam.mRenderComm:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.b(1, paramInt1, paramInt2, paramString1, paramString2);
    }
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString)) && (paramBoolean) && (!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.b(0, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString, paramString2);
    }
    if ((1 == this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int) && (1 == paramInt1) && (paramQQAppInterface != null) && (ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences != null) && (!ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("is_click_me_bubble_on" + paramQQAppInterface.a(), false)) && (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a() != null) && (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.a().f == 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.b(0, paramInt1, paramInt2, "点我吧~", paramString2) == 0)) {
      ApolloActionManager.a().jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("is_click_me_bubble_on" + paramQQAppInterface.a(), true).commit();
    }
    paramString1 = a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int, paramInt2, paramBoolean);
    paramInt1 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloIRenderCommInterface.a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, paramString1[0], paramString1[1]);
    if (paramInt1 == 0) {
      this.jdField_a_of_type_Boolean = true;
    }
    return paramInt1;
  }
  
  public static int a(int paramInt, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[loadRoles], manUin:" + paramString + ",roleType:" + paramInt + ",scale:" + paramFloat3);
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "manUin is nulllll, don't need loadrole.");
      }
      return 0;
    }
    paramString = ApolloActionHelper.a(paramString, paramQQAppInterface);
    if ((paramString == null) || (paramString.length != 2)) {
      return 0;
    }
    paramQQAppInterface = new ApolloRoleLoadParam[1];
    paramQQAppInterface[0] = new ApolloRoleLoadParam();
    paramQQAppInterface[0].jdField_a_of_type_Int = ((Integer)paramString[0]).intValue();
    paramQQAppInterface[0].jdField_a_of_type_ArrayOfInt = ((int[])paramString[1]);
    paramQQAppInterface[0].jdField_b_of_type_Int = paramInt;
    paramQQAppInterface[0].jdField_b_of_type_Float = paramFloat1;
    paramQQAppInterface[0].c = paramFloat2;
    paramQQAppInterface[0].jdField_a_of_type_Float = paramFloat3;
    ApolloActionManager.a().a(paramBoolean1, paramQQAppInterface, paramBoolean2);
    return ((Integer)paramString[0]).intValue();
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[handlerTroopShowMode],mManNum:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_Int + ",senderUin:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString + ",recUin:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString);
    }
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null)) {}
    Object localObject2;
    do
    {
      return;
      localObject2 = paramQQAppInterface.a();
    } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView == null));
    int i = ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.b();
    if ((i > 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_Int != i - 1)) {}
    Object localObject1;
    boolean bool2;
    int[] arrayOfInt;
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = bool1;
      if (!bool1)
      {
        long l1 = System.currentTimeMillis();
        localObject1 = ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString, paramQQAppInterface);
        bool2 = bool1;
        if (localObject1 != null)
        {
          bool2 = bool1;
          if (localObject1.length > 1)
          {
            if (((Integer)localObject1[0]).intValue() > 1000) {
              bool1 = true;
            }
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_Int == 1)
            {
              localObject1 = ApolloActionHelper.a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString, paramQQAppInterface);
              bool2 = bool1;
              if (localObject1 != null)
              {
                bool2 = bool1;
                if (((Integer)localObject1[0]).intValue() > 1000) {
                  bool2 = true;
                }
              }
            }
          }
        }
        long l2 = System.currentTimeMillis();
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("ApolloActionTask", 2, "isDispose delta:" + (l2 - l1));
          bool3 = bool2;
        }
      }
      arrayOfInt = ApolloActionManager.a().a(bool3, false, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString);
      if (arrayOfInt != null) {
        break label351;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ApolloActionTask", 2, "errInfo-> roleID is null.");
      return;
    }
    label351:
    ApolloActionManager.a().jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_Int;
    label378:
    Object localObject3;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_Int == 1)
    {
      bool1 = true;
      localObject3 = "";
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "isDoubleMan:" + bool1);
      }
      localObject1 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e != 1) {
        break label579;
      }
      localObject1 = ContactUtils.e(paramQQAppInterface, ApolloActionManager.a().h, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString);
      label446:
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(localObject2)) || (!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString))) {
        break label1129;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "fail to get self name in troop.");
      }
      localObject1 = paramQQAppInterface.b();
    }
    label579:
    label813:
    label988:
    label1042:
    label1102:
    label1126:
    label1129:
    for (;;)
    {
      if (!bool1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f < 1000000) {
          ApolloActionManager.a().e = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int);
        }
        i = a(1, arrayOfInt[0], true, (String)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString, paramQQAppInterface);
        if (i == 0) {
          break;
        }
        ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, i, "me");
        return;
        bool1 = false;
        break label378;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e != 3000) {
          break label446;
        }
        localObject1 = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString, true);
        break label446;
      }
      if (arrayOfInt.length != 2)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ApolloActionTask", 2, "role len not equal 2, len:" + arrayOfInt.length);
        return;
      }
      bool1 = ((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString);
      bool2 = ((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString);
      localObject2 = "";
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e == 1)
      {
        localObject2 = ContactUtils.e(paramQQAppInterface, ApolloActionManager.a().h, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString);
        if ((!((String)localObject2).equals(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString))) {
          break label1126;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString.lastIndexOf("@");
        if (-1 == i) {
          break label1126;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_c_of_type_JavaLangString.substring(i + 1);
      }
      for (;;)
      {
        String str;
        Object localObject4;
        if (((!bool1) && (!bool2)) || (bool1))
        {
          str = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString;
          localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString;
          bool1 = true;
          localObject4 = localObject2;
          localObject2 = str;
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f < 1000000)
          {
            if (!bool1) {
              break label988;
            }
            ApolloActionManager.a().e = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int);
          }
          for (ApolloActionManager.a().d = (Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int) + "_peer");; ApolloActionManager.a().d = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int))
          {
            i = a(1, arrayOfInt[0], bool1, (String)localObject1, (String)localObject2, paramQQAppInterface);
            if (i == 0) {
              break label1042;
            }
            ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, i, "me");
            return;
            if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e != 3000) {
              break;
            }
            localObject2 = ContactUtils.c(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString, true);
            break;
            if (!bool2) {
              break label1102;
            }
            str = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_JavaLangString;
            localObject3 = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_JavaLangString;
            bool1 = false;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = str;
            break label813;
            ApolloActionManager.a().e = (Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int) + "_peer");
          }
          i = arrayOfInt[1];
          if (!bool1) {}
          for (bool1 = true;; bool1 = false)
          {
            i = a(2, i, bool1, (String)localObject4, (String)localObject3, paramQQAppInterface);
            if (i == 0) {
              break;
            }
            ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, i, "me");
            return;
          }
          localObject4 = "";
          localObject1 = "";
          str = "";
          bool1 = true;
          localObject2 = localObject3;
          localObject3 = str;
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[handlC2CShowMode], isSingleAction:" + paramBoolean);
    }
    if ((paramQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null)) {}
    int[] arrayOfInt;
    do
    {
      return;
      arrayOfInt = ApolloActionManager.a().jdField_a_of_type_ArrayOfInt;
      if ((arrayOfInt != null) && (arrayOfInt.length >= 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloActionTask", 2, "roleId is nulllll or length is wrong." + arrayOfInt);
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f < 1000000)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean) {
        break label217;
      }
      ApolloActionManager.a().e = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int);
      ApolloActionManager.a().d = (Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int) + "_peer");
    }
    while ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f < 1000000)) {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean)
      {
        a(1, arrayOfInt[0], this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean, "", "", paramQQAppInterface);
        return;
        label217:
        ApolloActionManager.a().e = (Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int) + "_peer");
        ApolloActionManager.a().d = Integer.toString(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int);
      }
      else
      {
        i = arrayOfInt[1];
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a(2, i, paramBoolean, "", "", paramQQAppInterface);
          return;
        }
      }
    }
    int i = a(1, arrayOfInt[0], this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean, "", "", paramQQAppInterface);
    if (i != 0)
    {
      ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, i, "me");
      return;
    }
    i = arrayOfInt[1];
    if (!this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Boolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      i = a(2, i, paramBoolean, "", "", paramQQAppInterface);
      if (i == 0) {
        break;
      }
      ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, i, "me");
      return;
    }
  }
  
  public static String[] a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[getActionRscPath],activeId:" + paramInt1 + ",roleId:" + paramInt2 + ",isActionMaker:" + paramBoolean);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt2 == 0) && (paramInt1 < 21))
    {
      localStringBuilder.append("def/role/");
      localStringBuilder.append(0);
      localStringBuilder.append("/");
      paramInt2 = paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "targActionId:" + paramInt2);
      }
      localStringBuilder.append(paramInt2);
      if ((!paramBoolean) && (paramInt1 >= 21)) {
        break label474;
      }
      localStringBuilder.append("/action/action");
    }
    for (;;)
    {
      String str1 = localStringBuilder.toString();
      String str2 = Integer.toString(paramInt2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "action rsc path:" + localStringBuilder.toString() + ",actionId:" + paramInt2);
      }
      return new String[] { str1, str2 };
      if (paramInt1 < 5)
      {
        if (ApolloUtil.a(paramInt2))
        {
          localStringBuilder.append("role/");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("/");
          paramInt2 = paramInt1;
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionTask", 2, "entrance action rsc NOT exist, use default.");
        }
        localStringBuilder.append("def/role/");
        localStringBuilder.append(0);
        localStringBuilder.append("/");
        paramInt2 = paramInt1;
        break;
      }
      if (paramInt1 < 21)
      {
        if (paramInt1 == 5)
        {
          int i = ApolloActionHelper.a(paramInt2);
          if (-1 == i)
          {
            localStringBuilder.append("def/role/");
            localStringBuilder.append(0);
            localStringBuilder.append("/");
            localStringBuilder.append(ApolloConstant.A);
            localStringBuilder.append("/");
            paramInt2 = 1;
            break;
          }
          localStringBuilder.append("role/");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("/");
          localStringBuilder.append(ApolloConstant.A);
          localStringBuilder.append("/");
          paramInt2 = i;
          break;
        }
        if (paramInt1 != 6) {
          break label469;
        }
        localStringBuilder.append("def/role/");
        localStringBuilder.append(0);
        localStringBuilder.append("/");
        localStringBuilder.append(ApolloConstant.A);
        localStringBuilder.append("/");
        paramInt2 = 1;
        break;
      }
      localStringBuilder.append("action/");
      label469:
      paramInt2 = paramInt1;
      break;
      label474:
      localStringBuilder.append("/action_peer/action");
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloActionTask", 2, "[run] taskId:" + this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f + ",threadId:" + Thread.currentThread().getId());
    }
    QQAppInterface localQQAppInterface = ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloActionTask", 2, "warning: appInterface is null.");
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback.a(1, 1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Long));
      }
      return;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int < 21)
    {
      localObject = new ApolloActionData();
      ((ApolloActionData)localObject).personNum = 0;
      ((ApolloActionData)localObject).actionId = this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int;
    }
    for (;;)
    {
      if (!ApolloUtil.a(((ApolloActionData)localObject).actionId, ((ApolloActionData)localObject).personNum))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloActionTask", 2, "warning: action rsc NOT exist.");
        }
        ThreadManager.a(new psk(this), 5, null, true);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback.a(0, 0, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Long));
        }
        ThreadManager.a(new psl(this, localQQAppInterface, (ApolloActionData)localObject), 5, null, false);
        ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, 6, "me");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_ComTencentMobileqqApolloTaskIApolloActDldCallback.a(6, 1, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_a_of_type_Long));
        return;
        ApolloActionData localApolloActionData = ((ApolloDaoManager)localQQAppInterface.getManager(154)).a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int);
        localObject = localApolloActionData;
        if (localApolloActionData == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloActionTask", 2, "warning: data is null. call checkApolloPanelJsonVer");
          }
          ClubContentUpdateHandler.d(localQQAppInterface);
          ApolloActionManager.a().a(this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f, 1, "me");
          return;
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.f < 1000000) {
      ApolloActionManager.a().f();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e == 1) || (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e == 3000)) {
      a(localQQAppInterface);
    }
    label423:
    while ((ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.jdField_b_of_type_Int < 21))
    {
      ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setNodeHidden("me", 0);
      ApolloActionManager.a().jdField_a_of_type_ComTencentMobileqqApolloApolloSurfaceView.setNodeHidden("friend", 0);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloTaskApolloTaskParam.e == 0) {
        if (((ApolloActionData)localObject).personNum != 0) {
          break label501;
        }
      }
    }
    label501:
    for (boolean bool = true;; bool = false)
    {
      a(localQQAppInterface, bool);
      break label423;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\apollo\task\ApolloActionTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */