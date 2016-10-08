package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class ThemeDIYActivity$5
  implements ThemeDiyStyleLogic.StyleCallBack
{
  ThemeDIYActivity$5(ThemeDIYActivity paramThemeDIYActivity)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int callback(int paramInt1, int paramInt2, Bundle paramBundle, ResData paramResData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "saveStyleCallback: operateType:" + paramInt1 + ", stateCode:" + paramInt2);
    }
    if (paramInt2 == 8) {}
    try
    {
      Object localObject = new HashMap();
      ((HashMap)localObject).put("param_vipType", String.valueOf(this.this$0.isVip));
      ((HashMap)localObject).put("param_opType", String.valueOf(paramInt1));
      ((HashMap)localObject).put("param_isDiy", String.valueOf(this.this$0.isDIYThemeBefore));
      StatisticCollector.a(this.this$0.mContext).a(this.this$0.app.getAccount(), "ThemeDiyStyleLogicCallback", false, 1L, 0L, (HashMap)localObject, "", false);
      if (13 == paramInt1)
      {
        paramInt1 = paramBundle.getInt("index");
        paramResData = this.this$0.showData[paramInt1];
        if (paramResData == null)
        {
          QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DOWN_BG null == diyData, Index:" + paramInt1);
          return 0;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "saveStyleCallback: callback, pageIndex:" + paramInt1);
        }
        if (paramInt2 == 4) {
          if (ThemeDiyStyleLogic.isNeedDealDarkBri(paramResData, this.this$0.themeAdapter.selectResItem.index))
          {
            localObject = paramResData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDealFileName(paramResData.bgDiyPicRes, paramResData.position);
            if (new File((String)localObject).exists())
            {
              paramResData.bgDiyPicRes.state = 5;
              this.this$0.setSpThemeBackground(paramResData, paramInt1, true);
              paramResData.mSaveStatus = 6;
            }
          }
        }
      }
      for (;;)
      {
        if ((paramBundle != null) && (paramBundle.getInt("nextOperate") == 10))
        {
          this.this$0.mHandler.removeMessages(22);
          this.this$0.mHandler.sendMessageDelayed(Message.obtain(this.this$0.mHandler, 22, null), 50L);
        }
        return 1;
        paramResData.bgDiyPicRes.state = 2;
        this.this$0.setSpThemeBackground(paramResData, paramInt1, false);
        String str = paramResData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDownFileName(paramResData.bgDiyPicRes);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "saveStyleCallback: DarkBrightnessTask, orgPath:" + str);
        }
        new ThemeDiyStyleLogic.DarkBrightnessTask(this.this$0.mContext, this.this$0.app, str, (String)localObject, paramResData, paramBundle, this.this$0.saveStyleCallback).execute(new Object[0]);
        return 0;
        paramResData.bgDiyPicRes.state = 5;
        this.this$0.setSpThemeBackground(paramResData, paramInt1, true);
        paramResData.mSaveStatus = 6;
        continue;
        if (paramInt2 == 8)
        {
          this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景加载错误 " + paramInt1));
          QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DOWN_BG Error, pageIndex:" + paramInt1);
          return 0;
          if (14 == paramInt1)
          {
            localObject = this.this$0.showData[paramBundle.getInt("index")];
            if (localObject == null)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景压黑压白错误100"));
              QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DEAL_BG null == diyData, Index:" + paramBundle.getInt("index"));
              return 0;
            }
            if (((ThemeDIYData)localObject).bgDiyPicRes == null)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景压黑压白错误101"));
              QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DEAL_BG null == res.");
              return 0;
            }
            if (((ThemeDIYData)localObject).bgDiyPicRes != paramResData)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景压黑压白错误102"));
              QLog.e("ThemeDIYActivity", 1, "saveStyleCallback, OPERATE_KEY_DEAL_BG res change.");
              return 0;
            }
            if (paramInt2 == 4)
            {
              ((ThemeDIYData)localObject).mSaveStatus = 6;
              ((ThemeDIYData)localObject).bgDiyPicRes.state = 5;
              if (this.this$0.mUpdateUIPicAfterSaved)
              {
                paramResData = new Intent("com.tencent.qplus.THEME_INVALIDATE");
                paramResData.putExtra("pid", Process.myPid());
                this.this$0.mContext.sendBroadcast(paramResData, "com.tencent.msg.permission.pushnotify");
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "pic Save, isSaved = true, change pic.");
                }
              }
            }
            else if (paramInt2 == 8)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "背景压黑压白错误103"));
              QLog.e("ThemeDIYActivity", 2, "saveStyleCallback, OPERATE_KEY_DEAL_BG deal error." + ((ThemeDIYData)localObject).position);
              return 0;
            }
          }
          else if (12 == paramInt1)
          {
            if (paramInt2 == 4)
            {
              paramInt1 = this.this$0.themeDiyStyleLogic.downLoadStyleZip(this.this$0.themeAdapter.selectResItem, null, false);
              if (paramInt1 == 4)
              {
                this.this$0.themeAdapter.mSaveStatus = 6;
              }
              else if (paramInt1 == 8)
              {
                if (paramBundle.getString("operateBackCode") != null) {}
                for (paramBundle = paramBundle.getString("operateBackCode");; paramBundle = "-")
                {
                  this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "风格包解压失败:" + paramBundle + " - " + this.this$0.themeAdapter.selectResItem.id));
                  QLog.e("ThemeDIYActivity", 2, "saveStyleCallback, OPERATE_KEY_DOWN_STYLE_unzip error:" + paramBundle + " - " + this.this$0.themeAdapter.selectResItem.id);
                  return 0;
                }
              }
            }
            else if (paramInt2 == 8)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "风格包下载失败:" + this.this$0.themeAdapter.selectResItem.id));
              QLog.e("ThemeDIYActivity", 2, "saveStyleCallback, OPERATE_KEY_DOWN_STYLE_download error:" + this.this$0.themeAdapter.selectResItem.id);
              return 0;
            }
          }
          else if (16 == paramInt1)
          {
            paramResData = ThemeDiyStyleLogic.getThemeInfoByDensity(this.this$0.mContext, this.this$0.themeAdapter.selectResItem);
            if ((paramResData == null) || (paramBundle == null))
            {
              QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme server error Info == null.");
              return 0;
            }
            if (paramInt2 == 4)
            {
              if ((!TextUtils.isEmpty(paramResData.themeId)) && (paramResData.themeId.equals(paramBundle.getString("themeId"))))
              {
                this.this$0.mSaveToServerStatus = 6;
                if (QLog.isColorLevel()) {
                  QLog.d("ThemeDIYActivity", 2, "StyleCallBack:save theme server ok!!");
                }
              }
              else
              {
                QLog.d("ThemeDIYActivity", 1, "StyleCallBack:save theme server id change!!");
                return 0;
              }
            }
            else
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 26, "设置风格后台错误"));
              if ((!TextUtils.isEmpty(paramResData.themeId)) && (paramResData.themeId.equals(paramBundle.getString("themeId")))) {
                QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme server error 0");
              }
              for (;;)
              {
                return 0;
                QLog.d("ThemeDIYActivity", 1, "StyleCallBack:save theme server id change 2!!");
              }
            }
          }
          else if (15 == paramInt1)
          {
            if (paramInt2 == 4)
            {
              this.this$0.mUpdateUIPicAfterSaved = true;
              if (QLog.isColorLevel()) {
                QLog.d("ThemeDIYActivity", 2, "StyleCallBack:save theme ok!!");
              }
            }
            else if (paramInt2 == 8)
            {
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 26, "设置风格失败"));
              QLog.e("ThemeDIYActivity", 1, "StyleCallBack:save theme false, error type == " + paramInt2);
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */