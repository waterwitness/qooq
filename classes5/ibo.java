import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ibo
  implements DialogInterface.OnClickListener
{
  ibo(ibm paramibm)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReadInJoyBaseAdapter.a(this.a.a.a).a(false);
    this.a.a.a.a.a(5);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\ibo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */