import android.os.Bundle;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rjk
  implements Runnable
{
  /* Error */
  public rjk(SogouEmoji paramSogouEmoji, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 15	rjk:jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji	Lcom/tencent/mobileqq/emoticon/SogouEmoji;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 17	rjk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 19	rjk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: aload_0
    //   16: iload 4
    //   18: putfield 21	rjk:jdField_a_of_type_Boolean	Z
    //   21: aload_0
    //   22: invokespecial 24	java/lang/Object:<init>	()V
    //   25: getstatic 29	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   28: istore 4
    //   30: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	rjk
    //   0	31	1	paramSogouEmoji	SogouEmoji
    //   0	31	2	paramString1	String
    //   0	31	3	paramString2	String
    //   0	31	4	paramBoolean	boolean
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey begins, packId=" + this.jdField_a_of_type_JavaLangString + ",exprId:" + this.jdField_b_of_type_JavaLangString + ",isNewTask:" + this.jdField_a_of_type_Boolean);
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_JavaLangString) == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      localObject = new Bundle();
      ((Bundle)localObject).putInt(SogouEmoji.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int);
      ((Bundle)localObject).putString(SogouEmoji.c, this.jdField_b_of_type_JavaLangString);
      EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_JavaLangString, EmojiManager.e, (Bundle)localObject, false);
      if (QLog.isColorLevel()) {
        QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, fail to search 【the pack】 from db, try get json from srv, mCurTaskId:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int);
      }
    }
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        if (localObject != null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
        localObject = new Bundle();
        ((Bundle)localObject).putInt(SogouEmoji.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int);
        ((Bundle)localObject).putString(SogouEmoji.c, this.jdField_b_of_type_JavaLangString);
        EmojiListenerManager.a().a(this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmotionJsonDownloadListener);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiManager.a(this.jdField_a_of_type_JavaLangString, EmojiManager.e, (Bundle)localObject, false);
      } while (!QLog.isColorLevel());
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, fail to search 【the emotion】 from db, try get json from srv, mCurTaskId:" + this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int);
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localObject);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a(this.jdField_a_of_type_JavaLangString, localArrayList);
    } while (!QLog.isColorLevel());
    QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func pullSingleEmojiKey ends, everything is ok, try get keys from svr");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */