import android.os.Handler;
import android.os.Message;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.now.NowVideoView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class hki
  extends Handler
{
  public hki(NowVideoView paramNowVideoView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null));
      this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.b, this.a.c, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, true);
      return;
    } while ((this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager == null) || (this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (this.a.jdField_a_of_type_Boolean) || (this.a.h != 2));
    this.a.jdField_a_of_type_ComTencentBizNowNowLiveManager.a(this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.a.b, this.a.c, this.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq, false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\hki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */