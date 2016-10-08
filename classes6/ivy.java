import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.NewStoryCoverMgr;
import com.tencent.biz.qqstory.takevideo.NewStoryPartManager;
import com.tencent.biz.qqstory.takevideo.NewStoryRMViewSTInterface;
import com.tencent.biz.qqstory.takevideo.NewStoryTakeVideoActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class ivy
  implements DialogInterface.OnClickListener
{
  ivy(ivx paramivx)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.a.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.a.a.setResult(1001, paramDialogInterface);
    paramDialogInterface = this.a.a.a.jdField_a_of_type_ComTencentMobileqqActivityRichmediaStateRMVideoStateMgr.a;
    this.a.a.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoNewStoryPartManager.a.b(this.a.a.a.p, this.a.a.a.q, this.a.a.a.n, paramDialogInterface);
    this.a.a.a.finish();
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\ivy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */