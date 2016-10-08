package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.widget.EditText;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.magicface.drawable.PngFrameUtil;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.VasReportUtils;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import mqq.os.MqqHandler;
import rlb;
import rlc;
import rld;

public class PicEmoticonInfo
  extends EmoticonInfo
{
  public static final int a = 2;
  public static final int b = 3;
  private static final String k = "PicEmoticonInfo";
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Emoticon a;
  public boolean a;
  private Drawable b;
  private Drawable c;
  private Drawable d;
  public int h;
  public int i;
  public int j;
  private String l;
  
  public PicEmoticonInfo(String paramString)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
    this.l = paramString;
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) || (this.b == null)) {}
    try
    {
      paramString = BaseApplication.getContext().getResources();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString.getDrawable(2130837545);
      this.b = paramString.getDrawable(2130840120);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
      return;
    }
    catch (OutOfMemoryError paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PicEmoticonInfo", 2, paramString.getMessage());
    }
  }
  
  public static String a(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    return paramEmoticon.epId + "_" + paramEmoticon.eId;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionWidth == 0) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.extensionHeight == 0) || ((this.c == null) || (this.d == null))) {}
    try
    {
      Resources localResources = BaseApplication.getContext().getResources();
      this.c = localResources.getDrawable(2130841690);
      this.d = localResources.getDrawable(2130841691);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.c;
      this.b = this.d;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localException.getMessage());
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PicEmoticonInfo", 2, localOutOfMemoryError.getMessage());
        }
      }
    }
  }
  
  public static void a(URLDrawable paramURLDrawable)
  {
    Object localObject;
    if (paramURLDrawable != null)
    {
      localObject = paramURLDrawable.getCurrDrawable();
      if ((localObject != null) && ((localObject instanceof GifDrawable)))
      {
        localObject = ((GifDrawable)localObject).getImage();
        if ((localObject == null) || (!(localObject instanceof VoiceGifImage))) {
          break label72;
        }
        ((VoiceGifImage)localObject).b();
        ((VoiceGifImage)localObject).a();
        paramURLDrawable.invalidateSelf();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
        }
      }
    }
    label72:
    do
    {
      do
      {
        return;
      } while ((localObject == null) || (!(localObject instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)localObject).b();
      ((VoiceGifImageV2)localObject).a();
      paramURLDrawable.invalidateSelf();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif startSoundDrawablePlay start");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, Emoticon paramEmoticon)
  {
    if (paramEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send emotion + 1:emotion == null");
    }
    Object localObject2;
    boolean bool;
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "emotion mall,epid=" + paramEmoticon.epId + ";jobtype=" + paramEmoticon.jobType);
      }
      localObject1 = (EmojiManager)paramQQAppInterface.getManager(42);
      if ((paramEmoticon.jobType != 2) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity)))) {
        break label678;
      }
      localObject2 = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbIDDianji", 0, 0, paramEmoticon.epId, "", "", "");
      if ((localObject2 != null) && ((2 != ((EmoticonPackage)localObject2).status) || (!((EmoticonPackage)localObject2).valid)))
      {
        if (((EmoticonPackage)localObject2).jobType == 4) {}
        for (bool = true;; bool = false)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)paramContext).getActivity(), paramQQAppInterface.getAccount(), 8, paramEmoticon.epId, false, bool);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
          return;
        }
      }
      if (!((EmojiManager)localObject1).c()) {
        break label645;
      }
      if (((EmojiManager)localObject1).a(paramEmoticon.epId, Boolean.valueOf(false))) {
        break;
      }
      ChatActivityUtils.a(paramContext, 2131370491, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
    return;
    Object localObject1 = MagicfaceActionManager.a(paramEmoticon, 0);
    if ((localObject1 != null) && (((ActionGlobalData)localObject1).a))
    {
      if (MagicfaceViewController.a())
      {
        ((FragmentActivity)paramContext).getChatFragment().a().a(paramEmoticon, 0, null, false);
        ((FragmentActivity)paramContext).getChatFragment().a().a().a(paramEmoticon);
        return;
      }
      paramEmoticon.magicValue = "value=1";
      label376:
      ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon);
      paramSessionInfo = "";
      if (((FragmentActivity)paramContext).getChatFragment().a().a() == null) {
        break label1200;
      }
    }
    label645:
    label678:
    label1200:
    for (int m = ((FragmentActivity)paramContext).getChatFragment().a().a().a(paramEmoticon.epId);; m = -1)
    {
      paramContext = paramSessionInfo;
      if (m >= 0) {
        paramContext = Integer.toString(m);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X80057A9", 0, 0, paramEmoticon.epId, "", paramContext, paramEmoticon.eId);
      return;
      int n = PngFrameUtil.a(MagicfaceActionManager.a(paramEmoticon, 0));
      m = 0;
      if (localObject2 != null) {
        m = ((EmoticonPackage)localObject2).rscType;
      }
      localObject2 = "rscType?" + m + ";value=" + n;
      paramEmoticon.magicValue = ((String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEmoticon.magicValue);
      }
      if ((localObject1 != null) && (!((ActionGlobalData)localObject1).c))
      {
        ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, paramEmoticon);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
        return;
      }
      ((FragmentActivity)paramContext).getChatFragment().a().a().a(paramEmoticon, new rlc(paramEmoticon, (String)localObject2, paramQQAppInterface, paramContext, paramSessionInfo));
      return;
      ChatActivityUtils.a(paramContext, 2131370490);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
      return;
      if ((paramEmoticon.jobType != 4) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity)))) {
        break label376;
      }
      localObject2 = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.a(), 0);
      if (localObject2 != null) {
        ((SharedPreferences)localObject2).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).commit();
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X800579D", 0, 0, paramEmoticon.epId, "", "", "");
      localObject2 = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEmoticon.epId);
      if ((localObject2 != null) && ((2 != ((EmoticonPackage)localObject2).status) || (!((EmoticonPackage)localObject2).valid)))
      {
        if (((EmoticonPackage)localObject2).jobType == 4) {}
        for (bool = true;; bool = false)
        {
          EmojiHomeUiPlugin.openEmojiDetailPage(((BaseActivity)paramContext).getActivity(), paramQQAppInterface.getAccount(), 8, paramEmoticon.epId, false, bool);
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C13", 0, 0, "", "", "", "");
          return;
        }
      }
      if (((EmojiManager)localObject1).c())
      {
        if (((EmojiManager)localObject1).b(paramEmoticon.epId, true, true))
        {
          if (((EmojiManager)localObject1).b())
          {
            localObject1 = new Intent(paramContext, H5MagicPlayerActivity.class);
            ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
            ((Intent)localObject1).putExtra("autoPlay", "1");
            ((Intent)localObject1).putExtra("senderUin", paramQQAppInterface.a());
            ((Intent)localObject1).putExtra("selfUin", paramQQAppInterface.a());
            ((Intent)localObject1).putExtra("sessionInfo", paramSessionInfo);
            ((Intent)localObject1).putExtra("emoticon", paramEmoticon);
            localObject2 = (EmoticonManager)paramQQAppInterface.getManager(13);
            EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject2).a(paramEmoticon.epId);
            if (localEmoticonPackage != null)
            {
              localObject2 = ((EmoticonManager)localObject2).a(localEmoticonPackage.childEpId);
              if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
                ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
              }
            }
            paramContext.startActivity((Intent)localObject1);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "MbFasong", "MbZidongBofang", 0, 0, "", "", "", "");
            break label376;
          }
          if (!QLog.isColorLevel()) {
            break label376;
          }
          QLog.d("PicEmoticonInfo", 2, "not support h5magic ");
          break label376;
        }
        ChatActivityUtils.a(paramContext, 2131370491, 0);
        paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
        if (paramQQAppInterface == null) {
          break;
        }
        paramQQAppInterface.obtainMessage(10).sendToTarget();
        paramQQAppInterface.obtainMessage(21).sendToTarget();
        return;
      }
      ChatActivityUtils.a(paramContext, 2131370490);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "0X8005C16", 0, 0, "", "", "", "");
      return;
    }
  }
  
  public static void a(EmoticonPackage paramEmoticonPackage, Emoticon paramEmoticon, Activity paramActivity)
  {
    if ((paramEmoticonPackage.jobType == 0) && (paramEmoticonPackage.subType == 4))
    {
      if (paramEmoticonPackage.businessExtra != null) {
        break label75;
      }
      paramEmoticonPackage = "";
      if (paramEmoticon.businessExtra != null) {
        break label83;
      }
    }
    label75:
    label83:
    for (String str = "";; str = paramEmoticon.businessExtra)
    {
      ThreadManager.a(new rld(EmoticonUtils.o.replace("[epId]", paramEmoticon.epId).replace("[eId]", paramEmoticon.eId), paramActivity, paramEmoticon, paramEmoticonPackage, str), null, false);
      return;
      paramEmoticonPackage = paramEmoticonPackage.businessExtra;
      break;
    }
  }
  
  public static void b(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable != null) && ((paramURLDrawable instanceof GifDrawable)))
      {
        paramURLDrawable = ((GifDrawable)paramURLDrawable).getImage();
        if ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImage))) {
          break label62;
        }
        ((VoiceGifImage)paramURLDrawable).b();
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
        }
      }
    }
    label62:
    do
    {
      do
      {
        return;
      } while ((paramURLDrawable == null) || (!(paramURLDrawable instanceof VoiceGifImageV2)));
      ((VoiceGifImageV2)paramURLDrawable).b();
    } while (!QLog.isColorLevel());
    QLog.d("PicEmoticonInfo", 2, "soundgif stopSoundDrawablePlay stop");
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null)
    {
      Object localObject = null;
      try
      {
        paramContext = new URL("emotion_pic", "fromPanel", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        if (paramContext != null)
        {
          ColorDrawable localColorDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          if (this.b != null)
          {
            localObject = this.b;
            paramContext = URLDrawable.getDrawable(paramContext, localColorDrawable, (Drawable)localObject, false);
            paramContext.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
            paramContext.addHeader("my_uin", this.l);
            return paramContext;
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          paramContext = (Context)localObject;
          if (QLog.isColorLevel())
          {
            QLog.d("PicEmoticonInfo", 2, "getDrawable ,", localMalformedURLException);
            paramContext = (Context)localObject;
            continue;
            localObject = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
          }
        }
      }
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public URLDrawable a()
  {
    Object localObject4 = null;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      localObject1 = localObject4;
    }
    for (;;)
    {
      return (URLDrawable)localObject1;
      String str = EmoticonUtils.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      localObject1 = localObject4;
      if (str == null) {
        continue;
      }
      try
      {
        localObject3 = new URL("emotion_pic", "fromAIO", a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
        localObject1 = localObject4;
        if (localObject3 == null) {
          continue;
        }
        a();
        localObject3 = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.b, false);
        localObject1 = localObject3;
        if (((URLDrawable)localObject3).getStatus() == 1) {
          continue;
        }
        ((URLDrawable)localObject3).setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        ((URLDrawable)localObject3).addHeader("my_uin", this.l);
        localObject1 = localObject3;
        if (!FileUtil.a(str)) {
          continue;
        }
        try
        {
          ((URLDrawable)localObject3).downloadImediatly();
          return (URLDrawable)localObject3;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Object localObject2 = localObject3;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PicEmoticonInfo", 2, "getBigDrawable oom,drawableID=" + this.e);
        return (URLDrawable)localObject3;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          localMalformedURLException.printStackTrace();
          Object localObject3 = null;
        }
      }
    }
  }
  
  public URLDrawable a(Context paramContext, float paramFloat)
  {
    return a("fromAIO", true);
  }
  
  public URLDrawable a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      localObject = null;
      return (URLDrawable)localObject;
    }
    Drawable localDrawable;
    try
    {
      paramString = new URL("emotion_pic", paramString, a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon));
      if (paramString == null) {
        return null;
      }
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        QLog.e("PicEmoticonInfo", 1, "market face getLoadingDrawable", paramString);
        paramString = null;
      }
      a();
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      localDrawable = this.b;
      if (this.h == 0) {
        break label165;
      }
    }
    if (this.i != 0) {}
    label165:
    for (paramString = URLDrawable.getDrawable(paramString, this.h, this.i, (Drawable)localObject, localDrawable, paramBoolean);; paramString = URLDrawable.getDrawable(paramString, (Drawable)localObject, localDrawable, paramBoolean))
    {
      localObject = paramString;
      if (paramString.getStatus() == 1) {
        break;
      }
      paramString.setTag(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      paramString.addHeader("my_uin", this.l);
      paramString.addHeader("emo_type", String.valueOf(this.j));
      if (paramString.getStatus() != 2)
      {
        localObject = paramString;
        if (paramString.getStatus() != 3) {
          break;
        }
      }
      paramString.restartDownload();
      return paramString;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null)
    {
      VasReportUtils.a("emotionType", "emotionActionSend", "1", "", "", "", "", "", "", "");
      QLog.e("PicEmoticonInfo", 1, "send isFroward emotion = null");
    }
    label390:
    label674:
    label692:
    do
    {
      do
      {
        return;
        paramEditText = (EmojiManager)paramQQAppInterface.getManager(42);
        if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 2) || (!paramBoolean) || ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) || (!MagicfaceViewController.a())) {
          break label390;
        }
        if (paramEditText.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, Boolean.valueOf(false))) {
          break;
        }
        ChatActivityUtils.a(paramContext, 2131370491, 0);
        paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
      } while (paramQQAppInterface == null);
      paramQQAppInterface.obtainMessage(10).sendToTarget();
      paramQQAppInterface.obtainMessage(21).sendToTarget();
      return;
      int m = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "forward,【maxInt:】" + m);
      }
      m = PngFrameUtil.a(m);
      paramEditText = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      int n = PngFrameUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
      if (-1 != n)
      {
        paramEditText.rscType = n;
        ((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramEditText);
      }
      paramEditText = "rscType?" + n + ";value=" + m;
      this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue = paramEditText;
      if (QLog.isColorLevel()) {
        QLog.d("PicEmoticonInfo", 2, "before play,magicvalue:" + paramEditText);
      }
      Object localObject = MagicfaceActionManager.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, 0);
      if ((localObject != null) && (!((ActionGlobalData)localObject).c))
      {
        ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        return;
      }
      ((FragmentActivity)paramContext).getChatFragment().a().a().a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, new rlb(this, paramEditText, paramQQAppInterface, paramContext, paramSessionInfo));
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 4) && (paramBoolean) && (((paramContext instanceof SplashActivity)) || ((paramContext instanceof ChatActivity))))
      {
        localObject = paramContext.getSharedPreferences("emoticon_panel_" + paramQQAppInterface.a(), 0);
        if (localObject != null) {
          ((SharedPreferences)localObject).edit().putLong("sp_key_send_h5_magic_face_time", System.currentTimeMillis()).commit();
        }
        if (!paramEditText.b(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, true, true)) {
          break label692;
        }
        if (!paramEditText.b()) {
          break label674;
        }
        paramEditText = new Intent(paramContext, H5MagicPlayerActivity.class);
        paramEditText.putExtra("clickTime", System.currentTimeMillis());
        paramEditText.putExtra("autoPlay", "1");
        paramEditText.putExtra("senderUin", paramQQAppInterface.a());
        paramEditText.putExtra("selfUin", paramQQAppInterface.a());
        paramEditText.putExtra("sessionInfo", paramSessionInfo);
        paramEditText.putExtra("emoticon", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        localObject = (EmoticonManager)paramQQAppInterface.getManager(13);
        EmoticonPackage localEmoticonPackage = ((EmoticonManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        if (localEmoticonPackage != null)
        {
          localObject = ((EmoticonManager)localObject).a(localEmoticonPackage.childEpId);
          if ((localObject != null) && (((List)localObject).size() > 0)) {
            paramEditText.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
          }
        }
        paramContext.startActivity(paramEditText);
      }
      for (;;)
      {
        ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PicEmoticonInfo", 2, "forward not support h5magic");
        }
      }
      ChatActivityUtils.a(paramContext, 2131370491, 0);
      paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.obtainMessage(10).sendToTarget();
    paramQQAppInterface.obtainMessage(21).sendToTarget();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound);
  }
  
  public boolean b()
  {
    boolean bool2 = true;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) || (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1))
    {
      bool1 = false;
      return bool1;
    }
    Object localObject = EmoticonUtils.o.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        bool1 = true;
      }
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (bool1))
      {
        localObject = EmoticonUtils.k.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
        if (localObject == null) {
          break label165;
        }
        localObject = new File((String)localObject);
        if (((File)localObject).exists())
        {
          bool1 = bool2;
          if (((File)localObject).isFile()) {
            break;
          }
        }
        return false;
        bool1 = false;
        continue;
      }
      return bool1;
      label165:
      return false;
      bool1 = false;
    }
  }
  
  public boolean c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon == null) {
      return false;
    }
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 1)
    {
      localObject = EmoticonUtils.l.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      label52:
      if (localObject == null) {
        break label112;
      }
      localObject = new File((String)localObject);
      if ((!((File)localObject).exists()) || (!((File)localObject).isFile())) {
        break label114;
      }
    }
    for (;;)
    {
      return bool;
      localObject = EmoticonUtils.m.replace("[epId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).replace("[eId]", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      break label52;
      label112:
      break;
      label114:
      bool = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\PicEmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */