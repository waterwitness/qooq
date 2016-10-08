import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class kvh
  implements Runnable
{
  kvh(kvg paramkvg)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    MessageRecord localMessageRecord = new MessageRecord();
    localMessageRecord.shmsgseq = ChatHistory.a(this.a.a);
    int i = this.a.a.app.a().a(this.a.a.d, this.a.a.a, localMessageRecord);
    this.a.a.runOnUiThread(new kvi(this, i));
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */