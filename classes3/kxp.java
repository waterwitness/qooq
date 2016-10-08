import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.widget.QQProgressDialog;

class kxp
  extends AsyncTask
{
  kxp(kxo paramkxo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    this.a.a.app.a().a(paramVarArgs[0], true);
    if ((paramVarArgs[0] instanceof MessageForApollo)) {
      ApolloActionManager.a().a();
    }
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    ChatHistoryForC2C.a(this.a.a).removeMessages(1);
    if ((this.a.a.a != null) && (this.a.a.a.isShowing())) {
      this.a.a.a.dismiss();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\kxp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */