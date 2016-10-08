import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItem;
import com.tencent.biz.pubaccount.PublicAccountBrowser.ActionSheetItemViewHolder;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import mqq.app.AppRuntime;

public class wip
  implements AdapterView.OnItemClickListener
{
  public wip(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->begin!");
    }
    paramAdapterView = paramView.getTag();
    if (paramAdapterView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->tag null!");
      }
      return;
    }
    if ((SwiftBrowserShareMenuHandler.a(this.a) != null) && (SwiftBrowserShareMenuHandler.a(this.a).isShowing())) {
      SwiftBrowserShareMenuHandler.a(this.a).dismiss();
    }
    int i = ((PublicAccountBrowser.ActionSheetItemViewHolder)paramAdapterView).a.v;
    paramInt = -1;
    paramAdapterView = "";
    paramView = Uri.parse(SwiftBrowserShareMenuHandler.a(this.a));
    try
    {
      paramView = paramView.getQueryParameter("article_id");
      paramAdapterView = paramView;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        continue;
        paramAdapterView = new Bundle();
        paramAdapterView.putInt("forward_type", 1);
        paramAdapterView.putString("forward_filepath", SwiftBrowserShareMenuHandler.b(this.a));
        paramAdapterView.putString("forward_extra", SwiftBrowserShareMenuHandler.b(this.a));
        paramAdapterView.putBoolean("not_forward", true);
        paramAdapterView.putString("forward_thumb", SwiftBrowserShareMenuHandler.b(this.a));
        paramAdapterView.putBoolean("isFromShare", true);
        paramAdapterView.putBoolean("isJumpAIO", true);
        localIntent = new Intent();
        localIntent.putExtras(paramAdapterView);
        ForwardBaseOption.a(this.a.a, localIntent, 21);
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1001", paramView, "", "");
        if (QLog.isColorLevel())
        {
          QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->do action friend!");
          continue;
          paramAdapterView = QZoneHelper.UserInfo.a();
          paramAdapterView.a = BaseApplicationImpl.a().a().getAccount();
          QZoneHelper.a(this.a.a, paramAdapterView, SwiftBrowserShareMenuHandler.b(this.a), this.a.a.getString(2131369099), "", -1);
          ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1002", paramView, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->do action qzone!");
          }
        }
      }
      if (WXShareHelper.a().a()) {
        break label544;
      }
      paramInt = 2131369529;
      if (paramInt == -1) {
        break label559;
      }
      QRUtils.a(0, paramInt);
      for (;;)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1003", paramView, "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->do action wechat!");
        break;
        if (WXShareHelper.a().b()) {
          break label494;
        }
        paramInt = 2131369530;
        break label494;
        try
        {
          paramAdapterView = BitmapFactory.decodeFile(SwiftBrowserShareMenuHandler.b(this.a));
          if (paramAdapterView != null)
          {
            WXShareHelper.a().a(SwiftBrowserShareMenuHandler.b(this.a), paramAdapterView, 0, false);
            paramAdapterView.recycle();
          }
        }
        catch (OutOfMemoryError paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
        catch (Exception paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
      }
      if (WXShareHelper.a().a()) {
        break label675;
      }
    }
    paramView = paramAdapterView;
    if (paramAdapterView == null) {
      paramView = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->action:" + i + ", articleId:" + paramView + ", mEditScreenshotPath:" + SwiftBrowserShareMenuHandler.b(this.a));
    }
    switch (i)
    {
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->end!");
        return;
      }
      break;
    case 2: 
    case 3: 
    case 9: 
    case 10: 
      label224:
      Intent localIntent;
      label494:
      label544:
      label559:
      paramInt = 2131369529;
    }
    for (;;)
    {
      label625:
      if (paramInt != -1) {
        QRUtils.a(0, paramInt);
      }
      for (;;)
      {
        ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A1F", "0X8006A1F", 0, 0, "1004", paramView, "", "");
        if (!QLog.isColorLevel()) {
          break label224;
        }
        QLog.d("SwiftBrowserShareMenuHandler", 2, "onScreenShotItemClick->do action wechat circle!");
        break label224;
        break;
        label675:
        if (WXShareHelper.a().b()) {
          break label744;
        }
        paramInt = 2131369530;
        break label625;
        try
        {
          paramAdapterView = BitmapFactory.decodeFile(SwiftBrowserShareMenuHandler.b(this.a));
          if (paramAdapterView != null)
          {
            WXShareHelper.a().a(SwiftBrowserShareMenuHandler.b(this.a), paramAdapterView, 1, false);
            paramAdapterView.recycle();
          }
        }
        catch (OutOfMemoryError paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
        catch (Exception paramAdapterView)
        {
          paramAdapterView.printStackTrace();
        }
      }
      label744:
      paramInt = -1;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\wip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */