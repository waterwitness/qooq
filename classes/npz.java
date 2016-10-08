import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgVideoController;
import com.tencent.widget.AbsListView.RecyclerListener;

public class npz
  implements AbsListView.RecyclerListener
{
  public npz(StructingMsgItemBuilder paramStructingMsgItemBuilder)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject = AIOUtils.a(paramView);
          } while (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject));
          localObject = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject;
        } while ((!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject)) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage)) || (((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (!(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)));
        localObject = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((((MessageForStructing)localObject).structingMsg == null) || (!(((MessageForStructing)localObject).structingMsg instanceof StructMsgForGeneralShare)) || ((!(this.a.a instanceof ChatActivity)) && (!(this.a.a instanceof SplashActivity))));
      StructingMsgItemBuilder.ViewCache localViewCache = ((FragmentActivity)this.a.a).getChatFragment().a().a();
      String str = ((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).getLayoutStr();
      if (localViewCache != null) {
        localViewCache.a(str, (ViewGroup)paramView.findViewById(2131296328));
      }
    } while (!((StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg).mIsPAVideoStructMsg);
    StructMsgVideoController.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject).structingMsg);
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\npz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */