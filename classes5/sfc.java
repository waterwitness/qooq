import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.LocalTbsViewManagerCallback;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class sfc
  implements TbsReaderView.ReaderCallback
{
  public sfc(LocalTbsViewManager paramLocalTbsViewManager, Activity paramActivity, LocalTbsViewManager.LocalTbsViewManagerCallback paramLocalTbsViewManagerCallback, String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onCallBackAction(Integer paramInteger, Object paramObject1, Object paramObject2)
  {
    int i = 10386;
    switch (paramInteger.intValue())
    {
    case 19: 
    default: 
    case 12: 
    case 5000: 
    case 5012: 
      for (;;)
      {
        this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new sfg(this, paramInteger));
        return;
        if (paramObject1 != null)
        {
          i = ((Bundle)paramObject1).getInt("function_id");
          paramObject1 = TbsReaderView.getResString(this.jdField_a_of_type_AndroidAppActivity, i);
          paramObject2 = TbsReaderView.getResDrawable(this.jdField_a_of_type_AndroidAppActivity, i + 1);
          Drawable localDrawable = TbsReaderView.getResDrawable(this.jdField_a_of_type_AndroidAppActivity, i + 2);
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager$LocalTbsViewManagerCallback.a((String)paramObject1, (Drawable)paramObject2, localDrawable, new sfd(this, i));
          continue;
          if ((paramObject2 instanceof Bundle)) {}
          for (paramObject1 = (Bundle)paramObject2;; paramObject1 = new Bundle())
          {
            ((Bundle)paramObject1).putBoolean("is_bar_animating", false);
            break;
          }
          if (((Integer)paramObject1).intValue() == 0)
          {
            paramObject1 = new Bundle();
            ((Bundle)paramObject1).putString("filePath", this.jdField_a_of_type_JavaLangString);
            ((Bundle)paramObject1).putString("tempPath", Environment.getExternalStorageDirectory() + "/" + "TbsReaderTemp");
            LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).openFile((Bundle)paramObject1);
          }
        }
      }
    }
    paramInteger = this.jdField_a_of_type_AndroidAppActivity.getString(2131369303);
    if ((paramObject1 != null) && ((paramObject1 instanceof Bundle)))
    {
      paramObject2 = (Bundle)paramObject1;
      paramInteger = ((Bundle)paramObject2).getString("tip");
      paramObject1 = ((Bundle)paramObject2).getString("statistics");
      i = ((Bundle)paramObject2).getInt("channel_id", 10386);
    }
    for (;;)
    {
      paramObject2 = "http://mdc.html5.qq.com/d/directdown.jsp?channel_id=" + i;
      DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, 233, this.jdField_a_of_type_AndroidAppActivity.getString(2131369193), paramInteger, new sfe(this, (String)paramObject1, (String)paramObject2), new sff(this)).show();
      return;
      paramObject1 = "";
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\sfc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */