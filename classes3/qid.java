import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import cooperation.c2b.C2BUploadFileActivity;

public class qid
  implements Runnable
{
  public qid(VideoBroadcastReceiver paramVideoBroadcastReceiver, Context paramContext, Intent paramIntent)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, C2BUploadFileActivity.class);
    localIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_AndroidContentContext.getApplicationContext().startActivity(localIntent);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\qid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */