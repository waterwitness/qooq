import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPAAudio.ViewHolder;

public class uwo
  implements Runnable
{
  public uwo(StructMsgItemPAAudio paramStructMsgItemPAAudio, View paramView, StructMsgItemPAAudio.ViewHolder paramViewHolder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.getParent();
    Object localObject2 = localObject3;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (((ViewGroup)localObject2).getId() != 2131296312) {
          break label54;
        }
        localObject2 = (StructMsgForGeneralShare)((ViewGroup)localObject2).getTag(2131296312);
      }
    }
    if (localObject2 == null) {}
    label54:
    do
    {
      do
      {
        return;
        localObject1 = ((ViewGroup)localObject2).getParent();
        break;
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
      } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup == null);
      localObject1 = (ChatItemBuilder.BaseHolder)AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_AndroidViewViewGroup);
    } while (localObject1 == null);
    long l = ((ChatItemBuilder.BaseHolder)localObject1).a.uniseq;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.s = ((StructMsgForGeneralShare)localObject2).uin;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.a(l);
    if (!this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.setBackgroundResource(2130838942);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.setBackgroundResource(2130968670);
    ((AnimationDrawable)this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemPAAudio$ViewHolder.c.getBackground()).start();
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\uwo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */