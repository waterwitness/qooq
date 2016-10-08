package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class EmotionPanelDataBuilder
{
  private static EmotionPanelDataBuilder a;
  public static final String a;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = EmotionPanelDataBuilder.class.getSimpleName();
  }
  
  public static EmotionPanelDataBuilder a()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelDataBuilder == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelDataBuilder == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelDataBuilder = new EmotionPanelDataBuilder();
      }
      return jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelDataBuilder;
    }
    finally {}
  }
  
  public List a(QQAppInterface paramQQAppInterface, int paramInt, EmoticonPackage paramEmoticonPackage)
  {
    int i = 1;
    if (paramQQAppInterface == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getEmotionPanelData panelType = " + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = (EmoticonManager)paramQQAppInterface.getManager(13);
    switch (paramInt)
    {
    case 10: 
    case 11: 
    default: 
    case 1: 
    case 7: 
    case 4: 
      do
      {
        return localArrayList;
        return SystemAndEmojiEmoticonInfo.a(paramQQAppInterface);
        localArrayList.add(new EmotionPanelData());
        return localArrayList;
        paramQQAppInterface = ((FavroamingDBManager)paramQQAppInterface.getManager(148)).a(100);
        paramEmoticonPackage = new EmoticonInfo();
        paramEmoticonPackage.jdField_a_of_type_JavaLangString = "favEdit";
        localObject1 = new EmoticonInfo();
        ((EmoticonInfo)localObject1).jdField_a_of_type_JavaLangString = "funny_pic";
        localArrayList.add(paramEmoticonPackage);
        localArrayList.add(localObject1);
      } while (paramQQAppInterface == null);
      if (paramQQAppInterface.size() > FavEmoConstant.jdField_a_of_type_Int)
      {
        localArrayList.addAll(paramQQAppInterface.subList(0, FavEmoConstant.jdField_a_of_type_Int));
        return localArrayList;
      }
      localArrayList.addAll(paramQQAppInterface);
      return localArrayList;
    case 5: 
      paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
      paramQQAppInterface.jdField_a_of_type_JavaLangString = "push";
      paramEmoticonPackage = ((EmoticonManager)localObject1).b();
      localArrayList.add(paramQQAppInterface);
      localArrayList.addAll(paramEmoticonPackage);
      return localArrayList;
    case 3: 
      localArrayList.addAll(((EmoticonManager)localObject1).a(true));
      return localArrayList;
    }
    if ((paramEmoticonPackage == null) || (TextUtils.isEmpty(paramEmoticonPackage.epId))) {
      return null;
    }
    localObject1 = ((EmoticonManager)localObject1).a(paramEmoticonPackage.epId);
    label364:
    label381:
    Emoticon localEmoticon;
    Object localObject2;
    if (paramEmoticonPackage.jobType == 4)
    {
      paramInt = i;
      if (localObject1 == null) {
        break label464;
      }
      int j = ((List)localObject1).size();
      i = 0;
      if (i < j)
      {
        localEmoticon = (Emoticon)((List)localObject1).get(i);
        if (paramInt == 0) {
          break label466;
        }
        localObject2 = new SmallEmoticonInfo(paramQQAppInterface.a());
        ((SmallEmoticonInfo)localObject2).c = 10;
        ((SmallEmoticonInfo)localObject2).jdField_a_of_type_Int = paramEmoticonPackage.type;
        ((SmallEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
        localArrayList.add(localObject2);
      }
    }
    for (;;)
    {
      i += 1;
      break label381;
      break;
      paramInt = 0;
      break label364;
      label464:
      break;
      label466:
      localObject2 = new PicEmoticonInfo(paramQQAppInterface.a());
      ((PicEmoticonInfo)localObject2).c = 6;
      ((PicEmoticonInfo)localObject2).j = paramEmoticonPackage.type;
      ((PicEmoticonInfo)localObject2).jdField_a_of_type_ComTencentMobileqqDataEmoticon = localEmoticon;
      localArrayList.add(localObject2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionPanelDataBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */