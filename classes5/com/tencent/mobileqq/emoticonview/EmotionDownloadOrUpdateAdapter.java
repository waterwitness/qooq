package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;

public class EmotionDownloadOrUpdateAdapter
  extends EmotionNeedDownloadAdapter
  implements Handler.Callback, View.OnClickListener
{
  private static final int h = 0;
  public static final int i = 0;
  public static final int j = 1;
  private static final int k = 1;
  private static final int o = 2;
  private static final int q = 100;
  private static final int r = 101;
  private static final int s = 102;
  protected EmoticonPackage a;
  protected EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder a;
  private MqqHandler a;
  protected boolean a;
  protected boolean b;
  private int p;
  
  public EmotionDownloadOrUpdateAdapter(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, EmoticonCallback paramEmoticonCallback)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramEmoticonCallback);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.p = 2;
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    if (paramEmoticonPackage.jobType == 4) {}
    for (bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder == null)) {}
    ProgressButton localProgressButton;
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "doDownloadOpr epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
        localProgressButton = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton;
      } while (localProgressButton == null);
      if (!paramBoolean) {
        break;
      }
      d();
    } while (this.p != 2);
    EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals("10278")))
    {
      ((EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_endoffer_click", 0, 0, "", "", "", "");
    }
    localProgressButton.setProgressColor(-16745986);
    float f = localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    if (this.n == 2)
    {
      localProgressButton.setText("取消");
      localProgressButton.setProgress((int)f);
      localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, true);
      this.n = 1;
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
      if (this.n == 1)
      {
        String str = "下载";
        if (this.b) {
          str = "更新";
        }
        localProgressButton.setText(str);
        localProgressButton.setProgress(0);
        this.n = 2;
        localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 0).edit().remove("LAST_ADD_EMO_PACKAGE").commit();
      }
    }
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))
          {
            EmoticonPackage localEmoticonPackage = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage;
            bool1 = bool2;
            if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    int m = ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).h();
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4)
    {
      if ((m == 1) || (m == 3))
      {
        this.p = 2;
        return;
      }
      this.p = 0;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5)
    {
      if (m == 3)
      {
        this.p = 2;
        return;
      }
      this.p = 1;
      return;
    }
    this.p = 2;
  }
  
  public View a(BaseEmotionAdapter.ViewHolder paramViewHolder, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public BaseEmotionAdapter.ViewHolder a()
  {
    return new EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 18)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "payback");
      }
      if (a())
      {
        a(true);
        if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057AD", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
        }
      }
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 100;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramInt == 0) || (paramEmoticonPackage == null)) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    localMessage.obj = paramEmoticonPackage;
    localMessage.arg1 = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt1, int paramInt2)
  {
    if (paramEmoticonPackage == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 101;
    localMessage.obj = paramEmoticonPackage;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(EmotionDownloadOrUpdateAdapter.EmotionDownloadOrUpdateViewHolder paramEmotionDownloadOrUpdateViewHolder)
  {
    if ((paramEmotionDownloadOrUpdateViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)))
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "updateUI holder is null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "updateUI epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.name);
    paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject = EmosmUtils.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    for (;;)
    {
      try
      {
        localDrawable1 = BaseApplicationImpl.a().getResources().getDrawable(2130837545);
        localDrawable2 = BaseApplicationImpl.a().getResources().getDrawable(2130840120);
        if (!FileUtils.a((String)localObject)) {
          continue;
        }
        localObject = URLDrawableHelper.a(new URL("file:///" + (String)localObject), localDrawable1, localDrawable2);
        if (localObject == null) {
          continue;
        }
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Drawable localDrawable1;
        Drawable localDrawable2;
        float f;
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840120);
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840120);
        continue;
        str = "下载";
        if (!this.b) {
          break label464;
        }
      }
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
      f = ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "Ep id=" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId + ", progress=" + f);
      }
      if (f < 0.0F) {
        continue;
      }
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress((int)(f * 100.0F));
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
      this.n = 1;
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setOnClickListener(this);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        localObject = EmosmUtils.b(19, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        localObject = URLDrawableHelper.a((String)localObject, localDrawable1, localDrawable2);
      }
      else
      {
        localObject = EmosmUtils.b(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        continue;
        paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840120);
      }
    }
    String str = "更新";
    for (;;)
    {
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
      paramEmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText(str);
      this.n = 2;
      if (!a()) {
        break;
      }
      c();
      break;
      label464:
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 4) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5))
      {
        d();
        if (this.p != 2) {
          str = "立即开通";
        }
      }
      else if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
      {
        str = "查看详情";
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId))) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "onAdapterSelected emotionpkg = null");
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
        break;
      }
      d();
    } while (this.p != 2);
    while (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
    {
      EmojiManager localEmojiManager = (EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42);
      if ((localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId) >= 0.0F) || (!EmoticonUtils.b())) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "wifi auto download emotion , epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
      }
      localEmojiManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage, false);
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
        this.n = 1;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B1", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
      return;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.b)
    {
      if (paramInt == 0) {
        return 0;
      }
      return 1;
    }
    return super.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    if (this.b) {
      return 2;
    }
    return super.getViewTypeCount();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramMessage.obj;
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder == null) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView == null)) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "packageDownloadEnd view is null");
    }
    do
    {
      do
      {
        do
        {
          return true;
        } while ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId)) || (localEmoticonPackage == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId.equals(localEmoticonPackage.epId)));
        switch (paramMessage.what)
        {
        default: 
          return true;
        case 100: 
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshCover epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
          }
          paramMessage = EmosmUtils.a(2, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
        }
      } while (paramMessage == null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramMessage);
      return true;
      paramMessage = a().a("vipEmoticonKey_" + localEmoticonPackage.epId);
    } while (paramMessage == null);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage refreshprogress epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    int m = (int)paramMessage.a;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("取消");
    this.n = 1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(m);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgressColor(-16745986);
    return true;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleMessage packageDownloadEnd epid = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId);
    }
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("更新");
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setText("下载");
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionDownloadOrUpdateAdapter$EmotionDownloadOrUpdateViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetProgressButton.setProgress(0);
    this.n = 2;
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() != 2131298144) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 4) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype != 5)) {
        break;
      }
      d();
      if (this.p == 2) {
        break label284;
      }
      Object localObject = "mvip.gexinghua.android.sbp_" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId;
      paramView = "!vip";
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.mobileFeetype == 5) {
        paramView = "!svip";
      }
      paramView = "http://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + paramView + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramView);
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject, 4813);
      }
    } while (this.jdField_a_of_type_Boolean);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, "", "", "");
    return;
    if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.valid)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.jobType == 4) {}
      for (boolean bool = true;; bool = false)
      {
        EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 8, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId), false, bool);
        return;
      }
    }
    label284:
    a(false);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\EmotionDownloadOrUpdateAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */