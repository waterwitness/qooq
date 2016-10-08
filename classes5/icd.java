import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

public class icd
  implements DialogInterface.OnClickListener
{
  public icd(ReadInJoyListViewGroup paramReadInJoyListViewGroup)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReadInJoyListViewGroup.a(this.a).a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\icd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */