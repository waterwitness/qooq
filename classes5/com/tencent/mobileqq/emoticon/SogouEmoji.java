package com.tencent.mobileqq.emoticon;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import rji;
import rjj;
import rjk;
import rjl;

public class SogouEmoji
{
  public static final String a;
  public static String b;
  public static String c = "exprId";
  int jdField_a_of_type_Int = 0;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  EmoticonHandler jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler;
  EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new rjj(this);
  public EmojiManager a;
  public EmotionJsonDownloadListener a;
  public SogouEmojiTaskController a;
  public EmoticonManager a;
  public int b;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    jdField_a_of_type_JavaLangString = SogouEmoji.class.getSimpleName();
    jdField_b_of_type_JavaLangString = "taskId";
  }
  
  public SogouEmoji(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener = new rji(this);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji constructor begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(13));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.getManager(42));
    this.jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler = ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a(12));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController = new SogouEmojiTaskController(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji constructor ends");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
  }
  
  private boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func" + paramString + " ends, maybe chatActivity is finished.");
      }
      return false;
    }
    return true;
  }
  
  public ArrayList a(ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getInvalidKeyEmoticon begins");
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return localArrayList;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.next();
      if (!localEmoticon.hasEncryptKey()) {
        localArrayList.add(localEmoticon);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getInvalidKeyEmoticon ends, size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji destructor begins");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null))
    {
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app;
      if (localQQAppInterface != null) {
        localQQAppInterface.b(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a();
    }
    EmojiListenerManager.a().b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func SogouEmoji destructor ends");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend begins, packId:" + paramInt + ",exprId:" + paramString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a() != null) && (!NetworkUtil.e(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getApplicationContext()))) {
      QQToast.a(BaseApplicationImpl.a, 2131367481, 0).a();
    }
    do
    {
      Emoticon localEmoticon;
      do
      {
        return;
        localEmoticon = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(Integer.toString(paramInt), paramString);
        if ((localEmoticon != null) && (localEmoticon.hasEncryptKey())) {
          break;
        }
        a(Integer.toString(paramInt), paramString, true);
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend ends, emotion has invalid key. Call func pullSingleEmojiKey");
      return;
      a(localEmoticon);
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func trySend ends, everything is ok.");
  }
  
  public void a(Emoticon paramEmoticon)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func sendEmoji begins, mCurTaskId:" + this.jdField_b_of_type_Int + ",emoticon:" + paramEmoticon);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.c();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.b();
    if (!a("sendEmoji")) {
      return;
    }
    PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().app.a());
    localPicEmoticonInfo.c = 6;
    localPicEmoticonInfo.a = paramEmoticon;
    paramEmoticon = this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(paramEmoticon.epId);
    if (paramEmoticon != null) {}
    for (localPicEmoticonInfo.j = paramEmoticon.type;; localPicEmoticonInfo.j = 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(localPicEmoticonInfo);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func sendEmoji ends, type:" + localPicEmoticonInfo.j);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new rjk(this, paramString1, paramString2, paramBoolean);
    ThreadManager.a().post(paramString1);
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPackEmojiKey begins, packId:" + paramString);
    }
    if (!a("getPackEmojiKey")) {}
    do
    {
      return;
      String str = Integer.toString(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 1;
      if (EmosmUtils.a(paramString)) {
        this.jdField_a_of_type_ComTencentMobileqqAppEmoticonHandler.a(Integer.parseInt(paramString), paramArrayList, str);
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPackEmojiKey ends");
  }
  
  public void a(List paramList)
  {
    paramList = new rjl(this, paramList);
    ThreadManager.a().post(paramList);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticon\SogouEmoji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */