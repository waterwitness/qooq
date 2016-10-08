package com.tencent.mobileqq.theme.diy;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$13
  implements AdapterView.OnItemClickListener
{
  ThemeDIYActivity$13(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ResItemHolder localResItemHolder = (ResItemHolder)paramAdapterView.getItemAtPosition(paramInt);
    this.this$0.mUpdateUIPicAfterSaved = false;
    if ((localResItemHolder != null) && (localResItemHolder.resType == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "resItemClickListener RES_TYPE_BG, position:" + paramInt + ", pageId:" + this.this$0.currentIndex);
      }
      if ((localResItemHolder.thumResData == null) || (localResItemHolder.thumResData.state == 2)) {}
    }
    do
    {
      do
      {
        return;
        i = this.this$0.bgAdapter.resTryOnPosition;
        this.this$0.bgAdapter.resTryOnPosition = paramInt;
        this.this$0.showData[this.this$0.currentIndex].bgTryOnPosition = paramInt;
        this.this$0.bgAdapter.setItemState(i, paramInt, false);
        if (paramInt == 0)
        {
          this.this$0.onClick(this.this$0.btn_themeDiy_upload);
          return;
        }
        if (paramInt == 1)
        {
          this.this$0.onClick(this.this$0.btn_themeDiy_undo);
          return;
        }
        if (this.this$0.showData[this.this$0.currentIndex].intoDiyPic.id != localResItemHolder.id) {}
        for (this.this$0.showData[this.this$0.currentIndex].mSetStatus = 2;; this.this$0.showData[this.this$0.currentIndex].mSetStatus = 0)
        {
          this.this$0.showData[this.this$0.currentIndex].bgDiyPic = localResItemHolder.previewResData;
          this.this$0.showDiyImage(null, this.this$0.currentIndex, false);
          ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.a(), "theme_mall", "diy_yangtu", 0, 0, String.valueOf(this.this$0.currentIndex), String.valueOf(localResItemHolder.id), "", "");
          return;
        }
      } while ((localResItemHolder == null) || (localResItemHolder.resType != 1));
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "resItemClickListener RES_TYPE_THEME, position:" + paramInt + ", pageId:" + this.this$0.currentIndex);
      }
    } while ((localResItemHolder.thumResData != null) && (localResItemHolder.thumResData.state != 2));
    int i = this.this$0.themeAdapter.resTryOnPosition;
    this.this$0.themeAdapter.resTryOnPosition = paramInt;
    this.this$0.themeAdapter.selectResItem = localResItemHolder;
    this.this$0.themeAdapter.setItemState(i, paramInt, false);
    if (this.this$0.isDIYThemeBefore) {
      if (this.this$0.themeAdapter.resUsedID != localResItemHolder.id)
      {
        this.this$0.themeAdapter.mSetStatus = 2;
        paramInt = 0;
        label526:
        if (paramInt >= this.this$0.showData.length) {
          break label775;
        }
        if (localResItemHolder.index != 0) {
          break label739;
        }
        if (!this.this$0.isBigScreenType) {
          break label707;
        }
        paramAdapterView = this.this$0.showData[paramInt].imgBig;
        label569:
        i = Integer.parseInt("999");
        String str = ThemeDiyStyleLogic.DIR_SCREENSHOT_BG;
        StringBuilder localStringBuilder = new StringBuilder().append(IndividuationUrlHelper.a("themeDiy"));
        if (!this.this$0.isBigScreenType) {
          break label723;
        }
        paramView = this.this$0.showData[paramInt].imgBig;
        label621:
        paramAdapterView = new ResData(paramAdapterView, i, paramInt, str, paramView, 0, 0, 2, 0);
      }
    }
    for (;;)
    {
      this.this$0.showData[paramInt].screenShot = paramAdapterView;
      this.this$0.showScreenShot(null, paramInt, false);
      paramInt += 1;
      break label526;
      this.this$0.themeAdapter.mSetStatus = 0;
      break;
      this.this$0.themeAdapter.mSetStatus = 2;
      break;
      label707:
      paramAdapterView = this.this$0.showData[paramInt].imgSmall;
      break label569;
      label723:
      paramView = this.this$0.showData[paramInt].imgSmall;
      break label621;
      label739:
      if (paramInt == 0) {
        paramAdapterView = localResItemHolder.screen0ResData;
      } else if (paramInt == 1) {
        paramAdapterView = localResItemHolder.screen1ResData;
      } else {
        paramAdapterView = localResItemHolder.screen2ResData;
      }
    }
    label775:
    ReportController.b(this.this$0.app, "CliOper", "", this.this$0.app.a(), "theme_mall", "diy_style", 0, 0, String.valueOf(this.this$0.currentIndex), String.valueOf(localResItemHolder.id), "", "");
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$13.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */