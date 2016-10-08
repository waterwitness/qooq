import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class kql
  implements Runnable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public kql(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEmoticonMainPanel);
  }
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || ("".equals(this.jdField_a_of_type_JavaLangString))) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    int i = 0;
    label35:
    int j;
    int k;
    if (i < localStringBuilder.length())
    {
      j = localStringBuilder.codePointAt(i);
      if ((j != 20) || (i >= localStringBuilder.length() - 1)) {
        break label542;
      }
      k = localStringBuilder.charAt(i + 1);
      if ((k >= EmotcationConstants.b) && (250 != k)) {
        break label202;
      }
      if (250 != k) {
        break label659;
      }
      k = 10;
    }
    label202:
    label542:
    label659:
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A3", 0, 0, k + "", "", "", "");
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "report emoji send amount, index:" + k);
        j = i;
      }
      do
      {
        i = j + 1;
        break label35;
        break;
        j = i;
      } while (k != 255);
      if (i + 4 >= localStringBuilder.length()) {
        break;
      }
      Object localObject = new char[4];
      localObject[0] = localStringBuilder.charAt(i + 4);
      localObject[1] = localStringBuilder.charAt(i + 3);
      localObject[2] = localStringBuilder.charAt(i + 2);
      localObject[3] = localStringBuilder.charAt(i + 1);
      j = 0;
      if (j < 3)
      {
        if (localObject[j] == 'ú') {
          localObject[j] = 10;
        }
        for (;;)
        {
          j += 1;
          break;
          if (localObject[j] == 'þ') {
            localObject[j] = 13;
          }
        }
      }
      localObject = EmosmUtils.a((char[])localObject);
      if ((localObject != null) && (localObject.length == 2))
      {
        k = localObject[0];
        j = localObject[1];
      }
      for (;;)
      {
        int n = -1;
        int m = n;
        if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
        {
          m = n;
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
            m = ((EmoticonMainPanel)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(Integer.toString(k));
          }
        }
        String str = Integer.toString(m);
        if (this.jdField_a_of_type_Boolean) {}
        for (localObject = "0X800588C";; localObject = "0X80057AF")
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", (String)localObject, 0, 0, k + "", j + "", str, "");
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "report small emoticon send amount, epId:" + k + ",eId:" + j + ",tabOrder:" + str);
          }
          j = i + 4;
          break;
        }
        k = EmotcationConstants.a.get(j, -1);
        j = i;
        if (k < 0) {
          break;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A4", 0, 0, k + "", "", "", "");
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.aio.BaseChatPie", 2, "report system emoticon send amount, emoIdx:" + k);
        j = i;
        break;
        j = 0;
        k = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kql.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */