import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class pld
  implements DialogInterface.OnClickListener
{
  public pld(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Intent paramIntent, ArrayList paramArrayList)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    PhotoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, false);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */