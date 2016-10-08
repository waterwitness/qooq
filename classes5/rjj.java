import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticon.SogouEmojiTaskController;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class rjj
  extends EmoticonObserver
{
  public rjj(SogouEmoji paramSogouEmoji)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmosmBack begins, isSuccess:" + paramBoolean + ",type:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (paramInt != 3)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramObject = (EmoticonResp)paramObject;
          } while (((EmoticonResp)paramObject).data == null);
          paramObject = (ArrayList)((EmoticonResp)paramObject).data;
        } while (((ArrayList)paramObject).size() == 0);
        paramBoolean = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmojiTaskController.a(this.a.b);
        if (QLog.isColorLevel()) {
          QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack begins, isTaskExist:" + paramBoolean);
        }
        if (paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack ends, task CANCELLED by user.");
      return;
      this.a.a((Emoticon)((ArrayList)paramObject).get(0));
    } while (!QLog.isColorLevel());
    QLog.d(SogouEmoji.jdField_a_of_type_JavaLangString, 2, "func onEmojiKeyBack ends, Ready to send.");
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */