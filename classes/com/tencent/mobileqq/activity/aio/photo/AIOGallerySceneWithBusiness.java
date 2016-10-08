package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import cooperation.comic.VipComicReportUtils;
import cooperation.qqfav.QfavBuilder;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import ntu;
import org.json.JSONObject;

public class AIOGallerySceneWithBusiness
  extends AIOGalleryScene
{
  public static final int l = 1;
  public static final int m = 2;
  public Button a;
  private Set a;
  public Button b;
  View jdField_c_of_type_AndroidViewView;
  public Button c;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  public AIOGallerySceneWithBusiness(Activity paramActivity, AbstractImageListModel paramAbstractImageListModel, IAIOImageProvider paramIAIOImageProvider, String paramString)
  {
    super(paramActivity, paramAbstractImageListModel, paramIAIOImageProvider, paramString);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String[] paramArrayOfString)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfString != null)
    {
      i = j;
      if (paramArrayOfString.length >= 8)
      {
        j = 1;
        if (paramArrayOfString[7].equals("link")) {}
        do
        {
          return 3;
          i = j;
          if (paramArrayOfString.length < 9) {
            break;
          }
          i = j;
          if (!paramArrayOfString[7].equals("scrawl_link")) {
            break;
          }
          paramArrayOfString = paramArrayOfString[8];
          i = j;
          if (TextUtils.isEmpty(paramArrayOfString)) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageData", 2, "name = " + paramArrayOfString + " , name.length = " + paramArrayOfString.length());
          }
          i = j;
          if (paramArrayOfString.startsWith("upload")) {
            break;
          }
        } while (paramArrayOfString.trim().length() <= 32);
        i = j;
      }
    }
    return i;
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForStructing)))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      if ((paramChatMessage.structingMsg != null) && ((paramChatMessage.structingMsg instanceof StructMsgForImageShare))) {
        return a((StructMsgForImageShare)paramChatMessage.structingMsg);
      }
    }
    return null;
  }
  
  public static String a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      localObject1 = localObject2;
      if (a(paramStructMsgForImageShare.mMsgActionData))
      {
        if ((TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)) || (paramStructMsgForImageShare.mMsg_A_ActionData.indexOf("|") <= 0)) {
          break label67;
        }
        localObject1 = "comic_plugin.apk|" + paramStructMsgForImageShare.mMsg_A_ActionData;
      }
    }
    return (String)localObject1;
    label67:
    return paramStructMsgForImageShare.mMsgActionData;
  }
  
  public static String a(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8)
      {
        if (!paramString[7].equals("link")) {
          break label57;
        }
        str1 = paramString[4];
      }
    }
    label57:
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (!paramString[7].equals("scrawl_link"));
      str1 = str2;
    } while (paramString.length < 9);
    return paramString[8];
  }
  
  public static boolean a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    return a(a(paramStructMsgForImageShare));
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("comic_plugin.apk"));
  }
  
  public static final String[] a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    int j = 1;
    String[] arrayOfString;
    if ((paramStructMsgForImageShare.mMsgActionData != null) && (paramStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
    {
      arrayOfString = paramStructMsgForImageShare.mMsgActionData.substring(paramStructMsgForImageShare.mMsgActionData.indexOf("|") + 1).split("\\|");
      if ((arrayOfString.length < 8) || ((!arrayOfString[7].equals("link")) && (!arrayOfString[7].equals("scrawl_link")))) {
        break label141;
      }
    }
    label141:
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramStructMsgForImageShare.mMsg_A_ActionData)))
      {
        paramStructMsgForImageShare = paramStructMsgForImageShare.mMsg_A_ActionData.split("\\|");
        if ((paramStructMsgForImageShare.length >= 8) && (paramStructMsgForImageShare[7].equals("link"))) {
          i = j;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          return paramStructMsgForImageShare;
          i = 0;
        }
        else
        {
          return null;
          paramStructMsgForImageShare = arrayOfString;
        }
      }
    }
  }
  
  public static String[] a(String paramString)
  {
    if (a(paramString)) {
      return paramString.substring(paramString.indexOf("|") + 1).split("\\|");
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (a(paramString))
    {
      paramString = paramString.substring(paramString.indexOf("|") + 1).split("\\|");
      str1 = str2;
      if (paramString.length >= 8) {
        if (!paramString[7].equals("link"))
        {
          str1 = str2;
          if (!paramString[7].equals("scrawl_link")) {}
        }
        else
        {
          str1 = paramString[0];
        }
      }
    }
    return str1;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    paramViewGroup = (RelativeLayout)a();
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130905094, null);
    this.jdField_c_of_type_AndroidViewView.setClickable(true);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)TypedValue.applyDimension(1, 72.0F, this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics()));
    localLayoutParams.addRule(12, -1);
    paramViewGroup.addView(this.jdField_c_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131305269));
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    this.b = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131305270));
    this.b.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131305271));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131305267));
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    paramViewGroup = new ntu(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramViewGroup);
    this.b.setOnClickListener(paramViewGroup);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(paramViewGroup);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare)
  {
    if (paramStructMsgForImageShare == null) {}
    Object localObject2;
    Object localObject1;
    URLDrawable localURLDrawable;
    label66:
    do
    {
      return;
      localObject2 = paramStructMsgForImageShare.getFirstImageElement();
      if (localObject2 == null) {
        break label370;
      }
      if (((StructMsgItemImage)localObject2).a == null) {
        ((StructMsgItemImage)localObject2).a = paramStructMsgForImageShare;
      }
      localObject1 = ((StructMsgItemImage)localObject2).a();
      localURLDrawable = ForwardUtils.a(this.jdField_a_of_type_AndroidAppActivity, (MessageForPic)localObject1);
      if (!new File(((MessageForPic)localObject1).path).exists()) {
        break;
      }
      ((StructMsgItemImage)localObject2).o = ((MessageForPic)localObject1).path;
      if (!TextUtils.isEmpty(((StructMsgItemImage)localObject2).o)) {
        break label173;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement.mShareImageUrl is null!!!");
    return;
    String str = localURLDrawable.getURL().toString();
    if (AbsDownloader.a(str))
    {
      localObject1 = AbsDownloader.a(str);
      if (localObject1 == null) {
        break label420;
      }
      localObject1 = ((File)localObject1).getAbsolutePath();
    }
    for (;;)
    {
      ((StructMsgItemImage)localObject2).o = ((String)localObject1);
      break label66;
      localObject1 = URLDrawableHelper.a((PicUiInterface)localObject1, 65537);
      if (localObject1 != null)
      {
        localObject1 = AbsDownloader.a(((URL)localObject1).toString());
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          continue;
          label173:
          if (!AbsDownloader.a(localURLDrawable.getURL().toString())) {
            localURLDrawable.startDownload();
          }
          localObject1 = new Bundle();
          if ((paramStructMsgForImageShare.source_puin != null) && (!"".equals(paramStructMsgForImageShare.source_puin))) {
            ((Bundle)localObject1).putString("source_puin", paramStructMsgForImageShare.source_puin);
          }
          ((Bundle)localObject1).putInt("forward_type", -3);
          paramStructMsgForImageShare.mCommentText = null;
          ((Bundle)localObject1).putInt("structmsg_service_id", paramStructMsgForImageShare.mMsgServiceID);
          ((Bundle)localObject1).putByteArray("stuctmsg_bytes", paramStructMsgForImageShare.getBytes());
          localObject2 = new Intent();
          ((Intent)localObject2).putExtras((Bundle)localObject1);
          ForwardBaseOption.a(this.jdField_a_of_type_AndroidAppActivity, (Intent)localObject2, 0);
          localObject1 = a(paramStructMsgForImageShare);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break;
          }
          if (localObject1.length >= 8) {
            if (localObject1[7].equals("link")) {
              paramStructMsgForImageShare = localObject1[4];
            }
          }
          for (;;)
          {
            VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40058", localObject1[0], new String[] { "1", "", paramStructMsgForImageShare });
            return;
            label370:
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("AIOGalleryScene", 2, "StructingMsgItemBuilder onMenuItemClicked forward imageElement is null!!!");
            return;
            if ((localObject1[7].equals("scrawl_link")) && (localObject1.length >= 9)) {
              paramStructMsgForImageShare = localObject1[8];
            } else {
              paramStructMsgForImageShare = "";
            }
          }
        }
      }
      label420:
      localObject1 = null;
    }
  }
  
  protected void a(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    Object localObject2 = "";
    paramStructMsgForImageShare = a(paramStructMsgForImageShare);
    Object localObject1 = localObject2;
    if (paramStructMsgForImageShare != null)
    {
      localObject1 = localObject2;
      if (paramStructMsgForImageShare.length > 0) {
        localObject1 = paramStructMsgForImageShare[0];
      }
    }
    localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("from", "13");
      localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
      localJSONObject.put("leftViewText", "返回");
      localJSONObject.put("maintab", "index");
      ((Intent)localObject2).setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
      this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
      if ((paramStructMsgForImageShare != null) && (paramStructMsgForImageShare.length >= 8))
      {
        if (paramStructMsgForImageShare[7].equals("link"))
        {
          paramStructMsgForImageShare = paramStructMsgForImageShare[4];
          if (!"5".equals(paramString)) {
            break label248;
          }
          VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40057", (String)localObject1, new String[] { "", "", paramStructMsgForImageShare });
        }
        label248:
        while (!"6".equals(paramString))
        {
          return;
          if ((!paramStructMsgForImageShare[7].equals("scrawl_link")) || (paramStructMsgForImageShare.length < 9)) {
            break label305;
          }
          paramStructMsgForImageShare = paramStructMsgForImageShare[8];
          break;
        }
        VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40058", (String)localObject1, new String[] { "4", "", paramStructMsgForImageShare });
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        label305:
        paramStructMsgForImageShare = "";
      }
    }
  }
  
  boolean a(AIORichMediaInfo paramAIORichMediaInfo)
  {
    if (paramAIORichMediaInfo == null) {
      return false;
    }
    int i;
    Object localObject1;
    StructMsgForImageShare localStructMsgForImageShare;
    String[] arrayOfString;
    Object localObject2;
    if ((this.jdField_a_of_type_AndroidWidgetImageButton.getVisibility() != 4) || (this.jdField_c_of_type_AndroidViewView.getVisibility() != 4))
    {
      i = 1;
      if (AIOImageData.class.isInstance(paramAIORichMediaInfo.a))
      {
        localObject1 = (AIOImageData)paramAIORichMediaInfo.a;
        if (((AIOImageData)localObject1).h != 1) {
          break label449;
        }
        localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])((AIOImageData)localObject1).a);
        arrayOfString = a(localStructMsgForImageShare);
        Object localObject3 = null;
        Object localObject4 = null;
        localObject2 = localObject4;
        localObject1 = localObject3;
        if (arrayOfString != null)
        {
          localObject2 = localObject4;
          localObject1 = localObject3;
          if (arrayOfString.length >= 8)
          {
            localObject1 = arrayOfString[1];
            localObject2 = arrayOfString[3] + "第" + arrayOfString[5] + "页";
            if ((localObject1 == null) || (((String)localObject1).length() < 7)) {
              break label473;
            }
            localObject1 = ((String)localObject1).substring(0, 6) + "...";
          }
        }
      }
    }
    label304:
    label320:
    label430:
    label449:
    label473:
    for (;;)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramAIORichMediaInfo.hashCode())))
      {
        VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3008", "1", "30004", arrayOfString[0], new String[] { arrayOfString[2], arrayOfString[4], a(localStructMsgForImageShare.mMsgActionData) });
        this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramAIORichMediaInfo.hashCode()));
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label430;
        }
        this.b.setVisibility(8);
        if ((arrayOfString != null) && (arrayOfString.length >= 8) && (this.jdField_c_of_type_AndroidWidgetTextView != null)) {
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        this.jdField_c_of_type_AndroidViewView.invalidate();
        this.jdField_a_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
        this.b.setTag(localStructMsgForImageShare);
        this.jdField_c_of_type_AndroidWidgetButton.setTag(localStructMsgForImageShare);
        if (i != 0)
        {
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
          this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        }
      }
      for (;;)
      {
        return true;
        i = 0;
        break;
        this.jdField_a_of_type_AndroidWidgetButton.setText((CharSequence)localObject1);
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        break label304;
        this.b.setText((CharSequence)localObject2);
        this.b.setVisibility(0);
        break label320;
        if (i != 0)
        {
          this.jdField_c_of_type_AndroidViewView.setVisibility(4);
          this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
        }
      }
    }
  }
  
  boolean a(ActionSheet paramActionSheet, AIOImageData paramAIOImageData)
  {
    if ((paramActionSheet == null) || (paramAIOImageData == null)) {
      return false;
    }
    if (paramAIOImageData.h == 1)
    {
      paramActionSheet.c(2131370093);
      paramActionSheet.c(2131370097);
      paramActionSheet.c(2131370114);
      paramActionSheet.c(2131370115);
      return true;
    }
    return false;
  }
  
  boolean a(String paramString, AIOImageData paramAIOImageData, File paramFile)
  {
    if ((paramString == null) || (paramAIOImageData == null) || (paramFile == null)) {}
    do
    {
      do
      {
        return false;
        if (!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370093))) {
          break;
        }
      } while (paramAIOImageData.h != 1);
      a((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a));
      return true;
      if (!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370097))) {
        break;
      }
    } while (paramAIOImageData.h != 1);
    StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a);
    String[] arrayOfString = a(localStructMsgForImageShare);
    boolean bool;
    label159:
    String str;
    if ((arrayOfString != null) && (arrayOfString.length >= 8) && ((arrayOfString[7].equals("link")) || (arrayOfString[7].equals("scrawl_link"))))
    {
      bool = true;
      if (bool)
      {
        paramAIOImageData = null;
        paramString = paramAIOImageData;
        if (arrayOfString[7].equals("scrawl_link"))
        {
          paramString = paramAIOImageData;
          if (arrayOfString.length > 8) {
            paramString = arrayOfString[8];
          }
        }
        str = arrayOfString[3] + "第" + arrayOfString[5] + "页";
        paramAIOImageData = "http://imgcache.qq.com/club/client/comic/release/html/read_share.html?_bid=354&ADTAG=comic.plugin.read&_wv=5123&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&sectionName=" + URLEncoder.encode(arrayOfString[3]) + "&pageID=" + arrayOfString[4] + "&page=" + arrayOfString[5] + "&type=" + arrayOfString[6];
        if (TextUtils.isEmpty(paramString)) {
          break label713;
        }
      }
    }
    label713:
    for (paramString = paramAIOImageData + "&scrawl_link=" + URLEncoder.encode(paramString);; paramString = paramAIOImageData)
    {
      new QfavBuilder(6).a("nLinkType", 0).b("sTitle", arrayOfString[1]).b("sUrl", paramString).a("bAppShare", false).a("lAppId", 0L).b("sPublisher", localStructMsgForImageShare.mSourceName).b("sBrief", str).b("sPath", paramFile.getAbsolutePath()).b("sResUrl", localStructMsgForImageShare.mSourceUrl).a("lCategory", 1L).a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_c_of_type_JavaLangString);
      QfavReport.a(null, 6, 2);
      if (arrayOfString.length >= 8) {
        if (arrayOfString[7].equals("link")) {
          paramString = arrayOfString[4];
        }
      }
      for (;;)
      {
        VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40058", arrayOfString[0], new String[] { "2", "", paramString });
        return bool;
        bool = false;
        break label159;
        if ((arrayOfString[7].equals("scrawl_link")) && (arrayOfString.length >= 9))
        {
          paramString = arrayOfString[8];
          continue;
          if (paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370114)))
          {
            if (paramAIOImageData.h != 1) {
              break;
            }
            b((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
            return true;
          }
          if ((!paramString.equals(this.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131370115))) || (paramAIOImageData.h != 1)) {
            break;
          }
          a((StructMsgForImageShare)StructMsgFactory.a((byte[])paramAIOImageData.a), "6");
          return true;
        }
        paramString = "";
      }
    }
  }
  
  public void b(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {}
    for (;;)
    {
      return;
      paramStructMsgForImageShare = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("from", "13");
        localJSONObject.put("jumpto", "com.qqcomic.activity.VipComicTabBrowserActivity");
        localJSONObject.put("url", URLEncoder.encode("http://imgcache.qq.com/club/client/comic/release/html/detail.html?_bid=354&ADTAG=comic.plugin.fav&_cwv=1&pos=aio&id=" + arrayOfString[0]));
        localJSONObject.put("leftViewText", "返回");
        paramStructMsgForImageShare.setData(Uri.parse("mqqapi://qqcomic/jump?options=" + localJSONObject.toString()));
        this.jdField_a_of_type_AndroidAppActivity.startActivity(paramStructMsgForImageShare);
        if (arrayOfString.length >= 8)
        {
          if (arrayOfString[7].equals("link")) {}
          for (paramStructMsgForImageShare = arrayOfString[4]; "5".equals(paramString); paramStructMsgForImageShare = arrayOfString[8])
          {
            VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40055", arrayOfString[0], new String[] { "", "", paramStructMsgForImageShare });
            return;
            if ((!arrayOfString[7].equals("scrawl_link")) || (arrayOfString.length < 9)) {
              break label313;
            }
          }
          if (!"6".equals(paramString)) {
            continue;
          }
          VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40058", arrayOfString[0], new String[] { "3", "", paramStructMsgForImageShare });
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          label313:
          paramStructMsgForImageShare = "";
        }
      }
    }
  }
  
  public void c(StructMsgForImageShare paramStructMsgForImageShare, String paramString)
  {
    String[] arrayOfString = a(paramStructMsgForImageShare);
    if ((arrayOfString == null) || (arrayOfString.length < 8)) {
      return;
    }
    paramStructMsgForImageShare = "http://imgcache.qq.com/club/client/comic/release/html/redirect.html?_wv=5123&_bid=354&_cfrom=13&action=read&actionType=keepread&id=" + arrayOfString[0] + "&name=" + URLEncoder.encode(arrayOfString[1]) + "&sectionID=" + arrayOfString[2] + "&pageID=" + arrayOfString[4] + "&pageOffset=0&type=" + arrayOfString[6];
    paramString = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
    paramString.putExtra("url", paramStructMsgForImageShare);
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramString);
    paramString = "";
    if (arrayOfString.length >= 8)
    {
      paramStructMsgForImageShare = arrayOfString[4];
      if (arrayOfString[7].equals("link")) {
        paramString = arrayOfString[4];
      }
    }
    for (;;)
    {
      VipComicReportUtils.a(null, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_AndroidAppActivity, "3017", "2", "40056", arrayOfString[0], new String[] { "", paramStructMsgForImageShare, paramString });
      return;
      paramString = paramStructMsgForImageShare;
      if (arrayOfString[7].equals("scrawl_link"))
      {
        paramString = paramStructMsgForImageShare;
        if (arrayOfString.length >= 9)
        {
          paramString = arrayOfString[8];
          continue;
        }
      }
      paramStructMsgForImageShare = paramString;
      paramString = "";
    }
  }
  
  boolean f()
  {
    AIORichMediaInfo localAIORichMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.b();
    if ((localAIORichMediaInfo != null) && (AIOImageData.class.isInstance(localAIORichMediaInfo.a)) && (((AIOImageData)localAIORichMediaInfo.a).h == 1)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return true;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      return true;
    }
  }
  
  boolean g()
  {
    this.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(4);
    this.jdField_c_of_type_AndroidViewView.setVisibility(4);
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOGallerySceneWithBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */