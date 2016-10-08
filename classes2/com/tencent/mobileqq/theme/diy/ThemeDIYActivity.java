package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThemeHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.UniPayHandler;
import com.tencent.mobileqq.app.UniPayHandler.UniPayUpdateListener;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeDIYActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ScrollLayout.OnScreenChangeListener
{
  static final int BG_DEFAULT_POSITION = 1;
  static final int BG_UPLOAD_POSITION = 0;
  static final int HANDLER_MSG_OPRATE_SAVE = 22;
  static final int HANDLER_MSG_RES_DATA_CHANGED = 21;
  static final int HANDLER_MSG_RES_PIC_DOWNLOADED = 20;
  static final int HANDLER_MSG_SAVE_TIMEOUT = 24;
  static final int HANDLER_MSG_SCROLL_ADD_ITME = 10;
  static final int HANDLER_MSG_SET_PROGRESS_GONE = 26;
  static final int HANDLER_MSG_SET_PROGRESS_TEXT = 25;
  static final int HANDLER_MSG_SHOW_SCREEN_SHOT = 23;
  static final int HANDLER_MSG_SHOW_TOAST = 27;
  static final int PAGE_AIO = 2;
  static final int PAGE_MSG = 1;
  static final int PAGE_SETTING = 0;
  static final int STATE_END = 0;
  static final int STATE_RUN = 10;
  static final String TAG = "ThemeDIYActivity";
  static final int THEMESTATUS_FAIL = -1;
  static final int THEMESTATUS_NOT_SET = 0;
  static final int THEMESTATUS_SETED = 2;
  static final int THEMESTATUS_SETTING = 1;
  static final int THEME_DEFAULT_POSITION = 0;
  static boolean isBacked;
  static int themeStatus = 0;
  Animation.AnimationListener animatorListener = new ThemeDIYActivity.12(this);
  final int animatorTime = 300;
  ThemeDiyBgAdapter bgAdapter;
  ArrayList bgAllArray;
  HorizontalListView bgResHListView;
  Button btn_themeDiy_undo;
  Button btn_themeDiy_upload;
  int currentIndex;
  ThemeDIYActivity.DataLoading dataLoad;
  final String dealPng = "deal_";
  QQCustomDialog exitDialog;
  boolean isAniming;
  boolean isBigScreenType;
  boolean isClickTopButtonOpenVip;
  boolean isDIYThemeBefore;
  boolean isNotifyBack = true;
  boolean isShowPay = false;
  boolean isStyleMove;
  boolean isVip;
  ArrayList listStyle;
  String local_FilesDir;
  String local_User_FilesDir;
  Context mContext;
  Handler mHandler = new ThemeDIYActivity.10(this, Looper.getMainLooper());
  UniPayHandler.UniPayUpdateListener mObserver = new ThemeDIYActivity.8(this);
  int mSaveToServerStatus;
  ScrollLayout mScrollLayout;
  boolean mUpdateUIPicAfterSaved;
  float moveX;
  float moveY;
  PageIndicator pageIndicator;
  boolean panelStateOpen;
  QQProgressDialog progessDialog;
  DownloadListener resDownloadListener = new ThemeDIYActivity.9(this);
  AdapterView.OnItemClickListener resItemClickListener = new ThemeDIYActivity.13(this);
  ThemeDiyStyleLogic.StyleCallBack saveStyleCallback = new ThemeDIYActivity.5(this);
  final ThemeDIYData[] showData = { new ThemeDIYData("设置页", "drawer_v6_318x566.png", "drawer_bg.png", "drawer_v6_272x483.png", "drawer_bg.png", "theme_bg_setting_path", 2131427561, "theme_bg_setting_path_png", -50, "自定义-设置页背景", 0), new ThemeDIYData("通讯页", "chats_v6_318x566.png", null, "chats_v6_272x483.png", null, "theme_bg_message_path", 2131427560, "theme_bg_message_path_png", 50, "自定义-通讯页背景", 1), new ThemeDIYData("聊天背景页", "AIO_v6_318x566.png", "chat_background.png", "AIO_v6_272x483.png", "chat_background.png", "theme_bg_aio_path", 2131427562, "theme_bg_aio_path", 0, "自定义-聊天页背景", 2) };
  int stepY;
  LinearLayout stylePanel;
  int stylePanelHeight;
  int stylePanelMinH;
  HorizontalListView styleResHListView;
  ThemeDiyThemeAdapter themeAdapter;
  ArrayList themeAllArray;
  ThemeDiyStyleLogic themeDiyStyleLogic;
  ImageView theme_panel_arrow;
  UniPayHandler uniHandler;
  ValueAnimation.AnimationUpdateListener updateListener = new ThemeDIYActivity.11(this);
  ValueAnimation valueAnimatorDown;
  ValueAnimation valueAnimatorDrag;
  ValueAnimation valueAnimatorUp;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  static Drawable getAssetsDrawable(Context paramContext, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      Object localObject = paramContext.getResources().getAssets();
      try
      {
        paramString = ((AssetManager)localObject).open("themediy/skin_" + paramString);
        localObject = BitmapFactory.decodeStream(paramString);
        paramContext = new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        do
        {
          try
          {
            paramString.close();
            return paramContext;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              paramString = paramContext;
            }
          }
          catch (IOException localIOException2)
          {
            for (;;)
            {
              paramString = paramContext;
            }
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            for (;;)
            {
              paramString = paramContext;
            }
          }
          localOutOfMemoryError1 = localOutOfMemoryError1;
          paramString = null;
          paramContext = paramString;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localOutOfMemoryError1.getMessage());
        return paramString;
      }
      catch (IOException localIOException1)
      {
        do
        {
          paramString = null;
          paramContext = paramString;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localIOException1.getMessage());
        return paramString;
      }
      catch (Exception localException1)
      {
        do
        {
          paramString = null;
          paramContext = paramString;
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDIYActivity", 2, localException1.getMessage());
        return paramString;
      }
    }
  }
  
  public static Bitmap getLoacalBitmap(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeStream(new FileInputStream(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      QLog.d("ThemeDIYActivity", 1, "getLoacalBitmap1:" + paramString.getMessage());
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("ThemeDIYActivity", 1, "getLoacalBitmap2:" + paramString.getMessage());
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ThemeDIYActivity", 1, "getLoacalBitmap3:" + paramString.getMessage());
      }
    }
  }
  
  static Bundle getLoadParam(int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt1);
    localBundle.putInt("index", paramInt2);
    localBundle.putInt("picType", paramInt3);
    return localBundle;
  }
  
  void backgroundSave()
  {
    int i;
    Object localObject2;
    for (;;)
    {
      synchronized (this.showData)
      {
        if (!isNeedSave())
        {
          this.mHandler.removeMessages(24);
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave !isNeedSave()");
          }
          return;
        }
        this.mUpdateUIPicAfterSaved = false;
        i = 0;
        if (i >= this.showData.length) {
          break;
        }
        ThemeDIYData localThemeDIYData1 = this.showData[i];
        if (2 != localThemeDIYData1.mSetStatus)
        {
          localThemeDIYData1.mSaveStatus = 6;
        }
        else if ((localThemeDIYData1.mSaveStatus == 0) || (6 != localThemeDIYData1.mSaveStatus))
        {
          localThemeDIYData1.mSaveStatus = 4;
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave diyData.bgTryOnPosition:" + localThemeDIYData1.bgTryOnPosition + ", pageIndex:" + i);
          }
          if (1 == localThemeDIYData1.bgTryOnPosition)
          {
            localThemeDIYData1.bgDiyPicRes = null;
            localThemeDIYData1.intoDiyPic.name = "";
            localThemeDIYData1.intoDiyPic.id = Integer.parseInt("5000");
            ThemeBackground.clear(this.mContext, localThemeDIYData1.orgSpKey, this.app.a());
            if (!localThemeDIYData1.orgSpKey.equals(localThemeDIYData1.dealSpkey)) {
              ThemeBackground.clear(this.mContext, localThemeDIYData1.dealSpkey, this.app.a());
            }
            if (i == 2) {
              ChatBackground.b(this.mContext, this.app.getAccount(), null, "null");
            }
            ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_photosuccess", 0, 0, String.valueOf(i), "", "", "");
            if ((localThemeDIYData1.bgDiyPicRes != null) && (localThemeDIYData1.bgDiyPicRes.state != 5)) {
              break label1099;
            }
            localThemeDIYData1.mSaveStatus = 6;
            if (!QLog.isColorLevel()) {
              break label2735;
            }
            QLog.d("ThemeDIYActivity", 2, "backgroundSave bg diyData.mSaveStatus:" + localThemeDIYData1.mSaveStatus + ", pageIndex:" + i);
          }
        }
      }
      if (localThemeDIYData2.bgTryOnPosition == 0)
      {
        if (localThemeDIYData2.bgDiyPicRes != null)
        {
          localThemeDIYData2.intoDiyPic.name = localThemeDIYData2.bgDiyPicRes.name;
          localThemeDIYData2.intoDiyPic.id = localThemeDIYData2.bgDiyPicRes.id;
          ThemeBackground.setThemeBackgroundPic(this.mContext, localThemeDIYData2.orgSpKey, this.app.a(), localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.name);
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "backgroundSave page upload bg, page_i=" + i + ", orgSpKey:" + localThemeDIYData2.orgSpKey + ", path:" + localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.name);
          }
          if (!localThemeDIYData2.orgSpKey.equals(localThemeDIYData2.dealSpkey))
          {
            ThemeBackground.setThemeBackgroundPic(this.mContext, localThemeDIYData2.dealSpkey, this.app.a(), localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.dealedName);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave page upload bg, page_i=" + i + ", dealSpkey:" + localThemeDIYData2.dealSpkey + ", path:" + localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.dealedName);
            }
          }
          if (i == 2)
          {
            ChatBackground.b(this.mContext, this.app.getAccount(), null, localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.name);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave aio upload bg, path:" + localThemeDIYData2.bgDiyPicRes.path + localThemeDIYData2.bgDiyPicRes.name);
            }
          }
          localThemeDIYData2.bgDiyPicRes.state = 5;
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave page dont set bg, i=" + i);
        }
      }
      else
      {
        localObject2 = (ResItemHolder)this.bgAdapter.getItem(localThemeDIYData2.bgTryOnPosition);
        if (localObject2 == null) {}
        for (int j = Integer.parseInt("5000");; j = ((ResItemHolder)localObject2).id)
        {
          if ((j <= Integer.parseInt("5000")) || (j == localThemeDIYData2.intoDiyPic.id)) {
            break label1035;
          }
          if ((localThemeDIYData2.bgDiyPicRes == null) || (j != localThemeDIYData2.bgDiyPicRes.id)) {
            localThemeDIYData2.bgDiyPicRes = new ResData(((ResItemHolder)localObject2).resFileName, ((ResItemHolder)localObject2).id, ((ResItemHolder)localObject2).index, ThemeDiyStyleLogic.DIR_SCREENSHOT_BG, ((ResItemHolder)localObject2).pageUrl + ((ResItemHolder)localObject2).resFileName, 0, 0, 0, 0);
          }
          localThemeDIYData2.intoDiyPic.name = localThemeDIYData2.bgDiyPicRes.name;
          localThemeDIYData2.intoDiyPic.id = localThemeDIYData2.bgDiyPicRes.id;
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_yangtusuccess", 0, 0, String.valueOf(i), String.valueOf(localThemeDIYData2.intoDiyPic.id), "", "");
          break;
        }
        label1035:
        localThemeDIYData2.bgDiyPicRes = null;
        if (localThemeDIYData2.intoDiyPic != null)
        {
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_yangtusuccess", 0, 0, String.valueOf(i), String.valueOf(localThemeDIYData2.intoDiyPic.id), "", "");
          continue;
          label1099:
          if (localThemeDIYData2.bgDiyPicRes.state == 2)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("index", i);
            ((Bundle)localObject2).putInt("nowOperate", 14);
            ((Bundle)localObject2).putInt("nextOperate", 10);
            ((Bundle)localObject2).putInt("themeIndex", 0);
            j = this.themeDiyStyleLogic.dealDarkBrightness(localThemeDIYData2, (Bundle)localObject2);
            if (j == 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeDIYActivity", 2, "backgroundSave , deal bg, ok");
              }
              localThemeDIYData2.bgDiyPicRes.state = 5;
              setSpThemeBackground(localThemeDIYData2, i, true);
              localThemeDIYData2.mSaveStatus = 6;
            }
            else if (j == 8)
            {
              QLog.e("ThemeDIYActivity", 1, "backgroundSave , deal bg, error");
              this.saveStyleCallback.callback(14, 8, (Bundle)localObject2, localThemeDIYData2.bgDiyPicRes);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave , wait dealing pic, pageIndex:" + i);
            }
          }
          else if (localThemeDIYData2.bgDiyPicRes.state == 0)
          {
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("index", i);
            ((Bundle)localObject2).putInt("nowOperate", 13);
            ((Bundle)localObject2).putInt("nextOperate", 10);
            j = this.themeDiyStyleLogic.downLoadBgPic(localThemeDIYData2.bgDiyPicRes, (Bundle)localObject2);
            if (j == 4)
            {
              if (QLog.isColorLevel()) {
                QLog.d("ThemeDIYActivity", 2, "backgroundSave ,download pic ok, pageIndex:" + i);
              }
              if (ThemeDiyStyleLogic.isNeedDealDarkBri(localThemeDIYData2, this.themeAdapter.selectResItem.index))
              {
                if (new File(localThemeDIYData2.bgDiyPicRes.path, ThemeDiyStyleLogic.getDealFileName(localThemeDIYData2.bgDiyPicRes, i)).exists())
                {
                  localThemeDIYData2.bgDiyPicRes.state = 5;
                  setSpThemeBackground(localThemeDIYData2, i, true);
                  localThemeDIYData2.mSaveStatus = 6;
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ThemeDIYActivity", 2, "backgroundSave wait deal pic after down, pageIndex:" + i);
                  }
                  this.saveStyleCallback.callback(13, 4, (Bundle)localObject2, localThemeDIYData2.bgDiyPicRes);
                }
              }
              else
              {
                localThemeDIYData2.bgDiyPicRes.state = 5;
                setSpThemeBackground(localThemeDIYData2, i, true);
                localThemeDIYData2.mSaveStatus = 6;
              }
            }
            else if (j == 8)
            {
              QLog.e("ThemeDIYActivity", 1, "backgroundSave download bg, error");
              this.saveStyleCallback.callback(13, 8, (Bundle)localObject2, localThemeDIYData2.bgDiyPicRes);
            }
            else if (QLog.isColorLevel())
            {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave wait downloading pic, pageIndex:" + i);
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave deal bg, diyData.bgDiyPicRes.state:" + localThemeDIYData2.bgDiyPicRes.state);
            }
            localThemeDIYData2.mSaveStatus = 6;
          }
        }
      }
    }
    Object localObject3;
    Object localObject1;
    if (this.themeAdapter.selectResItem != null)
    {
      if (this.themeAdapter.mSaveStatus != 0) {
        break label2744;
      }
      this.themeAdapter.mSaveStatus = 4;
      localObject2 = ThemeUtil.getUserCurrentThemeId(this.app);
      this.themeAdapter.selectResItem.themeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, this.themeAdapter.selectResItem);
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder().append("backgroundSave, deal style, oldThemeID:").append((String)localObject2).append(", newID:");
        if (this.themeAdapter.selectResItem.themeInfo == null) {
          break label2753;
        }
        localObject1 = this.themeAdapter.selectResItem.themeInfo.themeId;
        label1771:
        QLog.d("ThemeDIYActivity", 2, (String)localObject1);
      }
      if ((!TextUtils.isEmpty(this.themeAdapter.selectResItem.themeInfo.themeId)) && (!this.themeAdapter.selectResItem.themeInfo.themeId.equals(localObject2)))
      {
        if (this.mSaveToServerStatus == 0)
        {
          this.mSaveToServerStatus = 4;
          localObject1 = new Bundle();
          ((Bundle)localObject1).putInt("nowOperate", 16);
          ((Bundle)localObject1).putInt("nextOperate", 10);
          ((ThemeHandler)this.app.a(14)).a(this.themeAdapter.selectResItem.themeInfo.themeId, this.themeAdapter.selectResItem.themeInfo.version, null, (Bundle)localObject1, this.saveStyleCallback);
        }
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("nowOperate", 12);
        ((Bundle)localObject1).putInt("nextOperate", 10);
        i = this.themeDiyStyleLogic.downLoadStyleZip(this.themeAdapter.selectResItem, (Bundle)localObject1, true);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave, themeDiyStyleLogic.downLoadStyleZip():" + i);
        }
        if (i == 4)
        {
          this.themeAdapter.mSaveStatus = 6;
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_stylesuccess", 0, 0, "", this.themeAdapter.selectResItem.themeInfo.themeId, "", "");
          break label2744;
        }
      }
    }
    for (;;)
    {
      boolean bool2;
      boolean bool1 = bool2;
      if (i < this.showData.length)
      {
        if (6 != this.showData[i].mSaveStatus) {
          bool1 = false;
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDIYActivity", 2, "backgroundSave, mSaveStatus:isReady=" + bool1 + ", iR:" + i + ", theme:" + this.themeAdapter.mSaveStatus + ", server:" + this.mSaveToServerStatus);
        }
        if ((bool1) && (6 == this.themeAdapter.mSaveStatus) && (6 == this.mSaveToServerStatus))
        {
          i = 0;
          for (;;)
          {
            if (i < this.showData.length)
            {
              this.showData[i].mSetStatus = 0;
              i += 1;
              continue;
              if (i == 8)
              {
                QLog.e("ThemeDIYActivity", 1, "backgroundSave, themeDiyStyleLogic.downLoadStyleZip Error");
                this.saveStyleCallback.callback(12, 8, (Bundle)localObject1, null);
                break;
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("ThemeDIYActivity", 2, "backgroundSave, waiting for themeDiyStyleLogic.downLoadStyleZip to back");
              break;
              this.mSaveToServerStatus = 6;
              this.themeAdapter.mSaveStatus = 6;
              ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_stylesuccess", 0, 0, "", this.themeAdapter.selectResItem.themeInfo.themeId, "", "");
              if (!QLog.isColorLevel()) {
                break label2744;
              }
              QLog.d("ThemeDIYActivity", 2, "backgroundSave, style ready!");
              break label2744;
              this.mSaveToServerStatus = 6;
              this.themeAdapter.mSaveStatus = 6;
              break label2744;
            }
          }
          this.themeAdapter.mSetStatus = 0;
          this.mHandler.removeMessages(24);
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_savesuccess", 0, 0, "", "", "", "");
          localObject1 = ThemeUtil.getUserCurrentThemeId(this.app);
          this.themeAdapter.selectResItem.themeInfo = ThemeDiyStyleLogic.getThemeInfoByDensity(this.mContext, this.themeAdapter.selectResItem);
          if ((localObject1 != null) && (!((String)localObject1).equals(this.themeAdapter.selectResItem.themeInfo.themeId)))
          {
            localObject2 = this.mContext;
            localObject3 = this.app;
            ThemeDiyStyleLogic.StyleCallBack localStyleCallBack = this.saveStyleCallback;
            if (this.themeDiyStyleLogic != null)
            {
              localObject1 = this.themeDiyStyleLogic.reportMap;
              new ThemeDiyStyleLogic.SwitchThemeTask((Context)localObject2, (QQAppInterface)localObject3, localStyleCallBack, (HashMap)localObject1).execute(new Object[] { this.themeAdapter.selectResItem.themeInfo.themeId, this.themeAdapter.selectResItem.themeInfo.version });
              if (QLog.isColorLevel()) {
                QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, switchThemeTask.execute(" + this.themeAdapter.selectResItem.themeInfo.themeId + ", " + this.themeAdapter.selectResItem.themeInfo.version + ");");
              }
            }
          }
        }
        for (;;)
        {
          return;
          localObject1 = null;
          break;
          try
          {
            Thread.sleep(1100L);
            localObject1 = new Intent("com.tencent.qplus.THEME_INVALIDATE");
            ((Intent)localObject1).putExtra("pid", Process.myPid());
            this.mContext.sendBroadcast((Intent)localObject1, "com.tencent.msg.permission.pushnotify");
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave, isSaveDataOk = true, dont change theme.");
            }
            this.mUpdateUIPicAfterSaved = true;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("ThemeDIYActivity", 2, "backgroundSave, waiting status.");
            }
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
        }
        label2735:
        i += 1;
        break;
        label2744:
        bool2 = true;
        i = 0;
        continue;
        label2753:
        String str = "null";
        break label1771;
      }
      i += 1;
    }
  }
  
  int compareVersion(String paramString1, String paramString2)
  {
    int m = 0;
    int j;
    if ((paramString1 == null) || (paramString2 == null))
    {
      j = 1;
      return j;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int n = Math.max(paramString1.length, paramString2.length);
    int i = 0;
    for (;;)
    {
      j = m;
      if (i >= n) {
        break;
      }
      if (i >= paramString1.length)
      {
        j = 0;
        if (i < paramString2.length) {
          break label95;
        }
      }
      label95:
      for (int k = 0;; k = Integer.valueOf(paramString2[i]).intValue())
      {
        if (j >= k) {
          break label109;
        }
        return 1;
        j = Integer.valueOf(paramString1[i]).intValue();
        break;
      }
      label109:
      if (j > k) {
        return -1;
      }
      i += 1;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.isAniming) || (this.stylePanel == null) || (this.stylePanel.getLayoutParams() == null)) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    float f = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        for (;;)
        {
          return super.dispatchTouchEvent(paramMotionEvent);
          this.moveY = f;
          this.moveX = paramMotionEvent.getX();
        }
      } while ((Math.abs(this.moveY - f) <= Math.abs(this.moveX - paramMotionEvent.getX())) || (Math.abs(this.moveY - f) <= this.stepY));
      this.isStyleMove = true;
      int i = this.stylePanel.getLayoutParams().height;
      i = (int)(0.3D * (this.moveY - f)) + i;
      if (i >= this.stylePanelHeight) {
        this.stylePanel.getLayoutParams().height = this.stylePanelHeight;
      }
      for (;;)
      {
        this.stylePanel.requestLayout();
        break;
        if (i <= this.stylePanelMinH) {
          this.stylePanel.getLayoutParams().height = this.stylePanelMinH;
        } else {
          this.stylePanel.getLayoutParams().height = i;
        }
      }
    }
    if (this.isStyleMove)
    {
      if (this.stylePanel.getLayoutParams().height - this.stylePanelMinH <= this.stylePanelHeight - this.stylePanel.getLayoutParams().height) {
        break label352;
      }
      performAnimate(this.stylePanel.getLayoutParams().height, this.stylePanelHeight, true, 300, false);
      this.theme_panel_arrow.setImageResource(2130841878);
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_slide", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.isStyleMove = false;
      break;
      label352:
      performAnimate(this.stylePanel.getLayoutParams().height, this.stylePanelMinH, false, 300, false);
      this.theme_panel_arrow.setImageResource(2130839401);
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_decline", 0, 0, "", "", "", "");
    }
  }
  
  /* Error */
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_4
    //   2: if_icmpne +222 -> 224
    //   5: aload_3
    //   6: ifnull +218 -> 224
    //   9: ldc_w 797
    //   12: aload_3
    //   13: ldc_w 799
    //   16: invokevirtual 803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokevirtual 430	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +202 -> 224
    //   25: aload_3
    //   26: ldc_w 805
    //   29: invokevirtual 803	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_3
    //   33: iconst_m1
    //   34: istore_2
    //   35: iconst_m1
    //   36: istore 6
    //   38: new 807	org/json/JSONObject
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 808	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore_3
    //   47: iload 6
    //   49: istore_1
    //   50: aload_3
    //   51: ldc_w 810
    //   54: invokevirtual 813	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: istore 5
    //   62: iload 6
    //   64: istore_1
    //   65: iload 5
    //   67: istore_2
    //   68: aload_3
    //   69: ldc_w 815
    //   72: invokevirtual 813	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   78: istore 6
    //   80: iload 6
    //   82: istore_1
    //   83: iload 5
    //   85: istore_2
    //   86: aload_3
    //   87: ldc_w 817
    //   90: invokevirtual 813	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   96: istore 7
    //   98: iload 7
    //   100: istore_1
    //   101: iload 5
    //   103: istore_2
    //   104: iload_1
    //   105: istore 5
    //   107: aload_3
    //   108: ifnull +116 -> 224
    //   111: iload_2
    //   112: ifne +112 -> 224
    //   115: iload 6
    //   117: ifne +107 -> 224
    //   120: iload 5
    //   122: ifne +102 -> 224
    //   125: aload_0
    //   126: getfield 819	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isClickTopButtonOpenVip	Z
    //   129: ifeq +117 -> 246
    //   132: aload_0
    //   133: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   136: ldc_w 443
    //   139: ldc_w 385
    //   142: aload_0
    //   143: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   146: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   149: ldc_w 445
    //   152: ldc_w 821
    //   155: iconst_0
    //   156: iconst_1
    //   157: ldc_w 385
    //   160: ldc_w 385
    //   163: ldc_w 385
    //   166: ldc_w 385
    //   169: invokestatic 456	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_0
    //   173: iconst_1
    //   174: putfield 823	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   177: aload_0
    //   178: getfield 225	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mHandler	Landroid/os/Handler;
    //   181: bipush 22
    //   183: invokevirtual 356	android/os/Handler:removeMessages	(I)V
    //   186: aload_0
    //   187: getfield 225	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mHandler	Landroid/os/Handler;
    //   190: aload_0
    //   191: getfield 225	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mHandler	Landroid/os/Handler;
    //   194: bipush 22
    //   196: iconst_1
    //   197: invokestatic 828	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   200: invokestatic 834	android/os/Message:obtain	(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;
    //   203: invokevirtual 838	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   206: pop
    //   207: aload_0
    //   208: getfield 840	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   211: ifnull +13 -> 224
    //   214: aload_0
    //   215: getfield 840	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   218: ldc_w 385
    //   221: invokevirtual 844	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   224: return
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_3
    //   229: iload 6
    //   231: istore_1
    //   232: aload 4
    //   234: invokevirtual 847	java/lang/Exception:printStackTrace	()V
    //   237: iconst_m1
    //   238: istore 5
    //   240: iload_1
    //   241: istore 6
    //   243: goto -136 -> 107
    //   246: aload_0
    //   247: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   250: ldc_w 443
    //   253: ldc_w 385
    //   256: aload_0
    //   257: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   260: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   263: ldc_w 445
    //   266: ldc_w 849
    //   269: iconst_0
    //   270: iconst_1
    //   271: ldc_w 385
    //   274: ldc_w 385
    //   277: ldc_w 385
    //   280: ldc_w 385
    //   283: invokestatic 456	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   286: goto -114 -> 172
    //   289: astore 4
    //   291: goto -59 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	ThemeDIYActivity
    //   0	294	1	paramInt1	int
    //   0	294	2	paramInt2	int
    //   0	294	3	paramIntent	Intent
    //   225	8	4	localException1	Exception
    //   289	1	4	localException2	Exception
    //   60	179	5	i	int
    //   36	206	6	j	int
    //   96	3	7	k	int
    // Exception table:
    //   from	to	target	type
    //   38	47	225	java/lang/Exception
    //   50	62	289	java/lang/Exception
    //   68	80	289	java/lang/Exception
    //   86	98	289	java/lang/Exception
  }
  
  /* Error */
  public boolean doOnCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 855	com/tencent/mobileqq/app/IphoneTitleBarActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: aload_0
    //   8: putfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   11: aload_0
    //   12: new 500	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic
    //   15: dup
    //   16: aload_0
    //   17: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   20: aload_0
    //   21: invokespecial 858	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;)V
    //   24: putfield 519	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeDiyStyleLogic	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic;
    //   27: aload_0
    //   28: getfield 519	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeDiyStyleLogic	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic;
    //   31: aload_0
    //   32: getfield 202	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:saveStyleCallback	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$StyleCallBack;
    //   35: putfield 861	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic:saveDealCallBack	Lcom/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic$StyleCallBack;
    //   38: iconst_0
    //   39: putstatic 863	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBacked	Z
    //   42: aload_0
    //   43: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   46: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: ldc_w 864
    //   54: invokespecial 867	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentView	(I)V
    //   57: aload_0
    //   58: ldc_w 868
    //   61: invokespecial 871	com/tencent/mobileqq/app/IphoneTitleBarActivity:setTitle	(I)V
    //   64: aload_0
    //   65: ldc_w 872
    //   68: aload_0
    //   69: invokespecial 876	com/tencent/mobileqq/app/IphoneTitleBarActivity:setRightButton	(ILandroid/view/View$OnClickListener;)V
    //   72: aload_0
    //   73: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: ldc_w 443
    //   79: ldc_w 385
    //   82: aload_0
    //   83: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   86: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   89: ldc_w 445
    //   92: ldc_w 878
    //   95: iconst_0
    //   96: iconst_0
    //   97: ldc_w 385
    //   100: ldc_w 385
    //   103: ldc_w 385
    //   106: ldc_w 385
    //   109: invokestatic 456	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_0
    //   113: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   116: invokevirtual 256	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   119: invokevirtual 882	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   122: getfield 887	android/util/DisplayMetrics:heightPixels	I
    //   125: istore 8
    //   127: aload_0
    //   128: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   131: invokevirtual 256	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   134: invokevirtual 882	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   137: getfield 890	android/util/DisplayMetrics:widthPixels	I
    //   140: istore 9
    //   142: iload 8
    //   144: iload 9
    //   146: invokestatic 893	java/lang/Math:min	(II)I
    //   149: sipush 640
    //   152: if_icmple +243 -> 395
    //   155: iconst_1
    //   156: istore 13
    //   158: aload_0
    //   159: iload 13
    //   161: putfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   164: aload_0
    //   165: new 264	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   172: getstatic 900	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   175: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: ldc_w 902
    //   181: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: putfield 904	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:local_FilesDir	Ljava/lang/String;
    //   190: new 559	java/io/File
    //   193: dup
    //   194: aload_0
    //   195: getfield 904	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:local_FilesDir	Ljava/lang/String;
    //   198: invokespecial 905	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore_2
    //   202: aload_2
    //   203: invokevirtual 569	java/io/File:exists	()Z
    //   206: ifne +8 -> 214
    //   209: aload_2
    //   210: invokevirtual 908	java/io/File:mkdirs	()Z
    //   213: pop
    //   214: aload_0
    //   215: new 264	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   222: getstatic 900	com/tencent/mobileqq/app/AppConstants:bj	Ljava/lang/String;
    //   225: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   232: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   235: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 910
    //   241: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 902
    //   247: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: putfield 912	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:local_User_FilesDir	Ljava/lang/String;
    //   256: aload_0
    //   257: aconst_null
    //   258: invokestatic 916	com/tencent/mobileqq/theme/ThemeUtil:getIsDIYTheme	(Ljava/lang/String;)Z
    //   261: putfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   264: aload_0
    //   265: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   268: bipush 13
    //   270: invokevirtual 612	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   273: checkcast 920	com/tencent/mobileqq/app/SVIPHandler
    //   276: invokevirtual 923	com/tencent/mobileqq/app/SVIPHandler:h	()I
    //   279: iconst_1
    //   280: if_icmplt +121 -> 401
    //   283: iconst_1
    //   284: istore 13
    //   286: aload_0
    //   287: iload 13
    //   289: putfield 823	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   292: aload_0
    //   293: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   296: ifeq +111 -> 407
    //   299: iconst_2
    //   300: istore 7
    //   302: iload 7
    //   304: putstatic 135	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeStatus	I
    //   307: aload_0
    //   308: getfield 823	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   311: ifeq +10 -> 321
    //   314: aload_0
    //   315: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   318: ifne +95 -> 413
    //   321: iconst_0
    //   322: istore 7
    //   324: aload_0
    //   325: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   328: arraylength
    //   329: istore 10
    //   331: iload 7
    //   333: iload 10
    //   335: if_icmpge +78 -> 413
    //   338: aload_0
    //   339: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   342: aload_0
    //   343: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   346: iload 7
    //   348: aaload
    //   349: getfield 406	com/tencent/mobileqq/theme/diy/ThemeDIYData:orgSpKey	Ljava/lang/String;
    //   352: aload_0
    //   353: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   356: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   359: invokestatic 421	com/tencent/mobileqq/theme/diy/ThemeBackground:clear	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_0
    //   363: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   366: aload_0
    //   367: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   370: iload 7
    //   372: aaload
    //   373: getfield 424	com/tencent/mobileqq/theme/diy/ThemeDIYData:dealSpkey	Ljava/lang/String;
    //   376: aload_0
    //   377: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   380: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   383: invokestatic 421	com/tencent/mobileqq/theme/diy/ThemeBackground:clear	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   386: iload 7
    //   388: iconst_1
    //   389: iadd
    //   390: istore 7
    //   392: goto -61 -> 331
    //   395: iconst_0
    //   396: istore 13
    //   398: goto -240 -> 158
    //   401: iconst_0
    //   402: istore 13
    //   404: goto -118 -> 286
    //   407: iconst_0
    //   408: istore 7
    //   410: goto -108 -> 302
    //   413: invokestatic 927	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   416: ldc_w 928
    //   419: invokevirtual 929	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   422: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   425: istore 7
    //   427: invokestatic 303	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +82 -> 512
    //   433: ldc 41
    //   435: iconst_2
    //   436: new 264	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 931
    //   446: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_1
    //   450: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: ldc_w 933
    //   456: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_0
    //   460: getfield 823	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   463: invokevirtual 633	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   466: ldc_w 935
    //   469: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: aload_0
    //   473: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   476: invokevirtual 633	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   479: ldc_w 937
    //   482: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: iload 7
    //   487: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: ldc_w 939
    //   493: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   500: invokestatic 584	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   503: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 310	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: new 941	java/util/HashMap
    //   515: dup
    //   516: invokespecial 942	java/util/HashMap:<init>	()V
    //   519: astore_1
    //   520: aload_1
    //   521: ldc_w 944
    //   524: aload_0
    //   525: getfield 823	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isVip	Z
    //   528: invokestatic 947	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   531: invokevirtual 951	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   534: pop
    //   535: aload_1
    //   536: ldc_w 953
    //   539: aload_0
    //   540: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   543: invokestatic 584	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   546: invokevirtual 951	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   549: pop
    //   550: aload_1
    //   551: ldc_w 955
    //   554: iload 7
    //   556: invokestatic 451	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   559: invokevirtual 951	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   562: pop
    //   563: aload_1
    //   564: ldc_w 957
    //   567: aload_0
    //   568: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   571: invokestatic 947	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   574: invokevirtual 951	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   577: pop
    //   578: aload_0
    //   579: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   582: invokestatic 962	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   585: aload_0
    //   586: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   589: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   592: ldc_w 964
    //   595: iconst_1
    //   596: lconst_1
    //   597: lconst_0
    //   598: aload_1
    //   599: ldc_w 385
    //   602: iconst_0
    //   603: invokevirtual 967	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   606: aload_0
    //   607: aload_0
    //   608: ldc_w 968
    //   611: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   614: checkcast 785	android/widget/ImageView
    //   617: putfield 782	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:theme_panel_arrow	Landroid/widget/ImageView;
    //   620: aload_0
    //   621: aload_0
    //   622: ldc_w 973
    //   625: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   628: checkcast 975	android/widget/Button
    //   631: putfield 977	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:btn_themeDiy_upload	Landroid/widget/Button;
    //   634: aload_0
    //   635: aload_0
    //   636: ldc_w 978
    //   639: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   642: checkcast 975	android/widget/Button
    //   645: putfield 980	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:btn_themeDiy_undo	Landroid/widget/Button;
    //   648: aload_0
    //   649: getfield 977	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:btn_themeDiy_upload	Landroid/widget/Button;
    //   652: aload_0
    //   653: invokevirtual 984	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   656: aload_0
    //   657: getfield 980	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:btn_themeDiy_undo	Landroid/widget/Button;
    //   660: aload_0
    //   661: invokevirtual 984	android/widget/Button:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   664: aload_0
    //   665: aload_0
    //   666: ldc_w 985
    //   669: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   672: checkcast 987	com/tencent/mobileqq/theme/diy/ScrollLayout
    //   675: putfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   678: aload_0
    //   679: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   682: aload_0
    //   683: invokevirtual 993	com/tencent/mobileqq/theme/diy/ScrollLayout:setOnScreenChangeListener	(Lcom/tencent/mobileqq/theme/diy/ScrollLayout$OnScreenChangeListener;)V
    //   686: aload_0
    //   687: aload_0
    //   688: ldc_w 994
    //   691: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   694: checkcast 732	android/widget/LinearLayout
    //   697: putfield 730	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:stylePanel	Landroid/widget/LinearLayout;
    //   700: aload_0
    //   701: aload_0
    //   702: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   705: ldc_w 995
    //   708: invokestatic 1000	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   711: f2i
    //   712: putfield 771	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:stylePanelHeight	I
    //   715: aload_0
    //   716: aload_0
    //   717: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   720: ldc_w 1001
    //   723: invokestatic 1000	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   726: f2i
    //   727: putfield 776	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:stylePanelMinH	I
    //   730: aload_0
    //   731: aload_0
    //   732: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   735: ldc_w 1001
    //   738: invokestatic 1000	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   741: f2i
    //   742: putfield 760	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:stepY	I
    //   745: iload 8
    //   747: iload 9
    //   749: invokestatic 718	java/lang/Math:max	(II)I
    //   752: i2f
    //   753: aload_0
    //   754: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   757: sipush 305
    //   760: i2f
    //   761: invokestatic 1000	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   764: fsub
    //   765: f2i
    //   766: iconst_5
    //   767: imul
    //   768: bipush 6
    //   770: idiv
    //   771: istore 11
    //   773: iload 11
    //   775: sipush 322
    //   778: imul
    //   779: sipush 572
    //   782: idiv
    //   783: istore 12
    //   785: aload_0
    //   786: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   789: invokestatic 1007	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   792: astore_3
    //   793: iconst_0
    //   794: istore 9
    //   796: iload 9
    //   798: aload_0
    //   799: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   802: arraylength
    //   803: if_icmpge +937 -> 1740
    //   806: iconst_1
    //   807: iload 9
    //   809: if_icmpeq +114 -> 923
    //   812: aload_0
    //   813: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   816: ifeq +754 -> 1570
    //   819: aload_0
    //   820: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   823: iload 9
    //   825: aaload
    //   826: getfield 1010	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgBig	Ljava/lang/String;
    //   829: astore_1
    //   830: ldc_w 392
    //   833: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   836: istore 8
    //   838: getstatic 503	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic:DIR_SCREENSHOT_BG	Ljava/lang/String;
    //   841: astore 4
    //   843: new 264	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   850: ldc_w 1012
    //   853: invokestatic 1016	com/tencent/mobileqq/vas/IndividuationUrlHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   856: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: astore 5
    //   861: aload_0
    //   862: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   865: ifeq +719 -> 1584
    //   868: aload_0
    //   869: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   872: iload 9
    //   874: aaload
    //   875: getfield 1010	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgBig	Ljava/lang/String;
    //   878: astore_2
    //   879: new 387	com/tencent/mobileqq/theme/diy/ResData
    //   882: dup
    //   883: aload_1
    //   884: iload 8
    //   886: iload 9
    //   888: aload 4
    //   890: aload 5
    //   892: aload_2
    //   893: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: iconst_0
    //   900: iconst_0
    //   901: iconst_3
    //   902: iconst_0
    //   903: invokespecial 509	com/tencent/mobileqq/theme/diy/ResData:<init>	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIII)V
    //   906: astore_1
    //   907: aload_1
    //   908: iconst_2
    //   909: putfield 1018	com/tencent/mobileqq/theme/diy/ResData:from	I
    //   912: aload_0
    //   913: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   916: iload 9
    //   918: aaload
    //   919: aload_1
    //   920: putfield 1021	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgDefaultPic	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   923: new 417	com/tencent/mobileqq/theme/diy/ThemeBackground
    //   926: dup
    //   927: invokespecial 1022	com/tencent/mobileqq/theme/diy/ThemeBackground:<init>	()V
    //   930: astore 4
    //   932: iconst_2
    //   933: iload 9
    //   935: if_icmpne +663 -> 1598
    //   938: aload 4
    //   940: aload_0
    //   941: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   944: bipush 62
    //   946: invokevirtual 1026	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   949: checkcast 1028	com/tencent/mobileqq/model/ChatBackgroundManager
    //   952: aconst_null
    //   953: invokevirtual 1030	com/tencent/mobileqq/model/ChatBackgroundManager:b	(Ljava/lang/String;)Ljava/lang/String;
    //   956: putfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   959: ldc_w 435
    //   962: aload 4
    //   964: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   967: invokevirtual 430	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   970: ifne +55 -> 1025
    //   973: aload 4
    //   975: aload_0
    //   976: aload 4
    //   978: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   981: iconst_0
    //   982: aload 4
    //   984: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   987: ldc_w 910
    //   990: invokevirtual 1034	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   993: iconst_1
    //   994: iadd
    //   995: invokevirtual 1038	java/lang/String:substring	(II)Ljava/lang/String;
    //   998: aload 4
    //   1000: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1003: aload 4
    //   1005: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1008: ldc_w 910
    //   1011: invokevirtual 1034	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1014: iconst_1
    //   1015: iadd
    //   1016: invokevirtual 1040	java/lang/String:substring	(I)Ljava/lang/String;
    //   1019: invokevirtual 1044	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:getLocalDrawable	(Ljava/lang/String;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   1022: putfield 1048	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1025: ldc_w 385
    //   1028: astore_2
    //   1029: ldc_w 392
    //   1032: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1035: istore 10
    //   1037: aload_2
    //   1038: astore_1
    //   1039: iload 10
    //   1041: istore 8
    //   1043: aload 4
    //   1045: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1048: ifnull +75 -> 1123
    //   1051: aload_2
    //   1052: astore_1
    //   1053: iload 10
    //   1055: istore 8
    //   1057: ldc_w 435
    //   1060: aload 4
    //   1062: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1065: invokevirtual 430	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1068: ifne +55 -> 1123
    //   1071: aload 4
    //   1073: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1076: aload 4
    //   1078: getfield 1031	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   1081: ldc_w 910
    //   1084: invokevirtual 1034	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   1087: iconst_1
    //   1088: iadd
    //   1089: invokevirtual 1040	java/lang/String:substring	(I)Ljava/lang/String;
    //   1092: astore_2
    //   1093: aload_2
    //   1094: ldc_w 1050
    //   1097: invokevirtual 712	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1100: astore 5
    //   1102: aload 5
    //   1104: arraylength
    //   1105: iconst_3
    //   1106: if_icmplt +529 -> 1635
    //   1109: aload 5
    //   1111: iconst_2
    //   1112: aaload
    //   1113: astore_1
    //   1114: aload 5
    //   1116: iconst_1
    //   1117: aaload
    //   1118: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1121: istore 8
    //   1123: aload_0
    //   1124: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1127: iload 9
    //   1129: aaload
    //   1130: astore_2
    //   1131: ldc_w 1052
    //   1134: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1137: iload 8
    //   1139: if_icmpne +532 -> 1671
    //   1142: iconst_0
    //   1143: istore 10
    //   1145: aload_2
    //   1146: iload 10
    //   1148: putfield 371	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgTryOnPosition	I
    //   1151: aload_0
    //   1152: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1155: iload 9
    //   1157: aaload
    //   1158: new 387	com/tencent/mobileqq/theme/diy/ResData
    //   1161: dup
    //   1162: aload_1
    //   1163: iload 8
    //   1165: iload 9
    //   1167: aconst_null
    //   1168: aconst_null
    //   1169: iconst_5
    //   1170: iconst_0
    //   1171: iconst_0
    //   1172: iconst_1
    //   1173: invokespecial 509	com/tencent/mobileqq/theme/diy/ResData:<init>	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIII)V
    //   1176: putfield 383	com/tencent/mobileqq/theme/diy/ThemeDIYData:intoDiyPic	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   1179: aload_0
    //   1180: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   1183: ifeq +14 -> 1197
    //   1186: iload 7
    //   1188: ldc_w 1054
    //   1191: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1194: if_icmpne +109 -> 1303
    //   1197: aload_0
    //   1198: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   1201: ifeq +476 -> 1677
    //   1204: aload_0
    //   1205: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1208: iload 9
    //   1210: aaload
    //   1211: getfield 1057	com/tencent/mobileqq/theme/diy/ThemeDIYData:imgBig	Ljava/lang/String;
    //   1214: astore_1
    //   1215: ldc_w 1054
    //   1218: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1221: istore 8
    //   1223: getstatic 503	com/tencent/mobileqq/theme/diy/ThemeDiyStyleLogic:DIR_SCREENSHOT_BG	Ljava/lang/String;
    //   1226: astore 5
    //   1228: new 264	java/lang/StringBuilder
    //   1231: dup
    //   1232: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1235: ldc_w 1012
    //   1238: invokestatic 1016	com/tencent/mobileqq/vas/IndividuationUrlHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1241: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1244: astore 6
    //   1246: aload_0
    //   1247: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   1250: ifeq +441 -> 1691
    //   1253: aload_0
    //   1254: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1257: iload 9
    //   1259: aaload
    //   1260: getfield 1057	com/tencent/mobileqq/theme/diy/ThemeDIYData:imgBig	Ljava/lang/String;
    //   1263: astore_2
    //   1264: new 387	com/tencent/mobileqq/theme/diy/ResData
    //   1267: dup
    //   1268: aload_1
    //   1269: iload 8
    //   1271: iload 9
    //   1273: aload 5
    //   1275: aload 6
    //   1277: aload_2
    //   1278: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: iconst_0
    //   1285: iconst_0
    //   1286: iconst_2
    //   1287: iconst_0
    //   1288: invokespecial 509	com/tencent/mobileqq/theme/diy/ResData:<init>	(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;IIII)V
    //   1291: astore_1
    //   1292: aload_0
    //   1293: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1296: iload 9
    //   1298: aaload
    //   1299: aload_1
    //   1300: putfield 1060	com/tencent/mobileqq/theme/diy/ThemeDIYData:screenShot	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   1303: new 1062	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder
    //   1306: dup
    //   1307: invokespecial 1063	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:<init>	()V
    //   1310: astore_1
    //   1311: aload_1
    //   1312: iload 9
    //   1314: putfield 1064	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:id	I
    //   1317: aload_3
    //   1318: ldc_w 1065
    //   1321: aconst_null
    //   1322: invokevirtual 1069	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1325: astore_2
    //   1326: aload_1
    //   1327: aload_2
    //   1328: ldc_w 1070
    //   1331: invokevirtual 1073	android/view/View:findViewById	(I)Landroid/view/View;
    //   1334: putfield 1077	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:scaleView	Landroid/view/View;
    //   1337: aload_2
    //   1338: aload_1
    //   1339: invokevirtual 1081	android/view/View:setTag	(Ljava/lang/Object;)V
    //   1342: aload_1
    //   1343: aload_2
    //   1344: ldc_w 1082
    //   1347: invokevirtual 1073	android/view/View:findViewById	(I)Landroid/view/View;
    //   1350: checkcast 1084	android/widget/RelativeLayout
    //   1353: putfield 1088	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mRLayout	Landroid/widget/RelativeLayout;
    //   1356: aload_1
    //   1357: getfield 1088	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mRLayout	Landroid/widget/RelativeLayout;
    //   1360: invokevirtual 1089	android/widget/RelativeLayout:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   1363: checkcast 1091	android/widget/RelativeLayout$LayoutParams
    //   1366: astore 5
    //   1368: aload 5
    //   1370: iload 12
    //   1372: putfield 1094	android/widget/RelativeLayout$LayoutParams:width	I
    //   1375: aload 5
    //   1377: iload 11
    //   1379: putfield 1095	android/widget/RelativeLayout$LayoutParams:height	I
    //   1382: aload_0
    //   1383: aload_1
    //   1384: iload 9
    //   1386: iconst_0
    //   1387: invokevirtual 1099	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showDefaultImage	(Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder;IZ)Z
    //   1390: pop
    //   1391: aload_1
    //   1392: aload_2
    //   1393: ldc_w 1100
    //   1396: invokevirtual 1073	android/view/View:findViewById	(I)Landroid/view/View;
    //   1399: checkcast 785	android/widget/ImageView
    //   1402: putfield 1103	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImg	Landroid/widget/ImageView;
    //   1405: aload_0
    //   1406: aload_1
    //   1407: iload 9
    //   1409: iconst_0
    //   1410: invokevirtual 1106	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showScreenShot	(Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder;IZ)Z
    //   1413: pop
    //   1414: aload_2
    //   1415: ldc_w 1107
    //   1418: invokevirtual 1073	android/view/View:findViewById	(I)Landroid/view/View;
    //   1421: checkcast 785	android/widget/ImageView
    //   1424: astore 5
    //   1426: aload 5
    //   1428: aload_0
    //   1429: invokevirtual 1108	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:getResources	()Landroid/content/res/Resources;
    //   1432: aload_0
    //   1433: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1436: iload 9
    //   1438: aaload
    //   1439: getfield 1111	com/tencent/mobileqq/theme/diy/ThemeDIYData:orgMarkColor	I
    //   1442: invokevirtual 1115	android/content/res/Resources:getColor	(I)I
    //   1445: invokevirtual 1118	android/widget/ImageView:setBackgroundColor	(I)V
    //   1448: iload 9
    //   1450: ifne +9 -> 1459
    //   1453: aload_1
    //   1454: aload 5
    //   1456: putfield 1121	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImgColor	Landroid/widget/ImageView;
    //   1459: aload_1
    //   1460: aload_2
    //   1461: ldc_w 1122
    //   1464: invokevirtual 1073	android/view/View:findViewById	(I)Landroid/view/View;
    //   1467: checkcast 785	android/widget/ImageView
    //   1470: putfield 1125	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImageDiy	Landroid/widget/ImageView;
    //   1473: aload_1
    //   1474: getfield 1125	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImageDiy	Landroid/widget/ImageView;
    //   1477: aload 4
    //   1479: invokevirtual 1126	android/widget/ImageView:setTag	(Ljava/lang/Object;)V
    //   1482: aload 4
    //   1484: getfield 1048	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1487: ifnull +218 -> 1705
    //   1490: aload_1
    //   1491: getfield 1125	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImageDiy	Landroid/widget/ImageView;
    //   1494: aload 4
    //   1496: getfield 1048	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   1499: invokevirtual 1130	android/widget/ImageView:setBackgroundDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1502: iload 9
    //   1504: ifle +220 -> 1724
    //   1507: aload_0
    //   1508: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   1511: aload_2
    //   1512: iconst_1
    //   1513: sipush 800
    //   1516: invokevirtual 1134	com/tencent/mobileqq/theme/diy/ScrollLayout:changeAlpha	(Landroid/view/View;ZI)Z
    //   1519: pop
    //   1520: aload_0
    //   1521: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   1524: aload_2
    //   1525: invokevirtual 1138	com/tencent/mobileqq/theme/diy/ScrollLayout:addView	(Landroid/view/View;)V
    //   1528: aload_0
    //   1529: aload_1
    //   1530: iload 9
    //   1532: iconst_1
    //   1533: invokevirtual 1142	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:setProgressBar	(Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder;IZ)V
    //   1536: iload 9
    //   1538: iconst_1
    //   1539: iadd
    //   1540: istore 9
    //   1542: goto -746 -> 796
    //   1545: astore_2
    //   1546: aload_0
    //   1547: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1550: invokestatic 584	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   1553: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1556: istore 7
    //   1558: goto -1131 -> 427
    //   1561: astore_2
    //   1562: sipush 1000
    //   1565: istore 7
    //   1567: goto -1140 -> 427
    //   1570: aload_0
    //   1571: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1574: iload 9
    //   1576: aaload
    //   1577: getfield 1145	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgSmall	Ljava/lang/String;
    //   1580: astore_1
    //   1581: goto -751 -> 830
    //   1584: aload_0
    //   1585: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1588: iload 9
    //   1590: aaload
    //   1591: getfield 1145	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgSmall	Ljava/lang/String;
    //   1594: astore_2
    //   1595: goto -716 -> 879
    //   1598: aload_0
    //   1599: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   1602: ifeq -577 -> 1025
    //   1605: aload_0
    //   1606: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   1609: aload_0
    //   1610: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1613: iload 9
    //   1615: aaload
    //   1616: getfield 406	com/tencent/mobileqq/theme/diy/ThemeDIYData:orgSpKey	Ljava/lang/String;
    //   1619: aload_0
    //   1620: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1623: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1626: aload 4
    //   1628: invokestatic 1149	com/tencent/mobileqq/theme/diy/ThemeBackground:getThemeBackground	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/theme/diy/ThemeBackground;)Z
    //   1631: pop
    //   1632: goto -607 -> 1025
    //   1635: aload_2
    //   1636: astore_1
    //   1637: iload 10
    //   1639: istore 8
    //   1641: iconst_2
    //   1642: iload 9
    //   1644: if_icmpne -521 -> 1123
    //   1647: ldc_w 1052
    //   1650: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1653: istore 8
    //   1655: aload_0
    //   1656: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1659: iload 9
    //   1661: aaload
    //   1662: iconst_0
    //   1663: putfield 371	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgTryOnPosition	I
    //   1666: aload_2
    //   1667: astore_1
    //   1668: goto -545 -> 1123
    //   1671: iconst_1
    //   1672: istore 10
    //   1674: goto -529 -> 1145
    //   1677: aload_0
    //   1678: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1681: iload 9
    //   1683: aaload
    //   1684: getfield 1152	com/tencent/mobileqq/theme/diy/ThemeDIYData:imgSmall	Ljava/lang/String;
    //   1687: astore_1
    //   1688: goto -473 -> 1215
    //   1691: aload_0
    //   1692: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   1695: iload 9
    //   1697: aaload
    //   1698: getfield 1152	com/tencent/mobileqq/theme/diy/ThemeDIYData:imgSmall	Ljava/lang/String;
    //   1701: astore_2
    //   1702: goto -438 -> 1264
    //   1705: aload_1
    //   1706: getfield 1121	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImgColor	Landroid/widget/ImageView;
    //   1709: ifnull -207 -> 1502
    //   1712: aload_1
    //   1713: getfield 1121	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$ViewHolder:mImgColor	Landroid/widget/ImageView;
    //   1716: bipush 8
    //   1718: invokevirtual 1155	android/widget/ImageView:setVisibility	(I)V
    //   1721: goto -219 -> 1502
    //   1724: aload_0
    //   1725: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   1728: aload_2
    //   1729: iconst_0
    //   1730: sipush 800
    //   1733: invokevirtual 1134	com/tencent/mobileqq/theme/diy/ScrollLayout:changeAlpha	(Landroid/view/View;ZI)Z
    //   1736: pop
    //   1737: goto -217 -> 1520
    //   1740: aload_0
    //   1741: aload_0
    //   1742: ldc_w 1156
    //   1745: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   1748: checkcast 1158	com/tencent/mobileqq/theme/diy/PageIndicator
    //   1751: putfield 1160	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:pageIndicator	Lcom/tencent/mobileqq/theme/diy/PageIndicator;
    //   1754: aload_0
    //   1755: getfield 1160	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:pageIndicator	Lcom/tencent/mobileqq/theme/diy/PageIndicator;
    //   1758: aload_0
    //   1759: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   1762: invokevirtual 1164	com/tencent/mobileqq/theme/diy/PageIndicator:bindScrollViewGroup	(Lcom/tencent/mobileqq/theme/diy/ScrollLayout;)V
    //   1765: aload_0
    //   1766: new 1166	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$DataLoading
    //   1769: dup
    //   1770: aload_0
    //   1771: invokespecial 1167	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$DataLoading:<init>	(Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity;)V
    //   1774: putfield 1169	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:dataLoad	Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity$DataLoading;
    //   1777: aload_0
    //   1778: getfield 1169	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:dataLoad	Lcom/tencent/mobileqq/theme/diy/ThemeDIYActivity$DataLoading;
    //   1781: aload_0
    //   1782: getfield 989	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mScrollLayout	Lcom/tencent/mobileqq/theme/diy/ScrollLayout;
    //   1785: invokevirtual 1170	com/tencent/mobileqq/theme/diy/ThemeDIYActivity$DataLoading:bindScrollViewGroup	(Lcom/tencent/mobileqq/theme/diy/ScrollLayout;)V
    //   1788: aload_0
    //   1789: aload_0
    //   1790: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1793: bipush 44
    //   1795: invokevirtual 612	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1798: checkcast 842	com/tencent/mobileqq/app/UniPayHandler
    //   1801: putfield 840	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   1804: aload_0
    //   1805: getfield 840	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   1808: aload_0
    //   1809: getfield 207	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mObserver	Lcom/tencent/mobileqq/app/UniPayHandler$UniPayUpdateListener;
    //   1812: invokevirtual 1173	com/tencent/mobileqq/app/UniPayHandler:a	(Lcom/tencent/mobileqq/app/UniPayHandler$UniPayUpdateListener;)V
    //   1815: aload_0
    //   1816: getfield 840	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:uniHandler	Lcom/tencent/mobileqq/app/UniPayHandler;
    //   1819: ldc_w 385
    //   1822: invokevirtual 844	com/tencent/mobileqq/app/UniPayHandler:a	(Ljava/lang/String;)V
    //   1825: aload_0
    //   1826: getfield 403	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:mContext	Landroid/content/Context;
    //   1829: new 264	java/lang/StringBuilder
    //   1832: dup
    //   1833: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1836: ldc_w 1175
    //   1839: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1842: aload_0
    //   1843: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1846: invokevirtual 415	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1849: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1855: iconst_0
    //   1856: invokevirtual 1179	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1859: astore_1
    //   1860: aload_1
    //   1861: ldc_w 1181
    //   1864: iconst_0
    //   1865: invokeinterface 1187 3 0
    //   1870: istore 8
    //   1872: iload 8
    //   1874: ifgt +68 -> 1942
    //   1877: aload_3
    //   1878: ldc_w 1188
    //   1881: aconst_null
    //   1882: invokevirtual 1069	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
    //   1885: astore_2
    //   1886: aload_2
    //   1887: ldc_w 1188
    //   1890: invokevirtual 1191	android/view/View:setId	(I)V
    //   1893: aload_2
    //   1894: aload_0
    //   1895: invokevirtual 1192	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1898: aload_0
    //   1899: aload_2
    //   1900: new 764	android/view/ViewGroup$LayoutParams
    //   1903: dup
    //   1904: iconst_m1
    //   1905: iconst_m1
    //   1906: invokespecial 1195	android/view/ViewGroup$LayoutParams:<init>	(II)V
    //   1909: invokevirtual 1199	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:addContentView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   1912: iload 8
    //   1914: ifge +483 -> 2397
    //   1917: iconst_1
    //   1918: istore 8
    //   1920: aload_1
    //   1921: invokeinterface 1203 1 0
    //   1926: ldc_w 1181
    //   1929: iload 8
    //   1931: invokeinterface 1208 3 0
    //   1936: invokeinterface 1211 1 0
    //   1941: pop
    //   1942: aload_0
    //   1943: aload_0
    //   1944: ldc_w 1212
    //   1947: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   1950: checkcast 1214	com/tencent/widget/HorizontalListView
    //   1953: putfield 1216	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgResHListView	Lcom/tencent/widget/HorizontalListView;
    //   1956: new 1218	java/util/ArrayList
    //   1959: dup
    //   1960: invokespecial 1219	java/util/ArrayList:<init>	()V
    //   1963: astore_1
    //   1964: new 492	com/tencent/mobileqq/theme/diy/ResItemHolder
    //   1967: dup
    //   1968: iconst_0
    //   1969: iconst_0
    //   1970: aconst_null
    //   1971: invokespecial 1222	com/tencent/mobileqq/theme/diy/ResItemHolder:<init>	(IILorg/json/JSONObject;)V
    //   1974: astore_2
    //   1975: aload_2
    //   1976: ldc_w 1052
    //   1979: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1982: putfield 496	com/tencent/mobileqq/theme/diy/ResItemHolder:id	I
    //   1985: aload_2
    //   1986: iconst_0
    //   1987: putfield 498	com/tencent/mobileqq/theme/diy/ResItemHolder:index	I
    //   1990: aload_1
    //   1991: aload_2
    //   1992: invokevirtual 1225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1995: pop
    //   1996: new 492	com/tencent/mobileqq/theme/diy/ResItemHolder
    //   1999: dup
    //   2000: iconst_0
    //   2001: iconst_2
    //   2002: aconst_null
    //   2003: invokespecial 1222	com/tencent/mobileqq/theme/diy/ResItemHolder:<init>	(IILorg/json/JSONObject;)V
    //   2006: astore_2
    //   2007: aload_2
    //   2008: ldc_w 392
    //   2011: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2014: putfield 496	com/tencent/mobileqq/theme/diy/ResItemHolder:id	I
    //   2017: aload_2
    //   2018: iconst_1
    //   2019: putfield 498	com/tencent/mobileqq/theme/diy/ResItemHolder:index	I
    //   2022: aload_2
    //   2023: aload_0
    //   2024: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   2027: iconst_0
    //   2028: aaload
    //   2029: getfield 1021	com/tencent/mobileqq/theme/diy/ThemeDIYData:bgDefaultPic	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2032: putfield 1228	com/tencent/mobileqq/theme/diy/ResItemHolder:thumResData	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2035: aload_1
    //   2036: aload_2
    //   2037: invokevirtual 1225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2040: pop
    //   2041: aload_0
    //   2042: new 486	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter
    //   2045: dup
    //   2046: aload_0
    //   2047: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2050: aload_0
    //   2051: aload_1
    //   2052: ldc_w 1229
    //   2055: invokespecial 1232	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/util/ArrayList;I)V
    //   2058: putfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2061: aload_0
    //   2062: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2065: aload_0
    //   2066: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   2069: putfield 1233	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:isBigScreenType	Z
    //   2072: aload_0
    //   2073: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2076: aload_0
    //   2077: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   2080: iconst_0
    //   2081: aaload
    //   2082: getfield 383	com/tencent/mobileqq/theme/diy/ThemeDIYData:intoDiyPic	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2085: getfield 401	com/tencent/mobileqq/theme/diy/ResData:id	I
    //   2088: putfield 1236	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:resUsedID	I
    //   2091: aload_0
    //   2092: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2095: getfield 1236	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:resUsedID	I
    //   2098: ldc_w 1052
    //   2101: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2104: if_icmpne +302 -> 2406
    //   2107: aload_0
    //   2108: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2111: iconst_0
    //   2112: putfield 1239	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:resTryOnPosition	I
    //   2115: aload_0
    //   2116: getfield 1216	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgResHListView	Lcom/tencent/widget/HorizontalListView;
    //   2119: aload_0
    //   2120: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2123: invokevirtual 1243	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   2126: aload_0
    //   2127: getfield 1216	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgResHListView	Lcom/tencent/widget/HorizontalListView;
    //   2130: aload_0
    //   2131: getfield 242	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:resItemClickListener	Landroid/widget/AdapterView$OnItemClickListener;
    //   2134: invokevirtual 1247	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   2137: aload_0
    //   2138: aload_0
    //   2139: ldc_w 1248
    //   2142: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   2145: checkcast 1214	com/tencent/widget/HorizontalListView
    //   2148: putfield 1250	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:styleResHListView	Lcom/tencent/widget/HorizontalListView;
    //   2151: new 1218	java/util/ArrayList
    //   2154: dup
    //   2155: invokespecial 1219	java/util/ArrayList:<init>	()V
    //   2158: astore_2
    //   2159: new 492	com/tencent/mobileqq/theme/diy/ResItemHolder
    //   2162: dup
    //   2163: iconst_1
    //   2164: iconst_0
    //   2165: aconst_null
    //   2166: invokespecial 1222	com/tencent/mobileqq/theme/diy/ResItemHolder:<init>	(IILorg/json/JSONObject;)V
    //   2169: astore_1
    //   2170: aload_1
    //   2171: ldc_w 1054
    //   2174: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2177: putfield 496	com/tencent/mobileqq/theme/diy/ResItemHolder:id	I
    //   2180: aload_1
    //   2181: aload_0
    //   2182: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   2185: iconst_0
    //   2186: aaload
    //   2187: getfield 1060	com/tencent/mobileqq/theme/diy/ThemeDIYData:screenShot	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2190: putfield 1253	com/tencent/mobileqq/theme/diy/ResItemHolder:screen0ResData	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2193: aload_1
    //   2194: aload_0
    //   2195: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   2198: iconst_1
    //   2199: aaload
    //   2200: getfield 1060	com/tencent/mobileqq/theme/diy/ThemeDIYData:screenShot	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2203: putfield 1256	com/tencent/mobileqq/theme/diy/ResItemHolder:screen1ResData	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2206: aload_1
    //   2207: aload_0
    //   2208: getfield 191	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:showData	[Lcom/tencent/mobileqq/theme/diy/ThemeDIYData;
    //   2211: iconst_2
    //   2212: aaload
    //   2213: getfield 1060	com/tencent/mobileqq/theme/diy/ThemeDIYData:screenShot	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2216: putfield 1259	com/tencent/mobileqq/theme/diy/ResItemHolder:screen2ResData	Lcom/tencent/mobileqq/theme/diy/ResData;
    //   2219: aload_1
    //   2220: iconst_0
    //   2221: putfield 498	com/tencent/mobileqq/theme/diy/ResItemHolder:index	I
    //   2224: aload_2
    //   2225: aload_1
    //   2226: invokevirtual 1225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2229: pop
    //   2230: aload_0
    //   2231: new 549	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter
    //   2234: dup
    //   2235: aload_0
    //   2236: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2239: aload_0
    //   2240: aload_2
    //   2241: ldc_w 1260
    //   2244: invokespecial 1261	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:<init>	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Context;Ljava/util/ArrayList;I)V
    //   2247: putfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2250: aload_0
    //   2251: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2254: aload_0
    //   2255: getfield 895	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isBigScreenType	Z
    //   2258: putfield 1262	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:isBigScreenType	Z
    //   2261: aload_0
    //   2262: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2265: astore_2
    //   2266: aload_0
    //   2267: getfield 918	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:isDIYThemeBefore	Z
    //   2270: ifeq +163 -> 2433
    //   2273: iload 7
    //   2275: istore 8
    //   2277: aload_2
    //   2278: iload 8
    //   2280: putfield 1263	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:resUsedID	I
    //   2283: aload_0
    //   2284: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2287: getfield 1263	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:resUsedID	I
    //   2290: ldc_w 1054
    //   2293: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2296: if_icmpne +11 -> 2307
    //   2299: aload_0
    //   2300: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2303: iconst_0
    //   2304: putfield 1264	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:resTryOnPosition	I
    //   2307: aload_0
    //   2308: getfield 1250	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:styleResHListView	Lcom/tencent/widget/HorizontalListView;
    //   2311: aload_0
    //   2312: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2315: invokevirtual 1243	com/tencent/widget/HorizontalListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   2318: aload_0
    //   2319: getfield 1250	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:styleResHListView	Lcom/tencent/widget/HorizontalListView;
    //   2322: aload_0
    //   2323: getfield 242	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:resItemClickListener	Landroid/widget/AdapterView$OnItemClickListener;
    //   2326: invokevirtual 1247	com/tencent/widget/HorizontalListView:setOnItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   2329: aload_0
    //   2330: getfield 547	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:themeAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter;
    //   2333: aload_1
    //   2334: putfield 553	com/tencent/mobileqq/theme/diy/ThemeDiyThemeAdapter:selectResItem	Lcom/tencent/mobileqq/theme/diy/ResItemHolder;
    //   2337: aload_0
    //   2338: ldc_w 1265
    //   2341: invokespecial 972	com/tencent/mobileqq/app/IphoneTitleBarActivity:findViewById	(I)Landroid/view/View;
    //   2344: checkcast 732	android/widget/LinearLayout
    //   2347: aload_0
    //   2348: invokevirtual 1266	android/widget/LinearLayout:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   2351: aload_0
    //   2352: iconst_1
    //   2353: invokevirtual 1270	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:loadResJson	(Z)V
    //   2356: aload_0
    //   2357: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2360: ldc_w 1272
    //   2363: ldc_w 1274
    //   2366: sipush 150
    //   2369: aconst_null
    //   2370: invokestatic 1279	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/content/Context;)I
    //   2373: iconst_1
    //   2374: iload 7
    //   2376: invokestatic 451	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2379: aload_0
    //   2380: getfield 410	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2383: invokestatic 1283	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeVersion	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   2386: ldc_w 1285
    //   2389: ldc_w 385
    //   2392: invokestatic 1290	com/tencent/mobileqq/theme/ThemeReporter:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2395: iconst_1
    //   2396: ireturn
    //   2397: iload 8
    //   2399: iconst_1
    //   2400: iadd
    //   2401: istore 8
    //   2403: goto -483 -> 1920
    //   2406: aload_0
    //   2407: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2410: getfield 1236	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:resUsedID	I
    //   2413: ldc_w 392
    //   2416: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2419: if_icmpne -304 -> 2115
    //   2422: aload_0
    //   2423: getfield 484	com/tencent/mobileqq/theme/diy/ThemeDIYActivity:bgAdapter	Lcom/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter;
    //   2426: iconst_1
    //   2427: putfield 1239	com/tencent/mobileqq/theme/diy/ThemeDiyBgAdapter:resTryOnPosition	I
    //   2430: goto -315 -> 2115
    //   2433: ldc_w 1054
    //   2436: invokestatic 398	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   2439: istore 8
    //   2441: goto -164 -> 2277
    //   2444: astore_1
    //   2445: goto -1839 -> 606
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2448	0	this	ThemeDIYActivity
    //   0	2448	1	paramBundle	Bundle
    //   201	1324	2	localObject1	Object
    //   1545	1	2	localNumberFormatException	NumberFormatException
    //   1561	1	2	localException	Exception
    //   1594	684	2	localObject2	Object
    //   792	1086	3	localLayoutInflater	android.view.LayoutInflater
    //   841	786	4	localObject3	Object
    //   859	596	5	localObject4	Object
    //   1244	32	6	localStringBuilder	StringBuilder
    //   300	2075	7	i	int
    //   125	2315	8	j	int
    //   140	1556	9	k	int
    //   329	1344	10	m	int
    //   771	607	11	n	int
    //   783	588	12	i1	int
    //   156	247	13	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   413	427	1545	java/lang/NumberFormatException
    //   413	427	1561	java/lang/Exception
    //   512	606	2444	java/lang/Exception
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.mHandler.removeMessages(24);
    if (this.uniHandler != null) {
      this.uniHandler.b(this.mObserver);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    View localView = this.mScrollLayout.getChildAt(this.currentIndex);
    if (localView == null) {}
    ThemeDIYActivity.ViewHolder localViewHolder;
    do
    {
      return;
      localViewHolder = (ThemeDIYActivity.ViewHolder)localView.getTag();
    } while (localViewHolder == null);
    if (paramIntent == null)
    {
      this.mContext.getSharedPreferences("theme_background_path_" + this.app.getAccount(), 0).getString(this.showData[this.currentIndex].orgSpKey, "null");
      this.showData[this.currentIndex].mSetStatus = 2;
      this.showData[this.currentIndex].bgDiyPicRes = null;
      this.showData[this.currentIndex].bgDiyPic = null;
    }
    for (;;)
    {
      showDiyImage(localViewHolder, this.currentIndex, true);
      if (localViewHolder.alpha >= 0.97F) {
        break;
      }
      this.mScrollLayout.changeAlphaImmediately(localView, 1.0F, 10);
      return;
      this.showData[this.currentIndex].mSetStatus = 2;
      if (paramIntent == null) {}
      for (paramIntent = "null";; paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"))
      {
        if ((paramIntent == null) || ("null".equals(paramIntent))) {
          break label498;
        }
        this.showData[this.currentIndex].bgDiyPicRes = new ResData(paramIntent.substring(paramIntent.lastIndexOf("/") + 1), Integer.parseInt("4999"), this.currentIndex, paramIntent.substring(0, paramIntent.lastIndexOf("/") + 1), null, 2, 0, 0, 1);
        this.showData[this.currentIndex].bgDiyPic = this.showData[this.currentIndex].bgDiyPicRes;
        Object localObject = this.themeDiyStyleLogic;
        if (!ThemeDiyStyleLogic.isNeedDealDarkBri(this.showData[this.currentIndex], this.themeAdapter.selectResItem.index)) {
          break label500;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putInt("index", this.currentIndex);
        ((Bundle)localObject).putInt("nowOperate", 14);
        this.showData[this.currentIndex].bgDiyPicRes.dealedName = (this.showData[this.currentIndex].bgDiyPicRes.name.substring(0, this.showData[this.currentIndex].bgDiyPicRes.name.length() - 3) + "png");
        new ThemeDiyStyleLogic.DarkBrightnessTask(this.mContext, this.app, paramIntent, paramIntent.substring(0, paramIntent.length() - 3) + "png", this.showData[this.currentIndex], (Bundle)localObject, this.saveStyleCallback).execute(new Object[0]);
        break;
      }
      label498:
      continue;
      label500:
      this.showData[this.currentIndex].bgDiyPicRes.state = 5;
      this.showData[this.currentIndex].bgDiyPicRes.dealedName = this.showData[this.currentIndex].bgDiyPicRes.name;
    }
    this.mScrollLayout.changeAlphaImmediately(localView, localViewHolder.alpha - 0.01F, 10);
  }
  
  Drawable getLocalDrawable(String paramString, ResData paramResData, ThemeDIYActivity.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    File localFile = new File(paramString, paramResData.name);
    if (localFile.exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      paramString = BitmapManager.a(paramString + paramResData.name, localOptions);
      if (paramString != null) {
        return new ChatBackgroundDrawable(this.mContext.getResources(), paramString);
      }
    }
    if ((paramBoolean) && (paramResData.url != null))
    {
      paramString = new DownloadTask(paramResData.url, localFile);
      paramString.a = paramResData.url;
      ((DownloaderFactory)this.app.getManager(46)).a(1).a(paramString, this.resDownloadListener, getLoadParam(0, paramViewHolder.id, paramResData.picType));
    }
    return null;
  }
  
  Drawable getLocalDrawable(String paramString1, String paramString2)
  {
    if (new File(paramString1, paramString2).exists())
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      paramString1 = BitmapManager.a(paramString1 + paramString2, localOptions);
      if (paramString1 != null) {
        return new ChatBackgroundDrawable(this.mContext.getResources(), paramString1);
      }
    }
    return null;
  }
  
  void gotoOpenQQVip(int paramInt, String paramString1, String paramString2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("userId", this.app.a());
      localJSONObject.put("openMonth", paramInt);
      localJSONObject.put("aid", "mvip.gexinghua.android.theme_diy2");
      localJSONObject.put("offerId", "1450000515");
      localJSONObject.put("serviceName", paramString1);
      localJSONObject.put("serviceCode", paramString2);
      PayBridgeActivity.tenpay(this, localJSONObject.toString(), 4, "ThemeDIYBgVIP");
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  boolean isNeedSave()
  {
    boolean bool = false;
    int i = 0;
    if (i < this.showData.length) {
      if (2 == this.showData[i].mSetStatus) {
        bool = true;
      }
    }
    while (2 != this.themeAdapter.mSetStatus)
    {
      return bool;
      i += 1;
      break;
    }
    return true;
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  void loadResJson(boolean paramBoolean)
  {
    ThreadManager.a().post(new ThemeDIYActivity.1(this, paramBoolean));
  }
  
  protected boolean onBackEvent()
  {
    if ((this.exitDialog != null) && (this.exitDialog.isShowing()))
    {
      this.exitDialog.dismiss();
      this.exitDialog = null;
      return true;
    }
    if (this.isNotifyBack)
    {
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_out", 0, 0, "", "", "", "");
      if (isNeedSave()) {
        try
        {
          this.exitDialog = DialogUtil.a(this.mContext, 230, getResources().getString(2131367535), "你的自定义主题还未保存，是否保存？", 2131367774, 2131368753, new ThemeDIYActivity.6(this), new ThemeDIYActivity.7(this));
          this.exitDialog.show();
          return true;
        }
        catch (Exception localException)
        {
          QLog.e("ThemeDIYActivity", 1, localException.getMessage());
        }
      }
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_outsuccess", 0, 1, "0", "", "", "");
    }
    super.onBackEvent();
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          saveOperate(true);
          ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_save", 0, 0, "", "", "", "");
          return;
          localObject1 = (ViewGroup)paramView.getParent();
        } while (localObject1 == null);
        localObject2 = ((ViewGroup)localObject1).findViewById(2131305112);
        if ((localObject2 == null) || (((View)localObject2).getVisibility() != 0)) {
          break;
        }
        ((View)localObject2).setVisibility(8);
        paramView = ((ViewGroup)localObject1).findViewById(2131305114);
      } while (paramView == null);
      paramView.setVisibility(0);
      this.stylePanel.getLayoutParams().height = this.stylePanelHeight;
      this.stylePanel.requestLayout();
      return;
      ((ViewGroup)localObject1).removeView(paramView);
      return;
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_photo", 0, 0, String.valueOf(this.currentIndex), "", "", "");
      paramView = getIntent();
      Object localObject1 = this.local_FilesDir + this.currentIndex + ThemeDiyStyleLogic.getDownFileName(null);
      Object localObject2 = new Rect();
      getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject2);
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      int m = ((Rect)localObject2).width();
      int k = ((Rect)localObject2).height();
      int j = m;
      int i = k;
      if (this.currentIndex != 2)
      {
        j = m * 3 / 4;
        i = k * 3 / 4;
      }
      PhotoUtils.a(paramView, this, ThemeDIYActivity.class.getName(), ((Rect)localObject2).width() * 4 / 5, ((Rect)localObject2).height() * 4 / 5, j, i, (String)localObject1);
      return;
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "Diy_default", 0, 1, String.valueOf(this.currentIndex), "", "", "");
      doOnNewIntent(null);
      return;
    } while (this.isAniming);
    if (!this.panelStateOpen)
    {
      performAnimate(this.stylePanel.getLayoutParams().height, this.stylePanelHeight, true, 300, true);
      ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_clickup", 0, 0, "", "", "", "");
      return;
    }
    performAnimate(this.stylePanel.getLayoutParams().height, this.stylePanelMinH, false, 300, true);
    ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "diy_clickdown", 0, 0, "", "", "", "");
  }
  
  public void onPostThemeChanged()
  {
    int j = 0;
    if (this.mScrollLayout != null) {
      this.mScrollLayout.setToScreen(this.currentIndex, 50);
    }
    if ((this.mNeedStatusTrans) && (this.mSystemBarComp != null))
    {
      i = getResources().getColor(2131428295);
      this.mSystemBarComp.a(i);
      this.mSystemBarComp.b(i);
    }
    setProgessDialog(false, 0);
    int i = this.themeAdapter.resUsedID;
    this.themeAdapter.resUsedID = this.themeAdapter.selectResItem.id;
    this.themeAdapter.setItemState(i, this.themeAdapter.resUsedID, true);
    int k = this.bgAdapter.resUsedID;
    label184:
    Object localObject2;
    Object localObject1;
    if (this.bgAdapter.getItem(this.bgAdapter.resTryOnPosition) != null)
    {
      this.bgAdapter.resUsedID = ((ResItemHolder)this.bgAdapter.getItem(this.bgAdapter.resTryOnPosition)).id;
      this.bgAdapter.setItemState(k, this.bgAdapter.resUsedID, true);
      i = j;
      if (i >= this.showData.length) {
        break label364;
      }
      localObject2 = this.showData[i].intoDiyPic;
      if (this.showData[i].bgDiyPicRes != null) {
        break label331;
      }
      localObject1 = this.showData[i].intoDiyPic.name;
      label228:
      ((ResData)localObject2).name = ((String)localObject1);
      localObject1 = this.showData[i].intoDiyPic;
      if (this.showData[i].bgDiyPicRes != null) {
        break label347;
      }
    }
    label331:
    label347:
    for (j = this.showData[i].intoDiyPic.id;; j = this.showData[i].bgDiyPicRes.id)
    {
      ((ResData)localObject1).id = j;
      i += 1;
      break label184;
      localObject1 = this.bgAdapter;
      if (this.showData[this.currentIndex].bgDiyPicRes == null) {}
      for (i = 0;; i = this.showData[this.currentIndex].bgDiyPicRes.id)
      {
        ((ThemeDiyBgAdapter)localObject1).resUsedID = i;
        break;
      }
      localObject1 = this.showData[i].bgDiyPicRes.name;
      break label228;
    }
    label364:
    QQToast.a(this.mContext, 2131369191, 2600).b(this.mContext.getResources().getDimensionPixelSize(2131492908));
    if (this.mScrollLayout != null)
    {
      localObject1 = this.mScrollLayout.getChildAt(this.currentIndex);
      if (localObject1 != null) {
        break label423;
      }
    }
    label423:
    do
    {
      return;
      localObject1 = null;
      break;
      localObject2 = (ThemeDIYActivity.ViewHolder)((View)localObject1).getTag();
    } while (localObject2 == null);
    if (((ThemeDIYActivity.ViewHolder)localObject2).alpha < 0.97F)
    {
      this.mScrollLayout.changeAlphaImmediately((View)localObject1, 1.0F, 10);
      return;
    }
    this.mScrollLayout.changeAlphaImmediately((View)localObject1, ((ThemeDIYActivity.ViewHolder)localObject2).alpha - 0.01F, 10);
  }
  
  public void onScreenChange(int paramInt)
  {
    ReportController.b(this.app, "CliOper", "", this.app.a(), "theme_mall", "skim_page2", 0, 0, String.valueOf(paramInt), "", "", "");
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "onScreenChange: pageIndex = " + String.valueOf(paramInt));
    }
    Object localObject = this.mScrollLayout.getChildAt(paramInt);
    if (localObject == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDIYActivity", 2, "onScreenChange: view == null");
      }
    }
    do
    {
      return;
      localObject = (ThemeDIYActivity.ViewHolder)((View)localObject).getTag();
      if (localObject != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ThemeDIYActivity", 2, "onScreenChange: holder == null");
    return;
    if (this.currentIndex != paramInt)
    {
      ResItemHolder localResItemHolder = (ResItemHolder)this.bgAdapter.getItem(1);
      if (localResItemHolder != null)
      {
        localResItemHolder.thumResData = this.showData[paramInt].bgDefaultPic;
        this.bgAdapter.showThumn(1, null, false);
      }
      int i = this.bgAdapter.resTryOnPosition;
      this.bgAdapter.resTryOnPosition = this.showData[paramInt].bgTryOnPosition;
      this.bgAdapter.setItemState(i, this.bgAdapter.resTryOnPosition, false);
      i = this.bgAdapter.resUsedID;
      this.bgAdapter.resUsedID = this.showData[paramInt].intoDiyPic.id;
      this.bgAdapter.setItemState(i, this.bgAdapter.resUsedID, true);
    }
    this.currentIndex = paramInt;
    this.pageIndicator.generatePageControl(paramInt);
    localObject = (ThemeBackground)((ThemeDIYActivity.ViewHolder)localObject).mImageDiy.getTag();
  }
  
  void performAnimate(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    this.panelStateOpen = paramBoolean1;
    setValueAnimatorState(this.valueAnimatorUp, false, 0);
    setValueAnimatorState(this.valueAnimatorDown, false, 0);
    setValueAnimatorState(this.valueAnimatorDrag, false, 0);
    if (!paramBoolean2)
    {
      this.valueAnimatorDrag = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.updateListener, false, false);
      setValueAnimatorState(this.valueAnimatorDrag, true, paramInt3);
      return;
    }
    if (this.panelStateOpen)
    {
      this.theme_panel_arrow.setImageResource(2130841878);
      if (this.valueAnimatorUp == null) {
        this.valueAnimatorUp = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.updateListener, false, false);
      }
      setValueAnimatorState(this.valueAnimatorUp, true, paramInt3);
      return;
    }
    this.theme_panel_arrow.setImageResource(2130839401);
    if (this.valueAnimatorDown == null) {
      this.valueAnimatorDown = new ValueAnimation(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), this.updateListener, false, false);
    }
    setValueAnimatorState(this.valueAnimatorDown, true, paramInt3);
  }
  
  void saveOperate(boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "saveOperate, isfromUser:" + paramBoolean + ", isVip:" + this.isVip + ", isDIYThemeBefore:" + this.isDIYThemeBefore);
    }
    if (!this.isVip) {
      try
      {
        DialogUtil.a(this.mContext, 230, getResources().getString(2131367535), "自定义主题为QQ会员专享特权，保存自定义主题需开通QQ会员", 2131367262, 2131368368, new ThemeDIYActivity.2(this), new ThemeDIYActivity.3(this)).show();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ThemeDIYActivity", 1, " onSaveClickListener error:" + localException.getMessage());
        return;
      }
    }
    ThemeDIYData[] arrayOfThemeDIYData = this.showData;
    if (paramBoolean)
    {
      try
      {
        if (!isNeedSave()) {
          return;
        }
      }
      finally {}
      this.mHandler.removeMessages(24);
      this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 24), 60000L);
      ThemeDIYData localThemeDIYData1 = this.showData[0];
      ThemeDIYData localThemeDIYData2 = this.showData[1];
      ThemeDIYData localThemeDIYData3 = this.showData[2];
      ThemeDiyThemeAdapter localThemeDiyThemeAdapter = this.themeAdapter;
      this.mSaveToServerStatus = 0;
      localThemeDiyThemeAdapter.mSaveStatus = 0;
      localThemeDIYData3.mSaveStatus = 0;
      localThemeDIYData2.mSaveStatus = 0;
      localThemeDIYData1.mSaveStatus = 0;
      setProgessDialog(true, 2131368382);
      ThreadManager.a(new ThemeDIYActivity.4(this), 8, null, true);
      return;
    }
    for (;;)
    {
      if (i < this.showData.length)
      {
        if (6 != this.showData[i].mSaveStatus) {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "saveOperate_wait i=" + i);
          }
        }
      }
      else
      {
        if (6 != this.themeAdapter.mSaveStatus)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ThemeDIYActivity", 2, "saveOperate_wait deal style.");
          }
          return;
        }
        backgroundSave();
        break;
      }
      i += 1;
    }
  }
  
  void setProgessDialog(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      if (this.progessDialog == null)
      {
        this.progessDialog = new QQProgressDialog(this.mContext, getTitleBarHeight());
        this.progessDialog.setCancelable(true);
      }
      this.progessDialog.b(paramInt);
      this.progessDialog.show();
    }
    while ((this.progessDialog == null) || (!this.progessDialog.isShowing())) {
      return;
    }
    this.progessDialog.dismiss();
  }
  
  void setProgressBar(ThemeDIYActivity.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    ThemeDIYActivity.ViewHolder localViewHolder = paramViewHolder;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.mScrollLayout.getChildAt(paramInt);
      if ((paramViewHolder != null) && (paramViewHolder.getTag() != null))
      {
        localViewHolder = (ThemeDIYActivity.ViewHolder)paramViewHolder.getTag();
        if (localViewHolder != null) {
          break label42;
        }
      }
    }
    label42:
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (ProgressBar)localViewHolder.mRLayout.findViewById(2131298831);
          if (!paramBoolean) {
            break;
          }
        } while (((this.showData[localViewHolder.id].bgDefaultPic == null) || (this.showData[localViewHolder.id].bgDefaultPic.state >= 2)) && ((this.showData[localViewHolder.id].bgDiyPic == null) || (this.showData[localViewHolder.id].bgDiyPic.state >= 2)) && ((this.showData[localViewHolder.id].screenShot == null) || (this.showData[localViewHolder.id].screenShot.state >= 2)));
        paramViewHolder = (ThemeDIYActivity.ViewHolder)localObject;
        if (localObject == null)
        {
          paramViewHolder = new ProgressBar(this.mContext);
          paramViewHolder.setId(2131298831);
          paramViewHolder.setIndeterminateDrawable(getResources().getDrawable(2130838321));
          paramInt = AIOUtils.a(16.0F, this.mContext.getResources());
          localObject = new RelativeLayout.LayoutParams(paramInt, paramInt);
          ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
          ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt;
          ((RelativeLayout.LayoutParams)localObject).addRule(13);
          localViewHolder.mRLayout.addView(paramViewHolder, (ViewGroup.LayoutParams)localObject);
        }
      } while (paramViewHolder.getVisibility() == 0);
      paramViewHolder.setVisibility(0);
      return;
    } while ((localObject == null) || (((ProgressBar)localObject).getVisibility() == 8) || ((this.showData[localViewHolder.id].bgDefaultPic != null) && (this.showData[localViewHolder.id].bgDefaultPic.state != 2)) || ((this.showData[localViewHolder.id].bgDiyPic != null) && (this.showData[localViewHolder.id].bgDiyPic.state != 2)) || ((this.showData[localViewHolder.id].screenShot != null) && (this.showData[localViewHolder.id].screenShot.state != 2)));
    ((ProgressBar)localObject).setVisibility(8);
  }
  
  void setProgressText(String paramString)
  {
    if ((this.progessDialog != null) && (this.progessDialog.isShowing())) {
      this.progessDialog.a(paramString);
    }
  }
  
  void setSpThemeBackground(ThemeDIYData paramThemeDIYData, int paramInt, boolean paramBoolean)
  {
    ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.orgSpKey, this.app.a(), paramThemeDIYData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDownFileName(paramThemeDIYData.bgDiyPicRes));
    if (!paramThemeDIYData.orgSpKey.equals(paramThemeDIYData.dealSpkey))
    {
      if ((!paramBoolean) || (!ThemeDiyStyleLogic.isNeedDealDarkBri(paramThemeDIYData, this.themeAdapter.selectResItem.index))) {
        break label183;
      }
      ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.dealSpkey, this.app.a(), paramThemeDIYData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDealFileName(paramThemeDIYData.bgDiyPicRes, paramInt));
    }
    for (;;)
    {
      if (paramInt == 2) {
        ChatBackground.b(this.mContext, this.app.getAccount(), null, paramThemeDIYData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDownFileName(paramThemeDIYData.bgDiyPicRes));
      }
      return;
      label183:
      ThemeBackground.setThemeBackgroundPic(this.mContext, paramThemeDIYData.dealSpkey, this.app.a(), paramThemeDIYData.bgDiyPicRes.path + ThemeDiyStyleLogic.getDownFileName(paramThemeDIYData.bgDiyPicRes));
    }
  }
  
  void setValueAnimatorState(ValueAnimation paramValueAnimation, boolean paramBoolean, int paramInt)
  {
    if (paramValueAnimation == null) {
      return;
    }
    if (paramBoolean)
    {
      if (paramValueAnimation.a() == null)
      {
        paramValueAnimation.setDuration(paramInt);
        paramValueAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        paramValueAnimation.setAnimationListener(this.animatorListener);
      }
      paramValueAnimation.a(Integer.valueOf(10));
      this.stylePanel.startAnimation(paramValueAnimation);
      return;
    }
    if ((paramValueAnimation.a() != null) && (Integer.parseInt(paramValueAnimation.a().toString()) == 10)) {
      paramValueAnimation.cancel();
    }
    paramValueAnimation.a(Integer.valueOf(0));
  }
  
  boolean showDefaultImage(ThemeDIYActivity.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.mScrollLayout.getChildAt(paramInt);
      if ((paramViewHolder != null) && (paramViewHolder.getTag() != null))
      {
        localObject = (ThemeDIYActivity.ViewHolder)paramViewHolder.getTag();
        paramViewHolder = (ThemeDIYActivity.ViewHolder)localObject;
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
    }
    if (this.showData[paramInt].bgDefaultPic == null) {
      return true;
    }
    if (this.showData[paramInt].bgDefaultPic.from == 2)
    {
      localObject = getAssetsDrawable(this.mContext, 0, this.showData[paramInt].bgDefaultPic.name);
      if (localObject == null) {
        break label225;
      }
      paramViewHolder.mRLayout.setBackgroundDrawable((Drawable)localObject);
      this.showData[paramInt].bgDefaultPic.state = 2;
      if ((paramBoolean) && (this.bgAdapter != null) && (paramInt == this.currentIndex) && (this.currentIndex == 0)) {
        this.bgAdapter.showThumn(1, null, true);
      }
      label161:
      if (localObject == null) {
        break label245;
      }
    }
    label225:
    label245:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      localObject = this.showData[paramInt].bgDefaultPic.path;
      ResData localResData = this.showData[paramInt].bgDefaultPic;
      if (!paramBoolean) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject = getLocalDrawable((String)localObject, localResData, paramViewHolder, bool1);
        break;
      }
      if (paramBoolean) {
        break label161;
      }
      this.showData[paramInt].bgDefaultPic.state = 1;
      break label161;
    }
  }
  
  boolean showDiyImage(ThemeDIYActivity.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.mScrollLayout.getChildAt(paramInt);
      if ((paramViewHolder != null) && (paramViewHolder.getTag() != null))
      {
        localObject = (ThemeDIYActivity.ViewHolder)paramViewHolder.getTag();
        paramViewHolder = (ThemeDIYActivity.ViewHolder)localObject;
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
    }
    if (this.showData[paramInt].bgDiyPic == null)
    {
      paramViewHolder.mImageDiy.setBackgroundDrawable(null);
      if (paramViewHolder.mImgColor != null) {
        paramViewHolder.mImgColor.setVisibility(8);
      }
      return true;
    }
    Object localObject = this.showData[paramInt].bgDiyPic.path;
    ResData localResData = this.showData[paramInt].bgDiyPic;
    boolean bool1;
    if (!paramBoolean)
    {
      bool1 = true;
      localObject = getLocalDrawable((String)localObject, localResData, paramViewHolder, bool1);
      paramViewHolder.mImageDiy.setBackgroundDrawable((Drawable)localObject);
      if (paramViewHolder.mImgColor != null) {
        paramViewHolder.mImgColor.setVisibility(0);
      }
      if (localObject == null) {
        break label260;
      }
      this.showData[paramInt].bgDiyPic.state = 2;
      if (this.currentIndex == paramInt)
      {
        if (paramViewHolder.alpha >= 0.97F) {
          break label228;
        }
        this.mScrollLayout.changeAlphaImmediately(this.mScrollLayout.getChildAt(this.currentIndex), 1.0F, 10);
      }
      label212:
      if (localObject == null) {
        break label287;
      }
    }
    label228:
    label260:
    label287:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      bool1 = false;
      break;
      this.mScrollLayout.changeAlphaImmediately(this.mScrollLayout.getChildAt(this.currentIndex), paramViewHolder.alpha - 0.01F, 10);
      break label212;
      if (paramBoolean) {
        break label212;
      }
      this.showData[paramInt].bgDiyPic.state = 1;
      setProgressBar(paramViewHolder, paramInt, true);
      break label212;
    }
  }
  
  boolean showScreenShot(ThemeDIYActivity.ViewHolder paramViewHolder, int paramInt, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramViewHolder == null)
    {
      paramViewHolder = this.mScrollLayout.getChildAt(paramInt);
      if ((paramViewHolder != null) && (paramViewHolder.getTag() != null))
      {
        localObject = (ThemeDIYActivity.ViewHolder)paramViewHolder.getTag();
        paramViewHolder = (ThemeDIYActivity.ViewHolder)localObject;
        if (localObject != null) {}
      }
      else
      {
        return false;
      }
    }
    if (this.showData[paramInt].screenShot == null) {
      return true;
    }
    Object localObject = this.showData[paramInt].screenShot.path;
    ResData localResData = this.showData[paramInt].screenShot;
    boolean bool1;
    if (!paramBoolean)
    {
      bool1 = true;
      localObject = getLocalDrawable((String)localObject, localResData, paramViewHolder, bool1);
      paramViewHolder.mImg.setBackgroundDrawable((Drawable)localObject);
      if (localObject == null) {
        break label221;
      }
      this.showData[paramInt].screenShot.state = 2;
      if (this.currentIndex == paramInt)
      {
        if (paramViewHolder.alpha >= 0.97F) {
          break label189;
        }
        this.mScrollLayout.changeAlphaImmediately(this.mScrollLayout.getChildAt(this.currentIndex), 1.0F, 10);
      }
      label173:
      if (localObject == null) {
        break label248;
      }
    }
    label189:
    label221:
    label248:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      return paramBoolean;
      bool1 = false;
      break;
      this.mScrollLayout.changeAlphaImmediately(this.mScrollLayout.getChildAt(this.currentIndex), paramViewHolder.alpha - 0.01F, 10);
      break label173;
      if (paramBoolean) {
        break label173;
      }
      this.showData[paramInt].screenShot.state = 1;
      setProgressBar(paramViewHolder, paramInt, true);
      break label173;
    }
  }
  
  void showTitleBtn()
  {
    String str1 = this.app.a();
    SharedPreferences localSharedPreferences = getSharedPreferences("uniPaySp_" + str1, 0);
    String str2 = localSharedPreferences.getString("sUin", "");
    int i = localSharedPreferences.getInt("isShowOpen", 0);
    int j = localSharedPreferences.getInt("iUinpPayType", 0);
    Integer.valueOf(localSharedPreferences.getString("open_month", "3")).intValue();
    if ((str2 != null) && (str1 != null) && (str2.equals(str1)))
    {
      if (i != 1) {}
    }
    else
    {
      switch (j)
      {
      default: 
        this.isVip = true;
      case 1: 
      case 2: 
        return;
      case 3: 
        return;
      case 4: 
        return;
      case 5: 
        return;
      case 6: 
        return;
      case 7: 
        return;
      case 8: 
        return;
      }
      return;
    }
    this.isVip = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\theme\diy\ThemeDIYActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */