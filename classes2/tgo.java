import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.filemanager.core.UniformDownloadMgr;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class tgo
  implements ActionSheet.OnButtonClickListener
{
  tgo(tgl paramtgl, View paramView, ActionSheet paramActionSheet)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      long l;
      if (!UniformDownloadMgr.a().a("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435"))
      {
        ReportController.b(this.jdField_a_of_type_Tgl.a.app, "CliOper", "", "", "0X800682D", "0X800682D", 0, 0, "", "", "", "");
        l = 0L;
      }
      for (;;)
      {
        try
        {
          paramView = new URL("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435");
        }
        catch (MalformedURLException paramView)
        {
          QLog.e("MusicPlayerActivity", 1, "music player activity url io MalformedURLException ", paramView);
          continue;
          paramInt = -1;
          continue;
        }
        try
        {
          paramInt = paramView.openConnection().getContentLength();
          l = paramInt;
        }
        catch (IOException paramView)
        {
          QLog.e("MusicPlayerActivity", 1, "music player activity url IOException ", paramView);
        }
      }
      paramView = new Bundle();
      paramView.putLong("_filesize_from_dlg", l);
      paramView.putString("_filename_from_dlg", this.jdField_a_of_type_Tgl.a.getResources().getString(2131369304));
      UniformDownloadMgr.a().b("http://misc.wcd.qq.com/app?packageName=com.tencent.qqmusic&channelId=10000435", paramView);
      paramView = this.jdField_a_of_type_AndroidViewView.getTag();
      if (!(paramView instanceof Integer)) {
        break label287;
      }
      paramInt = ((Integer)paramView).intValue();
      paramView = CalloutPopupWindow.a(this.jdField_a_of_type_Tgl.a).b(3).a(this.jdField_a_of_type_Tgl.a.getString(2131372589)).a(paramInt);
      paramView.c(49);
      paramView = new CalloutPopupWindow.DrawableBuilder(paramView).b(Color.argb(13, 255, 255, 255)).a(5).a();
      if (paramView != null)
      {
        paramView = paramView.a();
        if (paramView != null) {
          paramView.a(this.jdField_a_of_type_AndroidViewView);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\tgo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */