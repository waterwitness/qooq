import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.av.ui.MultiVideoMembersListviewAvtivity;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class gvh
  implements MultiVideoMembersClickListener
{
  public gvh(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private void b()
  {
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null)
    {
      localIntent = new Intent(localAVActivity, MultiVideoMembersListviewAvtivity.class);
      localIntent.putExtra("UinType", this.a.c);
      localIntent.putExtra("RelationUin", String.valueOf(this.a.b));
      localAVActivity.startActivity(localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.e("MultiVideoCtrlLayerUI4Discussion", 2, "startMembersListViewPage-->can not get activity");
  }
  
  public void a()
  {
    if ((this.a.jdField_a_of_type_ComTencentAvVideoController.a().f == 4) && (!this.a.jdField_a_of_type_ComTencentAvVideoController.a().k())) {
      this.a.ag();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiVideoCtrlLayerUI4Discussion", 2, "MultiVideoMembersClickListener , Uin = " + paramLong + " , videoScr = " + paramInt1 + " , isNeedRequest " + paramBoolean + " , positon = " + paramInt2);
    }
    if ((paramInt2 == 17) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\gvh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */