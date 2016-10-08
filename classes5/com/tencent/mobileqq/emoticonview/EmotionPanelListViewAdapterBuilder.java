package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelListViewAdapterBuilder
{
  private static EmotionPanelListViewAdapterBuilder a;
  public static final String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelListViewAdapterBuilder.class.getSimpleName();
  }
  
  public static EmotionPanelListViewAdapterBuilder a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewAdapterBuilder == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewAdapterBuilder == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewAdapterBuilder = new EmotionPanelListViewAdapterBuilder();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelListViewAdapterBuilder;
    }
    finally {}
  }
  
  public BaseEmotionAdapter a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getAdapter panelType = " + paramInt2);
    }
    switch (paramInt2)
    {
    case 10: 
    case 11: 
    default: 
      return null;
    case 1: 
      return new SystemAndEmojiAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 6: 
      return new BigEmotionDownloadedAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 8: 
      return new BigEmotionUpdateAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 7: 
      return new EmotionDownloadOrInvalidAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 4: 
      return new FavoriteEmotionAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 5: 
      return new MagicFaceAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 3: 
      return new RecommendEmotionAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    case 2: 
      return new SmallEmotionDownloadedAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    case 9: 
      return new SmallEmotionUpdateAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
    }
    return new EmotionCompleteInvalidAdapter(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonPackage, paramEmoticonCallback);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelListViewAdapterBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */