package com.tencent.biz.qqstory.pgc;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetAdapter;
import ilc;
import ild;
import ile;
import java.util.ArrayList;
import java.util.List;

public class ShareUtil
{
  public int a;
  public Context a;
  public ActionSheet a;
  public ActionSheetAdapter a;
  public boolean a;
  
  public ShareUtil(Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(UserInfo paramUserInfo, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    Object localObject = new ArrayList();
    int i = 0;
    while (i <= 3)
    {
      ((List)localObject).add(ActionSheetAdapter.a(i));
      i += 1;
    }
    if (this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter == null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter = new ActionSheetAdapter(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter.a((List)localObject);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      localObject = new ilc(this, paramUserInfo);
      paramOnDismissListener = new ild(this, paramOnDismissListener);
      ile localile = new ile(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetAdapter.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetActionSheetAdapter, (AdapterView.OnItemClickListener)localObject, paramOnDismissListener, localile, false);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      StoryReportor.a("share_uin", "channel_exp", 0, paramUserInfo.type, new String[] { paramUserInfo.unionId });
    }
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\pgc\ShareUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */