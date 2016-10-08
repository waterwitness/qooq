import android.view.View;
import com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richstatus.RichStatusEditText;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.SignatureTemplateInfo.DynamicItem;
import com.tencent.widget.ListView;
import mqq.os.MqqHandler;

public class nfd
  implements Runnable
{
  /* Error */
  public nfd(SigTlpAnimation paramSigTlpAnimation, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: putfield 14	nfd:jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation	Lcom/tencent/mobileqq/activity/aio/anim/SigTlpAnimation;
    //   5: aload_0
    //   6: aload_2
    //   7: putfield 16	nfd:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: aload_0
    //   11: aload_3
    //   12: putfield 18	nfd:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: aload_0
    //   16: invokespecial 21	java/lang/Object:<init>	()V
    //   19: getstatic 27	com/tencent/mobileqq/hotpatch/NotVerifyClass:DO_VERIFY_CLASS	Z
    //   22: istore 4
    //   24: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	nfd
    //   0	25	1	paramSigTlpAnimation	SigTlpAnimation
    //   0	25	2	paramString1	String
    //   0	25	3	paramString2	String
    //   22	1	4	bool	boolean
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(SigTlpAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation)))
    {
      SigTlpAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation, this.jdField_a_of_type_JavaLangString);
      localObject = SignatureTemplateConfig.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.a((String)localObject)) {}
    }
    else
    {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
    String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ArrayOfJavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.c != 0)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.c;
      ((VipPngPlayAnimationDrawable)localObject).a(arrayOfString, i, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.a(103);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_AndroidViewView == null) || (!(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_AndroidViewView instanceof RichStatusEditText)))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.b == 0) {
          break label221;
        }
      }
    }
    label221:
    for (int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentMobileqqVasSignatureTemplateInfo$DynamicItem.b;; i = 3)
    {
      ((VipPngPlayAnimationDrawable)localObject).l = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimSigTlpAnimation.jdField_a_of_type_ComTencentWidgetListView.getContext());
      ThreadManager.c().post(new nfe(this));
      return;
      i = 50;
      break;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\nfd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */