import com.tencent.mobileqq.activity.contact.newfriend.NewFriendBaseBuilder;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.widget.SwipRightMenuBuilder.SwipRightMenuItem;
import com.tencent.widget.SwipTextViewMenuBuilder;

public class oiw
  extends SwipTextViewMenuBuilder
{
  public oiw(NewFriendBaseBuilder paramNewFriendBaseBuilder, int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2, paramArrayOfInt1, paramInt3, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void a(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem[] paramArrayOfSwipRightMenuItem)
  {
    int i = 1;
    if ((paramArrayOfSwipRightMenuItem == null) || (paramArrayOfSwipRightMenuItem.length <= 0)) {}
    for (;;)
    {
      return;
      paramInt = this.a.a();
      if ((paramObject instanceof MessageForSystemMsg)) {
        paramInt = ((MessageForSystemMsg)paramObject).mSysmsgMenuFlag;
      }
      if (((paramObject instanceof PushRecommend)) || ((paramObject instanceof ContactMatch))) {
        paramInt = 1;
      }
      if ((paramArrayOfSwipRightMenuItem.length < 0) && ((paramInt & 0xF) == 1))
      {
        paramArrayOfSwipRightMenuItem[0].b = 0;
        paramArrayOfSwipRightMenuItem[0].a = 0;
        paramInt = i;
      }
      while (paramInt < paramArrayOfSwipRightMenuItem.length)
      {
        paramArrayOfSwipRightMenuItem[paramInt].b = -1;
        paramArrayOfSwipRightMenuItem[paramInt].a = -1;
        paramInt += 1;
        continue;
        paramInt = 0;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oiw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */