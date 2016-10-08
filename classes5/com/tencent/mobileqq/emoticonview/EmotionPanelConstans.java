package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelConstans
  extends EmoticonViewBinder
{
  public static final int A = 4;
  public static final int B = 3;
  public static final int C = 7;
  public static final int D = 4;
  public static final int E = 4;
  public static final int a = 1;
  public static final String a = EmotionPanelConstans.class.getSimpleName();
  public static final int b = 2;
  public static final int c = 3;
  public static final int q = 4;
  public static final int r = 5;
  public static final int s = 6;
  public static final int t = 7;
  public static final int u = 8;
  public static final int v = 9;
  public static final int w = 10;
  public static final int x = 11;
  public static final int y = 12;
  public static final int z = 7;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public EmotionPanelConstans(int paramInt)
  {
    super(paramInt);
  }
  
  public static int a(QQAppInterface paramQQAppInterface, EmotionPanelInfo paramEmotionPanelInfo)
  {
    if (paramEmotionPanelInfo == null) {
      return -1;
    }
    int i = paramEmotionPanelInfo.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getPanelType type = " + i);
    }
    switch (i)
    {
    case 5: 
    default: 
      return -1;
    case 4: 
      return 4;
    case 7: 
      return 1;
    case 9: 
      return 5;
    case 8: 
      return 3;
    case 6: 
      return a(paramQQAppInterface, paramEmotionPanelInfo, false);
    }
    return a(paramQQAppInterface, paramEmotionPanelInfo, true);
  }
  
  private static int a(QQAppInterface paramQQAppInterface, EmotionPanelInfo paramEmotionPanelInfo, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramEmotionPanelInfo == null))
    {
      QLog.e(a, 1, "getEmotionPanelType app or panelinfo is null");
      return -1;
    }
    EmoticonPackage localEmoticonPackage = paramEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      QLog.e(a, 1, "getEmotionPanelType emotionPkg is null; type = " + paramEmotionPanelInfo.jdField_a_of_type_Int);
      return -1;
    }
    boolean bool = EmoticonUtils.a(localEmoticonPackage);
    int i = localEmoticonPackage.status;
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "getEmotionPanelType epid = " + localEmoticonPackage.epId + "status = " + i + ";shouldUpdate = " + bool);
    }
    if ((!localEmoticonPackage.valid) || (i == 3) || (!a(paramQQAppInterface, localEmoticonPackage)))
    {
      if (i == 2) {
        return 12;
      }
      return 7;
    }
    if (bool)
    {
      if (paramBoolean) {
        return 9;
      }
      return 8;
    }
    if (i != 2) {
      return 7;
    }
    if (paramBoolean) {
      return 2;
    }
    return 6;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramQQAppInterface == null)) {
      return false;
    }
    int i = ((SVIPHandler)paramQQAppInterface.a(13)).h();
    if (paramEmoticonPackage.mobileFeetype == 4) {
      return (i == 1) || (i == 3);
    }
    if (paramEmoticonPackage.mobileFeetype == 5) {
      return i == 3;
    }
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelConstans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */