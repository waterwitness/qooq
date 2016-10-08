import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class gvp
  implements DialogInterface.OnClickListener
{
  public gvp(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().n()) && (this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() != null)) {
      PstnUtils.a(null, (Context)this.a.jdField_a_of_type_JavaLangRefWeakReference.get(), 2, 11);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */