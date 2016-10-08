package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.data.VipComicFavorEmoStructMsgInfo;
import com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.comic.VipComicReportUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import rkw;
import rkx;
import rky;

public class FavoriteEmoticonInfo
  extends EmoticonInfo
{
  static long jdField_a_of_type_Long = 0L;
  static final long b = 1000L;
  public static final String k = FavoriteEmoticonInfo.class.getSimpleName();
  private ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable();
  public String l;
  public String m;
  public String n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public FavoriteEmoticonInfo()
  {
    this.b = "show_fav_menu";
  }
  
  public static String a(Map paramMap, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramMap == null) || (paramMap.size() == 0)) {
      return null;
    }
    paramMap = (VipComicFavorEmoStructMsgInfo)paramMap.get(paramString.toUpperCase());
    if (paramMap != null) {
      return paramMap.actionData;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("image_url", this.m);
    localBundle.putInt("forward_type", -3);
    localBundle.putString("pkg_name", "com.tencent.mobileqq");
    localBundle.putInt("req_type", 5);
    localBundle.putString("brief_key", "[图片]");
    localBundle.putString("app_name", "QQ动漫");
    localBundle.putString("struct_share_key_content_action_DATA", this.n);
    StructMsgForImageShare.sendAndUploadImageShare(paramQQAppInterface, (StructMsgForImageShare)StructMsgFactory.a(localBundle), paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramSessionInfo.b);
    paramSessionInfo = AIOGallerySceneWithBusiness.a(this.n);
    if ((paramSessionInfo != null) && (paramSessionInfo.length >= 8)) {
      VipComicReportUtils.a(paramQQAppInterface, "3016", "2", "40051", paramSessionInfo[0], new String[] { paramSessionInfo[2], paramSessionInfo[4], AIOGallerySceneWithBusiness.a(this.n) });
    }
  }
  
  /* Error */
  public Drawable a(Context paramContext, float paramFloat)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 39	android/graphics/drawable/ColorDrawable
    //   6: dup
    //   7: invokespecial 40	android/graphics/drawable/ColorDrawable:<init>	()V
    //   10: astore_1
    //   11: invokestatic 158	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   14: invokevirtual 162	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   17: astore 4
    //   19: aload 4
    //   21: ldc -93
    //   23: invokevirtual 169	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   26: astore_3
    //   27: aload_3
    //   28: astore_1
    //   29: aload 4
    //   31: ldc -86
    //   33: invokevirtual 169	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   36: astore 4
    //   38: aload_1
    //   39: astore_3
    //   40: aload 4
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 81	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:m	Ljava/lang/String;
    //   47: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifne +125 -> 175
    //   53: aload_0
    //   54: getfield 81	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:m	Ljava/lang/String;
    //   57: ldc -84
    //   59: invokevirtual 175	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   62: ifeq +113 -> 175
    //   65: new 39	android/graphics/drawable/ColorDrawable
    //   68: dup
    //   69: invokespecial 40	android/graphics/drawable/ColorDrawable:<init>	()V
    //   72: pop
    //   73: invokestatic 181	com/tencent/image/URLDrawable$URLDrawableOptions:obtain	()Lcom/tencent/image/URLDrawable$URLDrawableOptions;
    //   76: astore 4
    //   78: aload 4
    //   80: bipush 100
    //   82: putfield 184	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestWidth	I
    //   85: aload 4
    //   87: bipush 100
    //   89: putfield 187	com/tencent/image/URLDrawable$URLDrawableOptions:mRequestHeight	I
    //   92: aload 4
    //   94: aload_3
    //   95: putfield 191	com/tencent/image/URLDrawable$URLDrawableOptions:mLoadingDrawable	Landroid/graphics/drawable/Drawable;
    //   98: aload 4
    //   100: aload_1
    //   101: putfield 194	com/tencent/image/URLDrawable$URLDrawableOptions:mFailedDrawable	Landroid/graphics/drawable/Drawable;
    //   104: new 196	java/io/File
    //   107: dup
    //   108: aload_0
    //   109: getfield 81	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:m	Ljava/lang/String;
    //   112: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;)V
    //   115: aload 4
    //   117: invokestatic 204	com/tencent/image/URLDrawable:getDrawable	(Ljava/io/File;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   120: astore 4
    //   122: aload 4
    //   124: areturn
    //   125: astore_3
    //   126: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +14 -> 143
    //   132: getstatic 33	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:k	Ljava/lang/String;
    //   135: iconst_2
    //   136: aload_3
    //   137: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   140: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_1
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_1
    //   147: goto -104 -> 43
    //   150: astore_3
    //   151: invokestatic 210	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +14 -> 168
    //   157: getstatic 33	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:k	Ljava/lang/String;
    //   160: iconst_2
    //   161: aload_3
    //   162: invokevirtual 218	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   165: invokestatic 217	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: aload_1
    //   169: astore_3
    //   170: aconst_null
    //   171: astore_1
    //   172: goto -129 -> 43
    //   175: aload_0
    //   176: getfield 81	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:m	Ljava/lang/String;
    //   179: ldc -36
    //   181: invokestatic 225	com/tencent/mobileqq/emoticonview/FavoriteDownloader:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/net/URL;
    //   184: astore 7
    //   186: new 227	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   189: dup
    //   190: invokespecial 228	com/tencent/mobileqq/activity/photo/LocalMediaInfo:<init>	()V
    //   193: astore 6
    //   195: aload 6
    //   197: aload_0
    //   198: getfield 81	com/tencent/mobileqq/emoticonview/FavoriteEmoticonInfo:m	Ljava/lang/String;
    //   201: putfield 229	com/tencent/mobileqq/activity/photo/LocalMediaInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   204: aload 6
    //   206: bipush 100
    //   208: putfield 232	com/tencent/mobileqq/activity/photo/LocalMediaInfo:f	I
    //   211: aload 6
    //   213: bipush 100
    //   215: putfield 235	com/tencent/mobileqq/activity/photo/LocalMediaInfo:g	I
    //   218: aload 5
    //   220: astore 4
    //   222: aload 7
    //   224: ifnull -102 -> 122
    //   227: aload 7
    //   229: aload_3
    //   230: aload_1
    //   231: invokestatic 240	com/tencent/mobileqq/transfile/URLDrawableHelper:a	(Ljava/net/URL;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Lcom/tencent/image/URLDrawable;
    //   234: astore_1
    //   235: aload_1
    //   236: aload 6
    //   238: invokevirtual 244	com/tencent/image/URLDrawable:setTag	(Ljava/lang/Object;)V
    //   241: aload_1
    //   242: areturn
    //   243: astore_3
    //   244: goto -93 -> 151
    //   247: astore_3
    //   248: goto -122 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	FavoriteEmoticonInfo
    //   0	251	1	paramContext	Context
    //   0	251	2	paramFloat	float
    //   26	69	3	localObject1	Object
    //   125	12	3	localException1	Exception
    //   144	1	3	localContext1	Context
    //   150	12	3	localOutOfMemoryError1	OutOfMemoryError
    //   169	61	3	localContext2	Context
    //   243	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   247	1	3	localException2	Exception
    //   17	204	4	localObject2	Object
    //   1	218	5	localObject3	Object
    //   193	44	6	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    //   184	44	7	localURL	URL
    // Exception table:
    //   from	to	target	type
    //   11	27	125	java/lang/Exception
    //   11	27	150	java/lang/OutOfMemoryError
    //   29	38	243	java/lang/OutOfMemoryError
    //   29	38	247	java/lang/Exception
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, EmoticonCallback paramEmoticonCallback)
  {
    String[] arrayOfString = paramContext.getResources().getStringArray(2131230727);
    paramContext = (ActionSheet)ActionSheetHelper.a(paramContext, null);
    paramContext.a(arrayOfString[0], 1);
    paramContext.a(arrayOfString[1], 1);
    paramContext.d(2131367262);
    paramContext.a(new rkx(this, paramQQAppInterface, paramEmoticonCallback, paramContext));
    paramContext.a(new rky(this, paramQQAppInterface));
    paramContext.show();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - jdField_a_of_type_Long < 1000L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FavoriteEmoticonInfo", 2, "send to offen,please try it later");
      }
      return;
    }
    jdField_a_of_type_Long = l1;
    if (AIOGallerySceneWithBusiness.a(this.n))
    {
      a(paramQQAppInterface, paramSessionInfo);
      return;
    }
    ChatActivityFacade.a(paramQQAppInterface, paramContext, paramSessionInfo, this.m, true);
    if ((!TextUtils.isEmpty(this.m)) && (this.m.contains("qto_")))
    {
      ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "0X8005C74", "0X8005C74", 0, 0, String.valueOf(FunnyPicHelper.a(this.l)), "", FunnyPicHelper.a(this.m), "");
      return;
    }
    ReportController.b(((BaseActivity)paramContext).app, "CliOper", "", "", "ep_mall", "0X800579F", 0, 0, "", "", "", "");
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    int j = 0;
    Object localObject1 = (FavroamingDBManager)paramQQAppInterface.getManager(148);
    Object localObject3 = ((FavroamingDBManager)localObject1).a();
    Object localObject2 = new ArrayList();
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      i = 0;
      while (i < ((List)localObject3).size())
      {
        localObject4 = (CustomEmotionData)((List)localObject3).get(i);
        if ((localObject4 != null) && (!TextUtils.isEmpty(((CustomEmotionData)localObject4).emoPath)) && (((CustomEmotionData)localObject4).emoPath.equals(this.m))) {
          ((List)localObject2).add(localObject4);
        }
        i += 1;
      }
    }
    localObject3 = new ArrayList();
    Object localObject4 = new ArrayList();
    int i = 0;
    if (i < ((List)localObject2).size())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)((List)localObject2).get(i);
      if ("isUpdate".equals(localCustomEmotionData.RomaingType))
      {
        localCustomEmotionData.RomaingType = "needDel";
        ((FavroamingDBManager)localObject1).b(localCustomEmotionData);
        ((List)localObject3).add(localCustomEmotionData.resid);
      }
      for (;;)
      {
        i += 1;
        break;
        ((FavroamingDBManager)localObject1).a(localCustomEmotionData);
        if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {
          ((List)localObject4).add(localCustomEmotionData.md5);
        }
      }
    }
    localObject1 = (FavEmoRoamingHandler)paramQQAppInterface.a(72);
    if ((localObject1 != null) && (!((List)localObject3).isEmpty()) && (((List)localObject3).get(0) != null) && (!"".equals(((List)localObject3).get(0)))) {
      ((FavEmoRoamingHandler)localObject1).a((List)localObject3, false);
    }
    if (((List)localObject4).size() > 0) {
      ThreadManager.a(new rkw(this, (VipComicMqqManager)paramQQAppInterface.getManager(140), (List)localObject4), 5, null, false);
    }
    localObject1 = paramQQAppInterface.a().createEntityManager();
    localObject2 = ((EntityManager)localObject1).a(RecentEmotionData.class, false, " emoPath = ?", new String[] { this.m }, null, null, null, null);
    if (localObject2 != null)
    {
      i = j;
      while (i < ((List)localObject2).size())
      {
        ((EntityManager)localObject1).b((RecentEmotionData)((List)localObject2).get(i));
        i += 1;
      }
    }
    ((EntityManager)localObject1).a();
    paramQQAppInterface = paramQQAppInterface.a(ChatActivity.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.obtainMessage(10).sendToTarget();
    }
    return true;
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    try
    {
      URL localURL = new URL("protocol_vas_extension_image", "FAVOROTE_PANEL", this.m);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mRequestWidth = ((int)(100.0F * paramFloat));
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(2130840120);
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      localURLDrawableOptions.mPlayGifImage = true;
      paramContext = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
      if (QLog.isColorLevel()) {
        QLog.d(k, 2, "d: width = " + paramContext.getIntrinsicWidth() + ";height = " + paramContext.getIntrinsicHeight() + ";options:width = " + localURLDrawableOptions.mRequestWidth + ";options:height = " + localURLDrawableOptions.mRequestHeight);
      }
      return paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\emoticonview\FavoriteEmoticonInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */