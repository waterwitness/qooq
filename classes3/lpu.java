import QQService.DiscussMemberInfo;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lpu
  extends FriendListObserver
{
  private lpu(JoinDiscussionActivity paramJoinDiscussionActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if ((paramBoolean) && (this.a.jdField_a_of_type_JavaUtilList != null))
    {
      localObject = this.a.jdField_a_of_type_JavaUtilList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!String.valueOf(((DiscussMemberInfo)((Iterator)localObject).next()).Uin).equals(paramString));
    }
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.a.jdField_a_of_type_JavaUtilArrayList.contains(paramString)))
      {
        this.a.jdField_a_of_type_JavaUtilArrayList.add(paramString);
        localObject = new StringBuilder();
        JoinDiscussionActivity localJoinDiscussionActivity = this.a;
        localJoinDiscussionActivity.f = (localJoinDiscussionActivity.f + paramString + ";");
        if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == this.a.c)
        {
          paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.f);
          this.a.runOnUiThread(new lpv(this, paramString));
        }
      }
      return;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\lpu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */