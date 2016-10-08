import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class oeq
  implements Runnable
{
  public oeq(HongbaoKeywordGrayTips paramHongbaoKeywordGrayTips)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject = HongbaoKeywordGrayTips.a(this.a).a().a(HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_JavaLangString, HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int);
    int i = ((List)localObject).size();
    if (i > 0)
    {
      localObject = (ChatMessage)((List)localObject).get(i - 1);
      if (HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int != 0) {
        break label130;
      }
      HongbaoKeywordGrayTips.a(this.a, ((ChatMessage)localObject).time);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HongbaoKeywordGrayTips", 2, "size : " + i + ", mLastMsgIdOrTime:" + HongbaoKeywordGrayTips.a(this.a));
      }
      return;
      label130:
      if ((HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int == 3000) || (HongbaoKeywordGrayTips.a(this.a).jdField_a_of_type_Int == 1)) {
        HongbaoKeywordGrayTips.a(this.a, ((ChatMessage)localObject).shmsgseq);
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oeq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */