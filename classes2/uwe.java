import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout13.ViewHolder;
import com.tencent.mobileqq.utils.ContactUtils;

public class uwe
  implements Runnable
{
  public uwe(StructMsgItemLayout13 paramStructMsgItemLayout13, StructMsgForGeneralShare paramStructMsgForGeneralShare, Resources paramResources, StructMsgItemLayout13.ViewHolder paramViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    String str = ContactUtils.f(StructMsgItemLayout13.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout13), this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.message.frienduin, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare.author);
    new Handler(Looper.getMainLooper()).post(new uwf(this, str));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */